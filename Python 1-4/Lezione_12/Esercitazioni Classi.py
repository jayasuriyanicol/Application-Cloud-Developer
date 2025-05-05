'''

Sistema di Gestione Biblioteca
Si desidera sviluppare un sistema per la gestione di una biblioteca in Python. 
Il sistema deve permettere di gestire un inventario di libri e le operazioni di prestito e restituzione degli stessi. 
Gli utenti del sistema devono essere in grado di aggiungere libri al catalogo, prestarli, restituirli e visualizzare quali libri sono disponibili in un dato momento.
 
Classi:
- Libro: Rappresenta un libro con titolo, autore, stato del prestito. Il libro deve essere inizialmente disponibile (non prestato).

- Biblioteca: Gestice tutte le operazioni legate alla gestione di una biblioteca.

    Metodi della classe:
    - aggiungi_libro(libro): Aggiunge un nuovo libro al catalogo della biblioteca. Restituisce un messaggio di conferma.

    - presta_libro(titolo): Cerca un libro per titolo e, se disponibile e non già prestato, lo segna come disponibile. Restituisce un messaggio di stato.

    - restituisci_libro(titolo): Cerca un libro per titolo e, se trovato e prestato, lo segna come disponibile. Restituisce un messaggio di stato.

    - mostra_libri_disponibili(): Restituisce una lista dei titoli dei libri attualmente disponibili. Se non ci sono libri disponibili, restituisce un messaggio di errore.

Codice Driver

    Aggiungi libri alla biblioteca.
    Presta e restituisci libri, gestendo anche casi limite (già prestato, doppia restituzione, libro inesistente).
    Mostra i libri disponibili in ogni fase.
    Visualizza lo stato finale di ogni libro.

'''



class Libro:

    def __init__(self,titolo:str, autore:str,statoPrestito: str):
        
        self.titolo = titolo
        self.autore = autore
        self.statoPrestito = statoPrestito



class Biblioteca(Libro):

    def __init__(self, titolo, autore, statoPrestito):
        super().__init__(titolo, autore, statoPrestito)

        self.catalogoBiblioteca = [] 
    

    def aggiungi_libro(self,libro):
        
        self.catalogoBiblioteca.append(libro)
        
        return "\nSUCCESSO ! Il libro è stato registrato con successo nel CATALOGO DELLA BIBLIOTECA"
    

    def presta_libro(self,libro):
        
        
        if self.titolo == libro:
            if self.statoPrestito == "disponibile".lower():

                return "DISPONIBILE ! il libro è disponibile e può essere PRESTATO"
            
            else:

                return "NON DISPONIBILE ! il libro non è disponibile e NON può essere PRESTATO"
        
        else:

            return "ATTENZIONE ! Il libro con il TITOLO fornito non è presente nell'ARCHIVIO"
        

    
      