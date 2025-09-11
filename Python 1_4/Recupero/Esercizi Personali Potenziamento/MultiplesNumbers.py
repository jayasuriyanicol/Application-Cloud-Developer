'''
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

Additionally, if the number is negative, return 0.

Note: If a number is a multiple of both 3 and 5, only count it once.

Courtesy of projecteuler.net (Problem 1)

'''

def solution(number):

    sommaNumeriTotali:int = 0

    if number < 0:

        return 0

    for numeroIndice in range (0,number):

        if numeroIndice % 3 == 0 or numeroIndice % 5  == 0:

            sommaNumeriTotali += numeroIndice
    return sommaNumeriTotali



'''Andiamo a verificare se il programma funziona correttamente come richiesto dal sistema, svolgendo noi un DRIVER PROGRAMM '''

print(solution(10)) 
print(solution(16))