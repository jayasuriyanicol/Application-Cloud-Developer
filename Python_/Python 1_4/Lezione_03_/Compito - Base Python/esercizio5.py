'''
Esercizio 5

Si supponga di poter acquistare barrette di cioccolato da un distributore automatico al costo di 1 euro ciascuna. 
Ogni barretta acquistata contiene un buono sconto, e con 6 buoni sconto si ottiene una barretta gratuita.

Scrivere un programma che:

    Acquisisca in input un valore N (numero di euro disponibili).
    Calcoli e mostri in output il numero totale di barrette che si possono ottenere, considerando anche quelle ottenute con i buoni sconto.
    Mostri quanti buoni sconto avanzano al termine dell'acquisto.

Esempio:
Se l'utente inserisce N = 6, può acquistare 6 barrette ottenendo 6 buoni sconto, che gli permettono di riscattare 1 ulteriore barretta gratuita, 
per un totale di 7 barrette. Alla fine, non rimarranno buoni sconto inutilizzati.

Il programma deve continuare a scambiare i buoni con nuove barrette finché ce ne sono abbastanza per ottenere almeno una barretta gratuita.

'''

while True:
    saldo = int(input("\nBenvenuto, nel DISTRIBUTORE PER L'ACQUISTO DELLE BARRETTE, il costo di ogni barretta è di 1 euro, ad ogni acquisto viene aggiunto un buono.\nRaggiunti i 6 buoni si ottiene una barretta omaggio.\n\nPrego, per iniziare l'acquisto inserisca il suo saldo (oppure digiti 0 per uscire):  "))
    
   #Se il nostro saldo è pari a 0 termina il programma con l'utilizzo di break 
    if saldo == 0:
        print("\nGrazie per aver usato il distributore. Arrivederci!")
        break
    
    if saldo < 1:
        print("\nATTENZIONE! Il saldo è NEGATIVO o insufficiente, non si può procedere con l'acquisto!")
    else:
        # Il numero di barrette è uguale al saldo
        barrette = saldo
        # Una barretta equivale a un buono sconto
        sconto = saldo  
        # Le barrette omaggio iniziano da 0
        barrette_omaggio = 0  
        
        # Calcola le barrette omaggio finché ci sono almeno 6 buoni
        while sconto >= 6:
            barrette_omaggio = sconto // 6
            barrette += barrette_omaggio
            sconto = sconto % 6 + barrette_omaggio
        
       #Output con tutti i risultati uno per uno 
        print("\n| RIEPILOGO ORDINE |")
        print(f"\nBARRETTE TOTALI: {barrette} (comprese {barrette_omaggio} in omaggio)")
        print(f"\nBUONI SCONTO RIMANENTI: {sconto}\n")
