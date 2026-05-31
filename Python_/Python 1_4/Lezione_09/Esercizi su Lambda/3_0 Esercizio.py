'''
Esercizio 3 – Uso con filter()

Hai la seguente lista numeri = [5, 12, 17, 18, 24, 32]. Usa filter() con una lambda per ottenere solo i numeri pari.

'''
#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo somma della funzione LAMBDA + FILTER
from typing import Callable

#Diamo in input una lista di numeri dati dall'esercizio
listaNumeri:list[int] = [5, 12, 17, 18, 24, 32] 

#Andiamo a chiamare la funzione funzioneFilterLambda e passare un parametro list -> che ci restituisce una list con i numeri pari, dalla formula x%2==0
funzioneFilterNumeri : Callable[[list[int]],list[int]] = list(filter(lambda x: x%2==0,listaNumeri))


print(funzioneFilterNumeri)
