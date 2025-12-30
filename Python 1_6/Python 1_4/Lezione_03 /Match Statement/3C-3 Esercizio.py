'''
Esercizio 3C-3. Creare in Python una lista vuota chiamata 'oggetti'. Con un ciclo, riempire questa lista con tre oggetti diversi.
Scrivere, poi, un programma che utilizzi un match statement per classificare gli oggetti presenti nella lista:

- ["penna", "matita", "quaderno"] → "Materiale scolastico"
- ["pane", "latte", "uova"] → "Prodotti alimentari"
- ["sedia", "tavolo", "armadio"] → "Mobili"
- ["telefono", "computer", "tablet"] → "Dispositivi elettronici"
- Qualsiasi altra lista → "Categoria sconosciuta"

Expected Output:

['casa', 'hotel', 'b&b']
Categoria sconosciuta

--------------------------

['penna', 'matita', 'quaderno']
Materiale scolastico

'''


#Creo una lista dove memorizzare univocamente tutti gli oggetti, e inizializzo il numero che conterà l'inserimento dell'oggetto (per 3 volte)
oggetti = [ ] 
numero = 1

#Inserimento dell'oggetto per tre volte all'interno della lista
for i in range (numero,4):
    
    oggetto:str = input(f"\nBenvenuto, inserisci il {numero}  ogetto: ")
    oggetti.append(oggetto)
    numero += 1

#Match Statement con tutte le casistiche, verifica se tutti i parametri corrispondono. 
match oggetti: 

    case ["penna", "matita", "quaderno"]:
         print("\n",oggetti)
         print("\nMateriale scolastico")
    case ["pane", "latte", "uova"]:
          print("\n",oggetti)
          print("\nProdotti alimentari")
    case ["sedia", "tavolo", "armadio"]:
          print("\n",oggetti)
          print("\nMobili")   
    case ["telefono", "computer", "tablet"]:
          print("\n",oggetti)
          print("Dispositivi Elettronici") 
    case _: 
          print("\n",oggetti)
          print("Categoria sconosciuta")



