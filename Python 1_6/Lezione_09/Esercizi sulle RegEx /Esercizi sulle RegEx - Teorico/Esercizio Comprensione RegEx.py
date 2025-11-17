'''
Esercizi – Comprensione di RegEx

Data la RegEx, occorre interpretarla.

    Esercizio 7.1: Cosa fa questa RegEx? ^[A-Z][a-z]{2,}$
    Esercizio 7.2: Quali stringhe sono accettate da \d{3}-\d{2}-\d{4}?
    Esercizio 7.3: Qual è l’effetto del simbolo ? in questa RegEx: colou?r 
    
'''


'''
Esercizio 7.1: Cosa fa questa RegEx? ^[A-Z][a-z]{2,}$

Questa RegEx prende in considerazioen il primo carattere MAIUSCOLO, il secondo che deve essere un minimo di 2 e può arrivare fino a "inifnito" n
'''



'''
Esercizio 7.2: Quali stringhe sono accettate da \d{3}-\d{2}-\d{4}?

Le stringhe accettate dal formato RegEx sono un minimo di 3 per la prima posizione, 2 per la seconda e 4 per la terza (3-2-4)

'''



'''
Esercizio 7.3: Qual è l’effetto del simbolo ? in questa RegEx: colou?r 

Chiede se è presente la stringa colou senza memorizzarla accettando entrambi i casi o colou oppure anche colour, rende la lettera "u" opzionale.


'''