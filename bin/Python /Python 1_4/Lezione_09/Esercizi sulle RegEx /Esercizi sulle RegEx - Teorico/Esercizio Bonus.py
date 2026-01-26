
'''
Bonus – Errori comuni

Obiettivo: Trovare errori in RegEx sbagliate.

    Esercizio 8.1: Qual è l’errore nella RegEx ^\d{2,5}?$ se voglio matchare da 2 a 5 cifre?
    Esercizio 8.2: La RegEx [A-z] funziona per lettere? Perché può essere rischiosa?

'''


'''
Esercizio 8.1: Qual è l’errore nella RegEx ^\d{2,5}?$ se voglio matchare da 2 a 5 cifre?

La sintassi errata sta nel inserire il punto interrogativo dato che renderebbe opzionale il match di {2,5}.
Inoltre questo comporterebbe che non raggiunga mai i requisiti indicati, andando a soddisfare solo il caso minimo "2".


'''


'''
Esercizio 8.2: La RegEx [A-z] funziona per lettere? Perché può essere rischiosa?

La funzione può essere rischiosa perchè indica che sono accette caratteri maiuscoli, minuscoli ma anche ASCII.
In questo caso, potrebbe essere incogruente meglio [a-z] oppure [A-Z].

'''