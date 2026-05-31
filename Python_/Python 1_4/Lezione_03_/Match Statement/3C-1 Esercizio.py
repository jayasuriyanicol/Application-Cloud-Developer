'''

Esercizio 3C-1. Scrivere un programma in Python che utilizzi un match statement per classificare un voto scolastico in base alla scala italiana.
Il programma deve accettare in input un voto numerico intero da 1 a 10 e stampare la valutazione corrispondente:

- 10 → "Eccellente"
- 8-9 → "Molto buono"
- 6-7 → "Sufficiente"
- 4-5 → "Insufficiente"
- 1-3 → "Gravemente insufficiente"
- Altro caso → "Voto non valido"

Expected Output:

Inserisci il voto: 5
Output: Insufficiente
- - - - - - - - - - -
Inserisci il voto: 11
Output: Voto non valido


'''

voto_input = input("Benvenuto, questo programma permette di classificare il tuo voto in decimi, il voto si basa in DECIMI (1 A 10).\n\nPrego, per proseguire, inserire il VOTO IN DECIMI (1 A 10): ")

# Verifica se l'input è numerico
if voto_input.isnumeric():
    voto = int(voto_input)
    
    # Verifica che il voto sia nell'intervallo 1-10
    if voto < 1 or voto > 10:
        print("Voto non valido: inserisci un numero tra 1 e 10!")
    else:
        match voto:
            case 10:
                print("\nEccellente !")
            case 9 | 8:
                print("\nMolto buono !")
            case 7 | 6:
                print("\nSufficiente !")
            case 5 | 4:
                print("\nInsufficiente !")
            case 3 | 1:
                print("\nGravemente insufficiente !")
else:
    print("Voto non valido: inserisci un numero intero tra 1 e 10 !")
