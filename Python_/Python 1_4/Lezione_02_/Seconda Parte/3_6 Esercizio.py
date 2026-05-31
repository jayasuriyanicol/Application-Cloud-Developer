'''
3-6. More Guests: You just found a bigger dinner table, so now more space is available. 
Think of three more guests to invite to dinner.
• Start with your program from Exercise 3-4 or 3-5. 
Add a print() call to the end of your program, informing people that you found a bigger table.
• Use insert() to add one new guest to the beginning of your list.
• Use insert() to add one new guest to the middle of your list.
• Use append() to add one new guest to the end of your list.
• Print a new set of invitation messages, one for each person in your list.

'''
##Lista degli invitati
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
     
    
#Inseriemnto della nuova richiesta dell'esercizio    

print() 

print(f"Ho trovato un tavolo più grande, si uniranno altre persone !")


#Inserimento dei nuovi ospiti

invited.insert(0,"Stefano")
invited.insert(3,"Claudio")


#Calcolo della metà della lista
metà = len(invited )//2

#Inserimento dei nomi a metà precisa della lista
invited.insert(metà, "Fabio")
invited.append("Carlo")

#Messaggio in più delle persone invitate
for guest in invited:
    print(f"Benvenuto {guest}, sei invitato alla mia cena !")