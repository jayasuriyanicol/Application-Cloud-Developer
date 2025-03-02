'''
6-2. Favorite Numbers: Use a dictionary to store people’s favorite numbers. 
Think of five names, and use them as keys in your dictionary. Think of a favorite number for each person, and store each as a value in your dictionary. 
Print each person’s name and their favorite number. 
For even more fun, poll a few friends and get some actual data for your program.
'''

# Creazione di un dizionario per memorizzare i numeri preferiti di alcune persone
favorite_numbers: dict[str, int] = {
    "Mario": 21, 
    "Flavio": 26, 
    "Claudio": 13, 
    "Nathan": 6, 
    "Michael": 4
}

# Iterazione e stampa dei dati iniziali del dizionario
for key, value in favorite_numbers.items():
    print("\n", "Nome:", key, "| Numero Preferito:", value)

# Aggiunta di un nuovo elemento al dizionario (Fabio e il suo numero preferito)
favorite_numbers["Fabio"] = 13

# Stampa del messaggio di aggiornamento
print("\nDi seguito riporto la LISTA AGGIORNATA CON IL NUMERO DI FABIO:")

# Iterazione e stampa del dizionario aggiornato
for key, value in favorite_numbers.items():
    print("\n", "Nome:", key, "| Numero Preferito:", value)
