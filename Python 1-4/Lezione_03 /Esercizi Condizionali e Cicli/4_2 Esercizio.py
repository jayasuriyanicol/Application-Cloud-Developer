'''
4-2. Animals: Think of at least three different animals that have a common characteristic. 
Store the names of these animals in a list, and then use a for loop to print out the name of each animal.
• Modify your program to print a statement about each animal, such as A dog would make a great pet.
• Add a line at the end of your program, stating what these animals have in common. 
You could print a sentence, such as Any of these animals would make a great pet!

'''

# Creiamo una lista con tre animali da compagnia
animals = ["Dog", "Cat", "Rabbit"]

# Usiamo un ciclo for per stampare il nome di ogni animale con una frase personalizzata
for name in animals:
    print(f"\nQuesto è il nome dell'animale: {name}")

# Stampa di frasi specifiche per ogni animale
print(f"\n{animals[0]} è un fantastico cane!")
print(f"\n{animals[1]} è di ottima compagnia!")
print(f"\n{animals[2]} è così morbido!")

# Messaggio finale che evidenzia una caratteristica comune tra gli animali della lista
print(f"\n\nGli animali {animals[0]}, {animals[1]}, {animals[2]} hanno in comune di essere ANIMALI DA COMPAGNIA!")
print(f"\n\nGli animali {animals[0]}, {animals[1]}, {animals[2]} potrebbero essere degli ottimi cuccioli!")
