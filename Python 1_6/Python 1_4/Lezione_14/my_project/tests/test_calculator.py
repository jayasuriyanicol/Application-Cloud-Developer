from my_project.calculator import Calculator
import pytest 


#Senza riscrivere ogni volta su ogni funzione -> "calculation: Calculator = Calculator(10,5)" possiamo creare direttamentre la funzione 'calculation' 
@pytest.fixture
def calculation():
    #Creates a fresh instance of Calculator before each test
    return Calculator(10,5) 

#Inseriamo tutte le varie funzioni con i vari TEST
def test_addition(calculation):
    
    assert calculation.addition() == 13, "the sum is wrong"


def test_subtraction(calculation):
   
    assert calculation.subtraction() == 5, "the subraction is wrong"


def test_multiplication(calculation):
    
    assert calculation.multiplication() == 50, "the multiplication is wrong"


def test_division(calculation):
    
    assert calculation.division() == 2.00, "the quotient is wrong"

