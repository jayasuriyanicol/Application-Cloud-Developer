'''
Esercizio 1 (riscaldamento – facile)

Scrivi una funzione che prenda una lista di numeri e ritorni la media, il massimo e il minimo.

'''

def MediaNumeri(listaNumeri:list[int]) -> int:
    
    lunghezzaLista:int = 0
    sommaElementi:int = 0
    mediaNumero:float = 0
    massimoNumeroLista:int = 0
    minimoNumeroLista:int = 0

    lunghezzaLista = len(listaNumeri)
    massimoNumeroLista = max(listaNumeri)
    minimoNumeroLista = min(listaNumeri)
     

    for numero in listaNumeri:

        sommaElementi += numero

    mediaNumero = sommaElementi / lunghezzaLista

    print(f"\nIl riepilogo della lista fornita -> {listaNumeri} :\n\nMedia -> {mediaNumero}\nMassimo numero -> {massimoNumeroLista}\nMinimo numero -> {minimoNumeroLista}")





MediaNumeri([1,2,3,4,5])
        

    