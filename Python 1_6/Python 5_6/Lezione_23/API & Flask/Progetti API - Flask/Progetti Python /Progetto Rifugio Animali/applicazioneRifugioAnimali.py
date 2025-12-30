'''
uno di tipo Cat, che saranno aggiunti al rifugio prima di avviare l’app Flask.
Applicazione Flask

Crea un’applicazione Flask che esponga alcune route GET per consultare i dati del rifugio e alcune route POST per modificare lo stato (ad esempio aggiungere animali e registrare adozioni).
Le funzioni delle route devono restituire oggetti JSON (non stringhe semplici).
Route GET richieste
1. GET /

Restituisce un JSON con:

    una breve descrizione del servizio, ad esempio:
     
    { "message": "Welcome to Animal Shelter API" }

    alcuni link testuali che indicano le altre route disponibili, ad esempio:

        /animals

        /animals/d1

        /animals/d1/food

        /animals/d1/adoption

    Questi link devono essere generati dinamicamente con url_for() e poi inseriti nel JSON, ad esempio:
     
    { "message": "...", "links": { "list_animals": url_for("list_animals"), "sample_dog": url_for("get_animal", animal_id="d1"), ... } }

2. GET /animals

Restituisce un JSON con la lista degli animali presenti nel rifugio.

Ogni elemento della lista può essere:

    una stringa descrittiva, ad esempio
    "d1 - Rex (dog) - 2 years - 18.5kg",

    oppure

    un dizionario con i campi principali dell’animale (quelli restituiti da info()).

La scelta è libera, ma deve essere coerente in tutto il programma (se scegli la rappresentazione come dizionario, usala ovunque per le liste).
3. GET /animals/<animal_id>

Restituisce un JSON con un solo elemento che rappresenta i dettagli dell’animale con l’ID specificato.

Ad esempio:
{ "id": "d1", "name": "Rex", "species": "dog", "age_years": 2, "weight_kg": 18.5, "breed": "border collie", "is_trained": true }

Se l’animale non esiste, la route dovrebbe restituire un JSON di errore (es. {"error": "Animal not found"}) con status code appropriato (ad esempio 404).
4. GET /animals/<animal_id>/food

Restituisce un JSON con le informazioni sul cibo giornaliero stimato per l’animale specificato.

L’output può essere, ad esempio:
{ "id": "d1", "daily_food_grams": 350 }

oppure una struttura più ricca a tua scelta, purché sia JSON.

Anche qui, se l’animale non esiste, va gestito l’errore.
5. GET /animals/<animal_id>/adoption

Restituisce lo stato di adozione dell’animale specificato.

Esempi di output:

Animale non adottato:
{ "id": "d1", "adopted": false }

Animale adottato:
{ "id": "d1", "adopted": true, "adopter_name": "Mario Rossi" }
Route POST richieste

Le seguenti route servono per modificare lo stato del rifugio (aggiungere animali, registrare adozioni).
In tutte le route POST il body della richiesta deve essere in formato JSON e deve essere letto tramite request.get_json().
1. POST /animals/add

Permette di aggiungere un nuovo animale al rifugio.

Il body JSON deve contenere le informazioni necessarie per creare l’animale e un campo che specifica il tipo, ad esempio "dog" o "cat".

Esempio per un cane:
{ "type": "dog", "id": "d3", "name": "Rex", "age_years": 2, "weight_kg": 18.5, "breed": "border collie", "is_trained": true }

Esempio per un gatto:
{ "type": "cat", "id": "c5", "name": "Micia", "age_years": 3, "weight_kg": 4.2, "indoor_only": true, "favorite_toy": "ball" }

La funzione della route deve:

    leggere il JSON dalla richiesta;

    verificare che il campo "type" sia presente e valido ("dog" o "cat");

    controllare che i campi richiesti (id, name, ecc.) siano presenti;

    creare l’istanza della sottoclasse corretta (Dog o Cat);

    aggiungere l’animale al Shelter con shelter.add(...);

    restituire un JSON di conferma, ad esempio:
     
    { "status": "ok", "added": { "id": "d3", "species": "dog" } }

In caso di errore (id già esistente, campi mancanti, tipo non riconosciuto) deve restituire un JSON di errore con uno status code adeguato (es. 400 Bad Request).
2. POST /animals/<animal_id>/adopt

Registra l’adozione di un animale.

Il body JSON deve contenere almeno il nome dell’adottante, ad esempio:
{ "adopter_name": "Mario Rossi" }

La funzione della route deve:

    verificare che l’animale con id animal_id esista nel rifugio;

    leggere il nome dell’adottante dal JSON;

    aggiornare la struttura di adozioni del Shelter (ad esempio con shelter.set_adopted(animal_id, adopter_name));

    restituire un JSON di conferma, ad esempio:
     
    { "id": "d1", "adopted": true, "adopter_name": "Mario Rossi" }

Se l’animale non esiste, oppure è già adottato (se vuoi gestire anche questo caso), la route deve restituire un JSON di errore e uno status code appropriato (es. 404 o 400).
Come strutturare l’esercizio

Crea un file main.py contenente:

    le classi Animal, Dog, Cat, Shelter;

    un’istanza di Shelter popolata con almeno un cane e un gatto di esempio;

    l’applicazione Flask con tutte le route GET e POST richieste;

    il codice per avviare l’app (solo se vuoi usare app.run() dal file Python).

Il formato delle risposte deve essere coerente: tutte le route devono restituire oggetti JSON.
Esecuzione dell’applicazione

Il programma può essere eseguito in due modi:

    da riga di comando:
     
    flask --app main run --debug

    oppure direttamente nel file Python, con:
    app.run(debug=True, host="127.0.0.1", port=5000)



'''

from flask import Flask,url_for,jsonify,request
from rifugioAnimali import *

#Riporto i valori che mi serviranno per generare le informazioni sull'applicazione del rifugio, importando la classe
primoAnimale : Dog = Dog('d1','Cris', 4, 50.6, 'Pastore Tedesco', True)
secondoAnimale : Cat = Cat('c1','Atta', 1, 1.34, False, 'Peluche')

rifugio = Shelter()

rifugio.add(primoAnimale)
rifugio.add(secondoAnimale)



rifugioAnimali = Flask(__name__)



@rifugioAnimali.route('/')


def homePage():

    linksAll = {
        'all_animals': url_for('get_animals'),
        'data_animal': url_for('get_animal', animal_id="d1"),
        'sample_food': url_for('get_animal_food', animal_id="d1"),
        'sample_adoption': url_for('get_animal_adoption', animal_id="d1")
    }

    
    messaggioBenvenuto = 'Welcome to Animal Shelter API'
   
   
    return jsonify({

        'message' : messaggioBenvenuto,
        'links' : linksAll
    })
        


@rifugioAnimali.route('/animals') 

def get_animals():

    data = []

    for el in rifugio.list_all():

        data.append(el.info()) 
    return jsonify(data)



@rifugioAnimali.route('/animals/<animal_id>')

def get_animal(animal_id):

    animal = rifugio.get(animal_id)
    if animal is None:

        return jsonify({"ERRORE": "Animale NON TROVATO"}),404
    else:
        
        return jsonify(animal.info())


@rifugioAnimali.route('/animals/<animal_id>/food')


def get_animal_food(animal_id):
    
    animal = rifugio.get(animal_id)

    if animal is None:

        return jsonify({"ERRORE": "Animale NON TROVATO"}),404
    else:

        num = animal.daily_food_grams()

        return{

            "id" : animal_id,
            "daily_food_grams": num

            }
    

@rifugioAnimali.route('/animals/<animal_id>/adoption')
def get_animal_adoption(animal_id):
    
    animal = rifugio.get(animal_id)

    if animal is None:


        return jsonify({"ERRORE": "Animale NON TROVATO"}),404
    else:
        
        if animal_id in rifugio.adoptions:

            p = rifugio.adoptions.get(animal_id)

            return {

                "id": animal_id,
                "adopted" : True,
                "adopted_name": p
               }
        else:

            return {

                "id" : animal_id,
                "adopted": False

                }
        
        

@rifugioAnimali.route('/animals/add', methods=["POST"])
def post_animal() -> dict:

    data = request.get_json()
    tipo = data.get("type", "").lower() 

    if not data or 'id' not in data or 'type' not in data:
        return jsonify({'ERRORE': 'Animale ID O TIPO SBAGLIATO'}), 400
    
    
    if rifugio.get(data["id"]) is not None:
        return jsonify({'ERRORE': 'ID Animale GIÀ ESISTENTE'}), 400

   
    
    if tipo == "dog":
        nuovoAnimale = Dog(
            data["id"], 
            data["name"], 
            data.get("age_years"),
            data.get("weight_kg"),
            data.get("breed"), 
            data.get("is_trained")
        )

    elif tipo == "cat":
        nuovoAnimale = Cat(
            data["id"], 
            data["name"],
            data.get("age_years"),
            data.get("weight_kg"), 
            data.get("indoor_only"), 
            data.get("favorite_toy")
        )
    else:
        return jsonify({'ERRORE': f'La tipologia -> {tipo} NON ESISTE nel sistema !'}), 400
            

    rifugio.add(nuovoAnimale)

    return jsonify({
        "linksAll": {
            "endpoint": url_for("get_animal", animal_id=nuovoAnimale.id),
            "method": "GET"
        },
        "animal_id": nuovoAnimale.id 
    }), 201



@rifugioAnimali.route('/animals/<animal_id>/adopt', methods=["POST"])
def adopt_animal(animal_id):

    data = request.get_json()

    if not data or "adopter_name" not in data:
        return jsonify({"ERRORE": "Il campo del PADRONE mancante !"}), 400

    adopter = data["adopter_name"]

  
    animal = rifugio.get(animal_id)
    if animal is None:
        return jsonify({"ERRORE": "Animale NON TROVATO"}), 404

   
    if animal_id in rifugio.adoptions:
        return jsonify({"ERRORE": "Animale già ADOTTATO !"}), 400


    rifugio.set_adopted(animal_id, adopter)

    return jsonify({
        "id": animal_id,
        "adopted": True,
        "adopter_name": adopter
    }), 200




if __name__ ==  "__main__":

    rifugioAnimali.run(debug= True)