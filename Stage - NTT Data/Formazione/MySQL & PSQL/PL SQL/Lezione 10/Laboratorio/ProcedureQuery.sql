--  1. Crea una procedura che:prende un employee_id aumenta lo stipendio del 10% 

CREATE OR REPLACE PROCEDURE salaryIncr(

    p_id IN employees.employee_id%TYPE
) IS 

BEGIN  

    UPDATE employees 

        SET salary = salary * 1.10
        WHERE employee_id = p_id;
    COMMIT;
END salaryIncr;


-- Andiamo a richiamare la procedura
BEGIN 

    salaryIncr(101);
END;



-- 2.  Scrivi un blocco PL/SQL che: chiama la procedura creata sopra 

-- Andiamo a richiamare la procedura
BEGIN 

    salaryIncr(101);
END;



-- 3. Crea una function che: prende uno stipendio restituisce il bonus (10%) 

CREATE OR REPLACE FUNCTION ottieniBonus( 

     p_salary IN NUMBER

) RETURN NUMBER IS  

    v_bonus NUMBER;

BEGIN 

    v_bonus := p_salary * 0.10;
    RETURN v_bonus;
END ottieniBonus;


-- 4. Usa la function in una SELECT sulla tabella EMPLOYEES 

SELECT first_name, salary, ottieniBonus(salary) AS val_bonus
FROM employees
WHERE department_id = 50;



-- 5. Crea una procedura che: prende un numero in input restituisce il doppio usando un parametro OUT 

CREATE OR REPLACE PROCEDURE doppioNum(

    p_numero IN NUMBER,
    v_doppio OUT NUMBER
) IS 
    
BEGIN 
  v_doppio := p_numero * 2;

END doppioNum;


-- 6. Scrivi un blocco che: chiama la procedura 

DECLARE

v_n NUMBER;

BEGIN 
    doppioNum(5,v_n);
    DBMS_OUTPUT.PUT_LINE('Il doppio è: ' || v_n);
END;


--  7. Crea un package SPEC che: contiene una function get_bonus 

CREATE OR REPLACE PACKAGE pkg_pacchetto AS 

    c_bonus CONSTANT NUMBER := 0.10;

FUNCTION get_bonus(p_salary NUMBER)
    RETURN NUMBER;


PROCEDURE incrSal( 

    p_id IN NUMBER,
    p_fattore IN NUMBER DEFAULT 1.1
);
END pkg_pacchetto;


-- 8. Completa il package BODY con la logica della function 

CREATE OR REPLACE PACKAGE BODY pkg_pacchetto AS 

    v_cont NUMBER := 0;

    FUNCTION get_bonus(p_salary IN NUMBER) RETURN NUMBER IS 
    BEGIN 
        RETURN p_salary * c_bonus;
    END get_bonus;

    PROCEDURE incrSal(
        p_id IN NUMBER,
        p_fattore IN NUMBER DEFAULT 1.1
    ) IS 
    BEGIN
        UPDATE employees 
        SET salary = salary * p_fattore
        WHERE employee_id = p_id;
        
        v_cont := v_cont + 1;
    END incrSal;
END pkg_pacchetto;


-- 9. Crea un trigger che: prima di un INSERT su EMPLOYEES imposta salary a 1000 se è NULL 

CREATE OR REPLACE TRIGGER trg_aggiuntaEmpl
    BEFORE INSERT ON employees 
    FOR EACH ROW
    BEGIN 

    :NEW.salary := NVL(:NEW.salary, 1000);

    IF :NEW.hire_date IS NULL THEN 
       :NEW.hire_date  := TRUNC(SYSDATE);
    END IF;
END trg_aggiuntaEmpl;


-- Per testare il funzionamento del TRIGGER possiamo fare

INSERT INTO employees (employee_id, first_name, last_name, job_id, department_id)
VALUES (546, 'Simone', 'Dragoncelli', 'IT_PROG', 50);


SELECT * FROM employees WHERE last_name LIKE '%Dragoncelli%';



-- 10. Scrivi una procedura che: usa la function get_bonus aggiorna lo stipendio con il bonus 


CREATE OR REPLACE PROCEDURE applicaBonusDipendente(
    p_id IN employees.employee_id%TYPE
) IS
    v_stipendioAtt employees.salary%TYPE;
    v_bonus   NUMBER;
BEGIN
    SELECT salary 
    INTO v_stipendioAtt
    FROM employees
    WHERE employee_id = p_id;

    v_bonus := pkg_pacchetto.get_bonus(v_stipendioAtt);

    UPDATE employees
    SET salary = salary + v_bonus
    WHERE employee_id = p_id;

    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('SUCCESSO! Dipendente ' || p_id || ' aggiornato con un bonus di: ' || v_bonus);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ATTENZIONE ! ERRORE: Nessun dipendente trovato con ID ' || p_id);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ATTENZIONE ! ERRORE GENERICO, GESTITO DA ORACLE: ' || SQLERRM);

END applicaBonusDipendente;



-- 11. Scrivi un blocco che: chiama la procedura poi verifica con SELECT il risultato 

BEGIN
    applicaBonusDipendente(104);
END;


SELECT * FROM employees WHERE employee_id = 104;