'''
CAPITOLO 2 - ESERCIZIO NUMERO 2

Atlante Fuso

Due ricettari si sovrappongono: fondili lasciando prevalere le dosi più aggiornate.
Implementa `merge_overwrite(a, b)` creando un nuovo dizionario con i valori di `b` 
che sovrascrivono `a`.
Mantieni la firma e promuovi i test.

'''


def merge_overwrite(a: dict, b: dict) -> dict:


    dizionario:dict[str] = {}

    for chiaveA,valueA in a.items():
        dizionario[chiaveA] = valueA

    for chiaveB, valueB in b.items():
            
        dizionario[chiaveB] = valueB 

        
    return dizionario


print(merge_overwrite({},{'a':9}))