'''
8-15. Printing Models: Put the functions for the example printing_models.py in a separate file called printing_functions.py. 
Write an import statement at the top of printing_models.py, and modify the file to use the imported functions.

'''

'''                                                | FILE PRITING_FUNCTIONS |                                                                          '''

#Inizio con il creare delle funzioni all'interno del file 'Printing_Functions' 

#Partiamo con la prima funzione che stampa i modelli finchè nessuno è incompleto, aggiungendo i cmodelli da 'modelli incompleti' -> 'modelli completi'
def stampa_modelli (modelli_incompleti, modelli_completi):

    while modelli_incompleti:
        disegno = modelli_incompleti.pop()
        print(f"Stampo il modello: {disegno}")
        modelli_completi.append(disegno)


#Successivamente, creiamo la funzione che mostra i nostri modelli 
def mostra_modelli (modelli_completi):
    print("\nQuesti sono i modelli che sono stati STAMPATI:")
    for modello in modelli_completi:
        print(modello)

