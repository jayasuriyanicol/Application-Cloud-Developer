'''
1.A Scrivere una funzione genera() che data in input la dimensione dim della matrice genera una matrice quadrata di dimensione dim x dim, 
ovvero una matrice che ha dim righe e dim colonne. Ogni elemento di questa matrice è un numero random tra 0 e 13. 
Inoltre, in ogni riga, ogni elemento della riga deve essere diverso dal primo elemento della riga stessa.

'''

from random import randint

def genera(dim:int) -> list[list[int]]:

    matrice:list[list[int]] = [] 

    for riga in range (dim):
        riga:list[int] = [] 

        for colonna in range (dim):

            while True:

                numeroRandomicoRiga:int = randint(0,13)

                if colonna == 0:
                    riga.append(numeroRandomicoRiga)
                    break
                if numeroRandomicoRiga != riga[0]:

                    riga.append(numeroRandomicoRiga)
                    break

            matrice.append(riga)





   




