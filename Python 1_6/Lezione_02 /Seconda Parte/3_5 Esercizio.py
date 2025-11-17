'''
3-5. Changing Guest List: You just heard that one of your guests can’t make the dinner, so you need to send out a new set of invitations. 
You’ll have to think of someone else to invite.
• Start with your program from Exercise 3-4. 
Add a print() call at the end of your program, stating the name of the guest who can’t make it.
• Modify your list, replacing the name of the guest who can’t make it with 
the name of the new person you are inviting.
• Print a second set of invitation messages, one for each person who is still in your list.

'''
#Lista degli invitati
invited = ["Cristiano Ronaldo", "Will Smith", "Michael Jackson"] 

#Messaggio per ogni invitato presente nella lista
for name in invited:
    message = print(f"Benvenuto {name} ! Sei invitato alla mia cena\n")


no_invited = input("\nC'è qualcuno che non può più venire alla cena? ")

#Rimozione della persona indicata dalla lista invitati
if no_invited in invited:
     invited.remove(no_invited)

     print(f"\n{no_invited} è stato RIMOSSO dalla lista con SUCCESSO !")


new_invited = input(f"\nChi vuoi invitare al posto di {no_invited} ? ")

#Inserimento della nuova persona nella LISTA
invited.append(new_invited)
print(f"\n{new_invited} è stato AGGIUNTO alla lista con SUCCESSO !")


#La lista aggiornata con la PERSONA ELIMINATA ed la nuova PERSONA INSERITA
print("\n DI SEGUITO LA NUOVA LISTA AGGIORNATA !")

for name in invited:
     message=print(f"\nBenvenuto {name} ! Sei invitato alla mia cena")
     









 
