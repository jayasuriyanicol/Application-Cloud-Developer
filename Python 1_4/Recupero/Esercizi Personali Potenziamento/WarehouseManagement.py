'''
Esercizio 5 (avanzato – gestione inventario con dizionari e input)

Scrivi un programma che gestisca l’inventario di un piccolo negozio.

L’utente deve poter inserire ripetutamente prodotti nel formato
nome_prodotto quantità prezzo_unitario
(es. pasta 3 1.99, pane 5 0.80)

Salva i dati in un dizionario dove:

la chiave è il nome del prodotto

il valore è un altro dizionario con chiavi quantità e prezzo_unitario.

Se l’utente inserisce lo stesso prodotto più volte, somma le quantità (lasciando invariato il prezzo unitario).

Alla fine (quando scrive fine) stampa:

Tutti i prodotti con quantità e prezzo unitario.

Il valore totale dell’inventario (somma di quantità × prezzo di ogni prodotto).

Il prodotto con valore più alto in magazzino.

Output Atteso:


Inserisci prodotto, quantità e prezzo (o 'fine'): pasta 3 1.99
Inserisci prodotto, quantità e prezzo (o 'fine'): pane 5 0.80
Inserisci prodotto, quantità e prezzo (o 'fine'): pasta 2 1.99
Inserisci prodotto, quantità e prezzo (o 'fine'): fine

Inventario:
- pasta: 5 pezzi, 1.99 €/pz
- pane: 5 pezzi, 0.80 €/pz

Valore totale: 13.95 €
Prodotto più prezioso: pasta (9.95 €)

'''

dizionarioProdotti:dict[str,dict[str,float]]  = {}

while True:

    inserimentoProdotto:str = input("Inserisci prodotto, quatità e prezzo (0 'fine'): ")


    

    informazioniProdotto:str = inserimentoProdotto.split()
    
    
    if inserimentoProdotto.lower() == "fine":

        break

    if len(informazioniProdotto) > 4:

        print("ATTENZIONE ! Non è possibile inserire più di 3 elementi, consentiti per lunghezza del nome del prodotto !")
        continue
    
    nomeProdotto = informazioniProdotto[0] 

    try:

        quantitàProdotto = int(informazioniProdotto[1])
        prezzoUnitaProdotto = float(informazioniProdotto[2])

    except ValueError:

          print("ATTENZIONE ! L'inserimento dei prodotti NON  è andato a BUON FINE, inserire prodotto, quantità e prezzo")
          continue
    
    if nomeProdotto in dizionarioProdotti:


            dizionarioProdotti[nomeProdotto]["quantità"] += quantitàProdotto

    else:
           dizionarioProdotti[nomeProdotto]={ "quantità" :  quantitàProdotto, "prezzoUnita": prezzoUnitaProdotto }


print("\nInventario:")

sommaQuantitàProdotto:int = 0
totaleSingoloProdotto:float = 0
totaleProdottiInventario:float = 0
prezzoMaggioreProdotto:float = 0

for nomeProdotto, datiProdotto in dizionarioProdotti.items():

     QuantitàProdotto = datiProdotto['quantità']
     SingoloProdotto = datiProdotto["prezzoUnita"]
     valoreProdotto = QuantitàProdotto * SingoloProdotto

     print(f"\n- {nomeProdotto}: {QuantitàProdotto} pezzi, {SingoloProdotto:.2f} €/pz")    
     
     totaleProdottiInventario += valoreProdotto

     if valoreProdotto > prezzoMaggioreProdotto:
          
        prezzoMaggioreProdotto = valoreProdotto
        nomeProdottoMaggiore = nomeProdotto

     else:
          totaleSingoloProdotto = 0
    

print(f"\nValore totale: {totaleProdottiInventario} euro")
print(f"\nProdotto più prezioso: {nomeProdottoMaggiore} ({prezzoMaggioreProdotto:.2f} euro)")

          