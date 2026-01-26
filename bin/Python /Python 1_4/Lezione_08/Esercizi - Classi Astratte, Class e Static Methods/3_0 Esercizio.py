'''
Exercise 3: Library Management System 

Create a Book class containing the following attributes: title, author, isbn. The book class must contains the following methods:

    __str__, method to return a string representation of the book.

    from_string, a class method to create a Book instance from a string in the format "title, author, isbn". It means that you must use the class reference cls to create a new object of the Book class using a string.

Example: 

book_str: str = "La Divina Commedia, D. Alighieri, 999000666"
divina_commedia: Book = Book.from_string(book_str)

In this case, divina_commedia should be an instance of the Book class with:

    title = "La Divina Commedia"

    author = "D. Alighieri"

    isbn = "999000666"

Create a Member class with the following attributes: name, member_id, borrowed_books. The member class must contain the following methods:

    borrow_book, to add a book to the borrowed_books list.

    return_book, to remove a book from the borrowed_books list.

    __str__, method to return a string representation of the member.

    from_string, a class method to create a Member instance from a string in the format "name, member_id". It means that you must use the class reference cls to create a new object of the Member class using a string.

Create a Library class with the following attributes: books, members, total_books (i.e., a class attribute to keep track of the total number of Book instances). The library class must contain the following methods:

    add_book, to add a book to the library and increment total_books.

    remove_book, to remove a book from the library and decrement total_books.

    register_member, to add a member to the library.

    lend_book, to lend a book to a member. It should check if the book is available and if the member is registered.

    __str__, method to return a string representation of the library with the list of books and members.

    library_statistics,  a class method to print the total number of books.

Finally, write a simple driver program. After creating a library, you should begin by creating instances of Book and Member. Wherever appropriate, use class methods (such as from_string) to instantiate objects from 
strings, improving clarity and modularity.

Once your objects are created, simulate some basic library operations:

    Register new members to the library. This could involve adding Member objects to a collection maintained by the library.

    Add books to the library’s collection.

    Lend books to members. This will involve marking a book as borrowed and associating it with a specific member.

    At each significant step, print the state of the library to track how it changes:
        before lending any book,
        after books have been lent.


'''

#Classe BOOK
class BookClass():

    #Metodo costruttore con i 3 attributi principali: titolo, autore e codice ISBN
    def __init__(self, title: str, author: str, isbn: int):
        self.title = title
        self.author = author
        self.isbn = isbn

    #Metodo __str__ per mostrare il libro in formato stringa
    def __str__(self):
        return f"Title: {self.title}, Author: {self.author}, ISBN: {self.isbn}"

    #Metodo di classe per creare un oggetto Book da una stringa
    @classmethod
    def from_string(cls, book_str: str):
        title, author, isbn = book_str.split(", ")
        return cls(title, author, isbn)


#Creazione istanza libro da stringa
book_str = "La Divina Commedia, D. Alighieri, 999000666"
divina_commedia = BookClass.from_string(book_str)

#Stampa a video dell’oggetto libro
print(divina_commedia)


#Classe MEMBER
class MemberClass:

    #Costruttore con nome, ID e lista dei libri presi in prestito
    def __init__(self, name: str, member_id: str):
        self.name = name
        self.member_id = member_id
        self.borrowed_books = []

    #Metodo per prendere in prestito un libro
    def borrow_book(self, book: str):
        self.borrowed_books.append(book)

    #Metodo per restituire un libro
    def return_book(self, book: str):
        if book in self.borrowed_books:
            self.borrowed_books.remove(book)
        else:
            return f"ATTENZIONE ! il libro {book} inserito non è presente nella LISTA !"

    #Metodo __str__ per mostrare lo stato del membro
    def __str__(self):
        if self.borrowed_books:
            books = ", ".join(self.borrowed_books)
        else:
            return "Nessun libro è stato preso in PRESTITO"
        return f"The name of the member is {self.name} his ID is : {self.member_id} have those books booked: {books} !"

    #Metodo di classe per creare un membro da una stringa
    @classmethod
    def from_string(cls, member_str: str):
        name, member_id = member_str.split(", ")
        return cls(name, member_id)


#Classe LIBRARY
class LibraryClass:

    #Attributo di classe che tiene il totale dei libri
    total_books = 0

    #Costruttore: inizializza le liste di libri e membri
    def __init__(self) -> None:
        self.books = []
        self.members = []
        LibraryClass.total_books += len(self.books)

    #Metodo per aggiungere un libro
    def add_book(self, book: str) -> int:
        if book not in self.books:
            self.books.append(book)
            LibraryClass.total_books += 1
        else:
            return f"ATTENZIONE ! il libro già presente nella LISTA !"

    #Metodo per rimuovere un libro
    def remove_book(self, book: str):
        if book in self.books:
            self.books.remove(book)
            LibraryClass.total_books -= 1
        else:
            return f"ATTENZIONE ! il libro da te inserito non è presente nella LISTA"

    #Metodo per registrare un nuovo membro
    def register_member(self, member: str):
        if member not in self.members:
            self.members.append(member)
        else:
            return f"ATTENZIONE ! il membro già presente nel SISTEMA !"

    #Metodo per prestare un libro a un membro
    def lend_book(self, book, member):
        if member not in self.members:
            return f"ATTENZIONE ! Non risulta nessun membro -> {member.name}"
        if book in self.books:
            self.books.remove(book)
            member.borrow_book(str(book))  # oppure book.title
            return f"Il libro '{book}' è stato PRESTATO con SUCCESSO a {member.name}!"
        else:
            return f"ATTENZIONE ! Non risulta nessun libro -> {book}"

    #Metodo __str__ per mostrare lo stato completo della libreria
    def __str__(self):
        result = "LIBRARY INFO:\n"
        result += "\nLibri disponibili:\n"
        for book in self.books:
            result += str(book) + "\n"
        result += "\nMembri registrati:\n"
        for member in self.members:
            result += str(member) + "\n"
        return result

    #Metodo di classe per stampare le statistiche
    @classmethod
    def library_statistics(cls):
        return f"Il numero totale dei libri è {cls.total_books}"



'''DRIVER PROGRAM - Iniziamo il programma con i dati'''

#Creazione libri da stringa
book_str1 = "Il Gattopardo, G. Tomasi, 111"
book_str2 = "1984, G. Orwell, 222"
book1 = BookClass.from_string(book_str1)
book2 = BookClass.from_string(book_str2)

#Creazione membri da stringa
member_str1 = "Mario Rossi, M001"
member_str2 = "Laura Bianchi, M002"
member1 = MemberClass.from_string(member_str1)
member2 = MemberClass.from_string(member_str2)

#Istanza della classe Library
library = LibraryClass()

#Registrazione membri
library.register_member(member1)
library.register_member(member2)

#Aggiunta dei libri
library.add_book(book1)
library.add_book(book2)

#Stato iniziale della libreria
print("STATO PRIMA DEL PRESTITO:")
print(library)
print(LibraryClass.library_statistics())

#Prestito di un libro
library.lend_book(book1, member1)

#Stato della libreria dopo il prestito
print("\nSTATO DOPO IL PRESTITO:")
print(library)
print(LibraryClass.library_statistics())




        

        
        





        



    
        
