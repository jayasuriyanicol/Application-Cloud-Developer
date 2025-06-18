'''
Esercizio 1.

In biologia molecolare, le molecole di DNA possono essere viste come stringhe sull’alfabeto dei nucleotidi
A = adenina, C = citosina, G =guanina, T = timina.

Ad esempio: DNA: CAGCTGATCGATGCTAGCCTG.

Scrivere un programma in linguaggio Python che legge dall’utente due stringhe s1 e s2 corripondenti a frammenti di
DNA e verifica se s2 puo' essere sovrapposta su s1 in modo che una parte iniziale (prefisso) di s2 coincida con
una parte finale (suffisso) di s1.
 
Il programma dovra' dare la lunghezza della massima sovrapposizione (0 se non si possono sovrapporre).
 
Ad esempio, se l’utente ha inserito:
s1= CAGCTGATCGATGCTAGCCTG
s2= AGCCTGTTGCACCTAGA

Le due stringhe si sovrappongono come segue:
CAGCTGATCGATGCTAGCCTG
                                  AGCCTGTTGCACCTAGA

Il programma dovra' quindi stampare in output:

    le stringhe sovrapposte come nell'esempio.

    La massima lunghezza di sovrapposizione e' 6.


NOTA1:
il programma dovra' anche verificare la correttezza dell’input, ovvero le stringhe inserite dall’utente devono essere effettivamente frammenti di DNA.
Suggerimento: scrivere una funzione isDNA() che, data in input una sequenza, restituisca True se la sequenza passata è una valida sequenza del DNA formata dai soli caratteri A, C, G o T, e che restituisca False altirmenti.
Può essere utile usare una regex.

Nota2: trovare una soluzione che eviti di scrivere codice replicato per inizializzare le sequenze s1 e s2.

Infine, verificare le seguenti coppie di frammenti di DNA:
- s1= TTGACCAGGTCA
- s2= AACCGGTTAA
La massima lunghezza è 1

- s1= GGTACCGTGA
- s2= CGTGAACCTT
La massima lunghezza è 5

- s1= AAGCTTACG
- s2= ACGTTCGA
La massima lunghezza è 3

- s1= TTACGAGTACGCTAGT
- s2= ACGCTAGTCCGA
La massima lunghezza è 8


'''

import re

def isDNA(sequenza:str) -> bool:
    
    sequenzaAnalizzata:str = re.fullmatch(r"[ACGT]+",sequenza)

    if sequenzaAnalizzata:
        return True
    return False
    
s1= ("TTACGAGTACGCTAGT")
s2= ("ACGCTAGTCCGA")


if not isDNA(s1) or not isDNA(s2):
    print("Errore: le sequenze devono contenere solo i caratteri A, C, G, T e devono contere tutti CARATTERI MAIUSCOLI")
else:
    max_overlap = 0

    # Prova tutte le possibili sovrapposizioni
    i = 1
    while i <= len(s1) and i <= len(s2):
        if s1[-i:] == s2[:i]:
            max_overlap = i
        i += 1

    # Stampa le stringhe sovrapposte
    print("\nStringhe sovrapposte:")
    print(s1)
    print(" " * (len(s1) - max_overlap) + s2)

    # Stampa la lunghezza della sovrapposizione
    print("\nLa massima lunghezza di sovrapposizione è", max_overlap)



 


