'''
4-15. Code Review: Choose three of the programs you’ve written in this chapter and modify each one to comply with PEP 8.

'''

'''

| MODIFICHE EFFETTUTATE - PRIMO ESERCIZIO 4_7:  Modifiche effettuate: Ho rinominato list_three in list_of_threes per maggiore chiarezza. 
Ho aggiunto un commento che spiega l'uso di range() e i relativi passi.|


Codice:  '''


'''
# 4-7. Threes: Crea una lista dei multipli di 3, da 3 a 30.
# Usa un ciclo for per stampare i numeri nella tua lista.

# Creiamo una lista di multipli di 3 da 3 a 30, utilizzando il terzo argomento di range()
list_of_threes = list(range(3, 31, 3))  # range(3, 31, 3) inizia da 3 e arriva fino a 30 con un passo di 3

# Usiamo un ciclo for per stampare ogni numero nella lista
for number in list_of_threes:
    print(f"Il valore è di: {number}")



'''

'''

| MODIFICHE EFFETTUTATE - SECONDO ESERCIZIO 4_6: Ho rinominato odd_numbers in odd_numbers_list per maggiore chiarezza.
Ho aggiornato i commenti per migliorarne la chiarezza. Ho corretto lo spazio attorno alla funzione range() e altri piccoli problemi di spaziatura.|


Codice:  '''


'''
# 4-6. Odd Numbers: Usa il terzo argomento della funzione range() per creare una lista 
# dei numeri dispari da 1 a 20. Usa un ciclo for per stampare ogni numero.

# Creiamo una lista di numeri dispari da 1 a 20 utilizzando il terzo argomento di range()
odd_numbers_list = list(range(1, 21, 2))  # Il terzo argomento "2" fa sì che vengano presi solo i numeri dispari

# Stampiamo un'intestazione per maggiore chiarezza
print("\n\n| DI SEGUITO I VALORI DISPARI DA 1 A 20, UTILIZZANDO IL CICLO FOR |\n\n")

# Usiamo un ciclo for per stampare ogni numero della lista
for number in odd_numbers_list:
    print(f"Questo è il valore: {number}")



'''


'''

| MODIFICHE EFFETTUTATE - TERZO ESERCIZIO 4_5: Ho rinominato milion in million_list per rendere meglio l'idea di cosa contiene la variabile.
Ho corretto la convenzione di denominazione delle variabili e delle funzioni.
Ho migliorato la leggibilità regolando la spaziatura tra le righe. |


Codice:  '''


'''
# 4-5. Summing a Million: Crea una lista dei numeri da uno a un milione, 
# e poi usa min() e max() per verificare che la tua lista inizi effettivamente da uno e finisca a un milione. 
# Inoltre, usa la funzione sum() per vedere quanto velocemente Python può sommare un milione di numeri.

# Creiamo una lista di numeri da 1 a 1.000.000
million_list = list(range(1, 1000001))

# Utilizziamo min() per trovare il numero più piccolo nella lista
print("Il numero MINIMO è:", min(million_list))

# Utilizziamo max() per trovare il numero più grande nella lista
print("Il numero MASSIMO è:", max(million_list))

# Utilizziamo sum() per calcolare la somma di tutti i numeri nella lista
print("La somma dei numeri è:", sum(million_list))


'''







