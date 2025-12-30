
'''CODICE DRIVER

### Test con codice driver
Scrivere un codice driver in cui si crea una lista di 10 film, di cui 5 sono film d'azione, 4 sono commedie e 1 è un film drammatico. Successivamente:

    Creare un oggetto Noleggio.
    Stampare: "Quale film vuoi nolleggiare?"
    Simulare il noleggio di un film di un primo cliente.
    Simulare il noleggio di un secondo film sempre da parte del primo cliente.
    Simulare il noleggio del film precedente da parte di un secondo cliente. (assicurarsi che il codice avvisi il secondo cliente che il film richiesto non è disponibile).
    Simulare il noleggio di un terzo film da parte del secondo cliente.
    Simulare il reso del secondo film noleggiato dal primo cliente.
    Stampare la lista dei film disponibili in negozio.



'''


from film import *
from movie_genre import *
from noleggio import *

primoFilm: Film = Azione(1, "Bolt vs Francesco")
secondoFilm: Film = Azione(2, "Cane vs Fingu")
terzoFilm: Film = Azione(3, "Cane vs Pesce")
quartoFilm: Film = Azione(4, "Cristiano vs Marcel")
quintoFilm: Film = Azione(5, "Albero vs Nicol")
sestoFilm: Film = Commedia(6, "Il lamento del bambino")
settimoFilm: Film = Commedia(7, "La storia del contadino")
ottavoFilm: Film = Commedia(8, "Amore Perso")
nonoFilm: Film = Commedia(9, "La perdita dell'asino")
decimoFilm: Film = Drama(10, "La vita")

lista_film = [
    primoFilm, secondoFilm, terzoFilm, quartoFilm, quintoFilm,
    sestoFilm, settimoFilm, ottavoFilm, nonoFilm, decimoFilm
]


noleggioFilm = Noleggio(lista_film)

print("\nQuale film vuoi noleggiare?\n")


noleggioFilm.rentAMovie(primoFilm, 101)


noleggioFilm.rentAMovie(secondoFilm, 101)


noleggioFilm.rentAMovie(secondoFilm, 202)


noleggioFilm.rentAMovie(terzoFilm, 202)


noleggioFilm.giveBack(secondoFilm, 101, 4)


noleggioFilm.printMovies()


noleggioFilm.printRentMovies(101)
noleggioFilm.printRentMovies(202)


