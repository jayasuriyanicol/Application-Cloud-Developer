'''
3) Scrivi una funzione che accetti un dizionario di prodotti con i relativi prezzi e
restituisca un nuovo dizionario con solo i prodotti che hanno un prezzo inferiore a 50, ma
con i prezzi aumentati del 10% e arrotondati a due cifre decimali.

'''

def dizionarioConParametri (dizionarioProdotti) -> dict[str,int|float]:

    dizionarioNuoviProdotti : dict[str, int|float]  = {} 

    for chiave,valore in dizionarioProdotti.items():

        if valore < 50:

            nuovoValore  = round(valore * 1.1, 2)

            dizionarioNuoviProdotti[chiave] = nuovoValore

    return dizionarioNuoviProdotti




prodotti = {"penna": 10, "zaino": 55, "quaderno": 30}
print(dizionarioConParametri(prodotti))
