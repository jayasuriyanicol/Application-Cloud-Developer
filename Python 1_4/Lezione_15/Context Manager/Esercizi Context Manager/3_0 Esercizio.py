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
              che permetta di ottenere data una lista NON ORDINATA la stessa lista ORDINATA e calcolare il tempo necessario per l'esecuzione dell'algoritmo

'''

import time

def orderedList(lista: list[int]) -> list[int]:
    ordered: bool = True
    for primoElemento in range(len(lista)):
        for secondoElemento in range(primoElemento + 1, len(lista)):

            ''' if lista[primoElemento] >= lista[secondoElemento]:
                ordered = False 
                
                if ordered:
                   return lista '''
                  
            if lista[secondoElemento] < lista[primoElemento]:
                lista[primoElemento], lista[secondoElemento] = lista[secondoElemento], lista[primoElemento]
            
    return lista


class CalculateTime:
    def __init__(self) -> None:
        self.startTime = 0.0
        self.endTime = 0.0

    def __enter__(self):
        self.startTime = time.time()
        return self

    def __exit__(self, excType, excValue, traceback):
        self.endTime = time.time()
        elapsedTime = self.endTime - self.startTime
        print(f"\nIl valore di ELAPSED TIME è il seguente: {elapsedTime:.5f} secondi")

        if excValue is not None:
            print(f"ERRORE EXCEPTION VALUE: {excValue}")
            print(f"ERRORE EXCEPTION TYPE: {excType}")
            print(f"ERRORE TRACEBACK: {traceback}")

        return True

print("Inizio del programma")

with CalculateTime():
    risultato = orderedList([3,2,1])
    print("Lista ordinata:", risultato)

print("Fine del programma")
