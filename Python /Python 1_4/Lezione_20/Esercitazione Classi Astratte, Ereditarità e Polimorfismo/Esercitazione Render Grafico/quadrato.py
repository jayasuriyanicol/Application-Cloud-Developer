'''
Definire la classe Quadrato che estende la classe Forma e aggiunge specifiche circa 
la lunghezza di un suo lato.
Il costruttore della classe deve ricevere come argomento solo il lato del quadrato, 
ed impostare il nome della forma su "Quadrato".
Il metodo getArea() deve calcolare l'area del quadrato.
Il metodo render() deve stampare su schermo un quadrato avente lato pari 
al valore passato nel costruttore. Il quadrato da stampare deve essere 
un quadrato vuoto (" "), avente degli asterischi ("*") lungo il suo perimetro. 
(Vedi Esempio di output)

'''


from forma import Forma

class Quadrato(Forma):


    def __init__(self,latoQuadrato:int) -> None:

        super().__init__("Quadrato")
 
        self.latoQuadrato = latoQuadrato
   
    def getLato(self) -> int:

        return self.latoQuadrato
    
    def getArea(self) -> float:

        latoQuadrato = self.latoQuadrato

        areaQuadrato = latoQuadrato * latoQuadrato

        return areaQuadrato
    

    def render(self) -> str:

        lato = self.getLato()

        for parteSuperioreInferiore in range(lato):
            for parteLaterale in range(lato):
                if parteSuperioreInferiore == 0 or parteSuperioreInferiore == lato - 1 or parteLaterale == 0 or parteLaterale == lato - 1:
                     
                    print('* ',end="")

                else:
                     
                     print("  ",end="")
            print()
         



        





    
        

