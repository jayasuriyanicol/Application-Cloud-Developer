'''
Check to see if a string has the same amount of 'x's and 'o's. 
The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false

'''


def xo(s):
    
    conteggioO:int = 0
    conteggioX:int = 0

    stringaAnalisi:str = s.lower()

    for elemento in stringaAnalisi:

        if elemento == "o":

            conteggioO += 1
            
        if elemento == "x":
            conteggioX += 1
    

    if conteggioO == conteggioX:

        return True
    if conteggioO != conteggioX:
        return False
    
    if conteggioX == 0 and conteggioO == 0:
        return True
    


'''Eseguiamo gli OUTPUT attesi forniti dall'esercizio, per verificare la  coerenza con i risultati attesi'''

print(xo("ooxx"))    
print(xo("xooxx"))  
print(xo("ooxXm"))  
print(xo("zpzpzpp")) 
print(xo("zzoo"))    
