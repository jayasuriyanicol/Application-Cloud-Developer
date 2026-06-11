-- ESERCIZI DDL - LEZIONE NUMERO 6


-- 1. ESERCIZIO 1 - EMP_TEST 

CREATE TABLE EMP_TEST (

    employee_id VARCHAR(5) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    salary DECIMAL(8,2) NOT NULL
);


-- 2. Esercizio 2 - DEPT-TEST 

CREATE TABLE DEPT_TEST ( 

    department_id VARCHAR(5) PRIMARY_KEY,
    department_name VARCHAR(50) NOT NULL
);


-- 3. Esercizio 3 - EMP_TEST2 

CREATE TABLE EMPT _TEST2 (

    employee_id VARCHAR(5) PRIMARY KEY,
    department_id VARCHAR(5) NOT NULL,
    FOREIGN KEY(department_id) REFERENCES DEPT_TEST(department_id)
);


-- 4. Crea una view che mostri nome, cognome e stipendio dalla tabella EMPLOYEES.

-- Utilizziamo la sintassi 'OR REPLACE' proprio per evitare possibili problematiche
CREATE OR REPLACE VIEW v_infoGenerali AS

    SELECT first_name AS NOME, last_name AS COGNOME, salary AS STIPENDIO
    FROM employees;


SELECT * FROM v_infoGenerali;


-- 5. Crea un indice sulla colonna LAST_NAME della tabella  EMPLOYEES per velocizzare le ricerche.

CREATE INDEX idx_ricercaCognome ON employees(last_name);



-- 6. Sequence Crea una sequence chiamata SEQ_TEST che parte da 1 e incrementa di 1 ad ogni chiamata.

CREATE SEQUENCE SEQ_TEST 

START WITH 1 
INCREMENT BY 1
NOCYCLE;




-- 7. Usa la Sequence Utilizza la sequence appena creata per generare un valore e inserirlo in una tabella.ù

INSERT INTO EMP_TEST (employee_id, first_name, salary)
VALUES (SEQ_TEST.NEXTVAL, 'Lanto Impaziente', 0000.00);


SELECT * FROM EMP_TEST;


-- 8. Aggiungi una nuova colonna BONUS alla tabella  EMPLOYEES per memorizzare il valore del bonus di ogni 
--    dipendente.Verifica la struttura aggiornata della tabella.

ALTER TABLE employees ADD BONUS DECIMAL(8,2);
SELECT * FROM employees;


-- 9. Modifica la colonna SALARY della tabella EMPLOYEES aumentando
--    la precisione numerica per supportare stipendi più elevati.

ALTER TABLE employees MODIFY salary DECIMAL(10,2);
SELECT * FROM employees;



-- 10. Cancella tutti i dati dalla tabella EMP_TEST senza eliminare 
--     la struttura della tabella stessa

TRUNCATE TABLE EMP_TEST;
SELECT * FROM EMP_TEST; 


-- 11.  DROP TABLE, Elimina completamente la tabella EMP_TEST,  inclusi struttura, dati, indici e vincoli
DROP TABLE EMP_TEST;

-- Questo restituirà 'not found data'
SELECT * FROM EMP_TEST;
