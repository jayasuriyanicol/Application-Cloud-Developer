'''
Creare un file chiamato "persona.py". In tale file, definire una classe chiamata Persona. Tale classe deve avere due attributi privati di tipo String, uno per il nome ed uno per il cognome, ed un attributo privato di tipo int per l'età.
- La classe Persona deve avere i seguenti metodi:

    init(first_name, last_name). Tale metodo, deve verificare che first_name, last_name siano stringhe; in caso negativo, impostare a None l'attributo che non risulta essere una stringa, stampando un messaggio di errore, ad esempio, "Il nome inserito non è una stringa!". Se first_name e last_name sono due stringhe, assegnare 0 all'attributo relativo all'età di una persona; se first_name e last_name non sono due stringhe, allora assegnare None all'età.
    setName(first_name): consente di impostare il nome di una persona, modificando il valore del relativo attributo. Il valore viene modificato se e solo se viene passata al metodo una stringa. In caso contrario, stampare un messaggio di errore, ad esempio "Il nome inserito non è una stringa!".
    setLastName(last_name): consente di impostare il cognome di una persona, modificando il valore del relativo attributo. Il valore viene modificato se e solo se viene passata al metodo una stringa. In caso contrario, stampare un messaggio di errore, ad esempio "Il cognome inserito non è una stringa!".
    setAge(age): consente di impostare l'età di una persona, modificando il valore del relativo attributo. Il valore viene modificato se e solo se viene passato al metodo un numero intero. In caso contrario, stampare un messaggio di errore, ad esempio "L'età deve essere un numero intero!".
    getName(): consente di ritornare il nome di una persona.
    getLastname(): consente di ritornare il cognome di una persona.
    getAge(): consente di ritornare l'età di una persona.
    greet(): stampa il seguente saluto "Ciao, sono {nome} {cognome}! Ho {età} anni!"

'''

class Persona:


    def __init__(self,first_name:str, last_name:str) -> None:

        self.first_name = first_name
        self.last_name = last_name
        self.eta = 0

        try:
            __first_name = str(first_name)
            __last_name = str(last_name)
            __eta = int(self.eta)

        except ValueError:
            print("ATTENZIONE ! il valore inserito non è una valore stringa !")
            __first_name = None
            __last_name = None
            __eta = None

    def setName(self,first_name:str) -> None:
        
        try:
          self.first_name = str(first_name)

        except ValueError:

            print("ATTENZIONE ! il valore inserito per il NOME non è una stringa !")

    
    def setLastName(self,last_name:str) -> None:

        try:
            self.last_name = str(last_name)

        except ValueError:

            print("ATTENZIONE ! il valore inserito per il COGNOME non è una stringa !") 

    
    def setAge(self, age:int) -> None:

        try:

            self.age = int(age)

        except ValueError:

            print("ATTENZIONE ! Il valore inserito per l'età non è un valore intero !")
    
    def getName(self) -> str:

        return self.first_name   

    def getLastName(self) -> str:

        return self.last_name     
    
    def getAge(self) -> str:

        return self.age
    
    def greet(self) -> str:

        print(f"\nCiao, sono {self.first_name} {self.last_name} ! Ho {self.eta} anni !")
        
    
'''DRIVER PROGRAMM'''


'''PRIMO CASO'''

persona = Persona("Cristiano", "Coccia")


print(persona.setName ("Cristiano"))
print(persona.setLastName("Coccia"))
print(persona.setAge(21))
print(persona.getName())
print(persona.getLastName())
print(persona.getAge())
print(persona.greet())


