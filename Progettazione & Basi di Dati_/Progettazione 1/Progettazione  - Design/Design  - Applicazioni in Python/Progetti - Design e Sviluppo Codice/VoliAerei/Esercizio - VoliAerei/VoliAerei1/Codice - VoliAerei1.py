'''
Dopo aver effettuato la ristrutturazione dal Diagramma delle classi (UML) di 'VoliAerei1', possiamo procedere con la stesura del codice in linguaggio Pyhthon partendo dal diagramma risturtturato
'''

from typing import Self,Any


'''Procediamo prima con i TIPI DI DATO SPECIALIZZATI, delle varire classi con VINCOLI.'''


class MinutiDurata(int):
    def __new__(cls, value: int) -> Self:

        if value <= 0:

            raise ValueError("ATTENZIONE!\nLa durata in minuti deve essere > 0")
        
        return int.__new__(cls, value)



class NumeroAbitanti(int):

    def __new__(cls, value: int) -> Self:

        if value < 0:

            raise ValueError("ATTENZIONE !\nIl numero di abitanti deve essere >= 0 non minore !")
        
        return int.__new__(cls, value)
    


class AnnoFondazione(int):

    def __new__(cls, value: int) -> Self:

        if value <= 1900:

            raise ValueError("ATTENZIONE!\nLa data della fondazione deve essere >= all'anno 1900")
        
        return int.__new__(cls, value)



'''Infine procediamo con la stesura per le CLASSI CONCETTUALI del DIAGRAMMA RISTRUTTURATO'''




#Definiamo la classe Aeroporto con attributi -> codice: str e nome:str
class Aeroporto:

    def __init__(self, codice:str, nome:str)-> None:

        self.codice = codice
        self.nome = nome

    def __eq__(self, other:Any)-> bool:

        if other is None or not isinstance(other, type(self)) or hash(self) != hash(other):

            return False
        
        return (self.codice) == (other.codice)


    def __hash__(self)-> int:

        return hash((self.codice,))

    def __repr__(self)-> str:

        return f"AEROPORTO ID:({self.codice} | NOME COMPLETO AEROPORTO: {self.nome})"




#Definiamo la classe Città con i seguenti attributi -> nome: str, numeroAbitanti: int
class Citta:

    def __init__(self, nome:str, numeroAbitanti:int)-> None:

        self.nome = nome
        self.numeroAbitanti = NumeroAbitanti(numeroAbitanti)


    def __eq__(self, other: Any) -> bool:

        if other is None or not isinstance(other, type(self)) or hash(self) != hash(other):

            return False
        
        return (self.nome) == (other.nome)
    

    def __hash__(self)-> int:

        return hash((self.nome))

    def __repr__(self)-> str:

        return f"NOME COMPLETO DELLA CITTÀ: ({self.nome}, | NUMERO COMPLESSIVO ABITANTI: {self.numeroAbitanti})"


#Definiamo la classe Nazione con i seguenti attributo -> nome: str
class Nazione:

    def __init__(self, nome:str) -> None:

        self.nome = nome

    def __eq__(self, other: Any) -> bool:

        if other is None or not isinstance(other, type(self)) or hash(self) != hash(other):

            return False
        
        return (self.nome) == (other.nome)

    def __hash__(self)-> int:

        return hash((self.nome))


    def __repr__(self)-> str:
        return f"NOME COMPLETO DELLA NAZIONE: ({self.nome})"


#Definiamo la classe CompagniaAerea con i seguenti attributi -> nome: str, fondazione: int
class CompagniaAerea:

    def __init__(self, nome:str, fondazione:int) -> None:

        self.nome = nome
        self.fondazione = AnnoFondazione(fondazione)

    def __eq__(self, other: Any) -> bool:

        if other is None or not isinstance(other, type(self)) or hash(self) != hash(other):

            return False
        
        return (self.nome) == (other.nome)

    def __hash__(self)-> int:

        return hash((self.nome))

    def __repr__(self)-> str:

        return f"NOME COMPLETO COMPAGNIA AEREA: ({self.nome}, | ANNO DELLA FONDAZIONE: {self.fondazione})"
    


#Definiamo la classe Volo con i seguenti attributi -> codice: str, durataMinuti: int, arrivo: Oggetto della classe Aeroporto, partenza: Oggetto della classe Aeroporto, compagnia: Oggetto della classe CompagniaAerea
class Volo:

    def __init__(self, codice:str, durataMinuti:int, partenza:Aeroporto , arrivo:Aeroporto , compagnia:CompagniaAerea)-> None:

        self.codice = codice
        self.durataMinuti = MinutiDurata(durataMinuti)


        #Verifichiamo che siano effettivamente ISTANZE delle classi appartenenti per 'partenza,arrivo e compagnia'
        if not isinstance(partenza, Aeroporto) or not isinstance(arrivo, Aeroporto):

            raise TypeError("ATTENZIONE!\nLa partenza e l'arrivo devono essere oggetti di tipo AEROPORTO")

        if not isinstance(compagnia, CompagniaAerea):

            raise TypeError("ATTENZIONE!\nLa compagnia deve essere un oggetto di tipo COMPAGNIAAEREA")

        self.partenza = partenza
        self.arrivo = arrivo
        self.compagnia = compagnia


    def __eq__(self, other: Any)-> bool:

        if other is None or not isinstance(other, type(self)) or hash(self) != hash(other):

            return False
        
        return (self.codice) == (other.codice)
    

    def __hash__(self)-> int:

        return hash((self.codice))


    def __repr__(self)-> str:

        return (f"NUMERO VOLO: ({self.codice}| DURATA TOTALE IN MINUTI: {self.durataMinuti}\n"
                f"AEROPORTO PARTENZA: {self.partenza}| AEROPORTO ARRIVO: {self.arrivo}| NOME COMPLETO COMPAGNIA: {self.compagnia})")




'''Per TESTARE la funzionalità della nostra soluzione possiamo scrivere un DRIVER PROGRAM'''

if __name__ == "__main__":

  
    
    #Effettuiamo un test sulla classe AEROPORTO
    primoAeroporto = Aeroporto("MXP", "Malpensa")
    secondoAeroporto = Aeroporto("MXP", "Malpensa")
    print("Uguali:", primoAeroporto == secondoAeroporto)
    print("Set aeroporti:", set([primoAeroporto, secondoAeroporto]))
    print()

    
    #Effettuiamo un test sulla classe NAZIONE
    italia = Nazione("Italia")
    spagna = Nazione("Spagna")
    print("Uguali nazioni:", italia == Nazione("Italia"))
    print("Set nazioni:", {italia, spagna})
    print()

    
    #Effettuiamo un test sulla classe CITTÀ
    roma = Citta("Roma", 2800000)
    milano = Citta("Milano", 1350000)
    print("Uguali città:", roma == Citta("Roma", 2800000))
    print("Set città:", {roma, milano})
    print()

    #Effettuiamo un test sulla classe AEROPORTO
    fco = Aeroporto("FCO", "Fiumicino")
    mxp = Aeroporto("MXP", "Malpensa")
    print("Uguali aeroporti:", fco == Aeroporto("FCO", "Altro Nome"))
    print("Set aeroporti:", {fco, mxp})
    print()

    #Effettuiamo un test sulla classe COMPAGNIAAEREA
    ita = CompagniaAerea("ITA Airways", 2020)
    print("Compagnia:", ita)
    print()

    #Effettuiamo un test sulla classe VOLO
    volo1 = Volo("AZ001", 90, fco, mxp, ita)
    volo2 = Volo("AZ001", 90, fco, mxp, ita)
    print("Uguali voli:", volo1 == volo2)
    print("Set voli:", {volo1, volo2})
    print()


 




