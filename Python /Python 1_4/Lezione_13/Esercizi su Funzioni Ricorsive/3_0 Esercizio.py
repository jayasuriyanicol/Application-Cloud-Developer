'''
Esercizio 3.

Il fattoriale di un intero non negativo n, scritto n!, è il prodotto

n * (n-1) * (n-2) * ... * 1

con 1! uguale a 1 e 0! definito come 1.
Si scriva una funzione ricorsiva recursiveFactorial che dato un numero n calcoli n!.

'''
#Definiamo una funzione che calcola il fattoriale di un numero n positivo, dando in putput 1 se nei casi analizzati esce come num intero 1 o 0.
def recursiveFactorial(n:int) -> int:

    if n < 0:
        print("Error ! The number is negative")
        return 0
    
    if n == 0 or n == 1:
        return 1
    return n * recursiveFactorial(n-1)

#Stampiamo in output il valore della forma ricorsiva, con un messaggio che ci indica il risultato
print("The factorial number is : ",recursiveFactorial(0))

