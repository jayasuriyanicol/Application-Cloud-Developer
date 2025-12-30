'''
Esercizio 2.
 
Scrivere un programma in Python che legga dall’utente una serie di nomi di persona (stringhe).
L'inserimento dei nomi deve terminare quando l’utente inserisce un nome già inserito in precedenza, oppure sono stati inseriti 30 nomi distinti. 
Inoltre, si deve porre il vincolo che ciascun nome sia una stringa di lunghezza inferiore a 20 caratteri e che non venga inserita una stringa vuota.

Al termine dell'inserimento, il programma deve:
- stampare quanti nomi sono stati inseriti in totale;
- stampare il nome più lungo tra quelli inseriti;
- stampare la lunghezza del nome più lungo.

Se ci sono più nomi con la stessa lunghezza massima, puoi scegliere uno qualsiasi tra quelli più lunghi.

Esempio:
Inserisci un nome: Dora
Inserisci un nome: Marcella
Inserisci un nome: Teresa
Inserisci un nome: Valentina
Inserisci un nome: Dora
 
Hai inserito 4 nomi distinti.
Il più lungo è Valentina con 9 caratteri.

'''


def inserimentoNomi() -> str|str|int:

    listaInserimentoNomi:list[str] = []
    stringaNome:str = ""


    while True:


        stringaNome = input("Inserisci il nome della persona: ")


        if stringaNome == "" :

            print("ATTENZIONE ! la stringa inserita è vuota")
            continue

        if len(stringaNome) > 20:

            print("ATTENZIONE ! la stringa inserita è maggiore di 20 caratteri")
            continue
    
        
        if stringaNome in listaInserimentoNomi:

            print( "ATTENZIONE ! Il nome inserito è già presente nella lista")
            continue
    
        if len(listaInserimentoNomi) >= 30: 

            print( "ATTENZIONE ! Non è possibile più inserire ulteriori nomi la lista è satura, supera i 30 nomi")
            break
        listaInserimentoNomi.append(stringaNome)
        
    
    contatoreNomi:int = len(listaInserimentoNomi)
    print(f"Il numero di nomi inseriti nel sistema è pari ad {contatoreNomi} nomi.\n")

    nomeLungo:str = max(listaInserimentoNomi, key=len)
    lunghezzaNomeLungo:int = len(nomeLungo)

    print(f"Il nome più lungo è {nomeLungo}.\n")
    print(f"La lunghezza del nome più lungo del sistema è lungo ben {lunghezzaNomeLungo} caratteri.\n")

inserimentoNomi()




        
    
        
        


      
