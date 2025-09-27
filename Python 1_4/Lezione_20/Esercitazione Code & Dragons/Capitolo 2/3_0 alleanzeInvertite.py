'''
CAPITOLO 2 - ESERCIZIO NUMERO 3

Per evitare errori, inverti gli indici della tabella: ogni valore rimandi 
all'essenza originaria. Usa `invert_unique(d)` assumendo valori univoci.
Mantieni la firma e passa i test.

'''

def invert_unique(d: dict) -> dict:

    dizionarioInverso:dict[int,str] = {} 

    if d.items():
        
        for chiave, valore in d.items():

            dizionarioInverso[valore] = chiave 
        return dizionarioInverso
    
    else:

        return d
    

print(invert_unique({'a':1,'b':2}))
    





        