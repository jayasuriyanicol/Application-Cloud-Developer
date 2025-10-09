'''
Esercizio NUMERO 1

Classe AppointmentScheduler - PUNTI 2

Progetta una classe AppointmentScheduler per gestire un insieme di appuntamenti.
Attributi:

○ appointments: dict[str, dict]: il dizionario appointments contiene
tutti gli appuntamenti. In dettaglio, la chiave è un app_id (stringa) e il valore
è un altro dizionario che per ogni appuntamento ha le seguenti coppie chiave,
valore:

■ Chiave: str = "data" e Valore: str = “Una data
dell'appuntamento…”
■ Chiave: str = "programmato": e Valore: bool = True oppure
False

Funzioni:
○ schedule_appointment(app_id: str, data: str) -> dict |
str
Se app_id esiste già: restituisci "Errore: appuntamento esiste già.", altrimenti
aggiungi il nuovo appuntamento (con programmato=True) e restituisci un
dizionario con il solo appuntamento appena creato.
○ reschedule_appointment(app_id: str, nuova_data: str) ->
dict | str
Se non esiste restituisci: "Errore: appuntamento non trovato.", altrimenti
aggiorna la data e restituisci un dizionario con il solo appuntamento
aggiornato.
○ cancel_appointment(app_id: str) -> dict | str
Se non esiste restituisci: "Errore: appuntamento non trovato.", altrimenti
imposta programmato=False e restituisci un dizionario con il solo
appuntamento aggiornato.
○ remove_appointment(app_id: str) -> dict | str
Se non esiste restituisci: "Errore: appuntamento non trovato.", altrimenti
rimuovi e restituisci un dizionario con il solo appuntamento rimosso.
○ list_appointments() -> list[str]
Restituisce la lista di tutti gli app_id.
○ get_appointment(app_id: str) -> dict | str
Restituisce il dict dell'appuntamento o "Errore: appuntamento non trovato."

'''


