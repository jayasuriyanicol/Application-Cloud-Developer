'''
🔸 Esercizio 5 — Conta frequenze

Scrivi una funzione:

word_count(sentence: str) -> dict[str, int]


che conti quante volte appare ogni parola in una stringa.
Ignora la punteggiatura e tratta tutto come minuscolo.

📘 Esempio:

word_count("Ciao ciao mondo") ➜ {"ciao": 2, "mondo": 1}

'''
from string import punctuation

def word_count(sentence: str) -> dict[str, int]:

    dizionarioFrequenze:dict[str,int] = {}  
    parola:str = ""


    for carattere in punctuation:

        sentence = sentence.replace(carattere, '')
    
    sentence = sentence.lower()

    
    for carattere in sentence:

        if carattere != " ":

             parola += carattere

        else:
        

            if parola not in dizionarioFrequenze.keys():

                dizionarioFrequenze[parola] = 1

            else:

                dizionarioFrequenze[parola] += 1
            parola = ""

    if parola:
        dizionarioFrequenze[parola] = dizionarioFrequenze.get(parola, 0) + 1



    return dizionarioFrequenze





print(word_count("Ciao ciao mondo"))



