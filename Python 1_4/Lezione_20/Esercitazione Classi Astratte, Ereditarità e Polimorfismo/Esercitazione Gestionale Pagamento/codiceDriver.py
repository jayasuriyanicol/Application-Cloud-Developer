'''
Per il test, si creino almeno due oggetti di tipo PagamentoContanti e due di tipo PagamentoCartaDiCredito con valori differenti e si invochi dettagliPagamento() per ognuno di essi.

Esempio di output:
Pagamento in contanti di: €150.00
150.00 euro da pagare in contanti con:
1 banconota da 100 euro
1 banconota da 50 euro

Pagamento in contanti di: €95.25
95.25 euro da pagare in contanti con:
1 banconota da 50 euro
2 banconote da 20 euro
1 banconota da 5 euro
1 moneta da 0.2 euro
1 moneta da 0.05 euro

Pagamento di: €200.00 effettuato con la carta di credito
Nome sulla carta: Mario Rossi
Data di scadenza: 12/24
Numero della carta: 1234567890123456

Pagamento di: €500.00 effettuato con la carta di credito
Nome sulla carta: Luigi Bianchi
Data di scadenza: 01/25
Numero della carta: 6543210987654321

'''


from pagamento import *
from pagamentoContanti import *
from pagamentoCartaDiCredito import *



primoPagamentoContanti = PagamentoContanti()
primoPagamentoContanti.setImportoPagamento(150.00)

secondoPagamentoContanti = PagamentoContanti ()
secondoPagamentoContanti.setImportoPagamento(95.25)

print("\nSOMMARIO TEST SOLDI FISICI - SUL GESTIONALE DI PAGAMENTO: ")

#Primo e Secondo TEST sulle BANCONOTE/FISICHE
primoPagamentoContanti.dettagliPagamento()
primoPagamentoContanti.inPezziDa() 

secondoPagamentoContanti.dettagliPagamento()
secondoPagamentoContanti.inPezziDa()


primoPagamentoContanti = PagamentoCartaDiCredito("Mario Rossi","12/24","1234567890123456")
primoPagamentoContanti.setImportoPagamento(200.00)

secondoPagamentoContanti = PagamentoCartaDiCredito("Luigi Bianchi","01/25","6543210987654321")
secondoPagamentoContanti.setImportoPagamento(500.00)


print("\nSOMMARIO TEST CARTA DI CREDITO - SUL GESTIONALE DI PAGAMENTO: ")


#Primo e Secondo TEST sulle CARTE DI CREDITO/VIRTUALI
primoPagamentoContanti.dettagliPagamento()
secondoPagamentoContanti.dettagliPagamento()
