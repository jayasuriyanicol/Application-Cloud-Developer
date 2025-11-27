-- SVOLGIMENTO QUERY SIMULAZIONE ESAME 




--QUERY 1: Quali sono le persone con stipendio di al massimo 40000 euro

SELECT p.nome, p.cognome, p.stipendio
FROM Persona
WHERE stipendio <= 40000;




--QUERY 2: Quali sono i ricercatori che lavorano ad almeno un progetto e hanno uno stipendio di al massimo 40000

SELECT p.nome, p.cognome, p.stipendio
FROM Persona p, AttivitaProgetto ap
WHERE p.stipendio <= 40000, p.posizione = "Ricercatore";



-- QUERY 3: Qual è il budget totale dei progetti nel db


SELECT DISTINCT p.id, SUM(p.budget)
FROM Progetto p;


--QUERY 4: Qual è il budget totale dei progetti a cui lavora ogni persona.  Per ogni persona restituire nome, cognome e budget totale dei progetti nei quali è coinvolto.

SELECT DISTINCT p.nome, p.cognome, SUM(pr.budget)
FROM Persona p, Progetto pr, AttivitaProgetto atp
WHERE p.id = atp.persona, pr.id = atp.progetto;
GROUP BY p.id;


--QUERY 5: Qual è il numero di progetti a cui partecipa ogni professore ordinario. Per ogni professore ordinario, restituire nome, cognome, numero di progetti nei quali è coinvolto


SELECT DISTINCT p.nome,p.cognome, COUNT(DISTINCT ap.progetto)
FROM Persone p, Progetto pr, AttivitaProgetto atp 
WHERE p.id = atp.persona, pr.id = atp.progetto, p.posizione = "Professore Ordinario"
GROUP BY p.id, p.nome,p.cognome
ORDER BY p.cognome, p.nome;


--QUERY 6: Qual è il numero di assenze per malattia di ogni professore associato. Per ogni professore associato, restituire nume, cognome e numero di assenze per malattia

SELECT DISTINCT p.nome,p,cognome,COUNT(a.id)
FROM Persona p, Assenza a 
WHERE p.id = a.persona, a.CausaAssenza = "Malattia", p.posizione = "Professore Associato"
GROUP BY p.id, p.nome, p.cognome
ORDER BY p.cognome, p.nome;


--QUERY 7: Qual è il numero totale di ore, per ogni persona, dedicate al progetto con id ‘5’. Per ogni persona che lavora al progetto, restituire nome, cognome e numero di ore totali dedicate ad attività progettuali relative al progetto


SELECT DISTINCT p.nome,p.cognome, SUM(atp.oreDurata)
FROM Persona p, AttivitaProgetto atp, Progetto pr
WHERE atp.id = 5, p.id = atp.persona
GROUP BY p.id,p.nome,p.cognome
ORDER BY p.cognome, p.nome;


--QUERY 8: Qual è il numero medio di ore delle attività progettuali svolte da ogni persona. Per ogni persona, restituire nome, cognome e numero medio di ore delle sue attività progettuali (in qualsivoglia progetto)

SELECT DISTINCT p.nome,p.cognome,AVG(atp.oreDurata)
FROM Persona p, AttivitaProgetto atp, Progetto pr
WHERE pr.nome = "Artemide",p.id = atp.persona
GROUP BY p.id, p.nome,p.cognome;
ORDER BY p.cognome, p.nome;



--QUERY 9: Qual è il numero totale di ore, per ogni persona, dedicate alla didattica. Per ogni persona che ha svolto attività didattica, restituire nome, cognome e numero di ore totali dedicate alla didattica

SELECT DISTINCT p.nome, p.cognome, SUM(DISTINCT atnp.oreDurata)

FROM Persona p, AttivitaNonProgettuale atnp

WHERE atnp.tipo = "Didattica";


--QUERY 10: Quali sono le persone che hanno svolto attività nel WP di id ‘5’ del progetto con id ‘3’. Per ogni persona, restituire il numero totale di ore svolte in attività progettuali per il WP in questione

SELECT DISTINCT p.nome, p.cognome SUM(atp.oreDurata)
FROM Persona p, AttivitaProgetto atp
WHERE atp.progetto = 3 AND atp.wp = 5
GROUP BY p.id, p.nome,p.cognome
ORDER BY p.cognome, p.nome;

