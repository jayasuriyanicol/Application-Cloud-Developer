--QUERY Accademia8




-- 1. Quali sono le persone (id, nome e cognome) che hanno avuto assenze solo nei giorni in cui non avevano alcuna attivitÃ (progettuali o non progettuali)?

SELECT DISTINCT p.id, p.nome,p.cognome
FROM  persona p
LEFT JOIN assenza a ON  p.id = a.persona
LEFT JOIN AttivitaProgetto ap ON ( p.id = ap.persona AND ap.giorno = a.giorno)
LEFT JOIN AttivitaNonProgettuale anp ON (p.id = anp.persona AND anp.giorno = a.giorno)
WHERE ap.id IS NULL AND anp.id IS NULL 
ORDER BY p.id;
      


--2. Quali sono le persone (id, nome e cognome) che non hanno mai partecipato ad alcun progetto durante la durata del progetto “Pegasus”?

SELECT DISTINCT p.id, p.nome, p.cognome

FROM Persona p, Progetto pr
LEFT JOIN Wp w ON (pr.id = w.progetto)
LEFT JOIN AttivitaProgetto ap ON (p.id = ap.persona)
LEFT JOIN AttivitaNonProgettuale anp ON (p.id = anp.persona)

WHERE pr.nome = 'Pegasus' AND pr.inizio != '2012-01-01' AND pr.fine != '2014-12-31' 
ORDER BY p.id;



--3. Quali sono id, nome, cognome e stipendio dei ricercatori con stipendio maggiori di tutti i professori (associati e ordinari)?


SELECT DISTINCT p.id,p.nome,p.cognome,p.stipendio

FROM Persona p1 

WHERE p1.posizione = 'Professore Ordinario' OR p1.posizione = 'Professore Associato'

ORDER BY p1.id;





--4. Quali sono le persone che hanno lavorato su progetti con un budget superiore alla media dei budget di tutti i progetti?



--5. Quali sono i progetti con un budget inferiore allala media, ma con un numero complessivo di ore dedicate alle attività di ricerca sopra la media?