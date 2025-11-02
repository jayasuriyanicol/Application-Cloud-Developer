



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
    











        