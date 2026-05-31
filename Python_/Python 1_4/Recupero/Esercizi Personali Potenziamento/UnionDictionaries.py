'''
🔸 Esercizio 8 — Unisci due dizionari

Scrivi una funzione:

merge_dicts(d1: dict, d2: dict) -> dict


che unisca due dizionari.
Se una chiave è presente in entrambi, nel risultato mantieni il valore del secondo.

📘 Esempio:

merge_dicts({"a": 1, "b": 2}, {"b": 9, "c": 3}) ➜ {"a": 1, "b": 9, "c": 3}


'''


def merge_dicts(d1: dict, d2: dict) -> dict[str,int]:

   dizionarioFinally:dict[str,int]  = {}

   for key,value in d1.items():
        dizionarioFinally[key] = value
   for key,value in d2.items():
         dizionarioFinally[key] = value
        

   return dizionarioFinally




print(merge_dicts({"a": 1, "b": 2}, {"b": 9, "c": 3}))