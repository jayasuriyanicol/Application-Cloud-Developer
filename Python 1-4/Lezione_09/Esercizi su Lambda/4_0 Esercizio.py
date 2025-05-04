'''
Esercizio 4 – Ordinamento con sorted()

Hai una lista di tuple studenti = [("Luca", 21), ("Anna", 19), ("Marco", 22)]. 
Ordina la lista in base all’età (secondo elemento) usando sorted() e lambda.

'''

#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo somma della funzione LAMBDA + SORTED
from typing import List, Tuple

#Diamo in input una lista di numeri dati dall'esercizio
listaStudenti: List[Tuple[ str,int]] = [("Luca", 21), ("Anna", 19), ("Marco", 22)]

#Andiamo a chiamare la funzione funzioneSortedStudenti e passare un parametro list -> che ci restituisce una list con l'età in maniera descrescente
listaSortedStudenti: List[Tuple[ str,int]] = sorted(listaStudenti, key=lambda etàStudente: etàStudente[1]  )


print(listaSortedStudenti)