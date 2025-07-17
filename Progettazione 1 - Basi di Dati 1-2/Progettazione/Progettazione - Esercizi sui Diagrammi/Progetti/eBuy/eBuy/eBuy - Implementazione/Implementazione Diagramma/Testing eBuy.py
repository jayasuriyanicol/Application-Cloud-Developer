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

    #Impostiamo, come fatto per l'asta un minimo di rialzo pari ad 50 euro, nel caso minore alziamo un eccezzione
    try:
        asta.setPrezzoBid(RealGZ(50.00))
    except AttributeError as errorImpostazionePrezzoBid:
        print(f"\nErrore impostazione prezzo_bid: {errorImpostazionePrezzoBid}")


    print("\n\n\nVALORI CREAZIONE ASTA")
    print(asta)





    #Creiamo una funzione per testare le funzionalità di un Bid, nel caso di successo ritorniamo il bid con relativo messaggio, altrimenti None e messaggio d'errore
    def testBid(ora, utente, asta):

        try:
            bid = Bid(ora, utente, asta)
            print(f"\nSUCCESSO ! Il Bid di {utente.username()} è effettuato con successo alle '{ora}' !")
            return bid
        
        except Exception as erroreCreazioneBid:
            print(f"\nATTENZIONE ! Errore durante la creazione del bid dell'utente {utente.username()}: {erroreCreazioneBid}")
            return None

    #Creiamo due Bid uno per ogni utente a distanza di 5 minuti.
    PrimoBid = testBid(datetime.now().time(), utente1, asta)
    SecondoBid = testBid((datetime.now() + timedelta(minutes=5)).time(), utente2, asta)





    #Procediamo anche con la stampa del Bid effettuati da ogni utente, con un relativo messaggio completo che mostra l'orario del bid
    def stampaBidUtente(utente):
        print(f"\n\n\nBid EFFETTUATI dall'utente -> {utente.username()}")
        for refimentoBid in utente.bid():
            link = refimentoBid()
            if link:
                bid = link.bid()
                print(f"\n=> Bid delle ore {bid._istante} per L'asta sull'oggetto '{bid.asta()().descrizione()}'")

    stampaBidUtente(utente1)
    stampaBidUtente(utente2)





    #Infine mostriamo la stampa di tutti i Bid Effettuati da ogni utente, con un relativo messaggio completo che mostra l'orario del bid
    print("\n\n\nSTORICO DEI BID EFFETTUATI DAI UTENTI")
    for ref in asta.bidEffettuatiStorico():
        link = ref()
        if link:
            bid = link.bid()
            print(f"\n=> È stato effettuato un BID alle ore {bid._istante} dall'utente '{bid.privato()().username()}'")
