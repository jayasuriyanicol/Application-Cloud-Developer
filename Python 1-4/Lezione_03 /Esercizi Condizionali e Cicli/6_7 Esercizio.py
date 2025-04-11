'''
6-7. People: Start with the program you wrote for Exercise 6-1.
 Make two new dictionaries representing different people, and store all three dictionaries in a list called people. 
 Loop through your list of people. As you loop through the list, print everything you know about each person.

''' 
# INIZIO Esercizio 6_1

# Creazione di un dizionario per memorizzare le informazioni di una persona
person_1: dict[str, str | int] = {
    "first_name": "Mario",  
    "last_name": "Rossi",   
    "age": 21,              
    "city": "Rome"          
}

# Stampa di un messaggio introduttivo
print("\nBenvenuto, di seguito i DATI PRESENTI NEL DIZIONARIO:\n")

# Iterazione su tutti gli elementi del dizionario person_1
for key, value in person_1.items():
    print(f"{key}: {value}")

# FINE Esercizio 6_1


# INIZIO Esercizio 6_7

# Creazione di altri due dizionari per memorizzare le informazioni di altre persone
person_2: dict[str, str | int] = {
    "first_name": "Michael",
    "last_name": "Baciarello",
    "age": 20,
    "city": "Rome"
}

person_3: dict[str, str | int] = {
    "first_name": "Nathan",
    "last_name": "Mbuyamba",
    "age": 21,
    "city": "Rome"
}

# Creazione della lista contenente tutti i dizionari
people = [person_1, person_2, person_3]

# Iterazione su ogni persona nella lista e stampa delle informazioni
print("\nLista completa delle persone e i loro dati:\n")
for person in people:
    print("-----------")
    for key, value in person.items():
        print(f"{key}: {value}")
    print("-----------\n")
