from __future__ import annotations
from typing import TYPE_CHECKING
'''IMPLEMENTAZIONE eBuy in Linguaggio Python'''



'''IMPORT per l'implementazione'''


from abc import ABC, abstractmethod
from typing import *
from datetime import datetime, timedelta
from TipiDato import *
import weakref



'''Al fine dell'evitare errori 
if TYPE_CHECKING:
    from py.classes.Bid import Bid
        cosi via per ogni classe che ci serve ...
'''





'''Creazione classe UTENTE'''

class Utente(ABC):

    _username : str  #valore <<imm>> {id}
    _registrazione: datetime  #valore <<imm>


    @abstractmethod
    def __init__(self, username:str, registrazione: datetime) -> None:
        
        #Verifichiamo che venga assegnato un corretto valore per 'username'
        if username:
            self._username = username
        else:
            raise AttributeError("ATTENZIONE ! il valore dell'attributo '_username' non può essere nullo (None) o vuoto")
        self._registrazione = registrazione

    def username(self) -> str:
        return self._username

    def registrazione(self) -> datetime.date:
        return self._registrazione
    
    #Mostriamo i dati dell'utente "Registrato" 
    def __str__(self) -> str:
        return f"\n\nL'utente: '{self.username()}'\n\nRisulta essere REGISTRATO CORRETTAMENTE in data: '{self.registrazione()}'"
    


'''Creazione classe PRIVATO (UtentePrivato)'''


class Privato(Utente):

    _bidEffettuatiUtente: dict[Bid, bid_ut._link] #link associazione con la classe Bid(bid_ut) 

    def __init__(self, username:str, registrazione:datetime.date)-> None:
        super().__init__(username, registrazione)

        self._bidEffettuatiUtente = dict()

        '''La classe PRIVATO non presenta attributi specifici'''



    def bid(self) -> frozenset[weakref[bid_ut._link]]:

        riferimentoBid = set()

        for l in self._bidEffettuatiUtente.values():

            riferimentoBid.add(weakref.ref(l))

        return frozenset(riferimentoBid)
                    


    def _aggiungiBid(self, linkBid: bid_ut._link) -> None:

        if linkBid.privato() is not self:

            raise ValueError("ATTENZIONE ! Il link ERRATTO !")
        
        if linkBid.bid() in self._bidEffettuatiUtente:

            raise KeyError(f"ATTENZIONE ! I link duplicati -> ({self}, {linkBid.bid()}) NON sono ammessi !")
        
        self._bidEffettuatiUtente[linkBid.bid()] = linkBid




'''Creazione della CLASSE Bid'''

class Bid:

    _istante: datetime.time #valore <<imm>> 
    _privato: Privato #link associazione con la classe Privato (bid_ut) 
    _asta: Asta #link associazione con la classe Asta(asta_bid) 


    def __init__(self, istanteBid: datetime.time, privato: Privato, asta: Asta) -> None:
        
        self._istante = istanteBid
        self._privato = None
        self._asta = None

        '''Riferimento ai due link a cui è collegata la classe Privato'''
        bid_ut._add(self, privato)
        asta_bid._add(self, asta)




    def privato(self) -> weakref[Privato] | None:

        if self._privato:
            return weakref.ref(self._privato) 
        else:
            None
        
    def asta(self) -> weakref[Asta] | None:

        if self._asta:
            return weakref.ref(self._asta)
        else:
            None

    def _setPrivato(self, linkPrivato: bid_ut._link) -> None:

        if self.privato() is not None:

            raise ValueError("ATTENZIONE ! Questo bid è già esistente in un link con un'altro UTENTE PRIVATO !")
        
        if linkPrivato.bid() is not self:

            raise ValueError("ATTENZIONE ! Il link ERRATO !")

        self._privato = linkPrivato.privato()
    
    def _setAsta(self, linkAsta: asta_bid._link) -> None:

        if self.asta() is not None:

            raise ValueError("ATTENZIONE ! Questo bid è già esistente in un link con un'altra ASTA !")
        
        if linkAsta.bid() is not self:

            raise ValueError("ATTENZIONE ! Il link non COINVOLGE ME !")

        self._asta = linkAsta.asta()
    

    def __hash__(self) -> int:
        return hash((self._istante, self._privato, self._asta))

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, Bid):
            return False
        return (self._istante == other._istante and
                self._privato == other._privato and
                self._asta == other._asta)



   
'''Creazione della classe POST OGGETTO'''


class PostOggetto(ABC):

    _descrizione: str
    _prezzo: RealGEZ
    _anni_garanzia: IntGEZ

    @abstractmethod
    def __init__(self, descrizione:str, anni_garanzia:IntGEZ, prezzo:RealGEZ) -> None:

        self.setDescrizione(descrizione)
        self.setAnniGaranzia (anni_garanzia)
        self._prezzo = prezzo
    
    def descrizione(self) -> str:
        return self._descrizione
    
    def anni_garanzia (self) -> IntGEZ:
        return self._anni_garanzia
    
    def prezzo(self) -> RealGEZ:
        return self._prezzo
    
    def setDescrizione(self, descrizioneEffettiva: str) -> None:
        self._descrizione = descrizioneEffettiva

    def setAnniGaranzia(self, garanziaEffettiva: IntGEZ) -> None:
        self._anni_garanzia = garanziaEffettiva

    @abstractmethod
    def __str__(self) -> str:
        
        return f"\n\n\nDETTAGLI OGGETTO\n\nDESCRIZIONE PRODOTTO: {self.descrizione}\n\nANNI GARANZIA:{self.anni_garanzia}\n\n\nPREZZO PRODOTTO:{self.prezzo}"




'''Creazione della classe ASTA(PostOggetto)'''


class Asta(PostOggetto):
    _prezzo_bid: RealGZ
    _scadenza: datetime
    _bidEffetuatiStorico: dict[Bid, asta_bid._link]

    def __init__(self, descrizione: str, anni_garanzia: IntGEZ, prezzo_iniziale: RealGEZ, prezzo_rialzi: RealGZ, scadenza: datetime.time) -> None:
        
        self._scadenza = scadenza
        self._prezzo = prezzo_iniziale
        self._bidEffetuati = prezzo_rialzi
        self._bidEffettuatiStorico = dict()

        
        super().__init__(descrizione, anni_garanzia, prezzo_iniziale)

    def prezzo_bid(self) -> RealGZ:

        return self._prezzo_bid

    def scadenza(self) -> datetime.time:

        return self._scadenza
    
    def bidEffettuatiStorico(self) -> frozenset[weakref[asta_bid._link]]:

        refs = set()
        for l in self._bidEffettuatiStorico.values():

            refs.add(weakref.ref(l))

        return frozenset(refs)
        
    
    def setPrezzoBid(self, costoEffettivoProdotto: RealGZ) -> None:

        if not self.scaduto():

            self._prezzo_bid = costoEffettivoProdotto
        
        else:
            raise AttributeError("ATTENZIONE ! Non è possibile settare un 'prezzo_bid' ad un'asta che è già terminata !")
        
        if self._bidEffettuatiStorico:

            raise AttributeError("ATTENZIONE ! Non è possibile settare un 'prezzo_bid' ad un'asta che ha già uno  o più bid !")
        else:

            self._prezzo_bid = costoEffettivoProdotto  


    def setPrezzo(self, inserimentoPrezzoEffettivo:RealGZ) -> None:

        if not self.scaduto():
            self._prezzo = inserimentoPrezzoEffettivo

            print("SUCCESSO ! Prezzo inserito correttamente ")

        else:
            raise AttributeError("ATTENZIONE ! Non è possibile settare un 'prezzo' ad un'asta che è già terminata !")
        
        if self._bidEffettuatiStorico:

            raise AttributeError("ATTENZIONE ! Non è possibile settare un 'prezzo' ad un'asta che ha già uno  o più bid !")
        else:

            self._prezzo_bid = inserimentoPrezzoEffettivo  

    
    def setScadenza (self, inserimentoScadenzaEffettiva: datetime.time) -> None:

        if self.scaduto():

            raise AttributeError("ATTENZIONE ! Non è possibile settare una 'scadenza' ad un'asta che è già terminata !")
        
        elif inserimentoScadenzaEffettiva < datetime.now():

            raise AttributeError("ATTENZIONE ! Non è possibile settare una 'scadenza' ad un'asta che è prima della data attuale !")
        
        else:
            self._scadenza = inserimentoScadenzaEffettiva

        if self._bidEffetuatiStorico:

            raise AttributeError("ATTENZIONE ! Non è possibile settare una 'scadenza' ad un'asta che ha già uno  o più bid !")
        else:

            self._scadenza = inserimentoScadenzaEffettiva  



    def _addBid (self, linkBid: asta_bid._link) -> None:

        if linkBid.asta() is not self:

            raise ValueError("ATTENZIONE ! Il link non COINVOLGE ME !")
        
        if linkBid.bid() in self._bidEffettuatiStorico:

            raise KeyError(f"ATTENZIONE ! Ci sono due link dupilicati -> ({self}, {linkBid.bid()}) NON sono ammessi !")
        
        self._bidEffettuatiStorico[linkBid.bid()] = linkBid




    def scaduto(self) -> bool:

        return self.scadenza() < datetime.now()
    

    def __str__(self) -> str:
        return (f"\n\n\nRIEPILOGO ASTA:\n\nDESCRIZIONE PRODOTTO: {self._descrizione}\n\nPREZZO ORIGINALE: {self._prezzo:.2f}€\n\nRIALZO BID MINIMO: {self.prezzo_bid():.2f}€\n"
        f"\nSCADENZA ASTA: {self.scadenza()}\n\nDURATA GARANZIA PRODOTTO: {self.anni_garanzia()} ANN{'O' if self.anni_garanzia() == 1 else 'I'}\n"
        f"\n\nSTATO ASTA: {'ATTIVO' if self.scaduto() else 'SCADUTO'}"
    )



'''Creazione del Link Associazione bid_ut (Privato -> Bid | Bid -> Privato)'''


class bid_ut:

    class _link: #-> (Privato -> Bid | Bid -> Privato)

        def __init__(self, bid: Bid, privato: Privato) -> None:

            self._bid = bid
            self._privato = privato

        def bid(self) -> Bid:
            return self._bid

        def privato(self) -> Privato:
            return self._privato


    @classmethod
    def _add(cls, bid: Bid, privato: Privato) -> None: 

        link = cls._link(bid, privato) #Link NON rimuovibili 
        bid._setPrivato(link) #valore <<imm>>  
        privato._aggiungiBid(link) #valore certamente NON noto alla nascita 


    
    def __hash__ (self) -> str:
        return hash((self.bid(), self.privato()))
    


    def __eq__(self,other) -> bool | str:

        if not isinstance(self,other) and hash(self) != hash(other):
            return False
        return ((self.bid(), self.privato() == (other.bid(), other.privato())))






'''Creazione Link Associazione asta_bid(BID -> ASTA | ASTA -> BID )'''

class asta_bid:  

    class _link:  #-> (Privato -> Bid | Bid -> Privato)
        def __init__(self, bid: Bid, asta: Asta) -> None:

            self._bid = bid
            self._asta = asta
        
        def bid(self) -> Bid:

            return self._bid
        
        def asta(self) -> Asta:

            return self._asta
        

    
    @classmethod
    def _add(cls, bid: Bid, asta: Asta) -> None:

        link = cls._link(bid, asta) #Link NON rimuovibili 
        bid._setAsta(link) #valore <<imm>> {id}
        asta._addBid(link)  #valore certamente NON noto alla nascita

    def __hash__(self) -> int:
            return hash((self.bid(), self.asta()))

    def __eq__(self, other: Any) -> bool:
            if not isinstance(other, asta_bid._link):
                return False
            return (self.bid() == other.bid() and self.asta() == other.asta())


