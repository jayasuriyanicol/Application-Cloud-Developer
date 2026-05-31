-- Esercizi extra sulla seconda lezione

/*
ESERCIZI AVANZATI – SQL (LEZIONE 2)

Argomenti:

- Funzioni stringa
- Funzioni numeriche
- Funzioni date
- TO_CHAR / TO_DATE / TO_NUMBER
- COUNT / SUM / AVG / MIN / MAX
- GROUP BY
- HAVING

Utilizza:

- EMPLOYEES

---
*/

/*
## 🟢 LIVELLO 1 – Funzioni stringa

Esercizio 1
Mostra:

- nome in maiuscolo
- cognome con iniziale maiuscola
- lunghezza del cognome

---

*/

SELECT UPPER(first_name), INITCAP(last_name), LENGTH(last_name)
FROM employees;



/*
Esercizio 2
Mostra:

- nome completo
- prime 3 lettere del cognome
- lunghezza del nome

---
*/


SELECT first_name || ' ' || last_name AS "NOME COMPLETO", SUBSTR(last_name,1,3) AS "COGNOME PRIME 3 LETTERE", LENGTH(last_name) AS NOME
FROM employees




/*
## 🟡 LIVELLO 2 – Funzioni numeriche

Esercizio 3
Mostra:

- salary
- salary arrotondato
- salary diviso per 12 troncato

solo per:

- salary > 4000

---

*/


SELECT salary AS SALARIO, ROUND(salary) AS "SALARIO ARROTONDATO", TRUNC(salary/12)
FROM employees
WHERE salary > 4000;



/*
Esercizio 4
Mostra:

- salary
- salary aumentato del 15%
- valore arrotondato

Ordina:

- salary desc

---
*/


SELECT salary AS SALARIO, ((salary * 0.15) + salary) AS "SALARIO AUMENTATO DEL 15%" , ROUND(salary) AS "SALARIO ARROTONDATO"
FROM employees

ORDER BY salary DESC;


/*
## 🔵 LIVELLO 3 – Funzioni date e conversioni

Esercizio 5
Mostra:

- nome completo
- hire_date
- hire_date formattata DD/MM/YYYY

---
*/


SELECT first_name || ' ' || last_name AS "NOME COMPLETO", hire_date AS "DATA ASSUNZIONE",  TO_CHAR(hire_date,'DD/MM/YYYY') AS "DATA ASSUNZIONE FORMATTATA"
FROM employees;


/*
Esercizio 6
Mostra:

- nome
- giorni lavorati fino ad oggi

Ordina:

- giorni lavorati desc

---

*/

SELECT first_name AS NOME, ROUND(SYSDATE - hire_date) AS "TOT GIORNI DA INIZIO ASSUNZIONE"
FROM employees
ORDER BY "TOT GIORNI DA INIZIO ASSUNZIONE" DESC;






/*
## 🔴 LIVELLO 4 – Aggregazioni

Esercizio 7
Mostra:

- numero totale dipendenti
- stipendio medio
- stipendio massimo
- stipendio minimo

---
*/

SELECT COUNT(employee_id) AS "NUMERO TOTALE DIPENDENTI", AVG(salary) AS "STIPENDIO MEDIO", MAX(salary) AS "STIPENDIO MASSIMO", MIN(salary) AS "STIPENDIO MINIMO"
FROM employees;


/*
Esercizio 8
Mostra:

- department_id
- numero dipendenti
- stipendio medio

Ordina:

- stipendio medio desc

---
*/


SELECT department_id AS "NUMERO DIPARTIMENTO", COUNT(employee_id) AS "NUMERO DIPENDENTI", AVG(salary) AS "STIPENDIO MEDIO"
FROM employees
GROUP BY "NUMERO DIPARTIMENTO"
ORDER BY "STIPENDIO MEDIO" DESC;






/*
## 🟣 LIVELLO 5 – GROUP BY e HAVING

Esercizio 9
Mostra:

- reparto
- numero dipendenti
- stipendio massimo

solo per:

- reparti con più di 2 dipendenti

---

*/

SELECT job_id AS "REPARTO", COUNT(employee_id) AS "NUMERO DIPENDENTI", MAX(salary) AS "STIPENDIO MASSIMO"
FROM employees
GROUP BY "REPARTO"
HAVING "NUMERO DIPENDENTI" > 2;


/*
Esercizio 10 ⭐
Mostra:

- reparto
- stipendio medio
- stipendio massimo
- stipendio minimo

solo per:

- reparti con stipendio medio > 5000

Ordina:

- media stipendi desc
*/


SELECT job_id AS "REPARTO",AVG(salary) AS "STIPENDIO MEDIO", MAX(salary) AS "STIPENDIO MASSIMO", MIN(salary) AS "STIPENDIO MINIMO"
FROM employees
GROUP BY "REPARTO"
HAVING "STIPENDIO MEDIO" > 5000
ORDER BY "STIPENDIO MEDIO" DESC;
