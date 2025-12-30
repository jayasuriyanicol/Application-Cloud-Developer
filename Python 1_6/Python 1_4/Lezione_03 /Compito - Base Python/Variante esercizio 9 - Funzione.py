'''
Esercizio numero 9 - VARIANTE CON UTILIZZO DELLE FUNZIONI.

Consegna ESERCIZIO numero 9:

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

#Definiamo una funzione che cacola il PI con parametri di parte dell'approssimazione (esempio: 3.14) e la parte decimale (esempio:4/1)
def computePI(appoximation_value:float,decimal_digits) -> int:
#Indichiamo all'interno della funzione il termine, il PI e i che sarà il nostro 'contatore'

    terms:int = 0
    pi:float = 0
    i:int = 0
   
  #Svolgiamo una funzione nella quale chiediamo che finchè il valore della approssimazione non sia diverso di continuare ad approssimare attraverso la funzion BUIL-IN di Python.
  #Sia la parte del PI che anche la parte in decimale. 
    while round(pi,decimal_digits) != appoximation_value:
      
     #Se la funzione è PARI andiamo a calcolare il PI attraverso la SOMMA
        if i%2==0:
            pi = pi + 4/(2*i+1)
     #Se la funzione è DISPARI andiamo a calcolare il PI attraverso la SOTTRAZIONE  
        else: 
            pi = pi - 4/(2*i+1)

    #Incrementiamo sia il termine che l'indice, riportando di nuovo il termine. 
        terms += 1
        i += 1
    return terms

#Infine per ogni PI, andiamo a richiamare la funzione indicando quanto è pari la parte decimale, e andando a nstampare il numero di TERMINI utilizzati.
print(f"\nPer approssimare il termine di 3.14 occorrono: {computePI(3.14,2)} TERMINI")
print(f"\nPer approssimare il termine di 3.141 occorrono: {computePI(3.141,3)} TERMINI")
print(f"\nPer approssimare il termine di 3.1415 occorrono: {computePI(3.1415,4)} TERMINI")
print(f"\nPer approssimare il termine di 3.14159 occorrono: {computePI(3.14159,5)} TERMINI")