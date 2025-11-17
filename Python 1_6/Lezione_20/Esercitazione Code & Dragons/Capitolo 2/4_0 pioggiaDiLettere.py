'''
CAPITOLO 2 - ESERCIZIO NUMERO 3

Pioggia di Lettere

Le pergamene si coprono di incisioni: conta quante volte ogni simbolo riappare, 
ignorando le macchie. Applica `letter_count(text)` per conteggiare solo lettere 
(in minuscolo), escludendo tutto il resto. Mantieni la firma e promuovi i test.

'''

from string import punctuation

def letter_count(text: str) -> dict[str,int]:
    
    testoPiatto:str = ""
    dizionarioLettere:dict = {} 
    

    testoPiatto = text.lower()
    

    for elementoSpeciale in punctuation:

        testoPiatto = testoPiatto.replace(elementoSpeciale, "")
        testoPiatto = testoPiatto.replace(" ","")

  


    for lettera in testoPiatto:
        
        if lettera in dizionarioLettere.keys():

             dizionarioLettere[lettera] += 1
        else:

            dizionarioLettere[lettera] = 1


    return dizionarioLettere 



print(letter_count('AaB@'))
    