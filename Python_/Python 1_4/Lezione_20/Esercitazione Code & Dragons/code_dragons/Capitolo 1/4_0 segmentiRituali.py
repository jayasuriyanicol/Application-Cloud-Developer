'''

CAPITOLO 1 - Esercizio numero 4

Segmenti Rituali


Per stabilizzare il rituale travasa i reagenti in fiale di volume costante. 
Usa `chunk(lst, size)` per ottenere sottoliste di lunghezza `size` 
(l'ultima può variare). Mantieni la firma e supera i test come una titolazione
regolare.



'''

def chunk(lst: list[int], size: int) -> list[list[int]]:

    sottolista:list[list[int]]    =  [[]]
    count:int = 0

    if len(lst) == 0:

        return  []   
    
    else:
        for elemento in lst:

            if count == size:
                
                sottolista.append([])
                count = 0
            sottolista[-1].append(elemento)
            count += 1
        
        return sottolista
        

print(chunk([1,2,3,4],2))

