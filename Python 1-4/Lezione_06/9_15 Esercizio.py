'''
9-15. Lottery Analysis: Extend the LotteryMachine class you created in Exercise 9-14.

1. Add a method called simulate_until_win(self, my_ticket) that:

    Accepts a ticket (a list of 4 items).
    Repeatedly draws random tickets using the draw_ticket() method.
    Keeps count of how many attempts it takes until a randomly drawn ticket matches my_ticket.
    Returns the number of attempts and the winning ticket.

2. Create a ticket called my_ticket with 4 numbers or letters from the pool.

3. Use the simulate_until_win() method to simulate how many draws it would take for your ticket to win.

4. Print a message showing:

    Your ticket
    The winning ticket
    How many attempts it took to win
'''

'''----------------------------                        ESERICIZIO NUMERO 9_14                       --------------------------------------------------'''




import random
import string

class LotteryMachine:

   
    def __init__(self):
        self.generation = [str(num) for num in range(10)] + list(string.ascii_letters[:5])  
        self.ticket = [] 
 
    def generationTicket(self):
        self.ticket = random.choices(self.generation, k=4)  
        return self.ticket
   
    def displayTicket(self):
        print("\nIf the values EXACTLY match the winning ticket, you WIN!")
        print("Winning Ticket:", ' '.join(self.ticket))

''' ------------------------------------                ESERCIZOIO 9_15                     ---------------------------------------------------------------------------------'''

#Definiamo una funzione che simula il numero di tentativi di una serie di numeri generata casualmente sia uguale al ticket vincente, mostra in output.
def simulate_until_win(self, my_ticket):
        tentativi = 0
        while True:
            random_ticket = random.choices(self.generation, k=4)
            tentativi += 1
            if random_ticket == my_ticket:
                return tentativi, random_ticket

#Definiamo la funzione lotteria per cercare di minimilizzare l'avvio del codice alla sola chiamata a funzione
def lotteria():
        lottery = LotteryMachine()
        my_ticket = lottery.generationTicket()

        print("Your ticket:     ", ' '.join(my_ticket))

        attempts, winning_ticket = lottery.simulate_until_win(my_ticket)

        print("Winning ticket:  ", ' '.join(winning_ticket))
        print("Attempts needed: ", attempts)


lotteria()


























