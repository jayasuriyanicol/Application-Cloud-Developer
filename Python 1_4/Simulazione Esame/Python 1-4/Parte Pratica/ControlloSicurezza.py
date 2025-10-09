'''
ESERCIZIO NUMERO 5

Controllo Sicurezza - PUNTI 1
Scrivi una funzione che verifica se una combinazione di sensori (S1, S2, S3) attiva l'allarme.
L'allarme si attiva solo se S1 è vero e (S2 o S3 è falso). 

La funzione deve ritornare "Allarme
attivato" oppure "Nessun allarme" a seconda delle condizioni.
check_security_alarm(s1: bool, s2: bool, s3: bool) -> str

'''


def check_security_alarm(s1: bool, s2: bool, s3: bool) -> str:


    if s1 == True:
        if s2 == False or s3 == False:

          return "Allarme attivato"
        else:
           return "Nessun allarme"
    else:
        return "Nessun allarme"

#Oppure, in alternativa con l'utilizzo del NOT:


'''
if s1==True (not s2 or not s3 ):
        return "Allarme attivato"

else:
    return "Nessun allarme"

'''


    
print(check_security_alarm(s1=True,s2=False,s3=False))
print(check_security_alarm(s1=False,s2=False,s3=True))
