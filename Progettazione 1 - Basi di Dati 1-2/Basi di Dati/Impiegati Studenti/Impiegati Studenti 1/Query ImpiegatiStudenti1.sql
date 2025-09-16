-- Svolgimento delle QUERY sul DATABASE ImpiegatiStudenti1


-- 1. Quali sono i nomi degli impiegati nati a partire dall'anno 

SELECT p.nome 
FROM Persona as p, Impiegato as imp;
WHERE p.cf = imp.Persona
ORDER BY data_nascita ASC;


-- 2. Quali sono i nomi di tutti i progetti?

SELECT pro.nome
FROM Progetto pro;


-- 3. Quali sono gli stipendi dei direttori?

SELECT imp.stipendio
FROM Impiegato imp
WHERE imp.ruolo = 'Direttore';


-- 4. Quanti sono i progettisti?

SELECT COUNT(imp.Persona)
FROM Impiegato imp
WHERE ruolo = 'Progettista';

-- 5. Quanti sono i responsabili?

SELECT COUNT(prog.resp_prog)
FROM Progetto prog, Impiegato imp
WHERE imp.persona = prog.resp_prog AND imp.ruolo = 'Progettista';

--  6. Quanti sono i progettisti che non sono responsabili?

-- NON CORRETTA

SELECT COUNT(pr.resp_prog)
FROM Persona p, Impiegato imp, Progetto pr
WHERE p.cf = imp.Persona  AND pr.resp_prog = imp.Persona AND imp.ruolo NOT 'Progettista';

-- 7. Qual è lo stipendio medio dei segretari?

SELECT AVG(imp.stipendio)
FROM impiegato imp
WHERE ruolo = 'Segretario';


-- 8. Qual è l'età della/o studente meno giovane?

SELECT MAX(date_part('year',age(current_date,data_nascita))) as eta 
FROM Persona p ,Studente s
WHERE p.cf = s.persona;



-- 9. Quanti sono i direttori che hanno assolto agli obblighi militari?

SELECT COUNT(p.cf)
FROM Persona p, Impiegato imp
WHERE p.cf = imp.Persona AND imp.ruolo = 'Direttore' AND p.pos_uomo = 'Assolto';


-- 10. Quanti sono i progetti di cui è responsabile un'impiegata con almeno due figli?

SELECT COUNT(p.id)
FROM Persona p, Impiegato imp, Progetto pr
WHERE p.cf = imp.Persona AND p.maternita >= 2 AND pr.resp_prog = imp.Persona;