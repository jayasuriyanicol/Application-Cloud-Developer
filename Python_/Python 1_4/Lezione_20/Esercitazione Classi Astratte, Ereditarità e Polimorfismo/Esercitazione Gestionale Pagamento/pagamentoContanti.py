'''

Successivamente, si definisca una classe PagamentoContanti che sia derivata da Pagamento
 e definisca l'importo. Q
 uesta classe dovrebbe ridefinire il metodo dettagliPagamento() per indicare che 
 il pagamento è in contanti. Si definisca inoltre il metodo inPezziDa() 
 che stampa a schermo quante banconote da 500 euro, 200 euro, 100 euro, 50 euro, 20 euro,
 10 euro, 5 euro e/o in quante monete da 2 euro, 1 euro, 0,50 euro, 0,20 euro, 0,10 euro, 
 0,05 euro, 0,01 euro sono necessarie per pagare l'importo in contanti.

'''

from pagamento import Pagamento


class PagamentoContanti(Pagamento):
    

    def __init__(self) -> None:
        super().__init__()
    

    def dettagliPagamento(self) -> None:

        print(f"\nImporto del pagamento : {self.getImportoPagamento():.2f} EURO")
        print("\nL'importo deve avvenire in CONTANTI")
    
    def inPezziDa(self) -> None:

        importo = round(self.getImportoPagamento(),2)

        listaSoldi:list[float] = [500.00,200.00,100.00,50.00,20.00,10.00,5.00,2.00,1.00,0.50,0.20,0.10,0.05,0.01]
        
        dizionarioBanconote:dict[float,int] = {} 


        for elemento in listaSoldi:

            if importo>=elemento:

                soldiOccorrenti = int(importo//elemento)
                importo = round(importo - (soldiOccorrenti * elemento),2)
                 
                if elemento not in dizionarioBanconote:
                    dizionarioBanconote[elemento] = soldiOccorrenti
                else:
                    dizionarioBanconote[elemento] += soldiOccorrenti
            

        print("\n|PAGAMENTO Modalità -> CONTANTI|")

        for chiave,valore in dizionarioBanconote.items():
                  
            if chiave >= 5.00:

                tipologiaMoneta = "BANCONOTA"

            else:
                tipologiaMoneta = "MONETA"

            if valore == 1:
                print(f"\n{tipologiaMoneta} da {chiave:.2f} EURO -> {valore} pezzo")
            else:
                print(f"\n{tipologiaMoneta} da €{chiave:.2f} EURO -> {valore} pezzi")
