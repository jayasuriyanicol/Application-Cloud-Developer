'''
5-5. Alien Colors #3: Turn your if-else chain from Exercise 5-4 into an if-elif-else chain.

• If the alien is green, print a message that the player earned 5 points.
• If the alien is yellow, print a message that the player earned 10 points.
• If the alien is red, print a message that the player earned 15 points.
• Write three versions of this program, making sure each message is printed for the appropriate color alien.

'''

'''|CASO IN CUI L'ALIELO È VERDE|'''

# Versione che esegue il blocco if (colore alieno: verde)
alien_color = 'green'  # Inizializzo la variabile alien_color con 'green'

# Verifica se il colore dell'alieno è verde
if alien_color == 'green':
    print("Hai appena guadagnato 5 punti per aver ucciso l'alieno!")
# In caso contrario (se il colore non è verde), esegue il blocco else
else:
    print("Hai appena guadagnato 10 punti per aver ucciso l'alieno!")


'''|CASO IN CUI L'ALIENO NON È VERDE (MA È GIALLO)|'''

# Versione che esegue il blocco elif (colore alieno: giallo)
alien_color = 'yellow'  # Inizializzo la variabile alien_color con 'yellow'

# Verifica se il colore dell'alieno è verde
if alien_color == 'green':
    print("Hai appena guadagnato 5 punti per aver ucciso l'alieno!")
# Se il colore è giallo, esegue il blocco elif
elif alien_color == 'yellow':
    print("Hai appena guadagnato 10 punti per aver ucciso l'alieno!")
# In caso contrario (se il colore non è verde né giallo), esegue il blocco else
else:
    print("Hai appena guadagnato 15 punti per aver ucciso l'alieno!")


'''|CASO IN CUI L'ALIENO NON È VERDE O GIALLO (MA È ROSSO)|'''

# Versione che esegue il blocco else (colore alieno: rosso)
alien_color = 'red'  # Inizializzo la variabile alien_color con 'red'

# Verifica se il colore dell'alieno è verde
if alien_color == 'green':
    print("Hai appena guadagnato 5 punti per aver ucciso l'alieno!")
# Se il colore è giallo, esegue il blocco elif
elif alien_color == 'yellow':
    print("Hai appena guadagnato 10 punti per aver ucciso l'alieno!")
# In caso contrario (se il colore non è né verde né giallo), esegue il blocco else
else:
    print("Hai appena guadagnato 15 punti per aver ucciso l'alieno!")
