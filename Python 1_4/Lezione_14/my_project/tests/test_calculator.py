from my_project.calculator import Calculator
def test_addition():
    calculation: Calculator = Calculator(10,5)
    assert calculation.addition() == 13, "the sum is wrong"


def test_subtraction():
    calculation: Calculator = Calculator(10,5)
    assert calculation.subtraction() == 5, "the subraction is wrong"


def test_multiplication():
    calculation: Calculator = Calculator(10,5)
    assert calculation.multiplication() == 50, "the multiplication is wrong"


def test_division():
    calculation: Calculator = Calculator(10,5)
    assert calculation.division() == 2.00, "the quotient is wrong"