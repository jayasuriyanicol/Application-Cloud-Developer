--  1. Inserisci un nuovo dipendente con i seguenti dati: id=201, nome=Luca, cognome=Test, salary=3000, department_id=50, job_id='IT_PROG', hire_date=oggi

INSERT INTO employees (employee_id, first_name, last_name, salary, department_id, job_id, hire_date)
VALUES (201, 'Mario', 'Mela', 2132, 50, 'IT_PROG', SYSDATE);


-- 2. Inserisci un nuovo reparto con i seguenti dati: id=100, nome=Training, location=Roma

INSERT INTO departments (department_id, department_name, location_id)
VALUES (100, 'MySquirell & CO', 'Roma'); 


--  3. Inserisci un nuovo job con i seguenti dati: id='JR_DEV', titolo=Junior Developer, min_salary=2000, max_salary=4000

INSERT INTO jobs (job_id, job_title, min_salary, max_salary)
VALUES ('JR_DEV', 'Junior Developer', 2000, 4000);


--  4. Aumento Stipendi Reparto 50 Aumenta del 10% lo stipendio di tutti i dipendenti appartenenti al reparto con department_id = 50.


UPDATE employees
SET salary = salary * 1.10
WHERE department_id = 50;

--  5. Cambio Reparto JR_DEV, Aggiorna il reparto di tutti i dipendenti con job_id = 'JR_DEV' portandoli nel reparto 100.

UPDATE employees
SET department_id = 100
WHERE job_id = 'JR_DEV';

--  6 . Salary Dipendente 101, Aggiorna il salary a 5000 per il dipendente con employee_id = 101.

UPDATE employees
SET salary = 5000
WHERE employee_id = 101;

--  7. Aumento per Anzianità, Aumenta di 500 lo stipendio di tutti i dipendenti assunti prima del 2010. Usa la funzione appropriata per filtrare per data.

UPDATE employees
SET salary = salary + 500
WHERE hire_date < TO_DATE('01-01-2010', 'DD-MM-YYYY');



-- 8 – Cancella Dipendenti Reparto 100, Cancella tutti i dipendenti appartenenti al reparto con department_id = 100.
DELETE FROM employees
WHERE department_id = 100;

-- 9 .Cancella per Stipendio Basso, Cancella tutti i dipendenti con uno stipendio inferiore a 2500. Verifica prima quanti record verranno eliminati.

SELECT COUNT(*) FROM employees WHERE salary < 2500;

DELETE FROM employees WHERE salary < 2500;

-- 10. Cancella Reparto, Cancella il reparto con id = 100. Attenzione ai vincoli di integrità referenziale: cosa succede se esistono dipendenti associati?

DELETE FROM departments
WHERE department_id = 100;

--Se esistono ancora dipendenti associati al reparto 100 (vincolo di Foreign Key), Oracle bloccherà l'operazione restituendo un errore di violazione di integrità referenziale
-- Per procedere è necessario prima cancellare o spostare i dipendenti.




-- 11. Rollback, Aumenta tutti gli stipendi di 1000, controlla il risultato con una SELECT, poi annulla la modifica con ROLLBACK.
UPDATE employees SET salary = salary + 1000;
SELECT employee_id, salary FROM employees;
ROLLBACK;

-- 12. Commit e Rollback, Inserisci un nuovo dipendente ed esegui COMMIT. Poi prova a fare ROLLBACK. Cosa succede?
INSERT INTO employees (employee_id, first_name, last_name, salary, department_id, job_id, hire_date)
VALUES (202, 'Mario', 'Rossi', 2800, 50, 'IT_PROG', SYSDATE);
COMMIT;
ROLLBACK;

 -- Dopo il COMMIT i dati sono salvati permanentemente nel database. Il ROLLBACK successivo non ha alcun effetto sui dati già confermati
 -- l'inserimento del dipendente rimane memorizzato.


-- 13. Savepoint, Aggiorna uno stipendio, crea un SAVEPOINT, fai un altro aggiornamento, poi torna al SAVEPOINT.
UPDATE employees SET salary = 6000 WHERE employee_id = 201;
SAVEPOINT sp_primo_aggiornamento;

UPDATE employees SET salary = 7000 WHERE employee_id = 201;

ROLLBACK TO sp_primo_aggiornamento;
-- Con il ROLLBACK lo stipendio del dipendente 201 è tornato a 6000, non avendo effettuato il commit abbiamo annullato il precedente.



-- 14. Aggiornamento Condizionale, Aggiorna lo stipendio di tutti i dipendenti applicando regole differenziate: +20% per i dipendenti con salary < 3000, +10% per tutti gli altri dipendenti.
UPDATE employees
SET salary = 
            CASE 
                WHEN salary < 3000 THEN salary * 1.20
                ELSE salary * 1.10
             END;

-- 15. Delete con Subquery, Cancella tutti i dipendenti il cui stipendio è inferiore alla media aziendale.
DELETE FROM employees
WHERE salary < (SELECT AVG(salary) FROM employees);
