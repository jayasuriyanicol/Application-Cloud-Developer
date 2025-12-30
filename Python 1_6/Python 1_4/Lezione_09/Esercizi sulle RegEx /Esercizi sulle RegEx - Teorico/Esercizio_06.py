'''
6. Codici personalizzati

Obiettivo: Unire lettere, numeri e caratteri speciali.

    Esercizio 6.1: Scrivi una RegEx per identificare un codice prodotto nel formato PROD-1234-XY.
    Esercizio 6.2: Crea una RegEx per un ID alfanumerico di esattamente 8 caratteri, che può contenere lettere maiuscole e numeri (es. AB12CD34).
'''


'''
Esercizio 6.1: Scrivi una RegEx per identificare un codice prodotto nel formato PROD-1234-XY.


Definiamo ^PROD-[0-9]{4}-XY$ OPPURE ^PROD-\d{4}-XY$

'''


'''
Esercizio 6.2: Crea una RegEx per un ID alfanumerico di esattamente 8 caratteri, che può contenere lettere maiuscole e numeri (es. AB12CD34).

Definiamo ^[A-Z0-9]{8}$


'''