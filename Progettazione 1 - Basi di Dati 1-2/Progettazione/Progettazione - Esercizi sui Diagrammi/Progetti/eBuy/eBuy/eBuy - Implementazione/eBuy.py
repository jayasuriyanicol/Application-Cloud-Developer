'''IMPLEMENTAZIONE eBuy in Linguaggio Python'''



'''IMPORT per l'implementazione'''

from __future__ import annotations
import weakref
from typing import Any, Self
from TipiDato import *
from datetime import datetime
from abc import ABC, abstractmethod




'''Creazione classe UTENTE'''

class Utente(ABC):

    _indexUsername: Index[str, Self] = Index("Lista Username") # indice per la lista '_indexusername' 
    _username: str  # valore <<imm>> {id}
    _registrazione: datetime  # valore <<imm>>


    @abstractmethod
    def __init__(self, username:str, registrazione:datetime.date) -> None:

        if username:
            self._indexUsername.add(username, self)
            self._username = username
        else:
            raise AttributeError("ATTENZIONE ! il valore dell'attributo '_username' non può essere nullo (None) o vuoto")
        self._registrazione = registrazione

    def username(self) -> str:
        return self._username

    def registrazione(self) -> datetime.date:
        return self._registrazione

    @classmethod
    def all(cls):
        return cls._indexUsername.all()

    @classmethod
    def get(cls, username: str):
        return cls._indexUsername.get(username)

    def __str__(self) -> str:
        return f"L'utente : {self.username()}\nRisulta essere REGISTRATO in data: {self.registrazione()}"
    



'''Creazione classe PRIVATO (UtentePrivato)'''


class Privato(Utente):

    _bidEffettuati: dict[Bid, bid_ut._link] #link associazione con la classe Bid(bid_ut) 

    def __init__(self, username:str, registrazione:datetime.date)-> None:
        super().__init__(username, registrazione)

        self._bidEffettuati= dict()

        '''La classe PRIVATO non presenta attributi specifici'''



    def bid(self) -> frozenset[weakref[bid_ut._link]]:
        refs = set()
        for l in self._bidEffettuati.values():

            refs.add(weakref.ref(l))

        return frozenset(refs)
                    


    def _aggiungiBid(self, linkBid: bid_ut._link) -> None:

        if linkBid.privato() is not self:

            raise ValueError("ATTENZIONE ! Il link non coinvolge me !")
        
        if linkBid.bid() in self._bidEffettuati:

            raise KeyError(f"ATTENZIONE ! I link duplicati -> ({self}, {linkBid.bid()}) NON sono ammessi !")
        self._bidEffettuati[linkBid.bid()] = linkBid




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

            raise ValueError("ATTENZIONE ! Il link non COINVOLGE ME !")

        self._privato = linkPrivato.privato()
    
    def _setAsta(self, linkAsta: asta_bid._link) -> None:

        if self.asta() is not None:

            raise ValueError("ATTENZIONE ! Questo bid è già esistente in un link con un'altra ASTA !")
        
        if linkAsta.bid() is not self:

            raise ValueError("ATTENZIONE ! Il link non COINVOLGE ME !")

        self._asta = linkAsta.asta()

