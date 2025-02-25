'''
4-1. Pizzas: Think of at least three kinds of your favorite pizza. Store these pizza names in a list, 
and then use a for loop to print the name of each pizza.
• Modify your for loop to print a sentence using the name of the pizza, instead of printing just the name of the pizza. 
For each pizza, you should have one line of output containing a simple statement like I like pepperoni pizza.
• Add a line at the end of your program, outside the for loop, that states how much you like pizza. 
The output should consist of three or more lines about the kinds of pizza you like and then an additional sentence, such as I really love pizza!

'''
# Creiamo una lista con tre tipi di pizza preferiti
pizza = ["Pizza Margherita", "Pizza alle Patate e Salsiccia", "Pizza alla Diavola"] 

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
