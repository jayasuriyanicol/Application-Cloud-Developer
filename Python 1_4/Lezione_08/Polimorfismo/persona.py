
'''LEZIONE 10/04/2025'''

'''
class Persona:

    def __init__(self):
        self.nome:str = " "
        self.cognome:str = " "
        self.età:int = 0


    def mostraSchermo (self):

        print(f"NOME: {self.nome} COGNOME: {self.cognome} ETÀ: {self.età}")



   #Adesso andiamo a creare i metodi GET,SET , __str__ , __call__

    def getName(self)-> str:

        return self.nome
    
    def getSurname(self) -> str:

        return self.cognome
    
    def getAge(self)-> str:

        return self.età


    def setName(self, nome:str) -> None:

        self.nome = nome 


    def setSurname(self, cognome:str) -> None:

        self.cognome = cognome

    
    def setAge(self, età:int) -> None:

        if età < 0 or età >130:

            self.età = 0 

        else:

            self.età = età

    def __str__(self):

        return f"La persona {self.nome} {self.cognome} di età {self.età} e attesa in sala di attesa !"
    




    def __call__(self):

        return f"La persona {self.nome} {self.cognome} ha età {self.età}"

'''


class Persona:

    '''
    self.name:str (attributo di  tipo stringa)
    self.lastname:str (Attributo di tipo stringa)
    self.age:int (Attributo di tipo int)    
    '''


   #Inizializzare un oggetto della classe Persona
    def __init__(self, name:str, lastname:str,age:int ) :
          
        self.setName(name)
        self.setLastname(lastname)
        self.setAge(age)


    '''Metodo speciale che ritorna una stringa e ch viene chiamata automaticamente quando si usa l'istruzione print (obj),
       dove obj è un oggetto della classe Persona 
    ''' 
    

   #Funzione che mi mostri in output i dati relativi ad una persona
    def __str__(self) -> str:
        return f"Nome: {self.name}\nCognome:{self.lastname}\nEtà:{self.age}"
    



    '''Metodo __call__ mi consente di usare l'oggetto della classe Persona istanziato come una funzione, 
       quindi, un oggetto della classe Persona si comporta come una funzione
    '''
    def __call__(self):
        return f"Nome: {self.name}\nCognome:{self.lastname}\nEtà:{self.age}"



   #METODI SETTER

   #Funzione che mi consenta di impostare il valore di self.name, con "if name" -> vediamo se la stringa non è vuota
    def setName(self, name:str) -> None:
       if name:
           self.name = name
       else:
           print("Error ! Il nome non può essere una stringa vuota")
    
    #Funzione che mi consenta di impostare il valore di self.lastname
    def setLastname(self, lastname:str) -> None:
       if lastname:
           self.lastname = lastname
       else:
           print("Error ! Il cognome non può essere una stringa vuota")

    #Funzione che mi consenta di impostare il valore di self.age
    def setAge(self, age:str) -> None:
       if age < 0 or age > 130:
           self.name = 0
       else:
           self.age = age
     


  #METODI GETTER

    #Funzione che mi consenta di ritornare il valore diu self.name
    def getName(self) -> str:
        return self.name   

    #Funzione che mi consenta di ritornare il valore diu self.lastname
    def getLastname(self) -> str:
        return self.lastname  
    
    #Funzione che mi consenta di ritornare il valore diu self.age
    def getAge(self) -> str:
        return self.age  
    
   #Metodo speak() per la classe Persona che consente di sumularer un saluto
    def speak(self) -> None:
        print(f"\nHello my name is {self.getName()}!\n") 






     






         



     
    

'''
class Persona:
    def __init__(self):
        self.name:str = ""
        self.last_name:str = ""
        self.age:int = 0

    #Creiamo una funzione che ci permette di avere l'anagrafica della persona in questione, con NOME,COGNOME ed ETÀ.
    def displayData (self) -> None:
        print(f"Nome: {self.name}\nCognome: {self.last_name}\nEtà: {self.age}") 

 
    
                                                                                                                            
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

'''