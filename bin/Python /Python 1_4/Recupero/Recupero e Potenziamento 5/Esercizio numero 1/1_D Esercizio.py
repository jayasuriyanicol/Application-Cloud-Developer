'''
1.D Scrivere una funzione caricoNullo(), che data in input una matrice, restituisce una lista di tuple, dove ogni tupla rappresenta una coppia di indici (r,c) per cui il carico 
della matrice è nullo. 
Ovvero, dovete trovare tutte le righe r e le colonne c per cui il carico della matrice k(r,c)=0 e memorizzare ogni coppia (tupla) in una lista.

'''

def caricoNullo(matrice:list[list[int]]) -> list[tuple[int,int]]:


    dimensioneMatrice:int = len(matrice)

    posizioneNulleMatrice:list[tuple[int,int]] = []   


    for elementoRiga in range(dimensioneMatrice):

        for elementoColonna in range(dimensioneMatrice):

            if caricoNullo(matrice,elementoRiga, elementoColonna):

                posizioneNulleMatrice.append(elementoRiga, elementoColonna)
    return posizioneNulleMatrice


