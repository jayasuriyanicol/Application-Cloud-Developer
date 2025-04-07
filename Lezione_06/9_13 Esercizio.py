'''
9-13. Dice: Make a class Dice with one attribute called sides, which has a default value of 6. 
Write a method called roll_die() that prints a random number between 1 and the number of sides the die has. 
Make a 6-sided die and roll it 10 times. Make a 10-sided die and a 20-sided die. Roll each die 10 times.

'''
#Importiamo random per i numeri random richiesti dall'esercizio
import random


class Dice:

    def __init__(self,sides:int=6)-> int:
        self.sides =sides
    
    def roll_die(self) -> int:
        return random.randint(1,self.sides)
    

    
#Svolgiamo la prima chiamata a funzione richiesta dall'esercizio
sides_6 = Dice()

print("\n\nThe value for 6 sides-die is: ")
for _ in range(10):
    print("\nThe value is: ",sides_6.roll_die())

#Svolgiamo la seconda chiamata a funzione richiesta dall'esercizio
sides_10 = Dice(10)

print("\n\nThe value for 10 sides-die is: ")
for _ in range(10):
    print("\nThe value is: ",sides_10.roll_die())

#Svolgiamo la seconda chiamata a funzione richiesta dall'esercizio
sides_20 = Dice(20)

print("\n\nThe value for 20 sides-die is: ")
for _ in range(10):
    print("\nThe value is: ",sides_20.roll_die())

