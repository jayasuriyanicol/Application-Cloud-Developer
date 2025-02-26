
'''
 
Esercizio 3C-2. Scrivere un programma in Python che converta un voto di laurea italiano (sistema in 110-emi) nel sistema GPA americano (scala 0-4).
Il programma deve accettare in input un voto di laurea compreso tra 66 e 110, espresso come numero intero e usare un match per determinare il corrispondente GPA americano, secondo questa tabella di conversione:

- 106-110 → 4.0
- 101-105 → 3.7
- 96-100 → 3.3
- 91-95 → 3.0
- 86-90 → 2.7
- 81-85 → 2.3
- 76-80 → 2.0
- 70-75 → 1.7
- 66-69 → 1.0
- Altro caso → "Voto non valido"

Expected Output:

Inserisci il voto di laurea: 110
Output: GPA 4.0


'''
#Messaggio di benvenuto e inserimento del voto
voto_laurea = int(input("Benvenuto, questo programma convertirà il tuo voto di LAUREA ITALIANA in GPA (Voto di LAUREA AMERICANO)\n\nPrego, inserire il VOTO di LAUREA ITALIANO (voto in esimi da 66 a 110): "))


#Condizione di voto di laurea maggiore o inferiore, con messaggio di ERRORE !
if voto_laurea < 66 or voto_laurea > 110:

    print("ATTENZIONE! Il voto inserito non è VALIDO.\n\n Il voto deve essere di valore INTERO e con un numero compreso che va da un mionimo di 66 a un massimo di 110.")

else:

  #Match statement con le verie casistiche imposte nella consegna 
    match voto_laurea:

        case _ if  106 <= voto_laurea <= 110:
            print("GPA: 4.0")
        case _ if 101 <= voto_laurea <= 105:
            print("GPA: 3.7")
        case _ if 96 <= voto_laurea <= 100:
            print("GPA: 3.3")
        case _ if 91 <= voto_laurea <= 95:
            print("GPA: 3.0")
        case _ if 86 <= voto_laurea <= 90:
            print("GPA: 2.7")
        case _ if 81 <= voto_laurea <= 85:
            print("GPA: 2.3")
        case _ if 76 <= voto_laurea <= 80:
            print("GPA: 2.0")
        case _ if 70 <= voto_laurea <= 75:
            print("GPA: 1.7")
        case _ if 66 <= voto_laurea <= 69:
            print("GPA: 1.0")
        case _ :
            print("Voto non valido. GPA: No Valid")
        
        


