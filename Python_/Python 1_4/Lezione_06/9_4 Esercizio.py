'''
9-4. Number Served: Start with your program from Exercise 9-1. 
Add an attribute called number_served with a default value of 0. 
Create an instance called restaurant from this class. 
Print the number of customers the restaurant has served, and then change this value and print it again. 
Add a method called set_number_served() that lets you set the number of customers that have been served. 
Call this method with a new number and print the value again. Add a method called increment_number_served() that lets you increment the number of customers
who’ve been served. Call this method with any number you like that could represent how many customers were served in, say, a day of business. 

'''

'''RISPETTO ALL'ESERCIZIO NUMERO 9_1 ANDIAMO A CAMBIARE, INSERIAMO IL NUMERO SERVITO CHE DI DEFAULT È 0 E ANDIAMO A CREARE DUE METODI UNO per I CLIENTI SERVITI AL MOMENTO E L'ALTRO PER I CRLIENTI INCREMENTATI A FINE GIORNATA'''


#Definiamo una classe Restaurant, dove andiamo a creare un costruttore con all'interno due variabili: 'RESTAURANT_NAME' e 'CUISINE_TYPE'
class Restaurant:
  
  def __init__(self, restaurant_name:str, cuisine_type:str, number_served:int = 0) -> str:
      
     #Successivamente andiamo a richiamare il parametro self.nome-varibile =  nome_variabile 
      self.restaurant_name = restaurant_name
      self.cuisine_type = cuisine_type
      self.number_served = number_served

 #Creiamo un metodo che andrà a stmpare il nome del ristorante e la tipologia  
  def describe_restaurant(self):
     
     print("\nQuesto è il nome del ristorante: ",self.restaurant_name)
     print("\nQuesto è la tipolgia del ristorante: ",self.cuisine_type)    

 #Creiamo anche un metodo per mostare in stampa se il ristorante è aperto o meno  
  def open_restaurant(self):
     
     print("\nIl ristorante è APERTO !")

#Creiamo una funzione che ci indica quanti sono i camerieri attuali che hanno servito il cliente
  def set_number_served (self,numero):
     
     if numero >= 0: 

        self.number_served = numero
         
        print("\nI camerieri ATTUALI che mi hanno servito sono: ",self.number_served)
    
     else:

        print("\nNon puoi inserire un numero inferiore a 0 !") 

#Creiamo un'altra funzione che incrementa il numero di persone servirte, dichiarate durante la chiamat a funzione
  def increment_number_served (self,numero):
     
     if numero > 0:

        self.number_served += numero
         
        print("\nI camerieri serviti nell'ARCO DELLA GIORNATA SONO DI: ",self.number_served)
     else:

        print("Non puoi diminuire ulteriormente il numero !")



     

#Creo una variabile chiamata ristorante, richiamando la classe e assegnando le varie variabili
ristorante: Restaurant =  Restaurant("Kebab Damasco", "Kebab - Cucina Araba")

#Possiamo in modo FACOLTATIVO aggiungere dei messsaggi in più

print("\nNome del ristorante: ",ristorante.restaurant_name)
print("\nSpecialità del ristorante: ",ristorante.cuisine_type)

#Richiamiamo le funzioni e nelle ultime due create come richiesto dall'esercizio indichiamo il parametro il numero che sarà pari a 0 e 1 per gli incremento.
ristorante.describe_restaurant()
ristorante.open_restaurant()
ristorante.set_number_served(0)
ristorante.increment_number_served(1)