from typing import Self

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
    
    
