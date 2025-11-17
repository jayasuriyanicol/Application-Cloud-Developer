'''
Esercizio 4 — Parole più lunghe di N

Scrivi una funzione:

long_words(words: list[str], min_len: int) -> list[str]

che ritorni tutte le parole con lunghezza maggiore di min_len.

📘 Esempio:


long_words(["gatto", "io", "elefante", "no"], 3) ➜ ["gatto", "elefante"]



'''


def  long_words(words: list[str], min_len: int) -> list[str]:


    listaParoleMinLen:list[str] = []


    for elem in words:


        if len(elem) > min_len:

            listaParoleMinLen.append(elem)

    return listaParoleMinLen


print(long_words(["gatto", "io", "elefante", "no"], 3))