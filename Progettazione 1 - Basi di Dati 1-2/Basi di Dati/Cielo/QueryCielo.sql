-- QUERY Database "Cielo"



-- 1 | Quali sono i voli (codice e nome delle compagnia) la cui durata supera le 3 ore?

SELECT v.codice codice_volo, v.comp compagnia

FROM Compagnia AS com, Volo AS v

WHERE com.nome = v.comp AND v.durataMinuti > 180;


-- 2 | Quali sono le compagnie che hanno voli che superano le 3 ore?


SELECT DISTINCT v.comp compoagnia

FROM Compagnia com, Volo v

WHERE com.nome = v.comp AND v.durataMinuti > 180

ORDER BY v.comp DESC; -- Nel caso vogliamo l'output come da "Risultati Attesi" se no ignoriamo l'ORDER BY




-- 3 | Quali sono i voli (codice e nome della compagnia) che partono dall'aeroporto con codice 'CIA'?


SELECT v.codice codice_volo, v.comp compagnia

FROM Volo v, ArrPart arp 

WHERE v.codice = arp.codice AND v.comp = arp.comp AND partenza = 'CIA';


-- 4 | Quali sono le compagnie che hanno voli che arrivano all'aeroporto con codice 'FCO'?

SELECT DISTINCT v.comp compagnia

FROM Volo v, ArrPart arp

WHERE v.codice = arp.codice AND v.comp = arp.comp AND arrivo = 'FCO';



-- 5 | Quali sono i voli  (codice e nome alla compagnia) che partono dall' aeroporto 'FCO' e arrivano all' aeroporto 'JFK' ?

SELECT DISTINCT v.codice codice_volo, v.comp compagnia

FROM Volo v, ArrPart arp

WHERE v.codice = arp.codice 
AND v.comp = arp.comp 
AND arp.partenza = 'FCO'
AND arp.arrivo = 'JFK';


-- 6 | Quali sono le compagnie che hanno voli che partono dall'aeroporto 'FCO' e atterrano all' aeroporto 'JFK' ?

SELECT DISTINCT v.comp compagnia            

FROM Volo v, ArrPart arp

WHERE v.codice = arp.codice 
AND v.comp = arp.comp 
AND arp.partenza = 'FCO'
AND arp.arrivo = 'JFK'

ORDER BY v.comp DESC; -- Nel caso vogliamo l'output come da "Risultati Attesi" se no ignoriamo l'ORDER BY



-- 7 | Quali sono i nomi delle compagnie che hanno voli diretti dalla città di 'Roma' alla città di 'New York'?


SELECT DISTINCT v.comp compagnia

FROM Volo v, ArrPart arp, LuogoAeroporto lg, LuogoAeroporto lg2

WHERE v.codice = arp.codice 
AND v.comp = arp.comp 
AND arp.partenza = lg.aeroporto AND lg.citta = 'Roma' 
AND arp.arrivo = lg2.aeroporto AND lg2.citta = 'New York';



-- 8 | Quali sono gli aeroporti ( con codice IATA , nome e luogo ) nei quali partono voli della compagnia di nome 'MagicFly' ?

SELECT DISTINCT ar.codice codiceiata, ar.nome, lg.citta

FROM Volo v, ArrPart arp, Aeroporto ar, LuogoAeroporto lg

WHERE v.comp = 'MagicFly'
AND v.codice = arp.codice and v.comp = arp.comp
AND arp.partenza = ar.codice
AND ar.codice = lg.aeroporto



-- 9 | Quali sono i voli che partono da un qualunque aeroporto della città di 'Roma' e atterrano ad un qualunque aeroporto della città
--     di 'New York' ? Restituire : codice del volo, nome della compagnia e aeroporti di partenmza e arrivo.


SELECT v.codice codice_volo, v.comp compagnia, arp.partenza, arp.arrivo

FROM Volo v, ArrPart arp, Luogoaeroporto lg, LuogoAeroporto lg2

WHERE v.codice = arp.codice AND v.comp = arp.comp
AND arp.partenza = lg.aeroporto AND lg.citta = 'Roma'
AND arp.arrivo = lg2.aeroporto and lg2.citta = 'New York';



-- 10 | Quali sono i possibili piani di volo con esattamente un cambio ( utilizzando solo voli della stessa compagnia ) da un qualunque aeroporto della città di 'Roma’'d un
--      qualunque aeroporto della città di ‘New York’ ? Restituire: nome della compagnia, codici dei voli, e aeroporti di partenza, scalo e arrivo


SELECT arp.comp  compagnia, arp.codice codice_volo1, arp.partenza, arp.arrivo scalo, arp2.codice codice_volo2, arp2.arrivo

FROM ArrPart arp, ArrPart arp2, LuogoAeroporto lg, LuogoAeroporto lg2

WHERE arp.arrivo = arp2.partenza
AND arp.comp = arp2.comp
AND arp.partenza = lg.aeroporto AND lg.citta = 'Roma'
AND arp2.arrivo = lg2.aeroporto AND lg2.citta = 'New York';




-- 11 | Quali sono le compagnie che hanno voli che partono dall’aeroporto 'FCO', atterrano all’aeroporto 'JFK', e di cui si conosce l’anno di fondazione ?


SELECT DISTINCT comp.nome compagnia

FROM compagnia comp, arrpart arp

WHERE arp.partenza = 'FCO' AND arp.arrivo = 'JFK' AND arp.comp = comp.nome

ORDER BY comp.nome DESC; -- Nel caso vogliamo l'output come da "Risultati Attesi" se no ignoriamo l'ORDER BY