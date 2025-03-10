'''
8-12. Sandwiches: Write a function that accepts a list of items a person wants on a sandwich. 
The function should have one parameter that collects as many items as the function call provides, and it should print a summary of the sandwich that’s being ordered. 
Call the function three times, using a different number of arguments each time.
'''


#Definisco una funzione ordine nella quale inserisco come parametro gli ingredienti del mio panino, la funzione stamperà elemento per elemento A MODO DI ELENCO, di quanto dichiarato dalla chiamata a funzione
def ordine (*ingredienti):
    
    print("\n| INGREDIENTI DEL TUO ORDINE - SANDWICH |")
    
    for elemento in ingredienti:
        print(f"- {elemento}")
    
print("Vi auguriamo un buon appetito !\n")

#Di seguito le chiamate a funzione effettuate: nella prima da tre, nella seconda da cinque e infine la terza da due
ordine('Prosciutto', 'Formaggio', 'Insalata')

ordine('Tacchino', 'Pomodoro', 'Cipolla', 'Maionese', 'Lattuga')

ordine('Tonno', 'Peperoni')





'''                                           |  FUNZIONE MIGLIORATA E AVANZATA DEL CODICE  |                                                     '''


'''
#Creiamo una lista dove memorizzare gli ingredienti inseriti dall'utente
ingredients = []

#Definiamo una funzione che chiede all'utente l'inserimento di quanti prodotti vuole e inserisce gli ingredienti, quanto dichiarato
def list_items(ingredients: list):
    numero:int = int(input("\nInserisci il NUMERO degli ingredienti che vuoi nel Sandwich: "))
    
    for count in range(1, numero + 1):  
        ingrediente = input(f"Inserisci il {count}° ingrediente: ")
        ingredients.append(ingrediente)


#Richiamo la funzione e il suo parametro e provveddo a stampare uno per uno gli ingredienti presenti nella lista
list_items(ingredients)


print("\n| LISTA INGREDIENTI PER IL SANDWICH |")
count:int = 0
for elemento in ingredients:
 count += 1
 print(f"\n{count}° Ingrediente :", elemento)
'
'''