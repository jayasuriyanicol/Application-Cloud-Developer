--Scrivi raise_all_salaries(p_dept IN NUMBER, p_pct IN NUMBER) che aumenta del p% lo stipendio di tutti i dipendenti di un dipartimento. 
-- Gestisci l'eccezione se il dipartimento non esiste

CREATE OR REPLACE PROCEDURE all_salaries(

    p_dept IN NUMBER,
    p_pct IN NUMBER

) IS 
    v_esiste NUMBER;

BEGIN 

    SELECT COUNT(*) 
    INTO v_esiste 
    FROM departments
    WHERE department_id = p_dept;

    IF v_esiste = 0 THEN RAISE NO_DATA_FOUND;
    END IF;

   
    UPDATE employees
    SET salary = salary + (salary * (p_pct/100)) 
    WHERE department_id = p_dept;

EXCEPTION 
 
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('ATTENZIONE ! Non sono stati trovati dati !');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ATTENZIONE ! ERRORE GESTITO DA ORACLE: ' || SQLERRM);
    
END all_salaries;



-- 2. Scrivi get_annual_salary(p_emp_id IN NUMBER) RETURN NUMBER che restituisce lo stipendio annuale (salary × 12 + commission). Usala in una SELECT su EMPLOYEES


CREATE OR REPLACE FUNCTION get_annual_salary(

    p_emp_id IN NUMBER


) RETURN NUMBER IS 
    v_commission NUMBER;
    v_stipendioAnnuale NUMBER;

  BEGIN 
    
    SELECT salary, NVL(commission_pct,0)
    INTO v_stipendioAnnuale, v_commission
    FROM employees
    WHERE employee_id = p_emp_id;

    v_stipendioAnnuale  := (v_stipendioAnnuale * 12 + v_commission);

    RETURN v_stipendioAnnuale;
END get_annual_salary;
 


SELECT employee_id, get_annual_salary(employee_id) AS "STIPENDIO ANNUALE" FROM employees WHERE employee_id = 89;



-- 3. Crea pkg_hr con SPEC e BODY. Inserisci: una function per il bonus, una procedure per l'aggiornamento 
-- stipendio, e una variabile privata che conta le operazioni eseguite

CREATE OR REPLACE PACKAGE pkg_hr AS

    FUNCTION get_bonus(p_emp_id NUMBER )
    RETURN NUMBER;

    PROCEDURE p_updateSalary(

        p_id NUMBER,
        p_nuovoSalario NUMBER
        
    );

    END pkg_hr;
    


    CREATE OR REPLACE PACKAGE BODY pkg_hr AS 

        v_cont NUMBER := 0;

        FUNCTION get_bonus(p_emp_id NUMBER)

        RETURN NUMBER IS
         v_bonusSal NUMBER;

        BEGIN 

            SELECT NVL(commission_pct,0)
            INTO v_bonusSal
            FROM employees
            WHERE employee_id = p_emp_id;

            RETURN v_bonusSal; 
       END get_bonus;
       
       
        PROCEDURE p_updateSalary(

            p_id NUMBER,
            p_nuovoSalario NUMBER
            
        ) IS 
        
        BEGIN  

        UPDATE employees
        SET salary = p_nuovoSalario
        WHERE employee_id = p_id;

        v_cont := v_cont + 1;
        
        IF v_cont > 0 THEN
        DBMS_OUTPUT.PUT_LINE('SUCCESSO ! Righe aggiornate ' || v_cont);

        END IF;

        END p_updateSalary;

    END pkg_hr;
    


  -- 4. Crea un trigger BEFORE UPDATE OF salary ON employees che impedisce una riduzione dello stipendio 
  -- sollevando RAISE_APPLICATION_ERROR se :NEW.salary < :OLD.salary.


  CREATE OR REPLACE TRIGGER t_updateCheck 
    BEFORE UPDATE OF salary ON employees
    FOR EACH ROW
    BEGIN 
     
     IF :NEW.salary < :OLD.salary THEN

        -- Dove '-20001' indica il codice di errore da specificare 
        RAISE_APPLICATION_ERROR(-20001,'ATTENZIONE ! Non è possibile andare a modificare il salario abbassandolo !');

    END IF;

   END t_updateCheck;


