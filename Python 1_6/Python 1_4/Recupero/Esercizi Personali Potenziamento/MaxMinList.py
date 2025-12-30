'''
Esercizio 3 — Trova il massimo e minimo

Scrivi una funzione:


min_max(values: list[int]) -> tuple[int, int]

he restituisca una tupla contenente (minimo, massimo).

📘 Esempio:
min_max([4, 9, 1, 7]) ➜ (1, 9)

'''


def min_max(values: list[int]) -> tuple[int,int]:

    tuplaMaxMin:tuple[int,int] = []  
    massimoElem:int = 0
    minimoElem:int = 1


    massimoElem = max(values)
    minimoElem = min(values)

    tuplaMaxMin = [minimoElem,massimoElem]

    return tuplaMaxMin    


    
    '''
    In forma più estesa si può utilizzare:
    for elem in values:

        if elem > massimoElem:

            massimoElem =  elem
        elif elem < minimoElem:

            minimoElem = elem

    tuplaMaxMin =[minimoElem, massimoElem]

    return tuplaMaxMin  
    '''



print(min_max([4, 9, 1, 7]))

    


