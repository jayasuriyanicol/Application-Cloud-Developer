'''
6-1. Person: Use a dictionary to store information about a person you know. 
Store their first name, last name, age, and the city in which they live. You should have keys such as first_name, last_name, age, and city. 
Print each piece of information stored in your dictionary.

'''

# Creazione di un dizionario per memorizzare le informazioni di una persona
person: dict[str, int] = {
    "first_name": "Mario",  # Nome della persona
    "last_name": "Rossi",   # Cognome della persona
    "age": 21,              # Età della persona
    "city": "Rome"          # Città di residenza
}

# Stampa di un messaggio introduttivo
print("\n\nBenvenuto, di seguito i DATI PRESENTI NEL DIZIONARIO: ")

# Iterazione su tutti gli elementi del dizionario
for key, value in person.items():
    # Stampa di ogni chiave e valore del dizionario
    print("\n", key, ":", value)
