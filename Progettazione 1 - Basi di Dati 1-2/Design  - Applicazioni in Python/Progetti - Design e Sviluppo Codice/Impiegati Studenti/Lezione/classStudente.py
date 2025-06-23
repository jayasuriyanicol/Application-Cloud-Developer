'''
class Studente:

    _nome:str
    _esami : dict[Modulo, esame._link] 
    #set[ esame._link]  


    def addEsame(self, m:Modulo, v:Voto) -> None:
        l= esame._link(self,m,v)

       ##self._esamiadd(l)

       if m in self._esmai:
        raise ValueError #...   
       self._esami[m] = l


    def esami(self) -> set[esame._link]:
        return self._esami.values()


    def esame(self, modulo:Modulo) -> esame._link |None:

        
        for e in self._esami:
           if e.modulo () is modulo:
              
              return e
           
        
        
        
        
'''