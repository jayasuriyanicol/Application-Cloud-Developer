'''
Esercizio 1.

Nota.
Questo esercizio è da svolgere prima tramite diagramma a blocchi, effettuando un check numerico per verificare che i risultati prodotti dal vostro algoritmo siano uguali a quelli dell'expected output proposto nella traccia.
Quando il docente darà il permesso, ogni studente provvederà a tradurre l'algoritmo elaborato in codice Python.
Durante lo svolgimento dell'esercizio non è possibile confrontarsi con gli altri compagni di corso.
Qualora sia necessario, chiedere eventuali chiarimenti al docente.

Un garage fa pagare una tariffa minima di 2.00 $ per parcheggiare fino a tre ore, più 0.50 $ all'ora per ogni ora o parte di essa oltre le tre ore. Il costo massimo per un dato periodo di 24 ore di parcheggio ammonta a 10.00 $. Supponete che nessuna macchina resti parcheggiata per più di 24 ore.
Elaborare un algoritmo che calcoli e stampi i costi del parcheggio per ciascuno dei tre clienti che ieri hanno parcheggiato le loro auto in questo garage.
E' richiesto sapere le ore di parcheggio per ogni cliente.

Una volta elaborato l'algoritmo, scrivere in Python, una funzione calculateCharges che consenta di determinare il costo del parcheggio per ogni cliente.
Mostra, poi, i risultati in forma tabellare.
Il vostro output deve avere il seguente formato:

Car         Hours           Charge
 1            1.5            2.00 $
 2            4.0            2.50 $
 3            24.0           10.00 $
 TOTAL        29.5           14.50 $  


'''

def CarParking(numeroOre:float) -> str | int | float:


    if numeroOre < 3:

        return 2.00
    
    else:
        OreExtraUsufruite:float = numeroOre - 3
        CostoUsufruitoExtra:float = 2.00 + 0.50 * OreExtraUsufruite
        return min(CostoUsufruitoExtra, 10.00)
    

listaClienti:list =[

    (1, 1.5),
    (2, 4.0),
    (3, 24.0)
] 

print(f"{'Car':<8} {' Hours':<10} {'     Charge':<10}")

OreTotali:float = 0
OreExtraUsufruite:float = 0



for macchinaCliente, numeroOre in listaClienti:
    costoUsufruito = CarParking(numeroOre)
    OreTotali += numeroOre
    OreExtraUsufruite += costoUsufruito
    print(f"{macchinaCliente:<10}{numeroOre:<15.1f}{costoUsufruito:.2f} $")
 
print(f"{'TOTAL':<10}{OreTotali:<15.1f}{OreExtraUsufruite:.2f} $")


