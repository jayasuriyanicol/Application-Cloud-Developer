'''
Esercizio: Gestione di un Rifugio per Animali (GET + POST)
Completion requirements

In questo esercizio dovrai scrivere il codice per un sistema che gestisce gli animali di un rifugio e che espone alcune informazioni e funzionalità tramite un’applicazione Flask. L’obiettivo è applicare i principi di ereditarietà e classi astratte, e sperimentare sia le richieste HTTP GET sia le richieste HTTP POST.
🐾 Specifiche del Problema
Classe Animal

La classe Animal rappresenta un animale generico del rifugio.
È una classe astratta e non può essere istanziata direttamente.

Ogni animale ha:

    un identificativo id di tipo stringa (es. "d1", "c3"),

    un nome name di tipo stringa,

    un’età age_years di tipo intero (anni),

    un peso weight_kg di tipo float (chilogrammi).

Metodi

    species(): metodo astratto.
    Deve essere implementato nelle sottoclassi per restituire la specie dell’animale, ad esempio "dog" o "cat".

    daily_food_grams(): metodo astratto.
    Deve essere implementato nelle sottoclassi e deve restituire la quantità di cibo giornaliera raccomandata in grammi.

    info(): metodo concreto.
    Restituisce un dizionario con le informazioni principali dell’animale, ad esempio:
     
    { "id": ..., "name": ..., "species": ..., "age_years": ..., "weight_kg": ..., # più eventuali campi specifici delle sottoclassi }

    bmi_like(): metodo concreto che restituisce un valore derivato (simile a un indice di “forma fisica”), ad esempio calcolato come:
     
    weight_kg / (age_years + 1)

    Il dettaglio della formula è lasciato libero, l’importante è che sia coerente e restituisca un numero (float).

Classe Dog

La classe Dog rappresenta un cane e eredita da Animal.
Attributi aggiuntivi

    breed: razza del cane, stringa (es. "labrador"),

    is_trained: booleano che indica se il cane è addestrato (True/False).

Metodi

    species(): restituisce la stringa "dog".

    daily_food_grams(): restituisce la quantità di cibo giornaliero in grammi.
    Puoi usare una formula plausibile, ad esempio:
     
    return 200 + age_years * 50

    oppure un’altra a tua scelta, purché sia chiaro che il risultato rappresenta grammi di cibo al giorno.

    info(): estende il metodo della superclasse includendo anche breed e is_trained, ad esempio:
     
    base = super().info() base["breed"] = self.breed base["is_trained"] = self.is_trained return base

Classe Cat

La classe Cat rappresenta un gatto e eredita da Animal.
Attributi aggiuntivi

    indoor_only: booleano che indica se il gatto vive solo in casa (True/False),

    favorite_toy: stringa che rappresenta il gioco preferito (es. "ball", "mouse").

Metodi

    species(): restituisce la stringa "cat".

    daily_food_grams(): restituisce la quantità di cibo giornaliero in grammi.
    Anche qui puoi usare una formula plausibile, ad esempio:
     
    return 100 + age_years * 30

    info(): estende il metodo della superclasse includendo anche indoor_only e favorite_toy.

Classe Shelter

La classe Shelter rappresenta il contenitore principale del sistema, che gestisce tutti gli animali presenti nel rifugio.
Attributi

    animals: dizionario che associa a ogni identificativo (id) l’oggetto Animal corrispondente, ad esempio:
     
    { "d1": <Dog ...>, "c1": <Cat ...>, ... }

    adoptions (opzionale ma consigliato): struttura dati per gestire lo stato di adozione, ad esempio un dizionario:
     
    { "d1": "Mario Rossi", "c1": "Luca Bianchi" }

    dove la chiave è l’id dell’animale e il valore è il nome dell’adottante.

Metodi

    add(animal): aggiunge un animale al rifugio.
    Se esiste già un animale con lo stesso id, puoi decidere se sovrascriverlo o ignorare l’operazione (nel contesto dell’esercizio è sufficiente una scelta semplice e documentata nei commenti).

    get(animal_id): restituisce l’oggetto Animal corrispondente all’ID specificato oppure None se non esiste.

    list_all(): restituisce una lista di tutte le istanze di Animal presenti nel rifugio (puoi decidere se restituire direttamente gli oggetti o piuttosto una lista di dizionari generati con info()).

    is_adopted(animal_id): restituisce True/False a seconda che l’animale risulti adottato nella struttura adoptions.

    set_adopted(animal_id, adopter_name): registra l’adozione per un dato animale, salvando il nome dell’adottante.

Nel codice principale dovrà essere creato un rifugio e dovranno essere creati almeno due animali, uno di tipo Dog e uno di tipo Cat, che saranno aggiunti al rifugio prima di avviare l’app Flask.

'''

from abc import ABC, abstractmethod 


class Animal(ABC):


    def __init__(self,id:str,name:str,age_years:int,weight_kg:float) -> None:


        self.id = id 
        self.name = name 
        self.age_years = age_years
        self.weight_kg = weight_kg
         
    @abstractmethod 
    def species(self)-> str: 
        pass

   
    @abstractmethod
    def daily_food_grams(self) -> int:

        pass 

    def info (self) -> dict:

        return {

            'id' : self.id,
            'name' : self.name,
            'species': self.species(),
            'age_years' : self.age_years,
            'weight_kg': self.weight_kg,
           } 
    
    def bmi_like(self) -> float:

        return float(self.weight_kg / (self.age_years + 1))
    


class Dog(Animal):

        def __init__(self, id:str, name:str, age_years:int, weight_kg:float,breed:str,is_trained:bool) -> None:
        
             super().__init__(id, name, age_years, weight_kg)
             
             self.breed = breed
             self.is_trained = is_trained
            
        def species(self) -> str:
             return 'dog'

        def daily_food_grams(self) -> float:
             return 200 + self.age_years * 50   

        def info(self) -> dict:
             base = super().info() 
             base["breed"] = self.breed
             base ['is_trained'] = self.is_trained 
             return base 




class Cat(Animal):
     
        def __init__(self, id:str, name:str, age_years:int, weight_kg:float,indoor_only:bool,favorite_toy:str)-> None:
            super().__init__(id, name, age_years, weight_kg)

            self.indoor_only = indoor_only
            self.favorite_toy = favorite_toy
        
        def species(self) -> str:
             return 'cat'
        
        def daily_food_grams(self) -> float:
             return 100 + self.age_years * 30
        
        def info(self) -> dict:

            base = super().info()
            base['indoor_only'] = self.indoor_only 
            base['favorite_toy'] = self.favorite_toy

            return base 


class Shelter:


        def __init__(self) -> None:
             
             self.animals:dict[str,Animal] = {}
             self.adoptions:dict[str,str] = {}

        def add(self,animal:Animal) -> None:
             
             if animal not in self.animals:
                  
                  self.animals[animal.id] = animal 
             else: 
                  pass 
             

        def get(self,animal_id:Animal) -> Animal | None:

            return self.animals.get(animal_id)

            

        def list_all(self) -> list[Animal]:

             return list(self.animals.values())  
        


        def set_adopted(self,animal_id:str,adopter_name:str) -> None:

            self.adoptions[animal_id]  = adopter_name      


#Creazione dei dati, che verranno già inseriti di 'DEFAULT'
primoAnimale : Dog = Dog('d1','Cris', 4, 50.6, 'Pastore Tedesco', True)
secondoAnimale : Cat = Cat('c1','Atta', 1, 1.34, False, 'Peluche')

rifugio = Shelter()

rifugio.add(primoAnimale)
rifugio.add(secondoAnimale)



print(rifugio.get('d1').info())
print(rifugio.get('c1').info())
print(rifugio.get('d1').daily_food_grams())
print(rifugio.get('c1').daily_food_grams())