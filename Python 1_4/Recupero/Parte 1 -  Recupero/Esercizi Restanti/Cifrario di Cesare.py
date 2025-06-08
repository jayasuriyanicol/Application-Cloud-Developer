'''
Cifrario di Cesare
Il cifrario di Cesare è un antico metodo crittografico che rende alcune informazioni nascoste
a chi non possiede la chiave per decifrarle.
Immagina l’alfabeto come una lista ordinata di lettere (puoi importare la lista delle lettere
dell’alfabeto minuscole scrivendo from string import ascii_lowercase
Ogni lettera ha una posizione in questa lista:
● a è 1
● b è 2
● j è 10
● e così via…
Il cifrario di Cesare nasconde l’informazione utilizzando una chiave, che è un numero intero
positivo, da sommare alla posizione della lettera originale: il risultato ottenuto corrisponde
alla posizione della lettera cifrata.
● a con key = 2 diventa c
Se la chiave porta oltre la fine dell’alfabeto, si ricomincia dal principio:
● a con key = 28 diventa c
Per decriptare (o “decifrare”) il messaggio, si applica la stessa procedura ma muovendosi
all’indietro nell’alfabeto. Devi fornire le funzioni:
caesar_cypher_encrypt(s, key)
caesar_cypher_decrypt(s, key)
dove:
● s è una stringa (lettera, parola, frase, ecc.).
● key è un numero intero positivo, la chiave del cifrario di Cesare.
La tua implementazione deve trasformare soltanto le lettere ASCII maiuscole e minuscole.
Caratteri speciali, numeri e lettere accentate non devono essere modificati.
Le funzioni non devono stampare nulla a schermo, ma restituire la stringa cifrata o
decifrata.
'''

#Importiamo come richiesto dall'esercizio ascii_*
from string import ascii_lowercase, ascii_uppercase

#Funzione per il criptaggio, con testo = s e chiave = key
def caesar_cypher_encrypt(s, key) -> str:


    risultatoCriptato: list[str] = []


    for lettera in s:


        if lettera in ascii_lowercase:

            indiceMinuscole = (ascii_lowercase.index(lettera) + key) % 26
            risultatoCriptato.append(ascii_lowercase[indiceMinuscole])
        

        elif lettera in ascii_uppercase:


            indiceMaiuscole = (ascii_uppercase.index(lettera) + key) % 26
            risultatoCriptato.append(ascii_uppercase[indiceMaiuscole])
        
        else:

            risultatoCriptato.append(lettera)
    
    return ''.join(risultatoCriptato)


#Funzione per il decriptaggio, con testo = s e chiave = key
def caesar_cypher_decrypt(s,key) -> str:

    risultatoDecriptato: list[str]  = []


    for lettera in s:


        if lettera in ascii_lowercase:

            decriptaMinuscole = (ascii_lowercase.index(lettera) - key ) % 26
            risultatoDecriptato.append(ascii_lowercase[decriptaMinuscole] )
        
        elif lettera in ascii_uppercase:

            decriptaMaiuscole = (ascii_uppercase.index(lettera) - key) % 26
            risultatoDecriptato.append(ascii_uppercase[decriptaMaiuscole] )

        else:

            risultatoDecriptato.append(lettera)

    return ''.join(risultatoDecriptato)





'''DRIVER PROGRAMM - Per verificare le funzionalità del programma '''

messaggioCriptareDecriptare = "Ciao, sono Cristiano Coccia !"
chiave = 2

messaggioCriptato = caesar_cypher_encrypt(messaggioCriptareDecriptare, chiave)
print("MESSAGGIO CRIPTATO: ", messaggioCriptato)  

messaggioDecriptato = caesar_cypher_decrypt(messaggioCriptato, chiave)
print("MESSAGGIO DECRIPTATO: ", messaggioDecriptato)  

