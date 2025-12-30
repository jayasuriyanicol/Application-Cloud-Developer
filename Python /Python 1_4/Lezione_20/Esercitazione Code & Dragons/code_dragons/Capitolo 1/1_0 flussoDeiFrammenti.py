'''
CAPITOLO 1 - Esercizio numero 1

Flusso dei Frammenti


Nel Laboratorio Reale i reagenti sono dispersi. Misura la quantità totale con `sum_list(nums)`, che somma gli interi in `nums`; 
se non c'è nulla, restituisci `0`. Mantieni la firma e lascia che gli esperimenti (i test) riescano.

'''


def sum_list(nums:list[int]) -> int:

    sommaNumeri = 0

    if len(nums) == 0:

        return 0

    else:

        for numeroPresente in nums:

            sommaNumeri += numeroPresente
        return sommaNumeri


'''Nel caso volessimo utilizzare una formula più ridotta possiamo adottare:'''

def sum_list(nums:list[int]) -> int:

    return sum(nums) if nums else 0



print(sum_list([1,2,3,4]))



