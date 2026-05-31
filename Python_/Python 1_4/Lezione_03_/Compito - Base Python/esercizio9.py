'''
Esercizio 9

Il valore di π può essere approssimato utilizzando la seguente serie infinita:

π = 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...

Scrivere un programma che calcoli il valore di π utilizzando questa serie e determini quanti termini sono necessari per ottenere approssimazioni 
sempre più accurate. Quindi:

    progettare un algoritmo che mostri in output quanti termini della serie devono essere usati per ottenere il valore di π ≈ 3.14;
    modificare l'algoritmo, mostrando in output quanti termini della serie devono essere usati per ottenere il valore di π ≈ 3.141;
    modificare l'algoritmo, mostrando in output quanti termini della serie devono essere usati per ottenere il valore di π ≈ 3.1415;
    modificare l'algoritmo, mostrando in output quanti termini della serie devono essere usati per ottenere il valore di π ≈ 3.14159.

Nota: Il programma deve iterare fino a raggiungere ciascuna delle soglie indicate, contando il numero di termini necessari.

'''
#Inizializziamo le variabili che ci serviranno per l'approssimazione del PiGreco
approssimazione_pi = 0.0
valore_denominatore = 1
valore_segno = 1
termini_usati = 0


#Indichiamo i valori e un indice soglia dentro una lista
valori_soglia = [3.14, 3.141, 3.1415, 3.14159]
indice_soglia = 0

#Iniziamo con il ciclo WHILE dove dobbiamo rimanere sotto i valori di soglia, calcolando con la formula fornita dall'esercizio
while indice_soglia < len(valori_soglia):
    
    approssimazione_pi += valore_segno * (4 / valore_denominatore)
    
    #Aggiorniamo man mano il valore, segno e termini ad ogni iterazione
    valore_denominatore += 2
    valore_segno *= -1
    termini_usati += 1
    
    
   #Impostiamo una condizione per vedere se l'approssimazione rispecchia i valori di soglia 
    if indice_soglia < len(valori_soglia):

        #Confrontiamo per ognuna di esse l'approssimazione con i valori di soglia e incrementiamo l'indice soglia

       #Valore iniziale PI = 3.14  
        if indice_soglia == 0 and 3.135 <= approssimazione_pi < 3.145:  
            print(f"\n\n|RISULTATI|\n\nPer raggiungere π ≈ 3.14 sono necessari {termini_usati} termini.")

            indice_soglia += 1
        #Modifichiamo il valore di PI = 3.141 
        elif indice_soglia == 1 and 3.1405 <= approssimazione_pi < 3.1415:  
            print(f"Per raggiungere π ≈ 3.141 sono necessari {termini_usati} termini.")

            indice_soglia += 1

        #Modifichiamo il valore di PI = 3.1415 
        elif indice_soglia == 2 and 3.14145 <= approssimazione_pi < 3.14155: 
            print(f"Per raggiungere π ≈ 3.1415 sono necessari {termini_usati} termini.")

            indice_soglia += 1

        #Modifichiamo il valore di PI = 3.14159
        elif indice_soglia == 3 and 3.141585 <= approssimazione_pi < 3.141595:  
            print(f"Per raggiungere π ≈ 3.14159 sono necessari {termini_usati} termini.")

            indice_soglia += 1

#Ouput del valore approssimato di PI
print(f"\n\n|APPROSSIMAZIONE|\n\nIl VALORE APPROSSIMATO DI PI È PARI AD: {approssimazione_pi}")