'''
1. Riconoscere numeri

Obiettivo: Definire una RegEx che riconosca solo stringhe composte da cifre.

    Esercizio 1.1: Scrivi una RegEx che riconosca un numero intero positivo (es. 123, 98765).
    Esercizio 1.2: Modifica la RegEx per accettare anche numeri negativi (es. -45, -1000, 0).

'''

'''
 Esercizio 1.1: Scrivi una RegEx che riconosca un numero intero positivo (es. 123, 98765):


Definiamo un range che va da ^[0-9]+$ , ovvero entro il numero 0 a più occorrenze fino al numero 9 a più cifre con relativi relative ancore all'inizio ed alla fine
'''


'''
Esercizio 1.2: Modifica la RegEx per accettare anche numeri negativi (es. -45, -1000, 0).


Definiamo un range che va da ^-[0,9]+$, ovvero modifico anche con i numeri negativi con più occorrenze anche sia sul positivo che nella parte negativa, sempre con ancore.

'''