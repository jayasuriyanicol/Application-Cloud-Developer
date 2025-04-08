'''
Esercizio 10.

Si scriva una funzione ricorsiva charDuplicator che consenta di duplicare ogni carattere in una stringa e restituisca il risultato sotto forma
di una nuova stringa.

Ad esempio, se la stringa "libro" viene data in input a charDuplicator, la funzione ricorsiva deve produrre in output la stringa "lliibbrroo".
'''

#Definiamo una funzione che data una stringa duplica ogni carettere della stringa dandola poi in output. In caso di stringa vuota ritornerà quest'ultima vuota.
def recursiveCharDuplicator(s: str) -> str:
    if not s:
      return " "
    
    else:

      return s[0]*2 + recursiveCharDuplicator(s[1:])


print(recursiveCharDuplicator(""))



