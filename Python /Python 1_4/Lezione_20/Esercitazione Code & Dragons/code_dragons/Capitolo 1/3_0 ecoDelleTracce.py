'''
CAPITOLO 1 - Esercizio numero 3

Eco delle Tracce

Gli alambicchi accumulano residui: separa ogni sostanza tenendo solo la prima 
apparizione. Usa `dedup_stable(nums)` per ottenere una nuova lista senza duplicati 
successivi, in ordine. 
Mantieni la firma e supera i test come un filtraggio riuscito.

'''


def dedup_stable(nums: list[int]) -> list[int]:

    numeriInseriti = set()
    risultato = []

    for numeroPresente in nums:

        if numeroPresente not in numeriInseriti:

            risultato.append(numeroPresente)
            numeriInseriti.add(numeroPresente)
            
    return risultato



print(dedup_stable([1,1,2,2,3,3,1]))  
print(dedup_stable([]))               
print(dedup_stable([7,7,7]))          