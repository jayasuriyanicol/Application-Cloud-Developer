'''
Ricerca Binaria
Implementa una funzione che effettua la ricerca binaria in una lista di numeri interni ordinati
e ritorna True se il numero è all’interno del della lista, altrimenti False.
'''


def ricercaBinaria(listaNumeri:list[int], numeroCercare:int ) -> bool:

    #Indichiamo due parti, sinistra e destra per riuscire a controllare entrambi gli estremi fino a giungere al centro 
    listaParteSinistra = 0
    listaParteDestra = len(listaNumeri) - 1

  

    while listaParteSinistra <= listaParteDestra:

        listaParteMedia = (listaParteSinistra + listaParteDestra) // 2

        if listaNumeri[listaParteMedia] == numeroCercare:

            return True
        
        elif listaNumeri[listaParteMedia]  < numeroCercare:

            listaParteSinistra = listaParteMedia + 1
        
        else:

            listaParteDestra = listaParteMedia - 1
    return False


'''DRIVER PROGRAMM - Verifichiamo con una condizione TRUE e una False se funzioni o meno la funzione di RICERCA BINARIA '''


print(ricercaBinaria([1,2,3,4,5], 5))
print(ricercaBinaria([1,2,3,4,5], 0))
            
        