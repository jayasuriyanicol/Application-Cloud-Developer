'''Infine procediamo con la stesura per le CLASSI CONCETTUALI del DIAGRAMMA RISTRUTTURATO'''

from datetime import timedelta

# Importiamo i tipi specializzati: IntValue, IntQuantity, IntData
from DichiarazioneTipiDiDato import *  


'''CLASSE Aeroporto con relativi Attributi:
        - codice (immutabile): identificativo dell’aeroporto
        - nome (mutabile): nome dell’aeroporto
'''
class Aeroporto:
    _codice:str       #-> <<immutabile>>, noto alla nascita, dove in realtà sarebbe CodiceIATA
    _nome: str        #->  <<mutabile>>, noto alla nascita

    def __init__(self, codice: str, nome: str) -> None:
        self._codice = codice
        self.setNome(nome)

    def getCodice(self) -> str:
        return self._codice

    def getNome(self) -> str:
        return self._nome

    def setNome(self, nome: str) -> None:
        self._nome = nome


'''CLASSE Volo con relativi Attributi:
        - codice (immutabile): identificativo del volo
        - durataInMinuti (mutabile): durata del volo espressa in minuti
'''
class Volo:
    _codice:str                   #-> <<immutabile>>, noto alla nascita, dove in realtà sarebbe CodiceVolo
    _durataInMinuti: timedelta    #-> <<mutabile>>, noto alla nascita

    def __init__(self, codice: str, durataInMinuti: IntValue) -> None:
        self._codice = codice
        self.setDurataInMinuti(durataInMinuti)

    def getCodice(self) -> str:
        return self._codice

    def getDurataInMinuti(self) -> timedelta:
        return self._durataInMinuti

    def setDurataInMinuti(self, minuti: IntQuantity) -> None:
        self._durataInMinuti = timedelta(minutes=minuti)


''' CLASSE CompagniaAerea con
 relativi Attributi:
        - nome (mutabile): nome della compagnia
        - fondazione (immutabile): anno di fondazione > 1900
'''
class CompagniaAerea:
    _nome: str            #-> <<mutabile>>, noto alla nascita
    _fondazione: IntData  #-> <<immutabile>>, noto alla nascita

    def __init__(self, nome: str, fondazione: IntData) -> None:
        self.setNome(nome)
        self._fondazione = fondazione

    def getNome(self) -> str:
        return self._nome

    def getFondazione(self) -> IntData:
        return self._fondazione

    def setNome(self, nome: str) -> None:
        self._nome = nome


''' CLASSE Città con relativi Attributti:
        - nome (mutabile): nome della città
        - numerodiAbitanti (mutabile): popolazione >= 0
'''
class Citta:
    _nome: str                      #-> <<mutabile>>, noto alla nascita
    _numeroDiAbitanti: IntQuantity  #-> <<mutabile>>, noto alla nascita

    def __init__(self, nome: str, numeroAbitanti: IntQuantity) -> None:
        self.setNome(nome)
        self.setNumeroDiAbitanti(numeroAbitanti)

    def getNome(self) -> str:
        return self._nome

    def getNumeroDiAbitanti(self) -> IntQuantity:
        return self._numeroDiAbitanti

    def setNome(self, nome: str) -> None:
        self._nome = nome

    def setNumeroDiAbitanti(self, numero: IntQuantity) -> None:
        self._numeroDiAbitanti = numero


''' CLASSE Nazione con relativi Attributti:
        - nome (mutabile): nome della nazione
'''
class Nazione:
    _nome: str  #-> <<mutabile>>, noto alla nascita

    def __init__(self, nome: str) -> None:
        self.setNome(nome)

    def getNome(self) -> str:
        return self._nome

    def setNome(self, nome: str) -> None:
        self._nome = nome


'''Effettuiamo un DRIVE PROGRAM per verificare il funzionamento'''

if __name__ == "__main__":

    #Effettuiamo un test sulla classe AEROPORTO
    primoAeroporto  = Aeroporto("FCO", "Aeroporto di Fiumicino")
    print(primoAeroporto.getCodice(), primoAeroporto.getNome())
    primoAeroporto.setNome("Aeroporto Internazionale di Roma")
    print(primoAeroporto.getCodice(), primoAeroporto.getNome())

    #Effettuiamo un test sulla classe VOLO
    primoVolo = Volo("QR131", IntValue(110))
    print(primoVolo.getCodice(), primoVolo.getDurataInMinuti())
    primoVolo.setDurataInMinuti(IntValue(120))
    print(primoVolo.getCodice(), primoVolo.getDurataInMinuti())


    #Effettuiamo un test sulla classe COMPAGNIA AEREA
    primaCompagniaAerea = CompagniaAerea("Qatar Airways", IntData(1984))
    print(primaCompagniaAerea.getNome() + ",", primaCompagniaAerea.getFondazione())
    primaCompagniaAerea.setNome("Qatar Airlines")
    print(primaCompagniaAerea.getNome() + ",", primaCompagniaAerea.getFondazione())

    #Effettuiamo un test sulla classe CITTÀ
    primaCitta = Citta("Fiumicino Aeroporto", IntQuantity(50000))
    print(f"La città di {primaCitta.getNome()} ha un totale di {primaCitta.getNumeroDiAbitanti()} abitanti.")
    primaCitta.setNome("Fiumicino Aeroporto - Comune di Roma")
    primaCitta.setNumeroDiAbitanti(IntQuantity(2746789))
    print(f"La città di  {primaCitta.getNome()} ha un totale di {primaCitta.getNumeroDiAbitanti()} abitanti.")


    #Effettuiamo un test sulla classe NAZIONE
    nazioneItalia = Nazione("Italy")
    print(nazioneItalia.getNome())
    nazioneItalia.setNome("United Italy")
    print(nazioneItalia.getNome())
