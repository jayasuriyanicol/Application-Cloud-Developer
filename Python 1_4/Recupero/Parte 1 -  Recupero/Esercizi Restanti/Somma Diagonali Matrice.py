'''
Somma delle Diagonali di una Matrice (Quadrata o
Rettangolare)
Data una matrice 2D (lista di liste) di interi con dimensioni n X n, scrivi due funzioni:
1. sum_primary_diagonal(matrix) che restituisce la somma della “diagonale
primaria” (dall’angolo in alto a sinistra verso il basso a destra).
2. sum_secondary_diagonal(matrix) che restituisce la somma della “diagonale
secondaria” (dall’angolo in alto a destra verso il basso a sinistra).
Requisiti:
● Entrambe le funzioni accettano una lista di liste.
● Restituisci un intero per ciascuna funzione.
Esempi:
mat1 = [
[1, 2, 3],
[4, 5, 6],
[7, 8, 9]
]
sum_primary_diagonal(mat1) # restituisce 1 + 5 + 9 = 15
sum_secondary_diagonal(mat1) # restituisce 3 + 5 + 7 = 15


'''


'''
In alternativa come soluzione possiamo giungere a quest'altro codice:

Soluzione:

def diag(m: list[list[int]]) -> int:
     
    sommaPrimaDiagonale:int = 0
    sommaSecondaDiagonale:int = 0
     
    for elemento in range (len(m)):
    
    sommaPrimaDiagonale += m[i][i]  
    sommaSecondaDiagonale += m[i][len(m) - 1 - i] 


"192.168.1.1"
def check(ip:str)-> bool:

    ip: list[str]  = ip.split(".")

    if len(ip) != 4:
       return False
    
    for componente in ip:
       
        if not component.isdigit() or (0 <= int (componente) <=255) : 
            
           return False
        
    return True

    


        

        
        
     
        
        
    




'''

#Definiamo una funzione che calcola la somma degli elementi sulla diagonale principale (dall'alto a sinistra al basso a destra)
def sum_primary_diagonal(matrix) -> int:

    #Calcoliamo la lunghezza della matrice (numero di righe/colonne, essendo quadrata)
    lunghezzaMatrice = len(matrix)
    sommaPrimaDiagonale = 0

    #Iteriamo sugli indici della diagonale principale: [0][0], [1][1], [2][2], ...
    for elemento in range(lunghezzaMatrice):
       sommaPrimaDiagonale += matrix[elemento][elemento] 

    return sommaPrimaDiagonale


#Definiamo una funzione che calcola la somma degli elementi sulla diagonale secondaria (dall'alto a destra al basso a sinistra)
def sum_secondary_diagonal(matrix) -> int:

    #Calcoliamo la lunghezza della matrice
    lunghezzaMatrice = len(matrix)
    sommaSecondaDiagonale = 0

    #Iteriamo sugli indici della diagonale secondaria: [0][n-1], [1][n-2], [2][n-3], ...
    for elemento in range(lunghezzaMatrice):
        sommaSecondaDiagonale += matrix[elemento][lunghezzaMatrice - 1 - elemento] 
    
    return sommaSecondaDiagonale


'''DRIVER PROGRAM - Eseguiamo il test sulle due funzioni con una matrice 3x3 '''


mat1 = [
[1, 2, 3],
[4, 5, 6],
[7, 8, 9]
]

print(sum_primary_diagonal(mat1))     
print(sum_secondary_diagonal(mat1))   
