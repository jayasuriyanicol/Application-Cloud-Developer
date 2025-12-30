def rounded_average(numbers: list[int]) -> int:
    somma = 0
    conteggio= 0
    for i in numbers:
        conteggio +=1 
        somma += i

    media = somma / conteggio
    
     