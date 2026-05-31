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


class AppointmentScheduler:


    def __init__(self)-> None:

        self.appointments:dict[str,dict] = {} 

        '''
        Esempio di DICT:

        {'A01': {'data': '05 Giugno 2023', 'programmato' : 'false' }

        Esempio di dizionario, formato da una chiave str e da un dizionario annidato al suo interno con chiavi 'data' e 'programmato'
        
        '''  


    def schedule_appointment(self,app_id:str,data:str) -> dict | str:

        if app_id in self.appointments:

            return "Errore: appuntamento esiste già"
        else:

            self.appointments[app_id] = {"data": data, "programmato" : True}
        return {app_id: self.appointments[app_id]} 
    


    def reschedule_appointment(self,app_id:str,nuova_data:str) -> dict | str:

        if app_id not in self.appointments:

            return "Errore: appuntamento non trovato"
        else:
         self.appointments[app_id]["data"] =  nuova_data 

        return { app_id: self.appointments[app_id]} 
    

    
    def cancel_appointment(self,app_id:str) -> dict | str:

        if app_id not in self.appointments:
            return "Errore: appuntamento non trovato"
        else:
            self.appointments[app_id]["programmato"] = False

        return {app_id : self.appointments[app_id]} 
    
   

    def remove_appointment(self, app_id: str) -> dict | str:

        if app_id not in self.appointments:
            return "Errore: appuntamento non trovato."
        else:
          appuntamentoRimosso = {app_id: self.appointments.pop(app_id)}

        return appuntamentoRimosso

    

    def list_appointments(self)-> list[str]:

        listaId:list[str] = []

        for elem in self.appointments.keys():

            listaId.append(elem)  
        return listaId
    

    
    
    def get_appointment(self,app_id:str) -> dict | str:

        if app_id in self.appointments:

                return {app_id: self.appointments[app_id]} 
            
        else: 
                return "Errore: appuntamento non trovato"
    


'''DRIVER PROGRAMM'''

sched = AppointmentScheduler()

print(sched.schedule_appointment("A01", "10 Ottobre 2025"))
print(sched.schedule_appointment("A02", "12 Ottobre 2025"))

print(sched.reschedule_appointment("A02", "11 Ottobre 2025"))

print(sched.cancel_appointment("A01"))

print(sched.get_appointment("A01"))

print(sched.remove_appointment("A01"))

print(sched.list_appointments())
