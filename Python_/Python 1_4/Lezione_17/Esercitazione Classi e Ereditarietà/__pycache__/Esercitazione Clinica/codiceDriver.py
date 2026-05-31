'''
Scrivere, infine, il codice driver che gestisca due dottori e due liste di pazienti. La prima lista di pazienti deve contenere 3 pazienti, mentre la seconda 1 solo paziente.

    Impostare l'età di ogni medico, affinché i due medici risultino validi!
    Il primo medico e il secondo medico si presentano, richiamando il rispettivo metodo doctorGreet().
    Creare un oggetto fattura chiamato fattura1. Alla fattura 1 devono essere associati il dottore_1 e la lista di 3 pazienti.
    Creare un oggetto fattura chiamato fattura2. Alla fattura 2 devono essere associati il dottore_2 e la lista di un solo paziente.
    Stampare in output il salario di ogni singolo dottore. Ad esempio:

      "Salario Dottore1: ... euro!
       Salario Dottore2: ... euro!"

    Rimuovere un paziente dalla lista dei pazienti del dottore 1 ed inserire tale paziente nella lista del dottore 2.
    Stampare in output il salario di ogni dottore.
    Stampare in output il guadagno totale incassato dall'ospedale. Il guadagno totale viene calcolato sommando i guadagni di ogni dottore. Esempio:

"In totale, l'ospedale ha incassato: tot euro!"

'''

from paziente import Paziente
from dottore import Dottore
from fatture import Fattura

#Procediamo alla creazione dei due medici per l'ospedale
primoMedico = Dottore("Mario", "Rossi", "Chirurgo", "CA345")
Dottore.setAge(48)

secondoMedico = Dottore("Francesco", "Bianchi", "Medico","FG543")
Dottore.setAge(31)

#Successivamente andiamo alla creazione dei primi 3 pazienti che saranno utenti del PRIMO MEDICO, aggiungendoli nella lista del PRIMO MEDICO
primoPaziente = Paziente("Luca", "Verdi", "ID001")
primoPaziente.setAge(35)

secondoPaziente = Paziente("Anna", "Neri", "ID002")
secondoPaziente.setAge(28)

terzoPaziente = Paziente("Marco", "Gialli", "ID003")
terzoPaziente.setAge(50)

listaPazientiPrimoMedico = [primoPaziente,secondoPaziente,terzoPaziente]


#Infine, andiamo alla creazione del ultimno paziente che sarà utente del SECONDO MEDICO, aggiungendolo nella lista del SECONDO MEDICO
quartoPaziente = Paziente("Claudia", "Bianchi", "ID004")
quartoPaziente.setAge(22)

listaPazientiSecondoMedico = [quartoPaziente]

#Presentiamo i medici con il metodo greet, come richiesto dalla consegna
print("\n   PRESENTAZIONE MEDICI  ")
primoMedico.doctorGreet()
secondoMedico.doctorGreet()

#Andiamo con la FATTURIZZAZIONE dei due MEDICI
primaFattura = Fattura(listaPazientiPrimoMedico, primoMedico)
secondaFattura = Fattura(listaPazientiSecondoMedico, secondoMedico)

#Stampiamo i salari per i due MEDICI
print("\n  SALARI INIZIALI  ")
print(f"Salario del PRIMO MEDICO: {primaFattura.getSalary()} euro!")
print(f"Salario del SECONDO MEDICO: {secondaFattura.getSalary()} euro!")


#Andiamo con la rimozione del SECONDO PAZEINTE del PRIMO MEDICO procedendo all'inserimento della lista del SECONDO MEDICO
primaFattura.removePatient("ID002")
secondaFattura.addPatient(secondoPaziente)


#Infine, ristampiamo i salari AGGIORNATI dopo la "sostituzione" del PAZIENTE
print("\n  SALARI DOPO SPOSTAMENTO ")
print(f"Salario del PRIMO MEDICO: {primaFattura.getSalary()} euro!")
print(f"Salario del SECONDO MEDICO: {secondaFattura.getSalary()} euro!")


#In conclusione, andiamo a calcolare il GUADAGNO OSPEDALIERO con le due FATTURE dei relativi medici
guadagnoComplessivoOspedaliero = primaFattura.getSalary() + secondaFattura.getSalary()
print(f"\nIn TOTALE, l'ospedale ha incassato {guadagnoComplessivoOspedaliero} EURO !")
