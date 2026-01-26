'''
3. E-commerce Shopping Cart:

    Create a function that defines a product with a name, price, and quantity.
    Create a function that manages the shopping cart, allowing the user to add, remove, and view products in the cart.
    The function should calculate the cart total and apply any discounts or taxes.
    Implement a for loop to iterate over the items in the cart and print detailed information about each product and the total.

'''

#Definiamo una funzione che stampa la descrizione con le relative infromazioni sul prodotto
def product(name:str, price:float, quantity:int) -> str|float|int: 
    print(f"The PRODUCT is {name}, the PRICE FOR ITEM is: {price:.2f} for {quantity} PIECES")

#Successivamnete definiamo una funzione che tramite un TEST CASE facci scegliere all'utente cosa ha intenzione di fare con la sua 'CARTA'
def shoppingCart():

    shoppingCart:list = [] 

   #Dopo aver creato una lista per memorizzare tutte le informazioni prosiguiamo con una condizione che finchè non è vera e non ci dice di uscire: AGGIUNGIAMO/MOSTRIAMO/RIMUOVIAMO il prodotto/i richiesti dall'utente 
    while True:
        selection:str = input("Welcome! Please write down if you want to (ADD/REMOVE/VIEW/TOTAL/EXIT) from the SHOPPING CART: ").lower()
        match selection:

            case "add":
                name = input("Welcome! Write down the product NAME: ") 
                price = float(input("Write down the PRICE of the PRODUCT: "))  
                quantity = int(input("Write down the QUANTITY of the PRODUCT: "))  

                shoppingCart.append({"name": name, "price": price, "quantity": quantity}) 
                
            case "remove":
                remove_product = input("Which product do you want to REMOVE? ") 
                shoppingCart = [item for item in shoppingCart if item["name"].lower() != remove_product.lower()]  
                print(f"{remove_product} removed from the cart.")  


            case "view":
                if len(shoppingCart) == 0:
                    print("There is NOTHING in the CART!")
                else:
                    for item in shoppingCart:
                        print(f"- The product is: {item['name']} for the quantity of {item['quantity']} at the price of ${item['price']:.2f} EACH")
            #Per il TOTALE, andremo anche a calcolare le tasse che moltlipichiamo con *0.1 del totale e aggiungiamo uno sconto se il totale supera i 100 che equivale al *0.5 del totale
            case "total":
                total = sum(item["price"] * item["quantity"] for item in shoppingCart)
                tax = total * 0.1  
                discount = total * 0.05 if total > 100 else 0  
                final_total = total + tax - discount
            #Mostriamo tutti i dati tichiesti e eventuali sconti 
                print(f"\nSubtotal: ${total:.2f}")
                print(f"Tax (10%): ${tax:.2f}")
                print(f"Discount (5% for orders over $100): ${discount:.2f}")
                print(f"Final Total: ${final_total:.2f}")

            case "exit":
                print("Thank you for shopping!")
                break

            case _:
                print("Invalid selection, please try again.")

#Richiamiamo la funzione per avviare tutto il programma
shoppingCart()
