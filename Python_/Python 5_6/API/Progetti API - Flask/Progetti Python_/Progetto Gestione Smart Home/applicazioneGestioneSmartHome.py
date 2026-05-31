'''
Applicazione Flask

Crea un’applicazione Flask che espone diverse route per gestire i dispositivi presenti nel sistema. Le funzioni delle route devono restituire oggetti JSON.

Dovrai usare tutti i metodi HTTP principali:

    GET (lettura),

    POST (creazione),

    PUT (sostituzione totale),

    PATCH (aggiornamento parziale),

    DELETE (cancellazione).

Route GET
GET /

Restituisce un JSON con:

    una breve descrizione del servizio, ad esempio: "Smart Home Hub API";

    link testuali che indicano le altre route attualmente disponibili, generati dinamicamente con url_for(), ad esempio:

        /devices,

        /devices/SN-101,

        /devices/SN-101/diagnostics/1.0

Il JSON potrebbe avere una struttura tipo:

{
    "message": "Smart Home Hub API",
    "links": {
        "vehicles_list": /devices,
        "vehicle_sample": /devices/SN-101,
        "estimate_sample": /devices/SN-101/diagnostic/1.0)
    }
}

GET /devices

Restituisce un JSON con l'elenco di tutti i veicoli presenti nel sistema.
Ogni elemento può essere:

    una stringa descrittiva,
    ad esempio "SN-101 - Bulb - Nest (status: received)",

    oppure

    un dizionario con i campi principali (quelli restituiti da info()).

La scelta è libera, ma deve essere coerente in tutto il programma.
GET /devices/<serial_number>

Restituisce un JSON con i dettagli del dispositivo specificato.

Se il veicolo non è presente nel sistema, restituire un JSON di errore (es. {"error": "device not found"}) con status code 404.
GET /devices/<serial_number>/diagnostic/<factor>

Restituisce un JSON con il tempo stimato per una diagnostica completa del dispositivo, utilizzando il metodo diagnostics_time(factor: float).

Esempio di output:

{
  "id": "SN-101",
  "device_type": "bulb"
  "factor": 1.0,
  "diagnostic_seconds": 45
}

Se il dispositivo non esiste, si ottiene un errore 404.

Il parametro factor può essere letto dall'URL e convertito in float (con un default di 1.0 se vuoi renderlo opzionale).
Route POST
POST /devices

Permette di aggiungere un nuovo veicolo al sistema.

Il body della richiesta deve essere JSON, letto con request.get_json().
Deve contenere almeno:

    type: "bulb" o "camera",

    serial_number, brand, room, installation_year, status,

    più i campi specifici del tipo (es. per camera: resolution, night_vision).

Esempio di JSON per una telecamera intelligente:

{
  "type": "camera",
  "id": "SN-3e67",
  "brand": "Philips",
  "room": "Living Room",
  "installation_year": 2022,
  "status": "online",
  "resolution": 3
  "night_vision": true
}

La funzione della route deve:

    validare il JSON (campi obbligatori, tipo corretto),

    creare l’istanza corretta (SmartBulb o SecurityCamera),

    aggiungerla al centro con iot_hub.add(device),

    restituire un JSON di conferma (es. con info()) e status code 201,
    oppure un JSON di errore con status code 400 in caso di problemi (es. campi mancanti, tipo non riconosciuto).

Route PUT
PUT /devices/<serial_number>

Sostituisce completamente le informazioni di un dispositivo esistente con quelle fornite nel body JSON (stesso formato del POST /devices).

Comportamento tipico:

    Se il veicolo esiste → viene rimpiazzato (aggiornato completamente).

    Se non esiste → puoi scegliere se:

        creare un nuovo veicolo con quell’plate id, oppure

        restituire un errore 404.

Route PATCH
PATCH /devices/<serial_number>/status

Aggiorna solo lo stato (status) del dispositivo specificato.

Body JSON di esempio:

{
  "status": "mantainance"
}

La funzione deve:

    verificare che il dispositivo esista,

    leggere il nuovo stato dal JSON,

    chiamare iot_hub.patch_status(serial_number, new_status),

    restituire il dispositivo aggiornato (via info()) o un messaggio di conferma.

In caso di dispositivo inesistente → errore 404.
Route DELETE
DELETE /devices/<serial_number>

Rimuove un dispositivo dal sistema.

Comportamento:

    Se il dispositivo esiste → viene eliminato e si restituisce un JSON di conferma (es. {"deleted": true, "serial_number": "SN-34567"}).

    Se non esiste → restituire un JSON di errore con status code 404.

Struttura del progetto

Il progetto può essere organizzato in questo modo:

    main.py
    Contiene:

        le classi SmartDevice, SmartBulb, SecurityCamera, IoTHub,

        l’istanza globale di IoTHub e i dispositivi di esempio,

        l’applicazione Flask con tutte le route definite sopra.

    test_api.py
    Contiene i test che usano requests per chiamare la tua API.

'''


from flask import Flask,request,jsonify,url_for
from gestioneSmartHome import *

app = Flask(__name__)

smart = IoTHub()

primoDisp = SmartBulb (

            serial_number = "SM321",
            brand ="Amazon BulbSmart",
            room = "Salotto",
            installation_year= 2023,
            status= Status.online,
            brightness_lumens = 900,
            color_capability = True 

)

secondoDisp = SecurityCamera (

            serial_number = "SC310",
            brand ="Xiaomi NightVision 4K",
            room = "Corridoio",
            installation_year= 2025,
            status= Status.updating,
            resolution= "4K",
            night_vision= True

)


smart.add(primoDisp)
smart.add(secondoDisp)



@app.route('/')

def homePage():

    linksAll = {

        'devices_list' : url_for('get_devices'),
        'device_sample': url_for('get_device', serial_number = "SM321"),
        'estimate_sample' : url_for('get_estimate_sample',serial_number="SC310", factor= 1.5)

       }
    
    messaggioBenvenuto = "Smart Home Hub API"



    return jsonify ({

        'message' : messaggioBenvenuto,
        'links': linksAll
    })


@app.route('/devices', methods=["GET"])

def get_devices():

    return jsonify([d.info() for d in smart.list_all()])


@app.route('/devices/<serial_number>', methods=["GET"])


def get_device(serial_number:str):

    data = smart.get(serial_number)

    if data is None:

        return({'ERROR': "Attenzione il dispositivo NON risulta essere presente nel SISTEMA"}),404
    
    else:

        return jsonify(data.info())
    


@app.route('/devices/<serial_number>/diagnostics/<factor>', methods=["GET"])

def get_estimate_sample(serial_number:str,factor:float):


    disp = smart.get(serial_number)


    if disp is None:


        return({'ERROR': "Attenzione il dispositivo NON risulta essere presente nel SISTEMA"}),404
    
    else:
        time = disp.diagnostics_time()
        return jsonify({

            "id": serial_number,
            "device_type": disp.device_type(),
            "factor": factor,
            "diagnostics_time": time
           })


@app.route('/devices', methods= ["POST"])

def post_devices():

    data = request.get_json()

    datiRichiesti = {"type", "serial_number", "brand", "room", "installation_year", "status"}


    if not data or not datiRichiesti.issubset(data):

           return jsonify({'ERRORE': "Ci sono dei DATI MANCANTI DA COMPILARE"}), 400
    
    if (data["serial_number"]):

           return jsonify({"ERRORE" : "Il dispositivo risulta già essere PRESENTE"}), 400 
     
    try:
         
         statusOggetto = Status[data["status"].lower()] 
    
    except KeyError:
         
         statusOggetto = Status.online 

    
    if data["type"] == "bulb":
         

         device = SmartBulb (

            data["serial_number"], 
            data["brand"], 
            data["room"], 
            data["installation_year"],
            statusOggetto,
            data.get("brightness_lumens", "800"), 
            data.get("color_capability", False)

        ) 
    elif data["type"] == "camera":
         

         device = SecurityCamera (

            data["serial_number"], 
            data["brand"], 
            data["room"], 
            data["installation_year"],
            statusOggetto,
            data.get("resolution", "1080p"), 
            data.get("night_vision", True)

        ) 
    
    else:


        return jsonify ({'ERRORE' : "ATTENZIONE ! Tipologia di dispositivo NON PRESENTE NEL SISTEMA !"}),400 
    

    smart.add(device)
    return jsonify(device.info()), 201
  


@app.route('/devices/<serial_number>', methods=["PUT"])


def put_devices(serial_number:str):

    data = request.get_json()  

    dispEsistente = smart.get(serial_number)


    if not dispEsistente:

         return jsonify({'ERROR': "ATTENZIONE ! Il dispositivo inserito NON esiste"}), 404

    try:

         statusOggetto = Status[data["status"].lower()]

    except KeyError:

         statusOggetto = Status.online

    if data["type"] == "bulb":
         

         device = SmartBulb (

            serial_number, 
            data["brand"], 
            data["room"], 
            data["installation_year"],
            statusOggetto,
            data.get("brightness_lumens", "800"), 
            data.get("color_capability", False)

        ) 
    elif data["type"] == "camera":
         

         device = SecurityCamera (

            serial_number, 
            data["brand"], 
            data["room"], 
            data["installation_year"],
            statusOggetto,
            data.get("resolution", "1080p"), 
            data.get("night_vision", True)

        ) 
    
    else:


        return jsonify ({'ERRORE' : "ATTENZIONE ! Tipologia di dispositivo NON PRESENTE NEL SISTEMA !"}),400 
    

    smart.add(device)
    return jsonify(device.info()), 200




@app.route('/devices/<serial_number>/status', methods=["PATCH"] )

def patch_status(serial_number:str):
    data = request.get_json()
    dispEsistente = smart.get(serial_number)


    if not dispEsistente:
         


         return jsonify({'ERROR': "ATTENZIONE ! Il dispositivo inserito NON esiste"}), 404


    if "status" not in data:
         
         return jsonify({'ERRORE': "Lo stato del dispositivo NON È presente nel sistema !"}), 404


    smart.patch_status(serial_number, data["status"])
    return jsonify(dispEsistente.info())


@app.route('/devices/<serial_number>',methods=["DELETE"])

def delete_device(serial_number:str):
     
    disp = smart.get(serial_number)

    if not disp:
         
         
        return jsonify({'ERROR': "ATTENZIONE ! Il dispositivo inserito NON esiste"}), 404
    else:
         
         smart.delete(serial_number)
         return jsonify({"ELIMINATO" : True, "ID dispositivo eliminato" : serial_number}), 200
         

         




if __name__ == "__main__":
     
    app.run(debug=True)





    





