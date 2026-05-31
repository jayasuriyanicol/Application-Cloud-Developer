'''
Esercizio 4

Scrivere un programma che consenta all'utente di inserire una sequenza di numeri reali non negativi (sia interi che decimali).
L'inserimento termina quando viene fornito un numero negativo, che funge da sentinella e non deve essere considerato nei calcoli.

Il programma deve:

    Calcolare la media dei soli numeri interi inseriti. Utilizzate la funzione is_integer() per verificare se il numero inserito è un intero.
    Determinare e visualizzare il numero più grande e il numero più piccolo tra tutti quelli inseriti (sia interi che decimali).
 
'''
#Inizializziamo delle liste vuote che conterranno i nostri numeri inseriti

numeri_generale= []
numeri_positivi= [] 

#Condizione While finchè non è negativo, continua con lo svolgimento

while True:
    numeri= float(input("\nBenvenuto questo programma calcola:\nla media, il numero più grande e quello più piccolo, di numeri positivi int e float, ma termina se inserito un numero negativo.\n\nPrego, inserire un numero (intero o decimale): "))
    
   #Condizione per i numeri NEGATIVI, termina il programma con break
    if numeri < 0:
        print(f"\nATTENZIONE ! Il numero {numeri} è NEGATIVO ! Solo numeri POSITIVI (INTERI O DECIMALI)\n")
        break
   
   #Inserisco i miei numeri generali, sia FLOAT CHE INT 
    numeri_generale.append(numeri)
   
  #Verifico che siano interi, come chiesto dalla consegna  
    if numeri.is_integer():
        numeri_positivi.append(int(numeri))

#Calcolo della mia media con i numeri interi 
if numeri_positivi:
    somma =+ numeri
    media= somma / len(numeri_positivi)

    print("\n| IL PROGRAMMA E' TERMINATO ECCO QUI I RISULTATI |\n\n")
    print(f"La MEDIA è la seguente: {media}")
else:
    print("Numeri non sufficienti per calcolare la media !")

if numeri_generale:

   #Inizializziamo il max e il min il primo numero inserito dall'utente 
    numeri_max = numeri_generale[0]  
    numeri_min = numeri_generale[0]  
   
  #Condizione per trovare il MAX e il MIN 
    for num in numeri_generale:
        if num > numeri_max:
            numeri_max = num
        if num < numeri_min:
            numeri_min = num


print(f"Il numero MASSIMO inserito è: {numeri_max}")
print(f"il numero MINIMO inserito è: {numeri_min}")

