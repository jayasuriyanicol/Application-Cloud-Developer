'''

Esercizio 2 (intermedio – con dizionario)

Scrivi un programma che simuli un conteggio voti:

Chiedi all’utente di inserire più voti (nomi dei candidati).

Salva i voti in un dizionario.

Alla fine mostra chi ha preso più voti e il numero totale di voti.

'''

dizionarioCandidati:dict[str,int] = {}
numeroTotaleVoti:float = 0
lunghezzaPiùAlta:int = 0
messaggioPersona:str = ''

while True:

    nomeCandidato:str = str(input("Benvenuto, inserisci il NOME DEL CANDIDATO: "))

    if nomeCandidato.lower() == "fine":
        break
    voto = 1

    if nomeCandidato not in dizionarioCandidati:

        dizionarioCandidati[nomeCandidato] = 0
        
    dizionarioCandidati[nomeCandidato] += voto  
    


    opzione:str = str(input("Vuoi continuare ad inserire voti per un'altro CANDIDATO (scrivere si o no ) ? "))

    if opzione == 'si':
            continue
    else:
        break
            

    
      
print("\n\n| CRONOLOGIA VOTI OTTENUTI PER PERSONA |")
for chiave,valore in dizionarioCandidati.items():
         
    lunghezzaVoti:int = valore
    messaggioPersona = f"\n\nPersona {chiave} ha ricevuto -> {lunghezzaVoti} voti"
    print(messaggioPersona)
    numeroTotaleVoti += lunghezzaVoti

    if lunghezzaVoti > lunghezzaPiùAlta:

        lunghezzaPiùAlta = lunghezzaVoti
        vincitore = chiave

print(f'\n\nSOMMARIO:\nNUMERO TOTALE VOTI COMPLESSIVI -> {numeroTotaleVoti}\nVINCITORE {vincitore} con {lunghezzaPiùAlta} voti')
    
