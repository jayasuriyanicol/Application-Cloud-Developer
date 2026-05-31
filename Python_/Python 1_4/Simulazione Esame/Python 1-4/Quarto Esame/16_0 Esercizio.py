'''

Scrivi una funzione che somma tutti i numeri interi di una lista che sono maggiori di un dato valore intero definito threshold.

For example:
Test 	Result

print(sum_above_threshold([15, 5, 25], 20)) 25


'''


def sum_above_threshold(numbers: list[int], threshold:int) -> int:

    somma:int = 0

    for elm in numbers:
        if elm > threshold:

            somma += elm

    return somma
    


print(sum_above_threshold([15, 5, 25], 20))
