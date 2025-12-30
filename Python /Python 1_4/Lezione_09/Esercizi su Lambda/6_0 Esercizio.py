'''
Esercizio 6 – Uso con reduce()

Usa reduce() (dal modulo functools) e una lambda per calcolare il prodotto di tutti gli elementi di una lista numeri = [2, 3, 4].

'''
#Importiamo il metodo Callable e Reduce da FUNCTOOLS, ed andiamo a eseguire il calcolo del prodotto con LAMBDA e REDUCE
from typing import Callable
from functools import reduce

numeri:list[int]= [2,3,4]  


#Andiamo a chiamare la funzione prodottoFunctolls e passare un parametro int e int -> che ci restituisce un numero int con il prodotto
prodottoFunctolls: Callable[[int,int] ,int] = reduce(lambda x,y : x*y, numeri) 


print(prodottoFunctolls)

