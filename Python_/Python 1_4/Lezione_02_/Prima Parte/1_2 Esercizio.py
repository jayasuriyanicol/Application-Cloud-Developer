'''
1-2. Si scriva un programma che dimostri le funzionalità dell'operatore % effettuando le seguenti attività:

    Memorizzare un numero in virgola mobile nella variabile x.
    Calcolare x%2.0 e memorizzare il risultato nella variabile y.
    Visualizzare in maniera distinta x e y.

Si esegua il programma con valori positivi e negativi di x. Che cosa cambia nel comportamento dell’applicazione 
quando i valori di x sono positivi o negativi?

'''
#Inserimento del numero in virgola mobile
x = float(input("Inserisci un numero in virgola mobile (positivo o negativo): "))

#Calcolo numero pari
y = x % 2.0

#Output dei risultati
print(f"Il valore di x è: {x}")
print(f"Il risultato di x % 2.0 è: {y}")



'''
Cosa cambia con valori positivi e negativi?
Con un numero positivo, l'operatore % restituisce semplicemente il resto della divisione.
 Con un numero negativo, il resto viene calcolato in modo tale che il risultato sia sempre non negativo. 
 Anche se x è negativo, il risultato di % sarà sempre positivo, perché Python calcola il resto come:
y=x−(divisore)×int(x/divisore)
Anche se x è negativo, il resto mantiene lo stesso segno del divisore, che in questo caso è positivo. 
'''