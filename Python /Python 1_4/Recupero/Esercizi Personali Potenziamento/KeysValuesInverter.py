'''
Esercizio 6 — Inverti chiavi e valori

Scrivi una funzione:

invert_dict(d: dict[str, str]) -> dict[str, str]


che inverta chiavi e valori in un dizionario.
👉 Se ci sono valori duplicati, tienine solo uno.

Esempio:

invert_dict({"a": "1", "b": "2", "c": "1"}) ➜ {"1": "a", "2": "b"}

'''



def invert_dict(d: dict[str, str]) -> dict[str, str]:


    dizionarioInverso:dict[str,str] ={}


    for key,value in d.items():


        if value not in dizionarioInverso.keys():
              dizionarioInverso[value] = key


    return dizionarioInverso




print(invert_dict({"a": "1", "b": "2", "c": "1"}))