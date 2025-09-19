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

    def __init__(self, first_name: str, last_name: str) -> None:

        try:
            self.__first_name = str(first_name)

        except ValueError:

            print("ATTENZIONE ! Il nome inserito non è una STRINGA!")
            self.__first_name = None

        try:

            self.__last_name = str(last_name)

        except ValueError:

            print("ATTENZIONE !Il cognome inserito non è una STRINGA!")
            self.__last_name = None

        
        if self.__first_name is not None and self.__last_name is not None:

            self.__eta = 0
        
        else:
            self.__eta = None


    def setName(self, first_name: str) -> None:

        try:

            self.__first_name = str(first_name)
        
        except ValueError:

            print("ATTENZIONE ! Il nome inserito non è una STRINGA!")

    def setLastName(self, last_name: str) -> None:

        try:

            self.__last_name = str(last_name)

        except ValueError:

            print("ATTENZIONE ! Il cognome inserito non è una STRINGA!")

    def setAge(self, age: int) -> None:

        try:

            self.__eta = int(age)

        except ValueError:

            print("ATTENZIONE ! L'età deve essere un numero INTERO!")

    def getName(self) -> str:

        return self.__first_name

    def getLastName(self) -> str:

        return self.__last_name

    def getAge(self) -> int:

        return self.__eta

    def greet(self) -> None:

        print(f"\nCiao, sono {self.__first_name} {self.__last_name}! Ho {self.__eta} anni!")


'''DRIVER PROGRAMM, per testare se la classe lavora correttamente'''

persona = Persona("Cristiano", "Coccia")

persona.setName("Cristiano")
persona.setLastName("Coccia")
persona.setAge(21)

print(persona.getName())
print(persona.getLastName())
print(persona.getAge())
persona.greet()
