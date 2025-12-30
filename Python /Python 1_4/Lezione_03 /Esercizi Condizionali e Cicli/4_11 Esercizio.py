'''
4-11. My Pizzas, Your Pizzas: Start with your program from Exercise 4-1. 
Make a copy of the list of pizzas, and call it friend_pizzas. Then, do the following:
• Add a new pizza to the original list.
• Add a different pizza to the list friend_pizzas.
• Prove that you have two separate lists. Print the message My favorite pizzas are:, 
and then use a for loop to print the first list. Print the message My friend’s favorite pizzas are:, and then use a for loop to print the second list. Make sure each new pizza is stored in the appropriate list.

'''

#INIZIO ESERCIZIO 4_1
# Creiamo una lista con tre tipi di pizza preferiti
pizza = ["Pizza Margherita", "Pizza alle Patate e Salsiccia", "Pizza alla Diavola"] 
friend_pizzas = ["Pizza alle Patate", "Pizza Funghi e Salciccia", "Pizza alla Quattro Formaggi"] 
# Stampa ogni tipo di pizza individualmente (non necessario, può essere incluso nel ciclo for)
print(f"{pizza[0]}")
print(f"{pizza[1]}")
print(f"{pizza[2]}")

# Utilizziamo un ciclo for per stampare ogni pizza della lista
for selection in pizza:
    print(f"{selection}")

# Modifichiamo il ciclo per stampare una frase personalizzata per ogni pizza
for selection in pizza:  
    print(f"Questa è la {selection} che hai ordinato!")

# Messaggio finale fuori dal ciclo per esprimere il nostro amore per la pizza
print("Potrei mangiarla ogni giorno!")

#FINE ESERCIZIO 4_1


#INIZIO ESERCIZIO 4_11

#Aggiungo una nuova pizza alla lista 'PIZZA'
pizza.append("Pizza alla Boscaiola")

#Aggiungo una nuova pizza alla lista 'FRIEND_PIZZAS'
friend_pizzas.append("Pizza Carbonara")

#Stampo in messaggi separati tutti valori presenti nelle liste: 'PIZZA' e 'FRIEND_PIZZAS' numerando uno per uno le pizze.
print("\n\n HO DUE LISTE DIFFERENTI DI PIZZA, GUARDA QUI: ")
print("QUESTA È LA LISTA 'PIZZA': ")
n=0
for pizzas in pizza: 
    n+=1
    print(f"\nQuesta è la {n} della lista 'PIZZA' : ", pizzas)

print("\n\nQUESTA È INVECE LA SECONDA LISTA 'FRIEND_PIZZAS': ")

h=0
for pizza in friend_pizzas:
    h +=1
    print(f"\nQuesta è la {h} della lista 'FRIEND_PIZZAS' : ",pizza)

#FINE ESERCIZIO 4_11