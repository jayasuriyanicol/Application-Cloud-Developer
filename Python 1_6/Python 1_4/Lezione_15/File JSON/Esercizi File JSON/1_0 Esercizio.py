'''
CREAZIONE E MANIPOLAZIONE DI UN FILE JSON

Attraverso questo esercizio andremo a creare, leggere e modificare un file JSON utilizzando Python.
Partiremo dalla creazione del file da zero, per poi gestirne i contenuti tramite operazioni di lettura ("r")
e scrittura ("w"), convertendo i dati tra il formato Python (dizionari, oggetti) e JSON.

Per riassumere il tutto, possiamo vedere qual'è lo scopo di questo ESERCIZIO BASE:

A. Legge un file config.json contenente configurazione di base.

B. Salva un nuovo dizionario (db) nel file configNewJson.json.

C. Aggiunge/modifica una chiave (features) nel file appena creato.

D. Legge e stampa il contenuto finale del file JSON modificato.

E. Trasforma ogni voce del dizionario salvato in oggetti della classe Example (quando possibile).

F. Stampa tutto in output in modo chiaro e differenziato.

'''

#Iniziamo con l'importare JSON per poter manipolare con il file: creazione,scrittura e lettura
import json


#Creiamo una classe EXAMPLE, dove inseriamo il nome e la versione con lo scopo di dimostare la trasformazione dei dati JSON da dict in oggetti PY
class Example:
    def __init__(self, name, version):
        self.name = name
        self.version = version
     
    def __str__(self):
        return f"Example(name='{self.name}', version='{self.version}')"



#Procediamo con la LETTURA di un file JSON in maniera BASICA, ovvero come esempio
with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/config.json", "r") as file:
    myConfig: dict = json.load(file)

print("\n\nCONFIGURAZIONE BASE sul file 'config.json'\n\n")
print(json.dumps(myConfig, indent=4))
print(f"\n\nQuesta è la VERSIONE CORRENTE: {myConfig.get('version', '0.0')}")
print("-" * 99 + "-\n")


#Successivamente creiamo un nuovo file JSON "configNewJson.json", dove inseriamo nel "db" un dict con 3 CF con relativo messaggio di SUCCESSO
db: dict = {
    "JYSNP...": {"name": "Nicol", "surname": "Jayasuriya", "age": 20},
    "MBUNT...": {"name": "Nathan", "surname": "Mbuyamba", "age": 21},
    "BMHIL...": {"name": "Michael", "surname": "Baciarello", "age": 20}
}

with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "w") as file:
    json.dump(db, file, indent=4)

print("\nSUCCESSO ! Il File 'configNewJson.json' è stato SALVATO con 3 UTENTI REGISTRATI.")
print("-" * 100)



#Come terzo punto, andiamo ad aggiungere una chiave "features" al file JSON esistente
with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "r") as file:
    jsonData = json.load(file)

jsonData["features"] = "0.0.1 Grapich Feature"

with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "w") as file:
    json.dump(jsonData, file, indent=4)

print("\nATTENZIONE ! è stata AGGIUNTA LA CHIAVE 'FEATURES' al file JSON !\n")
print("-" * 100)


#Il quarto punto, procede con la LETTURA DEL FILE che abbiamo modificato precedentemente MOSTRANDO il contenuto
with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "r") as file:
    contenutoFinale = json.load(file)

print("\n\n|CONTENUTO FINALE DI configNewJson.json|\n\n")
print(json.dumps(contenutoFinale, indent=4))
print("-" * 100)



#Per il quinto punto CREIAMO gli OGGETTI EXAMPLE dal file "config.json" 
esempiOggetto = Example(name=myConfig.get("name", "N/A"), version=myConfig.get("version", "0.0"))
print("\nSUCCESSO ! L'oggetto EXAMPLE è stato CREATO dal file 'config.json' :\n")
print(esempiOggetto)
print("-" * 100)



#Infine, andiamo a convertire gli UTENTI che sono stati SALVATI come OGGETTI
print("\n\n|ELENCO degli OGGETTI Example CREATI DA 'configNewJson.json'|\n\n")

#Iteriamo sul dict per la stampa degli oggetti EXAMPLE
for chiave, valore in contenutoFinale.items():
    if isinstance(valore, dict) and "name" in valore and "surname" in valore:
        oggetto = Example(name=valore["name"], version=str(valore.get("age", "N/A")))
        print(f"{chiave} → {oggetto}")
print("-" * 100)
