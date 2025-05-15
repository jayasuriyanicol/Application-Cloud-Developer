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

# Creiamo la classe contatore
class Contatore:

    def __init__(self):
        # Inizializziamo il conteggio a 0
        self.conteggio = 0

    def setZero(self):
        # Reimpostiamo il conteggio a 0
        self.conteggio = 0

    def add1(self):
        # Incrementiamo il conteggio di 1
        self.conteggio += 1

    def sub1(self):
        # Decrementiamo il conteggio di 1 solo se è maggiore di 0
        if self.conteggio > 0:
            self.conteggio -= 1
        else:
            # Se il conteggio è già 0, stampiamo un messaggio di errore
            print("Non è possibile eseguire la sottrazione")

    def get(self):
        # Restituiamo il valore corrente del conteggio
        return self.conteggio

    def mostra(self):
        # Stampiamo il valore corrente del conteggio
        print(f"Conteggio attuale: {self.conteggio}")


c = Contatore()  
c.add1() 
c.mostra()  


c = Contatore()  
c.sub1()  
c.mostra()  

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
# Output: 5
