'''GENERAZIONE CASUALE DEI PROFILI - SECONDO IL FORMATO SCELTO PostgreSQL '''


import random
from random import sample
from datetime import date, timedelta
from typing import Any


'''FUNZIONE GENERAZIONE PERSONE RANDOMICHE'''


def PersoneRandomiche (N:int) -> set[int]:

    risultato = 'INSERT INTO public.PERSONA(ID, NOME, COGNOME, POSIZIONE, STIPENDIO) VALUES \n'
      
    #Attraverso l'utilizzo di SAMPLE limitiam la creazione di duplicati 
    idPersone = sample(range(10000000), k=N)

    for elemento in range(N):
        idPersona = idPersone[elemento]

        nome =  str(random.randint(10000,1000000)) 
        cognome =  str(random.randint(10000,1000000)) 


        posizione = random.choice('RIcercatore', 'Professore Associato', 'Professore Ordinario')


        match posizione:

            case 'Ricercatore':
                minimoStipendio, massimoStipendio = 19000, 28000

            case 'Professore Associato' :
                minimoStipendio, massimoStipendio = 25000, 40000

            case 'Professore Ordinario':
                minimoStipendio, massimoStipendio = 30000, 100000

        stipendio = random.randint(minimoStipendio,massimoStipendio)

        risultato += f"{idPersona},\'{nome},\'\'{cognome},\'{posizione}\',{stipendio},\n" 
        print(risultato[:-2]+";" )
        return risultato
    


'''FUNZIONE GENERAZIONE PROGETTI RANDOMICI'''

def progettoRandomico (N:int) -> set[int]:

      risultato = 'INSERT INTO public.Progetto(ID, NOME, COGNOME, POSIZIONE, STIPENDIO) VALUES \n'
      
    

      idProgetti = sample(range(10000000), k=N)
      nomiProgetti = sample(range(10000000), k=N)
        
      progetti: dict[int,dict[str, Any]] = {}  

      for elemento in range(N):
            idProgetto = idProgetti[elemento]
            nome = nomiProgetti[elemento] 

            inizioSettimaneFa:int = random.randint(52+1,52*10)
            inizio = date.today() - timedelta(settimane=inizioSettimaneFa) 

            finettimaneFa:int = random.randint(52, inizioSettimaneFa-1)
            fine = date.today() - timedelta(settimane=inizioSettimaneFa) 
            
            budget = random.randint(10,5000) * 1000

            risultato += f"{idProgetto},\'{nome},\'\'{inizio.isoformat()},\'{fine.isoformat()}\',{budget},\n" 
            progetti[idProgetto] = { 'ID': idProgetto,
                                    'NOME' : nome,
                                    'INIZIO': inizio,
                                    'FINE' : fine
                                }

            print(risultato[:-2]+";" )
            return progetti


'''FUNZIONE GENERAZIONE PROJECT WORK RANDOMICI'''


def wpRandomico(N:int, progetti: dict[int, dict[str,Any]]) -> dict[int, list[dict[str,Any]]]:
    
    risultato = 'INSERT INTO public.WP(PROGETTO, ID, NOME, INIZIO, FINE) VALUES \n'
    wpPerProgetto = dict()

    for progettoId, dati in progetti.items():
        
            wpPerProgetto[progettoId] = []
            
            for elemento in range(N):
                
                wpId = elemento + 1
                
                nome = f"WP{wpId}_{progettoId}"
                inizio = dati['INIZIO'] + timedelta(giorni=random.randint(0, 60))
                fine = inizio + timedelta(giorni=random.randint(30, 300))

                risultato += f"({progettoId},{wpId},\'{nome}',\'{inizio.isoformat()}',\'{fine.isoformat()}'),\n"

                wpPerProgetto[progettoId]= { 'ID': wpId,
                                            'NOME': nome,
                                            'INIZIO': inizio,
                                            'FINE': fine
                                        }

    print(risultato[:-2] + ';')
    return wpPerProgetto



'''FUNZIONE GENERAZIONE ATTIVITA DI PROGETTO RANDOMICHE'''

def attivitaProgettoRandomiche(N:int, persone: list[int], progetti: dict[int, dict], wp: dict[int, list[dict]]) -> dict[int, list[dict[str,Any]]]:
    
    risultato = 'INSERT INTO public.AttivitaProgetto(ID, PERSONA, PROGETTO, WP, GIORNO, TIPO, OREDURATA) VALUES \n'

    for elemento in range(N):
        
        idAttivita = elemento + 1
        persona = random.choice(persone)
        progetto = random.choice(list(progetti.keys()))
        wpEntry = random.choice(wp[progetto])
        giorno = wpEntry['INIZIO'] + timedelta(gironi=random.randint(0, 30))
        tipo = random.choice(['Ricerca e Sviluppo', 'Dimostrazione', 'Management', 'Altro'])
        ore = random.randint(1, 8)

        risultato += f"({idAttivita},\{persona},\{progetto},\{wpEntry['ID']},\'{giorno.isoformat()}',\'{tipo}'\,{ore}),\n"

    print(risultato[:-2] + ';')



'''FUNZIONE GENERAZIONE ATTIVITA NON PROGETTUALI RANDOMICHE'''

def attivitaNonProgettualiRandomiche(N:int, persone: list[int]) -> dict[int, list[dict[str,Any]]]:
    
    risultato = 'INSERT INTO public.AttivitaNonProgettuale(ID, PERSONA, TIPO, WP, GIORNO, OREDURATA) VALUES \n'
    

    for elemento in range(N):
        
        idNonAttivita = elemento + 1
        persona = random.choice(persone)
        tipo = random.choice(['Didattica', 'Ricerca', 'Missione', 'Incontro Dipartimentale', 'Incontro Accademico'])
        wpFittizio = 1
        giorno = date.today() - timedelta(giorni=random.randint(0, 365*5))
        ore = random.randint(1, 8)

        risultato += f"({idNonAttivita},\{persona},\'{tipo}',\{wpFittizio}, \'{giorno.isoformat()}', \{ore}),\n"

    print(risultato[:-2] + ';')



'''FUNZIONE GENERAZIONE ASSENZE RANDOMICHE'''

def assenzeRandomiche(N:int, persone: list[int]) -> dict[int, list[dict[str,Any]]]:
    
    risultato = 'INSERT INTO public.ASSENZA(ID, PERSONA, TIPO, GIORNO, OREDURATA) VALUES \n'
    
    giorniOccupati = set()

    for elemento in range(N):
        idAssenza = elemento + 1
        persona = random.choice(persone)
        giorno = date.today() - timedelta(giorni=random.randint(0, 365*5))
        
        while (persona, giorno) in giorniOccupati:
            
            giorno = date.today() - timedelta(giorni=random.randint(0, 365*5))
        giorniOccupati.add((persona, giorno))
        
        tipo = random.choice(['Chiusura Universitaria', 'Maternita', 'Malattia'])
        ore = random.randint(1, 8)

        risultato += f"({idAssenza},{persona},'{tipo}','{giorno.isoformat()}',{ore}),\n"

    print(risultato[:-2] + ';')

    

        
