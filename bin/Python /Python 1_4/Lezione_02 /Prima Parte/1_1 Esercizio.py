'''
1-1. Si scriva un programma che dimostri la natura approssimativa dei numeri in virgola mobile effettuando le seguenti attività:

    Memorizzare un numero in virgola mobile nella variabile x.
    Calcolare 1.0/x memorizzare il risultato nella variabile y.
    Visualizzare il valore di x, y e il prodotto tra x e y.
    Sottrarre x dal prodotto tra x e y e mostrarne il risultato.

'''

#Dichiariamo la variabile e messaggio inserimento in input della variabile
x = float(input("Benvenuto! Inserisci una variabile x: "))
y = 1.0 / x
prodotto = x * y
sottrazione = prodotto - x

#Messaggi in otput con i vari risultati
print("Questo è il risultato di X:", x)
print("Questo è il risultato di Y:", y)
print("Questo è il prodotto tra X e Y:", prodotto)
print("Questo è il risultato della sottrazione (prodotto - X):", sottrazione)
