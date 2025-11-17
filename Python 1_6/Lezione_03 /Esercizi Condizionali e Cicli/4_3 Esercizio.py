'''
4-3. Counting to Twenty: Use a for loop to print the numbers from 1 to 20, inclusive.

'''

# Usiamo un ciclo for per contare da 0 a 20
for numero in range(21):  # range(21) genera numeri da 0 a 20
    print(f"Contiamo fino a VENTI: {numero}!")

    # Quando il numero raggiunge 20, stampiamo un messaggio speciale
    if numero == 20:
        print("Siamo giunti al 20!")
