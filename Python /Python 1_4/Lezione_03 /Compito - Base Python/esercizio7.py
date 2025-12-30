'''
Esercizio 7

Scrivere un programma che inizializzate due liste a e b della stessa lunghezza n, 
entrambe contenenti valori interi, calcoli la somma incrociata degli elementi.

Esempio:

a[1] + b[n-1], a[2] + b[n-2], ...

Memorizzare ogni somma incrociata in una nuova lista c e, quindi, visualizzare in output le liste a, b, c.

'''

#Iniziazlizziamo le liste richieste, ovvero A e B dove conterranno i numeri inseriti e la lista C con la somma incrociata
a = [ ] 
b = [ ] 
c = [ ] 


#Spiegazione programma e chiediamo di quanto vogliono essere lunghe le liste
lunghezza = int(input("\nBenvenuto, questo programma calcola LA SOMMA INCROCIATA date due liste.\n\nPer procedere inserisci la lunghezza desiderata delle due liste: "))

#Ciclo FOR per l'inserimento dei elementi nella lista e incrementiamo il numero_inserito per la lunghezza fino ad raggiungerlo
for numero_inserito in range(lunghezza):
    a.append(int(input(f"Prego, inserisci il {numero_inserito+1} elemento della LISTA A: ")))
    b.append(int(input(f"Prego, inserisci il {numero_inserito+1} elemento della LISTA B: ")))

#Calcoliamo la somma incrociata di ogni numero_presente nelle liste A e B e le aggiungiamo alla lista C
for numero_presente in range(lunghezza):
    c.append(a[numero_presente] + b[lunghezza-numero_presente-1])

#Output con le listeb inserite e con la lista risultante con il calcolo della SOMMA INCROCITA

print ("\n| RISULTATO DELLA SOMMA INCROCIATA |")
print("\nNumeri inseriti nella LISTA A:", a)
print("\nNumeri inseriti nella LISTA B:", b)
print("\nSomma Incrociata nella LISTA C:", c)
