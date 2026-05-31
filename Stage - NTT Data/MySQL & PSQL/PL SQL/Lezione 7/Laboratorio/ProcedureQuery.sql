-- 1. Scrivi un blocco PSQL dove dichiari una variabile NUMBER e successivamente assegni il valore 10

DECLARE 

v_variabile NUMBER := 10;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Il valore inserito è il seguente: '|| v_variabile);
   
END;


-- 2. Scrivi un blocco PSQL che dichiara una variabile VARCHAR2, assegna il tuo nome

DECLARE 

v_nome VARCHAR2 := 'Nicol';

BEGIN 

    DBMS_OUTPUT.PUT_LINE('Il tuo nome è: ' || v_nome);
END;




-- 3. Dichiara una variabile per lo stipendio usando %TYPE basato sulla tabella EMPLOYEES.

DECLARE 
 
v_stipendio employees.salary%TYPE;


-- 4. Dichiara una variabile record usando %ROWTYPE sulla tabella EMPLOYEES. 

DECLARE 
v_record employees.record&ROWTYPE;



-- 5.Scrivi un blocco PL/SQL che: recupera lo stipendio del dipendente con ID = 101 e lo salva in una variabile 

DECLARE 

v_stipendioCollega employees.salary%TYPE;

BEGIN 
    SELECT salary

    INTO v_stipendioCollega
    FROM employees
    WHERE employee_id= 101;

    DBMS_OUTPUT.PUT_LINE('Stipendio ID 101: ' || v_stipendioCollega);

END;


-- 6.  Scrivi un blocco che: recupera nome e cognome li salva in due variabili 

DECLARE 

v_nome employees.first_name%TYPE;
v_cognome employees.last_name%TYPE;


BEGIN 

    SELECT first_name,last_name

    INTO v_nome, v_cognome

    FROM employees 

    WHERE employee_id = 101;

    DBMS_OUTPUT.PUT_LINE('NOME ID 101: ' || v_nome);
    DBMS_OUTPUT.PUT_LINE('COGNOME ID 101: ' || v_cognome);


    
END;






-- 7. Scrivi un blocco che: prova a recuperare uno stipendio con una query che restituisce più righe 


-- Potremmo anche scrivere il blocco, ma siccome andiamo a salvarlo all'interno di una variabile questo darebbe problemi
-- dato che andiamo a manipolare dati multlipi


-- 8. Scrivi un blocco che: prova a recuperare un dipendente inesistente 

-- In questo caso compilerà senza tropp problemi l'unico fatto è che punterà a un oggetto nullo quindi darà successivamnete errore come oggetto non esistente



-- 9. Scrivi un blocco PL/SQL che: aggiorna lo stipendio del dipendente 101 (+10%) 


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
END;






-- 10. Scrivi un blocco che: inserisce un nuovo dipendente (usa valori semplici) 

DECLARE

    v_id   employees.employee_id%TYPE := 242;
    v_nome        employees.first_name%TYPE  := 'Mario';
    v_cognome     employees.last_name%TYPE   := 'Mela';
    v_email       employees.email%TYPE       := 'mario.mela21@outlook';
    v_job         employees.job_id%TYPE      := 'IT_PROG';
    v_stipendio   employees.salary%TYPE      := 3999.99;

BEGIN 

INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES (v_id, v_nome, v_cognome, v_email, '12/12/2012', v_job, v_stipendio);


      --Utilizziamo il RAISE per ottenere messaggi di conferma.
      RAISE NOTICE 'SUCCESSO ! Dipendente inserito con successo con ID: ' || v_id;
END;




-- 11. Scrivi un blocco PL/SQL che: recupera lo stipendio lo salva in una variabile (solo recupero, senza logica) 

DECLARE 

v_stipendio employees.salary%TYPE;


BEGIN 

    SELECT salary

    INTO v_stipendio

    FROM employees

    WHERE employee_id = 101;


    DBMS_OUTPUT.PUT('Lo stipendio di 101 è: ' || v_stipendio );

END;



-- 12. Scrivi un blocco PL/SQL che: recupera uno stipendio usa %TYPE gestisce correttamente la variabile 


DECLARE 

v_stipendio employees.salary%TYPE;


BEGIN 

    SELECT salary

    INTO v_stipendio

    FROM employees

    WHERE employee_id = 101;


    DBMS_OUTPUT.PUT('Lo stipendio di 101 è: ' || v_stipendio );

END;