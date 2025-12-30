'''
Esercizio 2 – Somma di due numeri

Crea una funzione lambda che accetti due numeri e restituisca la loro somma.

'''

#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo somma della funzione LAMBDA
from typing import Callable

#Andiamo a chiamare la funzione somma e passare un parametro float -> che ci restituisce un float con la formula x+y
somma : Callable[[float,float], float] = lambda x,y: x+y  

#Andiamo a eseguire dei TEST per vedere il corretto funzionamento della funzione somma
print(somma(1,1))
print(somma(4.1,4.2))