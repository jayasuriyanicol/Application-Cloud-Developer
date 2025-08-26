'''
Scrivi un programma che:

Chieda all’utente una frase.

Calcoli e mostri:

Quante parole contiene.

Quante lettere totali ci sono (senza contare spazi e punteggiatura).

La parola più lunga.

La frequenza di ogni parola (quante volte compare).


'''


fraseInserita:str = input("Benvenuto, inserisci una frase: ")



indiceCarattere:int = 0
conteggioLettere:int = 0
numeroParole:int = 0
parola:str = ''
parolaLunga:str = ''

dizionarioParole:dict[str,int] = {} 



fraseInserita += ' '
while indiceCarattere < len(fraseInserita):

    carattere:str = fraseInserita[indiceCarattere] 

    if carattere != " ":

        conteggioLettere += 1
        parola += carattere

    else:
        
        if parola:

            numeroParole += 1

        if parola in dizionarioParole:
    
             dizionarioParole[parola] += 1
        else:
            dizionarioParole[parola] = 1 

        if len(parola) > len(parolaLunga):

           parolaLunga = parola
       
        parola = ''

    indiceCarattere += 1




print(f"\n\nSommario della frase -> {fraseInserita}\n\nConteggio:\n\nNumero parole: {numeroParole}\nNumero Caratteri: {conteggioLettere}\nParola più lunga: {parolaLunga}\n\nFrequenza Parole:\n")


for chiave,valore in dizionarioParole.items():

    print(f"\n- {chiave}: {valore}")
        
