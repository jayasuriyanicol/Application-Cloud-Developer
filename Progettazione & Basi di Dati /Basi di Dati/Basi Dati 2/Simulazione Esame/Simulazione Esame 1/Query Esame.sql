--SIMULAZIONE ESAME DB 1 - Query Esame


-- 1. Elencare tutti i progetti la cui fine è successiva al 2023-12-31.

SELECT pr.nome AS NomeProgetto
FROM progetto pr
WHERE pr.fine > '2023-12-31';

--  2. Contare il numero totale di persone per ciascuna posizione : (Ricercatore, Professore Associato, Professore Ordinario)

SELECT p.posizione, COUNT(*)
FROM persona  p
GROUP BY p.posizione ;

-- 3. Restituire gli id e i nomi delle persone che hanno almeno  un giorno di assenza per "Malattia"

SELECT DISTINCT p.id, p.nome
FROM persona  p, assenza a
WHERE  p.id = a.persona  AND a.tipo = 'Malattia';

-- 4. Per ogni tipo di assenza, restituire il numero complessivo di occorrenze

SELECT a.tipo, COUNT(*) NumeroComplessivoOccorenze
FROM assenza a
GROUP BY a.tipo;

-- 5. Calcolare lo stipendio massimo tra tutti i "Professori Ordinari".
SELECT MAX(p.stipendio) AS StipendioMassimo
FROM persona p
WHERE p.posizione = 'Professore Ordinario';

--  6. Quali sono le attività e le ore spese dalla persona con id 1 nelle attività del progetto con id 4, ordinate in ordinedecrescente. Per ogni attività, restituire l’id, il tipo e il numero di ore


SELECT  ap.id, ap.tipo, ap.oreDurata AS Durata
FROM attivitaprogetto ap
WHERE ap.persona = 1 AND ap.progetto = 4
ORDER BY ap.id DESC ;

-- 7. Quanti sono i giorni di assenza per tipo e per persona. Per ogni persona e tipo di assenza, restituire nome, cognome, tipo assenza e giorni totali.

SELECT p.nome, p.cognome, a.tipo, COUNT(*) GiorniTotali
FROM persona p, assenza a 
WHERE  p.id = a.persona
GROUP BY p.id, p.nome, p.cognome, ass.tipo;

-- 8. Restituire tutti i “Professori Ordinari” che hanno lo stipendio massimo. Per ognuno, restituire id, nome e cognome

WITH MaxStipendio AS (

    SELECT MAX (p.stipendio) StipendioMassimo
    FROM persona AS p
    WHERE p.posizione = 'Professore Ordinario'
)

SELECT p.id, p.nome, p.cognome
FROM persona p, MaxStipendio
WHERE p.posizione = 'Professore Ordinario' AND p.stipendio = MaxStipendio.StipendioMassimo;

-- 9. Restituire la somma totale delle ore relative alle attività  progettuali svolte dalla persona con id = 3 e con durata  minore o uguale a 3 ore.

SELECT SUM (ap.oreDurata)
FROM attivitaprogetto ap
WHERE ap.oreDurata <= 3 AND ap.persona = 3;

-- 10. Restituire gli id e i nomi delle persone che non hanno mai avuto assenze di tipo "Chiusura Universitaria"

SELECT p.id, p.nome
FROM persona p
LEFT JOIN assenza a ON p.id = a.persona and a.tipo = 'Chiusura Universitaria'
WHERE a.id IS NULL;