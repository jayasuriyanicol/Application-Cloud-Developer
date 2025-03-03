'''
Esercizio 3C-6. Modificare il codice dell'esercizio 3C-4, affinchè si possa scrivere un codice python che consenta all'utente di inserire 
il nome di un animale ed un habitat. 
Quando il codice dell'esercizo 3C-4 classifica l'animale inserito in una delle categorie tra mammiferi, rettili, uccelli o pesci, oltre a mostrare 
un messaggio a schermo, deve salvare tale categoria in una variabile animal_type. Se l'animale inserito non è classificabile in una 
delle quattro categorie proposte, il valore di animal_type sarà ' "unknown".

Inserire, poi, in un dizionario il nome dell'animale, la categoria a cui esso appartiene (animal_type) e l'habitat.

Verificare con un match statement se l'animale e la categoria a cui esso appartiene possano vivere nell'habitat inserito; dunque, verificare:
- se l'animale può vivere nell'habitat specificato, stampare un messaggio appropriato.
- se l'habitat non è compatibile con l'habitat specificato, stampare un avviso.
- Se l'animale o l'habitat non sono riconosciuti, stampare un messaggio di errore.

Le categorie di classificazione devono essere:
- Mammiferi: cane, gatto, cavallo, elefante, leone, balena, delfino.
- Rettili: serpente, lucertola, tartaruga, coccodrillo.
- Uccelli: aquila, pappagallo, gufo, falco, cigno, anatra, gallina, tacchino.
- Pesci: squalo, trota, salmone, carpa.

Categorie di habitat:
- acqua
- aria
- terra

NOTA.
Il codice deve produrre un risultato sensato, ovvero che l'animale inserito possa effettivamente vivere nell'habitat specificato.
Tenere in considerazione il fatto che alcuni animali tra quelli specificati possono vivere in più di un habitat, mentre altri solo in uno.

Suggeirmento: può essere utile per coprire tutti i possibili casi implementare istruzioni match annidate.

Expected Output:

Digita il nome di un animale: leone
Digita l'habitat in cui vive l'animale leone: terra
Output:
Leone appartiene alla categoria dei Mammiferi!
L'animale leone è uno dei mammiferi che può vivere sulla terra!

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: balena
Digita l'habitat in cui vive l'animale balena: acqua
Output:
Balena appartiene alla categoria dei Mammiferi!
L'animale balena è uno dei mammiferi che può vivere in acqua!

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: delfino
Digita l'habitat in cui vive l'animale delfino: terra
Output:
Delfino appartiene alla categoria dei Mammiferi!
Non ho mai visto l'animale delfino vivere nell'habitat terra.

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: drago
Digita l'habitat in cui vive l'animale drago: aria
Output:
Non so dire in quale categoria classificare l'animale drago!
Non sono in grado di fornire informazioni sull'habitat aria.
 

'''

#Messaggio per l'inserimento delle variabili ANIMALE e HABITAT dell'animale
animale = input("\nBenvenuto! Inserisci il nome di un animale: ").lower()
habitat = input(f"\nInserisci l'habitat in cui vive l'animale {animale}: ").lower()

#Elenco delle diverse specie di animale presenti, classificate uno per uno
Mammiferi = {"cane", "gatto", "cavallo", "elefante", "leone", "balena", "delfino"}
Rettili = {"serpente", "lucertola", "tartaruga", "coccodrillo"}
Uccelli = {"aquila", "pappagallo", "gufo", "falco", "cigno", "anatra", "gallina", "tacchino"}
Pesci = {"squalo", "trota", "salmone", "carpa"}

#Categorie di HABITAT presentti dichiarate nella consegna
habitat_possibili = {"acqua", "aria", "terra"}

#Ciclo IF-ELIF-ELSE per la classificazione e inserimento dell'animale nella variabile ANIMAL_TYPE dove salviamo la categoria dell'animale in questione
if animale in Mammiferi:
    animal_type = "Mammiferi"
elif animale in Rettili:
    animal_type = "Rettili"
elif animale in Uccelli:
    animal_type = "Uccelli"
elif animale in Pesci:
    animal_type = "Pesci"
else:
    animal_type = "Unknown"

#Caso in cui abbiamo l'input SCONOSCIUTO, con relativi messaggi
if animal_type == "Unknown":
    print(f"Non so dire in quale categoria classificare l'animale {animale}!")
    print(f"Non sono in grado di fornire informazioni sull'habitat {habitat}.")
   
#Caso in cui l'HABITAT non corrisponde all'habitat selezionato
elif habitat not in habitat_possibili:
    print(f"L'habitat {habitat} non è riconosciuto. Inserisci 'ACQUA', 'TERRA' o 'ARIA'.")

#In caso in cui non corrisponde a nessuno di questi criteri SCONOSCIUTI, prosegue con i diversi casi del MATCH, passiamo come varibili: ANIMAL_TYPE e HABITAT
else:
    match (animal_type, habitat):

        #Caso MAMMIFERI, con i vari casi dell'HABITAT: terra e acqua
        case ("Mammiferi", "terra") if animale in {"cane", "gatto", "cavallo", "elefante", "leone"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} è uno dei mammiferi che può vivere sulla terra!")

        case ("Mammiferi", "acqua") if animale in {"balena", "delfino"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} è uno dei mammiferi che può vivere in acqua!")

        #Caso RETTILI, con i vari casi dell'HABITAT: terra e acqua
        case ("Rettili", "terra") if animale in {"serpente", "lucertola", "tartaruga", "coccodrillo"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può vivere sulla terra!")

        case ("Rettili", "acqua") if animale in {"tartaruga", "coccodrillo"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può vivere in acqua!")

        #Caso PESCI, in questo caso rimane l'HABITAT acqua dato che non ci sono pesci che sopravvivano al di fuori di essa

        #In più in questo CASE non andiamo a inserire la condizione if chiedendo se è presente nella LISTA, 
        #dato che sappiamo per cverto che essi no sopravvivono al di fuori dell'HABITAT ACQUA. 
        case ("Pesci", "acqua"):
        
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può vivere in acqua!")

        #Caso UCCELLI, con i vari casi dell'HABITAT: aria, terra e acqua
        case ("Uccelli", "aria") if animale in {"aquila", "falco", "pappagallo"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può volare in aria!")

        case ("Uccelli", "terra") if animale in {"pappagallo", "gallina", "tacchino"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può vivere sulla terra!")

        case ("Uccelli", "acqua") if animale in {"cigno", "anatra"}:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nL'animale {animale} può vivere in acqua!")

        # Caso ERRORE, quando un ANIMALE presente nelle CATEGORIE non corrisponmde all'HABITAT
        case _:
            print(f"\n{animale.upper()} appartiene alla categoria dei {animal_type}!")
            print(f"\nNon ho mai visto l'animale {animale} vivere nell'habitat {habitat}.")

print(habitat)