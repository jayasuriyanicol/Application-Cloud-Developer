'''
Vogliamo gestire un contatore che può essere incrementato, decrementato, resettato e visualizzato. 
La classe offre un modo semplice per tenere traccia di un conteggio che non può diventare negativo.

Classe Contatore
Attributi:
- conteggio: un intero che conserva il valore del conteggio, inizializzato a 0.

Metodi:
- __init__(): Inizializza l'attributo conteggio a 0.
- setZero(): Imposta il conteggio a 0.
- add1(): Incrementa il conteggio di 1.
- sub1(): Decrementa il conteggio di 1, ma non permette che il conteggio diventi negativo. Se il conteggio è già 0, stampa un messaggio di errore.
- get(): Restituisce il valore corrente del conteggio.
- mostra(): Stampa a schermo il valore corrente del conteggio.

For example:
Test 	Result

c = Contatore()  
c.add1() 
c.mostra()

	

Conteggio attuale: 1

c = Contatore()  
c.sub1()  
c.mostra()

	

Non è possibile eseguire la sottrazione
Conteggio attuale: 0

c = Contatore() 
c.add1()
c.add1()
c.add1()
c.add1()
c.sub1()  
c.add1()
c.add1()
z  = c.get()
print(z)

	

5
'''

#Creiamo la classe Contatore per gestire un conteggio che può essere incrementato, decrementato, reimpostato e visualizzato
class Contatore:

    #Inizializziamo il conteggio a 0 tramite il costruttore
    def __init__(self):
        self.conteggio = 0

    #Creiamo la funzione per reimpostare il conteggio a 0
    def setZero(self):
        self.conteggio = 0

    #Creiamo la funzione per incrementare il conteggio di 1
    def add1(self):
        self.conteggio += 1

    #Creiamo la funzione per decrementare il conteggio di 1, ma solo se maggiore di 0
    def sub1(self):
        if self.conteggio > 0:
            self.conteggio -= 1
        else:
            #Se il conteggio è già a 0 stampiamo un messaggio di errore
            print("Non è possibile eseguire la sottrazione")

    #Creiamo la funzione per restituire il valore corrente del conteggio
    def get(self):
        return self.conteggio

    #Creiamo la funzione per stampare il valore attuale del conteggio
    def mostra(self):
        print(f"Conteggio attuale: {self.conteggio}")





'''Come richiesto dall'esercizio andiamo a testare l'incremento del conteggio '''

c = Contatore()
c.add1()
c.mostra()

#Testiamo ora la sottrazione da zero, che deve stampare un messaggio di errore
c2 = Contatore()
c2.sub1()
c2.mostra()

#Proviamo infine una serie di operazioni miste e stampiamo il valore finale
c3 = Contatore()
c3.add1()
c3.add1()
c3.add1()
c3.add1()
c3.sub1()
c3.add1()
c3.add1()
z = c3.get()
print(z)
