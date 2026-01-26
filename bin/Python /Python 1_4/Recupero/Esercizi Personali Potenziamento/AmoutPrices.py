'''
Esercizio 4 (avanzato – gestione dizionari e input)

Scrivi un programma che gestisca le spese mensili di un utente:

Chiedi ripetutamente all’utente di inserire una spesa nel formato
categoria importo (es: spesa 25.50, affitto 500).

Salva le spese in un dizionario, dove la chiave è la categoria e il valore è la somma totale di quella categoria.

Alla fine (quando l’utente scrive fine) mostra:

Il totale di tutte le spese.

La spesa totale per ogni categoria.

La categoria in cui si è speso di più.

Inserisci spesa e importo (es. 'spesa 20.5'), o 'fine' per uscire: spesa 20
Inserisci spesa e importo (es. 'spesa 20.5'), o 'fine' per uscire: affitto 500
Inserisci spesa e importo (es. 'spesa 20.5'), o 'fine' per uscire: spesa 15
Inserisci spesa e importo (es. 'spesa 20.5'), o 'fine' per uscire: fine

Riepilogo spese:
- affitto: 500.0 €
- spesa: 35.0 €
Totale spese: 535.0 €
Categoria con spesa maggiore: affitto (500.0 €)

'''

dizionarioSpese: dict[str, float] = {}
sommaValoriTotale:float = 0
valoreSpesaMassima:list[str,int]  = [] 


while True:

    informazioniUtente:str = input("Benvenuto, Inserisci spesa e importo (es. 'spesa 20.5'), o 'fine' per uscire: ")


    if informazioniUtente.lower() == "fine":
        print("\n\nSUCCESSO ! Hai effettuato il LOG OUT per continuare riavviare il PROGRAMMA")  
        break

    testoSuddiviso:list[str,int]  = informazioniUtente.split(" ")


    if len(testoSuddiviso) != 2:
        print("ATTENZIONE ! Ci devono essere massimo di elementi inoltre deve inserire una categoria e un importo separati da spazio!")
        continue

    chiaveDizionario:str = testoSuddiviso[0]  


    try:
        valoreDizionario:int|float = float(testoSuddiviso[1]) 
         

    except ValueError:
        print("ATTENZIONE ! l'importo deve essere un numero non altro !")
        continue

    #In caso se un elemento è il medesimo 'chiaveDizionario' proseguo sommando direttamente i valori ('valoreDizionario')  
    if chiaveDizionario in dizionarioSpese:
        dizionarioSpese[chiaveDizionario] += round(dizionarioSpese[chiaveDizionario] + valoreDizionario, 2)
    else:
        dizionarioSpese[chiaveDizionario] = round(valoreDizionario,2)

print("\nRiepilogo delle SPESE:\n\n ")
for chiave,valore in dizionarioSpese.items():
    
        print(f"{chiave} : {valore}")


sommaValoriTotale = sum(dizionarioSpese.values())
valoreSpesaMassima = max(dizionarioSpese, key=dizionarioSpese.get)
 
print(f'\nValore delle spese TOTALI: {sommaValoriTotale:.2f} euro')
print(f'\nCategoria con spesa MAGGIORE: {valoreSpesaMassima} ({dizionarioSpese[valoreSpesaMassima]:.2f}) euro ')



        


