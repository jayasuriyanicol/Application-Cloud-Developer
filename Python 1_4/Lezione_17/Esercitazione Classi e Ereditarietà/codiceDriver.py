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
from persona import Persona
from fatture import Fattura



primoMedico = Dottore("Mario", "Rossi", "Chirurgo", "CA345")
Dottore.setAge(30)

secondoMedico = Dottore("Francesco", "Bianchi", "Medico")
