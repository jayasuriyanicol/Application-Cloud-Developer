'''

Scrivi una funzione che prende una lista di numeri e ritorna un dizionario che classifica i numeri in liste separate per numeri pari e dispari.

For example:
Test 	Result

print(classifica_numeri([1, 2, 3, 4, 5, 6]))  {'pari': [2, 4, 6], 'dispari': [1, 3, 5]}

print(classifica_numeri([]))  {'pari': [], 'dispari': []}



'''

def classifica_numeri(lista: int) -> dict[str:list[int]]:

    dizionarioPariDispari:dict[str,list[int]] = {"Pari": [], "Dispari": [] }   



    for valore in lista:


        if valore % 2 == 0:

            dizionarioPariDispari["Pari"].append(valore)
        else:
            dizionarioPariDispari["Dispari"].append(valore) 
    return dizionarioPariDispari



print(classifica_numeri([1, 2, 3, 4, 5, 6])) 

print(classifica_numeri([])) 
