'''

8️⃣ Rubrica Telefonica (con ricerca parziale)

Scrivi una funzione:

search_contact(phonebook: dict[str, str], query: str) -> list[str]

che ritorni tutti i nomi dei contatti che contengono la query (anche parziale, case-insensitive).

📘 Esempio:

search_contact({"Anna Rossi": "123", "Luca Verdi": "456", "Annalisa Neri": "789"}, "anna") ➜ ["Anna Rossi", "Annalisa Neri"]


'''
def search_contact(phonebook: dict[str, str], query: str) -> list[str]:

    query = query.lower()
    listaContatti:list[str] = []  

    for nome,valore in phonebook.items():

        if query in nome.lower():

            listaContatti.append(nome)
    
    return listaContatti

            


print(search_contact({"Anna Rossi": "123", "Luca Verdi": "456", "Annalisa Neri": "789"}, "anna"))

    

        

