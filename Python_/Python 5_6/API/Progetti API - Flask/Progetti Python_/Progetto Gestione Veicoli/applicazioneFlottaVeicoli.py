'''
Applicazione Flask

Crea un’applicazione Flask che espone diverse route per gestire i veicoli presenti nel sistema. Le funzioni delle route devono restituire oggetti JSON.

Dovrai usare tutti i metodi HTTP principali:

    GET (lettura),

    POST (creazione),

    PUT (sostituzione totale),

    PATCH (aggiornamento parziale),

    DELETE (cancellazione).

Route GET
GET /

Restituisce un JSON con:

    una breve descrizione del servizio, ad esempio: "Welcome to Rent Service API";

    link testuali che indicano le altre route attualmente disponibili, generati dinamicamente con url_for(), ad esempio:

        /vehicles,

        /vehicles/HA014AS,

        /vehicles/HA014AS/prep-time/2.0

Il JSON potrebbe avere una struttura tipo:

{
    "message": "Welcome to Rent Center API",
    "links": {
        "vehicles_list": /vehicles,
        "vehicle_sample": /vehicles/HA014AS,
        "estimate_sample": /devices/HA014AS/prep-time/2.0)
    }
}

GET /vehicles

Restituisce un JSON con l'elenco di tutti i veicoli presenti nel sistema.
Ogni elemento può essere:

    una stringa descrittiva,
    ad esempio "HA014AS - Car - Fiat Panda (status: received)",

    oppure

    un dizionario con i campi principali (quelli restituiti da info()).

La scelta è libera, ma deve essere coerente in tutto il programma.
GET /vehicles/<plate_id>

Restituisce un JSON con i dettagli del veicolo specificato.

Se il veicolo non è presente nel sistema, restituire un JSON di errore (es. {"error": "Vehicle not found"}) con status code 404.
GET /vehicles/<plate_id>/prep-time/<factor>

Restituisce un JSON con il tempo stimato totale per la preparazione del veicolo, utilizzando il metodo estimated_prep_time(factor: float).

Esempio di output:

{
  "id": "HA014AS",
  "device_type": "car"
  "factor": 2.0,
  "estimated_total_minutes": 120
}

Se il veicolo non esiste, si ottiene un errore 404.

Il parametro factor può essere letto dall'URL e convertito in float (con un default di 1.0 se vuoi renderlo opzionale).
Route POST
POST /vehicles

Permette di aggiungere un nuovo veicolo al sistema.

Il body della richiesta deve essere JSON, letto con request.get_json().
Deve contenere almeno:

    type: "car" o "van",

    plate_id, model, driver_name, registration_year, status,

    più i campi specifici del tipo (es. per smartphone: doors, is_cabrio).

Esempio di JSON per uno smartphone:

{
  "type": "car",
  "id": "XX999YY",
  "model": "Fiat 500 Cabrio",
  "customer_name": "Mario Rossi",
  "purchase_year": 2022,
  "status": "available",
  "doors": 3
  "is_cabrio": true
}

La funzione della route deve:

    validare il JSON (campi obbligatori, tipo corretto),

    creare l’istanza corretta (Car o Van),

    aggiungerla al centro con fleet_manager.add(device),

    restituire un JSON di conferma (es. con info()) e status code 201,
    oppure un JSON di errore con status code 400 in caso di problemi (es. campi mancanti, tipo non riconosciuto).

Route PUT
PUT /vehicles/<plate_id>

Sostituisce completamente le informazioni di un veicolo esistente con quelle fornite nel body JSON (stesso formato del POST /vehicles).

Comportamento tipico:

    Se il veicolo esiste → viene rimpiazzato (aggiornato completamente).

    Se non esiste → puoi scegliere se:

        creare un nuovo veicolo con quell’plate id, oppure

        restituire un errore 404.

Route PATCH
PATCH /vehicles/<plate_id>/status

Aggiorna solo lo stato (status) del veicolo specificato.

Body JSON di esempio:

{
  "status": "rented"
}

La funzione deve:

    verificare che il veicolo esista,

    leggere il nuovo stato dal JSON,

    chiamare fleet_manager.patch_status(device_id, new_status),

    restituire il veicolo aggiornato (via info()) o un messaggio di conferma.

In caso di veicolo inesistente → errore 404.
Route DELETE
DELETE /vehicles/<plate_id>

Rimuove un veicolo dal sistema.

Comportamento:

    Se il veicolo esiste → viene eliminato e si restituisce un JSON di conferma (es. {"deleted": true, "id": "XX999YY"}).

    Se non esiste → restituire un JSON di errore con status code 404.

Struttura del progetto

Il progetto può essere organizzato in questo modo:

    main.py
    Contiene:

        le classi Vehicle, Car, Van, FleetManager,

        l’istanza globale di FleetManager e i dispositivi di esempio,

        l’applicazione Flask con tutte le route definite sopra.

    test_api.py
    Contiene i test che usano requests per chiamare la tua API.

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
from flask import Flask,url_for,jsonify,request
from flottaVeicoli import *


app = Flask(__name__)

flotta = FleetManager()


primoVeicolo = Car(

   
    plate_id= "HA323JK",
    model= "Toyota Yaris Cross 2025",
    driver_name= "Nicol Jayasuriya",
    registration_year= 2025,
    status= Status.AVAILABLE,
    doors= 5,
    is_cabrio= True

)

secondoVeicolo = Van(

   
    plate_id= "HA001AA",
    model= "Fiat Doblò AirCross Hybrid 2026",
    driver_name= "Reenbac Company",
    registration_year= 2025,
    status= Status.MAINTENANCE,
    max_load_kg= 9924,
    require_special_license= True
)

flotta.add(primoVeicolo)
flotta.add(secondoVeicolo)

@app.route('/')


def homePage():

    linksAll = {

        'vehicles_list': url_for('get_vehicles'),
        'vehicle_sample' : url_for('get_vehicle', plate_id= "HA014AS"),
        'estimate_sample': url_for('get_estimate_time', plate_id= "HA014AS", factor=2.0)

       }
    

    messaggioBenvenuto = "Weclome to Rent Service API"


    return jsonify({

        'message' : messaggioBenvenuto,
        'links' : linksAll

      })



@app.route('/vehicles', methods=["GET"] )

def get_vehicles():

    data = [] 

    for el in flotta.list_all():


        data.append(el.info())
    return jsonify(data)



@app.route('/vehicles/<plate_id>',  methods=["GET"])


def get_vehicle(plate_id):

    veicolo = flotta.get(plate_id)

    if veicolo is None:

        return jsonify({"ERRORE" : "VEICOLO NON TROVATO "}), 404
    else:
        return jsonify(veicolo.info())
    




@app.route('/vehicles/<plate_id>/prep-time/<float:factor>',  methods=["GET"])

def get_estimate_time(plate_id, factor = 1.0):


    veicolo = flotta.get(plate_id)


    if veicolo is None:

          return jsonify({"ERRORE" : "VEICOLO NON TROVATO "}), 404
    else:

        time = veicolo.estimated_prep_time()

        return{

            "id": veicolo.plate_id,
            "device_type": veicolo.type,
            "factor": factor,
            "estimated_total_minutes": veicolo.estimated_prep_time(factor)

           }
       


@app.route('/vehicles', methods=["POST"])

def post_vehicles():
    data = request.get_json()
    
    #Required data, that we pass to check with the 'issubset' and the original JSON data ->  'data'     
    datiRichiesti = {"type", "id", "model", "driver_name", "registration_year", "status"}


    #Throught the 'issubset' we go to check if all the fields are on it. Avoiding using match or if cases to validate the fields 
    if not data or not datiRichiesti.issubset(data):


        return jsonify({'ERRORE': 'CI SONO DEI DATI MANCANTI, PER FAVORE COMPILARLI'}), 400
    
    if flotta.get(data["id"]):
        return jsonify({"ERRORE": "Targa già esistente"}), 400
    
    try:
        status_obj = Status[data["status"].replace("Status.", "")]

    except KeyError:

        status_obj = Status.AVAILABLE

    if data["type"] == "car":

        veicolo = Car(
            data["id"], 
            data["model"], 
            data["driver_name"], 
            data["registration_year"], 
            status_obj, 
            data.get("doors", 5), 
            data.get("is_cabrio", False)
        )

    elif data["type"] == "van":

        veicolo = Van(
            data["id"], 
            data["model"], 
            data["driver_name"], 
            data["registration_year"], 
            status_obj, 
            data.get("max_load_kg", 1000), 
            data.get("require_special_license", False)
        )

    else:
        return jsonify({'ERROR': 'Tipo non valido'}), 400 

    flotta.add(veicolo)
    return jsonify(veicolo.info()), 201




@app.route("/vehicles/<plate_id>", methods=["PUT"])

def put_vehicle(plate_id):

    data = request.get_json()
    veicolo_esistente = flotta.get(plate_id)
    
    if not veicolo_esistente:
        return jsonify({"ERRORE": "Veicolo non trovato"}), 404
    
    try:
        status_obj = Status[data["status"].replace("Status.", "")]

    except KeyError:
        status_obj = Status.AVAILABLE

    if data["type"] == "car":

        nuovo = Car(plate_id, data["model"], 
                    data["driver_name"], 
                    data["registration_year"], 
                    status_obj, 
                    data.get("doors", 5), 
                    data.get("is_cabrio", False))
        
    elif data["type"] == "van":
        nuovo = Van(plate_id, data["model"],
                     data["driver_name"], 
                    data["registration_year"], status_obj, 
                    data.get("max_load_kg", 1000), 
                    data.get("require_special_license", False))
        
    else:
        return jsonify({"ERRORE": "Tipo non valido"}), 400

    flotta.update(plate_id, nuovo)
    return jsonify(nuovo.info()), 200





@app.route("/vehicles/<plate_id>/status", methods =["PATCH"] )
def patch_status(plate_id) -> dict:

    veicolo =  flotta.get(plate_id)
    data = request.get_json()


    if not veicolo:

        return jsonify({"ERRORE" : "ATTENZIONE ! il veicolo NON è stato TROVATO"}), 404
    
    if "status" not in data:
          return jsonify({"ERRORE" : "ATTENZIONE ! STATO VEICOLO NON INDIVIDUATO, INSERIRE IL CAMPO !"}), 404
    
    
    flotta.patch_status(plate_id, data["status"])
    return jsonify(veicolo.info())




@app.route("/vehicles/<plate_id>", methods=["DELETE"])
def delete_vehicle(plate_id):
    if not flotta.get(plate_id):
        return jsonify({"ERRORE": "Veicolo non trovato"}), 404
    
    flotta.delete(plate_id)
    return jsonify({"deleted": True, "id": plate_id}), 200


if __name__ ==  "__main__":

    app.run(debug= True)