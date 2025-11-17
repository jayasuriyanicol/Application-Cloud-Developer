'''
9-8. Privileges: Write a separate Privileges class. The class should have one attribute, privileges, that stores a list of strings as described 
in Exercise 9-7.
Move the show_privileges() method to this class. 
Make a Privileges instance as an attribute in the Admin class. Create a new instance of Admin and use your method to show its privileges.
'''

# Inizializziamo una classe utente dove andiamo a inserire come attributi all'utente il suo nome e cognome
class User:
    def __init__(self, first_name: str, last_name: str, age: int, email: str, location: str) -> None:
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.email = email
        self.location = location

    # Metodo che descrive l'utente
    def describe_user(self) -> None:
        print(f"\nIl nome dell'utente è: {self.first_name.upper()} mentre il suo cognome è: {self.last_name.upper()}, "
              f"l'utente ha un'età di: {self.age} anni.\nLa sua EMAIL personale è: {self.email} e attualmente vive a : {self.location}.")

    # Metodo che saluta l'utente
    def greet_user(self) -> None:
        print(f"\nBenvenuto {self.last_name.upper()}! Ci congratuliamo con te {self.first_name.upper()} per essere qui con noi nell'Azienda di Reenbac!")

# Classe Privileges che gestisce i privilegi
class Privileges:
    def __init__(self, privileges: list) -> list:
        self.privileges = privileges

    # Metodo che mostra i privilegi
    def show_privileges(self) -> str:
        print("\nQuesti sono i privilegi che ha a disposizione come ADMIN:\n")
        for privilege in self.privileges:
            print(f"- {privilege}")

# Classe Admin che eredita da User e contiene un'istanza di Privileges
class Admin(User):
    def __init__(self, first_name: str, last_name: str, age: int, email: str, location: str, privileges: list) -> None:
        super().__init__(first_name, last_name, age, email, location)
        # Creiamo un'istanza della classe Privileges all'interno di Admin
        self.privileges = Privileges(privileges)

# Creazione dell'utente e dell'admin con i privilegi
utente_1 = User("Nicol", "Jayasuriya", 20, "jayasuiryanicol28@gmail.com", "Vienna, Austria")
utente_admin = Admin("Nicol", "Jayasuriya", 20, "jayasuiryanicol28@gmail.com", "Vienna, Austria", 
                     ["Può creare un nuovo utente", "Può gestire i fondi", "Può eliminare/sospendere un utente"])

# Stampa le informazioni dell'utente
utente_1.describe_user()
utente_1.greet_user()

# Mostra i privilegi dell'Admin
utente_admin.privileges.show_privileges()
