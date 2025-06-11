'''
ASSOCIAZIONE TRA LE CLASSI "Studente" e "Modulo" con classe associazione "esame".  
Riprodurre la fase implementativa del codice dato lo schema ristrutturato, con i seguenti attributi:

Studente -> valore attributo (studente:str)
esame -> associazione della classe con l'attributo (voto:int)
Modulo -> valore attributo (codice:str)

'''

from __future__ import annotations
f
class Studente:

    _nome:str           #-> <<mutable>>, noto alla nascita  
    _modulo: Modulo     #-> da assoc. Studente - Modulo [0..*] <<immutable>> possibilmente non noto alla nascita  
    # _esame: esame       #-> assoc. di classe, dell'assoc. Studente - Modulo [0..*] <<immutable>> sicuramente non noto alla nascita 
    _esami : set[esame] #-> da assoc. 'esame'[ 0..*], certamnete non noto alla nasicta      

    def __init__(self,nome:str)-> None:

        self._nome = nome
        self._esami = set()
        self.setNome(nome)
        


    def setNome(self,nome)-> None:

        self._nome = nome

    def addStudente(self)-> None:

        pass
    
    def getNome(self) -> str:

        return self._nome  
    
    def esami(self) -> frozenset[tuple[Modulo, int]]:

        return frozenset(self._esami.items())

    def addEsame(self, modulo:Modulo, voto:int) -> None:


       #Mi assicuro che lo studente self non abbia mai superato il modulo 'modulo' 

       newEsame : esame = esame(studente=self, modulo=modulo, voto=voto)

       if newEsame in self._esami:
         raise RuntimeError(f"Lo studente {self.nome()}"
                               f"ha già superato un esame di {modulo._codice()}")
       

       self._esami.add(newEsame)


    def removeEsame (self, modulo: Modulo) -> None:

        del self._esami[modulo]  


    def media_voti(self) -> float:

        '''Invochiamo l'operazione che permette di ottenere la media_voti di uno studente'''

        ''' if len(self._esami) == 0:

            raise RuntimeError(f"Lo studente {self.nome()} non ha superato alcun esame finora !")
        
        return sum(self._esami.values()) / len(self._esami)
        '''

        sommaVoti:float = 0 
        contatoreVoti:int = 0

        for voto  in esame.voto:

            sommaVoti += voto
            contatoreVoti += 1
        
        mediaTotale:float = sommaVoti / contatoreVoti 

        return mediaTotale

class Modulo:

    _codice:str           #-> <<immutable>> noto alla nascita 
    _studente : Studente  #-> da assoc. Modulo - Studente [0..*], <<immutable>> possibilmente non noto alla nascita

    def __init__(self,codice:str)-> None:
        self._codice = codice
        self.setCodice(codice)

    def setCodice(self,codice) -> None:

        self._codice = codice
    
    def getCodice(self) -> str:

        return self._codice

class esame:

   # Gli ogggeti di questa classe rappresentano link dell'associazione 'esame' 

    _voto:int            #-> <<immutable>>  noto alla nascita
    _studente: Studente  #-> da assoc. Modulo - Studente [0..*] (compreso come assoc. di classe), <<immutable>>  possibilmente non noto alla nascita
    _modulo : Modulo     #-> da assoc. Studente - Modulo [0..*] (compreso come assoc. di classe), <<immutable>>  possibilmente non noto alla nascita   
    def __init__(self, voto:int, studente: Studente, modulo: Modulo)-> None:
        
        self._voto = voto
        self._studente = studente
        self._modulo = modulo
        self.setVoto(voto)
        Studente._setVoto(self)

    def setVoto(self,voto)-> None:

        self._voto = voto

    def getVoto(self) -> int:

        return self._voto
    
    def add_esame(self, esame:str, voto:int) -> None:

        self._esame = esame
        self._voto = voto


        if esame()._studente != self:

            raise RuntimeError("ATTENZIONE! Non possono esistere due link della stesssa tipologia !")
        

    

        if __name__ ==  "__main__":

         
         alice: Studente = Studente("Alice")
         cristiano: Studente = Studente("Cristiano")


         progr1: Modulo = Modulo("Prog. 1")
         python1_4 : Modulo = Modulo ("Python 1-4")
         


         alice.addEsame(Mmdulo=progr1, voto = 28)
         alice.addEsame(modulo=python1_4, voto=29)


         alice.removeEsame(progr1)



         try:
             
             alice.addEsame(modulo=python1_4, voto = 31)

         except RuntimeError:
             print(f"ATTENZIONE! {alice.nome()} ha già superato il modulo")

        

        esamiAlice = alice.esami()

        print(f"{alice.nome()}")

   
    def __hash__(self )-> int:

        return hash((self._studente(), self._modulo()))
    
    def __eq__(self,other: any) -> bool:

        if type(self) !=type(other) \
           or hash(self) != hash(other):
            

            return self._studente() == other.studente () \
                  and self.modulo() == other.modulo ()        

