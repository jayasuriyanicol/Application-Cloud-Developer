'''

Esercizio 2 (intermedio – con dizionario)

Scrivi un programma che simuli un conteggio voti:

Chiedi all’utente di inserire più voti (nomi dei candidati).

Salva i voti in un dizionario.

Alla fine mostra chi ha preso più voti e il numero totale di voti.

'''
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
    
'''

'''-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- '''

'''|SOLUZIONE AVANZATA|

Aggiungiamo delle stessa soluzione, rendendola un pelino più complicata con l'aggiunta di voti veri e propri in maniera decimnale per ogni candidato

'''


dizionarioCandidati: dict[str, list[float]] = {}

while True:
   
   #Inserimento con TRY and EXCEPT per verificare se i dati inseriti sono corretti 
    try:
        nomeCandidato:str = str(input("Inserisci il NOME DEL CANDIDATO (o 'fine' per uscire): "))
    
    except ValueError:

        print("ATTENZIONE ! Devi inserire un nome valido (STRINGA).")
        continue

    
    if nomeCandidato.lower() == "fine":
        break

    try:
        voto = float(input(f"Inserisci il voto per {nomeCandidato}: "))

    except ValueError:

        print("ATTENZIONE ! Devi inserire un numero valido (INTERO o REALE).")
        continue

    #Nel caso corretti aggiungiamo i candiati con i loro voti all'interno del dizionario. Nel caso nuovo: candidato -> null sennò se presente: candidato -> voto 
    if nomeCandidato not in dizionarioCandidati:

        dizionarioCandidati[nomeCandidato] = []

    dizionarioCandidati[nomeCandidato].append(voto)


    #Nel caso vogliamo continuare 'si' sennò SOMMARIO con ciclo iterativo nel dizionario per decretare il vincitore 
    opzione: str = input("Vuoi continuare ad inserire voti (si/no)? ").lower()

    if opzione != "si":
        break



print("\n\nSOMMARIO RISULTATI:")

totaleVoti = 0
vincitoreFinale = None
mediaVincitore = 0

for candidato, voti in dizionarioCandidati.items():

    numeroVoti = len(voti)
    totaleVoti += numeroVoti
    media = sum(voti) / numeroVoti
    print(f"- {candidato}: {numeroVoti} voti, media {media:.2f}, totale {sum(voti):.2f}")

  
    if media > mediaVincitore:

        mediaVincitore = media
        vincitoreFinale = candidato



print(f"\n\nNumero Totale voti: {totaleVoti}")
print(f"\n\n\nIl Vincitore FINALE: {vincitoreFinale} con media {mediaVincitore:.2f}")
