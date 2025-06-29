from typing import Self,Any
from datetime import date
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

