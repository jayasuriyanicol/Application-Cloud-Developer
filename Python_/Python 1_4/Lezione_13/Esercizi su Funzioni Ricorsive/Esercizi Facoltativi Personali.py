




'''                                                         |ESERCIZI FACOLTATIVI PERSONALI|                                                                       '''



'''

🧩 Esercizio 1 – String Cleaner

Obiettivo:
Scrivi una funzione ricorsiva removeChar che riceva una stringa s e un carattere c,
e ritorni una nuova stringa con tutte le occorrenze del carattere c rimosse.
Esempi:

removeChar("banana", "a") ➝ "bnn"
removeChar("ciao", "c") ➝ "iao"

'''



def recursiveRemoveChar(s:str, c:str) -> str:

    if not s:
        return ""
    
    if s[0] == c:

        return recursiveRemoveChar (s[1:],c ) 
    
    else:
        return s[0] + recursiveRemoveChar (s[1:],c)
    

print(recursiveRemoveChar("famiglia", "a"))




'''🔢 Esercizio 2 – Somma delle cifre

Obiettivo:
Scrivi una funzione ricorsiva digitSum che riceva un numero intero positivo n
e ritorni la somma di tutte le sue cifre.
Esempi:

digitSum(123) ➝ 6        # 1 + 2 + 3
digitSum(5091) ➝ 15       # 5 + 0 + 9 + 1

'''

def recursiveDigitSum(n:int) -> int:

    if n == 0:
        return 0
    
    else:
        return n % 10 + recursiveDigitSum (n//10) 
    

print(recursiveDigitSum(1213))

