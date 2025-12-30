'''
Sistema di Prenotazione Cinema

Sviluppa un sistema in Python che gestisca le prenotazioni per un cinema. Il cinema ha diverse sale, ognuna con un diverso film in programmazione. 
Gli utenti possono vedere quali film sono disponibili e prenotare posti per un determinato spettacolo.
 
Classi:
- Film: Rappresenta un film con titolo e durata.
 
- Sala: Rappresenta una sala con numero identificativo, film attualmente in programmazione, posti totali, posti prenotati.

Metodi:
    - prenota_posti(num_posti): Prenota un certo numero di posti nella sala, se disponibili. Restituisce un messaggio di conferma o di errore.
    - posti_disponibili(): Restituisce il numero di posti ancora disponibili nella sala.
 
- Cinema: Gestisce le operazioni legate alla gestione delle sale.

Metodi:
    - aggiungi_sala(sala): Aggiunge una nuova sala al cinema.
    - prenota_film(titolo_film, num_posti): Trova il film desiderato e tenta di prenotare posti. Restituisce un messaggio di stato.

Test case:

    Un gestore del cinema configura le sale aggiungendo i film e i dettagli dei posti.
    Un cliente sceglie un film e prenota un certo numero di posti.
    Il sistema verifica la disponibilità e conferma o rifiuta la prenotazione.

'''

'''
Sistema di Prenotazione Cinema

Sviluppa un sistema in Python che gestisca le prenotazioni per un cinema. Il cinema ha diverse sale, ognuna con un diverso film in programmazione. 
Gli utenti possono vedere quali film sono disponibili e prenotare posti per un determinato spettacolo.
'''

#Creiamo la classe Film che rappresenta un film con titolo e durata
class Film:

    def __init__(self, titolo: str, durata: int) -> None:
        self.titolo = titolo
        self.durata = durata


#Creiamo la classe Sala, che contiene ID, film in programmazione e i posti totali e prenotati
class Sala:

    def __init__(self, numeroIdentificativo: str, filmAttualeProgrammazione: Film, postiTotali: int) -> None:
        self.numeroIdentificativo = numeroIdentificativo
        self.filmAttualeProgrammazione = filmAttualeProgrammazione
        self.postiTotali = postiTotali
        self.postiPrenotati = 0


    #Metodo per prenotare un certo numero di posti nella sala, se disponibili
    def prenota_posti(self, num_posti: int) -> str:

        differenzaPostiDisponibili: int = self.postiTotali - self.postiPrenotati

        if num_posti <= 0:
            return f"ATTENZIONE! Inserire un numero di posti valido e positivo."

        if num_posti <= differenzaPostiDisponibili:
            self.postiPrenotati += num_posti
            return f"SUCCESSO! Sono stati prenotati {num_posti} posti per '{self.filmAttualeProgrammazione.titolo}'."

        return f"ATTENZIONE! Disponibili solo {differenzaPostiDisponibili} posti per '{self.filmAttualeProgrammazione.titolo}'."
    

    #Metodo per visualizzare quanti posti sono ancora disponibili
    def posti_disponibili(self) -> str:
        postiDisponibiliSala: int = self.postiTotali - self.postiPrenotati
        return f"I posti ancora disponibili nella sala '{self.numeroIdentificativo}' sono {postiDisponibiliSala}."


#Creiamo la classe Cinema che gestisce tutte le sale
class Cinema:

    def __init__(self)-> None:
        self.sale = []

    #Metodo per aggiungere una nuova sala al cinema
    def aggiungi_sala(self, sala: Sala) -> str:
        self.sale.append(sala)
        return f"SUCCESSO! Aggiunta la sala con ID '{sala.numeroIdentificativo}' che proietta il film '{sala.filmAttualeProgrammazione.titolo}'."

    #Metodo per prenotare un film tramite titolo e numero posti richiesti
    def prenota_film(self, titolo_film: str, num_posti: int) -> str:

        for sala in self.sale:
            if sala.filmAttualeProgrammazione.titolo.lower() == titolo_film.lower():
                return sala.prenota_posti(num_posti)

        return f"ATTENZIONE! Il film '{titolo_film}' non è in programmazione in nessuna sala o è stato scritto in modo errato."



#TEST CASE (verifica corretto funzionamento del sistema) 

#Creo il film e la sala
film1 = Film("Matrix", 120)
sala1 = Sala("SAL001", film1, 100)

#Creo il cinema e aggiungo la sala
cinema = Cinema()
print(f"\n{cinema.aggiungi_sala(sala1)}")

#Effettuo prenotazioni, primo OK secondo MESAAGGIO ERRORE
print(f"\n{cinema.prenota_film('Matrix', 10)}")   
print(f"\n{cinema.prenota_film('Matrix', 95)}")   

#Verifico i posti ancora disponibili
print(f"\n{sala1.posti_disponibili()}")
