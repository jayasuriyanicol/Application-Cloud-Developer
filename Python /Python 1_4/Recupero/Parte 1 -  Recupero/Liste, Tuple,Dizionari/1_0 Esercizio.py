'''
1) Scrivi una funzione che converta una lista di tuple (chiave, valore) in un dizionario. Se
la chiave è già presente, somma il valore al valore già associato alla chiave.
'''

#Importiamo Any per perttere all'utente di inserire qualsiasi tipologia di elemento: str,int,float,ecc.
from typing import Any

def convertitoreChiaveValore(listaTuple: list[tuple[Any,Any]]) -> dict[Any,Any] :

    dizionario:dict[Any,Any]  = {}

    '''
    for tupla in listaTuple:

        key,value = key[0], value[1] 

        for key in dizionario:

            dizionario[key] += value

        else:

            dizionario[key] = value
    return dizionario  
    '''
    
    #In questo caso siccome sono delle tuple, non servirà utilizzare "listaTuple.items()" 
    for chiave,valore in listaTuple:

        if chiave in dizionario:
            dizionario[chiave] += valore

        else:
            dizionario[chiave] = valore
    
    return dizionario









            

  