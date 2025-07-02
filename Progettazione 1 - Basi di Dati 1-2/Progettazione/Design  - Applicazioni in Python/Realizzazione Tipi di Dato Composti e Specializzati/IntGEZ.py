'''IntGEZ: Modalità utilizzo della classe specializzata'''


from typing import Self

class IntGEZ(int):

    def __new__(cls,v:int|float|Self)-> Self:

        if v < 0:
            raise ValueError(f"ATTENTION! Value v == {v} must be >=0")4
        
        return int.__new__(cls,v)
    



'''Possiamo vederne una modalità di utilizzo specifica, come ada esempio su una classe chiamata Voto'''


class Voto(int):

    def __new__(cls, v:int|Self) ->Self:
        if v < 18 or v > 30:

            raise ValueError(f"Value v == {v} must be between 18 and 30")
        return int.__new__(cls,v)
    