'''
2. Guess the Number Game:

    Create a function that generates a random number within a range specified by the user.
    Prompt the user to guess the number within a specified maximum number of attempts.
    Provide feedback to the user after each guess, indicating whether their guess is too high, too low, or correct.
    Terminate the loop when the user guesses the number correctly or reaches the maximum number of attempts.

'''
#Importiamo la libreria RANDOM per scolgere questo esercizio, e iniziamo con il definire la funzione chiedendo il numero e verificando se sia CORRETTO, ALTO o BASSO. 
import random

def randomNumbers()-> None:
    number = random.randint(range_num_1, range_num_2)

    for i in range(attemps):
        guess = int(input("\n\nWhich number do you THINK is correct? "))

        if guess == number:
            print("\nCORRECT! The number is", number)
            return 

        elif guess > number:
            print("\nThe number you inserted is too HIGH")
        
        elif guess < number:
            print("\nThe number you inserted is too LOW")

   #Infine, mostriamo al giocatore il messaggio del numero RANDOM generato, tra i due range inseriti dall'utente 
    print(f"\n\nGame Over! The correct number from {range_num_1} to {range_num_2} was {number}")

#Chiediamo all'utente l'inserimento delle varie variabili, chiedendo i due limiti e il numero dei tentativi
range_num_1 = int(input("\nWelcome! Write the starting number of the range: "))
range_num_2 = int(input("\nNow, write the ending number: "))
attemps = int(input("\nNow, write the number of attempts: "))

#Infine richiamo nuovamente la funzione, per l'avvio del 'GIOCO'
randomNumbers()
