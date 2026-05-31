'''
Exercise 2
Write a function check_length(), which takes a string as an argument.
Using if / else, check if the length of the string is bigger, smaller, or equal to 10 
characters.

'''

#Defenisco una funzione che calcola la lunghezza della stringa se i caratteri 10 sono: maggiori,minori o pari.
def check_length(stringa):
    if len(stringa) > 10:
        print("\nLa stringa inserita è maggiore di 10 caratteri!")
    elif len(stringa) < 10:
        print("\nLa stringa inserita è minore di 10 caratteri!")
    else: 
        print("\nLa stringa inserita è pari a 10 caratteri!")
    
    return stringa  

'''Chiedo di inserire una parola all'interno della variabile parola e poi successivamente salvo la parola all'interno dela variabile risultato
che riporta la lunghezza della mia stringa e anche il risultato in output '''

parola = input("Inserisci una parola: ") 
risultato = check_length(parola)

print("\nQuesta è la stringa inserita dall'utente:", risultato)
