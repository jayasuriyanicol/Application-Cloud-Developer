'''
Esercizio 9.

Si scriva una funzione ricorsiva vowelRemover che elimini tutte le vocali da una stringa data e restituisca 
sotto forma di una nuova stringa la stringa originale ma senza le vocali.

Suggerimento: utilizzare l'operatore + per realizzare la concatenazione di stringhe al fine di costruire la stringa da restituire.

'''

#Definiamo una funzione che date delle vocali andiamo eliminare le vocali contenute in una stringa, se la stringa è vuota ritorna 0, in caso positivo ritorna la stringa senza le vocali,
def vowelRemover(s: str) -> str:
    if s == "":
        return ""
    
    
    vocali = ["a","e","i","o","u","A","E","I","O","U"] 

    
    if s[0] in vocali:
        return vowelRemover(s[1:])
    else:
        return s[0] + vowelRemover(s[1:])

#
print(vowelRemover("NICOLA"))  

      
    

    

    