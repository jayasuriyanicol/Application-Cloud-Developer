'''
5-3. Alien Colors #1: Imagine an alien was just shot down in a game. 
Create a variable called alien_color and assign it a value of 'green', 'yellow', or 'red'.
• Write an if statement to test whether the alien’s color is green. If it is, print a message that the player just earned 5 points.
• Write one version of this program that passes the if test and another that fails. (The version that fails will have no output.)

'''




# Versione che supera il test if
alien_color = 'green'  # Puoi cambiare il colore qui per testare il programma

if alien_color == 'green':
    print("Hai appena guadagnato 5 punti!")


# Versione che non supera il test if
alien_color = 'yellow'  # Puoi cambiare il colore qui per testare il programma

if alien_color == 'green':
    print("Hai appena guadagnato 5 punti!")






'''
#|METODO ALTERNATIVO|
#Inizializzo la variabile punti a 0 e messaggio input per l'inserimento del colore dell'ALIENO
points = 0
alien_color: str = str(input("Benvenuto, inserisci il colore dell'ALIENO che ti ha ucciso: "))

# Questo fallirà se il colore dell'alieno non è 'green'
if alien_color == "green":
    points += 5
    print("Hai appena GUADAGNATO 5 punti !")

# Per yellow o red, il programma stampa un messaggio ma non modifica i punti
if alien_color == "yellow":
    print("Grazie, di aver inserito il colore dell'alieno che ti ha ucciso !")
    None

if alien_color == "red":
    print("Grazie, di aver inserito il colore dell'alieno che ti ha ucciso !")
    None
'''