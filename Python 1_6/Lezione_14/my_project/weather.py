#Definiamo una funzione per il nostro primo TEST che ci permette di verificare le condizioni del METEO
def check_weather(temperature: float) -> str:
    if temperature > 20:
        return "hot"
    elif 10 < temperature <= 20:
        return "average"
    else:
        return "cold"
    
