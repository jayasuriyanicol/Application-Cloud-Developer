'''
1.E Scrivere una funzione caricoMax(), che data in input una matrice restituisce una tupla di indici r e c per i quali si ha il carico massimo della matrice. 
Ovvero, dovete trovare la coppia di indice riga r e indice colonna c per cui il carico k(r,c) ha valore massimo. Prima di restituire la tupla di indici (r,c) 
stampare il valore del carico massimo.

'''


def caricoMax(matrice:list[list[int]]) -> tuple[int|str, int|str]:


    dimensioneMatrice:int = len(matrice)

    massimoCarico:int = None
    posizioneMassimoCarico:[int|str, int|str] = None #type: ignore   
    posizioneMassimoCarico:tuple[int|str, int|str]


    for indiceRiga in range (dimensioneMatrice):

       for indiceColonna in range (dimensioneMatrice):

         caricoMatrice = calcolaCarico(matrice,indiceRiga, indiceColonna)

         if massimoCarico is None or  caricoMatrice > massimoCarico:
              
               massimoCarico = caricoMatrice
          
               posizioneMassimoCarico = (indiceRiga,indiceColonna)
        
    print(f"Il massimo carico della Matrice è la seguente:{massimoCarico}")
    print(f"La posizione del carico massimo è la seguente:{posizioneMassimoCarico}")
       


