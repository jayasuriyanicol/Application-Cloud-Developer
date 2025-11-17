'''
3. Sostituisci tutti i numeri con ‘###’

Scrivi una funzione mask_numbers(text) che sostituisce tutte le sequenze di cifre con ###.

Esempio:

text = "Il codice è 12345 e la data è 2025."
mask_numbers(text)  # "Il codice è ### e la data è ###."

'''
#Importiamo la libreria re e andiamo a creare una funzione che vada a sostituire i numeri con l'asterisco, attraverso la funzione re.sub riportando la stessa stringa.
import re

def mask_numbers(text: str) -> str:
    return re.sub(r'\d', '#', text)


print(mask_numbers("Il codice è 12345 e la data è 2025."))