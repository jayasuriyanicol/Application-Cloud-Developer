'''
9. Trova tutti i codici fiscali in un testo

Scrivi una funzione find_fc(text) che trova tutti i codici fiscali all'interno di un testo.

Esempio:

testo = "Mario Rossi CF: RSSMRA85M01H501Z, mentre Maria Bianchi ha il CF BNCMRA85T41H501Y."
codici = find_fc(testo) # ['RSSMRA85M01H501Z', 'BNCMRA85T41H501Y']
'''

#Importiamo la funzione re.findall per ricercare il codice fiscale secondo lo standard dove (MAIUSC_PAROLE(6)DIGIT(2)MAISC_PAROLE(1)DIGIT(2)MAISC_PAROLE(1)DIGIT(3)MAISC_PAROLE(1))
import re

def find_fc(text:str)-> str:

    return (re.findall(r'[A-Z]{6}\d{2}[A-Z]{1}\d{2}[A-Z]{1}\d{3}[A-Z]{1}', text))

#Verifichiamo quanto chiesto dall'esercizio la veridicità dello standard CF da 16 cifre.
print(find_fc("Mario Rossi CF: RSSMRA85M01H501Z, mentre Maria Bianchi ha il CF BNCMRA85T41H501Y."))
