''''
Esercizio 1

Crea un context manager usando una classe

Definisci una classe FileManager che implementa un context manager che gestisce le risorse dei file.

Implementa appropriatamente la funzione __init__, __enter__ e la funzione  __exit__

Esempio di funzionamento:

Il context manager deve permettere di aprire il file, effettuare operazioni e chiudere la risorsa aperta.

with FileManager('example.txt', 'w') as f:

    f.write('Hello, world!')
'''



class FileManager:

    def __init__(self,nome: str, mode:str ,coding: str)-> None:
        
        self.nome = nome
        self.mode = mode
        self.coding = coding

    def __enter__(self):
        

        #Messaggio di conferma che il valore è satto acquisito con successo, ritornando anche il valore di SELF.  
        print("SUCCESSO ! la RISORSA è stata acquisita !")

        return False
        
        
    def __exit__ (self,exc_type: None, exc_value: None, traceback: None):


        #Messaggio di conferma per l'utente per far capire che la risoras è stat rilasciata 
        print("SUCCESSO ! La risorsa è stata RILASCIATA !") 

        if exc_type is not None:
            print(f"Exception type:{exc_type}") #Valore della eccezione (messaggio) TYPE che è stata lanciata -> Se no NONE  
            print(f"Exception value : {exc_value}") #Valore della eccezione (messaggio) VALUE che è stata lanciata  -> Se no NONE   
            print(f"Traceback: {traceback}") #Valore della eccezione (messaggio) TRACEBACK che è stata lanciata -> Se no NONE  
        
        return False
    
    


with FileManager() as resource:
    print("Sei all'interno del BLOCCO WITH !")


'''------------------------------------------------------------    SPIEGAZIONE DI UN FILE JSON      ---------------------------------------------------------------------------------------------------'''


'''----------------------------------------------------------CLASSE EXAMPLE --------------------------------------------------------------------------'''
class Example:

    def __init__(self,name,versione):
        self.name= name  
        self.version = versione 

#Import di un file JSON
import json
with open("Lezione_15/config.json", "r") as file:
    myConfig : dict= json.load(file)
    print(myConfig["**"] )
# ** -> Version,Features,ecc.



'''-----------------------------------------ESEMPIO DI SALVATAGGIO DI UN FILE NEL FILE JSON------------------------------------------------'''    
file  = open("Lezione_15/configNewJson", "w")

db : dict = { "JYSNP..." : {"name": "Nicol", "surname":"Jayasuriya", "age": 20},
              "JYDNA..." : {"name": "Dilan", "surname":"Jayasuriya", "age": 30},
              "JYALP..." : {"name": "Anton", "surname":"Jayasuriya", "age": 53}}


json.dump(db,file)




'''------------------------------------METODO SLAVATAGGIO DI UN FILE JSON ------------------------------'''



json.dump(myConfig, file) #Utilizzo l'operatore dump per salvare il valore nel file JSON  
example_1 : Example = Example(myConfig["name"],myConfig["versione"])

jsonData : dict = json.load(file) #Per caricare un dato nel file JSON 

jsonData["features"] = "Ciao"

json.dump[jsonData,file] 

file.close()