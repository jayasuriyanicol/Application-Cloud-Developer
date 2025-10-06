-- Svolgimento delle Query su Cielo2


--1. Quante sono le compagnie che operano (sia in partenza che in arrivo) nei diversi aeroporti?

SELECT COUNT(DISTINCT comp) AS NumeroCompagnie, ap.codice AS CodiceAeroporto, ap.nome AS NomeAeroporto
FROM Aeroporto ap, ArrPart apr
WHERE apr.partenza = ap.codice OR apr.arrivo = ap.codice
GROUP BY ap.codice, ap.nome;

--1A. Quante sono le compagnie che hanno almeno un volo in partenza o in arrivo, per ogni aeroporto (DOVE -> Aeroporto | # compagnie)

SELECT COUNT(DISTINCT comp) AS NumeroCompagnie, ap.codice AS CodiceAeroporto, ap.nome AS NomeAeroporto
FROM Aeroporto ap, ArrPart apr
WHERE apr.partenza = ap.codice OR apr.arrivo = ap.codice
GROUP BY ap.codice, ap.nome;


--2. Quanti sono i voli che partono dall’aeroporto ‘HTR’ e hanno una durata di almeno 100 minuti?

SELECT COUNT(apr.codice) as NumeroVoliHTR
FROM Volo v, ArrPart apr
WHERE v.codice = apr.codice AND v.comp = apr.comp AND apr.partenza = 'HTR' AND v.durataMinuti >= 100;



--3. Quanti sono gli aeroporti sui quali opera la compagnia ‘Apitalia’, per ogni nazione nella quale opera?

SELECT COUNT(DISTINCT lga.aeroporto) AS NumeroNazioni, lga.nazione AS nomeNazione
FROM  ArrPart apr, LuogoAeroporto lga
WHERE (apr.partenza = lga.aeroporto OR apr.arrivo = lga.aeroporto) AND apr.comp= 'Apitalia' 
GROUP BY lga.nazione;



--4. Qual è la media, il massimo e il minimo della durata dei voli effettuati dalla  compagnia ‘MagicFly’ ?

SELECT ROUND(AVG(v.durataMinuti),2) AS MediaVolo, MAX(v.durataMinuti) AS MassimoVolo, MIN(v.durataMinuti) AS MinimoVolo
FROM Volo v
WHERE v.comp = 'MagicFly';


--5. Qual è l’anno di fondazione della compagnia più vecchia che opera in ognuno degli aeroporti?

SELECT MIN(com.annoFondaz) AS AnnoFondazione, ap.nome, ap.codice
FROM Compagnia com, Aeroporto ap, ArrPart arp
WHERE (arp.partenza = ap.codice OR arp.arrivo = ap.codice) AND
com.nome = arp.comp
GROUP BY ap.nome,ap.codice;



--6. Quante sono le nazioni (diverse) raggiungibili da ogni nazione tramite uno o più voli?

SELECT COUNT(DISTINCT lg1.nazione) AS NumeroPostiRaggiungibili, lg2.nazione AS NomeNazione
FROM ArrPart arp, LuogoAeroporto lg1, LuogoAeroporto lg2
WHERE lg1.aeroporto = arp.arrivo AND  lg2.aeroporto = arp.partenza AND lg1.nazione <> lg2.nazione
GROUP BY lg2.nazione;


--7 Qual è la durata media dei voli che partono da ognuno degli aeroporti?

SELECT ROUND(AVG(v.durataMinuti),2) AS DurataMediaVoli, ap.nome as NomeAeroporto, ap.codice AS CodiceAeroporto
FROM Volo v, ArrPart arp, Aeroporto ap
WHERE arp.codice = v.codice AND arp.partenza = ap.codice AND arp.comp = v.comp
GROUP BY ap.nome, ap.codice;


--8 Qual è la durata complessiva dei voli operati da ognuna delle compagnie fondate a partire dal 1950?

SELECT SUM(v.durataMinuti) AS DurataComplessiva, v.comp as NomeCompagnia
FROM Compagnia com, Volo v
WHERE com.annofondaz >= '1950' AND com.nome = v.comp
GROUP BY v.comp;


--9 Quali sono gli aeroporti nei quali operano esattamente due compagnie?

SELECT a.codice AS CodiceAeroporto,a.nome AS nomeCompagnia
FROM  Aeroporto a, ArrPart arp
WHERE (arp.arrivo = a.codice OR arp.partenza = a.codice) 
GROUP BY a.codice, a.nome
HAVING COUNT(DISTINCT arp.comp) = 2;

--10 Quali sono le città con almeno due aeroporti?

SELECT citta
FROM LuogoAeroporto 
GROUP BY citta
HAVING COUNT(*)>=2;



--11 Qual è il nome delle compagnie i cui voli hanno una durata media maggiore di 6 ore?

SELECT v.comp AS nomeCompagnia
FROM Volo v
GROUP BY v.comp
HAVING AVG(v.durataMinuti) > 360;



--12  Qual è il nome delle compagnie i cui voli hanno tutti una durata maggiore di 100 minuti?


SELECT v.comp AS NomeCompagnia
FROM Volo v
GROUP BY v.comp
HAVING MIN(v.durataMinuti) > 100;