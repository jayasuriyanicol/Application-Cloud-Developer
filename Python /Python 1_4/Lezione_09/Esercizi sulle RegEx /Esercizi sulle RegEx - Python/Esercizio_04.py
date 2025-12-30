'''
4. Verifica un CAP

Scrivi una funzione is_valid_cap(cap) che restituisce True se il CAP è valido (5 cifre), False altrimenti.

Esempio:

is_valid_cap("70124")   # True
is_valid_cap("A0123")   # False

'''
#IMportiamo la libreria import re e andiamo tramite la funzione findall a trovare il codice CAP formato da un minimo di 4 cifre attraverso la funzione bool, True se vero altrimenti False.
import re

def is_valid_cap(cap:str) -> str:


    return bool (re.findall (r'\d{5}', cap))

#Andiamo a verificare come richiesto per la ricerca di 5 cifre numeriche, altrimenti se non corrispondono False.
print(is_valid_cap("70124"))
print(is_valid_cap("A0123"))

