'''
Exercise 3
Write a function print_numbers(), which takes a list of numbers as argument.
Using a for loop, print each number one by one.

'''

#Defenisco la mia funzione che stampa i caretteri uno a uno data una lista di numeri
def print_numbers(numbers:list):
    count = 0
    for i in numbers:
        count +=1
        print(f"\nQuesto è il {count}° della lista della lista: {i}  ")

#Stampo ogni elemento della mia funzione secondo quanto scirtto all'interno della mia funzione
numbers:list = [1,2,3,4,5] 
print_numbers(numbers)