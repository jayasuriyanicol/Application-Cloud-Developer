'''
Esercizio 1 – Sintassi

Scrivi una funzione lambda che prenda un numero intero e ritorni il suo quadrato.

Esempio atteso:

quadrato = lambda x: ...

'''
#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo del quadrato della funzione LAMBDA
from typing import Callable

#Andiamo a chiamre la funzione quadrato e passare un parametro int -> che ci restituisce un int con la formula x**2
quadrato:Callable [[int],int] = lambda x: x ** 2

#Andiamo a eseguire dei TEST per vedere il corretto funzionamento della funzione LAMBDA
print(quadrato(2))
print(quadrato(4))