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

    def __init__(self,base:int, altezza:int) -> None:
        super().__init__("Rettangolo")
        self.base = base
        self.altezza = altezza
        

    def getBase(self) -> int:

        return self.base
    
    def getAltezza(self) -> int:

        return self.altezza
    
    def getArea(self) -> float:
        
        base = self.base
        altezza = self.altezza

        areaRettangolo = (base * altezza)
        return areaRettangolo
    

    def render(self) -> str:

        altezza = self.getAltezza()
        base = self.getBase()

        for parteSuperioreInferiore in range(altezza):
            for parteInferiore in range(base):
                if parteSuperioreInferiore == 0 or parteSuperioreInferiore == altezza - 1 or parteInferiore == 0 or parteInferiore == base - 1:
                     print('* ',end="")
                else:
                     print("  ",end="")
            print()
            


    
    

    
    