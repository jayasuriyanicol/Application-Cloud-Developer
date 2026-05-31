'''
Exercise 2: Implementing Static Methods

Create a class called MathOperations to group together some basic arithmetic functionality. Inside this class, define two static methods:

    add, which accepts two numeric parameters and returns their sum.

    multiply, which also takes two numeric parameters and returns their product.

Finally, write a small driver program to test the functionality of the add and multiply methods. 
This should involve calling both methods with sample inputs and printing the results to verify that they work correctly.



'''


'''Questo ESERCIZIO si può scrivere in due maniere differenti:
   
    A. Utilizzando l'import ABC in abc con il metodo di 'abstractmethod' 
     
    B. Non  utilizzando l'import ABC in abc con il metodo di 'abstractmethod' 

'''


'''|METODO A|'''


#Creiamo la classe astratta AbstractMathOperations per definire un'interfaccia per le operazioni matematiche
from abc import ABC, abstractmethod

class AbstractMathOperations(ABC):

    #Definiamo il metodo astratto per l'addizione: dovrà essere implementato da ogni sottoclasse
    @abstractmethod
    def add(self, a: float, b: float) -> float:
        return a + b  #Questo return è formale, l’implementazione avverrà nella sottoclasse

    #Definiamo il metodo astratto per la moltiplicazione
    @abstractmethod
    def multiply(self, a: float, b: float) -> float:
        return a * b  #Anche qui il corpo sarà ridefinito nella sottoclasse


#Creiamo la classe concreta MathOpertaions che implementa i metodi definiti nell'interfaccia astratta
class MathOpertaions(AbstractMathOperations):

    #Implementiamo il metodo add
    def add(self, a: float, b: float) -> float:
        return a + b

    #Implementiamo il metodo multiply
    def multiply(self, a: float, b: float) -> float:
        return a * b


#Creiamo una funzione che utilizza l'interfaccia AbstractMathOperations per stampare i risultati
def showCalculation(mathOperations: AbstractMathOperations) -> None:
    print("\n|METODO A|\n")
    print(f"Valore dell'ADDIZIONE: {mathOperations.add(2, 3):.2f}")
    print(f"Valore della MOLTLIPICAZIONE: {mathOperations.multiply(4, 5):.2f}")


#Eseguiamo il test istanziando la classe MathOpertaions
operation = MathOpertaions()
showCalculation(operation)






'''|METODO B|'''

#Creiamo la classe MathOperations con metodi statici per operazioni aritmetiche di base
class MathOperations:

    #Definiamo il metodo statico per l'addizione
    @staticmethod
    def add(a: float, b: float) -> float:
        return a + b

    #Definiamo il metodo statico per la moltiplicazione
    @staticmethod
    def multiply(a: float, b: float) -> float:
        return a * b


#Creiamo una funzione che testa direttamente i metodi statici della classe
def showCalculation() -> None:
    print("\n|METODO B|\n")
    print(f"Valore dell'ADDIZIONE: {MathOperations.add(2, 3):.2f}")
    print(f"Valore della MOLTLIPICAZIONE: {MathOperations.multiply(4, 5):.2f}")


#Chiamiamo la funzione di test
showCalculation()
