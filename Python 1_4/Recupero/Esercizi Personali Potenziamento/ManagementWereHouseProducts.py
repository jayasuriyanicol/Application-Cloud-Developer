'''
🧮 Esercizio 2 — Gestione Magazzino Prodotti (PUNTI 2)

Crea una classe Warehouse per gestire un magazzino con prodotti e quantità.

Requisiti

Attributo:

items: dict[str, int] — chiave = nome prodotto, valore = quantità

Metodi:

add_item(name: str, qty: int) -> None
Aggiunge il prodotto al magazzino. Se esiste già, somma le quantità.

remove_item(name: str, qty: int) -> None
Rimuove qty unità dal prodotto se disponibile; se non basta, stampa "Quantità insufficiente".
Se il prodotto non esiste, stampa "Prodotto non trovato".

check_stock(name: str) -> int | str
Restituisce la quantità disponibile o "Prodotto non trovato".

list_items() -> dict[str, int]
Restituisce il dizionario completo degli articoli e quantità.

'''


class Warehouse:

    def  __init__(self):
        self.items:dict[str,int] = {}

    def add_item(self,name:str,qty:int) -> None:

        if name not in self.items:

            self.items[name] = qty
        else:
            print("Errore: prodotto già presente nel magazzino")   
    

    def remove_item(self,name:str,qty:int) -> None:

        if name in self.items:

            if self.items[name] >= qty:

                self.items[name] -= qty  
                
            else:

                 print("Errore: quantità maggiore rispetto quella presente nel magazzino")
           
        else:
             print("Prodotto non trovato")        


    def check_stock(self,name:str) -> int|str:
        
        if name in self.items:


                return self.items[name] 

        else:   
            print("Prodotto non trovato") 

    def list_items(self) -> dict[str,int]:
    
        dizionarioDict:dict[str,int] = {} 


        for key,value in self.items.items():

            dizionarioDict[key] = value
        
        return dizionarioDict






w = Warehouse()
w.add_item("Monitor", 10)
w.add_item("Mouse", 25)
w.remove_item("Mouse", 5)
print(w.check_stock("Mouse"))   # ➜ 20
print(w.list_items())           # ➜ {'Monitor': 10, 'Mouse': 20}
