'''
Exercise 1: Creating an Abstract Class with Abstract Methods

Start by defining an abstract base class called Shape. This class should include two abstract methods: one named area, which will be responsible for calculating the area of a shape, and another named perimeter, 
which will calculate the perimeter. Since Shape is abstract, it will not provide specific implementations for these methods. Instead, it sets a blueprint for all shapes that will inherit from it.

Then, create two concrete subclasses, Circle and Rectangle, that both extend the Shape class. Each of these subclasses must provide their own implementation of the area and perimeter methods, based on the geometric formulas
 appropriate to their shapes.

Finally, write a simple driver program (test code) that creates instances of Circle and Rectangle, calls their area and perimeter methods, and prints the results. This will help verify that your class hierarchy works as intended.


'''

#Importiamo ABC e abstractmethod per creare una classe astratta
from abc import ABC, abstractmethod

#Creiamo la classe astratta Shape che rappresenta una forma geometrica generica
class Shape(ABC):

    #Definiamo il metodo astratto area che dovrà essere implementato da tutte le sottoclassi
    @abstractmethod
    def area(self) -> float:
        pass

    #Definiamo il metodo astratto perimeter che dovrà essere implementato da tutte le sottoclassi
    @abstractmethod
    def perimeter(self) -> float:
        pass


#Creiamo la classe Circle che eredita da Shape e rappresenta un cerchio
class Circle(Shape):
    #Inizializziamo il raggio del cerchio
    def __init__(self, r: float):
        self.r = r

    #Implementiamo il calcolo dell'area del cerchio
    def area(self) -> float:
        return 3.14 * self.r ** 2

    #Implementiamo il calcolo del perimetro del cerchio
    def perimeter(self) -> float:
        return 2 * 3.14 * self.r


#Creiamo la classe Rectangle che eredita da Shape e rappresenta un rettangolo
class Rectangle(Shape):
    def __init__(self, b: float, h: float):
        #Inizializziamo la base e l'altezza del rettangolo
        self.b = b
        self.h = h

    #Implementiamo il calcolo dell'area del rettangolo
    def area(self) -> float:
        return self.b * self.h

    #Implementiamo il calcolo del perimetro del rettangolo
    def perimeter(self) -> float:
        return 2 * (self.b + self.h)


#Creiamo una funzione che riceve una figura geometrica e ne stampa area e perimetro
def showCalculation(shape: Shape) -> None:
    #Stampiamo l'area e il perimetro
    print(f"AREA: {shape.area():.2f}")    
    print(f"PERIMETRO: {shape.perimeter():.2f}") 


#Testiamo la funzione con un oggetto Circle di raggio 2
print("\n|CERCHIO|\n")
showCalculation(Circle(2))

#Testiamo la funzione con un oggetto Rectangle di base 2.3 e altezza 3.5
print("\n|RETTANGOLO|\n")
showCalculation(Rectangle(2.3, 3.5))
