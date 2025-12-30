'''

Esercizio – Conteggio lettere

Scrivi un programma che:

Chieda all’utente di inserire una frase.

Conti quante volte appare ogni lettera (ignora spazi e punteggiatura).

Mostri il risultato in ordine alfabetico.

Inserisci una frase: Ciao come stai?
Risultato:
a: 2
c: 2
e: 1
i: 2
m: 1
o: 2
s: 1
t: 1


'''

from string import punctuation

dizionarioLettere:dict[str,int] = {}
dizionarioOrdinato:dict[str,int] = {} 

inserimentoFrase:str = input("Inserisci una frase: ")


try:
    fraseInserita:str = inserimentoFrase.lower()
except ValueError:

    print("ATTENZIONE ! Il valore inserito deve essere una STRINGA !")

for elementoSpeciale in punctuation:

    fraseInserita = fraseInserita.replace (elementoSpeciale, "")
    fraseInserita = fraseInserita.replace (" ", "")


for lettera in fraseInserita:


    if lettera not in dizionarioLettere:

        dizionarioLettere[lettera] = 1

    else:

        dizionarioLettere[lettera] += 1


dizionario = sorted(dizionarioLettere.items())

dizionarioOrdinato = dict(dizionario)

print("\nRisultato:\n")

for chiave,valore in dizionarioOrdinato.items():


    print(f"{chiave}: {valore}")





