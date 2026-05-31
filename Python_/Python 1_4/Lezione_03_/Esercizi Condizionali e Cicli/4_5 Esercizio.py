'''
4-5. Summing a Million: Make a list of the numbers from one to one million, 
and then use min() and max() to make sure your list actually starts at one and ends at one million. 
Also, use the sum() function to see how quickly Python can add a million numbers.

'''
# Creiamo una lista di numeri da 1 a 1.000.000
milion = list(range(1, 1000001))

# Utilizziamo min() per trovare il numero più piccolo nella lista
print("Il numero MINIMO è:", min(milion))

# Utilizziamo max() per trovare il numero più grande nella lista
print("Il numero MASSIMO è:", max(milion))

# Utilizziamo sum() per calcolare la somma di tutti i numeri nella lista
print("La somma dei numeri è:", sum(milion))
