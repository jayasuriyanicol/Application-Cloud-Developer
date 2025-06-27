'''
1.B Scrivere una funzione printMAT(), che data in input una matrice, la stampa in output, in modo tale che ogni elemento della matrice 
occupi in output 5 caratteri
'''


def printMAT(matrice:list[list[int]]) -> list[list[int]]:
    
    for riga in matrice:

        for elemento in riga:

            print(f"''.join {elemento:5}" )
    print()


'''

# 1.D - trova tutte le posizioni a carico nullo
def caricoNullo(mat):
    dim = len(mat)
    posizioni_nulle = []
    for r in range(dim):
        for c in range(dim):
            if calcolaCarico(mat, r, c) == 0:
                posizioni_nulle.append((r, c))
    return posizioni_nulle

# 1.E - trova la posizione con carico massimo
def caricoMax(mat):
    dim = len(mat)
    max_carico = None
    posizione = None
    for r in range(dim):
        for c in range(dim):
            carico = calcolaCarico(mat, r, c)
            if max_carico is None or carico > max_carico:
                max_carico = carico
                posizione = (r, c)
    print(f"Carico massimo: {max_carico}")
    return posizione

# 1.F - trova la posizione con carico minimo
def caricoMin(mat):
    dim = len(mat)
    min_carico = None
    posizione = None
    for r in range(dim):
        for c in range(dim):
            carico = calcolaCarico(mat, r, c)
            if min_carico is None or carico < min_carico:
                min_carico = carico
                posizione = (r, c)
    print(f"Carico minimo: {min_carico}")
    return posizione

# 1.G - codice driver
def main():
    dim = 5
    mat = genera(dim)
    
    print("Matrice generata:")
    printMAT(mat)
    
    posizioni_nulle = caricoNullo(mat)
    print(f"Numero di posizioni a carico nullo: {len(posizioni_nulle)}")
    print("Posizioni a carico nullo:", posizioni_nulle)
    
    rmax, cmax = caricoMax(mat)
    print(f"Indice carico massimo: r = {rmax}, c = {cmax}")
    print(f"Verifica carico massimo: {calcolaCarico(mat, rmax, cmax)}\n")
    
    rmin, cmin = caricoMin(mat)
    print(f"Indice carico minimo: r = {rmin}, c = {cmin}")
    print(f"Verifica carico minimo: {calcolaCarico(mat, rmin, cmin)}")

# Esecuzione
main()




'''