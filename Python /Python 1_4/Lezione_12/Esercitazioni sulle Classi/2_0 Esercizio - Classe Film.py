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


#Creiamo la classe Film, dove inseriamo il titolo e il nome del regista. Ogni istanza rappresenterà un singolo film associato a un regista.
class Film:
    def __init__(self, titolo: str, regista: str):
        self.titolo = titolo
        self.regista = regista


#Ora andiamo a creare la classe MovieCatalog, che conterrà tutte le operazioni richieste: aggiunta, rimozione, ricerca per titolo e visualizzazione dei film per regista.
class MovieCatalog:


    # Utilizziamo un dizionario con chiave = regista, valore = lista di titoli
    def __init__(self):
        self.catalogo = {}  

    def add_movie(self, titolo: str, regista: str):
        nuovoFilm = Film(titolo, regista)

        if regista not in self.catalogo:
            self.catalogo[regista] = []

        self.catalogo[regista].append(nuovoFilm.titolo)

        return f"\nSUCCESSO! Il film '{titolo}' è stato aggiunto sotto il regista {regista}."
    


    def remove_movie (self, titolo: str, regista: str):

        if regista in self.catalogo:
            if titolo in self.catalogo[regista]:
                self.catalogo[regista].remove(titolo)

                # Se il regista non ha più film, lo rimuoviamo dal catalogo
                if not self.catalogo[regista]:
                    del self.catalogo[regista]

                return f"\nRIMOZIONE EFFETTUATA! Il film '{titolo}' è stato rimosso da {regista}."

            else:
                return f"\nERRORE! Il film '{titolo}' non è presente per il regista {regista}."
        else:
            return f"\nERRORE! Il regista {regista} non è presente nel catalogo."
        



    def list_directors(self):
        print("\nElenco dei registi nel catalogo:")

        if self.catalogo:
            for regista in self.catalogo:
                print("-", regista)
        else:

            print("Nessun regista presente nel catalogo.")



    def get_movies_by_director(self, regista: str):


        if regista in self.catalogo:

            print(f"\nFilm diretti da {regista}:")

            for titolo in self.catalogo[regista]:
                print("-", titolo)

        else:
            print(f"\nIl regista '{regista}' non è presente nel catalogo.")





    def search_movies_by_title(self, parola: str):

        trovati = []

        for regista in self.catalogo:

            for titolo in self.catalogo[regista]:

                if parola.lower() in titolo.lower():
                    trovati.append((titolo, regista))

        print(f"\n Risultati ricerca per la parola '{parola}':")


        if trovati:

            for titolo, regista in trovati:
                print(f" '{titolo}' di {regista}")
        else:
            print("Nessun film trovato con quella parola nel titolo.")



'''Avviamo un DRIVER PROGRAM come viene richiesto dall'esercizio'''

#Ora inseriamo dei dati per testare il corretto funzionamento del programma
mioCatalogo = MovieCatalog()

#Aggiungiamo 3 film con i rispettivi registi
print(mioCatalogo.add_movie("Better Call Saul", "George Vincent Gilligan Jr"))
print(mioCatalogo.add_movie("Top Boy", "Yann Demange"))
print(mioCatalogo.add_movie("Snowfall", "John Singleton"))

#Visualizziamo tutti i registi presenti
mioCatalogo.list_directors()

#Visualizziamo tutti i film di un regista specifico
mioCatalogo.get_movies_by_director("George Vincent Gilligan Jr")

#Rimuoviamo un film e verifichiamo la corretta rimozione
print(mioCatalogo.remove_movie("Better Call Saul", "George Vincent Gilligan Jr"))
mioCatalogo.get_movies_by_director("George Vincent Gilligan Jr")

#Effettuiamo ricerche per parole chiave presenti e non presenti
mioCatalogo.search_movies_by_title("top")
mioCatalogo.search_movies_by_title("snowfall")
mioCatalogo.search_movies_by_title("call")
# Parola non presente
mioCatalogo.search_movies_by_title("fantasy")  

