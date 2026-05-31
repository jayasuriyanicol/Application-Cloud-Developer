'''
2. Riconoscere parole

Obiettivo: Lavorare con lettere e lunghezze di stringhe.

    Esercizio 2.1: Scrivi una RegEx che riconosca una parola composta solo da lettere minuscole.
    Esercizio 2.2: Adatta la RegEx per accettare parole con lettere maiuscole e minuscole.
    Esercizio 2.3: Modifica la RegEx per accettare parole lunghe da 5 a 10 caratteri.

'''

'''
Esercizio 2.1: Scrivi una RegEx che riconosca una parola composta solo da lettere minuscole.

Definiamo un range ^[a-z]+$, date le ancore prende più caratteri da a alla z in minuscolo.
'''

'''
Esercizio 2.2: Adatta la RegEx per accettare parole con lettere maiuscole e minuscole.

Definiamo un range ^[a-zA-Z]+, date le ancore prende oltre le minuscole anche le MAIUSCOLE per ogni occorrenza.
'''


'''
 Esercizio 2.3: Modifica la RegEx per accettare parole lunghe da 5 a 10 caratteri.

 Definiamo un range ^[a-zA-Z]{5,10}$ date le ancore prende pià occorrenze per un minimo di 5 per un massimo di 10.
'''