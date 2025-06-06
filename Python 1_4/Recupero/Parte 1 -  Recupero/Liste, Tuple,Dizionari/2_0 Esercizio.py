'''
2) Scrivi una funzione che prenda una lista di numeri e ritorni un dizionario che
classifichi i numeri in liste separate per numeri positivi e negativi
'''

#Possiamo anche utilizzare l'operatore Union (import dal typing Union) invece del classico "|"
def listaNumeriDizionario(lista: list[int|float]) -> dict[str, list[int|float]]:

    dizionarioNumeri: dict[str, list[int|float]] = { "Positivi": [], "Negativi": [] }

    for numero in lista:
        

         ''' POSSIAMO UTILIZZARE IN EVENIENZA ANCHE QUESTA FORMA:
        
            if "Positivi" not in dizionarioNumeri:
                dizionarioNumer["Positivi"] = []  
             dizionarioNumeri["Positivi"].append(element) 
            
        else:
    
             if "Negativi" not in dizionarioNumeri:
                dizionarioNumer["Positivi"] = []  
             dizionarioNumeri["Positivi"].append(element) 
        
    return dizionarioNumeri

    print(listaNumeriDizionario([1, -2, 3, -3, 10]))
    
        '''
        
         if numero >= 0:
            dizionarioNumeri["Positivi"].append(numero)
         else:
            dizionarioNumeri["Negativi"].append(numero)

    return dizionarioNumeri



print(listaNumeriDizionario([1, -2, 3, -3, 10]))

