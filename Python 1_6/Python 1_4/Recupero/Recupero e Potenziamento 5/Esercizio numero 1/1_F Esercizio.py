'''
1.F Scrivere una funzione caricoMin(), che data in input una matrice restituisce una tupla di indici r e c per i quali si ha il carico minimo della matrice.
Ovvero, dovete trovare la coppia di indice riga r e indice colonna c per cui il carico k(r,c) ha valore minimo. 
Prima di restituire la tupla di indici (r,c) stampare il valore del carico minimo.
'''

def caricoMin(matrice:list[int[int]]) -> int|tuple[int,int]:

    dimensioneMatrice = len(matrice)
    caricoMinimo = None
    posizioneMatrice = None

    for r in range(dimensioneMatrice):
        for c in range(dimensioneMatrice):

            caricoTotale:int = calcolaCarico(matrice,r,c) #type: ignore
            if caricoMinimo is None or caricoTotale < caricoMin:
                caricoMinimo = caricoTotale
                posizioneMatrice = (r,c)
    
    '''Ritorniamo come chiesto dall'esercizio prima il CARICO MINIMO poi successivamente la posizione delle matrici r e c'''
    print(f"Il CARICO MINIMO della matrice è il seguente: {caricoMinimo}")
    return posizioneMatrice


          
