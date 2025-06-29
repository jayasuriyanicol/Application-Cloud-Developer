'''
DESIGN del progetto Impiegati Studenti già svolto in precedenza in fase di design. IMPLEMENTAZIONE DEL CODICE IN LINGUAGGIO PYTHON.

'''

from __future__ import annotations
from datetime import date
from TipiDato import *

'''  Crezione della classe PERSONA '''

class Persona:
    
    ''' Assumiamo e indichiamo che gli attributi sono protetti utilizzando "_attributo" '''
    _nome: str
    _cognome: str
    _cf: CodiceFiscale # {id}
    _nascita: date # <<immutable>>
    _is_uomo: bool  # da fusione
    _is_donna: bool # da fusione
    _maternita: IntGEZ | None # [0..1] da fusione con Donna
    _posizione_militare: PosizioneMilitare | None # [0..1] da fusione con Uomo e aggregazione di pos_uomo


    def __init__(self, *, nome: str, cognome: str, cf: CodiceFiscale, nascita: date,
                 maternita: IntGEZ|None = None,
                 posizione_militare: PosizioneMilitare |None = None) -> None:
        

        self.set_nome(nome)
        self.set_cognome(cognome)
        self.set_cf(cf)
        self._nascita = nascita
        
        '''Assiumiamo che il sesso/genere indicato sia False di default'''

        self._is_donna = False
        self._is_uomo = False
        self._maternita = maternita
        self._posizione_militare = posizione_militare


        '''Nel caso in cui andiamo a valorizzare l'attributo questo ritornerà True dato che sarà completo da qualcosa'''

        if maternita is not None:
            self._is_donna = True
        if posizione_militare is not None:
            self._is_uomo = True
        
        '''Effettuiamo un TEST per verificare che non siano entrambi dello stesso sesso o uomo o donna'''

        if not (self.is_uomo() or self.is_donna()):
            # [V.Persona.fusione]
            # Per ogni p: Persona: p.is_donna ==True or p.is_uomo==True
            raise ValueError("Ogni persona deve essere uomo, donna o entrambi!")
        



    '''Partiamo con la definizione dei metodi get,set,ecc'''

    def nome(self) -> str:
        return self._nome


    def add_genere_donna(self, maternita: IntGEZ) -> None:
        if self.is_donna():
            raise RuntimeError("Era già una donna!")
        self._maternita = maternita
        self._is_donna = True


    def add_genere_uomo(self, pos_mil: PosizioneMilitare) -> None:
        if self.is_uomo():
            raise RuntimeError("Era già un uomo!")
        self._posizione_militare = pos_mil
        self._is_uomo = True


    def remove_genere_donna(self) -> None:
        if not self.is_donna():
            raise RuntimeError("Non era una donna!")
        if not self.is_uomo():
            raise RuntimeError("Non può rimanere senza genere!")
        self._maternita = None
        self._is_donna = False


    def remove_genere_uomo(self) -> None:
        if not self.is_uomo():
            raise RuntimeError("Non era un uomo!")
        if not self.is_donna():
            raise RuntimeError("Non può rimanere senza genere!")
        self._posizione_militare = None
        self._is_uomo = False


    def is_uomo(self) -> bool:
        return self._is_uomo
    

    def is_donna(self) -> bool:
        return self._is_donna
    

    def set_nome(self, nome: str) -> None:
        self._nome = nome


    def set_cognome(self, cognome: str) -> None:
        self._cognome = cognome


    def set_cf(self, cf: CodiceFiscale) -> None:
        self._cf = cf


    def maternita(self) -> IntGEZ:
        if not self.is_donna():
            raise RuntimeError("Non era una donna!")
        return self._maternita
    

    def posizione_militare(self) -> PosizioneMilitare:
        if not self._is_uomo:
            raise RuntimeError("Non era una uomo!")
        return self._posizione_militare
    

