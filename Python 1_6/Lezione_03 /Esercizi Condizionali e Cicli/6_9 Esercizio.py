'''
6-9. Favorite Places: Make a dictionary called favorite_places. 
Think of three names to use as keys in the dictionary, and store one to three favorite places for each person. 
To make this exercise a bit more interesting, ask some friends to name a few of their favorite places. 
Loop through the dictionary, and print each person’s name and their favorite places.

'''

# Creazione del dizionario favorite_places con i nomi delle persone come chiavi e i loro posti preferiti come valori
favorite_places: dict[str, list[str]] = {
    "Sara": ["Austria", "Francia", "Giappone"],  # Sara ha 3 posti preferiti
    "Federico": ["Svezia", "Norvegia"],           # Federico ha 2 posti preferiti
    "Carlo": ["Filippine"]                        # Carlo ha 1 posto preferito
}

# Iterazione sul dizionario e stampa di ciascuna persona e dei loro posti preferiti
print("\nEcco i posti preferiti delle persone:\n")

for name, places in favorite_places.items():
    # Stampa del nome della persona
    print(f"{name}'s posti preferiti sono:")
    # Iterazione sulla lista di posti preferiti di ogni persona
    for place in places:
        print(f"- {place}")
    print()  # Aggiunge una riga vuota tra le persone
