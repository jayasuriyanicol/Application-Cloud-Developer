'''
2. Trova tutte le email in un testo

Scrivi una funzione extract_emails(text) che prende un testo e restituisce tutte le email trovate.

Esempio:

text = "Contattaci a info@azienda.com oppure support@help.org"
extract_emails(text)  # ['info@azienda.com', 'support@help.org']

'''

#Importiamo la libreria re creando una funzione che vada a rintracciare dal testo l'email secondo lo standard dichiarato, con la funzione re.finall, riportando la lista delle email che rispettano la forma.

import re

def extract_emails(text:str) -> str:


    return str (re.findall(r"\S+@+\S+",text))


print(extract_emails("ontattaci a info@azienda.com oppure support@help.org"))



