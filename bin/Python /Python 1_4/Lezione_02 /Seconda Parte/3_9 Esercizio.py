'''
3-9. Dinner Guests: Working with one of the programs from Exercises 3, 
use len() to print a message indicating the number of people you’re inviting to dinner.

'''
#INIZIO ESERCIZIO 3_5

#Lista degli invitati
invited = ["Cristiano Ronaldo", "Will Smith", "Michael Jackson"] 

#Messaggio per ogni invitato presente nella lista
print("\n\n|INIZIO ESERCIZIO 3_5|\n\n")
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

print("\n\n|FINE ESERCIZIO 3_5|\n\n")

# FINE ESERCIZIO 3_5

# INZIO NUOVO ESERCIZIO 3_9

#Messaggio con gli invitati totali, includendo nel MESSAGGIO ANCHE L'INIZIO E LA FINE  dell'esercizio come punto
print(f"\n\n|INIZIO NUOVO ESERCIZIO 3_9|\n\nHo preso l'esercizio numero 3_5 come esercizio chiave E QUESTI SONO GLI INVITATI TOTALI: {len(invited)}\n\n|INIZIO NUOVO ESERCIZIO 3_9|\n\n ")

     


