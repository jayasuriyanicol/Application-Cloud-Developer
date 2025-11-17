'''
Esercizio 1 – Sintassi

Scrivi una funzione lambda che prenda un numero intero e ritorni il suo quadrato.

Esempio atteso:

quadrato = lambda x: ...

'''
#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo del quadrato della funzione LAMBDA
from typing import Callable

#Andiamo a chiamare la funzione quadrato e passare un parametro float -> che ci restituisce un float con la formula x**2
quadrato:Callable [[float],float] = lambda x: x ** 2

#Andiamo a eseguire dei TEST per vedere il corretto funzionamento della funzione quadrato 
print(quadrato(2))
print(quadrato(4.2))