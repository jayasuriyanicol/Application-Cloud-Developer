from typing import Any
import re

'''CivicoLettera: Modalità utilizzo della classe specializzata
In questo esempio andiamo a realizzare la classe CivicoLettera come esempio, ma basta cambiare i valori e seguire la sintassi per applicarla in altre enum

Seguendo questa modalità:
from typing import Self

class CivicoLettera(int):
    _lettera : str

    def __new__(cls, num: int, let: str) -> Self:

        v:int = super().__new__(cls, num)
        v._lettera = let
        return v 
    
    def numero(self) -> int:
        return self.real
    
    def lettera(self) -> str:
        return self._lettera

'''

class CivicoLettera:

    '''Possiamo da qui porre i nostri campi obbligatori da inserire'''

    def __init__(self, numero: int, lettera: str):
        if numero is None:
            raise ValueError("numero cannot be None")
        if not isinstance(numero, int) or numero < 0:
            raise ValueError(f"numero must be a non-negative integer, got: {numero}")

        if lettera is None:
            raise ValueError("lettera cannot be None")
        if not re.match("^[a-zA-Z]?$", lettera):
            raise ValueError(f"lettera must be a single optional alphabetic character, got: '{lettera}'")

        self._numero: int = numero
        self._lettera: str = lettera

    def numero(self) -> int:
        return self._numero

    def lettera(self) -> str:
        return self._lettera

    def __repr__(self) -> str:
        return f"CivicoLettera(numero={self.numero()}, lettera='{self.lettera()}')"


    '''class CivicoLettera implementa un tipo di dato: Python deve riconoscere se oggetti diversi rappresentano lo stesso valore'''

    def __hash__(self) -> int:
        return hash((self.numero(), self.lettera()))

    def __eq__(self, other: Any) -> bool:
        if other is None or \
           not isinstance(other, type(self)) or \
           hash(self) != hash(other):
            return False
        return (self.numero(), self.lettera()) == (other.numero(), other.lettera())

'''Esempio di DRIVER PROGRAM
# Creazione di un'istanza della classe CivicoLettera
civico = CivicoLettera(12, 'B')

# Accesso ai valori
print(civico.numero())   # Output: 12
print(civico.lettera())  # Output: 'B'

# Rappresentazione dell'oggetto
print(civico)            # Output: CivicoLettera(numero=12, lettera='B')
'''