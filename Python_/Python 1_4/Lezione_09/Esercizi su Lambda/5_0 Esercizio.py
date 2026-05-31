'''
Esercizio 5 – Funzione lambda con if

Crea una funzione lambda che prenda un numero e ritorni "pari" se è divisibile per 2, altrimenti "dispari".

'''

#Importiamo il metodo Callable, ed andiamo a eseguire il calcolo somma della funzione LAMBDA + FILTER
from typing import Callable

#Andiamo a chiamare la funzione numeriPariDispari e passare un parametro int -> che ci restituisce una str con o "pari" o "dispari", dalla formula x%2==0
numeriPariDispari: Callable[[int],str] = lambda x: "pari" if (x % 2== 0) else "dispari"

print(numeriPariDispari (4))
print(numeriPariDispari (5))