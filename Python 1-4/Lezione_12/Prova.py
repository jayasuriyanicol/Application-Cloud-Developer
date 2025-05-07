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

    def __init__(self,autore:str,titolo:str)->None:

        self.autore = autore
        self.titolo = titolo
        self.statoPrestito = False #Ipotizziamo che il libro sia disponibile



class Biblioteca:

    def __init__(self):

        self.catalogoBiblioteca = []



    def aggiungi_libro(self,autore,titolo)-> str:

        nuovoLibro = Libro(autore,titolo) 
        self.catalogoBiblioteca.append(nuovoLibro)

        return f"Il libro {titolo} è stato AGGIUNTO CON SUCCESSO NEL CATALOGO !"
    

    def presta_libro (self,titolo):

        for libro in self.catalogoBiblioteca:

            if libro.titolo == titolo:

                if not self.statoPrestito:

                 self.statoPrestito = True

                 return f"Il libro {titolo} è stato PRESTATO con SUCCESSO !"
            
                else:

                 return f"ATTENZIONE il libro {titolo} RISULTA GIÀ PRESTATO !"
            
            else: 
             return f"ATTENZIONE ! Il libro {titolo} non risulta nel CATALOGO della BIBLIOTECA !"
        
    def restituisci_libro (self,titolo):

        for libro in self.catalogoBiblioteca :

            if libro.titolo == titolo:

                if self.statoPrestito:


                 self.statoPrestito = False

                 return f"Il libro {titolo} è stato RESTITUITO con SUCCESSO !"
            
                else:

                 return f"ATTENZIONE il libro {titolo} NON RISULTA PRESTATO !"
            
            else: 
             
             return f"ATTENZIONE ! Il libro {titolo} non risulta nel CATALOGO della BIBLIOTECA !"
            


    def mostra_stato_libri (self):
       
       libriDisponibili = [ ] 
       for libro in self.catalogoBiblioteca:
          
          if not libro.statoPrestito:
             
             libriDisponibili.append(libro.titolo)

        
       if libriDisponibili:
        print("Questa è la LISTA dei LIBRI DISPONIBILI:")
        for libro in libriDisponibili:
          
          print( f"- {libro}" )
       
       else:
            print("\nATTENZIONE ! Nessun libro disponibile.")


    def stato_libri(self):
       
       for libro in self.catalogoBiblioteca:
          
          if libro.statoPrestito:
             
             stato = "Disponibile"
          else:
             
             stato = "Prestato"
          print (f"-{libro.titolo} ({stato}) ")
       



#Infine andiamo a inserire qualche dato da input per verificare la correttezza del programma, quindi inseriamo i vari dati e andiamo a richiamare le funzioni per vedere il loro corretto funzionamento

mia_biblioteca = Biblioteca()

#Provvedo con aggiungere dei Libri inventati
print(mia_biblioteca.aggiungi_libro("l GattoPardo", "Mario Verdi"))
print(mia_biblioteca.aggiungi_libro("Il cane testardo", "Fabrizio Umberti"))
print(mia_biblioteca.aggiungi_libro("Calma e Pazienza", "Cristiano Coccia"))

#Richiamo la funzione per vedere se i libri inseriti sono stati salvati correttamente
mia_biblioteca.mostra_stato_libri()

#Aggiungo come richiesto dalla consegna due PRESTITI nello stesso anno "2024"
print(mia_biblioteca.presta_libro("2024"))
print(mia_biblioteca.presta_libro("2024"))

#Restituisco come richiesto dalla consegna due RESTITUZIONI nello stesso anno "2025"
print(mia_biblioteca.restituisci_libro("2025"))
print(mia_biblioteca.restituisci_libro("2025")) 

#Presto l'ultimo libro aggiunbto al catalogoBiblioteca
print(mia_biblioteca.presta_libro("Calma e Pazienza"))

#Infine, per concludere mostro lo stato di tutti i libri con relativo TITOLO e STATO del PRESTITO (Disponibile o Prestato)
mia_biblioteca.mostra_stato_libri()

    

          

        
          
          
              
       

