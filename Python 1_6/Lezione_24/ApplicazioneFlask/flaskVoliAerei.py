from Dati import dati 
from flask import Flask,jsonify,request


voli = Flask (__name__)

#Pagina iniziale che mostra il messaggio di benvenuto
@voli.route('/')
def AboutVoli() -> str:

    return "<h3>Benvenuto sul sito di VoliAerei !</h3>"


@voli.route('/voli',methods =['GET'])

def get_voli():

    return jsonify({'Totali Voli': len(dati)})


@voli.route('/nazioni',methods=['GET'] )
def get_nazioni():

        return jsonify({'Nazioni': dati['Nazione']})

@voli.route('/nazioni', methods=['POST'])

def add_nazione():

     nuovo = request.get_json()

     if not nuovo or 'nome' not in nuovo:

            return{'errore' : 'Output non valido ai fini di risposta, prego inserire CORRETTAMENTE I DATI '},400
     
     nuovoId = len(dati['Nazione']) + 1

     nuovaNazione = {


          'id': nuovoId, 
          'nome': nuovo['nome'],
         }
     
     dati["Nazione"][nuovoId]  = nuovaNazione 

     return jsonify(nuovaNazione),201




#Gestione di ErrorHandler personalizzato 
@voli.errorhandler(400)

def requiredName(error):
        return jsonify({
              
              'ERRORE': 'ATTENZIONE ! il campo del testo va compilato',
              'CODICE ERRORE': 400
        }),400

@voli.errorhandler(404)
def notFound(error):

        return jsonify ({
              
              'NOT FOUND' : 'VALORE NON TROVATO',
              'CODICE ERRORE' : 404
              

        }),404













 