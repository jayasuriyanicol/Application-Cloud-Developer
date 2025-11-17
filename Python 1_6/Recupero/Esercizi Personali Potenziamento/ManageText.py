'''''
Esercizio 3 (avanzato – gestione testo)

Scrivi un programma che chieda una frase e:

stampi tutte le parole in ordine alfabetico,

stampi le parole senza duplicati, ok

stampi le parole ordinate per lunghezza. ok


'''

from string import punctuation

fraseUtente:str = str(input("Benvenuto, per procedere per favore inserire una frase: "))

fraseUtente += ' '

#Accorrtezza in più per evitare che nella frase venga accorpata anche parte che comprende la punteggiatura
for elementoSpeciale in punctuation:

    fraseUtente = fraseUtente.replace(elementoSpeciale, '')



indiceCarattere:int = 0
indice:int = 0 
paroleOrdinate:list[str] = [] 
paroleAlfabetiche:list[str] = [] 
listaParole:list[str] = []   
parola = ''


while indiceCarattere < len(fraseUtente):

    char:str = fraseUtente[indiceCarattere] 

    if char != " ":

        parola += char
    else:

        if parola and parola not in listaParole:
           listaParole.append(parola)
        parola = ''

    indiceCarattere += 1


paroleOrdinate:list[str] = sorted(listaParole,key=len)
paroleAlfabetiche:list[str] = sorted(listaParole)  


    

print(f"\nSOMMARIO ELEMENTI DELLA FRASE -> {fraseUtente}\n\nQuesta è la LISTA delle parole in ordine alfabetico -> {paroleAlfabetiche}\n\nQuesta è la LISTA delle parole in ordine di LUNGHEZZA -> {paroleOrdinate}\n\nQueste sono le parole senza i DUPLICATI: {listaParole}")




'''

Possiamo utilizzare anche la forma con SORT al posto di SORTED, rendendo ancora più efficiente l'esercizio computazionalmente parlando.



        paroleOrdinate:list[str] = listaParole.sort(key=len)
        paroleAlfabetiche:list[str] = listaParole.sort() 


'''