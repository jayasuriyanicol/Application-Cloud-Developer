'''
5-4. Alien Colors #2: Choose a color for an alien as you did in Exercise 5-3, and write an if-else chain.
• If the alien’s color is green, print a statement that the player just earned 5 points for shooting the alien.
• If the alien’s color isn’t green, print a statement that the player just earned 10 points.
• Write one version of this program that runs the if block and another that runs the else block.

'''

'''|CASO IN CUI L'ALINEO È VERDE|'''

#Versione che esegue il blocco if (colore alieno: verde)
alien_color = 'green'  # Inizializzo la variabile alien_color con 'green'

#Verifica se il colore dell'alieno è verde
if alien_color == 'green':
    print("Hai appena guadagnato 5 punti per aver ucciso l'alieno!")
#In caso contrario (se il colore non è verde), esegue il blocco else
else:
    print("Hai appena guadagnato 10 punti per aver ucciso l'alieno!")


'''|CASO IN CUI L'ALIENO NON È VERDE|'''

#Versione che esegue il blocco else (colore alieno: giallo)
alien_color = 'yellow'  # Inizializzo la variabile alien_color con 'yellow'

#Verifica se il colore dell'alieno è verde
if alien_color == 'green':
    print("Hai appena guadagnato 5 punti per aver ucciso l'alieno!")
#In caso contrario (se il colore non è verde), esegue il blocco else
else:
    print("Hai appena guadagnato 10 punti per aver ucciso l'alieno!")
