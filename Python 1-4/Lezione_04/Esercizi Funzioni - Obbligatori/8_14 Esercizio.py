'''
8-14. Cars: Write a function that stores information about a car in a dictionary. 
The function should always receive a manufacturer and a model name. It should then accept an arbitrary number of keyword arguments. 
Call the function with the required information and two other name-value pairs, such as a color or an optional feature. 
Your function should work for a call like this one: car = make_car('subaru', 'outback', color='blue', tow_package=True) 
Print the dictionary that’s returned to make sure all the information was stored correctly.
'''



#Definiamo una funzione che mostra in output il dizionario della composizione di una macchina, prendendo in considerazione come parametri:
'''AZIENDA MANIFATTURIERA, MODELLO DELLA MACCHINA, COLORE, PRESENZA DEL VOLANTE IN CARBONIO'''
def car (manufacturer:str,model_name:str,color:str=None,carbon: bool=None, **car:dict):

    car:dict ={"AZIENDA MANUFATTURIERA": manufacturer , "MODELLO" : model_name, "COLORE" : color, "VOLANTE IN CARBONIO": carbon }
    
    return car

#Richiamiamo la funzione per tre volte, associandola a un nome , stampando poi i relativi dict
veicolo1 = car("RENAULT", "SCENIC")
veicolo2 = car("RENAULT", "SCENIC", "Grey")
veicolo3 = car("RENAULT", "SCENIC", "Grey", carbon=False)

print ("\n",veicolo1)
print ("\n",veicolo2)
print ("\n",veicolo3)







'''                                           |  FUNZIONE MIGLIORATA E AVANZATA DEL CODICE  |                                                     '''

'''
# Definiamo una funzione che crea un dizionario contenente le informazioni di un'auto
# Prendendo in considerazione come parametri: AZIENDA MANIFATTURIERA, MODELLO, COLORE, VOLANTE IN CARBONIO
def car(manufacturer: str, model_name: str, color: str = None, carbon: bool = None, **kwargs):
    """Memorizza le informazioni su un'auto in un dizionario."""
    car_info = {
        "AZIENDA MANUFATTURIERA": manufacturer,  
        "MODELLO": model_name,  
        "COLORE": color,  
        "VOLANTE IN CARBONIO": carbon  
    }
    
    # Aggiunge eventuali altri attributi opzionali forniti dall'utente
    car_info.update(kwargs)
    
    return car_info

# Richiediamo all'utente di inserire i dati della macchina
manufacturer: str = input("Benvenuto, inserisci l'AZIENDA PRODUTTRICE della macchina: ")
model_name: str = input("Inserisci il MODELLO della macchina: ")
color: str = input("Inserisci il COLORE della macchina: ")

# Converte l'input della presenza del volante in carbonio in un valore booleano
carbon_input = input("Inserisci 'True' o 'False' in base alla presenza del VOLANTE IN CARBONIO: ")
carbon: bool = carbon_input.strip().lower() == "true"

# Chiamiamo la funzione passando i dati inseriti dall'utente e memorizziamo il risultato
veicolo = car(manufacturer, model_name, color, carbon)

# Stampiamo il dizionario contenente le informazioni dell'auto
print(veicolo) 

'''