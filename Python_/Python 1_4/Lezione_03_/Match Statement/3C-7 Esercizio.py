'''
Esercizio 3C-7. Si scriva un pr 100ogramma in python che computi la statistica di otto lanci di una moneta.
Per ciascuno dei lanci effettuati, l'utente inserisce "t" o "T" se è uscito "testa", mentre inserisce "c" o "C" se è uscito "croce".
Il programma deve mostrare in output il numero totale e la percentuale dei risultati "testa" e "croce".

NOTA.
Le percentuali devono essere mostrate in output obbligatoriamente con 2 cifre decimali.
Usare il match statement.

Expected Output:

Per ciascun lancio della moneta inserisci "t" o "T" se e' uscito "testa" mentre inserisci "c" o "C" se e' uscito "croce".

Lancio 1: t
Lancio 2: c
Lancio 3: t
Lancio 4: t
Lancio 5: c
Lancio 6: c
Lancio 7: t
Lancio 8: t

Totale "testa": 5
Percentaule "testa": 62.50%

Totale "croce": 3
Percentuale "croce": 37.50%

'''
#Inizializzazione delle variabili a 0, numero è a 1 perchè rappresentiamo gia il primo lancio
numero_testa = 0
numero_croce = 0
numero = 1  
totale_lanci = 0

#Messaggio di benvenuto e SPIEGAZIONE PER L'INSERIMENTO
print("\nBenvenuto! Questo programma permette di inserire il lancio della moneta:")
print('Inserisci "T" per TESTA e "C" per CROCE.')

#Ciclo FOR per l'inserimento esattamente 8 volte, con all'interno un WHILE True che ripete finchè non è vero
for _ in range(8):
    while True:  
        lancio = input(f"\nPrego, inserire il {numero} lancio: ").lower()

        match lancio:
            case "c":
                numero_croce += 1
                break  
            case "t":
                numero_testa += 1
                break 
            case _:
                print("\n| ATTENZIONE! |\nInserisci solo 'T' per TESTA o 'C' per CROCE.")
                print("Il conteggio di questo lancio non sarà considerato. Riprova.")
    
    numero += 1 

#Calcolo TOT delle volte inserite T o C
totale_lanci = numero_testa + numero_croce

#Calcolo delle percentuali, chiedendo se i lanci totali siano maggiori di 0 sennò pari a 0
if totale_lanci > 0:
    percentuale_testa = (numero_testa / totale_lanci) * 100
    percentuale_croce = (numero_croce / totale_lanci) * 100
else:

    print("\nATTENZIONE ! Nessun caso inserito pari a 0 !")
    percentuale_testa = percentuale_croce = 0.00

# OUTPUT dei risultati
print("\n\n| RISULTATI FINALI |")
print("\n| TESTA |")
print(f'Numero di volte: {numero_testa}')
print(f'Percentuale: {percentuale_testa:.2f}%')

print("\n| CROCE |")
print(f'Numero di volte: {numero_croce}')
print(f'Percentuale: {percentuale_croce:.2f}%')
