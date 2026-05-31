'''
Definire la classe Triangolo che estende la classe Forma e aggiunge specifiche circa 
la dimensione di un lato del triangolo (per semplicità, si suppone che il triangolo 
in questione sia un triangolo rettangolo).
Il costruttore della classe deve ricevere come argomento solo il lato del triangolo, 
ed impostare il nome della forma su "Triangolo".
Il metodo getArea() deve calcolare l'area del triangolo.
Il metodo render() deve stampare su schermo un triangolo rettangolo avente i due cateti
di lunghezza pari ai valori passati nel costruttore. Il triangolo da stampare deve 
essere un triangolo vuoto (" "), avente degli asterischi ("*") lungo il suo perimetro. 
(Vedi Esempio di output)
 
Hint: per il disegno utilizzare print("*", end=" "), dato che l'argomento end = " " 
permette di controllare come termina ogni chiamata a print, e impostandolo a uno spazio
si può fare in modo che tutte le stampe successive siano sulla stessa riga, separate da 
uno spazio.
'''

from forma import Forma

class Triangolo(Forma):

    def __init__(self, latoTriangolo:int)-> None:

        super().__init__("Triangolo")

        self.latoTriangolo = latoTriangolo


    def getLatoTriangolo(self)-> int:

        return self.latoTriangolo
    
    def getArea(self)-> float:

        lato = self.latoTriangolo

        areaTriangolo = ((lato*lato)//2)

        return areaTriangolo
    

    def render(self)-> str:

        lato = self.getLatoTriangolo()

        for parteSuperioreInferiore in range (lato):
            for parteInferiore in range(parteSuperioreInferiore + 1):
                
                if parteSuperioreInferiore == lato - 1 or parteInferiore == 0 or parteInferiore == parteSuperioreInferiore:
                     print('* ',end="")
                else:
                     print("  ",end="")

            print()
        



        

