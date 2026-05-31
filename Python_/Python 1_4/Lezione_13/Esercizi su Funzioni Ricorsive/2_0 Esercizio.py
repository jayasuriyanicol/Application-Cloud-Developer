'''
Esercizio 2.

Si supponga di voler calcolare l'ammontare del denaro depositato su un conto bancario ad interesse composto. 
Se m è la somma depositata sul conto, la somma disponibile alla fine del mese sarà 1.005 volte m.
Scrivere una funzione ricorsiva compoundInterest che calcoli la somma presente sul conto dopo t mesi data una somma di partenza m.
'''

#Definiamo una funzione che calcola l'interesse in forma ricorsiva, in caso m sia zero ci sarà errore e 0, nel caso t sia 0 restituisce il saldo e l'ultimo calcola in forma ricorsiva l'ammontare
def recursiveCompoundInterest(m: float, t: int) -> float:
     
    if m < 0:
        print("Error! The value cannot be negative!")
        return 0  
    
    if t == 0:
        return m  
    
    return recursiveCompoundInterest(m * 1.005, t - 1)  

#Richiamiamo la funzione con una variabile e creiamo un messaggio per l'utente fuoir dalla funzione
final_amount = recursiveCompoundInterest(100, 2) 
print(f"Final amount after all months: {final_amount:.2f}")
