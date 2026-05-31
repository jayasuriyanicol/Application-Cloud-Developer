'''
Crea un context manager che permette di calcolare il tempo che viene impiegato ad eseguire le istruzioni che si trovano nel with

with Timer():

    time.sleep(1)

time elapsed: 1.00000

in questo esempio il tempo passato non sarà mai uguale a 1

'''

#Andiamo a importare la libreria TIME e andiamo a creare la classe CalculateTime per andare a verificare il tempo necessario ELAPSED TIME per accedere e uscire dal file "Tempo Necessario"
import time

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
    

#Andiamo a svolgere il nostro TEST mostrando l'inizio del programma e la fine, come indicazione da dove inizia a dove finisce
print("Inizio del programma")

#Utilizziamo il TRY e l'EXCEPT per mostrare anche il caso d'errore, ovvero dalla riga 61 alla 65. Mentre il caso di successo dalla 59 alla 60
try:
    with CalculateTime():
        time.sleep(1)
        x = 1 / 0  
        print("Questa riga non verrà eseguita.")
except ZeroDivisionError:
    print("\n---------Errore ZERO DIVISION------!")

print("Fine del programma")