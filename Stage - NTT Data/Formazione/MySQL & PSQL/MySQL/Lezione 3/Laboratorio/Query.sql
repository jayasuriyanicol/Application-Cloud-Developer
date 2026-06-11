-- ESERCIZI TERZA Lezione SQL


-- 1. Unisci employees e departments: mostra nome, cognome e nome del reparto

SELECT first_name AS "NOME", last_name AS "COGNOME", job_id AS "NOME REPARTO"
FROM employees e, departments d
WHERE e.department_id = d.department_id


-- 2. Aggiungi la tabella jobs: mostra nome, reparto e job_title per ogni dipendente

SELECT e.first_name AS "NOME", e.job_id AS "NOME REPARTO", j.job_title AS "RUOLO DIPENDENTE"
FROM employees e, jobs j 
WHERE e.job_id = j.job_id;


-- 3. Seleziona i dipendenti con salario superiore alla media aziendale

SELECT first_name AS "NOME", last_name AS "COGNOME", job_id AS "NOME REPARTO", salary AS "SALARIO MENSILE"
FROM employees 
WHERE salary > (SELECT AVG(salary) FROM employees)



-- 4. Seleziona i dipendenti con salario superiore alla media aziendale

SELECT first_name AS "NOME", last_name AS "COGNOME", job_id AS "NOME REPARTO"
FROM employees e, departments d
WHERE e.department_id = d.department_id AND d.location IN ('Roma', 'London');





