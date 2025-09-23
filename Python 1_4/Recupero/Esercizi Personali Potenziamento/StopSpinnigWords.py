'''
Description:

Write a function that takes in a string of one or more words, and returns the same string, but with all words that have five or more letters reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:

"Hey fellow warriors"  --> "Hey wollef sroirraw" 
"This is a test        --> "This is a test" 
"This is another test" --> "This is rehtona test"

'''


def spin_words(sentence):

    frasi:list[str] = []  
    frase = ""
    fraseFinale = ""



    for elemento in sentence:

            if elemento != " ":

                frase += elemento

            else:
                frasi.append(frase)
                frase = ""
    if frase:
         
        frasi.append(frase)

        
    for indice,parola in enumerate(frasi):

            if len(parola) >= 5:

                parolaInversa = parola[::-1] 
                fraseFinale += (" " if indice > 0 else "")+ parolaInversa

            else:

                fraseFinale += (" " if indice > 0 else "") + parola

    return fraseFinale


            
print(spin_words("Hey Welcome"))       
print(spin_words("Ciao mondo bello"))  
print(spin_words("Prova"))           



'''Una SOLUZIONE più semplice sintatticamente e di COSTO COMPUTAZIONALE 
   più basso potrebbe essere la seguente:'''


'''
def spin_words(sentence) -> str:
     
    fraseSuddivisa:str = sentence.split()
    risultato:list  = []


    for parola in fraseSuddivisa:

        if len(parola)> 5:
             
           risultato.append(parola[::-1])
        else:
            risultato.append(parola)

    return " ".join(risultato)


print(spin_words("Hey Welcome"))       
print(spin_words("Ciao mondo bello"))  
print(spin_words("Prova"))      

'''