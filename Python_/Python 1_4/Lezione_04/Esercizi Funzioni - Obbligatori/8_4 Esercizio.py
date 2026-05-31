'''
8-4. Large Shirts: Modify the make_shirt() function so that shirts are large by default with a message that reads I love Python. 
Make a large shirt and a medium shirt with the default message, and a shirt of any size with a different message.
'''

#Definiamo la funzione che di default da una taglia LARGE e con la scritta "I love Python"
def make_shirt(size= "Large", message="I love Python"):
   parola = print(f"\n\nLa taglia della maglietta è {size} il messaggio scritto è il seguente: {message}")

    
#Nella prima chiamata a funzione, verrà stampata la maglia DEFAULT, mentre nella seconda la taglia Medium con la stessa scritta DEFAULT e nella terza Small con un messaggio differente
make_shirt()
make_shirt(size="Medium")
make_shirt(size="Small", message="Essential is Everything")