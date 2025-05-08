'''
2. Password Validation:  Write a function validate_password(password) that checks whether a password meets 
the following criteria: Minimum length of 20 characters,
At least three uppercase letters, At least four special characters (non-alphanumeric).
If the password is valid, the function should return True. 
If the password is invalid, the function should raise a built-in exception (e.g., ValueError) with a message indicating which criteria were not met.
'''
#Importiamo le stringhe e successivamente procediamo con le verifiche del caso.
import string

#Nella funzione andiamo a verificare che la lunghezza sia 20 char, in più che le lettere maiuscole siano e ed i caratteri speciali 4. In caso negativo darà un ValueError indirizzato, in caso posito invece True
def validate_password(password:str) -> bool:
    errors = []

    
    if len(password) < 20:
        errors.append("\nAttention ! Password must be at least 20 characters long.")
    
    upper_pass = 0
    for c in password:
        if c.isupper():
            upper_pass += 1
    
    if upper_pass < 3:
        errors.append("\nAttention ! Password must contain at least three uppercase letters.")

    special_pass = 0
    for c in password:
        if c in string.punctuation:
            special_pass += 1
    
    if special_pass < 4:
        errors.append("\nAttention ! Password must contain at least four special characters.")

    if errors:
        raise ValueError(" ".join(errors))

    return True


#Richiamiamo la funzione e andiamo a verificare per il primo caso sia vero, mentre per il secondo siano errori centralizzati.
print(validate_password("NicoL#!_?0ErADfewqaZZ"))
print(validate_password("NicoL#!_?0ErADfeZz"))
    
   
    




















