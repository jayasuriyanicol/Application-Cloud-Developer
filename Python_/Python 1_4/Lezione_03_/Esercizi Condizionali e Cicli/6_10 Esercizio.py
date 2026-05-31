'''
6-10. Favorite Numbers: Modify your program from Exercise 6-2 so each person can have more than one favorite number. 
Then print each person’s name along with their favorite numbers.

'''

# Creazione di un dizionario per memorizzare i numeri preferiti di alcune persone, nel quale inseriamo una lista per contenere tutti i numeri preferiti
favorite_numbers: dict[str, list[int]] = {
    "Mario": [21, 15, 9],       # Mario ha più numeri preferiti
    "Flavio": [26, 7, 11],      # Flavio ha più numeri preferiti
    "Claudio": [13],            # Claudio ha un solo numero preferito
    "Nathan": [6, 18],          # Nathan ha più numeri preferiti
    "Michael": [4, 10, 12]      # Michael ha più numeri preferiti
}

# Iterazione e stampa dei dati iniziali del dizionario
for key, values in favorite_numbers.items():
    # Stampa del nome e dei numeri preferiti per ogni persona
    print("\n", "Nome:", key, "| Numeri Preferiti:", ", ".join(map(str, values)))

# Aggiunta di un nuovo elemento al dizionario (Fabio e i suoi numeri preferiti)
favorite_numbers["Fabio"] = [13, 22]

# Stampa del messaggio di aggiornamento
print("\nDi seguito riporto la LISTA AGGIORNATA CON IL NUMERO DI FABIO:")

# Iterazione e stampa del dizionario aggiornato
for key, values in favorite_numbers.items():
    # Stampa del nome e dei numeri preferiti per ogni persona
    print("\n", "Nome:", key, "| Numeri Preferiti:", ", ".join(map(str, values)))
