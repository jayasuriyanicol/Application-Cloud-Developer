-- 1. Mostra per ogni dipendente: Nome, Cognome, Nome reparto

SELECT e.first_name, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;


-- 2. Mostra per ogni dipendente: Nome, Cognome, Job ID. Solo per i dipendenti del reparto 50.

SELECT e.first_name, e.last_name, e.job_id
FROM employees e
WHERE e.department_id = 50;

-- 3. Mostra per ogni dipendente: Nome, Cognome, Nome reparto. Solo per i dipendenti che lavorano in reparti con sede a Roma.

SELECT e.first_name, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND d.location_id = 'Roma';


-- 4. Mostra per ogni dipendente: Nome, Cognome, Nome reparto, Job title. Usa tutte e 3 le tabelle.

SELECT e.first_name, e.last_name, d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
  AND e.job_id = j.job_id;

-- 5. Mostra per ogni dipendente: Nome, Cognome, Stipendio, Nome reparto. Solo per dipendenti con stipendio maggiore di 4000.

SELECT e.first_name, e.last_name, e.salary, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.salary > 4000;

-- 6. Mostra per ogni dipendente: Nome, Cognome, Job title, Location. Solo per i dipendenti del reparto IT.

SELECT e.first_name, e.last_name, j.job_title, d.location_id
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
  AND e.job_id = j.job_id
  AND d.department_name = 'IT';



-- 7. Mostra per ogni dipendente: Nome, Cognome, Stipendio, Nome reparto. Per i dipendenti con stipendio tra 3000 e 6000. Ordina per stipendio decrescente.

SELECT e.first_name, e.last_name, e.salary, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.salary BETWEEN 3000 AND 6000
ORDER BY e.salary DESC;

-- 8. Mostra per ogni dipendente: Nome, Cognome, Nome reparto. Solo per i reparti situati a Milano o Roma.

SELECT e.first_name, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND d.location_id IN ('Milano', 'Roma');

-- 9. Esegui la seguente query: SELECT * FROM employees, departments; Poi rispondi alle domande: Quante righe vengono restituite? Perché succede?

SELECT * FROM employees, departments;

/*
Risposta teorica:
 Viene restituito un numero di righe pari al prodotto delle righe di 'employees' per le righe di 'departments'.
 Manca del tutto una clausola WHERE con la condizione di join. 
 Il database esegue quindi un Prodotto Cartesiano (Cross Join), combinando ogni singola riga della prima tabella con ogni singola riga della seconda.
*/




-- 10. Trova i dipendenti con stipendio superiore alla media aziendale. Usa una subquery nella clausola WHERE.

SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 11. Trova i dipendenti che lavorano in reparti situati a Roma. Utilizza una subquery (non una join diretta).

SELECT *
FROM employees
WHERE department_id IN (SELECT department_id FROM departments WHERE location_id = 'Roma');

-- 12. Trova i dipendenti che hanno lo stesso job_id di altri dipendenti. Pensa a come confrontare righe della stessa tabella.

SELECT *
FROM employees e1
WHERE e1.job_id IN (
    SELECT e2.job_id 
    FROM employees e2 
    WHERE e1.employee_id <> e2.employee_id
);




-- 13. Mostra per ogni reparto: Nome reparto, Stipendio medio. Solo per i reparti con stipendio medio maggiore di 4000.

SELECT d.department_name, AVG(e.salary) AS stipendio_medio
FROM employees e, departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_name
HAVING AVG(e.salary) > 4000;

-- 14. Trova il dipendente con lo stipendio più alto. Non usare FETCH FIRST. Trova un altro modo!

SELECT *
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);



-- 15. Mostra per ogni dipendente: Nome, Cognome, Stipendio. Solo per i dipendenti che guadagnano più della media del proprio reparto.

SELECT e1.first_name, e1.last_name, e1.salary
FROM employees e1
WHERE e1.salary > (
    SELECT AVG(e2.salary) 
    FROM employees e2 
    WHERE e2.department_id = e1.department_id
);

-- 16. Mostra per ogni reparto: Nome reparto, Numero di dipendenti. Solo per i reparti che hanno più di 2 dipendenti.

SELECT d.department_name, COUNT(e.employee_id) AS numero_dipendenti
FROM employees e, departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_name
HAVING COUNT(e.employee_id) > 2;


-- 17. Mostra per ogni dipendente: Nome, Cognome, Job title. Solo per i dipendenti che hanno uno stipendio maggiore del minimo previsto per il loro job.

SELECT e.first_name, e.last_name, j.job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
  AND e.salary > j.min_salary;




-- 18. Trova i reparti che non hanno dipendenti.

SELECT *
FROM departments
WHERE department_id NOT IN (
    SELECT department_id 
    FROM employees 
    WHERE department_id IS NOT NULL
);

-- 19. Trova i dipendenti che lavorano in reparti dove lo stipendio medio è maggiore della media aziendale.

SELECT *
FROM employees
WHERE department_id IN (
    SELECT department_id 
    FROM employees 
    GROUP BY department_id 
    HAVING AVG(salary) > (SELECT AVG(salary) FROM employees)
);

-- 20. Mostra nome e cognome dei dipendenti che lavorano nello stesso reparto di un dipendente chiamato 'Mario'.

SELECT first_name, last_name
FROM employees
WHERE department_id IN (
    SELECT department_id 
    FROM employees 
    WHERE first_name = 'Mario'
);

-- 21. Trova nome reparto e dipendente con stipendio massimo per ogni reparto.

SELECT d.department_name, e1.first_name, e1.last_name, e1.salary
FROM employees e1, departments d
WHERE e1.department_id = d.department_id
  AND e1.salary = (
      SELECT MAX(e2.salary) 
      FROM employees e2 
      WHERE e2.department_id = e1.department_id
  );

-- 22. Trova i dipendenti che non hanno commissione (commission_pct) e guadagnano più della media aziendale.

SELECT *
FROM employees
WHERE commission_pct IS NULL
  AND salary > (SELECT AVG(salary) FROM employees);

-- 23. Trova i dipendenti che hanno lo stipendio uguale a quello di almeno un altro dipendente (duplicati).

SELECT *
FROM employees e1
WHERE e1.salary IN (
    SELECT e2.salary 
    FROM employees e2 
    WHERE e1.employee_id <> e2.employee_id
);
