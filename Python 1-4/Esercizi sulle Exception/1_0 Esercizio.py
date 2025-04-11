'''
1_0 Esercizio:
Safe Square Root: Write a function safe_sqrt(number) that calculates the square root of a number using math.sqrt(). 
Handle ValueError if the input is negative by returning an informative message.

'''
#Importiamo la libreria MATH per svolghere l'esercizio per la RADICE QUADRATA (SQRT)
import math

#Definiamo la funzione che calcola la nostra radice quadrata rendendola "sicura" ovvero evitando che vengano inseriti valori negativi, in caso questo non accada calcoliamo il SQRt
def safe_sqrt() -> None:

    number = int(input("Welcome, please write down the NUMBER : "))

    if number < 0:

     raise ValueError ("ATTENTION ! The number you have write down is NEGATIVE, we consider only POSITIVE numbers !")
    
    else: 
       
     root = int(math.sqrt(number))

     print(f"\nThe SQUARE number of the value of {number} you have write down is {root:.2f}")



safe_sqrt()




'''                                                              |MODALITÀ ALTERNTIVA| 

In maniera alternativa possiamo riscrivere il codice utitlizzando la sintassi di TRY, EXCEPT, ecc.                                                         ''' 

'''
import math

def safe_sqrt(number):
    if number < 0:
        return "ATTENTION! The number is NEGATIVE, we consider only POSITIVE numbers!"
    else: 
      root = math.sqrt(number)
      return f"The square root of {number} is {root}"


try:
    num = float(input("Welcome, please write down the NUMBER :"))  
    print(safe_sqrt(num))
except ValueError:
    print("ATTENTION ! The number you have write down is NEGATIVE, we consider only POSITIVE numbers !")
'''