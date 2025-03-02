'''
6-8. Pets: Make several dictionaries, where each dictionary represents a different pet. 
In each dictionary, include the kind of animal and the owner’s name. 
Store these dictionaries in a list called pets. Next, loop through your list and as
you do, print everything you know about each pet. 

'''


# Creazione di più dizionari, ognuno rappresenta un animale domestico
pet_1 = {
    "animal_type": "Cane",
    "name": "Buddy",
    "owner": "Luca"
}

pet_2 = {
    "animal_type": "Gatto",
    "name": "Whiskers",
    "owner": "Anna"
}

pet_3 = {
    "animal_type": "Pappagallo",
    "name": "Polly",
    "owner": "Marco"
}

pet_4 = {
    "animal_type": "Pesce Rosso",
    "name": "Goldie",
    "owner": "Sofia"
}

# Creazione di una lista che contiene tutti i dizionari degli animali domestici
pets = [pet_1, pet_2, pet_3, pet_4]

# Iterazione sulla lista e stampa delle informazioni su ogni animale domestico
print("\nLista degli animali domestici e i loro proprietari:\n")

for pet in pets:
    print("-----------")
    for key, value in pet.items():
        print(f"{key}: {value}")
    print("-----------\n")
