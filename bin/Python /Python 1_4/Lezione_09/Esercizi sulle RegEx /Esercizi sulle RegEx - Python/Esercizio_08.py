'''
8. Trova parole con lettere maiuscole e numeri

Scrivi una funzione find_codes(text) che trova tutte le parole lunghe 8 caratteri, con lettere maiuscole e/o numeri.

Esempio:

text = "I codici sono AB12CD34 e 12345678 e XYZZYZZZ"
find_codes(text)  # ['AB12CD34', '12345678', 'XYZZYZZZ']
'''


#Importiamo la funzione re.findall per ricercare il codice secondo lo standard e stampare una lista di elementi
import re

def find_codes(text:str)-> str:

  return (re.findall(r'[A-Z0-9]{8}',text))

#Verifichiamo il caso dell'esercizio per vedere se i codici vengono stampati come detto.
print(find_codes("I codici sono AB12CD34 e 12345678 e XYZZYZZZ"))