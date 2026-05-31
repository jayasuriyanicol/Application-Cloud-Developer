'''
1.G Scrivere un codice driver che:

richiamando la funzione genera(), genera una matrice di dimensione 5 x 5 e richiamando la funzione printMAT() stampa tale matrice a schermo;

individua quante posizioni sono a carico nullo e quali sono, stampandole a schermo, ricorrendo alla funzione caricoNullo();

stampi a schermo gli indici riga rmax e colonna cmax per cui si ha il carico massimo della matrice. Ricorrendo alla funzione calcolaCarico(), stampare il carico della matrice k(rmax, cmax) per verificare che tale carico sia uguale a quello stampato in output dalla funzione caricoMax();

stampi a schermo gli indici riga rmin  e colonna cmin per cui si ha il carico minimo della matrice. Ricorrendo alla funzione calcolaCarico(), stampare il carico della matrice k(rmin, cmin) per verificare che tale carico sia uguale a quello stampato in output dalla funzione caricoMin().


'''


'''Implementiamo il CODICE DRIVER '''


def main():

    dimensioneMatrice:list[list[int,int]] = 5
    matrice = genera(dimensioneMatrice)#type:ignore 

    print("La matrice generata è la seguente: ")
    printMAT(matrice)#type:ignore 


    posizioneNulleMatrice= caricoNullo(matrice)#type: ignore
    print(f"Il numero delle posizioni del carico nullo è pari ad : {len(posizioneNulleMatrice)}\n") 
    print(f"Mentre le posizioni a carico nullo sono: {posizioneNulleMatrice}")


    rmax, cmax = caricoMax(mat)#type: ignore
    print(f"L'indice del carico massimo è pari ad: r = {rmax}, c = {cmax}")
    print(f"La verifica del carico massimo è pari ad: {calcolaCarico(mat, rmax, cmax)}\n")#type: ignore
    
    rmin, cmin = caricoMin(mat)#type: ignore
    print(f"L'indice carico minimo è pari ad: r = {rmin}, c = {cmin}")#type: ignore
    print(f"La verifica carico minimo è pari ad: {calcolaCarico(mat, rmin, cmin)}")#type: ignore


'''Richiamiamo la funzione MAIN per il test del CODICE DRIVER'''
main()