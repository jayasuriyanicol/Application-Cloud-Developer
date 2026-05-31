'''
Esercizio 1 — Somma dei numeri pari

Scrivi una funzione:

sum_even(nums: list[int]) -> int

che ritorni la somma di tutti i numeri pari contenuti nella lista.

sum_even([1, 2, 3, 4, 5, 6])  ➜  12

'''



def sum_even(nums: list[int] ) -> int:

    sommaNumeriPari:int =  0  



    for elem in nums:

        if elem % 2 == 0:

            sommaNumeriPari += elem
    return sommaNumeriPari
    


print(sum_even([1, 2, 3, 4, 5, 6]) )
    


        


