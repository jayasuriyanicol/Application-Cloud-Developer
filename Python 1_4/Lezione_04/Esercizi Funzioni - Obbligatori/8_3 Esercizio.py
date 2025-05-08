'''
8-3. T-Shirt: Write a function called make_shirt() that accepts a size and the text of a message that should be printed on the shirt. 
The function should print a sentence summarizing the size of the shirt and the message printed on it. 
Call the function once using positional arguments to make a shirt. Call the function a second time using keyword arguments.

'''
#Definiamo una variabile per l'inserimento fuori dalla funzione della taglia e il messaggio da riportare sulla maglia
def make_shirt(size:int, message:str):

    print(f"\nT-shirt size: {size}, with the message: '{message}' printed on it.")


#Prima chiamata a funzione, dove inseriamo i dati secondo il modo in cui sono stati dichiarati dove è NECESSARIO seguire la modalità in cui i parametri sono stati dichiarati
make_shirt(30, "Enjoy the life !")


#Seconda chiamata a funzione, dove inseriamo i dati richiamando i parametri, dove è possibile anche non seguire il filo logico
make_shirt(size=40, message="ESSENCE")
