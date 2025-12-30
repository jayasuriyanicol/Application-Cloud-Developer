'''
In questo esercizio dovrai scrivere il codice per un sistema che funge da "Hub" per la gestione dei dispositivi IoT (Internet of Things) in una casa intelligente, che espone alcune informazioni e funzionalità tramite un’applicazione Flask. L’obiettivo è sperimentare metodi HTTP (POST, PUT, PATCH, DELETE) e test con requests.
Sistema di Gestione Smart Home (IoT Hub)

Classe SmartDevice (astratta)

La classe SmartDevice rappresenta un generico dispositivo connesso generico gestito dal sistema. È una classe astratta e non può essere istanziata direttamente.

Ogni dispositivo ha:

    serial_number: str
    Identificativo univoco del dispositivo espresso come una stringa (es., "SN-10293-X"),

    brand: str
    La marca del dispositivo rappresentata come una stringa (es. "Nest"),

    room: str
    Nome della stanza in cui è collocato il dispositivo ("Living Room"),

    installation_year: int
    Anno di installazione del dispositivo, di tipo intero,

    status: str
    Lo stato attuale del dispositivo, espresso come una stringa, con valori possibili (a scelta, ma ad esempio):

        "online" (funzionante e connesso),

        "offline" (disconnesso),

        "updating" (aggiornamento firmware in corso),

        "error" (malfunzionamento),

Metodi

    device_type() -> str   metodo astratto
    Deve essere implementato nelle sottoclassi per restituire il tipo del dispositivo (es. "bulb", "camera").

    energy_consumption() -> float | int   metodo astratto
    Deve essere implementato nelle sottoclassi e restituisce il consumo medio di energia in Watt del dispositivo (può essere un intero o un float).

    connection_quality() -> int   metodo astratto
    Deve essere implementato nelle sottoclassi e restituire un indicatore (ad esempio un numero intero) che descriva la qualità della connessione richiesta dal dispositivo (intero da 1 a 10).

    info() -> dict[str, float | int | str]: 
    Restituisce un dizionario con le informazioni principali del dispositivo, ad esempio:

    {
        "serial_number": ...,
        "brand": ...,
        "room": ...,
        "installation_year": ...,
        "status": ...,
        # più eventuali campi specifici delle sottoclassi
    }

    diagnostici_time(factor: float = 1.0) -> float
    Calcola un tempo stimato per eseguire una diagnostica completa, sulla base di:

        energy_consumption(),

        connection_quality(),

        il fattore moltiplicativo factor (float, default 1.0).

    La formula è energy_consumption() * factor + connection_quality()*10 e restituisce, in secondi, il tempo stimato per eseguire una diagnostica completa (valore intero).

Classe SmartBulb

La classe SmartBulb rappresenta una lampadina intelligente ed eredita da SmartDevice.
Attributi aggiuntivi

    brightness_lumens: int 
    un intero che quantifica la luminosità della lampadina intelligente espressa in lumen (es. 800 o 1200).

    color_capability -> bool 
    un booleano che indica se la lampadina supporta la modalità RGB (vero se supportata, falso altrimenti).

Metodi

    device_type() -> str
    restituisce la stringa "bulb".

    energy_consumption() -> float | int
    restituisce il consumo medio di energia in Watt (float o int). Per questa tipologia di dispositivo il consumo è basso, tipicamente 9 o 15 Watt.

    connection_quality() -> int
    restituisce un indicatore (ad esempio un numero intero) che descriva la qualità della connessione richiesta dal dispositivo (intero da 1 a 10), tipicamente un valore basso/medio (es. tra 2 e 4), poiché le lampadine richiedono poca banda..

    info() -> dict[str, float | int | str]
    estende il metodo della superclasse includendo anche brightness_lumens e color_capability.

Classe SecurityCamera

La classe SecurityCamera rappresenta una telecamera di sicurezza ed eredita da SmartDevice.
Attributi aggiuntivi

    resolution: str
    Rappresenta la risoluzione della telecamera di sicurezza (es. "1080p", "4K").

    night_vision: bool
    Indica se la videocamera dispone di visione notturna (vero se dispone di visione notturna, falso altrimenti).

Metodi

    device_type() -> str
    Restituisce la stringa "camera".

    energy_consumption() -> float | int
    Restituisce il consumo medio di energia in Watt (float o int). I modelli di dispositivi motorizzati hanno tipicamente un consumo più elevato, quindi verrà restituito un valore più alto (es. 50 Watt).

    connection_quality() -> int
    Restituisce un indicatore (ad esempio un numero intero) che descriva la qualità della connessione richiesta dal dispositivo (intero da 1 a 10). Per questo tipo di dispositivo sarà un valore alto (es. tra 8 e 10), poiché lo streaming video richiede tipicamente molta banda.

    info(): estende il metodo della superclasse includendo anche resolution e night_vision.

Classe IoTHub

La classe IoTHub rappresenta il sistema di gestione di dispositivi intelligenti, cioè il database principale del sistema.
Attributi

    devices: dizionario che associa a ogni identificativo (serial_number) l’oggetto SmartDevice corrispondente:

    {
        "SN-101": <SmartBulb ...>,
        "SN-10293-X": <SecurityCamera ...>,
        ...
    }

Metodi

    add(device: SmartDevice) -> bool:
    Aggiunge un dispositivo al sistema. 
    Restituisce True se l’inserimento va a buon fine, False se il numero seriale è già presente nel sistema.

    get(serial_number: str) -> SmartDevice | None : 
    Restituisce l’oggetto SmartDevice corrispondente all’ID specificato oppure None se non esiste.

    update(serial_number: str, new_device: SmartDevice) -> None:
    Sostituisce completamente il dispositivo con numero seriale serial_number con new_device (per simulare un PUT).

    patch_status(serial_number: str, new_device: SmartDevice) -> None:
    Aggiorna solo lo stato (status) del dispositivo con numero seriale serial_number (per simulare un PATCH).

    delete(serial_number: str) -> bool:
    Rimuove il dispositivo con numero seriale serial_number dal dizionario.
    Restituisce True se l’eliminazione è andata a buon fine, False se il dispositivo non esiste.

    list_all() -> list[dict[str, float | int | str]] : 
    restituisce una lista di tutte le info() dei dispositivi presenti nel sistema

Nel codice principale dovrà essere creato un sistema di gestione dei dispositivi intelligenti (IoTHub) e dovranno essere inizializzati almeno due dispositivi, uno di tipo SmartBulb e uno di tipo SecurityCamera.

'''


from abc import ABC,abstractmethod
from enum import Enum


class Status(str,Enum):


    online:str = "ONLINE"
    offline:str = "OFFLINE"
    updating:str = "UPDATING"
    error:str = "ERROR"


class SmartDevice(ABC):


    def __init__(self,serial_number:str,brand:str,room:str, installation_year:int,status:Status):
       

       self.serial_number = serial_number
       self.brand = brand
       self.room = room
       self.installation_year = installation_year
       self.status = status


    @abstractmethod 
    def device_type(self) -> str:

        pass
  
    @abstractmethod
    def energy_consumption(self)-> float|int:

        pass 
   
    @abstractmethod
    def connection_quality(self) -> int :

        pass



    def info(self) -> dict[str,float |int | str]:

        return {

            "serial_number": self.serial_number,
            "brand": self.brand,
            "room": self.room,
            "installation_year": self.installation_year,
            "status": self.status
           } 
    
    def diagnostics_time(self,factor = 1.5) -> float:


        return float(self.energy_consumption() * factor + self.connection_quality()*10)
    


class SmartBulb(SmartDevice):


    def __init__(self, serial_number:str, brand:str, room:str, installation_year:int, status:Status, brightness_lumens:int, color_capability:bool) -> None:
        super().__init__(serial_number, brand, room, installation_year, status)

        self.brightness_lumens = brightness_lumens
        self.color_capability = color_capability


    def device_type(self) -> str:

        return "bulb"
    
    def energy_consumption(self) -> float | int:
        return 10.4
    
    def connection_quality(self) -> int:
        return 3
    

    def info(self) -> dict[str, float | int | str]:

        data = super().info()

        data.update({ 

            "brightness_lumens": self.brightness_lumens,
            "color_capability": self.color_capability

        })

        return data
    


class SecurityCamera(SmartDevice):

    def __init__(self, serial_number:str, brand:str, room:str, installation_year:int, status:Status, resolution:str, night_vision:bool) -> None:
        super().__init__(serial_number, brand, room, installation_year, status)

        self.resolution = resolution
        self.night_vision = night_vision

    def device_type(self) -> str:
        return "camera"


    def energy_consumption(self) -> float | int :
        return 50 
    

    def connection_quality(self) -> int:
        return 9
    

    def info(self) -> dict[str, float | int | str]:

        data = super().info()

        data.update({

            "resolution" : self.resolution,
            "night_vision": self.night_vision
        })

        return data 
    



class IoTHub:

    def __init__(self) -> None:

        self.devices:dict[str,SmartDevice] = {}


    def add(self,device:SmartDevice) -> bool:

        if device not in self.devices:

            self.devices[device.serial_number] = device 
            return True 
        else: 
            
            return False  
    

    def get(self,serial_number:str) -> SmartDevice | None:
        
        if serial_number in self.devices:

            return self.devices.get(serial_number)
        else:
            print("ATTENZIONE ! Dispositivo non presente nel SISTEMA !")
            return None
        
    def update(self,serial_number:str, new_device: SmartDevice) -> None:

        if serial_number in self.devices:

            self.devices[serial_number] = new_device 

        else: 

             print("ATTENZIONE ! Dispositivo non presente nel SISTEMA !")

    def patch_status(self, serial_number:str, new_status: SmartDevice) -> None:

        if serial_number in self.devices:

            self.devices[serial_number].status = new_status 
        else:

             print("ATTENZIONE ! Dispositivo non presente nel SISTEMA !")



    

    def delete(self,serial_number:str) -> bool:


        if serial_number in self.devices:

            del self.devices[serial_number]

            return True 
        else:

             print("ATTENZIONE ! Dispositivo non presente nel SISTEMA !")  
             return False
    

    def list_all(self) -> list[dict[str, float | int | str]] : 

        return list(self.devices.values())
    










        

     