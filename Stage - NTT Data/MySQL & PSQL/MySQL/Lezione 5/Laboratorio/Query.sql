-- ESERCIZI QUERY SQL - LEZIONE 5


-- 1.  Classifica i dipendenti in tre fasce salariali (LOW,MEDIUM,HIGH) e ordina per fascia

SELECT first_name AS NOME, salary AS SALARIO,

CASE 
 WHEN salary < 3000 THEN  'LOW'
 WHEN salary < 6000 THEN  'MEDIUM'
 WHEN salary > 6000 THEN  'HIGH'

 -- Qui potevamo inserire direttamente ELSE 'HIGH' ma meglio inserire un messaggio di errore.
 ELSE 'ATTENZIONE ! Fascia non riconosciuta'
END AS fasciaPrezzo

FROM employees
ORDER BY fasciaPrezzo;


-- 2. Calcola il reddito totale (stipendio + commissione) gestendo i NULL.

SELECT first_name AS NOME, salary + NVL(salary * commission_pct, 0) AS "REDDITO TOTALE"
FROM employees;


-- 3. Costruisci un codice utente con pri,e 3 lettere del nome in maiuscolo

SELECT first_name AS NOME, UPPER(SUBSTR(first_name,1,3)) AS "PRIME 3 LETTERE MAIUSCOLO"
FROM employees;


-- 4. Unisci CASE, NVL e funzioni stringa in una query di report completa

SELECT first_name AS NOME, UPPER(SUBSTR(first_name,0,1))|| '' || SUBSTR(first_name,2,LENGTH(first_name)) AS "INIZIALE NOME", 
       NVL(TO_CHAR(commission_pct),'N/A') AS "COMMISSIONE SPETTATA SU STIPENDIO", 

       CASE 
            WHEN salary < 3000 THEN 'JUNIOR'
            WHEN salary BETWEEN 3000 AND 6000 THEN 'ADVANCED'
            WHEN salary BETWEEN 6000 AND 9000 THEN 'SENIOR'
            WHEN salary > 9000 THEN 'EXECUTIVE SENIOR'

            ELSE 'ATTENZIONE ! Ruolo non riconosciuto !'
        END AS "RUOLO SALARIALE"
        
FROM employees;