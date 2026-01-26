'''
Scrivi un programma che chieda all’utente un numero N e stampi tutti i numeri pari da 0 a N inclusi.

Esempio input/output:

Inserisci un numero: 10
Output: 0 2 4 6 8 10

'''

listaNumeriPari:list[int] = [] 

try:

    numeroRichiesto:int = int(input("Inserisci un numero: "))

except ValueError:

    print("ATTENZIONE ! Sono permessi all'inserimento solamente numeri INTERI !")


for numero in range (0,numeroRichiesto+1):

    if numero % 2 == 0:

        listaNumeriPari.append(numero)

print("\nOutput:")

for elemento in listaNumeriPari:

    print(elemento)

    
        
    