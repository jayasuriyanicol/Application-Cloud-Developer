'''
Esercizio 8.

Si scriva una funzione ricorsiva vowelsCounter che conti il numero di vocali in una stringa.

Suggerimento: ogni volta che si effettua una chiamata ricorsiva, si utilizzi lo slicing per ottenere una nuova stringa formata 
dai caratteri compresi tra il secondo e l'ultimo della stringa originale.
L'ultima chiamata ricorsiva avverrà quando la stringa non contiene caratteri.
 

'''
#Definiamo una funzione che date delle vocali andiamo contare le vocali contenute in una stringa, se la stringa è vuota ritorna 0, in caso positivo calcola il valore in maniera ricorsiva
def recursiveVowelsCounter(s:str) -> int:

    if not s:
        return 0
    
    vocali = ["a","e","i","o","u","A","E","I","O","U"] 

    if s[0] in vocali:

        return 1 + recursiveVowelsCounter(s[1:])  
    

    else:
        return 0 + recursiveVowelsCounter(s[1:])
    


print(recursiveVowelsCounter("Ciao"))
  

        

    

    

