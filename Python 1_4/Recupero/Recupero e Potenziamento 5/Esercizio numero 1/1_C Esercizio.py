'''
1.C Scrivere una funzione calcolaCarico(), che dati in input una matrice, un indice riga r ed un indice colonna c, 
calcola e restituisce il carico della matrice k(r,c) per la riga r e la colonna c.  

'''

def calcolaCarico(matrice: list[list[int]], indiceRiga: int, indiceColonna: int) -> int:

    sommaRigheMatrice = 0
    sommaColonneMatrice = 0


    for elemento in matrice[indiceRiga]:
        sommaRigheMatrice += elemento

    for i in range(len(matrice)):
        sommaColonneMatrice += matrice[i][indiceColonna]

    calcoloCaricoMatrice = sommaRigheMatrice - sommaColonneMatrice

    return calcoloCaricoMatrice

   

