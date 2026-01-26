'''
Esercizio 1. 

Scrivere in Python una funzione recursivePower che calcola la potenza di un numero utilizzando la ricorsione. La funzione deve ricevere due parametri in input:

    base: il numero da elevare a potenza.
    exponent: l’esponente a cui elevare la base.

Utilizzare, poi, la funzione per calcolare:

    3⁴, ovvero 3 elevato alla potenza di 4. 
    4³ , ovvero 4 elevato alla potenza di 3.
    2⁵, ovvero 2 elevato alla potenza di 5. 
    5², ovvero 5 elevato alla potenza di 2.

'''

#Definiamo una funzione ricorsiva che calcola la funzione ricorsiva di un numero, facciamo prima il caso base se esponente(e) = 0 ogni numero ritorna 1, 
#inseriamo acnhe un caso intermedio ovvero se la base(b) = 0 ritorna 0, altrimenti vado a calcolare in modo ricorsivo il numero.
def recursivePower (b:int,e:int) -> int:

    if e == 0:
        return 1
    elif b== 0:
        return 0
    else:
        return int(b * recursivePower(b, e - 1))

#Richiamia o la funzione come richiesto e calcoliamo la funzione
print("3⁴ =", recursivePower(3, 4))
print("4³ =", recursivePower(4, 3))
print("2⁵ =", recursivePower(2, 5))
print("5² =", recursivePower(5, 2))
