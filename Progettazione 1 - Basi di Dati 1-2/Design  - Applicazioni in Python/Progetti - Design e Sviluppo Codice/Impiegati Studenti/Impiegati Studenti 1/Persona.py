'''
DESIGN del progetto Impiegati Studenti già svolto in precednza in fase di design

'''
from TipiDato import *

class Persona:

    __nome:str
    __cf : CodiceFiscale #type: ignore
    __data_nascita: Data 
    __is_donna: bool
    __is_uomo: bool
    __maternita: IntGEZ 
    __stipendio: RealGEZ 




    def __init__(self, nome:str, cognome:str, data_nascita:Data,is_donna:bool, is_uomo:bool, maternita:IntGEZ ) -> None: 

        self.__nome = nome  
        self.__cognome = cognome
        self.__data_nascita = data_nascita
        self.__is_donna = is_donna
        self.__is_uomo = is_uomo
        self.__maternita = maternita


class PosizioneMilitare(Persona):

     def __init__(self, nome, cognome, data_nascita, is_donna, is_uomo, maternita):
             super().__init__(nome, cognome, data_nascita, is_donna, is_uomo, maternita)


class  Impiegato: 
     pass

class Progetto:
     pass
     

       
             



    


        

    

    
           