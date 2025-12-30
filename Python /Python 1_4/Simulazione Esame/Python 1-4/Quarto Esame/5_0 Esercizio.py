'''
Scrivere il frammento di codice che cambi il valore intero memorizzato nella variabile x nel seguente modo:
- se x è pari, deve essere diviso per 2;
- se x è dispari deve essere moltiplicato per 3 e gli deve essere sottratto 1.

For example:
Test 	Result

print(transform(4))    2

print(transform(-10)) -5


'''

def transform(x: int) -> int:


    if x % 2 == 0:
        

        x =  x//2
    else:
        x = x * 3 
        x = x - 1
    return x




print(transform(4))   

print(transform(-10)) 