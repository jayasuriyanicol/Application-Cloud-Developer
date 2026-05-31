'''
Applicazione Flask

Crea un’applicazione Flask che esponga alcune route GET per consultare i dati del parco. Le funzioni delle route devono restituire oggetti json. 

Route richieste

GET /

Restituisce un json con:

    una breve descrizione del servizio (es. "Welcome to Park API"),
    alcuni link testuali che indicano le altre route disponibili (es. "/rides", "/rides/rc1", "/rides/rc1/wait/4.0").
    Devi generare i link dinamicamente con url_for() e poi inserirli nel json.

GET /rides

Restituisce un json di attrazioni presenti nel parco.
Ogni elemento del json può essere:

    una stringa descrittiva (es. "rc1 - Vortex (roller_coaster) - min 140cm"), oppure
    un dizionario con i campi principali dell’attrazione.

La scelta è libera, ma deve essere coerente in tutto il programma.

GET /rides/<ride_id>

Restituisce un json con un solo elemento che rappresenta i dettagli dell’attrazione con l’ID specificato.

GET /rides/<ride_id>/wait/crowd

Restituisce un json con le informazioni sull’attesa stimata per l’attrazione specificata.

    Il parametro crowd è facoltativo e indica un fattore di affollamento (di default 1.0).
    L’output può essere, ad esempio, una json contenente una stringa "Attesa: 60 minuti" oppure un dizionario {"wait_min": 60}.

Cosa strutturare l'esercizio

    Un file main.py contenente:
        le classi Ride, RollerCoaster, Carousel, Park;
        un parco popolato con almeno due giostre (una per tipo);
        l’applicazione Flask con tutte le route richieste;
    Il formato delle risposte deve essere coerente: tutte le route devono restituire oggetti json.

Esecuzione dell’applicazione

Il programma può essere eseguito in due modi:

    da riga di comando:

flask --app main run --debug

    oppure direttamente nel file Python:

app.run(debug=True, host="127.0.0.1", port=5000)


'''

from flask  import Flask,url_for,jsonify
from parcoDivertimenti import *

#Andiamo con la creazione dei dati che ci serviranno, importandoli 
r1 = RollerCoaster("SH001", "Shock", 165, 3)
r2 = RollerCoaster("CC005", "Inverter", 153, 1)
c1 = Carousel("AG324", "CarbonRider", 168, ["Elephant", "Tiger", "Monkey"])

park = Park()
park.add(r1)
park.add(r2)
park.add(c1)


print(park.get("SH001").info())
print(park.get('CC005').info())
print(park.get('AG324').info())
print(park.get("AG324").wait_time(crowd_factor=1.5))



app = Flask(__name__)

#Creiamo la HOMEPAGE, messaggio benvenuto e con i vari link necessari
@app.get("/")
def home() :
    links = {
        "all_rides": url_for("get_rides"),
        "ride_example": url_for("get_ride", ride_id="rc1"),
        "wait_example": url_for("get_wait", ride_id="rc1", crowd=2.0)
    }

    return jsonify({
        "message": "Welcome to Park API",
        "available_routes": links
    })

#Mostriamo tutte le attrazioni presenti nel parco
@app.get("/rides")

def get_rides():

    data = []
    for ride in park.list_all():
        data.append(ride.info())
    return jsonify(data)


#Mostriamo le carratterische dell'attrazione identificata con il suo ID univoco con la gestione dell'errore
@app.get("/rides/<ride_id>")
def get_ride(ride_id):
    ride = park.get(ride_id)
    if ride is None:
        return jsonify({"error": "Ride not found"}), 404
    return jsonify(ride.info())

#Proseguiamo con il mostrare le caratteristiche inerenti alla coda presente su ogni attrazione 
@app.get("/rides/<ride_id>/wait/")
@app.get("/rides/<ride_id>/wait/<crowd>")
def get_wait(ride_id, crowd=None):
    ride = park.get(ride_id)
    if ride is None:
        return jsonify({"error": "Ride not found"}), 404

    try:
        crowd_value = float(crowd) if crowd is not None else 1.0
    except ValueError:
        return jsonify({"error": "crowd must be a number"}), 400

    wait = ride.wait_time(crowd_value)

    return jsonify({
        "ride_id": ride_id,
        "crowd_factor": crowd_value,
        "wait_minutes": wait
    })