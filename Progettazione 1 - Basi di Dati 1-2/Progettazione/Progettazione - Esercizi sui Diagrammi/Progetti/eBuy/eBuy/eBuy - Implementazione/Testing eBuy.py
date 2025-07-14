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

