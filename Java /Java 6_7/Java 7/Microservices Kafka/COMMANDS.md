
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



