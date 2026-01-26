'''
6-11. Cities: Make a dictionary called cities.
 Use the names of three cities as keys in your dictionary. 
 Create a dictionary of information about each city and include the country that the city is in, its approximate population, and one fact about that city. The keys for each city’s dictionary should be something like country, population, and fact. 
 Print the name of each city and all of the information you have stored about it.

'''

# Creazione del dizionario "cities" con le città come chiavi.
# Ogni città ha un dizionario associato che contiene il paese, la popolazione e un fatto interessante.
cities: dict[str, dict[str, str | int]] = {
    "Vienna": {
        "country": "Vienna",           # Paese in cui si trova la città
        "population": 20001500,         # Popolazione della città
        "fact": "Vienna è conosciuta come la città della musica."  # Fato interessante sulla città
    },
    "Parigi": {
        "country": "Stati Uniti",
        "population": 2103000,
        "fact": "Parigi è la città dell'amore."
    },
    "Tokyo": {
        "country": "Giappone",
        "population": 13929286,
        "fact": "Tokyo è la città più popolosa del mondo."
    }
}

# Iterazione attraverso il dizionario delle città per stampare le informazioni
for city, info in cities.items():
    print(f"\nInformazioni su {city}:")
    print(f"Paese: {info['country']}")
    print(f"Popolazione: {info['population']}")
    print(f"Fatto interessante: {info['fact']}")

