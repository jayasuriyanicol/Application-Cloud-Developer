'''
In questo esercizio dovrai scrivere il codice per un sistema che gestisce un centro di assistenza per dispositivi elettronici che espone alcune informazioni e funzionalità tramite un’applicazione Flask. L’obiettivo è sperimentare metodi HTTP (POST, PUT, PATCH, DELETE) e test con requests.
Centro di Assistenza per Dispositivi Elettronici
Classe Device (astratta)

La classe Device rappresenta un dispositivo elettronico generico preso in carico dal centro di assistenza. È una classe astratta e non può essere istanziata direttamente.

Ogni dispositivo ha:

    un identificativo id di tipo stringa (es. "d1", "d2"),

    un modello model di tipo stringa (es. "iPhone 13", "ThinkPad X1"),

    un nome cliente customer_name di tipo stringa,

    un anno di acquisto purchase_year di tipo intero,

    uno stato della riparazione status di tipo stringa, con valori possibili (a scelta, ma ad esempio):

        "received" (ricevuto),

        "diagnosing" (in diagnosi),

        "repairing" (in riparazione),

        "ready" (pronto per il ritiro),

        "delivered" (consegnato al cliente).

Metodi

    device_type(): metodo astratto
    Deve essere implementato nelle sottoclassi per restituire il tipo di dispositivo (es. "smartphone", "laptop").

    base_diagnosis_time(): metodo astratto
    Deve essere implementato nelle sottoclassi e deve restituire il tempo base di diagnosi in minuti (int).

    repair_complexity(): metodo astratto
    Deve essere implementato nelle sottoclassi e restituire un indicatore (ad esempio un numero intero) che descrive la complessità media di riparazione di quel tipo di dispositivo.

    info(): 
    Restituisce un dizionario con le informazioni principali del dispositivo, ad esempio:

    {
        "id": ...,
        "device_type": ...,
        "model": ...,
        "customer_name": ...,
        "purchase_year": ...,
        "status": ...,
        # più eventuali campi specifici delle sottoclassi
    }

    estimated_total_time(factor: float = 1.0):
    Calcola un tempo stimato di lavorazione (diagnosi + riparazione) sulla base di:

        base_diagnosis_time(),

        repair_complexity(),

        fattore di carico factor (float, default 1.0).

    La formula è base_diagnosis_time() * factor + repair_complexity() * 30 e deve restituire un intero (minuti).

Classe Smartphone

La classe Smartphone rappresenta uno smartphone e eredita da Device.
Attributi aggiuntivi

    has_protective_case: bool che indica se il dispositivo è arrivato con una cover protettiva,

    storage_gb: intero che indica quanti GB di memoria ha lo smartphone.

Metodi

    device_type(): restituisce la stringa "smartphone".

    base_diagnosis_time(): restituisce il tempo base di diagnosi in minuti (es. 20).

    repair_complexity(): restituisce un intero che rappresenta la complessità (es. 2 o 3).

    info(): estende il metodo della superclasse includendo anche has_protective_case e storage_gb.

Classe Laptop

La classe Laptop rappresenta un laptop e eredita da Device.
Attributi aggiuntivi

    has_dedicated_gpu: bool che indica se il laptop ha una scheda grafica dedicata,

    screen_size_inches: float con la dimensione dello schermo in pollici.

Metodi

    device_type(): restituisce la stringa "laptop".

    base_diagnosis_time(): restituisce il tempo base di diagnosi in minuti (es. 40).

    repair_complexity(): restituisce un intero (magari più alto rispetto allo smartphone).

    info(): estende il metodo della superclasse includendo anche has_dedicated_gpu e screen_size_inches.

Classe ServiceCenter

La classe ServiceCenter rappresenta il centro di assistenza, cioè il contenitore principale del sistema.
Attributi

    devices: dizionario che associa a ogni identificativo (id) l’oggetto Device corrispondente:

    {
        "d1": <Smartphone ...>,
        "d2": <Laptop ...>,
        ...
    }

Metodi

    add(device): aggiunge un dispositivo al centro.
    Restituisce True se l’inserimento va a buon fine, False se l’id esiste già.

    get(device_id): restituisce l’oggetto Device corrispondente all’ID specificato oppure None se non esiste.

    update(device_id, new_device): sostituisce completamente il dispositivo con id device_id con new_device (per simulare un PUT).

    patch_status(device_id, new_status): aggiorna solo lo stato (status) del dispositivo specificato (per simulare un PATCH).

    delete(device_id): rimuove il dispositivo dal dizionario.
    Restituisce True se l’eliminazione è andata a buon fine, False se il dispositivo non esiste.

    list_all(): restituisce una lista di tutti i dispositivi presenti nel centro (o direttamente le loro info()).

Nel codice principale dovrà essere creato un centro di assistenza e dovranno essere inizializzati almeno due dispositivi, uno di tipo Smartphone e uno di tipo Laptop.
'''



from abc import ABC, abstractmethod
from enum import Enum


class Status (Enum):

   received:str = "RECEIVED"
   diagnosing:str = "DIAGNOSING"
   repairing:str = "REPAIRING"
   ready:str = "READY"
   delivered:str = "DELIVERED"


class Device(ABC):


  def __init__(self, id:str, model:str, customer_name:str, purchase_year:str, status: Status) -> None:

    self.id = id 
    self.model = model
    self.customer_name = customer_name
    self.purchase_year = purchase_year
    self.status = status

 
  @abstractmethod 
  def device_type(self) -> str:

    pass
  
  @abstractmethod 
  def base_diagnosis_time(self) -> int:
    pass
  
  @abstractmethod 
  def repair_complexity(self) -> int:
    pass
  


  def info(self) -> dict[str,str|int]:

     return {
     
                "id": self.id,
                "device_type": self.device_type(),
                "model": self.model,
                "customer_name": self.customer_name,
                "purchase_year": self.purchase_year,
                "status": self.status.value

         }
    





  def estimated_total_time(self,factor : float = 1.0) -> int:

    return int(self.base_diagnosis_time() * factor + self.repair_complexity() * 30)
  


class Smartphone(Device):
  

  def __init__(self, id:str, model:str, customer_name:str, purchase_year:int, status:Status, has_protective_case:bool, storage_gb: int) -> None:
    super().__init__(id, model, customer_name, purchase_year, status)

    self.has_protective_case = has_protective_case
    self.storage_gb = storage_gb

  def device_type(self) -> str:
    return "smartphone"

  def base_diagnosis_time(self)-> int:
    return 20
  
  def repair_complexity(self)-> int:
    return 2
  

  def info(self) -> dict[str,str|int]:

    data = super().info()
    data.update({
      
        "has_protective_case" : self.has_protective_case,
        "storage_gb" : self.storage_gb

    
     })
    return data



class Laptop(Device):
  
  def __init__(self, id:str, model:str, customer_name:str, purchase_year:int, status:Status, has_dedicated_gpu:bool, screen_size_inches: int) -> None:
    super().__init__(id, model, customer_name, purchase_year, status)
    
    self.has_dedicated_gpu = has_dedicated_gpu
    self.screen_size_inches = screen_size_inches

  def device_type(self)-> str:
    return "laptop"
  
  def base_diagnosis_time(self)-> int:
    return 40 
  
  def repair_complexity(self) -> int:
    return 3
  

  def info(self) -> dict[str,str|int]:


    data = super().info()
    data.update({
      
      "has_dedicated_gpu" : self.has_dedicated_gpu,
      "screen_size_inches" : self.screen_size_inches
    })
    return data


class ServiceCenter:
  

  def __init__(self) -> None:

    self.devices:dict[str,Device]  = {}


  def add(self,device:Device) -> bool:

    if device.id not in self.devices:
      
      self.devices[device.id] = device 
      return True 
    
    else:
      return False
    
  def get(self,device_id) -> Device|None:

      if device_id in self.devices:

        return self.devices.get(device_id)
      
      else:
        return None 
  
  def update(self,device_id:str, new_device:str) -> None:

      if device_id in self.devices:
         
         self.devices[device_id] = new_device
      else:

        print("ATTENZIONE ! Dispositivo non trovato, ID SBAGLIATO") 
    
  def patch_status(self,device_id:str,new_status:Status) -> None:

      if device_id in self.devices:
        
        self.devices[device_id].status = new_status

      else:
           print("ATTENZIONE ! Dispositivo non trovato, ID SBAGLIATO") 

  def delete(self,device_id:str) -> bool:

    if device_id in self.devices:
      
        del self.devices[device_id] 
        return True
    else: 
      return False 

  def list_all(self) -> list[Device]:

    return list(self.devices.values())






