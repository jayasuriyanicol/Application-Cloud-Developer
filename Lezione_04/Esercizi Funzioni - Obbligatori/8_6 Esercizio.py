'''
8-6. City Names: Write a function called city_country() that takes in the name of a city and its country. 
The function should return a string formatted like this: "Santiago, Chile". 
Call your function with at least three city-country pairs, and print the values that are returned.
'''

'''
#Definiamop una funzione che stampa la città e la nazione per ogni dato inserito
def city_country(city:str, country:str):
    
    print(f"{city}, {country} !")

#Dati che abbiamo dato richiamando la funzione city_country
city_country("Roma", "Italia")
city_country("Lisbona", "Portogallo")
city_country("Parigi" , "Francia")
'''


#Definiamo una funzione nella quale inseriamo una città e un paese e ci restituirsce una str con il nome della città e il luogo.
def country_city(city: str, country: str) -> str:

    return f"{city}, {country}"

#Creiamo una lista per memorizzare per 3 volte l'inserimento della località
localita = [] 

#Ciclo FOR per richiedere 3 volte l'inserimento delle variabili necessarie
for num in range(3):
    num += 1
    city = input(f"\n\nInserisci il {num}° nome della CITTÀ: ")
    country = input(f"\nInserisci il {num}° nome della NAZIONE: ")
    localita.append(country_city(city, country))  # Correzione passaggio parametri

#Infine stampiamo i valori in output delle varie località salvate nella lista, spaziate per una corretta visualizzazione
print("\n\n--- Località inserite ---")
for luogo in localita:

    print(f"\n{luogo}")

print("\n\n------------------------")
