'''
Classe TaskManager - PUNTI 2
Progetta una classe TaskManager per gestire un insieme di attività.
Attributi:
- tasks: dict[str, dict] : il dizionario tasks contiene tutte le attività. La chiave è un task_id (stringa) e il
valore è un dizionario con:
• Chiave: "descrizione" (str)
• Chiave: "completato" (bool)
Metodi:
- add_task(task_id: str, descrizione: str) -> dict | str
- update_task(task_id: str, nuova_descrizione: str) -> dict | str
- mark_completed(task_id: str) -> dict | str
- remove_task(task_id: str) -> dict | str
- list_tasks() -> list[str]
- get_task(task_id: str) -> dict | str

'''


class TaskManager:


    def __init__(self) -> None:
        
        self.tasks:dict[str,dict[str,str,str,bool]] = {}


    def add_task(self,task_id:str, descrizione: str) -> dict|str:

        if task_id in self.tasks:

            return "Errore: è già presente una TASK !"
        
        else:

            inserimento = self.tasks[task_id] = { "descrizione": descrizione, "completato" : False }   

            return inserimento

    def update_task (self,task_id:str, nuova_descrizione: str) -> dict |str:

        if task_id in self.tasks:

            sostituzione  = self.tasks[task_id] = {"descrizione" : nuova_descrizione, "completato" : False}

            return sostituzione

        else:

            return "Errore: non è presente nessun TASK ID " 
        
    
    def mark_completed(self,task_id:str) -> dict |str:

        if task_id in self.tasks:

            completato = self.tasks[task_id] = {"completato" : True}
            return {completato}
        
        else:

            return "Errore: non è presente nessun TASK ID"
        

    def remove_task (self,task_id:str) -> dict|str:

        if task_id in self.tasks:

            rimuovi = self.tasks.pop[task_id]  

            return {rimuovi}
        
        else:

            return "Errore: non è presente nessun TASK ID"
    
    def list_task (self) -> list[str]:   

        listaTask:list[str] = []

        for elemento in self.tasks.keys():

            listaTask.append(elemento)
        return listaTask
    

    def get_task (self,task_id:str) -> dict|str:

        if task_id in self.tasks:

            return {task_id : self.tasks[task_id]} 
        
        else:

            return "Errore: non è presente nessun TASK ID"


            



               

