'''
Controllo Temperatura – PUNTI 1

Scrivi una funzione che controlli la sicurezza di un sistema di riscaldamento.
Il sistema si considera sicuro se la temperatura è compresa tra 18 e 25 gradi, oppure se è attivo il modo automatico.

La funzione deve ritornare "Sicuro" oppure "Allarme".

check_temperature(temp: float, auto_mode: bool) -> str


📘 Esempio:

check_temperature(27, False) ➜ "Allarme"  
check_temperature(20, False) ➜ "Sicuro"  
check_temperature(27, True)  ➜ "Sicuro"



'''

def check_temperature(temp: float, auto_mode: bool) -> str:

    if (18 <= temp <=25) or auto_mode:

        return "Sicuro"

    else:
       return "Allarme"



print(check_temperature(27, False) )
print(check_temperature(20, False) )
print( check_temperature(27, True) )





