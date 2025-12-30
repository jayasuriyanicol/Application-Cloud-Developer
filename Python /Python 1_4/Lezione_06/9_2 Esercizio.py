'''
9-2. Three Restaurants: Start with your class from Exercise 9-1. Create three different instances from the class, and call describe_restaurant() for each instance.
'''

#Utilizziamo in questa maniera l'IMPORT dell'esercizio, doloamente evitiamo la RINOMINA del file, dato che non accetta underscore "_"

'''from 9_1 Esercizio import Restaurant'''

#Inizializziamo una classe chiamata Restaurant, comne dall'esercizio procedente e  aggiungiamo i medesemi paramatri nel costruttore
class Restaurant:
  
  def __init__(self, restaurant_name:str, cuisine_type:str):
      
      self.restaurant_name = restaurant_name
      self.cuisine_type = cuisine_type

#Creiamo un metodo che ha il compito di stampare a schermo il messaggio all'utente 
  def describe_restaurant(self):
     
     print("\nQuesto è il nome del ristorante: ",self.restaurant_name)
     print("\nQuesto è la tipolgia del ristorante: ",self.cuisine_type) 

#Altro metodo che ha il compito di dire se il ristorante è aperto
  def open_restaurant(self):
     
     print("\nIl ristorante è APERTO !")


#Come richiesto dall'esercizio 9_2 andiamo a stampare 3 locali differenti
ristorante: Restaurant =  Restaurant("Kebab Damasco", "Kebab - Cucina Araba")
ristorante_1: Restaurant = Restaurant ("Ciro Kebab", "Kebab - Alta Cucina Turca")
ristorante_2: Restaurant =  Restaurant ("Kebab Station", "Kebab - Fast Food Arabo")

#Stampiamo i relativi messaggi solo di descrizione dei locali, senza aggiungere se è aperto o meno dato che non viene richiesto.
ristorante.describe_restaurant()
ristorante_1.describe_restaurant()
ristorante_2.describe_restaurant()


#Sempre in maniera FACOLTATIVA possiamo aggiungere un messaggio in più al di fuori della chiamata del metodo/funzione

'''
print("\nNome del ristorante: ",ristorante.restaurant_name)
print("\nSpecialità del ristorante: ",ristorante.cuisine_type)
'''
