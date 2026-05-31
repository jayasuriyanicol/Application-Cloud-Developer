'''
9-13. Dice: Make a class Dice with one attribute called sides, which has a default value of 6. 
Write a method called roll_die() that prints a random number between 1 and the number of sides the die has. 
Make a 6-sided die and roll it 10 times. Make a 10-sided die and a 20-sided die. Roll each die 10 times.

'''

'''
import random

class Dice:

    def __init__ (self, sides="6"):

        self.sides = sides


def roll_die(self):
    while True:

      sides =  input("Please, insert the side of the roll: ")
      count += 1

      if count == 10:
          break
    '''


def fibonacci (n:int) -> int:


    if n <= 0:

        return 0
    
    if n == 1:

        return 1
    
    else:

      return  int(fibonacci(n-1)+ fibonacci(n-2))
    

print(fibonacci(6))