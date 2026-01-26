'''
This time no story, no theory. The examples below show you how to write function accum:
Examples:

accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"

The parameter of accum is a string which includes only letters from a..z and A..Z.

'''


def accum(st):
    
    listaParole:list[str] = []
    fraseFinale:str = ""

    if not st.isalpha():

        print("ATTENZIONE ! Non è possibile inserire nulla al di fuori di LETTERE (a-z and A-Z)")

    else:

        #Trasformo la frase tutta in minuscolo, così da facilitare lo svolgimentio di costruzione della 'fraseFinale' 
        listaParole = st.lower()  
        listaParole = list(st)
    
    for indice,elemento in enumerate(listaParole):
        
        parteCodice = elemento.upper() + elemento * indice 
        
        if indice < len(listaParole) - 1:
            fraseFinale += parteCodice + "-"

        else:
            fraseFinale += parteCodice

    return fraseFinale

''' Eseguo come richiesto dall'esercizio gli output attesi, per verificare la correttezza '''

print(accum("abcd"))
print(accum("abcd"))     
print(accum("RqaEzty"))  
print(accum("cwAt"))     




'''In caso alternativo per delle stringe di lunghezza maggiore, possiamo optare per questa soluzione. 
   Che non utilizza la forma 'lower()' e spezzetta in lista la frase, ma procedere direttamente con l'enumerate.

   
   def accum(st):
   
    fraseFinale:str = "" 

    for indice, lettera in enumerate(st):
       
        parteCodice = lettera.upper() + lettera.lower() * indice

        
        if indice < len(st) - 1:
        
            fraseFinale += parte + "-"

        else:
            fraseFinale += parte

    return fraseFinale
    
   '''


