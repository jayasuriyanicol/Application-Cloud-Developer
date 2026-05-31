--QUERY Accademia8




-- 1. Quali sono le persone (id, nome e cognome) che hanno avuto assenze solo nei giorni in cui non avevano alcuna attivitÃ (progettuali o non progettuali)?

SELECT p.id, p.nome, p.cognome

FROM attivitaprogetto ap

RIGHT JOIN assenza a ON a.persona = ap.persona AND a.giorno = ap.giorno

LEFT JOIN attivitanonprogettuale anp ON a.persona = anp.persona AND a.giorno = anp.giorno

RIGHT JOIN persona p ON p.id = a.persona AND (ap.id IS NOT NULL OR anp.id IS NOT NULL)

WHERE a.id IS NULL

ORDER BY p.id;

--2. Quali sono le persone (id, nome e cognome) che non hanno mai partecipato ad alcun progetto durante la durata del progetto “Pegasus”?

WITH LavoratoriPegasus AS (
    SELECT DISTINCT ap.persona

    FROM AttivitaProgetto ap, Progetto pr

    WHERE pr.nome = 'Pegasus' 
    
      AND ap.giorno >= pr.inizio 
      AND ap.giorno <= pr.fine
)

SELECT DISTINCT p.id, p.nome, p.cognome
FROM Persona p
LEFT JOIN LavoratoriPegasus lp ON p.id = lp.persona
WHERE lp.persona IS NULL
ORDER BY p.id;



--3. Quali sono id, nome, cognome e stipendio dei ricercatori con stipendio maggiori di tutti i professori (associati e ordinari)?


SELECT DISTINCT p.id, p.nome, p.cognome, p.stipendio

FROM Persona p
WHERE p.posizione = 'Ricercatore'
AND p.stipendio > (
    SELECT MAX(p2.stipendio)
    FROM Persona p2
    WHERE p2.posizione = 'Professore Associato' 
       OR p2.posizione = 'Professore Ordinario'
)
ORDER BY p.id;


--4. Quali sono le persone che hanno lavorato su progetti con un budget superiore alla media dei budget di tutti i progetti?

WITH b_tot AS (

    SELECT DISTINCT AVG(pr.budget) as mediaBudget
    FROM Persona p, AttivitaProgetto atp, Progetto pr
    WHERE p.id = atp.persona AND pr.id = atp.progetto

)

SELECT DISTINCT p.id,p.nome,p.cognome,p.posizione
FROM Persona p, AttivitaProgetto atp, Progetto pr
WHERE p.id = atp.persona AND pr.id = atp.progetto AND pr.budget > (SELECT mediaBudget FROM b_tot);


--5. Quali sono i progetti con un budget inferiore allala media, ma con un numero complessivo di ore dedicate alle attività di ricerca sopra la media?


WITH b_tot AS (

    SELECT AVG(pr.budget) as mediaBudget
    FROM Progetto pr

),



n_ricerca AS (

    SELECT DISTINCT AVG(oreTotali) as mediaOre
    FROM (

        SELECT SUM(ap.oreDurata) AS oreTotali
        FROM AttivitaProgetto ap
        WHERE  ap.tipo = 'Ricerca e Sviluppo'
        GROUP BY progetto
    ) AS q

)



SELECT DISTINCT pr.id, pr.nome, pr.budget, SUM(ap.oreDurata) AS TotaleOreRicerca
FROM AttivitaProgetto ap, Progetto pr
WHERE pr.id = ap.progetto AND ap.tipo = 'Ricerca e Sviluppo' 
GROUP BY pr.id,pr.nome,pr.budget
HAVING pr.budget < (SELECT mediaBudget FROM b_tot) AND SUM(ap.oreDurata) > (SELECT mediaOre FROM n_ricerca);