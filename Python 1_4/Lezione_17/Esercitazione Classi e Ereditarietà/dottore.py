'''
Creare un file chiamato "dottore.py".
In tale file, definire una classe chiamata Dottore. Si derivi Dottore dalla classe Persona.

Un dottore ha un nome, un cognome, un età, definiti dalla classe Persona, una specializzazione descritta tramite una stringa (ad esempio, Pediatra, Ostetrico, Medico Generale), ed una parcella per le visite in studio (si usi il tipo float). Gli attributi della classe dottore devono essere anch'essi privati.

- Definire i seguenti metodi:

    costruttore della classe Dottore, il quale richiede in input la specializzazione (specialization) di un dottore e la sua parcella (parcel). Tale metodo deve controllare che specialization sia una stringa e che parcel sia un float, altrimenti assegna None all'attributo che non verifica la condizione richiesta, mostrando un messaggio di errore, ad esempio, "La parcella inserita non è un float!".
    setSpecialization(specialization): consente di impostare la specializzazione di un dottore, modificando il valore del relativo attributo. Il valore viene modificato se e solo se viene passata al metodo una stringa. In caso contrario, stamapre un messaggio di errore, ad esempio "La specializzazione inserita non è una stringa!".
    setParcel(parcel): consente di impostare la parcella di un dottore, modificando il valore del relativo attributo. Il valore viene modificato se e solo se viene passato al metodo un float. In caso contrario, stamapre un messaggio di errore, ad esempio "La parcella inserita non è un float!".
    getSpecialization(): consente di ritornare la specializzazione del dottore.
    getParcel(): consente di ritornare la parcella del dottore.
    isAValidDoctor(): stabilisce se un dottore è un dottore valido; un dottore è valido se e solo se ha più di 30 anni, in quanto ha avuto il tempo necessario di compiere i suoi studi in medicina. Stampare "Doctor nome e cognome is valid!", se il dottore risulta valido. In caso contrario, stampare "Doctor nome e cognome is not valid!".
    doctorGreet():tale metodo richiama la funzione greet() della classe Persona. Poi, stampa il seguente saluto "Sono un medico {specializzazione}"
'''


from persona import Persona

class Dottore(Persona):

    def __init__(self, first_name: str, last_name: str, specialization: str, parcel: float):

        super().__init__(first_name, last_name)

        try:
            self.__specialization = str(specialization)

        except ValueError:

            print("ATTENZIONE ! la SPECIALIZZAZIONE non è una STRINGA!")
            self.__specialization = None

        try:
            self.__parcel = float(parcel)

        except ValueError:

            print("ATTENZIONE ! la PARCELLA non è un FLOAT!")
            self.__parcel = None


    def setSpecialization(self, specialization: str) -> None:

        try:
            self.__specialization = str(specialization)

        except ValueError:

            print("ATTENZIONE ! il valore inserito per la SPECIALIZZAZIONE non è una STRINGA!")



    def setParcel(self, parcel: float) -> None:

        try:
            self.__parcel = float(parcel)
        except ValueError:

            print("ATTENZIONE ! la PARCELLA non è un FLOAT!")


    def getSpecialization(self) -> str:

        return self.__specialization
    

    def getParcel(self) -> float:

        return self.__parcel
    

    def isAValidDoctor(self) -> None:

        if self.getAge() is not None and self.getAge() >= 30:

            print(f"Doctor {self.getName()} {self.getLastName()} is VALID!")

        else:
            print(f"Doctor {self.getName()} {self.getLastName()} is NOT VALID!")


    def doctorGreet(self) -> None:

        self.greet() 
        
        print(f"Sono un medico {self.__specialization}")




'''DRIVER PROGRAMM, per testare le funzionalità della classe Dottore'''

dottore = Dottore("Nicol", "Jayasuriya", "Chirurgo", 2050.00)

dottore.isAValidDoctor()
dottore.doctorGreet()
print(f"Specializzazione: {dottore.getSpecialization()}")
print(f"Parcella: {dottore.getParcel():.2f} €")
