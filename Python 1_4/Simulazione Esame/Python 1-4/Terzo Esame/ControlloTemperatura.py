


def check_temperature(temp: float, auto_mode: bool) -> str:

    if (18 <= temp <=25) or auto_mode:

        return "Sicuro"

    else:
       return "Allarme"



print(check_temperature(27, False) )
print(check_temperature(20, False) )
print( check_temperature(27, True) )





