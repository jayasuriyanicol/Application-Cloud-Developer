import numpy as np


def main():
    matrix = np.array([

       [1, 2, 3],
       [4, 5, 6],
       [7, 8, 9] 
    
    ] )

    print("Matrice di partenza: ")
    print(matrix)


    print("\nMatrice Trasposta: ")

    transposedMatrix = matrix.T
    print(transposedMatrix)


if __name__ == '__main__':
   main()

