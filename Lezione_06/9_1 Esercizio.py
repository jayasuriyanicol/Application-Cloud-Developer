'''
9-1. Restaurant: Make a class called Restaurant. The __init__() method for Restaurant should store two attributes: a restaurant_name and a cuisine_type. 
Make a method called describe_restaurant() that prints these two pieces of information, and a method called open_restaurant() that prints a message indicating that 
the restaurant is open. Make an instance called restaurant from your class. Print the two attributes individually, and then call both methods.

'''

#Definiamo una classe Restaurant, dove andiamo a creare un costruttore con all'interno due variabili: 'RESTAURANT_NAME' e 'CUISINE_TYPE'
class Restaurant:
  
  def __init__(self, restaurant_name:str, cuisine_type:str):
      
     #Successivamente andiamo a richiamare il parametro self.nome-varibile =  nome_variabile 
      self.restaurant_name = restaurant_name
      self.cuisine_type = cuisine_type

 #Creiamo un metodo che andrà a stmpare il nome del ristorante e la tipologia  
  def describe_restaurant(self):
     
     print("\nQuesto è il nome del ristorante: ",self.restaurant_name)
     print("\nQuesto è la tipolgia del ristorante: ",self.cuisine_type)    

 #Creiamo anche un metodo per mostare in stampa se il ristorante è aperto o meno  
  def open_restaurant(self):
     
     print("\nIl ristorante è APERTO !")

#Creo una variabile chiamata ristorante, richiamando la classe e assegnando le varie variabili
ristorante: Restaurant =  Restaurant("Kebab Damasco", "Kebab - Cucina Araba")

#Possiamo in modo FACOLTATIVO aggiungere dei messsaggi in più
'''
print("\nNome del ristorante: ",ristorante.restaurant_name)
print("\nSpecialità del ristorante: ",ristorante.cuisine_type)
'''

ristorante.describe_restaurant()
ristorante.open_restaurant()





