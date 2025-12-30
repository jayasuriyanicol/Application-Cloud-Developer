'''
ESERCIZIO NUMERO 3

Filtra e Concatena Numeri - PUNTI 1
Scrivi una funzione con il seguente header:
filter_and_concat(nums: list[int], min_val: int) -> str che prenda una
lista di interi e un valore minimo, e restituisci una stringa concatenata di tutti i numeri di nums
che sono maggiori di min_val, separati da virgola (es. "5,7,9")

'''


def filter_and_concat(nums: list[int], min_val: int) -> str:

    stringaNumeriMaggioriVal:str = ''

    for numero in nums:

        if numero > min_val:

            stringaNumeriMaggioriVal += str(numero)
            stringaNumeriMaggioriVal += "," 
            
    return stringaNumeriMaggioriVal


print(filter_and_concat([5,6,7,1,2,4,3], 3))

    
    

