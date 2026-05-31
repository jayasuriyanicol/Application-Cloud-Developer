'''

7. Verifica un nome proprio

Scrivi una funzione is_valid_name(name) che controlla se la stringa inizia con una lettera maiuscola seguita da almeno due lettere minuscole.

Esempio:

is_valid_name("Marco")    # True
is_valid_name("marco")    # False
is_valid_name("Ma")       # False


'''
#Importiamo la funzione re.findall per ricercare il nome secondo lo standard e verificarlo con una funzione BOOLEAN
import re

def is_valid_name(name:str) -> bool:

    return bool (re.findall(r'[A-Z]{1}[a-z]{2}', name))


#Verifichiamo con tutti i casi posti dall'esercizio la funzione
print(is_valid_name("Marco"))
print(is_valid_name("marco"))
print(is_valid_name("Ma"))

