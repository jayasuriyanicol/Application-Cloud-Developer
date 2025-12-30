"""
CREAZIONE E MANIPOLAZIONE DI UN FILE JSON

In questo esercizio andremo a vedere come lavorare con file JSON utilizzando Python. Vedremo come leggere e scrivere file JSON,
modificarli, salvarli su disco e come trasformare i dati letti in oggetti Python per una gestione più strutturata.

Quindi gli obiettivi sono: 

A. Capire come creare un file JSON da zero con Python
B. Salvare strutture dati Python (dizionari) in formato JSON
C. Leggere contenuti da file JSON esistenti
D. Modificare e riscrivere dati nei file JSON
E. Trasformare dati JSON in oggetti Python (OOP)


Utilizzeremo all'interno della CARTELLA 'Spiegazione File JSON ' quest'ultimi FILE per la manipolazione:
- base.json → file di configurazione di partenza
- modificaBase.json → file JSON creato e modificato dal programma

"""
#Importiamo la JSON per procedere con la manipolazione dei file
import json



#Andiamo a creare una classe Example dove mostriamo un primo esempio per la trasformazione dei dati JSON da dict in oggetti PY
class Example:
    def __init__(self, name, version):
        self.name = name
        self.version = version

    def __str__(self):
        return f"Example(name='{self.name}', version='{self.version}')"
    


#Successivamente andiamo all'abilitazione dell LETTURA DEL file 'base.json' mostrando il contenuto ben indentato
with open("Python 1_4/Lezione_15/File JSON/Spiegazione File JSON/base.json", "r") as file:
    myConfig: dict = json.load(file)

print("\n\n|CONTENUTO di 'config.json'|\n\n")
print(json.dumps(myConfig, indent=4)) 

#Qui procediamo con la visualizzazione della versione
print("\nVersione:", myConfig.get("version", "0.0"))
print("-" * 100)




#Poi creiamo un nuovo file JSON 'modificaBase' dove andiamo a inserire un dict come simulazione di CF di un 'DB'
db: dict = {
    "JYSNP...": {"name": "Nicol", "surname": "Jayasuriya", "age": 20},
    "MRSWE...": {"name": "Mario", "surname": "Rossi", "age": 29},
    "LBFRD...": {"name": "Luigi", "surname": "Bianchi", "age": 32}
}


#Apriamo il nostro file e andiamo a popolarlo da zero con il nostro dict che imita un 'db' con relativo messaggio di successo
with open("Python 1_4/Lezione_15/File JSON/Spiegazione File JSON/modificaBase.json", "w") as file:
    json.dump(db, file, indent=4)

print("\nSUCCESSO ! il file 'modificaBase.json' è stato POPOLATO CORRETTAMENTE !")
print("-" * 100)



#Come penultima cosa procediamo con il modifcare il file già esistente aprendo il file 'modificaBase.json' aggiungendo una chiave features con dei valori 
with open("Python 1_4/Lezione_15/File JSON/Spiegazione File JSON/modificaBase.json", "r") as file:
    jsonData: dict = json.load(file)

#Aggiungiamo la chiave in questione con dei valori per l'imiotazione di 'LOGIN' e 'REGISTRAZIONE'
jsonData["features"] = ["LOGIN", "REGISTRATI"]

#Chiudiamo correttamente il file per evitare errori "ExceptionValues" e mostriamo un messaggio di successo !
with open("Python 1_4/Lezione_15/File JSON/Spiegazione File JSON/modificaBase.json", "w") as file:
    json.dump(jsonData, file, indent=4)

print("\nSUCCESSO ! la chiave 'features' è STATA INSERITA CORRETTAMENTE !")
print("-" * 100)




#Infine, procediamo con la creazione di un oggetto da JSON, riprendendo la classe EXAMPLE creata all'inizio con dati non disponibili
primoEsempio = Example(name=myConfig.get("name", "Dato non disponibile"), version=myConfig.get("version", "Dato non dispobile"))

print("\nSUCCESSO ! l'oggetto è stato creato dal file 'base.json' CORRETTAMENTE !\n")

print(primoEsempio)
