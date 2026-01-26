'''
Si scriva un programma che dato un intero di quattro cifre, per esempio 2024, 
utilizzando gli opportuni operatori, lo si visualizzi, una cifra per riga:

2
0
2
4

'''

#input numero a 4 cifre
numero = int(input("Inserisci un numero intero di quattro cifre: "))

#Prendsiamo ogni singola cifra e la dividiamo ottenenedo la cifra
cifra1 = numero // 1000          # Prima cifra
cifra2 = (numero // 100) % 10    # Seconda cifra
cifra3 = (numero // 10) % 10     # Terza cifra
cifra4 = numero % 10             # Quarta cifra

#Output riga per riga
print("La cifra è:\n")
print(cifra1)
print(cifra2)
print(cifra3)
print(cifra4)
print("\n") # Per una più coretta visualizzazione in Output 


''' |CORREZIONE COLLETTIVA| 

Spiegazione Procedimento:

Per scrivere il numero 2024 con cifre separate, bisogna individuare quante volte le migliaia sono contenute in 2024, 
quante volte le centinaia sono contenute in 2024, quanten volte le decine sono contenute in 2024 e quante volte le 
unità sono contenute in 2024. 

Le migliaia, quindi, sono 2, dunque, il numero da valutare diventa 2024 - 2*1000 = 2024 - 2000 = 24. 
Nel numero 24 abbiamo che le centinaia sono 0 , quindi il numero da valutare rimane 24. 
Le decine sono 2, perciò il numero da valutare diventa 24 - 2*10 = 24 - 20 = 4. 
Le unità sono 4, dunque, il numero da valutare diventa 4 - 4*1= 4 - 4 = 0. 

Quindi, abbiamo che:
migliaia=2 
centinaia=0
decine=2
unita'=4


Per individuare il numero di volte in cui le migliaia sono contenute in 2024, basta dividere 2024 per 1000 e quindi usare il resto 
della divisione per capire il numero che deve essere valutato per calcolare le centinaia, le decine e le unità.
Per compiere queste operazioni, è possibile utilizzare gli operatori / e %. Ad esempio,
2024/1000 = 2 
2024%1000 = 24 (il resto) 

Se ripetiamo questo ragionamento per le centinaia, le decine e le unità allora possiamo stamapre a schermo tutte le cifre del numero 2024.
'''
'''

CODICE ALTERNATIVO, Corretto in classe:

n:int = 2024 

# stampare a schermo le migliaia.
# Poichè la divisione da come risultato un numero float, 
# devo convertire il risultato della divisione in un numero intero, usando la funzione int()
print(int(n/1000)) # 2024/1000=2

# numero da valutare per le centinaia, decine ed unità
n=n%1000 # n = 2024%1000=24 

# stamapre a schermo le centinaia
print(int(n/100)) # 24/100=0

# numero da valutare per le decine e le unità
n=n%100 # n = 24%100 = 24 

# stampare a schermo le decine 
print(int(n/10)) # 24/10=2 

# numero da valutare per le unità 
n=n%10 # n = 24%10=4 

# stampare a schermo le unità
print(int(n/1))

# la divisione n/1 darà sempre resto 0, quindi abbiamo finito il nostro procedimento.
# pertanto non è necessario valutare n%1

'''
