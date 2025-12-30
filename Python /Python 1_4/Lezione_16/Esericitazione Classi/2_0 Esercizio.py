'''
Sviluppa un sistema per la gestione delle ricette in Python che permetta agli utenti di creare, modificare, e cercare ricette basate sugli ingredienti. 
Il sistema dovrà essere capace di gestire una collezione (dizionario) di ricette e i loro ingredienti.

Classe:
- RecipeManager:
    Gestisce tutte le operazioni legate alle ricette.

    Metodi:
    - create_recipe(name, ingredients): Crea una nuova ricetta con il nome specificato e una lista di ingredienti. 
      Restituisce un nuovo dizionario con la sola ricetta appena creata o un messaggio di errore se la ricetta esiste già.

    - add_ingredient(recipe_name, ingredient): Aggiunge un ingrediente alla ricetta specificata. 
      Restituisce la ricetta aggiornata o un messaggio di errore se l'ingrediente esiste già o la ricetta non esiste.

    - remove_ingredient(recipe_name, ingredient): Rimuove un ingrediente dalla ricetta specificata. 
      Restituisce la ricetta aggiornata o un messaggio di errore se l'ingrediente non è presente o la ricetta non esiste.

    - update_ingredient(recipe_name, old_ingredient, new_ingredient): Sostituisce un ingrediente con un altro nella ricetta specificata. 
      Restituisce la ricetta aggiornata o un messaggio di errore se l'ingrediente non è presente o la ricetta non esiste.

    - list_recipes(): Elenca tutte le ricette esistenti.

    - list_ingredients(recipe_name): Mostra gli ingredienti di una specifica ricetta. 
      Restituisce un elenco di ingredienti o un messaggio di errore se la ricetta non esiste.

    - search_recipe_by_ingredient(ingredient): Trova e restituisce tutte le ricette che contengono un determinato ingrediente. 
      Restituisce un elenco di ricette o un messaggio di errore se nessuna ricetta contiene l'ingrediente.

For example:
Test 	Result

manager = RecipeManager()
print(manager.create_recipe("Pizza Margherita", ["Farina", "Acqua", "Lievito", "Pomodoro", "Mozzarella"]))
print(manager.add_ingredient("Pizza Margherita", "Basilico"))
print(manager.update_ingredient("Pizza Margherita", "Mozzarella", "Mozzarella di Bufala"))
print(manager.remove_ingredient("Pizza Margherita", "Acqua"))
print(manager.list_ingredients("Pizza Margherita"))

'''


#Creiamo la classe RecipeManager per gestire la creazione, modifica e ricerca di ricette e ingredienti
class RecipeManager:

    #Inizializziamo il dizionario che conterrà le ricette  
    def __init__(self):
   
        self.recipes = {}



    #Creiamo la funzione per aggiungere una nuova ricetta con nome e lista di ingredienti
    def create_recipe(self, name: str, ingredients: list[str]) -> dict | str:
        if name in self.recipes:
            
            return "ATTENZIONE! La ricetta esiste già!"
        
        else: 
         self.recipes[name] = ingredients
    
         return {name: self.recipes[name]}



    #Creiamo la funzione per aggiungere un nuovo ingrediente a una ricetta esistente
    def add_ingredient(self, recipe_name: str, ingredient: str) -> dict | str:
        
        if recipe_name not in self.recipes:
            
            return "ATTENZIONE! La ricetta non esiste!"
        
        if ingredient in self.recipes[recipe_name]:
            
            return "ATTENZIONE! L'ingrediente esiste già!"
        
        else:
          self.recipes[recipe_name].append(ingredient)

          return {recipe_name: self.recipes[recipe_name]}
    


    #Creiamo la funzione per rimuovere un ingrediente da una ricetta esistente
    def remove_ingredient(self, recipe_name: str, ingredient: str) -> dict | str:
        
        if recipe_name not in self.recipes:
            
            return "ATTENZIONE! La ricetta non esiste!"
        
        if ingredient not in self.recipes[recipe_name]:
            
            return "ATTENZIONE! L'ingrediente non è presente nella ricetta!"
        
        else:
            
          self.recipes[recipe_name].remove(ingredient)

          return {recipe_name: self.recipes[recipe_name]}
    


    #Creiamo la funzione per sostituire un ingrediente con un altro in una determinata ricetta
    def update_ingredient(self, recipe_name: str, old_ingredient: str, new_ingredient: str) -> dict | str:
        
        if recipe_name not in self.recipes:
            
            return "ATTENZIONE! La ricetta non esiste!"
        
        if old_ingredient not in self.recipes[recipe_name]:
            
            return "ATTENZIONE! L'ingrediente da sostituire non è presente!"
        
        else:
          index = self.recipes[recipe_name].index(old_ingredient)

          self.recipes[recipe_name][index] = new_ingredient

          return {recipe_name: self.recipes[recipe_name]}
    


    #Creiamo la funzione per elencare tutte le ricette esistenti
    def list_recipes(self) -> list[str]:
        
        return list(self.recipes.keys())



    #Creiamo la funzione per mostrare gli ingredienti di una ricetta specifica
    def list_ingredients(self, recipe_name: str) -> list[str] | str:
        
        if recipe_name not in self.recipes:
            
            return "ATTENZIONE! La ricetta non esiste!"
        else:
          return self.recipes[recipe_name]

    #Creiamo la funzione per cercare ricette che contengono un certo ingrediente tramite un dizionario
    def search_recipe_by_ingredient(self, ingredient: str) -> dict | str:
        
        found:dict = {}

        for name,ingredients in self.recipes.items():
            
            if ingredient in ingredients:
                found[name] = ingredients 
                








'''Eseguiamo ora dei test per verificare il corretto funzionamento del sistema'''

#Creiamo un'istanza del gestore di ricette
manager = RecipeManager()

#Creiamo una nuova ricetta per Pizza Margherita
print(manager.create_recipe("Pizza Margherita", ["Farina", "Acqua", "Lievito", "Pomodoro", "Mozzarella"]))

#Aggiungiamo l'ingrediente "Basilico" alla Pizza Margherita
print(manager.add_ingredient("Pizza Margherita", "Basilico"))

#Sostituiamo "Mozzarella" con "Mozzarella di Bufala"
print(manager.update_ingredient("Pizza Margherita", "Mozzarella", "Mozzarella di Bufala"))

#Rimuoviamo l'ingrediente "Acqua" dalla ricetta
print(manager.remove_ingredient("Pizza Margherita", "Acqua"))

#Visualizziamo gli ingredienti attuali della Pizza Margherita
print(manager.list_ingredients("Pizza Margherita"))
