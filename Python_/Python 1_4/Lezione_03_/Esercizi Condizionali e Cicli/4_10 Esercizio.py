'''
4-10. Slices: Using one of the programs you wrote in this chapter, add several lines to the end of the program that do the following:
• Print the message The first three items in the list are:. Then use a slice to print the first three items from that program’s list.
• Print the message Three items from the middle of the list are:. Then use a slice to print three items from the middle of the list.
• Print the message The last three items in the list are:. Then use a slice to print the last three items in the list.

'''
#| Prendo in considerazione la LISTA dell'ESERCIZIO numero 4_7 |


# Creiamo una lista di multipli di 3 da 3 a 30, utilizzando il terzo argomento di range()
lista_tre = list(range(3, 31, 3))  # range(3, 31, 3) inizia da 3 e arriva fino a 30 con un passo di 3

# Prendiamo i primi tre elementi della lista
primi_tre_valori = lista_tre[:3]

# Troviamo tre elementi centrali
metà_lista = len(lista_tre) // 2  # Troviamo l'indice centrale
valori_centrali = lista_tre[metà_lista - 1:metà_lista + 2]  # Selezioniamo tre valori attorno al centro

# Prendiamo gli ultimi tre elementi della lista
ultimi_tre_valori = lista_tre[-3:]

# Stampiamo i risultati
print("\nI primi tre elementi della lista sono:", primi_tre_valori)
print("\nTre elementi centrali della lista sono:", valori_centrali)
print("\nGli ultimi tre elementi della lista sono:", ultimi_tre_valori)
