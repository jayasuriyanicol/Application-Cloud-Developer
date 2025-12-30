'''
Esercizio 2 – Liste e funzioni

Crea una funzione filtra_parole(lista, lunghezza) che, data una lista di stringhe e un numero intero, ritorni solo le parole più lunghe di quella lunghezza.

Esempio:

lista = ["ciao", "programmazione", "python", "ok"]
print(filtra_parole(lista, 4))

Output Atteseo:

['programmazione', 'python']

'''

paroleLunghezzaMaggiore:list[str]  = [] 

def filtra_parole(lista:list[str], lunghezza:int ) -> str:


    for elemento in lista:

        if len(elemento) > lunghezza:

            paroleLunghezzaMaggiore.append(elemento)
    
    print(f"La lista delle parole maggiori della lunghezza sono -> {paroleLunghezzaMaggiore}")
    

# Esecuzione esempio dettato dall'esercizio

lista = ["ciao", "programmazione", "python", "ok"]
filtra_parole(lista, 4)

