'''
Esercizio 3C-00A. Scrivere un programma in Python che richieda all'utente di inserire un numero intero rappresentante il numero di neonati 
e utilizzi lo statement match per fornire una risposta appropriata:

- Se il numero inserito è 1, stampare "Congratulazioni!"
- Se il numero inserito è 2, stampare "Wow! Gemelli!"
- Se il numero inserito è 3, stampare "Wow! Tre!"
- Se il numero inserito è 4, stampare "Mamma mia Quattro! Wow!"
- Se il numero inserito è 5, stampare "Incredibile! Cinque!"
- Altrimenti, stampare "Non ci credo! n bambini!", sostituendo n con il numero inserito.

Expected Output:

Inserire il numero di neonati: 2
Wow! Gemelli!

- - - - - - - - - - - - - - - - - -

Inserire il numero di neonati: 5
Incredibile! Cinque!

- - - - - - - - - - - - - - - - - -

Inserire il numero di neonati: 7
Non ci credo! 7 bambini!

'''

# Chiede all'utente di inserire il numero di neonati e lo converte in un intero
neonati: int = int(input("Benvenuto, inserire il numero di neonati: "))

# Utilizza il costrutto 'match' per confrontare il numero inserito con i casi definiti
match neonati:

    # Se l'utente inserisce 1, stampa un messaggio di congratulazioni
    case 1:
        print("Congratulazioni!")

    # Se l'utente inserisce 2, indica che si tratta di gemelli
    case 2:
        print("Wow! Gemelli!")

    # Se l'utente inserisce 3, indica che ci sono tre neonati
    case 3:
        print("Wow! Tre!")

    # Se l'utente inserisce 4, esprime stupore per quattro neonati
    case 4: 
        print("Mamma mia, quattro! Wow!")

    # Se l'utente inserisce 5, esprime incredulità per cinque neonati
    case 5:
        print("Incredibile! Cinque!")

    # Se il numero di neonati è diverso dai casi precedenti, stampa un messaggio personalizzato
    case _:
        print(f"Non ci credo! {neonati} bambini!")


