'''
Sistema di Gestione Biblioteca - PUNTI 2
Implementa tre classi interagenti per gestire il prestito di libri.
Classe Book:
- book_id: str
- title: str
- author: str
- is_borrowed: bool
Classe Member:
- member_id: str
- name: str
- borrowed_books: list[Book]
Classe Library:
- books: dict[str, Book]
- members: dict[str, Member]
Metodi:
- add_book(book_id: str, title: str, author: str) -> None
- register_member(member_id: str, name: str) -> None
- borrow_book(member_id: str, book_id: str) -> None
- return_book(member_id: str, book_id: str) -> None
- list_available_books() -> list[str]
- list_member_borrowings(member_id: str) -> list[str] | str


'''

class Book: 

    
    def __init__(self,book_id : str, title:str,author: str, is_borrowed:bool) -> None:

        self.book_id = book_id
        self.title = title
        self.author = author
        self.is_borrowed = False

    
    def add_book(self,book_id,title:str,author:str)-> None:

        if not book_id:

            self.book_id = book_id
            self.title = title
            self.author = author
            self.is_borrowed = False
        else:

            print(f"Errore: esiste già il libro {book_id}")
    

class Member(Book):


    def __init__(self, book_id:str, title:str, author:str, is_borrowed:bool, member_id:str,name:str) -> None:
                 

                self.member_id = member_id
                self.name = name
                self.borrowed_books:list[Book] = []
                super().__init__(book_id, title, author, is_borrowed) 

    def register_member(self,member_id:str, name:str) -> None:
         

         if not member_id:
              

              self.member_id = member_id
              self.name = name
         else:
              print( f"Errore: Membro {self.name} già esistente")
    
    def borrow_book(self,member_id:str , book_id:str) -> None:
         
         if member_id and book_id:
              
              self.borrowed_books.append(book_id)
              self.is_borrowed = True
         else:

              print(f"Errore: Il libro {book_id} già risulta prenotato o non esiste")  
    
    def return_book(self,member_id:str, book_id:str) -> None:
         
         if member_id and book_id:
              
              self.borrowed_books.remove(book_id)
              self.is_borrowed = False
         else:

              print(f"Errore: Il libro {book_id} non risulta prenotato o non esiste")  
            


class Library:
     

    def __init__(self) -> None:
          
          self.books:dict[str, Book] = {}
          self.members:dict[str,Member] = {} 

    
    def list_available_books(self) -> list[str]:
         
        listaLibriDisponibili:list[str] = [] 


        for key,value in self.books.items():
             
            if not value.is_borrowed:
                  
                  listaLibriDisponibili.append(key)
            else:
                 
                 print("Errore: nessun libro disponibile !")
                 
             

         
    def list_member_borrowings(self,member_id: str) -> list[str] | str:
         

        listaMembriPrenotati:list[str] = []


        if member_id in self.members:
             
             member = self.members[member_id] 

       
             for book in member.borrowed_books:
                  
                  listaMembriPrenotati.append(book.book_id)
             return listaMembriPrenotati
        
        else:
            return "Errore: membro non trovato" 
        
 