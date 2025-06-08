'''
Unione di Intervalli Sovrapposti
Data una lista di intervalli chiusi rappresentati come liste di due elementi [start, end],
scrivi una funzione merge_intervals(intervals) che restituisce una nuova lista di
intervalli in cui tutti quelli sovrapposti sono stati fusi. Ogni intervallo soddisfa start <=
end. La lista risultante deve essere ordinata per inizio intervallo e non devono esserci
sovrapposizioni.
Requisiti:
● Input: una lista di liste, ad esempio [[1, 4], [2, 6], [8, 10], [15, 18]].
● Se due intervalli si sovrappongono o si toccano (es. [1,4] e [4,5]), unirli in
[1,5].
● Restituisci una lista di intervalli fusi, ordinata per il valore di inizio.
● Casi limite:
○ Se l’input è vuoto, restituisci una lista vuota.
○ Se è presente un solo intervallo, restituiscilo così com’è.
Esempi:
intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
merge_intervals(intervals) # restituisce [[1, 6], [8, 10], [15,
18]]
intervals = [[1, 4], [4, 5]]
merge_intervals(intervals) # restituisce [[1, 5]]

'''

#Definiamo una funzione che unisce gli intervalli sovrapposti o adiacenti
def merge_intervals(intervals: list[list[int]]) -> list[list[int]]:

    #Se la lista è vuota, restituiamo una lista vuota
    if len(intervals) == 0:
        return []

    #Se è presente un solo intervallo, lo restituiamo direttamente all'interno di una lista
    if len(intervals) == 1:
        return intervals

    #Ordiniamo gli intervalli in base al valore iniziale
    intervals.sort()

    #Inizializziamo la lista con il primo intervallo
    unioneIntervalli = [intervals[0]]

    #Scorriamo gli intervalli a partire dal secondo
    for i in range(1, len(intervals)):

        #Intervallo corrente
        valoreCorrente = intervals[i]

        #Ultimo intervallo aggiunto alla lista unita
        ultimoValore = unioneIntervalli[-1]

        #Se l'intervallo corrente si sovrappone o tocca quello precedente
        if valoreCorrente[0] <= ultimoValore[1]:
            
            #Estendiamo il finale dell'intervallo unito, se necessario
            if valoreCorrente[1] > ultimoValore[1]:
                ultimoValore[1] = valoreCorrente[1]
        
        #Altrimenti, aggiungiamo un nuovo intervallo separato
        else:
            unioneIntervalli.append(valoreCorrente)

    return unioneIntervalli


'''DRIVER PROGRAM - Eseguiamo il test con due esempi di intervalli'''

print(merge_intervals([[1, 3], [2, 6], [8, 10], [15, 18]]))   
print(merge_intervals([[1, 4], [4, 5]]))           
