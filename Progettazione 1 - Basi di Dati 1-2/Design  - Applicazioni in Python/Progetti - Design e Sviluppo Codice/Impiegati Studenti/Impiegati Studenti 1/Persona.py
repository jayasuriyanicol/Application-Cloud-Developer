'''
DESIGN del progetto Impiegati Studenti già svolto in precedenza in fase di design

'''


from __future__ import annotations
from datetime import date
from TipiDato import *




class Persona:
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
                 posizione_militare: PosizioneMilitare | None=None) -> None:
        self.set_nome(nome)
        self.set_cognome(cognome)
        self.set_cf(cf)
        self._nascita = nascita

        self._is_donna = False
        self._is_uomo = False
        self._maternita = maternita
        self._posizione_militare = posizione_militare

