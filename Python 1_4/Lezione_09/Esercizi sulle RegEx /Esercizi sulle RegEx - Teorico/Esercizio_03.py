'''
3. Email semplici

Obiettivo: Definire pattern per email.

    Esercizio 3.1: Scrivi una RegEx che riconosca email del tipo nome@dominio.com.
    Esercizio 3.2: Estendi la RegEx per accettare anche domini con più estensioni, es. nome@dominio.co.uk.
'''


'''
Esercizio 3.1: Scrivi una RegEx che riconosca email del tipo nome@dominio.com.

Definiamo: \S+@\S+, OPPURE: ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$

'''


'''
Esercizio 3.2: Estendi la RegEx per accettare anche domini con più estensioni, es. nome@dominio.co.uk.


Definiamo: \S+@\S+\S+, OPPURE : ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}(?:\.[a-zA-Z]{2,})*$

'''


