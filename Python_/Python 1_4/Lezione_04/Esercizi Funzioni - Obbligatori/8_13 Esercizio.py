'''
8-13. User Profile:  Build a profile of yourself by calling build_profile(), using your first and last names and three other key-value
pairs that describe you. All the values must be passed to the function as parameters. 
The function then must return a string such as "Eric Crow, age 45, hair brown, weight 67"

'''
#Defenisco una funzuione che prende come parametro tutti i dati per completare il profilo, creando una frase a doc richiesta dall'esericizio
def build_profile(name, surname, age, hair, weight):
    profilo = f"{name} {surname}, età {age}, capelli {hair}, peso {weight}"
    return profilo

#Inseriamo da input tutte le informazioni richieste per completare il profilo, verificando che l'età sia un numero intero.
name = input("Inserisci il NOME: ")
surname = input("Inserisci il COGNOME: ")
age = int(input("Inserisci l'ETÀ: "))  
hair = input("Inserisci il colore dei CAPELLI: ")
weight = input("Inserisci il PESO: ")

#Faccio una chiamata a funzione con tutti i parametri del profilo, salvandolo in una variabile "user_profile" e stampando il messaggio richiesto dalla traccia
user_profile = build_profile(name, surname, age, hair, weight)
print(user_profile)




