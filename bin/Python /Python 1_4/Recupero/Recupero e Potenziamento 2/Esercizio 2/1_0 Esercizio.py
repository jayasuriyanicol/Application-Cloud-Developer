'''
Esercizio 2.
 
Scrivere un programma Python che legge in input prima un intero x positivo e poi una sequenza di interi positivi. Se l'utente inserisce il numero 0, allora la sequenza deve terminare.

Per il numero x e per ogni numero della sequenza inserita, effettuare il controllo che il numero inserito sia effettivamente un intero e forzare l'utente ad inserire un numero intero positivo nel caso in cui questa condizione non venga rispettata.
Trovare una soluzione che eviti di scrivere codice duplicato per effettuare questa serie di controlli.
 
Suggerimento: per controllare che un numeri sia intero, usare la funzione is_integer() e isistance().

Determinato il numero x e la sequenza di interi positivi, il programma deve produrre in output:
 

    stampare la sequenza

    Il numero occ di occorrenze di x, ovvero  il numero di volte in cui appare x nella sequenza;

    La posizione pos del primo valore uguale a x.

    La somma di tutti i valori diversi da x;


Ad esempio, se l'utente inserisce come valore x il numero 3 e poi immette la sequenza: 7; 5; 1; 3; 3; 3; 11; 2; 3; 3; 0
 
il programma dovra' scrivere in output:

    stampare in output la sequenza

    Il numero 3 compare 5 volte nella sequenza (attenzione all'output se il numero compare 1 sola volta!)

    Il numero 3 compare per la prima volta in posizione 3 nella sequenza

    La somma dei valori della sequenza diversi da 3 e' 26

'''

def sequenzaContaOccorrenze(x:int, sequenzaInteri:list[int]) -> str:
   
    contatoreNumeri:int = 0
    sommaElementiDifferenti:int = 0
    posizioneOccorrenza:int = -1

    for numero in range(len(sequenzaInteri)):

        elemento = sequenzaInteri[numero]

        if not isinstance(elemento, int):
            print(f"ATTENZIONE ! l'elemento {elemento} non è intero !")
        

        if elemento == x:
            contatoreNumeri += 1
        else:
            sommaElementiDifferenti:int = sommaElementiDifferenti + elemento

        if posizioneOccorrenza == -1:
            if contatoreNumeri > 0:
                posizioneOccorrenza = sequenzaInteri.index(x) + 1 
        

    risultato = f"Sequenza Numeri:{sequenzaInteri}\n"
    
    if contatoreNumeri == 1:
        risultato += f"Il numero {x} compare {contatoreNumeri} volta nella sequenza\n"
    else:
        risultato += f"Il numero {x} compare {contatoreNumeri} volte nella sequenza\n"
    
    if posizioneOccorrenza != -1:
        risultato += f"Il numero {x} compare per la prima volta in posizione {posizioneOccorrenza} nella sequenza\n"
    
    risultato += f"La somma dei valori della sequenza diversi da {x} è {sommaElementiDifferenti}"
    
    return risultato



'''Proseguo con l'inserimento dei valori nelle parte MAIN del programma che finchè non si digiat il numero 0 prosegue'''


while True:

    numeroOccorenza = input("Benvenuto, inserire il numero: ")

    if numeroOccorenza.isdigit():  

        x = int(numeroOccorenza)
        if isinstance(x, int) and x > 0:
            break

    print("Attenzione, il numero inserito non è un intero positivo")


sequenzaInteri = []

while True:

    numeroIntero = input("Inserisci un numero intero positivo (0 per terminare): ")

    if numeroIntero.isdigit():

        numeroIntero= int(numeroIntero)

        if isinstance(numeroIntero, int) and numeroIntero == 0:
            break

        elif numeroIntero > 0:
            sequenzaInteri.append(numeroIntero)

        else:
            print("Inserisci solo numeri interi positivi!")

    else:
        print("Attenzione! Devi inserire un intero positivo.")
        

print(sequenzaContaOccorrenze(x, sequenzaInteri))
