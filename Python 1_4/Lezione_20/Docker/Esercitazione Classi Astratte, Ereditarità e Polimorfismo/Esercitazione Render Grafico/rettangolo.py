'''
Definire la classe Rettangolo che estende la classe Forma e aggiunge specifiche circa
 la lunghezza della sua base e della sua altezza.
Il costruttore della classe deve ricevere come argomento solo la base e l'altezza del 
rettangolo, ed impostare il nome della forma su "Rettangolo".
Il metodo getArea() deve calcolare l'area del rettangolo.
Il metodo render() deve stampare su schermo un rettangolo avente base ed altezza pari
ai valori passati nel costruttore.
Il rettangolo da stampare deve essere un rettangolo vuoto (" "), avente degli asterischi
 ("*") lungo il suo perimetro. (Vedi Esempio di output)
'''

from forma import Forma

class Rettangolo(Forma):

    def __init__(self, nomeForma:str, funzionalita:str,base:int,altezza:int) -> None:
        super().__init__(nomeForma, funzionalita)
        self.base = base
        self.altezza = altezza
        nomeForma = "Rettangolo"
    

    def getBase(self) -> int:
        return self.base
    
    def getAltezza(self) -> int:
        return self.base
    
    def getArea(self) -> float:
        
        base = self.base
        altezza = self.altezza


        areaRettangolo = (base * altezza) // 2
        return areaRettangolo
    

    def render(self) -> str:
        altezzaRettangolo = 1
        baseRettangolo = 1
        altezza = self.getAltezza()
        base = self.getBase()

        while altezza <= altezzaRettangolo :
            base = 1
            
            while base <= baseRettangolo:
                if altezzaRettangolo == 1 or altezzaRettangolo == altezza or baseRettangolo == 1 or baseRettangolo == base:
                     print('* ',end="")
                else:
                     print(" ",end="")
                altezza += 1
            print()
            altezza += 1


    
    

    
    