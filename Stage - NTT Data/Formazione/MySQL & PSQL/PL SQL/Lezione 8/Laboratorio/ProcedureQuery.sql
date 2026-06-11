-- 1. Scrivi un blocco PL/SQL che: recupera lo stipendio del dipendente 101, se è maggiore di 3000, aumenta del 10%

DECLARE 
    v_stipendio    employees.salary%TYPE;
    v_stipendioAum NUMBER;
BEGIN 
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 101;

    v_stipendioAum := v_stipendio;

    IF v_stipendio > 3000 THEN 
        v_stipendioAum := v_stipendio * 1.10;
    END IF;

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('STIPENDIO AGGIORNATO : ' || v_stipendioAum);
END;







-- 2: Scrivi un blocco che: recupera uno stipendio, se è minore di 3000, lo aumenta di 500

DECLARE 
    v_stipendio    employees.salary%TYPE;
    v_stipendioAum NUMBER;
BEGIN 
   
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 132;

    v_stipendioAum := v_stipendio;

   
    IF v_stipendio < 3000 THEN 
        v_stipendioAum := v_stipendio + 500;
    END IF;

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('STIPENDIO AGGIORNATO: ' || v_stipendioAum);
END;





-- 3. Scrivi un blocco che: recupera uno stipendio, se > 3000 → aumenta del 10%, altrimenti → aumenta di 500

DECLARE 
    v_stipendio    employees.salary%TYPE;
    v_stipendioAum NUMBER;

BEGIN 
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 102;

    
    IF v_stipendio > 3000 THEN 
        v_stipendioAum := v_stipendio * 1.10;
    ELSE 
        v_stipendioAum := v_stipendio + 500;
    END IF; 

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('STIPENDIO AGGIORNATO: ' || v_stipendioAum);
END;




-- 4. Scrivi un blocco che: recupera uno stipendio, assegna una variabile livello: LOW (<3000), MEDIUM (<6000), HIGH

DECLARE 
    v_stipendio employees.salary%TYPE;
    v_livello   VARCHAR2(20);
BEGIN     
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 102;

    
    CASE 
        WHEN v_stipendio < 3000 THEN  
            v_livello := 'LOW';
        WHEN v_stipendio < 6000 THEN  
            v_livello := 'MEDIUM';
        ELSE 
            v_livello := 'HIGH';
    END CASE;

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ESTRATTO: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('LIVELLO ASSEGNATO: ' || v_livello);
END;



-- 5. Scrivi un blocco che: stampa (simula) i numeri da 1 a 5 usando LOOP

DECLARE 
    v_numero NUMBER := 1; 
BEGIN 
    LOOP 
        DBMS_OUTPUT.PUT_LINE('Numero : ' || v_numero); 

        v_numero := v_numero + 1; 

        EXIT WHEN v_numero > 5;
    END LOOP;
END;



-- 6. Scrivi un blocco che: usa un FOR loop per contare da 1 a 10

BEGIN 
   
    FOR i IN 1..10 LOOP

        DBMS_OUTPUT.PUT_LINE('Numero : ' || i);

    END LOOP;
END;


-- 7. Scrivi un blocco che: usa WHILE loop per contare fino a 5 

DECLARE
    v_numero NUMBER := 1;
BEGIN
    WHILE v_numero <= 5 LOOP
    DBMS_OUTPUT.PUT_LINE(v_numero);
        v_numero:= v_numero + 1;
END LOOP;
END



-- 8. Scrivi un blocco che: usa un loop incrementa una variabile fino a 5 


DECLARE 
    v_numero NUMBER := 1; 

BEGIN 
    LOOP 
        DBMS_OUTPUT.PUT_LINE('Numero : ' || v_numero); 

        v_numero := v_numero + 1; 

        EXIT WHEN v_numero > 5;
    END LOOP;
END;



-- 9. Scrivi un blocco che: recupera uno stipendio gestisce NO_DATA_FOUND 


DECLARE 
   v_stipendio employees.salary%TYPE;
   v_stipendioAggiornato NUMBER;


BEGIN 

    SELECT salary

    INTO v_stipendio 

    FROM  employees

    WHERE employee_id = 101;

    v_stipendioAggiornato := v_stipendio * 1.10;
    
    DBMS_OUTPUT.PUT_LINE('Stipendio ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('Stipendio AGGIORNATO: ' || v_stipendioAggiornato);
     
    EXCEPTION 

        WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Nessun dato è stato trovato !');

END;



-- 10. Scrivi un blocco che: gestisce TOO_MANY_ROWS 


DECLARE 
   v_stipendio employees.salary%TYPE;
   v_stipendioAggiornato NUMBER;


BEGIN 

    SELECT salary

    INTO v_stipendio 

    FROM  employees

    WHERE employee_id = 101;

    v_stipendioAggiornato := v_stipendio * 1.10;
    
    DBMS_OUTPUT.PUT_LINE('Stipendio ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('Stipendio AGGIORNATO: ' || v_stipendioAggiornato);
     
    EXCEPTION 

        WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Posso elaborare solo una riga non più !');

END;




-- 11. 

DECLARE 
   v_stipendio employees.salary%TYPE;
   v_stipendioAggiornato NUMBER;


BEGIN 

    SELECT salary

    INTO v_stipendio 

    FROM  employees

    WHERE employee_id = 101;

    v_stipendioAggiornato := v_stipendio * 1.10;
    
    DBMS_OUTPUT.PUT_LINE('Stipendio ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('Stipendio AGGIORNATO: ' || v_stipendioAggiornato);
     
    EXCEPTION 

        -- Nelle EXCEPTION per valori UNCHECKED viene gestito tutto da OTHERS, con SQLERRM che funge da 'e.getMessage()' come su JAVA
        WHEN OTHERS THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Errore gestito da PSQL, codice ERRORE -> ' || SQLERRM);

END;



-- 12. Scrivi un blocco che: recupera uno stipendio applica IF gestisce eventuali errori 


DECLARE 
    v_stipendio    employees.salary%TYPE;
    v_stipendioAum NUMBER;
BEGIN 
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 101;

    v_stipendioAum := v_stipendio;

    IF v_stipendio > 3000 THEN 
        v_stipendioAum := v_stipendio * 1.10;
    END IF;

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ATTUALE: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('STIPENDIO AGGIORNATO : ' || v_stipendioAum);

    EXCEPTION 
          WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Nessun dato è stato trovato !');
          WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Posso elaborare solo una riga non più !');

END;



-- 13. recupera uno stipendio calcola livello (CASE) gestisce errori 


DECLARE 
    v_stipendio employees.salary%TYPE;
    v_livello   VARCHAR2(20);
BEGIN     
    SELECT salary 
    INTO v_stipendio 
    FROM employees 
    WHERE employee_id = 102;

    
    CASE 
        WHEN v_stipendio < 3000 THEN  
            v_livello := 'LOW';
        WHEN v_stipendio < 6000 THEN  
            v_livello := 'MEDIUM';
        ELSE 
            v_livello := 'HIGH';
    END CASE;

    DBMS_OUTPUT.PUT_LINE('STIPENDIO ESTRATTO: ' || v_stipendio);
    DBMS_OUTPUT.PUT_LINE('LIVELLO ASSEGNATO: ' || v_livello);

    EXCEPTION 
          WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Nessun dato è stato trovato !');
          WHEN DATA_NOT_FOUND THEN DBMS_OUTPUT.PUT_FILE('ATTENZIONE ! Posso elaborare solo una riga non più !');
END;




