'''
Esercizio 8 – Doppio ordinamento

Hai una lista di dizionari:

studenti = [
    {"nome": "Anna", "media": 28},
    {"nome": "Luca", "media": 25},
    {"nome": "Marco", "media": 30}
]

Ordina la lista in ordine decrescente di media usando una funzione lambda.

'''
#Importiamo da typing LISTE, DIZIONARI E UNIONE per andare attarverso l'utilizzo di LAMBDA a creare una funzione che mostra la media in ordine DECRESCENTE
from typing import List,Dict,Union

#Inseriamo la lista fornita dal testo della consegna
listaStudenti: List[Dict[str,Union[str,int]]] = [
    {"nome": "Anna", "media": 28},
    {"nome": "Luca", "media": 25},
    {"nome": "Marco", "media": 30}
]

#Andiamo a svolgere la funzione listaDecrescenteStudenti dove attraverso il meotdo SORTED andiamo ariportare in una nuova lista di dict i voti di ogni persona in maniera decrescente
listaDecrescenteStudenti:List[Dict[str,Union[str,int]]] = sorted(listaStudenti,key=lambda mediaStudente: mediaStudente["media"], reverse=True)



print(listaDecrescenteStudenti)