'''
SPECIFICA DEI VINCOLI - Derivati dal diagramma UML ristutturato


[V.Peronsa.Genere.Fusione ] 
per ogni p:Persona 
-p.is_uomo == True or p.is_donna == True

 -p.is_uomo == True se e solo se (<=>) p partecipa a un link pos_uomo 

-p.is_donna == True <=> p.maternità ha un valore 

[V.Impiegato.Progettista.fusione] 
per ogni i:Impiegato 

se i partecipa a un link resp_prog, allora i ruolo = Ruolo.progettista 

'''

'''Importiamo tutte le risorse che ci occorrono per il programma'''


from TipiDato import *
from datetime import date
from __future__ import annotations 
from typing import Self


'''Dichiarazione degli attributi PUBBLICI nella classe Persona'''

class Persona:

    _nome:str
    _cognome:str
    _cf: CodiceFiscale
    _data_nascita: Data| date
    _maternita: IntGEZ | None 
    _is_uomo: bool
    _is_donna: bool




'''Inizializzazione degli attributi PUBBLICI nella classe Persona'''

def __init__ (self,*, nome:str, cognome:str, cf:CodiceFiscale, data_nascita:Data, maternita: IntGEZ, is_uomo:bool, is_donna:bool ):

    self._uomo = nome 
    self._cognome = cognome
    self._cf = cf
    self._data_nascita = data_nascita
    self._maternita = maternita
    self._is_uomo = is_uomo
    self._is_donna = is_donna
    self.setNome = nome
    self.setCognome = cognome

    


def setNome(self,nome:str)-> None:

    self.nome = nome

def setCognome(self,cognome:str)-> None:

    self.cognome = cognome

def setCf(self,cf:CodiceFiscale)-> None:

    self.cf = cf

def setDataNascita(self,data_nascita:Data)-> None:

    self.data_nascita = data_nascita



def getNome(self)-> str:

    return self.nome

def getCognome(self)-> str:

    return self.cognome

def getCf(self)-> CodiceFiscale:

    return self.cf

def getDataNascita(self)-> Data:

    return self.data_nascita



