'''
Esercizio 3C-10. Scrivere un programma in Python che permetta all'utente di inserire una data (giorno e mese espressi in forma numerica), 
salvi la data in una tupla e utilizzi un match statement per verificare se la data corrisponde a una festività o a un evento speciale:

- Capodanno → 1 Gennaio → "Capodanno"
- San Valentino → 14 Febbraio → "San Valentino"
- Festa della Repubblica Italiana → " Giugno → "Festa della Repubblica Italiana"
- Ferragosto → 15 Agosto → "Ferragosto"
- Halloween → 31 Ottobre → "Halloween"
- Natale → 25 Dicembre → "Natale"
- Altro caso → "Nessuna festività importante in questa data."

Expected Output:

Inserisci il giorno: 25
Inserisci il mese: 12
Output: Il 25/12 è Natale!

- - - - - - - - - - - - - - -

Inserisci il giorno: 5
Inserisci il mese: 3
Output: Nessuna festività importante in questa data.
'''


#Chiedo i dati in input all'utente, ovvero giorno e anno
giorno = int(input("\nBenvenuto, inserisci il giorno: "))
mese = int(input("Inserisci il mese: "))


#Salvo quanto inserito all'internbo di una tupla che chiamo DATA 
data = (giorno,mese)


#Per ogni caso riporto la festività e nel caso DEFAULT, riporto la data inserita con giorno e mese indicando che non corrisponde a nessuna festività
match data:

       case (1,1):
              print("Capodanno !")
       case (14,2):
              print("San Valentino !")
       case (2,6):
              print("Giusto -> 'Festa della Repubblica Italiana !")
       case (15,8):
              print("Ferragosto !")
       case (31,10):
              print("Hallowen")
       case (25,12):
              print("Natale !")
       case (_,_):
              print(f"Nessuna festività importante in questa data inserita 'Il giorno {giorno}, del {mese}° mese dell'anno'")