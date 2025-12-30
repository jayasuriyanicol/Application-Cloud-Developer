'''
4. Text Analysis:

    Create a function that takes a paragraph and counts the number of occurrences of each word.
    The function should print a report showing the most frequent words and their number of occurrences.
    You can use a for loop to iterate over the words in the text and a dictionary to store the occurrences.
    Implement error handling to handle missing files or other input issues.

'''

#Definiamo un funzione che comta le parole in una frase, senza considerare la PUNTEGGIATURA e SIMBOLI. Solo l'utilizzo della parole che servono.
def paragraphCounts():

    paragraph:str = input("Welcome, please write down a sentece: ")

   #Se nell'input non viene riportato nulla appare un messaggio di errore che dice di inserire qualcosa ad eccezione di caratteri speciali 
    if not paragraph:
        error = print("\nAttention ! Error please write down something EXCEPT (?!,;,eccetera)")

   #Ogni parola viene salvato nella variabile words che assumera le sembianze di una LISTA grazie al metodo BUILT-IN split che 'SPLITTA' ogni parola all'interno din una lista
    words:str = paragraph.lower().split()
    word_count:dict =  {} 

   #Per ogni parola nella variabile words andiamo a togliere questi eventuali simboli e punteggiature 
    for word in words:

        word = word.strip ("?!,;()")
        
       #Ora ogni parola che abbiamo preso se non presente nel dizionario andiamo ad aggiungere 1 se invece presente incrementiamo di 1 quest'ultimo 
        if word:
            if word in word_count:
                word_count[word] +=  1
            else:
                word_count[word] = 1
    
   #Successivamenete andiamon a stampare i relativi valori uno per uno in OUTPUT dai i valori presenti del DICT. 
    for key,value in word_count.items():

        print(f"\nIn the sentence the word '{key}' appears almost : {value} times !")

#Richiamiamo la funzione in modo che funzioni tutto il processo, non passiamo niente come parametro
paragraphCounts()