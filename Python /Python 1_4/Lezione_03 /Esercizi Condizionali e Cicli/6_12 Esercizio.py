'''
6-12. Extensions: We’re now working with examples that are complex enough that they can be extended in any number of ways.
 Use one of the example programs from this chapter, and extend it by adding new keys and values, changing the context of the program, 
 or improving the formatting of the output.

'''
# Creazione del glossario con nuovi termini di programmazione e significati
nuove_parole:dict[str, dict[str]] = {
    "Variabile": {
        "definizione": "Un contenitore per memorizzare dati che possono cambiare durante l'esecuzione del programma.",
        "esempio": "Esempio: x = 5, dove 'x' è una variabile che memorizza il valore 5."
    },
    "Lista": {
        "definizione": "Una collezione ordinata di elementi, che può contenere diversi tipi di dati e può essere modificata.",
        "esempio": "Esempio: my_list = [1, 2, 3, 4], dove 'my_list' è una lista di numeri."
    },
    "Dizionario": {
        "definizione": "Una struttura dati che memorizza coppie chiave-valore, permettendo un accesso rapido ai dati.",
        "esempio": "Esempio: my_dict = {'nome': 'Mario', 'età': 21}, dove 'nome' e 'età' sono chiavi del dizionario."
    },
    "Ciclo for": {
        "definizione": "Una struttura di controllo che consente di iterare su una sequenza di elementi.",
        "esempio": "Esempio: for i in range(5): print(i), itera sui numeri da 0 a 4."
    },
    "Funzione": {
        "definizione": "Un blocco di codice riutilizzabile che esegue un'operazione specifica e può restituire un valore.",
        "esempio": "Esempio: def somma(a, b): return a + b, una funzione che somma due numeri."
    },
    "Classe": {
        "definizione": "Una struttura che permette di definire oggetti con attributi e metodi.",
        "esempio": "Esempio: class Persona: def __init__(self, nome): self.nome = nome, una classe per creare oggetti Persona."
    },
    "Modulo": {
        "definizione": "Un file che contiene un insieme di funzioni e variabili che possono essere riutilizzati in altri programmi.",
        "esempio": "Esempio: import math, dove math è un modulo che fornisce funzioni matematiche."
    }
}

# Stampa dei termini con la loro definizione e un esempio
print("Glossario di Programmazione:\n")
for key, value in nuove_parole.items():
    print(f"{key}:")
    print(f"  Definizione: {value['definizione']}")
    print(f"  Esempio: {value['esempio']}\n")
