'''

Creare un file chiamato "fatture.py".
In tale file, creare una classe chiamata Fattura.

- Definire i seguenti metodi:

    init(patient,doctor): deve avere come input una lista di pazienti ed un dottore. Tale metodo deve verificare se il dottore può esercitare la professione, richiamando la funzione isAValidDoctor(). In caso affermativo assegnare all'attributo fatture (di tipo intero) il numero di pazienti che ha il dottore, mentre assegnare 0 all'attributo salary (di tipo int).  In caso contrario, assegnare il valore None a tutti i 4 gli attributi della classe e stampare un messaggio di errore, come, ad esempio: "Non è possibile creare la classe fattura poichè il dottore non è valido!".
    getSalary(): deve ritornare il salario guadagnato dal dottore. Il salario gudaganto viene calcolato moltiplicando la parcella del dottore per il numero di pazienti.
    getFatture(): deve assegnare all'attributo fatture il numero di pazienti (in modo che sia sempre aggiornato) che ha il dottore e ritornare il suo valore.
    addPatient(newPatient): consente di aggiungere un paziente alla lista di pazienti di un dottore, aggiornando poi il numero di fatture ed il salario, richiamando il metodo getFatture() e getSalary().  Stampare "Alla lista del Dottor cognome è stato aggiunto il paziente {codice_identificativo}"
    removePatient(idCode): consente di rimuovere un paziente alla lista di pazienti di un dottore ricevendo in input il codice identificativo del paziente da rimuovere, aggiornando poi il numero di fatture e il salario, richiamando il metodo get Fatture() e getSalary(). Stampare "Alla lista del Dottor cognome è stato rimosso il paziente {codice_identificativo}".


'''

from dottore import *
from paziente import *
class Fattura:

    def __init__(self,patient:list[Paziente],doctor:Dottore) -> None:

        self.patient = patient
        self.doctor = doctor

        if doctor.isAValidDoctor():

            self.fatture:int = len(patient)
            self.salary:int = 0
        else:

            self.patient = None
            self.doctor = None
            self.fatture = None
            self.doctor = None

            print("ATTENZIONE ! Non è possibile creare la classe FATTURA poichè il dottore non è valido !")
    


    def getSalary(self)-> int:

        return self.salary
    
    def getFatture(self) -> int:

        return self.fatture
    
    def addPatient(self,newPatient:str) -> None:

        self.fatture.add(newPatient)

        self.getFatture(newPatient)
        self.getSalary()

        print(f"Alla lista del Dottor cognome è stato aggiunto il paziente {Paziente.getIdCode}")
    

    def removePatient(self, idCode:int) -> str:

        for elemento in self.patient:

            if elemento == idCode:

                self.fatture.remove(paziente)

                print(f"Alla lista del Dottor {Persona.first_name} {Persona.last_name} è stato rimosso il paziente {Paziente.getIdCode}")
            else:
                print("ATTENZIONE ! non corrrisponde nessun Paziente all'id del codice inserito")