'''FormatRequired: Modalità utilizzo della classe specializzata'''

from typing import Self
import re

class FormatRequired(str):

    def __new__ (cls,text:str|Self)-> Self:
        

        '''Andiamo a compilare all'interno della FULLMATCH con i requisiti di cui abbiamo bisogno, in questo caso ho inserito il formato del CF'''
        if not re.fullmatch('^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$',text):

            raise ValueError(f"Value t == {text} does not comply to standard")
        return str.__new__(cls,text)
    


