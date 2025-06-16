'''
8.B Il Massimo Comun Divisore di due o più numeri è il più grande divisore comune dei numeri considerati.
Ad esempio, se consideriamo i numeri 12 e 18, il loro Massimo Comun Divisore è mcd(12,18) = 6.
Infatti,

    i divisori di 12 sono:

        12 = 1, 2, 3, 4, 6, 12

    i divisori di 18 sono:

        18 = 1, 2, 3, 6, 9, 18

il divisore più grande che 12 e 18 hanno in comune è 6.

Scrivere nel file frazione.py una funzione  mcd(int x, int y) per il calcolo del Massimo Comune Divisore.
 
Nel caso in cui esista un Massimo Comun Divisore tra i numeri x e y, allora la funzione deve ritornarlo come numero intero.
Altrimenti, nel caso in cui non esista un massimo Comun Divisore tra i numeri x e y, la funzione deve ritornare 1.
   

Suggerimento: per semplicità, per implementare la funzione richiesta, trovare una soluzione che generalizzi l'esempio proposto 
e che tenga conto dei casi x > y e x < y per evitare di replicare righe di codice.
   

'''

def mcd(x:int, y:int) -> int:

    #Vado alla ricerca del valore assoluto (massimo) così da ottenerli  
    x= abs(x)
    y= abs(y)

    #Troviamo il valore minimo fra i valori di x e y  
    valoreMinimo= min(x,y)
   
    #Per ogni valore fra il 'ValoreMinimo' trovato da 0 a -1 (ovvero l'ultimo valore)
    for valore in range(valoreMinimo, 0, -1):

        #Nel caso in cui il valore è divisibile in entrambi e da resto zero stampo il valore, sennò riporto 1 
        if x % valore == 0 and y % valore == 0:

            return valore
    return 1



'''DRIVER PROGRAM - cerchiamo di provare a verificare che una o più opzioni diano risulato corretto'''

print(mcd(12, 18)) 
print(mcd(5, 7))   
print(mcd(6,12)) 
print(mcd(0, 10))   
    
