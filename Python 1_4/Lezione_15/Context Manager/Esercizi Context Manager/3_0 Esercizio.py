'''
DEFINIAMO UNA FUNZIONE CHE CALCOLA SE UN NUMERO È PRIMO O MENO
'''

'''def primeNumber(n: int)-> bool:

    for i in range (2,n):
        if n%i==0:
            print(f"il divisore trovato è: {i}")
            return False
    
    return True


def primeDividedNumber(n:int) -> bool:
    for i in range(2,(n//2)+1):
        if n%i==0:
            print(f"il divisore trovato è:{i}")
            return False
    return True



print(primeNumber(5))
print(primeDividedNumber(32)) '''



'''ESERCIZIO: Creare una funzione BubbleSort che cui ci permetta senza l'utilizzo delle funzioni build-in MAX(), MIN() attraverso l'utilizzo dello SWAPPING
              che permetta di ottenere data una lista NON ORDINATA la stessa lista ORDINATA e calcolare il tempo necessario per l'esecuzione dell'algoritmo.
              Inoltre nel caso la lista sia effettivamente ordinata possiamo procedere a stampare direttamente la lista così com'è sennò proseguire con lo
              SWAPPING affinchè la lista non venga effettivamente ordinata.
'''



#Importiamo TIME per calcolare il tempo necessario per l'esecuzione
import time


'''Possibile anche importare la classe CalculateTime, ma siccome la sintassi del file non va bene preferiamo riportala sull'esercizio. 
   Quindi in caso, si potrebbe anche fare -> "from 2_0 Esercizio import CalculateTime", ma dovremmo in ogni modo modificare la sintassi del
   file senza spazi e MAIUSC 
'''

#Andiamo a definire una funzione simile al BubbleSort che ci ordina una lista di interi. Prendiamo la len della lista e creiamo due parti che vanno a iterare nella prima e seconda metà della lista
def orderedList(lista: list[int]) -> list[int]:
    lunghezzaLista = len(lista)

    #Procediamo con l'iterazione nella prima parte della lista, assumendo che la lista sia ordinata ovvero -> 'ordered = True'
    for firstHalf in range(lunghezzaLista):
        ordered = True  

        #Successivamente andiamo a iterare sulla seconda parte della lista per confrontare solamente fino all'ultimo elemento della lista non in posizione  
        for secondHalf in range(0, lunghezzaLista - 1):  
            if lista[secondHalf] > lista[secondHalf + 1]:
                lista[secondHalf], lista[secondHalf + 1] = lista[secondHalf + 1], lista[secondHalf]  
                #Se avviene almeno uno scambio, cambiamo e mettiamo False 
                ordered = False  

        #Nessuno scambio,la lista è già ordinata (lo verifichiamo solo se succede al primo ciclo) e attarverso il bool di ordered se è True
        if ordered:
            if firstHalf == 0:
                print("Lista già ordinata, nessun ordinamento necessario")
            break

    return lista

#Copiamo dall'esericizio '2_0 Esercizio' la classe e non la riportiamo come detto dopo 'import time', per il calcolo del tempo necessario
class CalculateTime:
    
    #Andiamo a definire il costruttore con i valori di startTime e endTime inizializzati a zero = 0.0  
    def __init__(self)-> None:

        self.startTime = 0.0
        self.endTime = 0.0

    
    #Effettuiamo l'accesso al file per poter accedere dentro il file con il metodo time.time() -> from time import time per ottenere il tempo necessario ad l'apertura del file
    def __enter__(self):

        self.startTime = time.time()
        return self
    
    #Infine ci "disconnettiamo" dal file e andiamo a acquisire il valore del tempo come nella funzione precedente, passiamo sempre i valori di EXCEPTION e TRACEBACK in caso di errore.  
    def __exit__ (self, excType: str, excValue : str, traceback: str)-> str:

        self.endTime = time.time()

        #Andiamo ad effettuare la differenza fra il tempo di accesso e il tempo di termine così da ottenere il tempo trascorso, stampandolo con 5 cifre decimali
        elapsedTime = self.endTime - self.startTime

        print(f"Il valore di ELAPSED TIME è il seguente :{elapsedTime:.5f} secondi")
   
       
        #In caso di ERRORE andiamo a stampare il messaggio di ERRORE con il relativo errore del sistema per tutti i suoi casi 
        if excValue is not None:

            print(f"ERRORE EXCEPTION VALUE: {excValue} ")
            print(f"ERRORE EXCEPTION TYPE: {excType} ")
            print(f"ERRORE TRACEBACK: {traceback} ")

        #Ritorniamo TRUE perchè siamo riusciti a non far PROPAGARE l'errore 
        return True
    

#Richiamo della classe e avviamento della funzione 'orderdList per vedere il funzionamento
with CalculateTime():
    print("Inizio del Programma")
    risultato = orderedList([4, 2, 3, 1])
    print("Lista ordinata:", risultato)

print("Fine del programma")
