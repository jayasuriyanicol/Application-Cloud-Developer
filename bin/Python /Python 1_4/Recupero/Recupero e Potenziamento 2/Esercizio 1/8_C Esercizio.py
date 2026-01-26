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

    ___numeratore: int|float|Any
    ___denominatore: int|float|Any

    def __init__(self,numeratore:int|float|Any, denominatore:int|float|Any) -> None:

        self.___numeratore = numeratore
        self.___denominatore = denominatore
    
    def __repr__(self):
        
        return f"{self.___numeratore} / {self.___denominatore}"
    
    def MassimoComuneDivisore(self, x:int|float|Any, y:int|float|Any) -> int|float|Any:

        x:int|float|Any = abs(x)
        y:int|float|Any = abs(y)
        valoreMinimo:int = min(x,y)

        for elementoFrazione in range (valoreMinimo, 0, -1):

            if x % elementoFrazione == 0 and y % elementoFrazione == 0:

                return elementoFrazione
        return 1
    

    def semplifica(self):


        valoreMcD:int = self.MassimoComuneDivisore(self.___numeratore,self.___denominatore )

        return Frazione(self.___numeratore // valoreMcD , self.___denominatore // valoreMcD)
    

        

def semplifica(listaFrazioni:list[Frazione] ) -> list[Frazione]:


    listaFrazioneIrriducibili:list[Frazione] = [] 


    for frazione in listaFrazioni:

        frazioneNonSemplificata = frazione.semplifica()
        listaFrazioneIrriducibili.append(frazioneNonSemplificata)
    
    return listaFrazioneIrriducibili






'''DRIVER PROGRAMM - Notiamo la bontà della soluzione'''

if __name__ == "__main__":


    listaFrazione = [Frazione(3,5), Frazione(8,4), Frazione(3,7), Frazione(18,6) ] 
    
    risultatoFrazioneIrriducibile = semplifica(listaFrazione)

    print(risultatoFrazioneIrriducibile)