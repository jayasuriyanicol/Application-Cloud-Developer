'''
Exercise 5
Write a function add_one(). It takes an integer as argument. The function adds 1 to the integer and returns it.
Write another function add_one_to_list(). It takes a list of integers as argument.
Define a variable new_list in this function.
Using a for loop, iterate through the argument list.
Using add_one (), fill new_list with integers from the argument list incremented
by 1.
Print new_list.
Example:
add_one_to_list([1, 2, 3])
>> [2, 3, 4]

'''
#Definiamo una funzione che somma il numero +1
def add_one(intero: int) -> int:
    return intero + 1  

''' Definiamo una funzione che data una lista di interi, somma +1 a tutti i numeri presenti nella lista, 
riportando sempre un valore int in output all'interno di una nuova lista '''

def add_one_to_list(lst: list) -> None:
    new_list = []  
    for num in lst:  
        new_list.append(add_one(num))  
    print(new_list)  

numero = add_one(2)
print(numero)  

#La lista che abbiamo dichiarato per l'operazione, che verrà trasformata
add_one_to_list([1, 2, 3])  
