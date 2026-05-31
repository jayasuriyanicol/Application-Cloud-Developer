'''
8-15. Printing Models: Put the functions for the example printing_models.py in a separate file called printing_functions.py. 
Write an import statement at the top of printing_models.py, and modify the file to use the imported functions.

'''



'''                                                | FILE PRITING_MODELS |                                                                '''


#Successivamente, creo un file dove richiamo le mie funzioni, assegnando i miei valori per i relativi modelli

#Importo dal mio file 'PRINTING_FUNCTIONS' imnporto i vari nomi delle funzioni
from printing_functions import stampa_modelli,mostra_modelli

#Creo la mia lista dove sono presenti tutti i miei modelli ancora non completi e una lista vuota con i modelli completi, dove successivamente andremo a insrire tutti i nostri modelli
modelli_incompleti = ['Custodia Telefono', 'Macchina Fiat', 'Rubber - One Piece']
modelli_completi = []

#Richiamo il mio file.il nome della funzione e richiamando i relativi parametri di ogni funzione
stampa_modelli (modelli_incompleti,modelli_completi)
mostra_modelli (modelli_completi)