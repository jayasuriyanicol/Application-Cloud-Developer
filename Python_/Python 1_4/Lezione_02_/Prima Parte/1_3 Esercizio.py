'''
1-3. Si scriva un programma che legge tre numeri interi e visualizza la media dei tre numeri.
'''

#Inizializziamo la somma a 0
somma = 0 

#Utilizziamo un ciclo for per leggere tutti e 3 i numeri
for i in range(3):
    numero = int(input(f"Inserisci il numero intero {i+1}: "))
    somma += numero  #Aggiungi il numero alla somma

#Calcolo della media
media = somma / 3

#Output della media
print(f"La media dei tre numeri è: {media}")