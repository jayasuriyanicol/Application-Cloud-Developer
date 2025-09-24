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


    def __init__(self, nomeForma:str, funzionalita:str,latoQuadrato:int) -> None:
        super().__init__(nomeForma, funzionalita)
 
        self.latoQuadrato = latoQuadrato
        self.nomeForma = "Quadrato"
   
    def getLato(self) -> int:

        return self.latoQuadrato
    
    def getArea(self) -> float:

        latoQuadrato = self.latoQuadrato

        areaQuadrato = latoQuadrato * latoQuadrato

        return areaQuadrato
    

    def render(self) -> str:

        altezza:int = 1
        lunghezza:int = 1
        lato = self.getLato()

        while altezza <= lato:
            lunghezza = 1
            
            while lunghezza <= lato:
                if altezza == 1 or altezza == lato or lunghezza == 1 or lunghezza == lato:
                     print('* ',end="")
                else:
                     print(" ",end="")
                altezza += 1
            print()
            altezza += 1



        





    
        

