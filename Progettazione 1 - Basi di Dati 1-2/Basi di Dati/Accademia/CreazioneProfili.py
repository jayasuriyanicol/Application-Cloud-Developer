'''GENERAZIONE CASUALE DEI PROFILI - SECONDO IL FORMATO SCELTO '''


import random
from random import sample
from datetime import date, timedelta
from typing import Any


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
        


            
