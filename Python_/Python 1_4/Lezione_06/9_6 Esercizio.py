'''
9-6. Ice Cream Stand: An ice cream stand is a specific kind of restaurant. 
Write a class called IceCreamStand that inherits from the Restaurant class you wrote in Exercise 9-1 or Exercise 9-4. 
Either version of the class will work; just pick the one you like better. Add an attribute called flavors that stores a list of ice cream flavors. 
Write a method that displays these flavors. Create an instance of IceCreamStand, and call this method. 

'''

#Definiamo una classe Restaurant, dove andiamo a creare un costruttore con all'interno due variabili: 'RESTAURANT_NAME' e 'CUISINE_TYPE'
class Restaurant:
  
  def __init__(self, restaurant_name:str, cuisine_type:str, number_served:int = 0) -> str:
      
     #Successivamente andiamo a richiamare il parametro self.nome-varibile =  nome_variabile 
      self.restaurant_name = restaurant_name
      self.cuisine_type = cuisine_type
      self.number_served = number_served

 #Creiamo un metodo che andrà a stmpare il nome del ristorante e la tipologia  
  def describe_restaurant(self):
     print("\n--------- DESCRIZIONE RISTORANTE / NEGOZIO ----------- \n")
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

        print("\nNon puoi diminuire ulteriormente il numero !")
        
#Andiamo a creare un'ulteriore classe che sarà eriditata da Restaurant, andiamo a richiamare i parametri utili e aggiungiamo anche un nuovo valore, quello di gusti
class IceCreamStand (Restaurant):
   
   def __init__(self,restaurant_name:str, cuisine_type:str, flavours:list) -> str|list:
   #Indichiamo che questi'utlimi appartengono alla superclasse Restaurant 
    super().__init__(restaurant_name, cuisine_type)
    self.flavours = flavours


    #Andiamo a definire una funzione che mostra in output i gusti dei vari gelati inseriti da INPUT
   def pick_flavours(self):
      
     print("\n--------- GELATERIA ESERCIZIO 9_6------------ \n")
     
     print(f"\nThe flavour you have picked up is:\n ")

     for flavour in self.flavours:
         
         print(f"-{flavour}\n")




#Creo una variabile chiamata ristorante, richiamando la classe e assegnando le varie variabili
ristorante: Restaurant =  Restaurant("Kebab Damasco", "Kebab - Cucina Araba")
gusto : IceCreamStand = IceCreamStand ("Gelateria da Pino", "Gelateria", ["Strawbarry", "Banana", "Coconut"] )

#Richiamiamo le funzioni e nelle ultime due create come richiesto dall'esercizio indichiamo il parametro il numero che sarà pari a 0 e 1 per gli incremento.
ristorante.describe_restaurant()
ristorante.open_restaurant()
ristorante.set_number_served(0)
ristorante.increment_number_served(1)

#Per l'ultima classe eriditata da Restaurant, andiamo a richiamare le relative funzioni
gusto.describe_restaurant()
gusto.pick_flavours()
