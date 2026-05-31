'''
CAPITOLO 1 - ESERCIZIO 5

Trama Lineare

A fine procedura versa tutto nello stesso crogiolo creando un flusso uniforme. Ottienilo con `flatten_once(nested)`, che concatena le sottoliste a un solo livello.
 Mantieni la firma e fai riuscire i test.

'''



def flatten_once(nested: list[list[int]]) -> list[int]:

    lista:list    =  []
    count:int = 0

    if len(nested) == 0:

        return  []   
    
    else:
        for elemento in nested:
            for numero in elemento:
                
             lista.append(numero)
                
    return lista
        
print(flatten_once([[1,2],[3,4]]))







