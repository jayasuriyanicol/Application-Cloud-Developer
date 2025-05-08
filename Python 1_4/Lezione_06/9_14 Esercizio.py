'''
9-14. Lottery: Create a class LotteryMachine that holds a list containing a series of 10 numbers and 5 letters. 
Implement a method to randomly select 4 items (numbers or letters) from this list to draw a winning ticket. 
Finally, implement a method to display a message saying that any ticket matching the winning 4 items wins a prize.

'''


#Importiamo random e string per la generazione del biglietto vincente
import random
import string
#Creiamo una classe chiamata LotteryMachine
class LotteryMachine:

   #Definiamo il costruttore con la generazione di esattamente un massimo di 10 numeri e 4 caratteri. in più la lista dove andremo a memorizzare le variabili
    def __init__(self):
        self.generation = [str(num) for num in range(10)] + list(string.ascii_letters[:5])  
        self.ticket = [] 

   #Attraverso la funzione della generazione andiamo a generare i rispettivi valori, dichiarati precedentemente nel costruttore e ritorniamo la lista  
    def generationTicket(self):
        self.ticket = random.choices(self.generation, k=4)  
        return self.ticket
   #Infine, come richiesto dall'esercizio andiamo a stampare il risultato, con una messaggio prestabilito dall'esercizio 
    def displayTicket(self):
        print("\nIf the values EXACTLY match the winning ticket, you WIN!")
        print("Winning Ticket:", ' '.join(self.ticket))

#Richiamiamo tutte le funzioni della classe LotteryMachine
lottery = LotteryMachine()
lottery.generationTicket()
lottery.displayTicket()
























'''
import random
import string

class LotteryMachine:

    def __init__(self):
        # Genera una lista di 10 numeri e 5 lettere
        self.generation = [str(num) for num in range(10)] + list(string.ascii_uppercase[:5])  # ['0'-'9', 'A'-'E']
        self.ticket = []

    def randomlySelection(self):
        self.ticket = random.sample(self.generation, 4)  # 4 elementi unici
        return self.ticket

    def displayWin(self):
        print("🎉 Any ticket matching the winning 4 items wins a prize!")
        print("🏆 Winning Ticket:", ' '.join(self.ticket))

# Uso della classe
lottery = LotteryMachine()
lottery.randomlySelection()
lottery.displayWin()
'''