'''
Ricerca Binaria
Implementa una funzione che effettua la ricerca binaria in una lista di numeri interni ordinati
e ritorna True se il numero è all’interno del della lista, altrimenti False.
'''


def ricercaBinaria(listaNumeri:list[int], numeroCercare:int ) -> bool:

    listaParteSinistra = 0
    listaParteDestra = len(listaNumeri) - 1


    while listaParteSinistra <= listaParteDestra:

        listaParteMeta = (listaParteSinistra + listaParteDestra) // 2