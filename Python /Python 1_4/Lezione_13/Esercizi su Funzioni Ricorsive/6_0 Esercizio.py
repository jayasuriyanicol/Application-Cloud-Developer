'''
Esercizio 6.

Una produttoria è definita come il prodotto di un certo numero n di fattori, con n intero positivo. Sia Pi una produttoria definita come segue:
Pi = (0 + 2) * (1 + 2) * (2 + 2) * ... *  (n+2).  

Calcolare il valore della produttoria Pi se n = 7.

'''
#Definiamo una funzione che calcola la Produttoria di un numero, se questo è minore di 0 errore, sennò se è 0 produttoria = 1 e in caso finale andiamo a calcolare la produttoria
def recursiveProductory(n:int) -> int:
    pi = 0

    if n < 0:

        print("Error ! Attention give only POSITIVE NUMBERS !")
        return 0
    

    if n == 0 :
        return 1
    
    return (n+2) * recursiveProductory (n-1)

  
#Successivamente richiamiamo il valore in questione andando a salavare in una variabile per poi stampare a schermo l'output 
result = recursiveProductory(7)
print(f"The value of Pi for n = 7 is {result}")



        
    
    