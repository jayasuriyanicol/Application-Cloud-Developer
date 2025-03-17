'''
9-3. Users: Make a class called User. Create two attributes called first_name and last_name, and then create several other attributes
 that are typically stored in a user profile. Make a method called describe_user() that prints a summary of the user’s information. 
 Make another method called greet_user() that prints a personalized greeting to the user. 
Create several instances representing different users, and call both methods for each user.
'''

#Inizializziamo una classe utente dove andiamo a insreire come attributi all'utente il suo nome e cognome
class User:

    def __init__(self, first_name:str, last_name:str, age:int, email:str, location:str) -> str :
      
      self.first_name = first_name
      self.last_name =  last_name
      self.age = age
      self.email  = email
      self.location = location
#Creiamo un metodo chiamto decsrivi l'utente, in cui inseriamo e descriviamo il nome e il cognome dell'utente in questione
    def describe_user (self):
       
       print(f"\nIl nome dell'utente è: {self.first_name.upper()} mentre il suo cognome è: {self.last_name.upper()}, l'utente ha un età di: {self.age} anni.\nLa sua EMAIL personale è la seguente: {self.email} e attualmente vive a : {self.location}.")
    
#Inoltre, andiamo a creare un'ulteriore metodo che si congratula con l'utente
    def greet_user(self):
        print(f"\nBenvenuto {self.last_name.upper()} ! Ci congratuliamo con te {self.first_name.upper()} per essere qui con noi nell'Azienda di Reenbac !")


#Andiamo a indicare i vari attributi e prpocediamo con la stampa dei metodi
utente_1 : User = User ("Nicol" , "Jayasuriya", 20,  "jayasuiryanicol28@gmail.com", "Vienna, Austria")
utente_2 : User = User ("Nathan" , "Mbuyamba", 21, "mbuyambanathan1@gmail18.com", "Madrid, Spain")
utente_3 : User = User ("Michael" , "Baciarello", 20 ,"baciarellomichael@gmail.com", "Prague, Republic Czech") 


utente_1.describe_user()
utente_1.greet_user()
utente_2.describe_user()
utente_2.greet_user()
utente_3.describe_user()
utente_3.greet_user() 



'''                                           | FUNZIONALITÀ AVANZATA DELL'ESERCIZIO |                                                              '''

'''
class User:
    def __init__(self, first_name, last_name, age, city, email):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.city = city
        self.email = email

    def describe_user(self):
        print("\n--- Profilo Utente ---")
        print(f"Nome: {self.first_name}")
        print(f"Cognome: {self.last_name}")
        print(f"Età: {self.age}")
        print(f"Città: {self.city}")
        print(f"Email: {self.email}")

    def greet_user(self):
        print(f"\nCiao {self.first_name} {self.last_name}, benvenuto/a!")


# Creiamo una lista per memorizzare gli utenti
users = []

# Chiediamo i dati per 3 utenti
for i in range(3):
    print(f"\nInserisci i dati per l'utente {i + 1}:")
    first_name = input("Nome: ")
    last_name = input("Cognome: ")
    age = input("Età: ")
    city = input("Città: ")
    email = input("Email: ")

    # Creiamo un'istanza della classe User e la aggiungiamo alla lista
    user = User(first_name, last_name, age, city, email)
    users.append(user)

# Stampiamo le informazioni di ogni utente
for user in users:
    user.describe_user()
    user.greet_user()
'''