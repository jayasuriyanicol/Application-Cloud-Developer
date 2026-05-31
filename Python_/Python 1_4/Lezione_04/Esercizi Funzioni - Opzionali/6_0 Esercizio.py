''''
6. Password Generator:

    Create a function that generates a random password with a specified length and desired character types 
    (lowercase letters, uppercase letters, numbers, symbols).
    Allow the user to specify the password length and desired character types.
    Generate and return a random password that meets the user's criteria.

'''

#Importiamo le librerie di RANDOM e STRING per utilizzare le funzioni RANDOM e dei caretteri delle STRINGHE come ci viene richiesto dall'esercizio
import random,string

#Definiamo una funzione che ci crea la PASSWORD, aggiungendo i vari caratteri se RICHIESTI e la sua relativa lunghezza. In caso di nessuno carattere inserito uscirà un messsaggio di ERRORE.
def randomPassword(length: int, uppercase: bool, lowercase: bool, numbers: bool, symbols: bool) -> str:
    characters = []

   
    if uppercase:
        characters.extend(string.ascii_uppercase)

    
    if lowercase:
        characters.extend(string.ascii_lowercase)

    
    if numbers:
        characters.extend(string.digits)

    
    if symbols:
        characters.extend(string.punctuation)

    
    if not characters:
        print("ERROR! You need to have at least one character type selected!")
        return None

   #Attraverso JOIN e le librerie IMPORT e STRING per quanto rigaurda i caratteri andiamo a costruire la nostra PASSWORD, che seguirà i CRITERI scelti dall'utente.
    password = ''.join(random.choice(characters) 
                       
                       for i in range(length))

    return password


#Definiamo una funzione che ci chiede la lunghezza e l'aggiunta o meno dei caraetteri, simboli e numeri per costruire la nostra password e dopo averla costruita ce la stampa in OUTPUT.
def criteriaPassword() -> None:
    
    length = int(input("\nWelcome, write down the LENGTH for your PASSWORD: "))

    
    print("\nWrite down the CHARACTER TYPES you want to ADD to your PASSWORD\n\nResponse with YES or NO:")
    uppercase = input("\nDo you want to include UPPERCASE letters? ").lower() == 'yes'
    lowercase = input("\nDo you want to include LOWERCASE letters? ").lower() == 'yes'
    numbers = input("\nDo you want to include NUMBERS? ").lower() == 'yes'
    symbols = input("\nDo you want to include SYMBOLS? ").lower() == 'yes'

    
    password = randomPassword(length, uppercase, lowercase, numbers, symbols)

    
    if password:
        print(f"\nPERFECT! Here is your CRITERIA PASSWORD: \n\n{password}")


#Richiamiamo la funzuione principale per l'inserimento dei dati per la PASSWORD
criteriaPassword()
