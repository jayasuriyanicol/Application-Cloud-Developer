'''

Gestione di un magazzino
Scrivi un programma in Python che gestisca un magazzino. Il programma deve permettere di aggiungere prodotti al magazzino, 
cercare prodotti per nome e verificare la disponibilità di un prodotto.

Definisci una classe Prodotto con i seguenti attributi:
- nome (stringa)
- quantità (intero)
 
Definisci una classe Magazzino con i seguenti metodi:
- aggiungi_prodotto(prodotto: Prodotto): aggiunge un prodotto al magazzino.
- cerca_prodotto(nome: str) -> Prodotto: cerca un prodotto per nome e lo ritorna se esiste.
- verifica_disponibilità(nome: str) -> str: verifica se un prodotto è disponibile in magazzino.
 
Test case:

    Un gestore del magazzino crea un magazzino e diversi prodotti in diverse quantità. Successivamente, aggiunge i prodotti al magazzino.
    Il sistema cerca un prodotto per verificare se esiste nell'inventario.
    Il sistema verifica la disponibilità dei prodotti in inventario.



'''


#Creiamo la classe Prodotto con due attributi: nome del prodotto e quantità disponibile
class Prodotto:

    def __init__(self,nome:str,quantità:int) -> None:
        self.nome = nome
        self.quantità = quantità


#Creiamo la classe Magazzino che conterrà e gestirà la lista dei prodotti
class Magazzino:

    #Inizializziamo il magazzino come una lista vuota di prodotti
    def __init__(self):
        self.magazzino = []  

    #Funzione che aggiunge un prodotto alla lista del magazzino,aggiungiamo l'oggetto Prodotto alla lista magazzino
    def aggiungi_prodotto(self,prodotto:Prodotto) -> str:
        
        self.magazzino.append(prodotto)  
        return f"SUCCESSO ! il prodotto {prodotto.nome} è stato aggiunto al MAGAZZINO !"
    
    #Funzione che cerca un prodotto in base al nome, se esiste lo conferma, cicliamo tutti i prodotti presenti nel magazzino, controllando se il nome corrisponde ignorando maiuscole/minuscole
    def cerca_prodotto(self,nome:str):

        for elementoProdotto in self.magazzino:  

            if elementoProdotto.nome.lower() == nome.lower():  
                return f"SUCCESSO ! il prodotto '{nome}' ESISTE nel MAGAZZINO !"
            
        return f"ATTENZIONE ! il prodotto '{nome}' NON ESISTE nel MAGAZZINO !"  

    
    #Funzione che verifica se il prodotto è disponibile, ovvero se quantità > 0, cicliamo i prodotti per cercare il nome richiesto
    def verifica_disponibilità(self,nome:str)-> str:

        for elementoProdotto in self.magazzino:  
             
            if elementoProdotto.nome.lower() == nome.lower():
                if elementoProdotto.quantità > 0:  
                    return f"SUCCESSO ! il prodotto '{nome}' è DISPONBILIE nel MAGAZZINO !"
                else:  
                    return f"ATTENZIONE! Il prodotto '{nome}' NON è DISPONIBILE nel MAGAZZINO!"

        return f"ATTENZIONE ! il prodotto '{nome}' NON è DISPONIBILE nel MAGAZZINO !"  
    


#TEST CASE (verifica corretto funzionamento del sistema) 


#Creazione del magazzino
magazzino = Magazzino()

#Creazione di 3 prodotti con nome e quantità
prodotto1 = Prodotto("Monitor", 10)
prodotto2 = Prodotto("Tastiera", 0)
prodotto3 = Prodotto("Mouse", 25)

#Aggiunta dei prodotti al magazzino
print(f"\n{magazzino.aggiungi_prodotto(prodotto1)}")
print(f"\n{magazzino.aggiungi_prodotto(prodotto2)}")
print(f"\n{magazzino.aggiungi_prodotto(prodotto3)}")

#Ricerca di prodotti esistenti e non
print(f"\n{magazzino.cerca_prodotto('Mouse')}")
print(f"\n{magazzino.cerca_prodotto('Stampante')}")

#Verifica disponibilità dei prodotti, DISPONIBILE , NON DISPONIBILE, NON ESISTE
print(f"\n{magazzino.verifica_disponibilità('Monitor')}")     
print(f"\n{magazzino.verifica_disponibilità('Tastiera')}")    
print(f"\n{magazzino.verifica_disponibilità('Stampante')}")   
