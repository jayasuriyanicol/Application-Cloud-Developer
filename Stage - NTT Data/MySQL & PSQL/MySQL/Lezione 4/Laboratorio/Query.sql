-- ESERCIZI LEZIONE 4 SQL: DML


-- 1. Inserire 3 nuovi dipendenti nella tabella employees

INSERT INTO employees(employee_id, first_name, last_name, salary,email,hire_date,job_id)
VALUES(67, 'Giacomo', 'Coccodrillini', 7267.00, 'giacomococcodrillini67@gmail.com', '01-17-2005', 'AD_EXEC');

INSERT INTO employees(employee_id, first_name, last_name, salary,email,hire_date,job_id)
VALUES(68, 'Nicol', 'Jayasuriya', 3050.00, 'jayasuriyanicol28@gmail.com', '05-19-2005', 'IT_PROG');


INSERT INTO employees(employee_id, first_name, last_name, salary,email,hire_date,job_id)
VALUES(69, 'Dario', 'Montuoro', 3049.99, 'montuoro.dario@gmail.com', '05-20-2024', 'IT_PROG');


COMMIT;




-- 2. Aggiornare gli stipendi di un reparto specifico

UPDATE employees 
SET salary = salary * 0.50 
WHERE department_id = 50;

COMMIT;





-- 3. Cancellare record di test con WHERE preciso

DELETE FROM employees 
WHERE employee_id = 67;



COMMIT;


-- 5. Utilizzare COMMIT e ROLLBACK in una transazione 

UPDATE employees
SET salary = 3000.00
WHERE employee_id = 99

COMMIT;

 -- In evenienza utilizziamo : ROLLBACK;




 -- 6. Creare un SAVEPOINT e testare il recupero parziale

UPDATE employees
SET salary = 4231.00
WHERE employee_id = 121;

SAVEPOINT t1;

UPDATE employees 
SET salary = 3232.21
WHERE employee_id = 121;

SAVEPOINT t2;


COMMIT;