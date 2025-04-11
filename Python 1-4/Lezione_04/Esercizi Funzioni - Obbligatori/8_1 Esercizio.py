'''
8-1. Message: Write a function called display_message() that prints one sentence telling everyone what you are learning about in this chapter. 
Call the function, and make sure the message displays correctly.

'''

#Definiamo una funzione, che dato un mesaggio nella funzione, riporti quest'ultimo
def display_message():

    print("Che bello in questa lezione ho imparato come fare le funzioni !")
    return print
    
#Salviamo nella variabile contenuto, la chiamata a funzione senza parametro e la stampiamo
contenuto:str= display_message()
print(contenuto)

'''SOLUZIONE PIÙ VELOCE, senza l'ausilio di una variabile'''
display_message()