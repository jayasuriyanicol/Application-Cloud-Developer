'''IMPLEMENTAZIONI DELLE CLASSI in Python'''

from eBuy import *

def ultimo_bid(self) -> Bid | None:

    if not self._bid: 
        return None
    max_b = None

    for l in self._bids.values():
        if l.bid.istante <= datetime.now():
            if  max_b == None:
                max_b = l.bid
            else:
                if l.bid().istante() > max_b.istante():

                    max_b = l.bid()
    return max_b


def scaduta(self,i:datetime) -> bool:

    if self.scadenza() < i:
       return True
    return False


def vincitore(self) -> UtentePrivato | None:

    if not self.scaduta(datetime.now()):
        return None
    
    b = self.ultimo_bid(datetime.now())

    if b == None:

        return None
    return b.bid_ut().utente_privato()


def prezzo(self, i:datetime) -> FloatGEZ:

     B = [] 

     for l in self.asta_bid:

        if l.bid().istante() <= i:

             B.append(l.bid())
    
     N= len(B)

     result:FloatGEZ = self.prezzo  + N * self.prezzo_bid

     return result   