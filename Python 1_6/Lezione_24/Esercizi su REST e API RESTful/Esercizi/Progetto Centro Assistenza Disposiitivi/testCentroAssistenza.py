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

        GET /devices e controlla che la lista non sia vuota;

        POST /devices per aggiungere un nuovo dispositivo;

        GET /devices/<nuovo_id> per verificare che sia stato creato;

        PATCH /devices/<nuovo_id>/status per aggiornare lo stato;

        PUT /devices/<nuovo_id> per sostituire le info del dispositivo;

        DELETE /devices/<nuovo_id> per eliminarlo;

        GET /devices/<nuovo_id> per verificare che non esista più (status 404).

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


import requests, json

BASE_URL = "http://localhost:5000"

DEVICE = 'D002'

#We create a delimitator to have a good response on the terminal, distinguishing all the parts
def delimitatore(title):
    print(f"\n{'='*10} {title} {'='*10}")


if __name__ == "__main__":
    headers = {
        "Content-type": "application/json",
        "Accept": "application/json"
    }

    #1. GET / e stampa / verifica il contenuto della risposta 
    delimitatore("GET / (HOME)")
    ris = requests.get(f"{BASE_URL}/", headers=headers)
    print("RISPOSTA ->\n" ,ris.json())


   #2. GET /devices e controlla che la lista non sia vuota;
    delimitatore("GET /devices (LISTA NON VUOTA)")
    ris = requests.get(f"{BASE_URL}/devices", headers=headers)

    listaDispositivi = ris.json()

    if len(listaDispositivi) > 0:
        print("SUCCESSO ! La lista non è vuota\nJSON:\n", ris.json())
    else:
        print("ATTENZIONE ! La lista è vuota\nJSON:\n", ris.json())


  #3.POST /devices per aggiungere un nuovo dispositivo;

    delimitatore("POST /devices (NUOVO DISPOSITIVO)")

    nuovoDispositivo = { 
        'type' : 'smartphone',
        'id' : 'D002',
        'model': 'Xiamo RedGrey 2',
        'customer_name': 'Cristiano Coccia',
        'purchase_year': 2022,
        'status' : 'ready',
        'has_protective_case' : True,
        'storage_gb': 128
    }

    ris = requests.post(f"{BASE_URL}/devices", json= nuovoDispositivo, headers=headers)
    print("RISPOSTA:\n", ris.json())




    #4. GET /devices/<nuovo_id> per verificare che sia stato creato;

    delimitatore("GET /devices/<device_id> (VERIFICA DISPOSITIVO)")

    ris = requests.get(f"{BASE_URL}/devices/{DEVICE}", headers=headers)
    print("RISPOSTA:\n", ris.json())




   #5. PATCH /devices/<device_id>/status per aggiornare lo stato;

    delimitatore("PATCH /devices/<device_id>/status (AGGIORNA STATO DISPOSITIVO)")

    nuovoStatus = {'status': 'delivered'}

    ris = requests.patch(f"{BASE_URL}/devices/{DEVICE}/status", json=nuovoStatus, headers=headers)
    
    if ris.status_code == 200:

        print("SUCCESSO ! Dispositivo aggiornato con successo !")
        print("JSON:\n", ris.json())

    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)


   #6. PUT /devices/<device_id> per sostituire le info del dispositivo;

    delimitatore("PUT /devices/<devices_id> (SOSTITUIRE INFO DISPOSITIVO)")

    modificaDisp = { 
         
        'type' : 'smartphone',
        'id' : 'D002',
        'model': 'Xiamo RedGrey 2',
        'customer_name': 'Cristiano Coccia',
        'purchase_year': 2022,
        'status' : 'delivered',
        'has_protective_case' : True,
        'storage_gb': 128
    }


    ris = requests.put(f"{BASE_URL}/devices/{DEVICE}", json=modificaDisp, headers=headers)

    if ris.status_code == 200:

        print("SUCCESSO ! Dispositivo aggiornato con successo !")
        print("JSON:\n", ris.json())

    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)



   #7. DELETE /devices/<device_id> per eliminarlo;

    delimitatore("DELETE /devices/<device_id> (ELIMINARE DISPOSITIVO)")

    ris = requests.delete(f"{BASE_URL}/devices/{DEVICE}", headers=headers)


    if ris.status_code == 200:

        print(f"SUCCESSO ! Dispositivo RIMOSSO con successo !")
        print("JSON:\n", ris.json())

        #8. GET /devices/<device_id> per verificare che non esista più (status 404). 
        delimitatore("GET /devices/<device_id> (VERIFICA RIMOZIONE DISPOSITIVO)")
        ris_verifica = requests.get(f"{BASE_URL}/devices/{DEVICE}", headers=headers)
        
        if ris_verifica.status_code == 404:
            print("CONFERMATO ! Il Dispositivo non esiste più (404 Not Found).")



    else:

        print("ATTENZIONE ! Errore, non è stato possibilie proseguire con la richiesta", ris.status_code)

























