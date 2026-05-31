'''
Esercizio 3C-5. Scrivere un programma in Python che memorizzi il nome, il ruolo e l'età di un utente in un dizionario. 
Il nome, il ruolo e l'età devono essere inseriti in input dall'utente stesso. 
Il programma deve determinare il livello di accesso ai servizi in base al ruolo e all'età dell'utente secondo questo schema:

- Admin → "Accesso completo a tutte le funzionalità."
- Moderatore → "Può gestire i contenuti ma non modificare le impostazioni."
- Utente adulto (età ≥ 18) → "Accesso standard a tutti i servizi."
- Utente minorenne (età < 18) → "Accesso limitato! Alcune funzionalità sono bloccate."
- Ospite → "Accesso ristretto! Solo visualizzazione dei contenuti."
- Ruolo non riconosciuto → "Attenzione! Ruolo non riconsciuto! Accesso Negato!"

Expected Output:

Digitare nome dell'utente: Mario Rossi
Digitare ruolo dell'utente: admin
Digitare l'età dell'utente: 30
Output: Accesso completo a tutte le funzionalità.

- - - - - - - - - - - - - - - - - - - - - - - - - - -

Digitare nome dell'utente: Giulia Bianchi
Digitare ruolo dell'utente: utente
Digitare l'età dell'utente: 16
Output: Accesso limitato! Alcune funzionalità sono limitate!

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digitare nome dell'utente: Sara Neri
Digitare ruolo dell'utente: vip
Digitare l'età dell'utente: 22
Output: Attenzione! Ruolo non riconosciuto! Accesso Negato!

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Digitare nome dell'utente: Luca Verdi
Digitare ruolo dell'utente: moderatore
Digitare l'età dell'utente: 25
Output: Salve Luca Verdi! Può gestire i contenuti ma non modificare le impostazioni.

'''

#Dizionario dove salviamo tute le nostre CHIAVI con relativi VALORI che inseriremo in INPUT
anagrafica = {}


#Messaggio di benvenuto e spiegazione del programma e successivamente inserimento dei valori NOME,RUOLO e ETÀ che verranno memorizzati sul DICT
print("\n\nBenvenuto, questo programma memorizza in input il tuo: NOME, RUOLO e ETÀ e ti farà entrare (ovvero accedere al sistema), secondo un criterio pre-stabilito.\n\n")

anagrafica["nome"] = str(input("Per proseguire, prego, inserire il proprio NOME: "))


anagrafica["ruolo"] = str(input("\n\nInserire il proprio RUOLO all'interno della compagnia/azienda: "))

anagrafica["età"]= int(input("\n\nInfine, per concludere servirebbe la sua ETÀ: "))



#Match STATEMENT direttamente sulla chiave RUOLO, in base a quello inserito uscirà il relativo output. IL CODICE È STATO MIGLIORATO andando fuori EXPECTED OUTPUT, per abbellimento e visualizzazione.
match anagrafica["ruolo"]:

    case "admin":
         print(f"\n\nBENVENUTO {anagrafica['nome'].upper()} !\n\nFUNZIONALITÀ DISPONIBILI COME RUOLO DI {anagrafica['ruolo']} : \n\n| Accesso completo a tutte le funzionalità |")
    case "moderatore":
         print(f"\n\nBENVENUTO {anagrafica['nome'].upper()} !\n\nFUNZIONALITÀ DISPONIBILI COME RUOLO DI {anagrafica['ruolo']} : \n\n| Può gestire i contenuti ma non modificare le impostazioni |")
    case "utente adulto":
          if anagrafica["età"] >= 18 :
               print(f"\n\nBENVENUTO {anagrafica['nome'].upper()} !\n\nFUNZIONALITÀ DISPONIBILI COME RUOLO DI {anagrafica['ruolo']} : \n\n| Accesso standard a tutti i servizi |")
          else:
               print(f"\n\nATTENZIONE ! {anagrafica['nome'].upper()} IL RUOLO INSERITO NON SODDISFA I CRITERI!\n\nIl suo ruolo è stato inserito COME RUOLO DI 'utente maggiorenne', quindi VERRÀ RIPRINISTINATO COME RUOLO DI 'UTENTE MINORENNE', data l'età inserità di {anagrafica['età']} anni.\n\n Quindi gli ACCESSI DISPONIBILI sono : \n\n| Accesso limitato ! Alcune funzionalità sono bloccate |")
               
    case "utente minorenne":
           if anagrafica["età"] <= 18 :
               print(f"\n\nBENVENUTO {anagrafica['nome'].upper()} !\n\nFUNZIONALITÀ DISPONIBILI COME RUOLO DI {anagrafica['ruolo']} : \n\n| Accesso limitato ! Alcune funzionalità sono bloccate |")
    
    case  "ospite":
          print(f"\n\nBENVENUTO {anagrafica['nome'].upper()} !\n\nFUNZIONALITÀ DISPONIBILI COME RUOLO DI {anagrafica['ruolo']} : \n\n| Accesso ristretto! Solo visulizzazione dei contenuti |")
         
    
    case _ :
          print(f"\n\n ATTENZIONE ! {anagrafica['nome'].upper()} !\n\nERRORE NON PRESENTE NELL'ELENCO {anagrafica['ruolo']} : \n\n| Attenzione! Ruolo non riconosciuto! Accesso Negato ! |")
          

         
               

    
                

