'''
Esercizio 1.
 
Nota.
Prima di scivere la funzione in Python, è obbligatorio produrre uno schema che rappresenti ricorsivamente quanto richiesto.
Dopo aver prodotto lo schema, procedere con l'implementazione solo quando indicato dal docente.
 
Una stringa palidroma, è una stringa che non cambia anche se letta al contrario, come la stringa "radar". 
Si scriva una funzione ricorsiva chiamata recursivePalindrome() che accetti in input un parametro di tipo stringa e restituisca True se l'argomento è un palindromo e False altrimenti.

Non si tenga conto degli spazi nella stringa e non si faccia distinzione tra lettere maiuscole e minuscole.

La funzione dovrebbe considerare palindrome le seguenti stringhe:
"radar"
"Anna"
"I topi non avevano nipoti"

La funzione non dovrebbe considerare palindrome le seguenti stringhe:
"casa"
"Marta"
"Roma e Amore"

Suggerimento: usare la funzione replace() per sostituire gli spazi con una stringa vuota.

'''



def recursivePalindrome(stringa:str)-> bool:


    #Partiamo con il caso base assumendo che la nostra stringa sia vuota e poi procediamo con gli altri casi
    if stringa == "":

        return "ATTENZIONE ! La stringa inserita è vuota !", None
    
    #Attuiamo la rimozione degli spazi utlizzando il replave e convertendo la stringa in minuscolo, salviamo successivamente la variabile nella stringa originale
    rimozioneSpaziStringa:str = stringa.replace(" ", "").lower()
    
    stringa = rimozioneSpaziStringa


    if len(stringa) <= 1:

        return True
    

    if stringa[0] == stringa[-1]:

        return recursivePalindrome(stringa[1:-1])
    return False







print(recursivePalindrome("a"))
print(recursivePalindrome("radar"))
print(recursivePalindrome("I topi non avevano nipoti"))
print(recursivePalindrome(""))







