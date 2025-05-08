'''
8. ATM Machine Simulator:

    Create a function that simulates an ATM machine.
    Initialize an account with a starting balance.
    Allow the user to perform transactions such as deposit, withdraw, and check balance.
    Validate transactions against the account balance and available funds.
    Provide appropriate feedback to the user for each transaction.
'''


#Definiamo una funzione che chiede come prima cosa l'inserimento del credito presente nel proprio account, tramite una variabile globale
def atm_machine():
    global balance  
    balance = float(input("\nInsert now the BALANCE that you have in your account: "))

   #Definiamo l'opzione di versamento, dove andremo a incremnetare il saldo presente nell'account con i vari casi annessi.
    def deposit_account():
        global balance

        print("\nWelcome to the DEPOSIT section of the ATM!")
        
        amount_deposit = float(input("\nPlease enter the amount you want to DEPOSIT: "))
        
       #Verifica se il saldo inserito è negativo 
        if amount_deposit < 0:
            print("\nERROR: Deposit amount cannot be negative!")
            
        #In caso non sia negativo, incrementa la somma versata al saldo già esistente con relativo messaggio.
        else:
            balance += amount_deposit
            print(f"\nSUCCESS! Your new account balance is: {balance:.2f} EURO")
       
       
    
            
        

 
    #Definiamo la seconda opzione per lo scambio di denaro. Verifica se il saldo è conforme e prosegue con lo scmabio decrementando il saldo esistente     
    def withdraw_account():
        global balance
        print("\nWelcome to the WITHDRAW section of the ATM!")
        
        withdraw = float(input("\nPlease enter the amount you want to WITHDRAW: "))
        if withdraw < 0:
                print("\nERROR: Withdraw amount cannot be negative!")
                
        
        elif withdraw > balance:
                print("\nERROR: Insufficient funds!")
            
        else: 
             balance -= withdraw
             print(f"\nSUCCESS! You withdrew {withdraw:.2f} EURO. Your new balance is {balance:.2f} EURO")
        
        

    



   #Definiamo la terza e l'ultima funzione che mostra il saldo presente in output  
    def check_balance_account():
        print("\nWelcome to the CHECK BALANCE section!")
        print(f"\nYour account balance is {balance:.2f} EURO")


   #Riprendiamo la parte della funzione MAIN atm_machine e chiediamo all'utente con un WHILE TRUE quale opzione vuole scegliere finch+ non vuole premere exit. Ogni opzione si ricollegherà alla funzione
    while True:
        selection = input("\nChoose an option: \n1. DEPOSIT\n2. WITHDRAW\n3. CHECK BALANCE\n4. EXIT\n\nEnter your choice: ").strip().lower()

        match selection:
             
          case "1":
            deposit_account()

          case "2":
            withdraw_account()

          case "3":
            check_balance_account()

          case "4":
            print("\nThank you for using the ATM! Goodbye.")
            break
            
          case _:
            print("\nERROR: Invalid choice! Please select a valid option.")


#Richiamiamo la funzione per l'avviamento della funzione atm_machine
atm_machine()