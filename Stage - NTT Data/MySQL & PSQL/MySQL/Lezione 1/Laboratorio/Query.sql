-- QUERY della prima lezione su MySQL
 
-- 1. Seleziona first_name, last_name e email da tutti i dipendenti.

SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL
FROM employees;


-- 2. Visualizza tutti i campi della tabella departments.

SELECT * 
FROM departments;



--3. Trova i dati del salario annuo  dei dipendenti (calcola salario * 12) e mostra nome, cognome, email e salario annuo. Ordina i risultati per salario annuo in ordine decrescente.

-- Procediamo con il calcolo del salario annuo utilizzando la formula salario (mensile) * 12 mensilità
SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL,
       salary * 12 AS "SALARIO ANNUO"

FROM employees

ORDER BY "SALARIO ANNUO" DESC;



-- 4. Trova tutti i dipendenti con department_id = 50 e stipendio maggiore di 3.500.

SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL 

FROM employees

WHERE department_id = 50 AND salary > 3500;



-- 5. Lista dei dipendenti assunti tra il 2000 e il 2005 (usa hire_date e BETWEEN).


SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL 

FROM employees

-- Utilizziamo la data inglese dato che MySQL riconosce il formato 'YYYY-MM-DD' per le date.
WHERE hire_date BETWEEN '01-01-2000' AND '12-31-2005';



-- 6. Trova tutti i dipendenti il cui cognome contiene la lettera 'a' e appartengono ai reparti 20, 30 o 40.

SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL 

FROM employees

--  Utilizzaimo la clausola IN per concatenare più AND di fila.
WHERE last_name LIKE '%a%' AND department_id IN (20, 30, 40);

 

-- 7. Elenca i dipendenti del reparto 80 ordinati per stipendio decrescente. Mostra nome, cognome e stipendio.

SELECT first_name AS nome ,last_name AS COGNOME, salary AS STIPENDIO
FROM employees
WHERE department_id = 80
ORDER BY salary DESC;


-- 8. Mostra tutti i dipendenti  ordinati  prima per  department_id crescente,  poi per  last_name alfabetico.

SELECT first_name AS nome ,last_name AS COGNOME, email AS EMAIL, department_id AS REPARTO
FROM employees
ORDER BY department_id ASC, last_name ASC;


-- 9.Trova i 5 dipendenti con lo stipendio più alto usando WHERE e ORDER BY. (Sfida: come limiteresti i risultati a 5 righe in Oracle?)

SELECT first_name AS nome ,last_name AS COGNOME, salary AS STIPENDIO
FROM employees
-- ROWNUM è una pseudocolonna in Oracle che restituisce un numero sequenziale per ogni riga restituita da una query.
WHERE ROWNUM < 5
ORDER BY salary DESC;
