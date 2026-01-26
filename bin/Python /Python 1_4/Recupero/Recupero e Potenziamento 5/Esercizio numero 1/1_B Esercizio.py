'''
1.B Scrivere una funzione printMAT(), che data in input una matrice, la stampa in output, in modo tale che ogni elemento della matrice 
occupi in output 5 caratteri
'''


def printMAT(matrice:list[list[int]]) -> list[list[int]]:
    
    for riga in matrice:

        for elemento in riga:

            print(f"''.join {elemento:5}" )
    print()

