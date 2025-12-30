'''
Esercizio 1

Scrivere un programma che permetta all'utente di inserire una serie di parole in input, 
terminando l'inserimento quando viene digitata la parola "fine" (che non deve essere considerata nell'elaborazione).
Per ogni parola inserita, il programma deve verificare se il primo e l'ultimo carattere sono uguali e visualizzare 
un messaggio corrispondente.

'''

#Ciclo While, finchè non sarà vera continua con la domanda
while True:
    parola:str = input('\nBenvenuto, il programma ti dirà se il primo e l ultimo carattere di un parola sono uguali o meno\ne terminerà solo quando digiterai la parola "fine".\n\nPrego, inserisci una parola: ')

#Uscita dal programma se inseriamo "fine" in minuscolo
    if parola == "fine":
        print('\nSEI FUORI DAL PROGRAMMA ! Hai digitato la parola "fine"')
        break

#Condizione imposta dall'esercizio, parola > 1 e prima lettera e ultima lettera uguale: 
# se sì (successo) se no (fallimento) con relativo messaggio
    if len(parola)> 1 and parola [0] == parola  [-1] :
        print(f"\n{parola} hanno il primo e l'ultimo carattere uguale !")

    else:
        print(f"\n{parola} non hanno il primo e l'ultimo carattere uguale !")

    
    


