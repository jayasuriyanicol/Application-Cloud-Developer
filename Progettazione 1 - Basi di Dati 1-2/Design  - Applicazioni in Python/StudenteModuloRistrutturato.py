'''
ASSOCIAZIONE TRA LE CLASSI "Studente" e "Modulo" con classe associazione "esame".  
Riprodurre la fase implementativa del codice dato lo schema ristrutturato, con i seguenti attributi:

Studente -> valore attributo (studente:str)
esame -> associazione della classe con l'attributo (voto:int)
Modulo -> valore attributo (codice:str)

'''

from __future__ import annotations

class Studente:

    _nome:str       #-> <<mutable>>, noto alla nascita  
    _modulo: Modulo #-> da assoc. Studente - Modulo [0..*] <<immutable>> possibilmente non noto alla nascita  
    _esame: esame   #-> assoc. di classe, dell'assoc. Studente - Modulo [0..*] <<immutable>> sicuramente non noto alla nascita 


    def __init__(self,nome:str)-> None:

        self._nome = nome
        self.setNome(nome)


    def setNome(self,nome)-> None:

        self._nome = nome
    
    def getNome(self) -> str:

        return self._nome  
   
    def media_voti() -> float:

        '''Invochiamo l'operazione che permette di ottenere la media_voti di uno studente'''

        sommaVoti:float = 0 
        contatoreVoti:int = 0

        for voto  in esame.voto:

            sommaVoti += voto
            contatoreVoti += 1
        
        mediaTotale:float = sommaVoti / contatoreVoti 

        return mediaTotale

class Modulo:

    _codice:str           #-> <<immutable>> noto alla nascita 
    _studente : Studente  #-> da assoc. Modulo - Studente [0..*], <<immutable>> possibilmente non noto alla nascita

    def __init__(self,codice:str)-> None:
        self._codice = codice
        self.setCodice(codice)

    def setCodice(self,codice) -> None:

        self._codice = codice
    
    def getCodice(self) -> str:

        return self._codice

class esame:

    _voto:int            #-> <<immutable>>  noto alla nascita
    _studente: Studente  #-> da assoc. Modulo - Studente [0..*] (compreso come assoc. di classe), <<immutable>>  possibilmente non noto alla nascita

    def __init__(self, voto:int)-> None:
        
        self._voto = voto
        self.setVoto(voto)
        Studente._setVoto(self)

    def setVoto(self,voto)-> None:

        self._voto = voto

    def getVoto(self) -> int:

        return self._voto
    
    def add_esame(self, esame:str, voto:int) -> None:

        self._esame = esame
        self._voto = voto


        if esame()._studente != self:

            raise RuntimeError("ATTENZIONE! Non possono esistere due link della stesssa tipologia !")