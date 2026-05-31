'''
Mostri Contro Alieni
Creatura con le seguenti proprietà:
- attributi: nome (di tipo stringa, per indicare il nome della creatura)
- metodi: tutti i metodi standard, ovvero __init__, setter, getter e __str__
In particolare:

    il metodo setNome() deve fare un controllo se il nome inserito sia una stringa valida. In caso contrario, impostare il nome della creatura con il valore di "Creatura Generica".

    il metodo __str__ deve mostrare in output: "Creatura: nome creatura"



Alieno (che eredita da Creatura) con le seguenti proprietà:
- attributi: matricola (di tipo intero positivo), munizioni (una lista di 15 interi positivi)
- metodi: setter, getter, __str__
In particolare:

    il metodo setMatricola() (privato), non riceve argomenti in input e deve inizializzare l'attributo matricola con un numero intero positivo casuale tra 10000 e 90000.

Per generare un numero intero casuale nell'intervallo [a, b] (ovvero estremi inclusi), importare il modulo random e usare la funzione randint(a,b) del modulo;
 

    il metodo setMunizioni() (privato) non riceve argomenti in input e deve inizializzare l'attributo munizioni con una lista di 15 numeri interi positivi i cui elementi sono numeri della sequenza 0, 1, 4, 9, 16, 25, 36, 49, ... Usare le list comprehension.

    il metodo __init__ deve inizializzare la superclasse, inizializzare la matricola e le munizioni.

Inoltre, i nomi di tutti gli alieni devono essere "Robot-" + matricola (ad esempio, "Robot-16326", scritto con la R maiuscola).


Pertanto, nel metodo __init__ impostare il nome dell'Alieno come richiesto, effettuando opportuni controlli. Nel caso in cui il nome dell'alieno non sia conforme, mostrare il seguente messaggio e re-impostare il nome in modo corretto: "Attenzione! Tutti gli Alieni devono avere il nome "Robot" seguito dal numero di matricola! Reimpostazione nome Alieno in Corso!".

    il metodo __str__ deve mostrare in output: "Alieno: nome alieno" (ad esempio: Alieno: Robot-16326)


Mostro ( che eredita da Creatura) con le seguenti proprietà:
- attributi: urlo_vittoria (di tipo stringa), gemito_sconfitta (di tipo stringa), assalto (una lista di 15 interi positivi)
- metodi: setter, getter, __str__
In particolare:

    il metodo __init__ deve ricevere il nome del mostro, il suo urlo della vittoria ed il suo gemito sconfitta. Inoltre, deve inizializzare assalto.

    il metodo setAssalto() (privato) non riceve argomenti in input e deve inizializzare una lista di 15 numeri interi positivi casuali tra 1 e 100, estremi inclusi, tutti diversi tra loro.

    i metodi setVittoria(vittoria: str) e setSconfitta(sconfitta: str) (privati), devono controllare se i valori di vittoria e sconfitta siano valori validi. In caso contrario, devono impostare gli attributi urlo_vittoria a "GRAAAHHH" e gemito sconfitta a "Uuurghhh".

    ad esempio, se il nome del mostro è "godzilla", il metodo __str__ dovrà mostrare a schermo: Mostro: gOdZiLlA, ovvero il nome del mostro scritto con i caratteri alternati minuscolo-maiuscolo.



All'interno del file ReP3_inizialeNome_Cognome (fuori dalla classi) definire le seguenti funzioni:

    pariUguali(a: list[int], b: list[int]). Questo metodo riceve in input due liste a e b di interi positivi e deve restituire una lista c.

Ogni elementi della lista c deve essere uguale a:
- 1 se l'elemento i-esimo di a e l'elemento i-esimo di b sono sono entrambi pari
- 0 altrimenti

    combattimento(a: Alieno, m: Mostro). Questo metodo riceve in input un oggetto della classe Alieno ed un oggetto della classe Mostro. Il metodo deve controllare la validità di a e la validità di m. Se a non è un Alieno o se M non è un Mostro, il combattimento deve essere interrotto, mostrare un opportuno messaggio e ritornare None. Altrimenti, se a e m sono oggetti validi, il metodo deve simulare il combattimento tra Mostro e Alieno, restituendo la creatura vincitrice. Il combattimento consiste nell'applicare la funzione pariUguali() alle munizioni dell'Alieno e all'assalto del Mostro. Se la lista prodotta in output dal pariUguali() ha più di 4 elementi con valore 1, allora il vincitore è il mostro. Altrimenti, il vincitore è l'alieno. Se vince il mostro, sullo schermo viene stampato per 3 volte l'urlo della vittoria, altrimenti viene stampato il gemito della sconfitta.


    proclamaVincitore(c: Creatura). Questo metodo stampa a schermo se hanno vinto gli alieni o i mostri ( a seconda dell'oggetto c) e , mostra il vincitore all'interno di un rettangolo con contorno di * come nell'esempio.


*****************************

*                                         *

*    Alieno: Robot-25855    *

*                                         *

*****************************

*************************

*                                   *

*    Mostro: gOrThOr    *

*                                    *

*************************

Suggerimento: stampare prima il rettangolo vuoto, le cui dimensioni sono altezza 5 e lunghezza = lunghezza di c.__str__() + 10
poi, modificare il codice in questo modo:
quando si arriva alla riga centrale del rettangolo (ovvero i=2), si deve stampare il nome del vincitore al centro del rettangolo.
per far questo si deve imporre la condizione i=2 e j =5. Se la condizione è verificata, stampare la creatura c (print(c), end=""), stampare 5 spazi vuoti e un * (print(     *), end="") e poi interrompere l'iterazione corrente.


Infine,

    Scrivere nel metodo main, un codice Python che

- Inizializza un mostro e un alieno e stampa i dati corrispondenti sullo schermo.
- Esegue un combattimento tra i due oggetti creati.
- Proclama il vincitore.


Esempio di Output:

Alieno: Robot-41119
Munizioni: [0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196]


Mostro: gOrThOr
Assalto: [13, 23, 28, 80, 50, 56, 33, 55, 15, 20, 15, 94, 42, 16, 46]

Combattimento

GRAAAHHH
GRAAAHHH
GRAAAHHH


I Mostri hanno vinto!

*************************

*                                    *

*    Mostro: gOrThOr    *

*                                    *

*************************


'''

from random import randint


#Creazione della classe Creatura

___nome:str

class Creatura:


    def __init__(self, nome:str = "Creatura Generica") -> None:

        if isinstance(nome, str):

            self.___nome = nome

        else:
            self.___nome = "Creatura Generica"


    def setNome(self, nome:str = "Creatura Generica") -> None:

        if isinstance(nome, str):
            
            self.___nome = nome

        else:
            self.___nome = "Creatura Generica"


    def getNome(self) -> str:

        return self.___nome


    def __str__(self) -> str:

        return f"Creatura: {self.___nome}"



#Creazione della Sottoclasse Alieno -> Creatura (Superclasse)

class Alieno(Creatura):

    ___matricola:str
    ___munizioni:str

    #Richiamo due volte l'init: uno per la superclasse e un'altro per la sua sottoclasse, dato che messi insieme generano conflitto 
    def __init__(self,nome) -> None:
        super().__init__(nome)

    def __init__(self) -> None:

        self.___matricola = randint(10000, 90000)
        self.___munizioni = []

        for elemento in range(15):

            self.___munizioni.append(elemento * elemento)

        nome = "Robot-" + str(self.___matricola)

        Creatura.__init__(self, nome)



    def getMatricola(self) -> str:

        return self.___matricola

    def getMunizioni(self) -> str:

        return self.___munizioni

    def __str__(self) -> str:

        return f"Alieno: {self.getNome()}"
    

#Creazione della sottoclasse Mostro -> Creatura (Superclassee)


class Mostro(Creatura):


    ___urlo_vittoria:str
    ___gemito_sconfitta:str
    ___assalto : list[int] 


    def __init__(self, nome:str,urlo_vittoria: str, gemito_sconfitta: str) -> str:
        super().__init__(nome)

        self.___urlo_vittoria = urlo_vittoria
        self.___gemito_sconfitta = gemito_sconfitta
        self.___assalto = [] 


        if isinstance(nome, str):

            self.___nome = nome
        
        else:

            self.___nome = "Creatura Generica"


        if isinstance(urlo_vittoria, str):

            self.___urlo_vittoria = urlo_vittoria

        else:

            self.___urlo_vittoria = "GRAAAHHH"

        if isinstance(gemito_sconfitta, str):

            self.___gemito_sconfitta = gemito_sconfitta

        else:

            self.___gemito_sconfitta = "Uuurghhh"

        self.___assalto = []

      
        while len(self.___assalto) < 15:

            num = randint(1, 100)

            if num not in self.___assalto:

                self.___assalto.append(num)



    def getAssalto(self) -> str:

        return self.___assalto
    

    def getUrloVittoria(self) -> str:

        return self.___urlo_vittoria
    

    def getGemitoSconfitta(self) -> str:

        return self.___gemito_sconfitta
    

    #Nel metodo __str__ vado a iterare sul nome e n base all'indice del carattere verifico se esso è pari o dispari quindi => pari = minuscolo o dispari = MAIUSCOLO !
    def __str__(self) -> str:
        nome = self.___nome
        nome_alternato = ""
        for i in range(len(nome)):
            if i % 2 == 0:
                nome_alternato += nome[i].lower()
            else:
                nome_alternato += nome[i].upper()
        return "Mostro: " + nome_alternato
    

'''------------------------------------------------------------ FINE CLASSE CREATURA - con le sue relative sottoclassi -----------------------------------------------------------------'''

def pariUguali(a: list[int], b: list[int]) -> list[int]:

    listaLetteraA:list[int]  = a
    listaLetteraB:list[int]  = b
    listaLetteraC = []

    for carattere in range(15):

        if listaLetteraA[carattere] % 2 == 0 and listaLetteraB[carattere] % 2 == 0:

            listaLetteraC.append(1)

        else:
            listaLetteraC.append(0)

    return listaLetteraC





def combattimento(a: Alieno, m: Mostro) -> str:

    if not isinstance(a, Alieno) or not isinstance(m, Mostro):

        print("Oggetti non validi per il combattimento!")

        return None

    listaMunizioniAssalto = pariUguali(a.getMunizioni(), m.getAssalto())

    contatore = 0

    for elemento in listaMunizioniAssalto:
        if elemento == 1:
            contatore += 1

    if contatore >= 4:
        print(m.getUrloVittoria()* 3)
        return m
    
    else:
        print(m.getGemitoSconfitta() * 3)
        return a




def proclamaVincitore(c: Creatura) -> str:
    nomeVincitore = str(c)
    lunghezzaNomeVincitore = len(nomeVincitore) + 10

    for elemento in range(5):
        if elemento == 2:
            print("*" + " " * 5 + nomeVincitore + " " * (lunghezzaNomeVincitore - 6 - len(nomeVincitore)) + "*")
        else:
            print("*" + " " * (lunghezzaNomeVincitore - 2) + "*")
    print("*" * lunghezzaNomeVincitore)



'''ESEGUIAMO IL CODICE MAIN - per verificare la bontà della nostra soluzione'''


def main():

    a = Alieno()
    m = Mostro("gorthor", "GRAAAHHH", "Uuurghhh")

    print(f"\n{a}\nMunizioni: {a.getMunizioni()}\n\n" )
    print(f"\n{m}\nMunizioni: {m.getAssalto()}\n\n" )

    print("Combattimento:\n")
    vincitore = combattimento(a, m)

    if vincitore is not None:
        if isinstance(vincitore, Alieno):
            print("\nGli Alieni hanno vinto!")
        else:
            print("\nI Mostri hanno vinto!\n")
        proclamaVincitore(vincitore)




'''ESEGUIAMO IL DRIVER PROGRAM - proveninete dal programma main che abbiamo stilato'''


if __name__ == "__main__":
    main()


