'''
Creazione della classe e costruttore PERSONA, spiegazione parte della definizione e creazione della classe e del costruttore
'''


'''
Creazione di una classe PERSONA:

Di una persona dobbiamo sapere delle infromazioni. Queste informazioni vengono chimate attributi (della classe Python)
Le informazioni saranno:
- NOME
- COGNOME
- ETÀ 

Come possiamo rappresentarlo in Python?

self.name:str (attributo di tipo stringa)
self.lastname:str (attributo di tipo stringa)
self.age:int (attributo di tipo int)
'''
'''class Persona:
#Andiamo a creare il costruttore
 def __init__ (self,name:str, last_name:str, age:int):
  
  self.name = name
  self.last_name = last_name
  self.age = age

 def displayData (self) -> None:
  print(f"Nome: {self.name}\nCognome:{self.last_name}\nEtà:{self.age}") '''


#Andiamo a creare una classe persona, pero in questo caso senza passarli come parametri, ma direttamente dentro la classe e non dentro le parentesi
class Persona:
    def __init__(self):
        self.name:str = ""
        self.last_name:str = ""
        self.age:int = 0

    #Creiamo una funzione che ci permette di avere l'anagrafica della persona in questione, con NOME,COGNOME ed ETÀ.
    def displayData (self) -> None:
        print(f"Nome: {self.name}\nCognome: {self.last_name}\nEtà: {self.age}") 

 
    '''                                         | ANDIAMO A CREARE I METODI GET E SET |   
                                                                                                                                                                        '''
    
    #Definiamo una funzione che mi consenta di impostare il valore di self.name 
    def setName(self, name:str ) -> None:
        self.name = name 

   #Definiamo una funzione che mi consenta di impostare il valore self.last_name
    def setLastName(self,last_name:str) -> None: 
        self.last_name = last_name

   #Definiamo una funzione che mi consenta di impostare il valore di self.age.
    def setAge(self, age:int)-> None:

        if age < 0 or age > 130:

         self.age = 0
        else:
            self.age = age

   #Definiamo una funzione che mi consenta di ritornare il valore di self.name 
    def getName(self) -> str:
        return self.name
    
   #Analogamente posso definire una funzione che mi permetta di ritornare il valore di self.last_name 
    def getLastName(self) -> str:

        return self.last_name
    
   #Definiamo una funzione che mi consenta di ritornare il valore di self.age 
    def getAge(self) -> int:
        return self.age