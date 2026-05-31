'''
3-7. Shrinking Guest List: You just found out that your new dinner table won’t arrive in time for the dinner, 
and now you have space for only two guests.
• Start with your program from Exercise 3-6. 
Add a new line that prints a message saying that you can invite only two people for dinner.
• Use pop() to remove guests from your list one at a time until only two names remain in your list. 
Each time you pop a name from your list, print a message to that person letting them know you’re sorry 
you can’t invite them to dinner.
• Print a message to each of the two people still on your list, letting them know they’re still invited.
• Use del to remove the last two names from your list, so it’s stored in reverse-alphabetical order.
Print the list to show that its order has changed.

'''

# Lista iniziale degli invitati
invited = ["Cristiano Ronaldo", "Will Smith", "Michael Jackson"]

# Messaggio per ogni invitato
for name in invited:
    print(f"\nBenvenuto {name}! Sei invitato alla mia cena.")

# Rimozione di un invitato
no_invited = input("\nC'è qualcuno che non può più venire alla cena? ").title()

if no_invited in invited:
    invited.remove(no_invited)
    print(f"\n{no_invited} è stato RIMOSSO dalla lista con SUCCESSO!")

    # Inserimento nuovo invitato
    new_invited = input(f"\nChi vuoi invitare al posto di {no_invited}? ").title()
    invited.append(new_invited)
    print(f"\n{new_invited} è stato AGGIUNTO alla lista con SUCCESSO!")
else:
    print(f"\n{no_invited} non era nella lista degli invitati.")

# Stampa della lista aggiornata
print("\n--- LISTA INVITATI AGGIORNATA ---")
for name in invited:
    print(f"✅ {name} è invitato alla cena.")

# Nuovi ospiti dopo aver trovato un tavolo più grande
print("\n🔔 HO TROVATO UN TAVOLO PIÙ GRANDE! Aggiungiamo altri ospiti!")

invited.insert(0, "Stefano")
invited.insert(3, "Claudio")

# Inserimento a metà della lista
metà = len(invited) // 2
invited.insert(metà, "Fabio")
invited.append("Carlo")

# Stampa della nuova lista di invitati
print("\n--- NUOVA LISTA DI INVITATI ---")
for guest in invited:
    print(f"🎉 {guest}, sei invitato alla mia cena!")

# Problema con il tavolo: solo 2 ospiti ammessi
print("\n⚠️ CI SCUSIAMO PER IL DISAGIO! Possiamo invitare solo due persone.")

# Rimozione ospiti uno alla volta
while len(invited) > 2:
    ospite = invited.pop()
    print(f"❌ Mi dispiace {ospite}, ma NON sei PIÙ INVITATO ALLA CENA.")

# Conferma degli ultimi due invitati
print("\n✅ INVITATI CONFERMATI:")
for ospite in invited:
    print(f"✔️ {ospite}, sei ancora invitato alla mia cena!")

# Rimozione finale degli ultimi due ospiti in ordine inverso
invited.sort(reverse=True)
del invited[0]
del invited[0]

# Stampa lista finale (vuota)
print("\n🏁 OSPITI FINALI:", invited)
