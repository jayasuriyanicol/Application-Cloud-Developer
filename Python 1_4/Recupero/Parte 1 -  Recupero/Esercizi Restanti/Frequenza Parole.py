'''
Frequenza di Parole Uniche con Normalizzazione
Scrivi una funzione che prende una stringa di testo (contenente eventualmente
punteggiatura, lettere maiuscole e minuscole, spazi bianchi) e restituisce un dizionario che
associa a ciascuna parola unica (in minuscolo, privata della punteggiatura iniziale/finale) il
numero di occorrenze.
Requisiti:
● Suddividi l’input sugli spazi bianchi per ottenere i token.
● Normalizza ogni token:
1. Converti in minuscolo.
2. Rimuovi la punteggiatura iniziale e finale (ad esempio usando str.strip()
con un insieme di caratteri di punteggiatura).
● Ignora qualsiasi token che diventa stringa vuota dopo la rimozione della
punteggiatura.
● Restituisci un dict dove le chiavi sono parole normalizzate e i valori sono conteggi
interi.
Esempio:
text = "Hello, world! Hello... PYTHON? world."
output = count_unique_words(text)
● # output == {'hello': 2, 'world': 2, 'python': 1}

'''

#Importiamo dalla strind la funzione punctuation per eliminare relativi (?,.:,ecc.)
from string import punctuation


#Definiamo una funzione che calcola le occorrenzze (parole) che si ripetono in una determinata frase passata per input -> "testoConvertire"
def occorrenzeFrase(testoConvertire:str)-> dict[str,int]:

    dizionarioOccorrenze:dict[str,int] = {}

    #Splittiamo il testo in piccole parti -> "token" per verificare che ogni parola correttamente 
    tokens = testoConvertire.split()

    for token in tokens:
       
       #Eliminiamo dal token la "punteggiatura" e nel caso sia nullo -> "stringa vuota" continuiamo
       elemento = token.lower().strip(punctuation)

       if elemento == '':
          
          continue
       

       #Per ogni elemento "token" spoglio da "impurita" (punteggiatura, testi vuoti, ecc.)  andiamo a verificare se già presente -> +1 se non presente -> 1
       if elemento in dizionarioOccorrenze:
       
           dizionarioOccorrenze[elemento] += 1 

       else:
           dizionarioOccorrenze[elemento] = 1  

    return dizionarioOccorrenze



'''DRIVER PROGRAMM - Test delle funzionalità del programma'''

text = "Hello, world! Hello... PYTHON? world."
output = occorrenzeFrase(text)
print(output)