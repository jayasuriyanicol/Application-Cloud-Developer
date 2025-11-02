'''
🧩 Esercizio 1 — Gestione Account Bancari (PUNTI 2)

Scrivi una classe BankAccount per simulare la gestione di un conto corrente.

Requisiti

Attributi:

account_id: str

owner: str

balance: float (saldo, inizialmente 0.0)

Metodi:

deposit(amount: float) -> None
Aggiunge l’importo al saldo. Se amount <= 0, stampa "Importo non valido".

withdraw(amount: float) -> None
Sottrae l’importo dal saldo se sufficiente. Se il saldo non è sufficiente, stampa "Fondi insufficienti".

get_balance() -> float
Restituisce il saldo attuale.

__str__(self)
Restituisce una stringa descrittiva, es.:
"Conto di Mario Rossi - Saldo: 350.0€"

'''

class BankAccount:


        def __init__(self,account_id:str,owner:str) -> None:
                
                self.account_id = account_id
                self.owner = owner
                self.balance:float = 0.0

        def deposit(self,amount:float) -> None:
                
                if amount <= 0:
                 print("Errore: importo non versabile, l'importo è negativo o uguale a 0 !")
                
                else:
                    self.balance += amount

        def withdraw(self,amount:float) -> None:
              
              if amount > self.balance:
                    
                    print("Errore: importo non dispensabile, l'importo supera il saldo del conto")
              else:
                    self.balance -= amount

        def get_balance(self) -> float:
              
              return self.balance
        
        def __str__(self)-> str:
              
              return f'Conto di {self.owner} - Saldo : {round(self.balance,2)} EURO'
                



conto = BankAccount("ACC001", "Mario Rossi")
conto.deposit(500)
conto.withdraw(150)
print(conto.get_balance()) 
print(conto)                 