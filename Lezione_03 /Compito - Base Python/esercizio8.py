'''
Esercizio 8

Un'applicazione interessante dei computer è la rappresentazione grafica di dati.
Scrivere un programma che acquisisca cinque numeri interi (ognuno compreso tra 1 e 30) e visualizzi in output un grafico a barre testuale con asterischi *.

Per ogni numero letto, il programma deve stampare una riga contenente tanti asterischi quanti il valore del numero stesso.

Esempio di output:
Se l'utente inserisce i numeri 5, 8, 3, 12, 7, il programma deve stampare:

*****
********
***
************
*******
'''

#Creiamo una lista per memorizzare i nostri numeri inseriti
asterischi = [ ]

#Spiegazione programma all'utente
print("\nBenvenuto! Questo programma, dato un numero intero compreso tra 1 e 30, mostra graficamente tanti asterischi quanto il numero inserito, per un massimo di 5 numeri.")

#Ciclo FOR per l'acquisizione di tutti i 5 numeri 
for numero in range(5):
    numero_inserito = int(input(f"\nPer favore, inserisci il {numero+1} numero: "))

    #Come indicato dal problema verifico che i numeri siano maggiori di 1 e minori di 30, sennò termino il programma mostrando in output il GRAFICO A BARRE
    if numero_inserito < 1 or numero_inserito > 30:
        print("\nATTENZIONE! Il numero deve essere MAGGIORE di 1 e MINORE di 30. Riprova RIAVVIANDO il programma.")
        break

    #Aggiungo il numero inserito nella lista vuota creata precedentemente
    asterischi.append(numero_inserito)

#Infine in output mostro il GRAFICO A BARRE con i relativi numeri, tramite FOR che a seconda del numero presente nella lista stampa volta per volta gli asterischi.
print("\n| GRAFICO A BARRE | \n")
for numero in asterischi:
    print('*' * numero)
