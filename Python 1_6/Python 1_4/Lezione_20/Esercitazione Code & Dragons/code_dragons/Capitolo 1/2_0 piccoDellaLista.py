'''
CAPITOLO 1 - Esercizio numero 2

Picco della Lista

Tra i flaconi ricomposti cerca la concentrazione dominante.
Calcolala con `max_or_none(nums)`: torna il massimo, o `None` se non ci sono dati.
Mantieni la firma e superi i test come una titolazione perfetta.


'''


def max_or_none(nums: list[int]) -> int | None:

    if len(nums) == 0:
        return None
    
    massimo = nums[0]

    for n in nums[1:]:

        if n > massimo:
            massimo = n

    return massimo



'''Nel caso volessimo utilizzare una formula più ridotta possiamo adottare:'''


def max_or_none(nums: list[int]) -> int | None:

    if not nums: 
        return None
    return max(nums)



print(max_or_none([1,1,2,2,3,3,1]))
