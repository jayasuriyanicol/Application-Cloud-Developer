'''
Esercizio 2
Scrivere un programma che acquisisca una stringa inserita dall'utente e calcoli il numero totale di spazi presenti nella stringa. 
Il risultato deve essere visualizzato in output.

'''

#Dichiariamo le nostre variabili, carattere che servirà da incide e spazio come variabile per sommare gli spazi.
carattere = 0
spazio = 0

#Inseriamo la stringa in input per l'utente
stringa= str(input("\nBenvenuto nel programma che calcola gli spazi presenti in una stringa.\n\nPrego, inserisci una stringa (frase): "))

#Per ogni carattere nella stringa se è uguale a " ", incremento spazio. Attuabile con anche il While ma troppo dispendioso
for carattere in stringa:
    if carattere == " ":
     spazio += 1

# IN ALTERNATIVA con la funzione COUNT: Con la variabile "spazio", calcoliamo gli spazi presenti nella stringa
'''spazio= stringa.count(" ")'''

#Output degli spazi con la stringa inserita dall'utente
print(f'\nSono presenti {spazio} spazio\i nella stringa: "{stringa}" ')