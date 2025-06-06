'''
Progettare un sistema di videonoleggio con i seguenti requisiti:
1. Classe Movie:
Attributi:
● movie_id: str - Identificatore di un film.
● title: str - Titolo del film.
● director: str - Regista del film.
● is_rented: boolean - Booleano che indica se il film è noleggiato o meno.
Metodi:
● rent(): Contrassegna il film come noleggiato se non è già noleggiato. Se il film
non è già noleggiato imposta is_rented a True, altrimenti stampa il messaggio "Il
film '{self.title}' è già noleggiato."
● return_movie(): Contrassegna il film come restituito. Se il film è già noleggiato
imposta is_rented a False, altrimenti stampa il messaggio "Il film '{self.title}' non è
stato noleggiato da questo cliente."
2. Classe Customer:
Attributi:
● customer_id: str - Identificativo del cliente.
● name: str - Nome del cliente.
● rented_movies: list[Movie] - Lista dei film noleggiati.
Metodi:
● rent_movie(movie: Movie): Aggiunge il film nella lista rented_movies se non è già
stato noleggiato, altrimenti stampa il messaggio "Il film '{movie.title}' è già
noleggiato."
● return_movie(movie: Movie): Rimuove il film dalla lista rented_movies se già
presente, altrimenti stampa il messaggio "Il film '{movie.title}' non è stato
noleggiato da questo cliente."
3. Classe VideoRentalStore:
Attributi:
● movies: dict[str, Movie] - Dizionario che ha per chiave l'id del film e per valore
l'oggetto Movie.
● customers: dict[str, Customer] - Dizionario che ha per chiave l'id del cliente e per
valore l'oggetto Customer.

Metodi:
● add_movie(movie_id: str, title: str, director: str): Aggiunge un nuovo film nel
videonoleggio se non è già presente, altrimenti stampa il messaggio "Il film con
ID '{movie_id}' esiste già."
● register_customer(customer_id: str, name: str): Iscrive un nuovo cliente nel
videonoleggio se non è già presente, altrimenti stampa il messaggio "Il cliente
con ID '{customer_id}' è già registrato."
● rent_movie(customer_id: str, movie_id: str): Permette al cliente di noleggiare un
film se entrambi esistono nel videonoleggio, altrimenti stampa il messaggio
"Cliente o film non trovato."
● return_movie(customer_id: str, movie_id: str): Permette al cliente di restituire un
film se entrambi esistono nel videonoleggio, altrimenti stampa il messaggio
"Cliente o film non trovato."
● get_rented_movies(customer_id: str): list[Movie] - Restituisce la lista dei film
noleggiati dal client (customer.rented_movies) se il cliente esiste nel
videonoleggio, altrimenti stampa il messaggio "Cliente non trovato." e ritorna una
lista vuota.
'''



class  Movie:


    def __init__(self,movie_id:str, title:str, director:str, is_rented=False):

        self.movie_id = movie_id
        self.title = title
        self.director = director
        self.is_rented = is_rented



    def rent(self)-> None:

        if not self.is_rented:
         
         self.is_rented = True

        else:
             print(f"Il film '{self.title}' è già noleggiato.")


    
    
    def return_movie(self) -> None:

        if self.is_rented:
            self.is_rented = True
        else:
            self.is_rented = False
            print(f"Il film è stato '{self.title} non è stato noleggiato")


class Customer:

    def __init__(self, customer_id:str, name:str, rented_movies:list[Movie])-> None:
        

        self.customer_id = customer_id
        self.name = name
        self.rented_movies = rented_movies

    
    def rent_movie(self, movie:Movie) -> None:

        if movie.is_rented and movie not in self.rented_movies:
            
            movie.rent()
            self.rented_movies.append(movie)
        else: 
            print(f"Il film {movie.title} è già noleggiato !")
            

    def return_movie(self, movie:Movie) -> None:

        if movie in self.rented_movies:
            
            movie.return_movie()
            self.rented_movies.remove(movie)
        else:   
            print(f"Il film {movie.title} non è stato noleggiato da questo cliente")



class VideoRentalStore:


    def __init__(self, movies: dict[str,Movie] = {}, customers: dict[str,Customer] = {}) -> None:
           
           self.movies = movies
           self.customers = customers

    
    def add_movie(self,movie_id:str,title:str,director:str) -> None:

        if movie_id in self.movies:

            print(f"Il film con ID {movie_id} esiste già")

        else:

            movie: Movie = Movie(movie_id = movie_id, title=title, director=director)
            
            self.movies[movie_id] = movie  

    def register_customer(self, customer_id:str, name:str) -> None:

        if customer_id in self.customers:

            print(f"Il cliente con ID '{customer_id}' è già registrato.")

        else:

            customer: Customer = Customer(customer_id, name) 
 
            self.customers[customer_id] = customer 
        

    def rent_movie(self,customer_id:str, movie_id:str) -> None: 

        if customer_id in self.customers and movie_id in self.movies:
           
           #Possiamo richiamare la funzione rent_movie () -> del cliente e passare come parametro self.movies[movie_id], invece di crearne una nuova  
           self.customers[customer_id].rent_movie(self.movies[movie_id])  
        else:

            print("Cliente o film non trovato.")

            


    def return_movie(self,customer_id:str, movie_id:str) -> None:

       if customer_id in self.customers and movie_id in self.movies:
           
           #Svolge la stessa medesima cosa, solamente che utilizza la funzione return_movie return_movie
           self.customers[customer_id].return_movie(self.movies[movie_id])  

       else:

             print("Cliente o film non trovato.")


            
        
    def get_rented_movies(self, customer_id:str) -> list[Movie]:
        

        if customer_id in self.customers:

            return self.customers[customer_id].rented_movies  
        else:
            

            #Ritorniamo il messaggio e la lista vuota come specificato dall'esercizio
            print(f"Cliente non trovato.")

            return [] 
    


    '''FUNZIONE AGGIUNTIVA - ALLENAMENTO FUORI DALLA CONSEGNA'''

    #Crea funzione con return lista tutti i film che sono stati noleggiati fino ad adesso 
    def returnAllMoviesRented(self) -> list[Movie] :


        listaMovies:list[Movie]  = [] 

        for _, cliente in self.customers.items():
                
                listaMovies += cliente.rented_movies

        return listaMovies
    


'''DRIVER PROGRAMM - Per Testare la funzionalità'''


if __name__ == "__main__":

    #Creazione del videonoleggio
    store = VideoRentalStore()

    #Aggiunta di film
    store.add_movie("M001", "Inception", "Christopher Nolan")
    store.add_movie("M002", "Interstellar", "Christopher Nolan")
    store.add_movie("M003", "The Matrix", "Lana Wachowski")

    #Tentativo di aggiungere un film già esistente
    store.add_movie("M001", "Duplicato", "Qualcun Altro")

    #Registrazione clienti
    store.register_customer("C001", "Alice")
    store.register_customer("C002", "Bob")

    #Tentativo di registrare lo stesso cliente
    store.register_customer("C001", "Alice Duplicato")

    #Noleggio film
    store.rent_movie("C001", "M001")
    store.rent_movie("C002", "M001")
    store.rent_movie("C002", "M002")

    #Lista film noleggiati da Alice
    print("\nFilm noleggiati da Alice:")
    for movie in store.get_rented_movies("C001"):
        print(f"- {movie.title} di {movie.director}")

    #Lista film noleggiati da Bob
    print("\nFilm noleggiati da Bob:")
    for movie in store.get_rented_movies("C002"):
        print(f"- {movie.title} di {movie.director}")

    #Tentativo di restituire un film non noleggiato
    store.return_movie("C001", "M003")

    #Restituzione di un film correttamente
    store.return_movie("C002", "M002")

    #Stato aggiornato dopo restituzione
    print("\nFilm noleggiati da Bob dopo restituzione:")
    for movie in store.get_rented_movies("C002"):
        print(f"- {movie.title}")

    #Lista totale di film noleggiati nel sistema
    print("\nTutti i film attualmente noleggiati:")
    for movie in store.returnAllMoviesRented():
        print(f"- {movie.title}")
