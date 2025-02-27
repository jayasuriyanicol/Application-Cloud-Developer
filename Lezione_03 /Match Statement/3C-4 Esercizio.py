'''

Esercizio 3C-4. Scrivere un programma in Python che permetta all'utente di inserire il nome di un animale e, utilizzando un match statement, 
identifichi a quale categoria esso appartiene. L'animale deve essere classificato in una delle seguenti categorie:

- Mammiferi: cane, gatto, cavallo, elefante, leone.
- Rettili: serpente, lucertola, tartaruga, coccodrillo.
- Uccelli: aquila, pappagallo, gufo, falco.
- Pesci: squalo, trota, salmone, carpa.

Se l'animale non appartiene a nessuna delle categorie sopra elencate,  mostrare un messaggio indicante 
che il programma non è in grado di classificare l'animale inserito.

Suggerimento: Utilizzare una lista per ognuna della quattro categorie.

Expected Output:

Digita il nome di un animale: cane
Output: cane appartiene alla categoria dei Mammiferi!

- - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: coccodrillo
Output: coccodrillo appartiene alla categoria dei Rettili!

- - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: pappagallo
Output: pappagallo appartiene alla categoria degli Uccelli!

- - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: squalo
Output: squalo appartiene alla categoria dei Pesci!

- - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digita il nome di un animale: giraffa
Output: Non so dire in quale categoria classificare l'animale giraffa!

'''
#Messaggio di benvenuto e spiegazione utilizzo del programma, con iserimento della variabile ANIMALE
animale:str=input("\n\nBenvenuto, questo programma dato in input la tipologia di un animale da in OUTPUT la categoria di quest'ultimo.\n\nPrego, inserire la tipoloigia dell'animale: ")


#Creazione delle liste secondo quando richiesto dal problema
Mammiferi:list= ["cane", "gatto", "cavallo", "elefante", "leone"] 
Rettili:list=["serpente","lucertola", "tartaruga", "coccodrillo"]
Uccelli:list= ["aquila", "pappagallo", "gufo", "falco"] 
Pesci:list= ["squalo", "trota", "salmone", "carpa"]


#Creiamo iun match statement per ogni animale in questione, con mesaggio univoco, riportando anche il nome dell'animale.
match animale:
    case animale if animale in Mammiferi:
        print(f"\n{animale.upper()} appartiene alla categoria dei Mammiferi ! ")
    case animale if animale in Rettili:
        print(f"\n{animale.upper()} appartiene alla categoria dei Rettili ! ")
    case animale if animale in Uccelli:
        print(f"\n{animale.upper()} appartiene alla categoria dei Uccelli ! ")
    case animale if animale in Pesci:
        print(f"\n{animale.upper()} appartiene alla categoria dei Pesci ! ")
