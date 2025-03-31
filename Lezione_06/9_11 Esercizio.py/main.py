'''
There is the PROGRAM 9_8 Esercizio.py of the LASTEST RESTAURANT PROGRAM:

Questa parte reppresenta la parte dove facciamo la parte MAIN, ovvero recupoeriamo i dati dal file 'users.py' dove sono presenti le nostre funzioni
tramite il FROM e recuperiamo le due funzioni che ci interessano che sono le funzioni di 'describe' e 'greet' come richiamandole e riportando 
le chiamate a funzioni precedenti possiamo vedere come esse funzionino.

'''

from users import User, Admin

# Creazione di un utente normale
utente_1 = User("Nicol", "Jayasuriya", 20, "jayasuiryanicol28@gmail.com", "Vienna, Austria")
utente_1.describe_user()
utente_1.greet_user()

# Creazione di un amministratore con privilegi specifici
admin_1 = Admin("Nicol", "Jayasuriya", 20, "jayasuiryanicol28@gmail.com", "Vienna, Austria",
                ["Può creare nuovi utenti", "Può gestire i fondi", "Può eliminare o sospendere utenti"])

# Stampa i privilegi dell'Admin
admin_1.privileges.show_privileges()
