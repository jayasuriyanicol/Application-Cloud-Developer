-- QUERY Database "Cielo"



-- 1 | Quali sono i voli (codice e nome delle compagnia) la cui durata supera le 3 ore?

SELECT v.codice, v.comp

FROM Compagnia AS com, Volo AS v

WHERE com.nome = v.comp AND v.durataMinuti > 180;