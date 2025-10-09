#Example of using a Decorator to take the time/check the time of a function

#Sample usage function of a timer 
def timer(func):

    def wrapper():
        import time
        start: float = time.time()
        func()
        print(time.time() - start)
    return wrapper


#Creation of a function Cronometro with usage of *args
from typing import Callable, Any

def cronometro(function:Callable) -> Callable:

        def wrapper(*args)-> Any:
                
                from time import time
                start = time()
                function(*args)
                print(f"Tempo strascorso: {time() -start}")
        return wrapper



#Cronometro as a decorator, used to calcolate a 'large' function of a cicle for to in order to test it
@cronometro
def testCronometro(num:int) -> None:
        
        contatoreCronometro = 0

        for _ in range (0,215932832):
                
                contatoreCronometro += num


testCronometro(30000000)

        