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


def merge_intervals(intervals:list[str,str]) ->  list[str,str] | list[None]:

   if len(intervals) == 0:
      
      return [] 
   
   elif len(intervals) == 1:
      
      return intervals[0]
   

   intervals.sort()

   unioneIntervalli = [intervals[0]] 
   

   for i in range(1, len(intervals)):

      valoreCorrente = intervals[i]
      ultimoValore = unioneIntervalli[-1] 

      if valoreCorrente[0]  <= ultimoValore[1]:     
         if valoreCorrente[1] > ultimoValore[1]:

            ultimoValore[1] = valoreCorrente[1]
      else:
         unioneIntervalli.append(valoreCorrente)
   return unioneIntervalli

print(merge_intervals([[1, 3], [2, 6], [8, 10], [15, 18]]))
print(merge_intervals([[1, 4], [4, 5]]))
