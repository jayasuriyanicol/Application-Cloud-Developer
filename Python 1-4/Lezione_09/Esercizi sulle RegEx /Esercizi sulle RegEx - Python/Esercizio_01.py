'''

1. Verifica se una stringa è un numero intero

Scrivi una funzione is_integer(s) che restituisce True se la stringa è un numero intero (positivo o negativo), False altrimenti.

Esempio:

is_integer("123")      # True
is_integer("-456")     # True
is_integer("12.3")     # False


'''
#Importiamo la libreria re e proseguiamo creando una funzione che restituisce TRUE o FALSE a seconda se sia un num intero.
import re

def is_integer(s:str) -> bool:
    #Attraverso la funzione re.match andiamo ad individuare il numero  e riportiamo il risultato con un bool.
    return bool(re.match(r'^\d+$',s))

#Effettuiamo le verifiche come richiesto dall'esercizio.
print(is_integer("123"))
print(is_integer("-456"))
print(is_integer("12.3"))



