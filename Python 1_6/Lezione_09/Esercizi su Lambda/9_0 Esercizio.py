'''
Esercizio 9 – Ritorna una lambda

Scrivi una funzione moltiplicatore(n) che ritorni una lambda che moltiplica un valore per n.

Esempio d'uso:

per_due = moltiplicatore(2)
print(per_due(10))  # Output: 20

'''
#Importiamo il metodo Callable per svolgere la funzione di moltiplicatore che dato n svolge il numero per x volte.
from typing import Callable

#Definiamo una funzuione ch dato un numero n in input, questo ritorna una funzione lambda- Callable di valori float. Quindi con x: x*n = float
def moltiplicatore(n:int)-> Callable[[float], float]:

    return lambda x: x*n



per_due = moltiplicatore(2)
print(per_due(10))  