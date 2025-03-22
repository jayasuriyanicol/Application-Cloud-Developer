'''
8-2. Favorite Book: Write a function called favorite_book() that accepts one parameter, title. 
The function should print a message, such as "One of my favorite books is Alice in Wonderland". 
Call the function, making sure to include a book title as an argument in the function call.
'''

'''                                                          |METODO RICHIESTO DALL'ESERCIZIO|                                                                                           '''

#Definiamo una funzione che stampi un messaggio del nostro libro preferito, scrivendo solo la parte della preferenza, che si aggiungerà tramite una concatenazione
def favorite_book(title:str):
  
  print("\nOne of my favorite books is " + title)


#Riportiamo attraverso l'utilizzo di una variabile "titolo_libro", il titolo del nostro libro preferito
titolo_libro= ("Alice in Wonderland")

favorite_book(titolo_libro)




'''                                                          |METODO AVANZATO DELL'ESERCIZIO|                                                                                           '''

'''#Definiamo una funzione che stampi un messaggio del nostro libro preferito, scrivendo solo la parte della preferenza, che si aggiungerà tramite una concatenazione
def favorite_book(title:str):
    print("\nOne of my favorite books is " +title)

#Riportiamo attraverso l'utilizzo di una variabile "book_title", il titolo del nostro libro preferito, chiedendo all'utente di inserire il suo libro preferito
book_title:str = input("\nPlease, write down you're preferit book: ")
favorite_book(book_title) '''