'''
In questo esercizio dovrai scrivere il codice per un sistema che gestisce una flotta di veicoli per un'azienda di noleggio auto e furgoni che espone alcune informazioni e funzionalità tramite un’applicazione Flask. L’obiettivo è sperimentare metodi HTTP (POST, PUT, PATCH, DELETE) e test con requests.
Noleggio flotta di veicoli

Classe Veichle (astratta)

La classe Veichle rappresenta un veicolo generico gestito dal sistema. È una classe astratta e non può essere istanziata direttamente.

Ogni veicolo ha:

    un identificativo plate_id univoco di tipo stringa (targa del veicolo; es., "HA014AS"),

    un modello model di tipo stringa (es. "Fiat Panda", "Ford Fiesta"),

    il nome dell'attuale conducente/noleggiatore driver_name di tipo stringa (o None se libero),

    un anno di immatricolazione del veicolo registration_year di tipo intero,

    lo stato  status attuale del veicolo di tipo stringa, con valori possibili (a scelta, ma ad esempio):

        "available" (disponibile nel parcheggio),

        "rented" (attualmente noleggiato),

        "maintenance" (in manutenzione meccanica),

        "cleaning" (pulizia),

        "retired" (dismesso o venduto).

Metodi

    vehicle_type(): metodo astratto
    Deve essere implementato nelle sottoclassi per restituire il tipo di veicolo (es. "car", "van").

    base_cleaning_time(): metodo astratto
    Deve essere implementato nelle sottoclassi e restituire il tempo necessario per la pulizia ordinaria del veicolo espresso in minuti (int).

    wear_level(): metodo astratto
    Deve essere implementato nelle sottoclassi e restituire un indicatore (ad esempio un numero intero) che descriva il livello medio di usura per quel tipo di veicolo (da 1 a 5).

    info(): 
    Restituisce un dizionario con le informazioni principali del veicolo, ad esempio:

    {
        "id": ...,
        "model": ...,
        "driver_name": ...,
        "veichle_type": ...,
        "registration_year": ...,
        "status": ...,
        # più eventuali campi specifici delle sottoclassi
    }

    estimated_prep_time(factor: float = 1.0):
    Calcola un tempo stimato per preparare il veicolo (pulizia + controlli) prima di un nuovo noleggio, sulla base di:

        base_cleaning_time(),

        wear_level(),

        il fattore moltiplicativo factor (float, default 1.0).

    La formula è base_cleaning_time() * factor + repair_complexity()*15 e restituisce il tempo di preparazione stimato in minuti (intero).

Classe Car

La classe Car rappresenta un'automobile standard e eredita da Vehicle.
Attributi aggiuntivi

    doors: un intero che indica il numero di portiere.

    is_cabrio: intero che indica quanti GB di memoria ha lo smartphone.

Metodi

    vehicle_type(): restituisce la stringa "car".

    base_cleaning_time(): restituisce il tempo base di pulizia del veicolo in minuti (es. 30).

    wear_level(): restituisce un intero che rappresenta il livello di usura medio del veicolo. Il valore di usura di un'automobile generica sarà basso (es. 1 o 2).

    info(): estende il metodo della superclasse includendo anche doors e is_cabrio.

Classe Van

La classe Van rappresenta un veicolo commerciale ed eredita da Vehicle.
Attributi aggiuntivi

    max_load_kg: un intero che indica la portata massima del veicolo in kg.

    require_special_license: un booleano che indica se sia necessaria o meno una patente speciale per la conduzione del veicolo (es. la patente C).

Metodi

    vehicle_type(): restituisce la stringa "van".

    base_cleaning_time(): restituisce il tempo base di pulizia del van in minuti (es. 60, poiché il van è una tipologia di veicolo onerosa da pulire).

    wear_level(): restituisce un intero che rappresenta il livello di usura medio del veicolo. Il valore di usura di un van sarà alto poiché il van prevede un uso lavorativo intenso (es. 4 o 5).

    info(): estende il metodo della superclasse includendo anche max_load_kg e require_special_license.

Classe FleetManager

La classe FleetManager rappresenta il gestore della flotta, cioè il database principale del sistema.
Attributi

    vehicles: dizionario che associa a ogni identificativo (plate_id) l’oggetto Vehicle corrispondente:

    {
        "HA014AS": <Fiat Panda ...>,
        "CC216FG": <Peugeot Partner ...>,
        ...
    }

Metodi

    add(vechile: Vehicle) -> bool:
    Aggiunge un veicolo al sistema. 
    Restituisce True se l’inserimento va a buon fine, False se il veicolo esiste già.

    get(plate_id: str) -> Vehicle:
    Restituisce l’oggetto Vehicle corrispondente all’ID specificato oppure None se non esiste.

    update(plate_id: str, new_vehicle: Vehicle) -> None:
    Sostituisce completamente il veicolo con id plate_id con new_vehicle (per simulare un PUT).

    patch_status(plate_id: str, new_vehicle: Vehicle) -> None:
    Aggiorna solo lo stato (status) del veicolo specificato con id plate_id (per simulare un PATCH).

    delete(plate_id: str) -> bool:
    Rimuove il veicolo dal dizionario.
    Restituisce True se l’eliminazione è andata a buon fine, False se il veicolo non esiste.

    list_all(): restituisce una lista di tutte le info() di veicoli presenti nel sistema

Nel codice principale dovrà essere creato un gestore della flotta di veicoli (FleetManager) e dovranno essere inizializzati almeno due veicoli, uno di tipo Car e uno di tipo Van.

'''


from abc import ABC,abstractmethod
from enum import Enum;



'''We create an enum class, importing it from the Enum propietes and associated by the correct str and denomination'''
class Status(Enum) :
    
    AVAILABLE:str = "AVAILABLE"
    RENTED:str = "RENTED"
    MAINTENANCE:str = "MAINTENANCE"
    CLEANING:str = "CLEANING"
    RETIRED:str = "RETIRED"


class Vehicle(ABC):
    def __init__(self, plate_id: str, model: str, driver_name: str, registration_year: int, status: Status):
        self.plate_id = plate_id
        self.model = model
        self.driver_name = driver_name
        self.registration_year = registration_year
        self.status = status

    @abstractmethod
    def vehicle_type(self) -> str:
        pass

    @abstractmethod
    def base_cleaning_time(self) -> int:
        pass

    @abstractmethod
    def wear_level(self) -> int:
        pass

    def info(self) -> dict:
        return {
            "id": self.plate_id,
            "model": self.model,
            "driver_name": self.driver_name,
            "vehicle_type": self.vehicle_type(),
            "registration_year": self.registration_year,
            "status": self.status.value
        }

    def estimated_prep_time(self, factor: float = 1.0) -> int:
        return int(self.base_cleaning_time() * factor + self.wear_level() * 15)


class Car(Vehicle):
    def __init__(self, plate_id, model, driver_name, registration_year, status: Status, doors: int, is_cabrio: bool):
        super().__init__(plate_id, model, driver_name, registration_year, status)
        self.doors = doors
        self.is_cabrio = is_cabrio

    def vehicle_type(self) -> str:
        return "car"

    def base_cleaning_time(self) -> int:
        return 30

    def wear_level(self) -> int:
        return 2

    def info(self) -> dict:
        data = super().info()
        data.update({
            "doors": self.doors,
            "is_cabrio": self.is_cabrio
        })
        return data


class Van(Vehicle):
    def __init__(self, plate_id, model, driver_name, registration_year, status: Status, max_load_kg: int, require_special_license: bool):
        super().__init__(plate_id, model, driver_name, registration_year, status)
        self.max_load_kg = max_load_kg
        self.require_special_license = require_special_license

    def vehicle_type(self) -> str:
        return "van"

    def base_cleaning_time(self) -> int:
        return 60

    def wear_level(self) -> int:
        return 5

    def info(self) -> dict:
        data = super().info()
        data.update({
            "max_load_kg": self.max_load_kg,
            "require_special_license": self.require_special_license
        })
        return data


class FleetManager:
    def __init__(self):
        self.vehicles: dict[str, Vehicle] = {}

    def add(self, vehicle: Vehicle) -> bool:
        if vehicle.plate_id in self.vehicles:
            return False
        self.vehicles[vehicle.plate_id] = vehicle
        return True

    def get(self, plate_id: str) -> Vehicle:
        return self.vehicles.get(plate_id)

    def update(self, plate_id: str, new_vehicle: Vehicle) -> None:
        self.vehicles[plate_id] = new_vehicle

    def patch_status(self, plate_id: str, new_status: Status) -> None:
        vehicle = self.get(plate_id)
        if vehicle:
            vehicle.status = new_status

    def delete(self, plate_id: str) -> bool:
        if plate_id in self.vehicles:
            del self.vehicles[plate_id]
            return True
        return False

    def list_all(self) -> list[Vehicle]:
        return list(self.vehicles.values())






        
    


    


        




       

