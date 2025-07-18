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