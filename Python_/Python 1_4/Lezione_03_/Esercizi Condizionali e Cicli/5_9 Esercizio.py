'''
5-9. No Users: Add an if test to hello_admin.py to make sure the list of users is not empty.
• If the list is empty, print the message We need to find some users!
• Remove all of the usernames from your list, and make sure the correct message is printed.

'''

# Lista degli username (VUOTA)
usernames = []

# Lista degli username (incluso 'admin')
# usernames = ["admin", "gestore", "moderatore", "impiegato", "segretario"]

# Verifica se la lista è vuota
if not usernames:
    print("We need to find some users!")
else:
    # Ciclo attraverso la lista degli utenti
    for username in usernames:
        if username == "admin":
            print("\nHello admin, would you like to see a status report?")
        else:
            print(f"\nHello {username}, thank you for logging in again.")

