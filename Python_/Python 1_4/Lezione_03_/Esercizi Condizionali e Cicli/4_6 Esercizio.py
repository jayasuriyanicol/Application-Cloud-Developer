'''
4-6. Odd Numbers: Use the third argument of the range() function to make a list of the odd numbers from 1 to 20. 
Use a for loop to print each number.


'''

# Creiamo una lista di numeri dispari da 1 a 20 utilizzando il terzo argomento di range()
odd_numbers = list(range(1, 21, 2))  # Il terzo argomento "2" fa sì che vengano presi solo i numeri dispari

# Stampiamo un'intestazione per maggiore chiarezza
print("\n\n| DI SEGUITO I VALORI DISPARI DA 1 A 20, UTILIZZANDO IL CICLO FOR |\n\n")

# Usiamo un ciclo for per stampare ogni numero della lista
for number in odd_numbers:
    print(f"Questo è il valore: {number}")



 
 