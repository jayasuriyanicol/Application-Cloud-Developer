'''
ESERCIZIO NUMERO 2

Sistema di Gestione di un Cinema - PUNTI 2

Implementa tre classi interagenti per gestire biglietti di film.

Classe Ticket:
Attributi
○ ticket_id: str
○ movie: str
○ seat: str
○ is_booked: bool
Metodi:
○ book() -> None: se "is_booked" è False, lo imposta a True; altrimenti
stampa "Il biglietto per '{self.movie}' posto '{self.seat}' è già prenotato."
○ cancel() -> None: se "is_booked" è True, lo imposta a False;
altrimenti stampa "Il biglietto per '{self.movie}' posto '{self.seat}' non risulta
prenotato."
Classe Viewer:
Attributi
○ viewer_id: str
○ name: str
○ booked_tickets: list[Ticket]



Metodi:
○ book_ticket(ticket: Ticket) -> None: se "ticket.is_booked"
è False, aggiunge "ticket" a "booked_tickets" e chiama
"ticket.book()"; altrimenti stampa "Il biglietto per '{ticket.movie}' non è
disponibile."
○ cancel_ticket(ticket: Ticket) -> None: se "ticket" è in
"booked_tickets", lo rimuove e chiama "ticket.cancel()"; altrimenti
stampa "Il biglietto per '{ticket.movie}' non è stato prenotato da questo
spettatore."


Classe Cinema:
Attributi
○ tickets: dict[str, Ticket]
○ viewers: dict[str, Viewer]


Metodi:
○ add_ticket(ticket_id: str, movie: str, seat: str) -> None:
se "ticket_id" esiste: stampa "Il biglietto con ID '{ticket_id}' esiste già.",
altrimenti aggiunge un nuovo "Ticket".
○ register_viewer(viewer_id: str, name: str) -> None: se
"viewer_id" esiste: stampa "Lo spettatore con ID '{viewer_id}' è già
registrato.", altrimenti aggiunge un nuovo "Viewer".
○ book_ticket(viewer_id: str, ticket_id: str) -> None: se
entrambi esistono, invoca "viewer.book_ticket(ticket)"; altrimenti
stampa "Spettatore o biglietto non trovato."
○ cancel_ticket(viewer_id: str, ticket_id: str) -> None: se
entrambi esistono, invoca "viewer.cancel_ticket(ticket)"; altrimenti
stampa "Spettatore o biglietto non trovato."
○ list_available_tickets() -> list[str]: restituisce la lista di
"ticket_id" con "is_booked == False".
○ list_viewer_bookings(viewer_id: str) -> list[str] | str:
■ se lo spettatore esiste, restituisce lista di \"ticket_id\" prenotati;
■ Altrimenti restituisce "Errore: spettatore non trovato."

'''




