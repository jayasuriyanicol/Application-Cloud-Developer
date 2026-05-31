'''
Progettare un sistema di gestione della biblioteca con i seguenti requisiti:

    Classe Book:
        Attributi:
            book_id: str - Identificatore di un libro.
            title: str - titolo del libro.
            author: str - autore del libro
            is_borrowed: boolean - booleano che indica se il libro è in prestito o meno.
        Metodi:
            borrow()-Contrassegna il libro come preso in prestito se non è già preso in prestito.
            return_book()- Contrassegna il libro come restituito.

    Classe Member:
        Attributi:
            member_id: str - identificativo del membro.
            name: str - il nome del membro.
            borrowed_books: list[Book] - lista dei libri presi in prestito.
        Metodi:
            borrow_book(book): aggiunge il libro nella lista borrowed_books se non è già stato preso in prestito.
            return_book(book): rimuove il libro dalla lista borrowed_books.

    Classe Library:
        Attributi:
            books: dict[str, Book] - dizionario che ha per chiave l'id del libro e per valore l'oggetto Book
            members: dict[str, Member] - dizionario che ha per chiave l'id del membro e per valore l'oggetto Membro
        Metodi:
            add_book(book_id: str, title: str, author: str): Aggiunge un nuovo libro nella biblioteca.
            register_member(member_id:str, name: str): Iscrive un nuovo membro nella biblioteca.
            borrow_book(member_id: str, book_id: str): Permette al membro di prendere in prestito il libro.
            return_book(member_id: str, book_id: str): Permette al membro di restituire il libro.
            get_borrowed_books(member_id): list[Book] - restituisce la lista dei libri presi in prestito dal membro.



'''



class Book:


    def __init__(self,book_id:str,title:str,author:str,is_borrowed:bool = False) -> None:

        self.book_id = book_id
        self.title = title
        self.author = author
        self.is_borrowed = is_borrowed

    
    def borrow(self) -> None:

        if not self.is_borrowed:

            self.is_borrowed = True
        else:

            print("Book is already borrowed")
    
    def return_book(self) -> None:

        if self.is_borrowed:

            self.is_borrowed = False
        else:
            print("Errore: il libro NON risulta in prestito")

class Member:

    def __init__(self,member_id:str,name:str)-> None:

        self.member_id = member_id
        self.name = name
        self.borrowed_books:list[Book] = [] 
    
    def borrow_book(self,book) -> None:


        if book not in self.borrowed_books:

            self.borrowed_books.append(book)
        else:
            print("Errore: Il libro risulta già in prestito")

    def return_book(self,book) -> None:

        if book in self.borrowed_books:

            self.borrowed_books.remove(book)
        else:

             print("Errore: Non risulta nessun libro in prestito")
            

class Library:

    def __init__(self) -> None:

        self.books:dict[str,Book] = {}
        self.members:dict[str,Member] = {}

    def add_book(self,book_id:str,title:str,author:str) -> None:

        libro = Book(book_id,title,author)

        if book_id not in self.books:

            self.books[book_id] = libro
        else:
            print("Errore: il libro risulta già essere presente nella Libreria")

    def register_member(self,member_id:str, name:str) -> None:

        membro = Member(member_id,name)

        if member_id not in self.members:

            self.members[member_id] = membro
        else:
            print("Errore: il membro risulta già essere presente nella lista membri")
    
    def borrow_book(self,member_id:str,book_id:str) -> None:

        prestito = self.books.get(book_id)
        membro = self.members.get(member_id)

        if member_id in self.members and book_id in self.books:

            prestito.borrow()
            membro.borrow_book(prestito)
        else:

            print("Book not found")
    
    def return_book(self,member_id:str,book_id:str) -> None:

        prestito = self.books.get(book_id)
        membro = self.members.get(member_id)


        if member_id in self.members and book_id in self.books:

            prestito.return_book()
            membro.return_book(prestito)
        else:
             print("Errore: membro o libro non presente per la restituzione")
    
    def get_borrowed_books(self,member_id) -> list[Book]:


        if member_id in self.members:


            return self.members[member_id].borrowed_books
        else:

             print("Errore: membro non presente per la restituzione della lista dei suoi libri")
             return [] 



        
          
    


