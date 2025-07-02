'''TimeRangeExecution: Modalità utilizzo della classe specializzata'''

from typing import Self,Any
from datetime import *




'''In questo esempio andiamo a realizzare la classe TimeRange come esempio, ma basta cambiare i valori e seguire la sintassi per applicarla in altre enum'''
class TimeRangeExecution(tuple):

     _start: datetime|None # vincoli moltl. [0..1] 
     _end: datetime|None # vincoli moltl. [0..1] 

     #Vincoliamo il soggetto _start ad essere <= ad _end


     def __new__(cls, start:datetime|str|None, end:datetime|str|None)->Self:
    
        #Accettiamo il anche l'ipotesi che _start che _end abbiamo entrambi None (unbonded time periods)


        values = [datetime.fromisoformat(x) if isinstance(x,str) else x for x in [start, end]]
        if values[0] and values[1] and values[0] > values[1]:

            raise ValueError(f"Invalid TimeRangeExecution (from={start}, to ={end}): 'from' must bhe <= 'to'")      
        
        return tuple.__new__(cls, values)
        
     def start(self)-> datetime|None:
        return self[0]
     
     def end(self)-> datetime|None:
         return self[1]

     def duration(self)-> timedelta|None:
         try:

             return self.end() - self.start()
         except:
             #Dobbiamo ritornare timedelta(+infinity) but timedelta non ha una rappresentazione standard per il più infinito
             return timedelta.max  

     def isDisjoint(self, other:Self) -> bool:
         
        # case #1:
		# self :        X---------------
		# other: ---X           

		# case #2:
		# self : ---------------X
		# other:                   X----

		# case #3:
		# self :        X-------X
		# other: ---X      or      X----


        if self.start() : #1, #2
            if other.end() and other.end() < self.start():

                return True #-> 1  
            
        if self.end() : #2 #3 

            if other.start() and other.start > self.end():
                return True #3 
            
        return False
     

     def intersection(self, other:Self) -> bool:
         
         return not self.isDisjoint(other)
     
     def shift(self, delta:timedelta)-> Self:
         
         if not delta:
             
             return self
         else:
             return TimeRangeExecution(
                 
                 None if not self.start() else self.start() + delta,
                 None if not self.end() else self.end() + delta)
         
    
     def __str__(self)->str:
         return f"{ f'[(self[0])]' if self[0] else '{-inifinity'}, f { f'{self[1]}]' if self[1] else '+infinity)'}"
         
         
     




        
        

   























