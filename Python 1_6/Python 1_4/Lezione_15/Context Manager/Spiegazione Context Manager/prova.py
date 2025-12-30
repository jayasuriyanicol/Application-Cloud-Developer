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


class FileManager:

    def __init__(self, name: str, mode: str, encoding: str = "utf-8") -> None:
        
        self.name = name
        self.mode = mode
        self.encoding = encoding
        self.file = None


    def __enter__ (self):

        self.file = open(self.name,self.mode, encoding=self.encoding)
        print("SUCCESSO ! Accesso alla risorsa avvenuta CORRETTAMENTE !")
        return self.file
    
    def __exit__(self, exc_type:str, exc_value:str, traceback:str) -> str:

        if self.file:
            self.file.close()
            print("SUCCESSO ! Uscita dal FILE avvenuto CORRETTAMENTE !")
        
        if exc_type is not None:

           print(f"EXCPECTION TYPE ERROR: {exc_type} ")
           print(f"EXCPECTION VALUE ERROR: {exc_value} ")
           print(f"TRACEBACK ERROR: {traceback} ")


        return False

with FileManager('example.txt', 'w') as f:
    f.write("Scrivo prima dell'errore...\n")
    1 / 0  # Questo genera un'eccezione ZeroDivisionError
    f.write("Questa riga non verrà mai scritta!")
