# Progetto Microservizi: CQRS & Outbox Pattern con Kafka

Questa repository contiene l'implementazione di un sistema di sincronizzazione dati tra due microservizi (**WR** - Write e **RD** - Read) utilizzando **Apache Kafka** e il design pattern **@Transactional Outbox**.

## Architettura

In questo specifico esercizio, ci siamo focalizzati esclusivamente sulla **logica di streaming e persistenza**, con un cambiamento peò sul ***DB WR** e creazione di un nuovo file config per lo ****STREAM**. 

> **Nota:** Per mantenere il repository leggero e focalizzato sull'obiettivo, i servizi di infrastruttura comuni come **Spring Cloud Gateway**, **Eureka Server** e **Spring Cloud Config Server** non sono inclusi nel codice sorgente di questo esercizio, in quanto già ampiamente trattati nei moduli precedenti.


### Componenti Principali

Rispetto gli altri esercizi ci sono stati dei cambi in questi file

1.  **Microservizio WR (Porta 8075)**: Gestisce le operazioni di scrittura su database PostgreSQL (`db_catalogo_wr_dev`) e popola una tabella di Outbox.

2.  **Scheduler (Poller)**: Monitora la tabella Outbox e invia i messaggi a Kafka.

3.  **Apache Kafka**: Broker di messaggistica che garantisce il passaggio dei dati.

4.  **Microservizio RD (Porta 8081)**: In ascolto sul topic Kafka, riceve il JSON e sincronizza il proprio database di lettura (`db_catalogo_rd_dev`).

---

## Configurazione Database  (SQL)

> *ATTENZIONE: Se presente già il DB `db_catalogo_wr_dev` creare solo la tabella **entity_outbox** non considerando nient'altro dato che è presente già tutto quanto come un copia incolla.

### 1. Database di Scrittura (WR)
```sql
-- Creazione Database
CREATE DATABASE db_catalogo_wr_dev;

-- Tabella Prodotti (Write Model)
CREATE TABLE prodotto (
    id_prodotto SERIAL PRIMARY KEY,
    prezzo_unitario DOUBLE PRECISION,
    quantità_prodotto INTEGER,
    categoria VARCHAR(255),
    versione INTEGER
);

-- Tabella Outbox (Transactional Outbox Pattern)
CREATE TABLE entity_outbox (
    id_evento UUID PRIMARY KEY,
    id_entita INTEGER,
    tipologia_evento VARCHAR(50),
    payload TEXT, -- Contiene il JSON del prodotto
    stato VARCHAR(20), -- PENDING, SEND, ERROR
    data_creazione TIMESTAMP,
    numero_tentativi INTEGER DEFAULT 0
);
```

> *ATTENZIONE: Stessa cosa del **WR** `db_catalogo_rd_dev`, non ricreare se già presente dato che si tratterebbe di un copia e incolla e creerebbe un conflitto.


### 2. Database di Lettura (RD)
```sql
-- Creazione Database
CREATE DATABASE db_catalogo_rd_dev;

-- Tabella Prodotti (Read Model)
-- NOTA: Qui non usiamo SERIAL/GENERATED perché l'ID viene dettato dal WR
CREATE TABLE prodotto (
    id_prodotto INTEGER PRIMARY KEY, 
    prezzo_unitario DOUBLE PRECISION,
    quantità_prodotto INTEGER,
    categoria VARCHAR(255)
);
```

---

## Configurazione Cloud (Config Server)

** Se utilizzi un **Config Server** esterno per gestire i profili, crea un file chiamato `MM-catalogo-WR-dev.properties` (o integra quello esistente) con il seguente contenuto per abilitare lo stream:

```properties
# PROFILE: DEV - KAFKA STREAMING CONFIGURATION
example.property=I AM THE DEV PROFILE - kafka

# Server Port
server.port=8083

# Datasource WR
spring.datasource.url=jdbc:postgresql://localhost:5432/db_catalogo_wr_dev
spring.datasource.username=postgres
spring.datasource.password=postgres

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Eureka Discovery (Puntando al server centralizzato)
eureka.client.serviceUrl.defaultZone=http://localhost:8070/eureka/
eureka.instance.hostname=localhost
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true

# Metrics
enable.metrics.push=false
```

---

## Avvio STEPS

1.  **Docker**: Avvia Kafka e Zookeeper tramite il file `docker-compose.yml`.
    ```bash
    docker compose up -d
    ```
2.  **Microservizi**: Avvia Config,Eureka, Gateway e prima di tutto `MM-catalogo-WR-Stream` e successivamente `MM-catalogo-RD`.

3.  **Test**: Invia una richiesta `POST` al WR. Verifica nei log di RD l'avvenuta ricezione e nel database RD la corretta persistenza del dato.

---
## Avvio docker con KAFKA COMANDI

---

## 1. Gestione Docker (Il Motore)

cartella file `docker-compose.yml` e usa questi comandi:

* **Per avviare tutto (Kafka, Zookeeper, Postgres):**

    ```bash
    docker compose up -d
    ```
* **Per spegnere tutto:**

    ```bash
    docker compose down
    ```
* **Per vedere se i container sono "vivi" e stabili:**

    ```bash
    docker ps
    ```
    *(Controlla che la colonna STATUS dica "Up" e non "Restarting").*

---

## 2. Vedere i risultati nei Topic Kafka

Per essere sicuro che i messaggi stiano davvero viaggiando dentro Kafka, usa questo comando nel terminale della VM:

* **Vedere i messaggi in tempo reale:**

    ```bash
    docker exec -it resources-kafka-1 kafka-console-consumer --bootstrap-server localhost:9092 --topic prodotto-stream-catalog --from-beginning
    ```
    *(Lascia questo terminale aperto: ogni volta che lo scheduler del WR invia qualcosa, vedrai apparire il JSON qui sotto).*

---

## 3. Verificare i Database (PostgreSQL)

Se vuoi controllare lo stato dei messaggi o se il RD ha salvato i dati, usa `psql` o PGAdmin:

* **Nel DB del WR (db_catalogo_wr_dev):**

    ```sql
    -- Controlla se i messaggi sono passati a SEND
    SELECT id_evento, stato, numero_tentativi, payload FROM entity_outbox ORDER BY data_creazione DESC;
    ```

* **Nel DB del RD (db_catalogo_rd_dev):**

    ```sql
    -- Controlla se il prodotto è stato sincronizzato
    SELECT * FROM prodotto; 
    ```

---

## 4. Troubleshooting (Cosa fare se non succede nulla)

Se invii una POST ma il RD non riceve nulla, segui questa scaletta:

1.  **Controlla il WR**: Lo scheduler sta girando? (Vedi i log `>>> SCHEDULER IN ESECUZIONE`).

2.  **Controlla Kafka**: Il comando al punto 2 mostra il messaggio? Se sì, il WR ha finito il suo lavoro.

3.  **Controlla il RD**: È ancora acceso? Se vedi errori di Eureka (Connection Refused), ignorali pure finché il servizio resta `UP` su porta 8081.



