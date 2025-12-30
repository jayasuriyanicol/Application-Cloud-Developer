'''
Test automatici con requests
Scrivi un file di test che:

    Imposta gli header per lavorare con JSON, ad esempio:

    headers = {
        "Content-type": "application/json",
        "Accept": "application/json"
    }

    Esegue almeno le seguenti operazioni, usando requests:

        GET / e stampa / verifica il contenuto della risposta;

        GET /vehicles e controlla che la lista non sia vuota;

        POST /vehicles per aggiungere un nuovo veicolo;

        GET /vehicles/<plate_id> per verificare che sia stato creato;

        PATCH /vehicles/<plate_id>/status per aggiornare lo stato;

        PUT /vehicles/<plate_id> per sostituire le info del veicolo;

        DELETE /vehicles/<plate_id> per eliminarlo;

        GET /vehicles/<plate_id> per verificare che non esista più (status 404).

    Come minimo, i test devono stampare le risposte.

Esempio minimale di struttura (non il codice completo):

 

import requests
import json

BASE_URL = "http://localhost:5000"

if __name__ == "__main__":
    headers = {
        "Content-type": "application/json",
        "Accept": "application/json"
    }

    # Esempio: test su GET /
    response = requests.get(f"{BASE_URL}/", headers=headers)
    print("GET /", response.status_code, response.json())

    # ... altri test per POST, PUT, PATCH, DELETE ...


Prima di eseguire i test, il server Flask deve essere in esecuzione (ad esempio con python main.py o flask --app main run).
'''
import requests
import json 


BASE_URL =  "http://localhost:5000"
PLATE = "GH232DA"

#We create a delimitator to have a good response on the terminal, distinguishing all the parts
def delimitatore(title):
    print(f"\n{'='*10} {title} {'='*10}")


if __name__ == "__main__":


    headers ={


        "Content-type" : "application/json",
        "Accept" : "applications/json"


       }
    

   
    #1. GET / e stampa / verifica il contenuto della risposta
    delimitatore("GET / (HOME)")
    ris = requests.get (f"{BASE_URL}/", headers=headers)
    print(ris.json()) 




    #2. GET /vehicles e controlla che la lista non sia vuota

    delimitatore("GET /vehicles (LISTA NON VUOTA)")
    ris = requests.get(f"{BASE_URL}/vehicles", headers=headers)

    listaVeicoli = ris.json()

    if len(listaVeicoli) > 0:
        print("SUCCESSO ! La lista non è vuota\nJSON:\n", ris.json())
    else:
        print("ATTENZIONE ! La lista è vuota\nJSON:\n", ris.json())



   #3. POST /vehicles per aggiungere un nuovo veicolo

    delimitatore("POST /vehicles (NUOVO VEICOLO)")

    nuovoVeicolo = { 
        'type' : 'car',
        'id' : PLATE,
        'model': 'Citroen C5 Cross Mild Hybrid',
        'driver_name': 'Michael Jordan',
        'registration_year': 2024,
        'status' : 'CLEANING',
        'doors' : 5,
        'is_cabrio': False
    }

    ris = requests.post(f"{BASE_URL}/vehicles", json= nuovoVeicolo, headers=headers)
    print("RISPOSTA:\n", ris.json())


   #4. GET /vehicles/<plate_id> per verificare che sia stato creato;

    delimitatore("GET /vehicles/<plate_id> (VERIFICA VEICOLO)")

    ris = requests.get(f"{BASE_URL}/vehicles/{PLATE}", headers=headers)
    print("RISPOSTA:\n", ris.json())



   #5. PATCH /vehicles/<plate_id>/status per aggiornare lo stato;

    delimitatore("PATCH /vehicles/<plate_id>/status (AGGIORNA STATO VEICOLO)")

    nuovoStatus = {'status': 'AVAILABLE'}

    ris = requests.patch(f"{BASE_URL}/vehicles/{PLATE}/status", json=nuovoStatus, headers=headers)
    
    if ris.status_code == 200:

        print("SUCCESSO ! Veicolo aggiornato con successo !")
        print("JSON:\n", ris.json())

    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)


   #6. PUT /vehicles/<plate_id> per sostituire le info del veicolo;

    delimitatore("PUT /vehicles/<plate_id> (SOSTITUIRE INFO VEICOLO)")

    modificaVeicolo = { 
         
        'type': 'car',
        'model': 'Citroen C5 Cross Mild Hybrid',
        'driver_name': 'Giacomo Coccodrillini',
        'registration_year': 2024,
        'status' : 'AVAILABLE',
        'doors' : 5,
        'is_cabrio': False
    }


    ris = requests.put(f"{BASE_URL}/vehicles/{PLATE}", json=modificaVeicolo, headers=headers)

    if ris.status_code == 200:

        print("SUCCESSO ! Veicolo aggiornato con successo !")
        print("JSON:\n", ris.json())

    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)



   #7. DELETE /vehicles/<plate_id> per eliminarlo;

    delimitatore("DELETE /vehicles/<plate_id> (ELIMINARE VEICOLO)")

    ris = requests.delete(f"{BASE_URL}/vehicles/{PLATE}", headers=headers)


    if ris.status_code == 200:

        print(f"SUCCESSO ! Veicolo RIMOSSO con successo !")
        print("JSON:\n", ris.json())

        #8. GET /vehicles/<plate_id> per verificare che non esista più (status 404). 
        delimitatore("GET /vehicles/<plate_id> (VERIFICA RIMOZIONE VEICOLO)")
        ris_verifica = requests.get(f"{BASE_URL}/vehicles/{PLATE}", headers=headers)
        
        if ris_verifica.status_code == 404:
            print("CONFERMATO ! Il veicolo non esiste più (404 Not Found).")



    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)











         

    
    
    


    


    
 



