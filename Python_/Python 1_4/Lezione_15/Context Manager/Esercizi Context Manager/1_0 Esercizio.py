''''
Esercizio 1

Crea un context manager usando una classe

Definisci una classe FileManager che implementa un context manager che gestisce le risorse dei file.

Implementa appropriatamente la funzione __init__, __enter__ e la funzione  __exit__

Esempio di funzionamento:

Il context manager deve permettere di aprire il file, effettuare operazioni e chiudere la risorsa aperta.

with FileManager('example.txt', 'w') as f:

    f.write('Hello, world!')
'''

#Creiamo la classe FileManager per andare a scrivere un messaggio sul file 'example.txt'
class FileManager:
    def __init__(self, nome: str, mode: str, encoding: str = 'utf-8') -> None:
        self.nome = nome
        self.mode = mode
        self.encoding = encoding
        #Inizializziamo il file come "nullo" senza nessun parametro -> None
        self.file = None  

#Creiamo la funzione che ci permetterà di aprire il file per scriverci, ritornando alla fine il file
    def __enter__(self):
        self.file = open(self.nome, self.mode, encoding=self.encoding)
        print("SUCCESSO! La RISORSA è stata acquisita!")
        return self.file  

#Infine creiamo la funzione per chiudere e uscire dal file, e una gestione nel caso qualcosa non funzioni quindi Exception Values che vengono printate a video
    def __exit__(self, exc_type, exc_value, traceback):
        if self.file:
            self.file.close()
            print("SUCCESSO! La RISORSA è stata rilasciata!")

        if exc_type is not None:
            print(f"Exception type: {exc_type}")
            print(f"Exception value: {exc_value}")
            print(f"Traceback: {traceback}")
        
       #In caso di caso negativo ritorniamo False
        return False  



#Come richiesto dall'esericizio andiamo a provare a scrivere un messaggio testando l'effettivo funzionamento
with FileManager("example.txt", "w") as f:
    f.write("Ho appena effettuato l'accesso nel FILE!")


#Mentre se vogliamo testare gl EXCEPTION ERRORS e il Traceback, possiamo utilizzarer il metodo Zero Division 1/0
with FileManager('example.txt', 'w') as f:
    f.write("Scrivo prima dell'errore...\n")
    1 / 0 
    f.write("Questa riga non verrà mai scritta!")


