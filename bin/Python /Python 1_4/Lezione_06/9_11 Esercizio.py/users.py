'''

9-11. Imported Admin: Create a module users.py containing three classes:

    User: stores first_name, last_name, username, and email; includes describe_user() and greet_user() methods.
    Privileges: holds a list of privileges and a method show_privileges() to display them.
    Admin: stores a User instance and a Privileges instance as attributes.

In a separate file main.py, import the classes, create a User and a Privileges instance, pass them to Admin, 
and call describe_user() and show_privileges() to verify everything works correctly.


Nel seguente file andiamo a memorizzare la classe USER con tutte le sue FUNZIONI associate che poi verranno richiamate nel file 'main.py'
'''


class User:
    def __init__(self, first_name: str, last_name: str, age: int, email: str, location: str) -> None:
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.email = email
        self.location = location


    def describe_user(self) -> None:
        print(f"\nIl nome dell'utente è: {self.first_name.upper()} mentre il suo cognome è: {self.last_name.upper()}, "
              f"l'utente ha un'età di: {self.age} anni.\nLa sua EMAIL personale è: {self.email} e attualmente vive a : {self.location}.")

    
    def greet_user(self) -> None:
        print(f"\nBenvenuto {self.last_name.upper()}! Ci congratuliamo con te {self.first_name.upper()} per essere qui con noi nell'Azienda di Reenbac!")




class Privileges:
    def __init__(self, privileges: list) -> list:
        self.privileges = privileges


    def show_privileges(self) -> str:
        print("\nQuesti sono i privilegi che ha a disposizione come ADMIN:\n")
        for privilege in self.privileges:
            print(f"- {privilege}")





class Admin(User):
    def __init__(self, first_name: str, last_name: str, age: int, email: str, location: str, privileges: list) -> None:
        super().__init__(first_name, last_name, age, email, location)
        self.privileges = Privileges(privileges)
