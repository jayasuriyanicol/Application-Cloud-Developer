'''
Esercizio 4.

Scrivere una funzione ricorsiva recursiveDigitCounter che restituisca il numero di cifre di un numero intero n passato in input.
Sono permessi sia valori positivi che negativi per n.
Ad esempio, il numero -120 ha 3 cifre.
Non si tenga conto di eventuali zeri non significativi.

Suggerimento: per il calcolo delle cifre, fare un controllo se il valore assoluto di n sia minore di 10. In caso positivo,
significa che il numero n ha una sola cifra. In caso negativo, significa che il numero n ha più cifre; dunque, 
dividere n per 10 per rimuovere l'ultima cifra e richiama ricorsivamente la funzione, fino a ottenere un numero con una sola cifra.

'''
#Definiamo una funzione che calcoli dati num interi e positivi, il numero di cifre presenti nel numero dato in maniera ricorsiva. 
def recursiveDigitCounter(n:int)-> int:
    #Nel caso in cui un num sia negaticvo prendiamo e lo convertiamo in maniera positiva 
    if n < 0:
       n = -n
    
   #Nel caso il numero sia minore di 10, di facto sarà  per forza un numero composto da una cifra, quindi return 1 
    if n < 10:

        return 1
    
   #In caso non sia min di 0, andiamo a calcolare il nostro il nostaro risultato con la div in 10 per togliere sempre l'ultima cifra e fare la ricorasione 
    else:
        ris = n  //10 
    return 1 + recursiveDigitCounter(ris)

#Successivamente andiamo a stampare il nostro numero, mostrando le cifre per ogni numero inserito
print(f"The number given contain : {recursiveDigitCounter(0)} digits.")