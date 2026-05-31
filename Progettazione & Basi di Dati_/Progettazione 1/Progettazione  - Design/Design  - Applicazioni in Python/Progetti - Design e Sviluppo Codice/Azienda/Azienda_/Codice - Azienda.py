'''
ASSOCIAZIONE TRA LE CLASSI "Impiegato" e "Progetto" con classe associazione "partecipa".  
Riprodurre la fase implementativa del codice dato lo schema ristrutturato, con i seguenti attributi:

Impiegato -> valore attributo (nome:str, cognome:str, data_nascita: date <<immu>> , stipendio : Denaro)
partecipa -> associazione della classe con l'attributo (data_inizio:date <<immu>>)
Progetto -> valore attributo (nome:str, budget: Denaro)

'''


from __future__ import annotations
from datetime import date
from typing import Any


class Impiegato:


    _nome:str 
    _cognome:str
    _data_nascita:date    #-> <<immu>>
    _stipendio : RealGEZ 
    _progetti : set()  #-> da assoc. 'Progetto'[ 0..*], certamnete non noto alla nasicta      
 


    def __init__(self, nome:str, cognome:str, data_nascita:date,stipendio: Denaro)-> None:

        self._nome = nome
        self._cognome = cognome
        self._data_nascita = data_nascita
        self._stipendio = stipendio
        self._progetti = set[partecipa] 

    def nome(self)-> str:
        
        return self._nome
    
    def cognome(self)-> str:

        return self._cognome
    
    def data_nascita(self)-> str:

        return self._data_nascita 
    
    def stipendio(self)-> str:

        return self._stipendio
    
    def setNome(self, nome:str)-> None:
        
        if len(nome) < 2:
            raise ValueError("ATTENZIONE! il nome deve ssere lungo più di 2 caratteri")
        self._nome = nome
    
    def removeNome(self) -> None:
        del self._nome
    
    def progetti(self)-> frozenset[partecipa]:
        return frozenset(self._progetti) 
    
    
    def _addLinkPartecipa(self,l:partecipa._link) -> None:
         
         if l.impiegato () != self:
             
             raise ValueError("Il link non coinvolge me!")
         
         if self.is_coinvolto(l.progetto()):
            
             raise ValueError("Il progetto era dell'Impiegato!")
            
         self._progetti.add(l)
        
         



    def _removeLinkPartecipa(self,l:partecipa._link) -> None:
        
         if l.impiegato () != self:
             
             raise ValueError("Il link non coinvolge me!")
         
         if self.is_coinvolto(l.progetto()):
            
             raise ValueError("Il progetto era dell'Impiegato!")
            
         self._progetti.add(l)
        


    def is_coinvolto(self, progetto:Progetto) -> bool:

        for linkPartecipa in self._progetti ():
            if linkPartecipa.profetto() == progetto:
                return True
        return False
    
    

    

class partecipa:

  @classmethod
  def add(cls, progetto: Progetto, impiegato:Impiegato, data_inizio: date) -> _link:
      
       l = cls._link(progetto,impiegato,data_inizio)
       progetto._addLinkPartecipa(l)
       impiegato._addLinkPartecipa(l)

       return l
  
  @classmethod
  def remove(cls,l: _link) -> None:
      
      l.impiegato().removeLinkPartecipa(l)
      l.progetto().removeLinkPartecipa(l)




class _link:
     #Ogni istanza rappresenta un link partecipa, ovvero coppia di (Progetto, Impiegato) con data  

     _data_inizio: date      #-> <<immu>>
     _progetto: Progetto     #-> <<immu>> da assoc. 'partecipa'[ 0..*], certamnete non noto alla nasicta      
     _impiegato : Impiegato  #-> <<immu>>  da assoc. 'partecipa'[ 0..*], certamnete non noto alla nasicta      
  


     def __init__(self, data_inizio:date)-> None:

        self._data_inizio = data_inizio

    
     def impiegato(self) -> None:

        return self._impiegato
    
     def progetto(self) -> None:

        return self._progetto
    


     def __hash__(self)-> int:

        return hash ((self.progetto(), self.impiegato()))
    
     def __eq__(self, other: Any ) -> bool:

        if type(other) != type(self) \
            or hash (self)!= type(self):
           return False

    



 
    



class Progetto:


    _nome : str
    _budget : float #-> che dobbiamo traformare in RealGEZ  
    _impiegati : set[partecipa]  #-> da assoc. 'partecipa'[ 0..*], certamnete non noto alla nasicta      
 


    def __init__(self,nome:str,budget:Denaro):


        self._nome = nome
        self._budget = budget

        
    def _addLinkPartecipa(self,l:partecipa._link) -> None:
        
         self._impiegati.add(l)
    

    def _removeLinkPartecipa(self,l:partecipa._link) -> None:
        
         self._impiegati.remove(l)

    

        

    def impiegati(self,l: partecipa._link)-> frozenset[partecipa]:
        return frozenset(self._impiegati) 
    

    def is_coinvolto(self, impiegato:Impiegato) -> bool:

        for linkPartecipa in self._impiegati ():
            if linkPartecipa.impiegato() == impiegato:
                return True
        return False
            