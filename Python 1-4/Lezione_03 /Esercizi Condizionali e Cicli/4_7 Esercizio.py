'''
4-7. Threes: Make a list of the multiples of 3, from 3 to 30. Use a for loop to print the numbers in your list.

'''
# Creiamo una lista di multipli di 3 da 3 a 30, utilizzando il terzo argomento di range()
list_three = list(range(3, 31, 3))  # range(3, 31, 3) inizia da 3 e arriva fino a 30 con un passo di 3

# Usiamo un ciclo for per stampare ogni numero nella lista
for number in list_three:
    print(f"Il valore è di: {number}")
