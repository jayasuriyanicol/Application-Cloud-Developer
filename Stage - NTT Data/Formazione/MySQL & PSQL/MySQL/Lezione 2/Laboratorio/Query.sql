-- -- QUERY della seconda lezione su MySQL
/* 1.Media stipendi
  Calcola la media degli stipendi di tutti i dipendenti. Poi calcola la media per ogni job_id.*/

SELECT AVG(salary) AS "MEDIA TUTTI STIPENDI" FROM employees;

-- Poi calcola la media per ogni job_id.
SELECT job_id, AVG(salary) AS salario
FROM employees
GROUP BY job_id;

/*2.Conteggio per reparto
Conta il numero di dipendenti in ciascun reparto. Ordina per numero decrescente.*/

SELECT COUNT(employee_id) AS "NUMERO DIPENDENTI", department_id AS "NOME REPARTO"
FROM employees
GROUP BY department_id 
ORDER BY COUNT(employee_id) DESC;


/*3 Stipendio massimo
Trova lo stipendio massimo e minimo per ogni department_id usando MIN e MAX.*/

SELECT department_id AS "NOME DIPARTIMENTO", MAX(salary) AS "STIPENDIO MASSIMO", MIN(salary) AS "STIPENDIO MINIMO"
FROM employees
GROUP BY department_id;


/*4 Filtrare c on HAVING
Mostra solo i reparti con più di 5 dipendenti e media stipendi superiore a 5.000.*/

Select department_id AS "NOME DIPARTIMENTO", COUNT(employee_id) AS "NUMERO DIPENDENTI TOTALI", AVG(salary) AS "MEDIA STIPENDI"
FROM employees
GROUP BY department_id
HAVING COUNT(employee_id) > 5 AND AVG(salary) > 5000;
