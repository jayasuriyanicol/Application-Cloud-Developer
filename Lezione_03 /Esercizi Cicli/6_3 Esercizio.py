'''
6-3. Glossary: A Python dictionary can be used to model an actual dictionary. However, to avoid confusion, let’s call it a glossary.
• Think of five programming words you’ve learned about in the previous chapters. 
Use these words as the keys in your glossary, and store their meanings as values.
• Print each word and its meaning as neatly formatted output. 
You might print the word followed by a colon and then its meaning, or print the word on one line and then print its meaning indented on a second line. 
Use the newline character (\n) to insert a blank line between each word-meaning pair in your output.

'''

# Creazione del glossario con termini di programmazione e significati come detto dal problema
nuove_parole = {
    "Variabile": "Un contenitore per memorizzare dati che possono cambiare durante l'esecuzione del programma.",
    "Lista": "Una collezione ordinata di elementi, che può contenere diversi tipi di dati e può essere modificata.",
    "Dizionario": "Una struttura dati che memorizza coppie chiave-valore, permettendo un accesso rapido ai dati.",
    "Ciclo for": "Una struttura di controllo che consente di iterare su una sequenza di elementi.",
    "Funzione": "Un blocco di codice riutilizzabile che esegue un'operazione specifica e può restituire un valore."
}

# Stampa dei termini con la loro definizione, formattati con una riga vuota tra di loro
for key, value in nuove_parole.items():
    print(f"{key}:\n  {value}\n")
