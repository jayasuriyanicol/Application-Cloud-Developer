'''
5-10. Checking Usernames: Do the following to create a program that simulates how websites ensure that everyone has a unique username.
• Make a list of five or more usernames called current_users.
• Make another list of five usernames called new_users. Make sure one or two of the new usernames are also in the current_users list.
• Loop through the new_users list to see if each new username has already been used. 
If it has, print a message that the person will need to enter a new username. 
If a username has not been used, print a message saying that the username is available.
• Make sure your comparison is case insensitive. If 'John' has been used, 'JOHN' should not be accepted. (To do this, you’ll need to make a copy of current_users containing the lowercase versions of all existing users.)

'''
# Lista degli username attuali
current_users = ["Mario", "Giovanni", "Stefano", "John", "Sara"]

# Lista dei nuovi username
new_users = ["Mario", "Sara", "Federica", "Martina", "John"]

# Creiamo una versione dei nomi correnti in minuscolo per comparazioni case insensitive
utenti_lower = [user.lower() for user in current_users]

# Ciclo attraverso i nuovi utenti
for new_user in new_users:
    if new_user.lower() in utenti_lower:
        print(f"\n\nMi dispiace, l'username '{new_user}' è GIÀ STATO PRESO. Per favore scegli un altro nome.")
    else:
        print(f"\n\nL'username '{new_user}' è DISPONIBILE.")
