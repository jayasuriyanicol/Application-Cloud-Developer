'''
Si definisca una classe PagamentoCartaDiCredito derivata anch'essa da Pagamento 
e che definisce l'importo. 
Questa classe deve contenere gli attributi per il nome del titolare della carta, la data di scadenza, e il numero della carta di credito. Infine, si ridefinisca il metodo dettagliPagamento() per includere tutte le informazioni della carta di credito oltre 
all'importo del pagamento.
'''

from pagamento import Pagamento

class PagamentoCartaDiCredito(Pagamento):


    def __init__(self,nomeTitolare:str,dataScadenza:str, numeroCartaCredito:str) -> None:
        super().__init__()

        self.__nomeTitolare = nomeTitolare
        self.__dataScadenza = dataScadenza
        self.__numeroCartaCredito = numeroCartaCredito
    

    def setNomeTitolare(self, nomeTitolare:str) -> None:

        self.__nomeTitolare = nomeTitolare
    
    def setDataScadenza(self, dataScadenza:str) -> None:

        self.__dataScadenza = dataScadenza
    
    def setNumeroCartaCredito(self, numeroCarta:str) -> None:

        self.__numeroCartaCredito = numeroCarta

    
    def getNomeTitolare(self) -> str:

        return self.__nomeTitolare
    
    def getDataScadenza (self) ->str:
        return self.__dataScadenza
    
    def getNumeroCartaCredito (self) ->str:
        return self.__numeroCartaCredito
    
   
    def dettagliPagamento(self):
        
        print("\n|PAGAMENTO Modalità -> CARTA DI CREDITO|")
        print(f"\nNome sulla carta: {self.__nomeTitolare}")
        print(f"Data di scadenza: {self.__dataScadenza}")
        print(f"Numero della carta: {self.__numeroCartaCredito}")
        super().dettagliPagamento()