'''
Esercizio: Sistema di Gestione di un Parco Divertimenti (OOP + Flask)
Completion requirements

In questo esercizio, dovrai scrivere il codice per un sistema che gestisce le attrazioni di un parco divertimenti e che espone alcune informazioni tramite un’applicazione Flask. L’obiettivo è applicare i principi di ereditarietà e classi astratte, e sperimentare le richieste HTTP GET di Flask.

Specifiche del Problema

Classe Ride

La classe Ride rappresenta un’attrazione generica del parco. È una classe astratta e non può essere istanziata direttamente.
Ogni attrazione ha:

    un identificativo (id) di tipo stringa;
    un nome (name) di tipo stringa;
    un’altezza minima richiesta (min_height_cm) di tipo intero.

Metodi:

    category(): metodo astratto. Deve essere implementato nelle sottoclassi per restituire la categoria dell’attrazione (es. "roller_coaster", "family").
    base_wait(): metodo astratto. Deve essere implementato nelle sottoclassi e deve restituire l’attesa base in minuti.
    info(): metodo concreto che restituisce un dizionario con le informazioni principali dell’attrazione (id, nome, altezza minima, categoria e attributi specifici).
    wait_time(crowd_factor: float = 1.0): metodo concreto che restituisce l’attesa stimata in minuti. L’attesa è calcolata come base_wait() * crowd_factor, arrotondata all’intero positivo.

Classe RollerCoaster

La classe RollerCoaster rappresenta una montagna russa e eredita da Ride.

Attributi aggiuntivi:

    inversions: numero di inversioni presenti nel tracciato (ad esempio 3 o 5).

Metodi:

    category(): restituisce la stringa "roller_coaster".
    base_wait(): restituisce l’attesa base in minuti (ad esempio 40).
    info(): estende il metodo della superclasse includendo anche il numero di inversioni.

Classe Carousel

La classe Carousel rappresenta una giostra con animali e eredita da Ride.

Attributi aggiuntivi:

    animals: lista di animali presenti sulla giostra (ad esempio ["horse", "swan", "tiger"]).

Metodi:

    category(): restituisce la stringa "family".
    base_wait(): restituisce l’attesa base in minuti (ad esempio 10).
    info(): estende il metodo della superclasse includendo la lista di animali.

Classe Park

La classe Park rappresenta il contenitore principale del sistema, che gestisce tutte le attrazioni presenti nel parco.

Attributi:

    rides: dizionario che associa a ogni identificativo (id) l’oggetto Ride corrispondente.

Metodi:

    add(ride): aggiunge un’attrazione al parco.
    get(ride_id): restituisce l’attrazione corrispondente all’ID specificato oppure None se non esiste.
    list_all(): restituisce una lista di tutte le attrazioni (puoi ordinare per categoria e nome, opzionale).

Nel codice principale dovrà essere creato un parco e dovranno essere create almeno due attrazioni, una di tipo RollerCoaster e una di tipo Carousel.
'''

from abc import ABC, abstractmethod

class Ride(ABC):

    def __init__(self, id: str, name: str, min_height_cm: int) -> None:
        self.id = id
        self.name = name
        self.min_height_cm = min_height_cm

    @abstractmethod
    def category(self) -> str:
        pass

    @abstractmethod
    def base_wait(self) -> int:
        pass

    def info(self) -> dict:
        return {
            "id": self.id,
            "name": self.name,
            "min_height_cm": self.min_height_cm,
            "category": self.category()
        }

    def wait_time(self, crowd_factor: float = 1.0) -> int:
        wait = self.base_wait() * crowd_factor
        return max(1, round(wait))


class RollerCoaster(Ride):

    def __init__(self, id: str, name: str, min_height_cm: int, inversions: int):
        super().__init__(id, name, min_height_cm)
        self.inversions = inversions

    def category(self) -> str:
        return "roller_coaster"

    def base_wait(self) -> int:
        return 40

    def info(self) -> dict:
        data = super().info()
        data["inversions"] = self.inversions
        return data


class Carousel(Ride):

    def __init__(self, id: str, name: str, min_height_cm: int, animals: list[str]):
        super().__init__(id, name, min_height_cm)
        self.animals = animals

    def category(self) -> str:
        return "family"

    def base_wait(self) -> int:
        return 10

    def info(self) -> dict:
        data = super().info()
        data["animals"] = self.animals
        return data



class Park:

    def __init__(self):
        self.rides: dict[str, Ride] = {}

    def add(self, ride: Ride) -> None:
        self.rides[ride.id] = ride

    def get(self, ride_id: str) -> Ride | None:
        return self.rides.get(ride_id)

    def list_all(self) -> list[Ride]:
        return list(self.rides.values())



r1 = RollerCoaster("SH001", "Shock", 165, 3)
r2 = RollerCoaster("CC005", "Inverter", 153, 1)
c1 = Carousel("AG324", "CarbonRider", 168, ["Elephant", "Tiger", "Monkey"])

pk = Park()
pk.add(r1)
pk.add(r2)
pk.add(c1)


print(pk.get("SH001").info())
print(pk.get('CC005').info())
print(pk.get('AG324').info())
print(pk.get("AG324").wait_time(crowd_factor=1.5))





    






          
          

        






