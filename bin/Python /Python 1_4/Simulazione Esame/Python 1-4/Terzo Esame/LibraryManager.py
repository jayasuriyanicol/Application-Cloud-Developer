'''
Classe LibraryManager – PUNTI 2

Progetta una classe LibraryManager per gestire una piccola biblioteca digitale.

Attributi:

books: dict[str, dict] — dizionario che contiene tutti i libri presenti.
La chiave è il codice del libro (book_id), e il valore è un altro dizionario con:

"titolo": str — titolo del libro

"disponibile": bool — indica se il libro è disponibile o già prestato

Metodi:

add_book(book_id: str, titolo: str) -> dict | str
Aggiunge un nuovo libro. Se il codice esiste già, restituisce "Errore: libro già presente.".
Altrimenti, aggiunge il libro con disponibile=True e ritorna il dizionario del libro aggiunto.

borrow_book(book_id: str) -> dict | str
Se il libro non esiste, restituisce "Errore: libro non trovato.".
Se non è disponibile, restituisce "Errore: libro già in prestito.".
Altrimenti imposta disponibile=False e restituisce il libro aggiornato.

return_book(book_id: str) -> dict | str
Se non esiste, restituisce "Errore: libro non trovato.".
Altrimenti imposta disponibile=True e restituisce il libro aggiornato.

remove_book(book_id: str) -> dict | str
Rimuove un libro dal catalogo. Se non esiste, restituisce "Errore: libro non trovato.".
Altrimenti restituisce il libro rimosso.

list_books() -> list[str]
Restituisce la lista dei codici libro (book_id) presenti nel sistema.

'''



class LibraryManager:


    def __init__(self) -> None:

        self.books:dict[str,dict] = {}

    def add_book(self,book_id:str, titolo:str) -> dict|str:


        if book_id not in self.books:

            self.books[book_id] = {"titolo" : titolo ,"disponibile" : True}

        else:
            return "Errore: libro già presente"  
        
        return self.books
    
    def borrow_book(self,book_id:str) -> dict|str:

        if book_id in self.books:

            if self.books[book_id]["disponibile"] == True  :


                self.books[book_id]["disponibile": False] 

            else:
                return "Errore: libro già in prestito"
        else:
            return "Errore: libro non trovato"
    
    def return_book(self,book_id)-> dict|str:

        if book_id not in self.books:

            return "Errore: libro non trovato"
        
        else:
            self.books[book_id]["disponibile":True]  
    
    def remove_book(self,book_id:str)-> dict|str:

        if book_id in self.books:

           return self.books.pop(book_id)
        else:
            return "Errore: libro non trovato"
    
    def list_books(self) -> list[str]:

        listaBookId:list[str] = [] 

        for el in self.books.keys():

            listaBookId.append(el)
        
        return listaBookId
    











        