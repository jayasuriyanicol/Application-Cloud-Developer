'''
Scrivere un programma che acquisisca in input due numeri interi, n1 e n2, 
e calcoli il prodotto di tutti i numeri compresi tra n1 e n2, inclusi gli estremi.

Il programma deve gestire anche il caso in cui n1 > n2, calcolando comunque il prodotto 

'''

#Messaggio di spiegazione del codice e inserimento dei due valori
print("\nBenvenuto, questo programma calcola il prodotto tra tutti i numeri compresi tra due numeri inseriti (compresi i due numeri).\nPer procedere indicare i due numeri: ")

n_1 = int(input("\nPrego, inserisci il primo numero: "))
n_2 = int(input("Prego, inserisci il secondo numero: "))

#Definiamo tutte e due i casi
primo_caso = (n_1, n_2)
secondo_caso = (n_2, n_1)


#Indichiamo la condizione richiesta dal problema se vero invertiamo l'ordine
if n_1 > n_2:
    primo_caso = secondo_caso 

#Prendiamo i valori aggiornati
n_1, n_2 = primo_caso

prodotto = 1
primo = n_1

while primo <= n_2:
    prodotto *= primo
    primo += 1

#Risultato con OUTPUT del prodotto
print("\n| RISULTATO |")

print(f"\nIl RISULTATO DEL PRODOTTO fra i numeri inseriti {n_1} e {n_2} è il seguente: {prodotto}")
