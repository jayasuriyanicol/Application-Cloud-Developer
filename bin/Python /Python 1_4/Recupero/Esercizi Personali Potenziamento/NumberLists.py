'''

Scrivi un programma che gestisca una lista di numeri:

Chiedi all’utente di inserire numeri interi (finché non scrive fine).

Salva tutti i numeri in una lista.

Alla fine, stampa:

La lista dei numeri inseriti.

La somma totale.

La media.

Solo i numeri pari.

Solo i numeri dispari.

I numeri ordinati in ordine crescente e decrescente.


Output atteso

Inserisci un numero (o 'fine'): 10
Inserisci un numero (o 'fine'): 5
Inserisci un numero (o 'fine'): 8
Inserisci un numero (o 'fine'): fine

Numeri inseriti: [10, 5, 8]
Somma: 23
Media: 7.67
Numeri pari: [10, 8]
Numeri dispari: [5]
Crescente: [5, 8, 10]
Decrescente: [10, 8, 5]

'''
sommaTotaleNumeri:int = 0
mediaNumeriInseriti:float = 0
listaNumeriInseriti:list[int] = [] 
listaNumeriPari:list[int] = [] 
listaNumeriDispari:list[int] = [] 
listaNumeriCrescenti:list[int] = [] 
listaNumeriDecrescenti:list[int] = [] 



while True:


    inserimentoNumeri:int = input("Inserisci un numero (o 'fine'): ")

    if inserimentoNumeri.lower() == 'fine':

        break

    try:

        numeroInserito  = int(inserimentoNumeri)

    
    except ValueError:

        print("ATTENZIONE ! è possibile inserire solo numeri INTERI ")

    
    listaNumeriInseriti.append(numeroInserito)

for elemento in listaNumeriInseriti:

 sommaTotaleNumeri += elemento

 mediaNumeriInseriti = sommaTotaleNumeri / len(listaNumeriInseriti)

 if elemento % 2 == 0:
    listaNumeriPari.append(elemento)
 else:
    listaNumeriDispari.append(elemento)

listaNumeriCrescenti = sorted(listaNumeriInseriti)
listaNumeriDecrescenti = sorted(listaNumeriInseriti, reverse=True)

print(f"\n\nRiepilogo:\n\nNumeri inseriti: {listaNumeriInseriti}\nSomma: {sommaTotaleNumeri}\nMedia: {mediaNumeriInseriti:.2f}\nNumeri pari: {listaNumeriPari}\nNumeri dispari: {listaNumeriDispari}\nCrescente: {listaNumeriCrescenti}\nDecrescente: {listaNumeriDecrescenti}\n\n FINE RIEPILOGO")


'''
In alternativa possiamo utilizzare il metodo delle LIST COMPREHENSION

listaNumeri:list[int] = [] 


while True: 

    inserimentoNumero:str = input("Inserisci un numero o 'fine'): ")

    if inserimentoNumero.lower() == 'fine':
        break
        
    try:
        numero = int(inserimentoNumero)
        listaNumeri.append(numero)
    except ValueError:
        print("ATTTENZIONE ! Non è possibile inserire numeri al di fuori da quelli INTERI")

if listaNumeri:

    sommaNumeriLista:int = sum(listaNumeri)
    mediaNumeriLista:int|float = sommaNumeriLista / len(listaNumeri)
    listaNumeriPari:list[int] = [numero for numero in listaNumeri if numero % 2 == 0]
    listaNumeriDispari:list[int]  =[ numero for numero in listaNumeri if numero % 2 != 0] 

    print(f"\nNumeri inseriti: {listaNumeri}")
    print(f"Somma: {sommaNumeriLista}")
    print(f"Media: {mediaNumeriLista:.2f}")
    print(f"Numeri pari: {listaNumeriPari}")
    print(f"Numeri dispari: {listaNumeriDispari}")
    print(f"Crescente: {sorted(listaNumeri)}")
    print(f"Decrescente: {sorted(listaNumeri, reverse=True)}")

else:
    print("\nATTENZIONE ! Non è stato inserito alcun numero.\nLa Lista è vuota !")

'''