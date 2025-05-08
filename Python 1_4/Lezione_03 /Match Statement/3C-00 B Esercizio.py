'''
Esercizio 3C-00B. Scrivere un programma in Python che chieda all'utente di inserire il proprio nome e il proprio genere (specificato con "m" per maschio o "f" per femmina) e utilizzi lo statement match per fornire una risposta adeguata da inserire in un documento di identita'.

- Se il valore di gender è "m", stampare il nome e il genere come Maschio.
- Se il valore di gender è "f", stampare il nome e il genere come Femmina.
- Se il valore di gender è diverso da "m" o "f", stampare un messaggio di errore, indicando che non è possibile generare un documento di identità.

Expected Output:

Inserire nome: Luca
Inserire gender. Digitare m per maschio e f per femmina: m
Nome: Luca
Gender: Maschio

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Inserire nome: Anna
Inserire gender. Digitare m per maschio e f per femmina: f
Nome: Anna
Gender: Femmina


'''

# Chiede all'utente di inserire il proprio nome e lo salva nella variabile 'nome'
nome: str = input("\nBenvenuto, inserisci il tuo NOME: ")

# Chiede all'utente di inserire il proprio sesso ('m' per maschio, 'f' per femmina), funziona anche con l'utilizzo della MAIUSC o MINUSC
sesso: str = input('\nInserisci il tuo sesso "m" per maschio e "f" per femmina: ').lower()

# Utilizza il costrutto 'match' per verificare il valore inserito nella variabile 'sesso'
match sesso:

    # Se l'utente ha inserito 'm', stampa il nome e il genere "Maschio"
    case 'm':
        print(f"\nNome: {nome}")
        print(f"\nGender: Maschio\n\n")

    # Se l'utente ha inserito 'f', stampa il nome e il genere "Femmina"
    case 'f':
        print(f"\nNome: {nome}")
        print(f"\nGender: Femmina\n\n")

    # Se l'utente ha inserito un valore diverso da 'm' o 'f', stampa un messaggio di errore
    case _:
        print("\nErrore: Il valore inserito non è valido per il documento di identità.")
