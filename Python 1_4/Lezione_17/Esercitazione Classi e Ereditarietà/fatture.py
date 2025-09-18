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

from dottore import Dottore
from paziente import Paziente

class Fattura:

    def __init__(self,patient:list[Paziente],doctor:Dottore) -> None:

        self.patient = patient
        self.doctor = doctor

        if doctor.isAValidDoctor():

            self.fatture:int = len(patient)
            self.salary:float = self.getSalary()
        else:

            self.patient = None
            self.doctor = None
            self.fatture = None
            self.salary = None

            print("ATTENZIONE ! Non è possibile creare la classe FATTURA poichè il dottore non è valido !")
    


    def getSalary(self)-> int:

        if self.doctor is not None and self.patient is not None:

            self.salary = self.doctor.getParcel() * len(self.patient)
            return self.salary
        
        else:
            return 0
        
    
    def getFatture(self) -> int:
        
        if self.patient is not None:

            self.fatture = len(self.patient)
            return self.fatture
        
        else:
            return 0
    
    def addPatient(self,newPatient:str) -> None:

        if self.patient is not None:
            
            self.patient.append(newPatient)
            self.getFatture()
            self.getSalary()
            print(f"Alla lista del Dottor {self.doctor.getLastName} è stato aggiunto il paziente {Paziente.getIdCode}")
        
        print(f"ATTENZIONE ! Alla lista del Dottor {self.doctor.getLastName} NON è stato aggiunto nessun paziente, dato che risulta None/vuoto!")

    def removePatient(self, idCode:int) -> str:

        if self.patient is not None:

            for paziente in self.patient:

             if paziente.getIdCode() == idCode:

                self.patient.remove(paziente)
                self.getFatture()
                self.getSalary()

                print(f"Alla lista del Dottor {self.doctor.getName} {self.doctor.getLastName} è stato RIMOSSO il paziente {idCode}")
                return 
            print("ATTENZIONE ! non corrrisponde nessun Paziente all'id del codice inserito")




'''DRIVER PROGRAMM, per testare le funzionalità della classe Fatture'''



primoDottore = Dottore("Mario", "Rossi", "Cardiologo", 100.0)
primoDottore.setAge(45)


pazienteUno = Paziente("Luca", "Bianchi", "P001")
pazienteDue = Paziente("Anna", "Verdi", "P002")

fatturaMedico = Fattura([pazienteUno, pazienteDue], primoDottore)

print("\n TEST FATTURA ")

print("Numero fatture iniziali:", fatturaMedico.getFatture())
print("Salario iniziale:", fatturaMedico.getSalary())


#Per testare l'aggiunta e la rimozione, creiamo un TERZO PAZIENTE per le operazioni in "FatturaMedico"

terzoPaziente = Paziente("Marco", "Neri", "P003")

fatturaMedico.addPatient(terzoPaziente)

print("Numero fatture dopo aggiunta:", fatturaMedico.getFatture())
print("Salario dopo aggiunta:", fatturaMedico.getSalary())


fatturaMedico.removePatient("P001")

print("Numero fatture dopo rimozione:", fatturaMedico.getFatture())
print("Salario dopo rimozione:", fatturaMedico.getSalary())
