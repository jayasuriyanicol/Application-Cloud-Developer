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

#Andiamo a definire una funzione simile al BubbleSort che ci ordina una lista di interi. Prendiamo la len della lista e creiamo due parti che vanno a iterare nella prima e seconda metà della lista
def orderedList(lista: list[int]) -> list[int]:
    lunghezzaLista = len(lista)

    #Procediamo con l'iterazione nella prima parte della lista, assumendo che la lista sia ordinata ovvero -> 'ordered = True'
    for firstHalf in range(lunghezzaLista):
        ordered = True  

        #Successivamente andiamo a iterare sulla seconda parte della lista per confrontare solamente fino all'ultimo elemento della lista non in posizione  
        for secondHalf in range(0, lunghezzaLista - firstHalf - 1):  
            if lista[secondHalf] > lista[secondHalf + 1]:
                lista[secondHalf], lista[secondHalf + 1] = lista[secondHalf + 1], lista[secondHalf]  
                #Se avviene almeno uno scambio, cambdaiamo e mettiamo False 
                ordered = False  

        # Nessuno scambio: la lista è già ordinata (lo verifichiamo solo se succede al primo ciclo)
        if ordered:
            if firstHalf == 0:
                print("Lista già ordinata, nessun ordinamento necessario.")
            break

    return lista

# Classe per calcolare il tempo di esecuzione (ELAPSED TIME) usando il costrutto with
class CalculateTime:
    def __init__(self) -> None:
        self.startTime = 0.0
        self.endTime = 0.0

    # Salva il tempo iniziale di esecuzione
    def __enter__(self):
        self.startTime = time.time()
        return self

    # Salva il tempo finale e calcola il tempo trascorso (ELAPSED TIME)
    def __exit__(self, excType, excValue, traceback):
        self.endTime = time.time()
        elapsedTime = self.endTime - self.startTime
        print(f"\nIl valore di ELAPSED TIME è il seguente: {elapsedTime:.5f} secondi")

        # In caso di errore stampa info dettagliate
        if excValue is not None:
            print(f"ERRORE EXCEPTION VALUE: {excValue}")
            print(f"ERRORE EXCEPTION TYPE: {excType}")
            print(f"ERRORE TRACEBACK: {traceback}")

        return True  # Per non propagare l’eccezione

# Esecuzione del programma
print("Inizio del programma")

# Calcolo del tempo di ordinamento
with CalculateTime():
    risultato = orderedList([4, 2, 3, 1])
    print("Lista ordinata:", risultato)

print("Fine del programma")
