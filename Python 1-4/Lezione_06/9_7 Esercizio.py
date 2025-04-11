'''
9-7. Admin: An administrator is a special kind of user. 
Write a class called Admin that inherits from the User class you wrote in Exercise 9-3 or Exercise 9-5. 
Add an attribute, privileges, that stores a list of strings like "can add post", "can delete post", "can ban user", and so on. 
Write a method called show_privileges() that lists the administrator’s set of privileges. Create an instance of Admin, and call your method. 

'''


#Inizializziamo una classe utente dove andiamo a insreire come attributi all'utente il suo nome e cognome
class User:

    def __init__(self, first_name:str, last_name:str, age:int, email:str, location:str) -> str :
      
      self.first_name = first_name
      self.last_name =  last_name
      self.age = age
      self.email  = email
      self.location = location
#Creiamo un metodo chiamto descrivi l'utente, in cui inseriamo e descriviamo il nome e il cognome dell'utente in questione con gli altri relativi dati
    def describe_user (self):
       
       print(f"\nIl nome dell'utente è: {self.first_name.upper()} mentre il suo cognome è: {self.last_name.upper()}, l'utente ha un età di: {self.age} anni.\nLa sua EMAIL personale è la seguente: {self.email} e attualmente vive a : {self.location}.")
    
#Inoltre, andiamo a creare un'ulteriore metodo che si congratula con l'utente
    def greet_user(self):
        print(f"\nBenvenuto {self.last_name.upper()} ! Ci congratuliamo con te {self.first_name.upper()} per essere qui con noi nell'Azienda di Reenbac !")


#Creiamo un'altra classe chimata ADMIN come richiesto dall'esercizio che viene eriditata da USER 
class Admin (User):
   
   def __init__(self,first_name:str, last_name:str, age:int, email:str, location:str, privileges:list) -> str|int|list:
      
      super().__init__(first_name,last_name,age,email,location)
      self.privileges = privileges


  #Contiene un metodo che stampa tutti i privilegi nella lista 'PRIVILEGES' uno per uno
   def show_privileges(self):
       
     print("\nQuesti sono i privilegi che ha a disposizione come ADMIN:\n")
     for privilage in self.privileges:

        print(f"- {privilage}")

#Andiamo a indicare i vari attributi e prpocediamo con la stampa dei metodi dell'utente e del relativo ADMIN con i suoi privilegi, e successivamente richiamiamo le funzioni 
utente_1 : User = User ("Nicol" , "Jayasuriya", 20,  "jayasuiryanicol28@gmail.com", "Vienna, Austria")
utente_admin : Admin = Admin ("Nicol" , "Jayasuriya", 20,  "jayasuiryanicol28@gmail.com", "Vienna, Austria",["Può creare un nuovo utente", "Può gestire i Fondi", "Può eliminare/sopsendere un utente"] )


utente_1.describe_user()
utente_1.greet_user()


utente_admin.show_privileges()
