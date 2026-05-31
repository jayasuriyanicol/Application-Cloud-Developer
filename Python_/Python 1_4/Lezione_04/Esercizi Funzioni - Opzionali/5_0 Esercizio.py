'''
5. Inventory Management System:

     Create a function that defines an item with a code, name, quantity, and price.
     Create a database or dictionary to store the items in inventory.
     Implement functions to add, remove, search, and update items in the inventory.
    Use for loops and conditional statements to manage the various inventory operations.
'''

#Definiamo un dizionario per memorizzare gli articoli
database: dict = {}

#Definiamo una funzione per aggiungere un nuovo articolo all'inventario
def itemDefine() -> None:
    # Richiediamo all'utente di inserire il codice dell'articolo
    code = input("Welcome, please write down the CODE of the ITEM: ")
    
    #Richiediamo all'utente di inserire il nome dell'articolo
    name = input("Please, to continue write down the NAME of the ITEM: ")
    
    #Richiediamo la quantità dell'articolo e la converiamo in un numero intero
    quantity = int(input("Write down the QUANTITY of the ITEM: "))
    
    #Richiediamo il prezzo per ogni articolo e lo converiamo in un numero decimale
    price = float(input("Finally, please write down the PRICE per ITEM: "))
    
    #Stampa un messaggio di conferma
    print(f"\nSUCCESSFULLY RECORDED!\n\nThe ITEM: {name} with CODE NUMBER: {code} is STORED with a QUANTITY OF {quantity}.\nThe price of the ITEM is {price} euro per piece.")
    
    #Aggiungiamo l'articolo al dizionario con il codice come chiave
    database[code] = {"NAME": name, "CODE": code, "QUANTITY": quantity, "PRICE": price}

#Definiamo una funzione per rimuovere un articolo dall'inventario
def itemRemove() -> None:
    #Richiediamo il codice dell'articolo che vogliamo rimuovere
    code = input("\nPlease, write down the CODE of the ITEM you want to REMOVE: ")

    #Verifichiamo se l'articolo è presente nel database
    if code in database:
        #Se l'articolo è trovato, lo rimuoviamo
        del database[code] 
        #Stampa un messaggio di conferma
        print(f"\nThe ITEM with CODE {code} is SUCCESSFULLY DELETED!")
    else:
        #Se l'articolo non è trovato, stampiamo un messaggio di errore
        print("\nINVALID CODE! Please Try Again!")

#Definiamo una funzione per cercare un articolo nell'inventario
def itemSearch() -> None:
    # Richiediamo il codice dell'articolo che vogliamo cercare
    code = input("\nPlease, write down the CODE of the ITEM you want to SEARCH: ")

    #Verifichiamo se l'articolo è presente nel database
    if code in database:
        #Se l'articolo è trovato, lo recuperiamo
        item = database[code]
        #Stampiamo tutte le informazioni dell'articolo trovato
        print(f"\nThe ITEM: {item['NAME']}")
        print(f"CODE: {item['CODE']}")
        print(f"QUANTITY: {item['QUANTITY']}")
        print(f"PRICE FOR EACH: {item['PRICE']} euro")
    else:
        # Se l'articolo non è trovato, stampiamo un messaggio di errore
        print("\nAttention! The CODE WRITTEN is NOT CORRECT!")

# Definiamo una funzione per aggiornare un articolo nell'inventario
def itemUpdate() -> None:
    # Richiediamo il codice dell'articolo che vogliamo aggiornare
    code = input("\nPlease, write down the CODE of the ITEM you want to UPDATE: ")

    # Verifichiamo se l'articolo è presente nel database
    if code in database:
        # Se l'articolo è trovato, chiediamo la nuova quantità e il nuovo prezzo
        new_quantity = int(input("\nWrite down the NEW QUANTITY of the product: "))  # Conversione in intero
        new_price = float(input("\nWrite down the NEW price of the product: "))  # Conversione in float

        # Recuperiamo l'articolo dal database
        item = database[code]

        # Aggiorniamo la quantità e il prezzo
        item["QUANTITY"] = new_quantity
        item["PRICE"] = new_price

        # Stampa un messaggio di conferma
        print(f"\nThe ITEM {item['NAME']} is SUCCESSFULLY UPDATED!")
    else:
        # Se l'articolo non è trovato, stampiamo un messaggio di errore
        print("\nATTENTION! Item NOT FOUND!")

# Definiamo una funzione per gestire tutte le operazioni sull'inventario
def manageItem() -> None:
    # Iniziamo un ciclo infinito per continuare a chiedere cosa fare
    while True:
        # Chiediamo all'utente quale operazione vuole fare
        option = input("\n\nPlease write down, what you want to do with the items in the inventory? \n\n- ADD\n- REMOVE\n- SEARCH\n- UPDATE\n- EXIT\n\nWrite down the SELECTION here: ").lower()

        #Se l'utente sceglie di aggiungere un articolo
        if option == "add": 
            itemDefine()
        
        #Se l'utente sceglie di rimuovere un articolo
        elif option == "remove":
            itemRemove()
        
        #Se l'utente sceglie di cercare un articolo
        elif option == "search":
            itemSearch()
        
        #Se l'utente sceglie di aggiornare un articolo
        elif option == "update":
            itemUpdate()

        #Se l'utente sceglie di uscire
        elif option == "exit":
            print("You are SUCCESSFULLY LOGGED OUT from the DATABASE!")
            break  # Esci dal ciclo

        #Se l'utente inserisce un'opzione non valida
        else:
            print("\nATTENTION! INVALID INPUT! Please enter a valid option.\n\n- ADD\n- REMOVE\n- SEARCH\n- UPDATE\n- EXIT\n")

#Avvio del sistema di gestione inventario
manageItem()
