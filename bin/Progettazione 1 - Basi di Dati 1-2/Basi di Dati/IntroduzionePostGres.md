# Utilizzo di PostGres in ambiente Docker

Per poter utilizzare **PostGres** nell'ambiente di **Docker**, dobbiamo seguire dei semplici step.

## A. Avviamento di PostGres su Docker

Per avviare l'ambiente **PostGres su Docker**, dobbiamo aprire il terminale ed eseguire il seguente comando:




docker exec -it its_postgresql bash


Questo comando permette di **entrare nell'ambiente Docker** in modalità `-it` (interattiva) utilizzando la shell `bash` all'interno del container chiamato `its_postgresql`.

## B. Avviamento effettivo dell’ambiente PostGres

Una volta entrati nel container (esempio: `814b559bf92c:/#`), possiamo accedere a PostGres digitando:

psql -U postgres



## C. Utilizzo di PostGres con linguaggio SQL

A questo punto, ci troviamo **nell'ambiente PostGres** e possiamo connetterci a un database esistente oppure crearne uno nuovo.

Esempio di connessione a un database chiamato `esami`:




postgres=# \c esami
You are now connected to database "esami" as user "postgres".
esami=#


## Comandi Utili in PostGres

- `\c nomeDB`  
  Connessione a un determinato database.

- `\d nomeClasse`  
  Mostra una vista approfondita della tabella (classe) specificata.

- `\!`  
  Esce temporaneamente dalla modalità PostGres per tornare al terminale di sistema (utile per eseguire comandi come `clear`).
