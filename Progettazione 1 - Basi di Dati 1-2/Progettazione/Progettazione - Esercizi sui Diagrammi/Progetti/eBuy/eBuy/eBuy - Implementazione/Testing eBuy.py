'''                                                                  TEST  PROGETTO eBuy                                                                                                     


Importiamo eBuy (main) e i suoi relativi TipiDato (all)
'''
from eBuy import *
from TipiDato import *


if __name__ == "__main__":


    #Procediamo con la creazione degli Utenti Privati e li stampiamo
    utente1 = Privato("Mario Rossi", datetime.now().date())
    utente2 = Privato("Francesco Bianchi", datetime.now().date())

    print(utente1)
    print(utente2)



    #Creaiamo l'asta per un PostOggetto messo in 'Asta', impostando la data di oggi più due giorni
    scadenza = datetime.now() + timedelta(days=2)

   #Creiamo l'asta impostando tutti i dati 
    asta = Asta(
        
        descrizione="Laptop Lenovo ThinkPad X1",
        anni_garanzia=IntGEZ(3),
        prezzo_iniziale=RealGEZ(1200.00),
        prezzo_rialzi=RealGZ(50.00),
        scadenza=scadenza
    )
