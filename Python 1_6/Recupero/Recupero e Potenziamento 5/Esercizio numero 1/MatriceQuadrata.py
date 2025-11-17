from random import randint

def genera(dim:int) -> list[list[int]]:
    matrice:list[list[int]] = [] 

    for riga in range (dim):
        riga_corrente:list[int] = [] 

        for colonna in range (dim):
            while True:
                numeroRandomicoRiga:int = randint(0,13)
                if colonna == 0:
                    riga_corrente.append(numeroRandomicoRiga)
                    break
                if numeroRandomicoRiga != riga_corrente[0]:
                    riga_corrente.append(numeroRandomicoRiga)
                    break

        matrice.append(riga_corrente)  
    
    return matrice  

def printMAT(matrice:list[list[int]]) -> list[list[int]]:
    for riga in matrice:
        for elemento in riga:
            print(f"{elemento:5}", end="")  
        print()
    print()

def calcolaCarico(matrice: list[list[int]], indiceRiga: int, indiceColonna: int) -> int:
    sommaRigheMatrice = 0
    sommaColonneMatrice = 0

    for elemento in matrice[indiceRiga]:
        sommaRigheMatrice += elemento

    for i in range(len(matrice)):
        sommaColonneMatrice += matrice[i][indiceColonna]

    calcoloCaricoMatrice = sommaRigheMatrice - sommaColonneMatrice

    return calcoloCaricoMatrice

def caricoNullo(matrice:list[list[int]]) -> list[tuple[int,int]]:
    dimensioneMatrice:int = len(matrice)
    posizioneNulleMatrice:list[tuple[int,int]] = []   

    for elementoRiga in range(dimensioneMatrice):
        for elementoColonna in range(dimensioneMatrice):
            if calcolaCarico(matrice, elementoRiga, elementoColonna) == 0:
                posizioneNulleMatrice.append((elementoRiga, elementoColonna)) 

    return posizioneNulleMatrice

def caricoMax(matrice:list[list[int]]) -> tuple[int|str, int|str]:
    dimensioneMatrice:int = len(matrice)
    massimoCarico:int = None
    posizioneMassimoCarico:tuple[int|str, int|str] = (0,0) 

    for indiceRiga in range (dimensioneMatrice):
        for indiceColonna in range (dimensioneMatrice):
            caricoMatrice = calcolaCarico(matrice,indiceRiga, indiceColonna)
            if massimoCarico is None or  caricoMatrice > massimoCarico:
                massimoCarico = caricoMatrice
                posizioneMassimoCarico = (indiceRiga,indiceColonna)

    print(f"Il massimo carico della Matrice è la seguente: {massimoCarico}")
    print(f"La posizione del carico massimo è la seguente :{posizioneMassimoCarico}")
    
    return posizioneMassimoCarico  

def caricoMin(matrice:list[list[int]]) -> int|tuple[int,int]:  
    dimensioneMatrice = len(matrice)
    caricoMinimo = None
    posizioneMatrice = None

    for r in range(dimensioneMatrice):
        for c in range(dimensioneMatrice):
            caricoTotale:int = calcolaCarico(matrice,r,c)
            if caricoMinimo is None or caricoTotale < caricoMinimo:  
                caricoMinimo = caricoTotale
                posizioneMatrice = (r,c)
    
    '''Ritorniamo come chiesto dall'esercizio prima il CARICO MINIMO poi successivamente la posizione delle matrici r e c'''
    print(f"Il CARICO MINIMO della matrice è il seguente: {caricoMinimo}")
    return posizioneMatrice

def main():
    dimensioneMatrice:int = 5 
    matrice = genera(dimensioneMatrice)

    print("\nLa matrice generata è la seguente: ")
    printMAT(matrice)

    posizioneNulleMatrice = caricoNullo(matrice)
    print(f"Il numero delle posizioni del carico nullo è pari ad : {len(posizioneNulleMatrice)}\n") 
    print(f"Mentre le posizioni a carico nullo sono: {posizioneNulleMatrice}")

    rmax, cmax = caricoMax(matrice)
    print(f"L'indice del carico massimo è pari ad: r = {rmax}, c = {cmax}")
    print(f"La verifica del carico massimo è pari ad: {calcolaCarico(matrice, rmax, cmax)}\n")
    
    rmin, cmin = caricoMin(matrice)
    print(f"L'indice carico minimo è pari ad: r = {rmin}, c = {cmin}")
    print(f"La verifica carico minimo è pari ad: {calcolaCarico(matrice, rmin, cmin)}")

'''Richiamiamo la funzione MAIN per il test del CODICE DRIVER'''
main()
