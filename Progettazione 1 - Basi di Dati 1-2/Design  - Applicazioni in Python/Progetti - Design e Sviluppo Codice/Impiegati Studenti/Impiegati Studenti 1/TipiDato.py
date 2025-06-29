from typing import Self,Any
from datetime import date
from typing import Any
from enum import *
import re



class IntGEZ(int):
    # Tipo di dato specializzato Intero >= 0 (Greater than or Equal to Zero)
    def __new__(cls, v: float | int | str | bool | Self) -> Self:
        n: int = super().__new__(cls, v)  # prova a convertire v in un int
        if n >= 0:
            return n
        raise ValueError(f"Il valore {n} è minore di 0!")


class IntGZ(int):
    # Tipo di dato specializzato Intero > 0 (Greater than Zero)
    def __new__(cls, v: float | int | str | bool | Self) -> Self:
        n: int = super().__new__(cls, v)  # prova a convertire v in un int
        if n > 0:
            return n
        raise ValueError(f"Il valore {n} non è positivo!")


class RealGEZ(int):
    # Tipo di dato specializzato Reale | Float >= 0 (Greater than or Equal to Zero)
    def __new__(cls, v: float | int | str | bool | Self) -> Self:
        n: int = super().__new__(cls, v)  # prova a convertire v in un int
        if n >= 0:
            return n
        raise ValueError(f"Il valore {n} è minore di 0!")


class Data(date):
    # Tipo di dato specializzato Data (solo date valide)
    def __new__(cls, v: str | date | tuple | list) -> Self:
        """
        Crea un oggetto Data a partire da:
        - una stringa nel formato 'GG-MM-AAAA'
        - un oggetto date
        - una tupla/lista di tre interi (giorno, mese, anno)
        """
        if isinstance(v, date):
            return super().__new__(cls, v.giorno, v.mese, v.anno)
        elif isinstance(v, str):
            try:
                g, m, a = map(int, v.split('-'))
                return super().__new__(cls, g, m, a)
            except Exception:
                raise ValueError(f"Stringa data non valida: '{v}'. Usa il formato 'YYYY-MM-DD'.")
        elif isinstance(v, (tuple, list)) and len(v) == 3:
            try:
                g, m, a = map(int, v)
                return super().__new__(cls, g, m, a)
            except Exception:
                raise ValueError(f"Valori non validi nella tupla/lista data: {v}.")
        else:
            raise TypeError(f"Tipo non supportato per Data: {type(v)}. Usa str, date, tuple o list.")


class CodiceFiscale(str):
    # Tipo di dato specializzato per Codice Fiscale Italiano (16 caratteri alfanumerici)
    def __new__(cls, v: str | Self) -> Self:
        """
        Crea un oggetto CodiceFiscale verificando che:
        - sia una stringa
        - sia lunga esattamente 16 caratteri
        - contenga solo caratteri alfanumerici
        """
        s = str(v).upper()
        if len(s) != 16:
            raise ValueError(f"Il Codice Fiscale deve essere lungo 16 caratteri (ricevuto: {len(s)}).")
        if not s.isalnum():
            raise ValueError("Il Codice Fiscale deve contenere solo caratteri alfanumerici.")
        return super().__new__(cls, s)

class Telefono(str):
    def __new__(cls, t: str | Self) -> Self:
        if re.fullmatch(r"^\d{10}$", t):
            return super().__new__(cls, t)
        raise ValueError(f"'{t}' non è un numero di telefono italiano valido")


class CAP(str):
    def __new__(cls, v: str | Self) -> Self:
        if re.fullmatch(r"^\d{5}$", v):
            return super().__new__(cls, v)
        raise ValueError(f"'{v}' non è un CAP italiano valido!")



class Indirizzo:
    # campi dati:
    _via:str
    _civico: str
    _cap: CAP
    def __init__(self, via: str, civico: str, cap: CAP) -> None:
        self._via: str = via

        if not re.search("^[0-9]+[a-zA-Z]*$", civico):
            raise ValueError(f"value for civico '{civico}' not allowed")
        self._civico: str = civico
        self._cap: CAP = cap

    def via(self) -> str:
        return self._via

    def civico(self) -> str:
        return self._civico

    def cap(self) -> str:
        return self._cap

    def __repr__(self) -> str:
        return f"Indirizzo(via={self.via()}, civico={self.civico()}, cap={self.cap()})"

    def __str__(self) -> str:
        return f"{self.via()} {self.civico()} - {self.cap()}"

    # class Indirizzo implementa un tipo di dato: Python deve riconoscere se oggetti diversi rappresentano lo stesso valore
    def __hash__(self) -> int:
        return hash((self.via(), self.civico(), self.cap()))

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, type(self)) or \
                hash(self) != hash(other):
            return False
        return (self.via(), self.civico(), self.cap()) == (other.via(), other.civico(), other.cap())



class Genere(StrEnum):
    uomo = auto()
    donna = auto()



if __name__ == "__main__":

    tel1: Telefono = Telefono("ciao")