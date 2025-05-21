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


class Film:

    def __init__(self, titolo: str, durata: int) -> None:
        self.titolo = titolo
        self.durata = durata


class Sala:

    def __init__(self, numeroIdentificativo: str, filmAttualeProgrammazione: Film, postiTotali: int) -> None:
        self.numeroIdentificativo = numeroIdentificativo
        self.filmAttualeProgrammazione = filmAttualeProgrammazione
        self.postiTotali = postiTotali
        self.postiPrenotati = 0

    def prenota_posti(self, num_posti: int) -> str:

        differenzaPostiDisponibili: int = self.postiTotali - self.postiPrenotati

        if num_posti <= 0:
            return f"ATTENZIONE! inserire un numero di posti coerente alla capienza della SALA !"

        if num_posti <= differenzaPostiDisponibili:

            self.postiPrenotati += num_posti

            return f"SUCCESSO! sono stati prenotati {num_posti}"
        
        return f"ATTENZIONE ! sono rimanenti solo {differenzaPostiDisponibili} posti, non {num_posti} posti come richiesto !"

    def posti_disponibili(self) -> str:

        postiDisponibiliSala: int = self.postiTotali - self.postiPrenotati

        return f"I POSTI disponibili nella sala sono {postiDisponibiliSala} posti !"


class Cinema:

    def __init__(self):
        self.sale = []

    def aggiungi_sala(self, sala: Sala) -> str:
        self.sale.append(sala)
        return f"SUCCESSO! È stata aggiunta una nuova sala con ID {sala.numeroIdentificativo} !"

    def prenota_film(self, titolo_film: str, num_posti: int) -> str:

        for sala in self.sale:
            if sala.filmAttualeProgrammazione.titolo.lower() == titolo_film.lower():
                return sala.prenota_posti(num_posti)

        return f"ATTENZIONE ! per il FILM '{titolo_film}' sintassi o titolo del film ERRATO/NON ESISTENTE oppure non presente in NESSUNA SALA !"



film1 = Film("Matrix", 120)
sala1 = Sala("SAL001", film1, 100)

cinema = Cinema()
film1 = Film("Matrix", 120)
sala1 = Sala(1, film1, 100)
cinema = Cinema()

print(f"\n{cinema.aggiungi_sala(sala1)}")

print(f"\n{cinema.prenota_film('Matrix', 10)}")
print(f"\n{cinema.prenota_film('Matrix', 95)}")  
print(f"\n{sala1.posti_disponibili()}")

