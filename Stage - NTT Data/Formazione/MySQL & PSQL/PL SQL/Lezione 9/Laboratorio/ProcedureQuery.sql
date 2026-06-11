-- 1. Scrivi un blocco PL/SQL che:  aggiorna lo stipendio dei dipendenti del reparto 50 (+10%) stampa il numero di righe aggiornate usando SQL%ROWCOUNT 


BEGIN 
   
    UPDATE employees 
    SET salary = salary * 1.10
    WHERE department_id = 50;

    
    DBMS_OUTPUT.PUT_LINE('SUCCESSO! Sono state aggiornate ' || SQL%ROWCOUNT || ' righe.');

    
    IF SQL%FOUND THEN  
        DBMS_OUTPUT.PUT_LINE('SUCCESSO! È stato interessato almeno un dipendente.');
    ELSE  
        DBMS_OUTPUT.PUT_LINE('ATTENZIONE! Nessun dipendente è stato modificato né trovato.');
    END IF;
END;





--2. Scrivi un blocco che: esegue una DELETE su una condizione a tua scelta stampa se sono state trovate righe usando SQL%FOUND 

BEGIN   

    DELETE employees
    WHERE employee_id = 101;

     
    
   IF SQL%FOUND THEN DBMS_OUTPUT.PUT_LINE('SUCCESSO! È stato interessato almeno un dipendente.'); 
   ELSE  
        DBMS_OUTPUT.PUT_LINE('ATTENZIONE! Nessun dipendente è stato modificato né trovato.');
    END IF;

END;


-- 3. Scrivi un blocco PL/SQL che: usa un cursor FOR LOOP legge tutti i dipendenti stampa nome e stipendio 

DECLARE 

CURSOR c_cursore IS

    SELECT first_name, last_name , salary
    FROM employees 
    WHERE department_id = 50;

BEGIN 

        FOR i IN c_cursore LOOP
           DBMS_OUTPUT.PUT_LINE(i.first_name || ' - '  || i.last_name || ' - ' || i.salary );
        END LOOP;
END;



-- 4. Scrivi un blocco che: usa un cursor FOR LOOP legge i dipendenti del reparto 50 stampa solo il nome 


DECLARE

    CURSOR c_cursore IS 

        SELECT first_name
        FROM employees
        WHERE department_id = 50;    
    
BEGIN
     
     FOR i IN c_cursore LOOP 

        DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name);
     END LOOP;
END;

 

-- 5. Scrivi un blocco che: legge tutti i dipendenti per ogni dipendente calcola il bonus (10%) stampa nome e bonus 


DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, (salary * 0.10) AS val_bonus
        FROM employees;
         
    
BEGIN
     
     FOR i IN c_cursore LOOP 

        DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - BONUS: ' || i.val_bonus);
     END LOOP;
END;



-- 6. Scrivi un blocco che: legge i dipendenti stampa: HIGH se salary > 6000 LOW altrimenti 



DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, salary
        FROM employees;
         
    
BEGIN
     
     FOR i IN c_cursore LOOP 
           
         CASE  

            WHEN i.salary > 6000 THEN   DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: HIGH');
            ELSE DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: LOW');
         END CASE;
     END LOOP;
END;


-- 7. Scrivi un blocco che: dichiara un cursore sui dipendenti usa OPEN, FETCH, CLOSE legge una sola riga 
  
    
DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, last_name, salary
        FROM employees;

        v_name   employees.first_name%TYPE;
        v_cognome   employees.last_name%TYPE;
        v_salary employees.salary%TYPE;

         
    
BEGIN

    OPEN c_cursore;

        FETCH c_cursore 
        INTO v_name, v_cognome, v_salary;
     
    
      
     CLOSE c_cursore;
END;
  

--  8.  Esercizio 8 Scrivi un blocco che: usa un cursore esplicito legge tutte le righe con LOOP stampa nome e stipendio 


DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, salary
        FROM employees;

        v_name   employees.first_name%TYPE;
        v_salary employees.salary%TYPE;

         
    
BEGIN

    OPEN c_cursore;
    
    LOOP
        FETCH c_cursore INTO v_name, v_salary;
        EXIT WHEN c_cursore%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('NOME: ' || v_name || ' - SALARY: ' || v_salary);
    END LOOP;
    
    CLOSE c_cursore;
END;


-- 9. Scrivi due versioni dello stesso programma: una con cursore esplicito una con cursor FOR LOOP 


-- VERSIONE CURSORE ESPLICITO


DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, salary
        FROM employees;

        v_name   employees.first_name%TYPE;
        v_salary employees.salary%TYPE;
         
    
BEGIN
     
    OPEN c_cursor; 

        FETCH c_cursor INTO v_name, v_salary 
    
           
         CASE  

            WHEN  v_salary > 6000 THEN   DBMS_OUTPUT.PUT_LINE('NOME: ' || v_name || ' - SALARY: ' || v_salary || ' - LIVELLO: HIGH');
            ELSE DBMS_OUTPUT.PUT_LINE('NOME: ' || v_name || ' - SALARY: ' || v_salary || ' - LIVELLO: LOW');
         END CASE;
    CLOSE c_cursore;
END;
        
     
    
-- VERSIONE FOR LOOP

DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, salary
        FROM employees;
         
    
BEGIN
     
     FOR i IN c_cursore LOOP 
           
         CASE  

            WHEN i.salary > 6000 THEN   DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: HIGH');
            ELSE DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: LOW');
         END CASE;
     END LOOP;
END;
        
    
 -- 10.  Scrivi un blocco che: stampa “Inizio elaborazione” scorre i dipendenti stampa ogni nome stampa “Fine elaborazione” 



DECLARE
    CURSOR c_cursore IS 
        SELECT first_name
        FROM employees;

    v_name employees.first_name%TYPE;
BEGIN
    OPEN c_cursore; 

    DBMS_OUTPUT.PUT_LINE('INIZIO ELABORAZIONE');

    FETCH c_cursore INTO v_name; 

    DBMS_OUTPUT.PUT_LINE('NOME: ' || v_name);
         
    CLOSE c_cursore;

    DBMS_OUTPUT.PUT_LINE('FINE ELABORAZIONE');
END;



-- 11. Scrivi un blocco che: legge i dipendenti se lo stipendio > 5000 → stampa “ALTO” altrimenti “NORMALE” 


DECLARE

    CURSOR c_cursore IS 

        SELECT first_name, salary
        FROM employees;
         
    
BEGIN
     
     FOR i IN c_cursore LOOP 
           
         CASE  

            WHEN i.salary > 5000 THEN   DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: alto');
            ELSE DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - LIVELLO: NORMALE');
         END CASE;
     END LOOP;
END;




-- 12. Scrivi un blocco che: legge i dipendenti del reparto 50 calcola bonus stampa tutto in formato: Nome - Salary - Bonus 


DECLARE
    CURSOR c_cursore IS 
        SELECT first_name, salary, (salary * 0.10) AS val_bonus
        FROM employees
        WHERE department_id = 50;
BEGIN
     FOR i IN c_cursore LOOP 
         DBMS_OUTPUT.PUT_LINE('NOME: ' || i.first_name || ' - SALARY: ' || i.salary || ' - BONUS: ' || i.val_bonus);
     END LOOP;       
END;
