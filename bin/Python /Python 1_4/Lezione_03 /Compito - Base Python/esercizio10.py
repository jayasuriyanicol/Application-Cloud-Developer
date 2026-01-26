'''
Esercizio 10

Scrivere un programma che permetta di analizzare una lista di numeri interi inseriti dall’utente.

Il programma deve:

    acquisire una sequenza di numeri interi, terminando l’inserimento quando l’utente digita 0 (che non deve essere considerato nei calcoli);
    calcolare e visualizzare la somma di tutti i numeri pari inseriti;
    calcolare e visualizzare la media di tutti i numeri dispari inseriti;
    determinare e visualizzare il numero con la frequenza più alta (cioè quello che compare più volte nella lista);
    se più numeri hanno la stessa frequenza massima, visualizzarli tutti.

Esempio di input e output
Input:

Inserisci un numero (0 per terminare): 4
Inserisci un numero (0 per terminare): 7
Inserisci un numero (0 per terminare): 2
Inserisci un numero (0 per terminare): 7
Inserisci un numero (0 per terminare): 3
Inserisci un numero (0 per terminare): 4
Inserisci un numero (0 per terminare): 0

Output:

Somma dei numeri pari: 10
Media dei numeri dispari: 5.67
Numero più frequente: 7 (2 volte)


'''


#Inizializziamo le variabili e liste necessarie
numero_inserito= [ ] 
somma_pari = 0
somma_dispari = 0
numeri_dispari = 0
numeri_frequenti = {} 

#Spiegazione programma all'utente
print("\nBenvenuto, attraverso questo programma finchè il numero digitato non sarà 0, potrai inserire i numeri INTERI a tuo piacimento e in output otterrai:.")
print("\n1. LA SOMMA DEI NUMERI PARI")
print("\n2. LA MEDIA DEI NUMERI DISPARI")
print("\n3. I NUMERI CON LA FREQUENZA PIU' ALTA (A VOLTE PIU' DI UNO)")

#Finchè la condizione è vera e non 0 continua l'inserimento del valore
while True:
    numero_inserito = int(input("\n\nPrego, inserire un numero intero (DIGITA 0 PER TERMINARE): "))
    
   #Termina e mostra l'output se è 0 
    if numero_inserito == 0:
        break
    
    #Verifichiamo se è pari e aggiungiamo alla somma pari
    if numero_inserito % 2 == 0:
        somma_pari += numero_inserito
 
   #Verifichiamo se è dispari e aggiungiamo alla somma dispari, potevamo inserire else, ma sempre meglio verificare la condizione
    if numero_inserito % 2 != 0:
        numeri_dispari += 1
        somma_dispari += numero_inserito
    
    #Ogni numero inserito nella LISTA dei numeri come richiesto dall'esercizio vediamo se è presente nel SET di numeri frequenti
    if numero_inserito in numeri_frequenti:
    #Se presente incrementiamo 
        numeri_frequenti[numero_inserito] += 1
    else:
    #Altrimenti rimarrà l'unico numero inserito ovvero pari ad 1 
        numeri_frequenti[numero_inserito] = 1

#Calcoliamo la media dei numeri dispari, verificando se ci siano,
if numeri_dispari > 0:
    media_dispari = somma_dispari / numeri_dispari
else:
    print("ATTENZIONE ! Non sono presenti numeri dispari inseriti")

#Proseguiamo trovando la frequenza massima,
massima_frequenza = 0
frequenza_massima = []

for n, f in numeri_frequenti.items():
    #Verifichiamo la presenza di una frequenza maggiore e nel caso modifichiamo la lista
    if f > massima_frequenza:
        massima_frequenza = f
        frequenza_massima = [n]
    #Caso intermedio ELIF se abbiamo una frequenza uguale, modifichiamo aggiungendolo alla lista
    elif f == massima_frequenza:
        frequenza_massima.append(n)

#Output con tutti i risultati, somma, media e frequenza massima e in caso OUTPUT con relativi errori.
print(f"\n\n| RIEPILOGO DATI |\n\nSOMMA NUMERI PARI: {somma_pari}")

if somma_pari == 0:
    print("ATTENZIONE ! Non sono presenti numeri PARI inseriti ")

if numeri_dispari > 0:
    print(f"MEDIA NUMERI DISPARI: {media_dispari:.2f}")
else:
    print("ATTENZIONE ! Non vi è la media dei numeri dispari !" )

for numero in frequenza_massima:
    print(f"NUMERO/I  PIU' FREQUENTE/I: {numero}  ( E' STATO DIGITATO {massima_frequenza} VOLTE )")

