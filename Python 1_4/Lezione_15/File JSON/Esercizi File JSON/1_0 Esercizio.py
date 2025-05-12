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
print(f"Questa è la VERSIONE CORRENTE: {myConfig.get('version', '0.0')}")
print("-" * 50)


# ---------- 2. CREAZIONE DI UN NUOVO FILE JSON ----------
db: dict = {
    "JYSNP...": {"name": "Nicol", "surname": "Jayasuriya", "age": 20},
    "MBUNT...": {"name": "Nathan", "surname": "Mbuyamba", "age": 21},
    "BMHIL...": {"name": "Michael", "surname": "Baciarello", "age": 20}
}

with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "w") as file:
    json.dump(db, file, indent=4)

print("📤 File 'configNewJson.json' salvato con 3 utenti iniziali.")
print("-" * 50)


# ---------- 3. AGGIUNTA DI UNA CHIAVE AL FILE ESISTENTE ----------
with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "r") as file:
    jsonData = json.load(file)

jsonData["features"] = "Ciao"

with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "w") as file:
    json.dump(jsonData, file, indent=4)

print("🛠️ Aggiunta la chiave 'features' al file JSON.")
print("-" * 50)


# ---------- 4. LETTURA FINALE DEL FILE MODIFICATO ----------
with open("Python 1_4/Lezione_15/File JSON/Esercizi File JSON/configNewJson.json", "r") as file:
    contenuto_finale = json.load(file)

print("📂 CONTENUTO FINALE DI configNewJson.json:")
print(json.dumps(contenuto_finale, indent=4))
print("-" * 50)


# ---------- 5. CREAZIONE OGGETTI Example (da config.json) ----------
example_obj = Example(name=myConfig.get("name", "N/A"), version=myConfig.get("version", "0.0"))
print("🧱 Oggetto Example creato da config.json:")
print(example_obj)
print("-" * 50)


# ---------- 6. CONVERSIONE UTENTI SALVATI IN OGGETTI ----------
print("🧍‍♂️ OGGETTI Example CREATI DA configNewJson.json (dove possibile):")
for key, value in contenuto_finale.items():
    if isinstance(value, dict) and "name" in value and "surname" in value:
        obj = Example(name=value["name"], version=str(value.get("age", "N/A")))
        print(f"{key} → {obj}")
print("-" * 50)
