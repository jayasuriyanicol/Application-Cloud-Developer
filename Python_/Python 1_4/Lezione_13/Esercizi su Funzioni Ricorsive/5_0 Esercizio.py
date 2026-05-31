'''
Esercizio 5.

Una progressione armonica è definita come il prodotto dei reciproci dei primi n numeri interi positivi, ovvero il risultato della moltiplicazione 
di 1 diviso ogni numero intero da 1 fino a n.
Ad esempio, se n = 6, la progressione armonica A vale:
A = 1/6 * 1/5 * 1/4 * 1/3 * 1/2 * 1 = 0.001389.

Scrivere in Python una funzione ricorsiva chiamata armonica che dato un numero n intero positivo, 
calcoli la relativa progressione armonica, arrotondando il risultato finale a 6 cifre decimali.

'''

#Definiamo una funzione che calcola la progressione armonica di un  num n, nel caso base diamo un errore, in caso positivo continuiamo con num = 1 o calcoliamo il valore secondo la formula
def recursiveArmonyProgress(n: int) -> float:
    if n <= 0:
        print("Error! The value you have inserted is not valid, ONLY POSITIVE NUMBERS!")
        return 0
    
    
    if n == 1:
        return 1
    
    
    value = (1 / n) * recursiveArmonyProgress(n - 1)
    
    return value
   
#Successivamente richiamiamo il valore in questione andando a salavare in una variabile per poi stampare a schermo l'output 
armonic_progression = recursiveArmonyProgress(6)

print(f"The ARMONIC PROGRESSION fo the number is this one: {armonic_progression:.6f} ")

