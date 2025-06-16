'''
Esercizio 2. 
 
Elaborare uno schema che consenta di stampare in output in maniera ricorsiva gli elementi di una lista in ordine inverso.

Una volta elaborato il diagramma, appena consentitovi dal docente, scrivere una funzione ricorsiva in Python, chiamata printListBackward che stampi in output gli elementi di una lista in ordine inverso, sfruttando la ricorsione.
Infine, scrivere un codice driver date le seguneti liste, stampi ogni lista in ordine inverso sfruttando la funzione ricorsiva printListBackward.

    lista1: 1, 2, 3, 4, 5

    lista2: "Armatura", "Bravura", "Cane", "Diamante", "Elefante", "Furfante"


'''

from typing import Any
def printListBackward(listaOrdinata:list[Any] )-> list[Any]:


    if not listaOrdinata:

        return 
    printListBackward(listaOrdinata[1:]) 
    print(listaOrdinata[0])





'''DRIVER PROGRAM - richiesto dall'esercizio'''
listaNumero1 = ["Armatura", "Bravura", "Cane", "Diamante", "Elefante", "Furfante"]
 


printListBackward(listaNumero1)

        