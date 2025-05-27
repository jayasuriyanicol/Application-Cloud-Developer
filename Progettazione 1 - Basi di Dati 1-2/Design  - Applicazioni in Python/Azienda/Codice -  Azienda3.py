from typing import Self
from datetime import *


'''Procediamo con lo sviluppo delle CLASSI che ci serviranno per lo sviluppo delle nostre CLASSI nel diagramma RISTRUTTURATO'''
class RealGEZ(float):
    def __new__(cls, v:int|float|str) -> Self:

        if v < 0:
            raise ValueError(f"Value v== {v} must be >==0 !")
        
        return float.__new__(cls,v)
    


class RealGZ(RealGEZ):
    def __new__(cls, v:int|float|str) -> Self:

        if v <= 0:
            raise ValueError(f"Value v== {v} must be >==0 !")
        
        return RealGEZ.__new__(cls,v)
    

'''Adesso, procediamo con la creazione e lo sviluppo delle classi dal DIAGRAMMA RISTRUTTURATO'''


class Dipartimento:
    pass

class afferenza:
    _impiegato : Impiegato #-> Dato <<immutable>>
    _dipartimento: Dipartimento 
    _dataAfferenza: datetime.time 
    _dataNascita : datetime.time


    def impiegato(self) -> Impiegato:
        return self._impiegato
    
    def dipartimento(self) -> Dipartimento:

        return self._dipartimento
    
    def dataAfferenza(self)-> datetime.time:
        return self._dataAfferenza
    

    def nascita(self) -> datetime.time:

        return self._dataNascita
    
    def setdataAfferenza(self, v:datetime.time):
    
     '''NON PROCEDIAMO CON LA DEFINIZIONE DELLA FUNZIONE Nascita 'def setdaatNascita(self,v: ...) <<-- NO, perchè sappiamo che esso è <<immutable>> dalla nascita'''
     pass

    def setdataNascita(self, v:datetime.time):

        return self._dataNascita == v    
    
    


#Creiamo la classe IMPIEGATO della classe RISTRUTTURATA
class Impiegato:

    _nome:str
    _cognome :str
    _stipendioAnnuale : RealGZ
    _dataAfferenza: datetime.date
    _nascita : datetime.date
    _dipartimento: Dipartimento

    def nome(self)-> str:

        return self._nome
    

    def cognome(self) -> str:
        return self._cognome
    

    def stipendioAnnuale(self)-> RealGZ:
        return self._stipendioAnnuale
    
    def dataAfferenza(self) -> datetime.date:
        return self._dataAfferenza
    
    def nascita(self)->datetime.date:

        return self._nascita
    
    def dipartimento(self) -> Dipartimento:

        return self._dipartimento
    

    '''Successivamente, procediamo con la creazione dei Metodi GETTER e SETTER'''
    def setNome(self, v:str) -> None:

        self._nome:str = v
    def setCognome(self, v:str) -> None:

        self._cognome:str = v
    def setstipendioAnnuale(self, v:str) -> None:

        self._stipendioAnnuale:str = v

    def setdataAfferenza(self, v:str) -> None:

        self._dataAfferenza:str = v

    def setDipartimento(self, v:Dipartimento) -> None:
        self._dipartimento:str = v
    


    def  unsetDipartimento(self)-> None:
         self._dipartimento = None

    '''NON PROCEDIAMO CON LA DEFINIZIONE DELLA FUNZIONE Nascita 'def setdaatNascita(self,v: ...) <<-- NO, perchè sappiamo che esso è <<immutable>> dalla nascita'''

 
   #TO DO : Incompleto ! Manca l'inserimento del link 'afferenza' 
    def __init__(self, nome:str, cognome:str, stipendioAnnuale:RealGZ, dataNascita: datetime.time, dataAfferenza: datetime.time, dipartimento: Dipartimento):
        
        self.setNome(nome)
        self.setCognome(cognome)
        self.setstipendioAnnuale(stipendioAnnuale)
        self.setdataAfferenza(dataAfferenza)
        self.dataNascita = dataNascita 
        self.dipartimento = None
        self.setDipartimento(dipartimento)
    

