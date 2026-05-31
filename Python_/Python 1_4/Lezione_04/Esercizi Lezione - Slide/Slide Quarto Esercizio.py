'''
Exercise 4
Write a function check_each(), which takes a list of numbers as argument.
Using a for loop, iterate through the list.
For each number, print “bigger” if it’s bigger than 5, “smaller” if it’s smaller than 5, and “equal” if it’s equal to 5
'''

#Definisco la mia funzione che data una lista indica quali numeri sono maggiori, minori o uguali al numero 5
def check_each(lista: list):
    count = 0
    for i in lista:
        count += 1
        print(f"\nQuesta è il {count} numero della lista: {i}")  

        
        if i > 5:
            print("\nbigger!")
        elif i < 5:
            print("\nsmaller!")
        else:
            print("\nequal to 5!")


#Dichiarata la mia lista proseguo stampando i vari valori 
lista = [1, 2, 3, 4, 5, 6, 7]
check_each(lista)
