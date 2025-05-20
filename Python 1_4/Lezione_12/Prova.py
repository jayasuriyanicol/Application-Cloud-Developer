
'''
Sistema di Gestione Catalogo Film 
Sviluppa un sistema in Python per la gestione di un catalogo film che permetta di aggiungere, rimuovere e cercare film di un particolare regista. 
Il sistema dovrebbe consentire anche di visualizzare tutti i registi e i loro film.

Classe:
- MovieCatalog: Gestisce tutte le operazioni legate al catalogo dei film.

    Metodi della classe:
    - add_movie(director_name, movies): Aggiunge uno o più film a un regista specifico nel catalogo. Se il regista non esiste, viene creato un nuovo record. 
     Se il regista esiste, la sua lista di film viene aggiornata.

    - remove_movie(director_name, movie_name): Rimuove un film specifico dall'elenco dei film di un regista. Se tutti i film sono rimossi,
      il regista può essere opzionalmente rimosso dal catalogo.

    - list_directors(): Elenca tutti i registi presenti nel catalogo.

    - get_movies_by_director(director_name): Restituisce tutti i film di un regista specifico.

    - search_movies_by_title(title): Trova tutti i film che contengono una certa parola nel titolo. 
      Restituisce un elenco dei registi e dei rispettivi film che contengono la parola cercata o un messaggio di errore se nessun film contiene la parola cercata nel titolo.
 
Codice driver

    Crea un’istanza della classe MovieCatalog.
    Aggiungi nuovi film e registi.
    Aggiungi film a registi già presenti nel catalogo.
    Rimuovi film dal catalogo.
    Elenca i registi presenti nel catalogo.
    Visualizza film di uno specifico regista.
    Cerca film per parola chiave nel titolo, gestendo il caso con risultati che senza.

'''


class Film:

    def __init__(self,titolo:str,regista:str):
        self.titolo = titolo
        self.regista = regista
    


class MovieCatalog:

    def __init__(self) -> None:

        self.catalogoFilm:dict[str,str] = {}



    def add_movie(self,directory_name:str, movies:str,titolo:str,regista:str):
        nuovoFilm = Film(titolo,regista)


        if directory_name not in self.catalogoFilm:

            self.catalogoFilm[regista] = []  

            self.catalogoFilm.append(nuovoFilm.titolo)

            return f"SUCCESSO! il regista {regista} è stato salvato con i suoi relativi FILM !"
        
        else: 

            return f"ERRORE! Attenzione il regista {regista} non è stato salvato con i suoi FILM !"
        

    
    def remove_film(self,directory_name:str, movie_name:str,regista:str,titolo:str):

        if regista not in self.catalogoFilm:

            self.catalogoFilm[regista] = []

            if movie_name in self.catalogoFilm:

             del self.catalogoFilm(movie_name)

            else: 
                 f"ATTENZIONE! Non risulta nessun film con il nome {movie_name} !"  

            return f"SUCCESSO! è stato eliminato il film {movie_name}"
        
    
    



