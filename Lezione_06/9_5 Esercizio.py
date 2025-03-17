'''
9-5. Login Attempts: Add an attribute called login_attempts to your User class from Exercise 9-3.
 Write a method called increment_login_attempts() that increments the value of login_attempts by 1. 
 Write another method called reset_login_attempts() that resets the value of login_attempts to 0. 
 Make an instance of the User class and call increment_login_attempts() several times. 
 Print the value of login_attempts to make sure it was incremented properly, and then call reset_login_attempts(). 
 Print login_attempts again to make sure it was reset to 0.

'''


#Creiamo una classe chiamata USER e andiamo a passaere come parametri i vari dati, andando a creare anche il costruttore. passiamo come ultimo attributo un valore di DEFAULT pari a 0 !
class User:
    def __init__(self, first_name: str, last_name: str, age: int, email: str, location: str) -> str|int:
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.email = email
        self.location = location
        self.login_attempts = 0  
#Creiamo un metodo chiamto descrivi l'utente, in cui inseriamo e descriviamo il nome e il cognome dell'utente in questione con altri relativi dati
    def describe_user(self):
        print(f"\nIl nome dell'utente è: {self.first_name.upper()} {self.last_name.upper()}, ha {self.age} anni.\n"
              f"La sua email è: {self.email} e attualmente vive a: {self.location}.")

#Inoltre, andiamo a creare un'ulteriore metodo che si congratula con l'utente
    def greet_user(self):
        print(f"\nBenvenuto {self.last_name.upper()}! Ci congratuliamo con te, {self.first_name.upper()}, "
              f"per essere qui con noi nell'Azienda di Reenbac!")
        
#Come richiesto anche dall'esercizio, vado ad incrementare anche il numero di accessi, che andrò a richiamre più volte successivamente
    def increment_login_attempts(self):
    
        self.login_attempts += 1
        print(f"\nTentativi di login attuali: {self.login_attempts}")
    
#Infine andiamo ad azzerare tutti i varri tentativi di login
    def reset_login_attempts(self):

        self.login_attempts = 0
        print("\nI tentativi di login sono stati azzerati.")

#Andiamo a creare la mia propria istanza
utente_1 = User("Nicol", "Jayasuriya", 20, "jayasuiryanicol28@gmail.com", "Vienna, Austria")

#Andiamo a stampare i relative chiamate a funzioen richieste dall'esercizio precedente
utente_1.describe_user()
utente_1.greet_user()

#Secondo quanto richiesto dal nuovo esercizion andaimo a stampare anche i vari tentativi con chiamate a funzione, mostrando poi l'output finale
utente_1.increment_login_attempts()
utente_1.increment_login_attempts()
utente_1.increment_login_attempts()


print(f"\nTentativi di login totali: {utente_1.login_attempts}")

#Come detto, andimo poi a azzerare i login effettuati, mostrando in OUTPUT
utente_1.reset_login_attempts()
print(f"\nTentativi di login dopo il reset: {utente_1.login_attempts}")
