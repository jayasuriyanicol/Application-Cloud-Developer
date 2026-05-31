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


class Ticket:



    def __init__(self,ticket_id:str, movie:str,seat:str,is_booked:bool) -> None:


        self.ticket_id = ticket_id
        self.movie = movie
        self.seat = seat
        self.is_booked = is_booked 

    
    def book (self) -> None:

        if not self.is_booked:

            self.is_booked = True
        else:
            print(f"Il biglietto per '{self.movie}' posto '{self.seat}' è già prenotato")
    
    def cancel(self) -> None:

        if self.is_booked:
            self.is_booked = False
        else:
            print(f"Il biglietto per '{self.movie}' posto '{self.seat}' non risulta prenotato.")


    
class Viewer:


    def __init__(self,viewer_id:str, name:str) -> None:


        self.viewer_id = viewer_id
        self.name = name
        self.booked_tickets: list[Ticket] =  [] 



    def book_ticket(self,ticket:Ticket) -> None:

        if not ticket.is_booked:

            self.booked_tickets.append(ticket)

            ticket.book()
        else:
            print(f"Il biglietto per '{ticket.movie}' non è disponibile. ")
        

    def cancel_ticket(self,ticket:Ticket) -> None:

        if ticket in self.booked_tickets:

            self.booked_tickets.remove(ticket)

            ticket.cancel()
        else:
             
            print(f"Il biglietto per '{ticket.movie}' non è stato prenotato da questo spettatore.")
        

class Cinema:

    def __init__(self) -> None:

        self.tickets: dict[str, Ticket] = {} 
        self.viewers: dict[str, Viewer] = {} 
    
    def add_ticket(self,ticket_id:str, movie:str,seat:str) -> None:

        if ticket_id in self.tickets:

            print(f"Il biglietto con ID '{ticket_id}' esiste già.")
        else:
            self.tickets[ticket_id] = Ticket(ticket_id, movie, seat,False)
    
    def register_viewer(self,viewer_id:str, name:str) -> None:


        if viewer_id in self.viewers.keys():

            print(f"Lo spettatore con ID '{viewer_id}' è già registrato.")
        else:
            self.viewers[viewer_id] =  Viewer(viewer_id, name)
        

    def book_ticket(self, viewer_id:str, ticket_id: str) -> None:

        if ticket_id in self.tickets and viewer_id in self.viewers:
            
            viewer = self.viewers[viewer_id]
            ticket = self.tickets[ticket_id]    
            viewer.book_ticket(ticket)
        else:
            print("Spettatore o biglietto non trovato.")
    

    def cancel_ticket(self, viewer_id:str, ticket_id: str) -> None:

        if ticket_id in self.tickets.keys() and viewer_id in self.viewers.keys():

            viewer = self.viewers[viewer_id]
            ticket = self.tickets[ticket_id]   
            viewer.cancel_ticket(ticket)
        else:
            print("Spettatore o biglietto non trovato.")

    def list_available_tickets(self) -> list[str] :


        lista:list[str] = []

        for key,value in self.tickets.items():

            if not value.is_booked :

                 lista.append(key)
        return lista
    

    def list_viewer_bookings (self,viewer_id:str) -> list[str] | str:

        lista:list[str] = []   
        if viewer_id in self.viewers:

            viewer = self.viewers[viewer_id]
        

            for ticket in viewer.booked_tickets:

                 lista.append(ticket.ticket_id)
            return lista

        else:
            return "Errore: spettatore non trovato" 
        
 

