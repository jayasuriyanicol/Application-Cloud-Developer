'''
5. Estrai tutte le date nel formato gg/mm/aaaa

Scrivi una funzione find_dates(text) che trova tutte le date in formato italiano (dd/mm/yyyy) in un testo.

Esempio:

text = "Le date importanti sono 09/04/2025 e 15/08/2023."
find_dates(text)  # ['09/04/2025', '15/08/2023']

'''
#Andiamo a importare la funzione re.findall dove andiamo a matchare i casi in cui ci sono delle date dato il testo che corrispondono alla dichiarazione 2/2/4 cifre.
import re

def find_dates(text:str) -> str:

 return (re.findall(r'\d{2}/\d{2}/\d{4}',text))

#Andiamo a testare la funzione posta, per ricercare le date all'interno del testo, che rispondono ai requisiti posti.
print(find_dates("Le date importanti sono 09/04/2025 e 15/08/2023."))