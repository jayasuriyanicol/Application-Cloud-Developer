'''
8.C Una frazione si dice irriducibile se il numeratore e il denominatore non hanno divisori comuni, ovvero il più grande divisore comune tra numeratore e denominatore è 1.

Sia l una lista di frazioni, ovvero una lista di oggetti della classe Frazione.

Si scriva nel file frazioni.py una funzione chiamata semplifica() che data in input una lista di frazioni ritorni in output una lista di frazioni irriducibili.
 
Nello specifico:

    se una frazione f della lista data in input è già irriducibile, allora inserire questa frazione f nella lista da ritornare in output.

 

    se una frazione f della lista data in input può essere semplificata, in una frazione irriducibile f1, allora si deve prima semplicare la frazione f, 
    ottenendo la frazione irriducibile f1 e poi inserire f1 nella lista da ritornare in output.


Suggerimento: Leggere bene la traccia dell'intero esercizio per capire come implementare la funzione semplifica.
Inserire in modo adeguato le seguenti frazioni nella lista l.
   
'''


from typing import Any

class Frazione:

    ___numeratore: int|float
    ___denominatore: int|float

    def __init__(self,numeratore:int|float, denominatore:int|float) -> None:

        self.___numeratore = numeratore
        self.___denominatore = denominatore
    
    def __repr__(self):
        
        return f"{self.___numeratore} \ {self.___denominatore}"
    
    def MassimoComuneDivisore(self, x:int|float, Y:int|float) -> int|float:

        x:int|float = abs(self.___numeratore)
        y:int|float = abs(self.___denominatore)
        valoreMinimo:int = min(x,y)

        for elementoFrazione in (valoreMinimo, 0, -1):

            if x % elementoFrazione == 0 and y % elementoFrazione == 0:

                return elementoFrazione
            return 1
    

    def semplifica(self):


        valoreMcD:int = self.MassimoComuneDivisore(self.___numeratore,self.___denominatore )

        return Frazione(self.___numeratore // valoreMcD , self.___denominatore // valoreMcD)





    
    
        


 

        

def semplifica(listaFrazioni:Frazione) -> list[Frazione]:


    listaFrazioneIrriducibili:list[Frazione] = [] 


    for frazione in listaFrazioni:

        if frazione



