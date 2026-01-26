'''
Esercizio:  Dato una stringa in caratteri minuscolo inseriti da input, questo deve dare di nuovo in output come risultato:

1. IL PRIMO CARATTERE DI OGNI STRINGA IN MAIUSCOLO
2. IL PRIMO E L'ULTIMO CARATTERE DELLA STRINGA IN MAIUSCOLO


'''


stringa = input("Benvenuto, inserisci una stringa in MINUSCOLO: ")

nuova_stringa = stringa.title()

print("Questa è la nuova stringa con l'inizio di ogni parola in MAIUSCOLO: ", nuova_stringa)

parole = stringa.split()
risultato = []

for parola in parole:
    if len(parola) > 1:
        nuova_parola = parola[0].upper() + parola[1:-1] + parola[-1].upper()
    else:
        nuova_parola = parola.upper()
    
    risultato.append(nuova_parola)


stringa_finale = " ".join(risultato)
print("Stringa con il primo e ultimo carattere di ogni parola in MAIUSCOLO:", stringa_finale)



'''  |METODO ALTERNATIVO|

Metodo alternativo del codice creato precedentemente: 


frase:str = input("Insersci una frase: ")

parole:str = frase.title()

result: list[str] = []

for parola in parole:
p_in = parola [:-1]
p_ultimo = parola[-1]
nuova= p_in + p_ultima.upper()
result.append(nuova) 

print(" ".join(result))

'''