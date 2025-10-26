'''

Esercizio 2 — Elimina duplicati

Scrivi una funzione:

remove_duplicates(items: list[str]) -> list[str]

che restituisca una nuova lista senza elementi duplicati, mantenendo l’ordine originale.

Esempio:

remove_duplicates(["a", "b", "a", "c", "b"]) ➜ ["a", "b", "c"]

'''



def remove_duplicates (items:list[str]) -> list[str]:


    listaNoDuplicati:list[str] = []


    for elem in items:

        if elem not in listaNoDuplicati:


            listaNoDuplicati.append(elem)

    return listaNoDuplicati



print(remove_duplicates(["a", "b", "a", "c", "b"]))