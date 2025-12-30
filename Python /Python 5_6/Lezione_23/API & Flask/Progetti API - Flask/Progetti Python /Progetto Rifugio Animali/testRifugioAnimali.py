import requests
import json

URL = "http://127.0.0.1:5000"

#We create a delimitator to have a good response on the terminal, distinguishing all the parts
def delimitatore(title):
    print(f"\n{'='*10} {title} {'='*10}")



if __name__ == "__main__":
    headers = {
        'Content-type': 'application/json',
        'Accept': 'application/json'
    }



    #1. GET /
    delimitatore("GET / (HOME)")
    ris = requests.get(f"{URL}/", headers=headers)
    print(ris.json())

    #2. GET /animals 
    delimitatore("GET /animals (LISTA INIZIALE)")
    ris = requests.get(f"{URL}/animals", headers=headers)
    print(ris.json())

  
   
    delimitatore("GET /animals/d1 (DETTAGLI E CIBO)")
    ris_info = requests.get(f"{URL}/animals/d1", headers=headers)
    ris_food = requests.get(f"{URL}/animals/d1/food", headers=headers)
    ris_adopt_status = requests.get(f"{URL}/animals/d1/adoption", headers=headers)
    
    #3. GET /animals/d1
    print(f"INFO: {ris_info.json()}")

    #4. GET /animals/d1/food 
    print(f"STIMA CIBO: {ris_food.json()}")

    #5. GET /animals/d1/adoption
    print(f"ADOZIONE STATO: {ris_adopt_status.json()}")

   
    #6. POST /animals/add – aggiunta di un nuovo cane 
    delimitatore("POST /animals/add (NUOVO CANE)")
    nuovoCane = {
        'id': 'd99',
        'type': 'dog',
        'name': 'Rudy',
        'age_years': 3,
        'weight_kg': 45.2,
        'breed': 'Meticcio',
        'is_trained': False
    }
    ris_post_nuovoCane = requests.post(f"{URL}/animals/add", json=nuovoCane, headers=headers)
    print(f"Risposta aggiunta: {ris_post_nuovoCane.json()}")

    
    #7. POST /animals/add – aggiunta di un nuovo gatto
    delimitatore("POST /animals/add (NUOVO GATTO)")
    nuovoGatto = {
        'id': 'c50',
        'type': 'cat',
        'name': 'Luna',
        'age_years': 2,
        'weight_kg': 4.5,
        'is_indoor': True,
        'favorite_toy': 'Topolino di stoffa'
    }
    ris_post_gattp = requests.post(f"{URL}/animals/add", json=nuovoGatto, headers=headers)
    print(f"Risposta aggiunta: {ris_post_gattp.json()}")

    
    #8.0 POST /animals/<animal_id>/adopt – registrare un’adozione
    delimitatore("POST /adopt (REGISTRA ADOZIONE PER RUDY)")
    adoption_data = {"adopter_name": "Mario Rossi"}
    res_adopt = requests.post(f"{URL}/animals/d99/adopt", json=adoption_data, headers=headers)
    print(f"Risposta adozione: {res_adopt.json()}")

    #8.1 POST /animals/<animal_id>/adopt – verificare un’adozione
    delimitatore("VERIFICA FINALE ADOZIONE")
    res_final = requests.get(f"{URL}/animals/d99/adoption", headers=headers)
    print(f"Stato finale Rudy: {res_final.json()}")