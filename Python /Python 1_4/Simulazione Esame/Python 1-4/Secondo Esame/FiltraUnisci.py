'''

Filtra e Unisci Parole - PUNTI 1
Scrivi una funzione con il seguente header:
filter_and_join(words: list[str], min_len: int) -> str
che prenda una lista di parole e restituisca una stringa con tutte le parole di lunghezza maggiore di
min_len, unite da trattini (es. "gatto-cane-elefante").

'''


def filter_and_join(words: list[str], min_len: int) -> str:

    paroleFrase:str = ""


    for elem in words:

        if len(elem) > min_len and len(paroleFrase) > 0:

            paroleFrase +=  "-" + elem
        else:
            paroleFrase += elem

    return paroleFrase




print(filter_and_join(words=["gatto","elefante","cane"], min_len=3))

