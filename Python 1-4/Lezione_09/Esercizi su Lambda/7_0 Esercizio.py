'''
Esercizio 7 – Filtra parole corte

Hai una lista di parole parole = ["cane", "gatto", "elefante", "ratto", "orso"] Estrai solo le parole con più di 4 lettere usando filter() e lambda.

'''

#Importiamo il metodo Callable ed andiamo a trovare le parole maggiori di quattro caretteri nella lista di parole date
from typing import Callable

#Diamo in input una lista di parole date dall'esercizio
parole: list[str] = ["cane", "gatto", "elefante", "ratto", "orso"]

#Andiamo a chiamare la funzione estraiParole e passare un parametro list -> che ci restituisce una list con tutte le parole superiori a 4 caratteri
estraiParole: Callable [[list[str]] , list[str]] = list(filter(lambda nome : len(nome) > 4 ,parole))  


print(estraiParole)