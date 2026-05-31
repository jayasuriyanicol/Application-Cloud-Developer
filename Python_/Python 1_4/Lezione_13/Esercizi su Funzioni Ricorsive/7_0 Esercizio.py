'''

Esercizio 7.

Una produttoria è definita come il prodotto di un certo numero n di fattori, con n intero positivo. Sia Pi3 una produttoria definita come segue:
Pi3 = (1**3) * (2**3) * (3**3) * ... * (n**3)  

Calcolare il valore della produttoria Pi3 se n = 5.

'''
#Definiamo una funzione che calcoli in maniera ricorsiva il cubo di una produttoria dato un num n in input, se esso è = 0 restituisce 1 e in caso finale calcola il cubo della produttoria
def recursiveProductory(n:int) -> int:

    if n < 0:
        print("Error ! Attention give only POSITIVE NUMBERS !")
        return 0
    
    if n == 0:
        return 1
    
    return (n**3) * recursiveProductory(n-1)
    
#Successivamente richiamiamo il valore in questione andando a salavare in una variabile per poi stampare a schermo l'output 
result = recursiveProductory(5)
print(f"The value of Pi for n = 5 is {result}")

   