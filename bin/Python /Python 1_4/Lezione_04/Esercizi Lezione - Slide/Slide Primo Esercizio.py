'''
Exercise 1
Write a function check_value(), which takes a number as an argument.
Using if / else, the function should print whether the number is bigger, smaller, or equal to 5

'''

#Definisco una funzione che vede se il numero 5 è maggiore, minore o uguale a 5
def check_value(a:int):

    if a > 5:
      
      print("Il numero inserito è maggiore di 5 !")
    elif a <5:
       
       print("Il numero inserito è minore di 5 !")

    else:
       print("Il nuemro inserito è uguale a 5 !")
    
    return a

#Salvo il numero dentro la variabile numero e stampo il risultato
numero = check_value(4)

print("Questo è il numero inserito: ", numero)