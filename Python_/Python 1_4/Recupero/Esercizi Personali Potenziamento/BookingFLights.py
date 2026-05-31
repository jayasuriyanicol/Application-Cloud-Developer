'''
4️⃣ Sistema di Prenotazione Voli

Scrivi una funzione:


book_flight(flights: dict[str, list[str]], volo: str, passeggero: str) -> dict[str, list[str]]

Se il volo non esiste, crealo e aggiungi il passeggero.

Se il passeggero è già registrato su quel volo, non aggiungerlo due volte.

Se il volo ha più di 5 passeggeri, stampa "Volo pieno" e non aggiungere altri.

📘 Esempio:

book_flight({"AZ101": ["Anna", "Luca"]}, "AZ101", "Marta")

'''


def book_flight(flights: dict[str, list[str]], volo: str, passeggero: str) -> dict[str, list[str]]:

    if volo in flights:

        if passeggero not in flights[volo]:


            if len(flights[volo]) < 5:
               
               flights[volo].append(passeggero)

            else:
                print("Volo Pieno")

        else:
            print("ERRORE: il passegero è già presente sul volo !")
    
    if volo not in flights:
       
        flights[volo] = [passeggero] 
    

   
    return flights




print(book_flight({"AZ101": ["Anna", "Luca"]}, "AZ101", "Marta"))
print(book_flight({"AZ101": ["Anna", "Luca"]}, "QR143", "Martina"))
print(book_flight({"AZ101": ["Anna", "Luca", "Marta", "Paolo", "Giulia"]}, "AZ101", "Franco"))
print(book_flight({"AZ101": ["Anna", "Luca"]}, "AZ101", "Anna"))