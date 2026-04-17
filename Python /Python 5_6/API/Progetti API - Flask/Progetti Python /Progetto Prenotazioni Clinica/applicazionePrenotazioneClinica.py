'''
Applicazione Flask

Crea un’applicazione Flask che espone diverse route per gestire le prenotazioni presenti nel sistema. Le funzioni delle route devono restituire oggetti JSON.

Dovrai usare tutti i metodi HTTP principali:

    GET (lettura)
    POST (creazione)
    PUT (sostituzione totale)
    PATCH (aggiornamento parziale)
    DELETE (cancellazione)

Route GET
GET /

Restituisce un JSON con:

    una breve descrizione del servizio, ad esempio: "Clinic Booking Hub API";
    link testuali che indicano le altre route disponibili, generati dinamicamente con url_for(), ad esempio:
        /bookings
        /bookings/BK-101
        /bookings/BK-101/wait/1.0

Il JSON potrebbe avere una struttura tipo:

{
  "message": "Clinic Booking Hub API",
  "links": {
    "bookings_list": "/bookings",
    "booking_sample": "/bookings/BK-101",
    "estimate_sample": "/bookings/BK-101/wait/1.0"
  }
}

GET /bookings

Restituisce un JSON con l'elenco di tutte le prenotazioni presenti nel sistema.

Ogni elemento può essere:

    una stringa descrittiva, ad esempio: "BK-101 - visit - Mario Rossi (status: scheduled)"
    oppure un dizionario con i campi principali (quelli restituiti da info()).

La scelta è libera, ma deve essere coerente in tutto il programma.
GET /bookings/<booking_id>

Restituisce un JSON con i dettagli della prenotazione specificata.

Se la prenotazione non è presente nel sistema, restituire un JSON di errore (es. {"error": "booking not found"}) con status code 404.
GET /bookings/<booking_id>/wait/<factor>

Restituisce un JSON con il tempo di attesa stimato prima dell’appuntamento, utilizzando estimated_wait(factor: float).

Esempio di output:

{
  "booking_id": "BK-101",
  "booking_type": "visit",
  "factor": 1.0,
  "estimated_wait_minutes": 55
}

Se la prenotazione non esiste, si ottiene un errore 404.

Il parametro factor può essere letto dall’URL e convertito in float (con un default di 1.0 se vuoi renderlo opzionale).
Route POST
POST /bookings

Permette di aggiungere una nuova prenotazione al sistema.

Il body della richiesta deve essere JSON, letto con request.get_json().

Deve contenere almeno:

    type: "visit" o "exam"
    booking_id, patient_name, doctor, department, date, time, status
    più i campi specifici del tipo:
        per visit: visit_reason, first_time
        per exam: exam_type, requires_fasting

Esempio di JSON per un esame diagnostico:

{
  "type": "exam",
  "booking_id": "BK-3e67",
  "patient_name": "Giulia Verdi",
  "doctor": "Dr. Neri",
  "department": "Radiologia",
  "date": "2026-02-10",
  "time": "09:15",
  "status": "scheduled",
  "exam_type": "RMN",
  "requires_fasting": true
}

La funzione della route deve:

    validare il JSON (campi obbligatori, tipo corretto),
    creare l’istanza corretta (MedicalVisit o DiagnosticExam),
    aggiungerla al centro con clinic_hub.add(booking),
    restituire un JSON di conferma (es. con info()) e status code 201,

oppure un JSON di errore con status code 400 in caso di problemi (es. campi mancanti, tipo non riconosciuto, formati errati).
Route PUT
PUT /bookings/<booking_id>

Sostituisce completamente le informazioni di una prenotazione esistente con quelle fornite nel body JSON (stesso formato del POST /bookings).

Comportamento tipico:

    Se la prenotazione esiste → viene rimpiazzata (aggiornata completamente).
    Se non esiste → puoi scegliere se:
        creare una nuova prenotazione con quel booking_id, oppure
        restituire un errore 404.

Route PATCH
PATCH /bookings/<booking_id>/status

Aggiorna solo lo stato (status) della prenotazione specificata.

Body JSON di esempio:

{
  "status": "checked_in"
}

La funzione deve:

    verificare che la prenotazione esista,
    leggere il nuovo stato dal JSON,
    chiamare clinic_hub.patch_status(booking_id, new_status),
    restituire la prenotazione aggiornata (via info()) o un messaggio di conferma.

In caso di prenotazione inesistente → errore 404.
Route DELETE
DELETE /bookings/<booking_id>

Rimuove una prenotazione dal sistema.

Comportamento:

    Se la prenotazione esiste → viene eliminata e si restituisce un JSON di conferma (es. {"deleted": true, "booking_id": "BK-34567"}).
    Se non esiste → restituire un JSON di errore con status code 404.

'''

from flask import Flask, jsonify, request, url_for
from prenotazioneClinica import *


app = Flask(__name__)

hub = ClinicHub()

def create_booking_from_json(data: dict, booking_id_override: str = None) -> Union[Booking, str]:
    """
    ? Nella seguente funzione helper per convertire un JSON in un oggetto Booking (Visit o Exam).
    ? Restituisce l'oggetto oppure una stringa di errore.
    """
    required_base = ["type", "patient_name", "doctor", "department", "date", "time"]
    
    #Usiamo l'ID passato come override (utile per le PUT) o quello nel JSON
    b_id = booking_id_override if booking_id_override else data.get("booking_id")
    
    if not b_id:

        return "Missing booking_id"
    
    for field in required_base:

        if field not in data:

            return f"Missing field: {field}"

    b_type = data["type"]
    status = data.get("status", "scheduled")


    if b_type == "visit":
        if "visit_reason" not in data or "first_time" not in data:
            return "Missing specific fields for visit (visit_reason, first_time)"
        
        return MedicalVisit(
            booking_id=b_id,
            patient_name=data["patient_name"],
            doctor=data["doctor"],
            department=data["department"],
            date=data["date"],
            time=data["time"],
            visit_reason=data["visit_reason"],
            first_time=data["first_time"],
            status=status
        )

    elif b_type == "exam":

        if "exam_type" not in data or "requires_fasting" not in data:
            return "Missing specific fields for exam (exam_type, requires_fasting)"
        
        return DiagnosticExam(
            booking_id=b_id,
            patient_name=data["patient_name"],
            doctor=data["doctor"],
            department=data["department"],
            date=data["date"],
            time=data["time"],
            exam_type=data["exam_type"],
            requires_fasting=data["requires_fasting"],
            status=status
        )
    
    return f"Unknown booking type: {b_type}"


def init_data():
    """Popoliamo il sistema con dati di prova all'avvio."""

    v1 = MedicalVisit("BK-101", "Mario Rossi", "Dr. Bianchi", "Cardiologia", "2026-02-10", "10:00", "Controllo", False)
    e1 = DiagnosticExam("BK-202", "Anna Verdi", "Dr. Neri", "Radiologia", "2026-02-11", "11:30", "TAC", True)
    
    hub.add(v1)
    hub.add(e1)

#Inizializziamo i campi popolati
init_data()



@app.route("/", methods=["GET"])
def index():
    return jsonify({
        "message": "Clinic Booking Hub API",
        "links": {
            "bookings_list": url_for("get_bookings", _external=True),
            "booking_sample": url_for("get_booking_detail", booking_id="BK-101", _external=True),
            "estimate_sample": url_for("get_booking_wait", booking_id="BK-101", factor=1.2, _external=True)
        }
    })


@app.route("/bookings", methods=["GET"])
def get_bookings():
    return jsonify(hub.list_all())


@app.route("/bookings/<booking_id>", methods=["GET"])
def get_booking_detail(booking_id):
    booking = hub.get(booking_id)
    
    if not booking:
        return jsonify({"error": "Booking not found"}), 404
    
    return jsonify(booking.info())


@app.route("/bookings/<booking_id>/wait/<factor>", methods=["GET"])

def get_booking_wait(booking_id, factor):
    booking = hub.get(booking_id)
    
    if not booking:
        return jsonify({"error": "Booking not found"}), 404
    
    try:
        f_val = float(factor)

    except ValueError:

        return jsonify({"error": "Factor must be a number"}), 400

    wait_time = booking.estimated_wait(f_val)
    
    return jsonify({
        "booking_id": booking.booking_id,
        "booking_type": booking.booking_type(),
        "factor": f_val,
        "estimated_wait_minutes": wait_time
    })




@app.route("/bookings", methods=["POST"])
def create_booking():

    data = request.get_json()
    
    if not data:
        return jsonify({"error": "Invalid JSON body"}), 400

    new_booking = create_booking_from_json(data)
    
    #Gestisco l'errore di inizializzazione
    if isinstance(new_booking, str):
        return jsonify({"error": new_booking}), 400

    success = hub.add(new_booking)
    
    if not success:
        return jsonify({"error": f"Booking ID {new_booking.booking_id} already exists"}), 400

    return jsonify(new_booking.info()), 201




@app.route("/bookings/<booking_id>", methods=["PUT"])
def update_booking(booking_id):
    data = request.get_json()
    
    if not data:
        return jsonify({"error": "Invalid JSON body"}), 400

    #Qui, vado con la creazione oggetto forzando l'ID dell'URL
    updated_booking = create_booking_from_json(data, booking_id_override=booking_id)

    if isinstance(updated_booking, str):
        return jsonify({"error": updated_booking}), 400

    exists = hub.get(booking_id) is not None
    
    hub.update(booking_id, updated_booking)
    
    message = "Booking updated" if exists else "Booking created via PUT"
    return jsonify({"message": message, "booking": updated_booking.info()}), 200




@app.route("/bookings/<booking_id>/status", methods=["PATCH"])

def patch_booking_status(booking_id):
    booking = hub.get(booking_id)
    
    if not booking:
        return jsonify({"error": "Booking not found"}), 404

    data = request.get_json()
    
    if not data or "status" not in data:
        return jsonify({"error": "Missing 'status' field in JSON"}), 400

    new_status = data["status"]
    hub.patch_status(booking_id, new_status)

    return jsonify({
        "message": "Status updated", 
        "booking_id": booking_id, 
        "new_status": new_status,
        "full_info": booking.info()
    })




@app.route("/bookings/<booking_id>", methods=["DELETE"])

def delete_booking(booking_id):
    success = hub.delete(booking_id)
    
    if success:
        return jsonify({"deleted": True, "booking_id": booking_id}), 200
    else:
        return jsonify({"error": "Booking not found"}), 404


if __name__ == "__main__":
    app.run(debug=True)


