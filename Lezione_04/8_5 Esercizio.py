'''
8-5. Cities: Write a function called describe_city() that accepts the name of a city and its country. 
The function should print a simple sentence, such as Reykjavik is in Iceland. Give the parameter for the country a default value. 
Call your function for three different cities, at least one of which is not in the default country.
'''

'''


''                                                          |METODO RICHIESTO DALL'ESERCIZIO|                                                                                           '''

#Definiamo una funzione, che prende come parametri la città e il paese che di DEFAULT è "Italy"
def describe_city(city:str, country:str = "Italy"):
    print(f"{city} is in {country}.")

# Chiamate della funzione per tre città, nelle prime due di DEFAULT "Italy", come dichiarato nella funzione, mentre nell'ultima si specifica il paese in questione
describe_city("Rome")                
describe_city("Milan")               
describe_city("Reykjavik", "Iceland")





'''                                                          |METODO AVANZATO DELL'ESERCIZIO|                                                                                           '''

''' #Definiamo una funzione, che prende come parametri la città e il paese che di DEFAULT è "Italy"
def describe_city(city: str, country:str = "Italy"):
    print(f"{city} is in {country}.")

#Facciamo un cilo FOR per x3 volte come richiesto dall'esercizio e stampiamo
for i in range(3):
    city = input("\nInserisci il nome della città: ")
    country = input("\nInserisci il nome del paese (premi invio per usare 'Italy'): ")
    if country == "": 
        print("\n")
        describe_city(city)
    else:
        print("\n")
        describe_city(city, country) '''

 


