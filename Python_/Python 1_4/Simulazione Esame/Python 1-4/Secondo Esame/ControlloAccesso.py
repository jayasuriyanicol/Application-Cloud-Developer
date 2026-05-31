'''
Controllo Accesso - PUNTI 1
Scrivi una funzione che verifichi se l'accesso è consentito.
L'accesso è consentito se il badge è valido e (il pin è corretto oppure l'override admin è attivo).
La funzione deve ritornare "Accesso consentito" oppure "Accesso negato".
check_access(badge: bool, pin: bool, admin_override: bool) -> str

'''


def check_access(badge: bool, pin: bool, admin_override: bool) -> str:



    if badge == True:

        if pin == True or admin_override == True:

            return "Accesso consentito"
        
        else:
           
           return "Accesso negato"
    
        
    else:
           return "Accesso negato"
        

        

print(check_access(badge=True,pin=True,admin_override=True))

print(check_access(badge=True,pin=False,admin_override=False))