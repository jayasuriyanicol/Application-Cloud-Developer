'''FieldsAssumption: Modalità utilizzo della classe specializzata'''

from typing import Any
import re


'''In questo esempio andiamo a realizzare la classe Indirizzo come esempio, ma basta cambiare i valori e seguire la sintassi per applicarla in altre enum'''
class FieldsAssumption(str):

    '''Possiamo da qui porcdere i nostri campio obbligatori da inserire'''

    def __init__(self, via:str , civico:str):

        if via is None:

            raise ValueError(f"via cannot be None")
        

        if civico is None:

            raise ValueError (f"civico cannot be None")
        
        self._via:str = via

        if not re.search("^[0-9]+[a-zA-Z]*$", civico):

            raise ValueError(f"value for civico : '{civico}' is not allowed")
        self._civico:str = civico

    
    def via(self)-> str:
        return self._via
    def civico(self) -> str:
        return self._civico
    

    def __repr__(self)-> str:
        return f"Indirizzo (via={self.via()}, civico = {self.civico()})"
    

    


    '''class INDIRIZZO implementa un tipo di dato: Python deve riconoscere se oggetti diversi rappresentano lo stesso valore '''

    def __hash__(self)-> int:
        return hash ( (self.via(), self.civico ()) )
    
    def __eq__(self, other: Any) -> bool:
        
        if other is None or \
                not isinstance(other, type(self)) or \
                hash(self) != hash(other):
            return False
        
        return (self.via(), self.civico() ) == (other.via(), other.civico())
            

        
        

   






























'''Possiamo vederne una modalità di utilizzo specifica, come ada esempio su una classe chiamata CodiceFiscaleItaliano'''
