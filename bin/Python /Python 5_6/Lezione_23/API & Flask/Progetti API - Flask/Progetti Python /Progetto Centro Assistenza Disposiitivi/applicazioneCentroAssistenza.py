'''
Applicazione Flask

Crea un’applicazione Flask che espone diverse route per gestire i dispositivi del centro. Le funzioni delle route devono restituire oggetti JSON.

Dovrai usare tutti i metodi HTTP principali:

    GET (lettura),

    POST (creazione),

    PUT (sostituzione totale),

    PATCH (aggiornamento parziale),

    DELETE (cancellazione).

Route GET
GET /

Restituisce un JSON con:

    una breve descrizione del servizio, ad esempio: "Welcome to Service Center API";

    alcuni link testuali che indicano le altre route disponibili, generati dinamicamente con url_for(), ad esempio:

        /devices,

        /devices/d1,

        /devices/d1/estimate/1.5

Il JSON potrebbe avere una struttura tipo:

{
    "message": "Welcome to Service Center API",
    "links": {
        "list_devices": /devices,
        "sample_device": /devices/d1,
        "sample_estimate": /devices/d1/estimate/1.5)
    }
}

GET /devices

Restituisce un JSON con la lista di tutti i dispositivi presenti nel centro.
Ogni elemento può essere:

    una stringa descrittiva,
    ad esempio "d1 - smartphone - iPhone 13 (status: received)",

    oppure

    un dizionario con i campi principali (quelli restituiti da info()).

La scelta è libera, ma deve essere coerente in tutto il programma.
GET /devices/<device_id>

Restituisce un JSON con i dettagli del dispositivo specificato.

Se il dispositivo non esiste, restituire un JSON di errore (es. {"error": "Device not found"}) con status code 404.
GET /devices/<device_id>/estimate/<factor>

Restituisce un JSON con il tempo stimato totale per la lavorazione del dispositivo, utilizzando il metodo estimated_total_time(factor).

Esempio di output:

{
  "id": "d1",
  "device_type": "smartphone",
  "factor": 1.5,
  "estimated_total_minutes": 120
}

Se il dispositivo non esiste, tornare un errore 404.

Il parametro factor può essere letto dalla URL e convertito in float (con un default di 1.0 se vuoi renderlo opzionale).
Route POST
POST /devices

Permette di aggiungere un nuovo dispositivo.

Il body della richiesta deve essere JSON, letto con request.get_json().
Deve contenere almeno:

    type: "smartphone" o "laptop",

    id, model, customer_name, purchase_year, status,

    più i campi specifici del tipo (es. per smartphone: has_protective_case, storage_gb).

Esempio di JSON per uno smartphone:

{
  "type": "smartphone",
  "id": "d3",
  "model": "Galaxy S21",
  "customer_name": "Mario Rossi",
  "purchase_year": 2021,
  "status": "received",
  "has_protective_case": true,
  "storage_gb": 128
}

La funzione della route deve:

    validare il JSON (campi obbligatori, tipo corretto),

    creare l’istanza corretta (Smartphone o Laptop),

    aggiungerla al centro con service_center.add(device),

    restituire un JSON di conferma (es. con info()) e status code 201,
    oppure un JSON di errore con status code 400 in caso di problemi (es. campi mancanti, tipo non riconosciuto).

Route PUT
PUT /devices/<device_id>

Sostituisce completamente le informazioni di un dispositivo esistente con quelle fornite nel body JSON (stesso formato del POST /devices).

Comportamento tipico:

    Se il dispositivo esiste → viene rimpiazzato (aggiornato completamente).

    Se non esiste → puoi scegliere se:

        creare un nuovo dispositivo con quell’id, oppure

        restituire un errore 404.

Route PATCH
PATCH /devices/<device_id>/status

Aggiorna solo lo stato (status) del dispositivo specificato.

Body JSON di esempio:

{
  "status": "repairing"
}

La funzione deve:

    verificare che il dispositivo esista,

    leggere il nuovo stato dal JSON,

    chiamare service_center.patch_status(device_id, new_status),

    restituire il dispositivo aggiornato (via info()) o un messaggio di conferma.

In caso di dispositivo inesistente → errore 404.
Route DELETE
DELETE /devices/<device_id>

Rimuove un dispositivo dal centro di assistenza.

Comportamento:

    Se il dispositivo esiste → viene eliminato e si restituisce un JSON di conferma (es. {"deleted": true, "id": "d2"}).

    Se non esiste → restituire un JSON di errore con status code 404.

Struttura del progetto

Il progetto può essere organizzato in questo modo:

    main.py
    Contiene:

        le classi Device, Smartphone, Laptop, ServiceCenter,

        l’istanza globale di ServiceCenter e i dispositivi di esempio,

        l’applicazione Flask con tutte le route definite sopra.

    test_api.py
    Contiene i test che usano requests per chiamare la tua API.

'''


from flask import Flask,url_for,jsonify,request
from centroAssistenza import * 

app = Flask(__name__)

assistenza = ServiceCenter()


primoDispositivo = Smartphone(


       id= "D001",
       
       model= "Iphone 17 ProMax",
       customer_name = "Edoardo Trotterellini",
       purchase_year =  2025,
       status = Status.repairing,
       has_protective_case= True,
       storage_gb= 256
    
)


secondoDispositivo = Laptop (



       id= "D292",
     
       model= "MSI Donxer Final",
       customer_name = "Francesco Manganellini",
       purchase_year =  2022,
       status = Status.diagnosing,
       has_dedicated_gpu= False,
       screen_size_inches= 69

)


assistenza.add(primoDispositivo)
assistenza.add(secondoDispositivo)



@app.route('/')


def homePage():


    linksAll = {

        'list_devices': url_for('get_devices'),
        'sample_device': url_for('get_device', device_id="D001"),
        'sample_estimate': url_for('get_estimated_total_time',device_id="D001",factor= 1.5),

       }
    
    messaggioBenvenuto = "Welcome to Service Center API"

   
    return jsonify({
       
       'message' : messaggioBenvenuto,
       'links': linksAll
    })

 
@app.route('/devices', methods=["GET"])


def get_devices():

  return jsonify([d.info() for d in assistenza.list_all()])




@app.route('/devices/<device_id>', methods=["GET"])

def get_device(device_id):

    disp = assistenza.get(device_id)

    if disp is None:

        return jsonify({'ERRORE' : "Il dispositivo NON ESISTE"}), 404
    else:
        return jsonify(disp.info())



@app.route('/devices/<device_id>/estimate/<factor>', methods=["GET"])

def get_estimated_total_time(device_id,factor):

    disp = assistenza.get(device_id)

    if disp is None:

        return jsonify({'ERRORE' : "Dispositivo non esistente"}), 404 
    else:

        temp = disp.estimated_total_time()

        return jsonify( { 

            "id" : disp.id,
            "device_type": disp.device_type(),
            "factor": factor,
            "estimated_total_minutes": temp

            })

@app.route('/devices', methods=["POST"] )

def post_devices():

    data = request.get_json()


    datiRichiesti = {"type", "id", "model","customer_name", "purchase_year", "status"}


    if not data or not datiRichiesti.issubset(data):

        return jsonify({'ERRORE': "Ci sono dei DATI MANCANTI DA COMPILARE"}), 400
    
    if assistenza.get(data["id"]):

        return jsonify({"ERRORE" : "Il dispositivo risulta già essere PRESENTE"}) , 400 
    
    try:

        statusOggetto =  Status[data["status"].replace("Status.", "")]

    except KeyError:

        statusOggetto = Status.delivered 

    if data["type"] == "smartphone":


        disp = Smartphone (

            data["id"], 
            data["model"], 
            data["customer_name"], 
            data["purchase_year"],
            statusOggetto,
            data.get("has_protective_case", True), 
            data.get("storage_gb", 256)


        )  


    elif data["type"] == "laptop":


        disp = Laptop (

            data["id"], 
            data["model"], 
            data["customer_name"], 
            data["purchase_year"],
            statusOggetto, 
            data.get("has_dedicated_gpu", False) , 
            data.get("screen_size_inches",69)

        )

    else:


        return jsonify ({'ERRORE' : "ATTENZIONE ! Tipologia di dispositivo NON PRESENTE NEL SISTEMA !"}),400 
    

    assistenza.add(disp)
    return jsonify(disp.info()), 201



@app.route('/devices/<device_id>', methods=["PUT"] )

def put_device(device_id):

    data= request.get_json()
    dispEsistente = assistenza.get(device_id)


    if not dispEsistente:

        return jsonify({"ERRORE" : "Il dispositivo NON È PRESENTE NEL SISTEMA !"})

    try: 
        statusOggetto = Status[data["status"].replace("Status.",  "")] 

    except KeyError:

        statusOggetto = Status.delivered 
    
    if data["type"] == "smartphone":



        nuovoDisp = Smartphone (
            data["id"], 
            data["model"], 
            data["customer_name"], 
            data["purchase_year"],
            statusOggetto,
            data.get("has_protective_case", True), 
            data.get("storage_gb", 256)


        )  


    
    elif data["type"] == "laptop":


        nuovoDisp = Laptop (
    
            data["id"], 
            data["model"], 
            data["customer_name"], 
            data["purchase_year"],
            statusOggetto, 
            data.get("has_dedicated_gpu", False) , 
            data.get("screen_size_inches",69)

        )

    else:


        return jsonify ({'ERRORE' : "ATTENZIONE ! Tipologia di dispositivo NON PRESENTE NEL SISTEMA !"}),400 
    

    assistenza.update(device_id,nuovoDisp)
    return jsonify(nuovoDisp.info()), 200

@app.route('/devices/<device_id>/status', methods=["PATCH"])

def patch_status(device_id):
    
    disp = assistenza.get(device_id)
    data = request.get_json()

    if not disp:

        return jsonify({'ERRORE': "Il dispositivo NON È presente nel sistema !"}), 404
    
    if "status" not in data:

        return jsonify({'ERRORE': "Lo stato del dispositivo NON È presente nel sistema !"}), 404


    assistenza.patch_status(device_id, data["status"])

    return jsonify(disp.info())

@app.route('/devices/<device_id>', methods=["DELETE"])

def delete_device(device_id):

    if not assistenza.get(device_id):

        return jsonify({'ERRORE' : "Il dispositivo NON È presente nel sistema !"}), 404
    
    else:
        assistenza.delete(device_id)
        return jsonify({"ELIMINATO" : True, "ID dispositivo eliminato" : device_id}), 200
    





if __name__ == "__main__":

    app.run(debug=True)

