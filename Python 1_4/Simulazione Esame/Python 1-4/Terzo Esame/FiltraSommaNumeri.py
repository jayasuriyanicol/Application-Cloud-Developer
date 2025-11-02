'''
Filtra e Somma Numeri – PUNTI 1

Scrivi una funzione con il seguente header:
filter_and_sum(nums: list[int], min_val: int) -> int

La funzione deve prendere una lista di numeri interi e sommare tutti i numeri maggiori di min_val.
Restituisci la somma risultante.

📘 Esempio:

filter_and_sum([2, 7, 3, 10, 5], 4) ➜ 22

'''

def filter_and_sum(nums:list[int],min_val:int) -> int:

    sommaValori:int = 0

    for elm in nums:

        if elm > min_val:
            sommaValori += elm
    
    return sommaValori


