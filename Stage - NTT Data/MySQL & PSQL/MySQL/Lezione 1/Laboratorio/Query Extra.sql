-- Esercizi extra sulla prima lezione
/* Esercizio 1
Mostra:
- employee_id
- nome completo (nome + cognome)
- stipendio annuale

solo per:

- dipendenti del reparto 50

Ordina:

- stipendio decrescente
*/

SELECT employee_id, first_name || ' ' || last_name AS "NOME COMPLETO", salary * 12 AS "SALARIO ANNUALE"
FROM employees
WHERE department_id = 50
ORDER BY salary DESC;

/*
Esercizio 2
Mostra:

- nome
- cognome
- email
- salary aumentato del 20%

solo per:

- salary maggiore di 4000

Ordina:

- cognome alfabetico

*/


SELECT first_name AS NOME, last_name AS COGNOME, email AS EMAIL, salary * 0.20 AS "SALARIO AUMENTO 20%"
FROM employees
WHERE SALARY > 4000
ORDER BY  last_name;

/*
## 🟡 LIVELLO 2 – WHERE complessi

Esercizio 3
Mostra:

- nome completo
- salary
- department_id

solo per:

- salary tra 3000 e 7000
- department_id IN (20, 50, 80)

Ordina:

- reparto
- stipendio decrescente

*/


SELECT first_name || ' ' || last_name AS "NOME COMPLETO", salary AS SALARIO, department_id AS DIPARTIMENTO
FROM employees
WHERE salary BETWEEN 3000 AND 7000 AND department_id IN(20,50,80)
ORDER BY department_id, salary DESC;


/*
Esercizio 4
Mostra tutti i dipendenti:

- il cui cognome inizia con “S”
- oppure contiene “an”

e:

- salary > 3000

---
*/


SELECT * 
FROM employees
WHERE last_name LIKE 'S%' OR last_name LIKE '%an%' AND salary > 3000;

/*

Esercizio 5
Mostra:

- nome completo
- email

solo per:

- cognomi che terminano con “n”

Ordina:

- nome completo

---
*/

SELECT first_name || ' ' || last_name AS "NOME COMPLETO", email AS "EMAIL"
FROM employees
WHERE last_name LIKE '%n'
ORDER BY first_name || ' ' || last_name;

/*
Esercizio 6
Mostra:

- nome
- cognome
- salary annuale
- stipendio aumentato del 10%

solo per:

- dipendenti assunti tra il 2005 e il 2015

---

*/

SELECT first_name AS NOME, last_name AS COGNOME, salary * 0.10 AS "SALARIO AUMENTATO 10%"
FROM employees
WHERE hire_date BETWEEN '01-01-2005' AND '12-31-2015';


/*
## 🔴 LIVELLO 4 – Ordinamenti avanzati

Esercizio 7
Mostra:

- nome completo
- reparto
- salary

Ordina:

- prima per reparto crescente
- poi per stipendio decrescente
- poi per cognome alfabetico

---
*/

SELECT first_name || ' ' || last_name AS "NOME COMPLETO", job_id AS "NOME REPARTO", salary AS "SALARIO"
FROM employees
ORDER BY job_id, salary DESC , first_name || ' ' || last_name;


/*
Esercizio 8 ⭐
Mostra:

- i 10 dipendenti con stipendio più alto

Visualizza:

- nome completo
- salary
- stipendio annuale

Ordina:

- salary desc

---
*/


SELECT first_name || ' ' || last_name AS "NOME COMPLETO", salary AS "SALARIO MENSILE", salary * 12 AS "SALARIO ANNUALE"
FROM employees
ORDER BY salary DESC;



/*
## 🟣 LIVELLO 5 – Query complete

Esercizio 9 ⭐⭐
Crea un report con:

- employee_id
- nome completo
- job_id
- department_id
- salary
- stipendio annuale

solo per:

- salary > 5000
- reparti 20, 50 o 80
- cognome contenente la lettera “a”

Ordina:

- reparto
- stipendio desc

*/


SELECT employee_id, first_name || ' ' || last_name AS "NOME COMPLETO",job_id AS "NOME REPARTO", department_id AS "CODICE DIPARTIMENTO", salary AS "SALARIO MENSILE", salary * 12 AS "SALARIO ANNUALE"
FROM employees
WHERE salary > 5000 AND department_id IN(20,50 OR 80) AND last_name LIKE 'a'
ORDER BY job_id AND salary DESC;