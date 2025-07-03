from abc import ABC, abstractmethod
from string import ascii_lowercase, ascii_uppercase


class CodificatoreMessaggio(ABC):

    @abstractmethod
    def codifica(self, testoInChiaro: str) -> str:
        pass


class DecodificatoreMessaggio(ABC):

    @abstractmethod
    def decodifica(self, testoCodificato: str) -> str:
        pass


class CifratoreAScorrimento(CodificatoreMessaggio, DecodificatoreMessaggio):

    def __init__(self, chiave: int) -> None:
        self.chiave = chiave

    def codifica(self, testoInChiaro: str) -> str:
        risultatoCriptato: list[str] = []

        for lettera in testoInChiaro:

            if lettera in ascii_lowercase:
                indiceMinuscole = (ascii_lowercase.index(lettera) + self.chiave) % 26
                risultatoCriptato.append(ascii_lowercase[indiceMinuscole])

            elif lettera in ascii_uppercase:
                indiceMaiuscole = (ascii_uppercase.index(lettera) + self.chiave) % 26
                risultatoCriptato.append(ascii_uppercase[indiceMaiuscole])

            else:
                risultatoCriptato.append(lettera)

        return ''.join(risultatoCriptato)

    def decodifica(self, testoCodificato: str) -> str:
        risultatoDecriptato: list[str] = []

        for lettera in testoCodificato:

            if lettera in ascii_lowercase:
                decriptaMinuscole = (ascii_lowercase.index(lettera) - self.chiave) % 26
                risultatoDecriptato.append(ascii_lowercase[decriptaMinuscole])

            elif lettera in ascii_uppercase:
                decriptaMaiuscole = (ascii_uppercase.index(lettera) - self.chiave) % 26
                risultatoDecriptato.append(ascii_uppercase[decriptaMaiuscole])

            else:
                risultatoDecriptato.append(lettera)

        return ''.join(risultatoDecriptato)


class CifratoreACombinazione(CodificatoreMessaggio, DecodificatoreMessaggio):

    def __init__(self, n: int) -> None:
        self.n = n

    def __combinazione(self, testo: str) -> str:
        lunghezzaMessaggio = len(testo)

        if lunghezzaMessaggio % 2 == 0:
            lunghezzaMeta = lunghezzaMessaggio // 2
        else:
            lunghezzaMeta = lunghezzaMessaggio // 2 + 1  # prima metà più lunga

        primaMeta = testo[:lunghezzaMeta]
        secondaMeta = testo[lunghezzaMeta:]

        combinato = ""

        for i in range(len(testo)):
            if i % 2 == 0 and primaMeta:
                combinato += primaMeta[0]
                primaMeta = primaMeta[1:]
            elif secondaMeta:
                combinato += secondaMeta[0]
                secondaMeta = secondaMeta[1:]

        return combinato

    def __decodifica_combinazione(self, testo: str) -> str:
        for _ in range(self.n):
            lunghezzaMessaggio = len(testo)

            if lunghezzaMessaggio % 2 == 0:
                lunghezzaMeta = lunghezzaMessaggio // 2
            else:
                lunghezzaMeta = lunghezzaMessaggio // 2 + 1

            primaMeta = [''] * lunghezzaMeta
            secondaMeta = [''] * (lunghezzaMessaggio - lunghezzaMeta)

            indicePrima = 0
            indiceSeconda = 0

            for i in range(len(testo)):
                if i % 2 == 0:
                    primaMeta[indicePrima] = testo[i]
                    indicePrima += 1
                else:
                    secondaMeta[indiceSeconda] = testo[i]
                    indiceSeconda += 1

            testo = ''.join(primaMeta + secondaMeta)

        return testo

    def codifica(self, testoInChiaro: str) -> str:
        for _ in range(self.n):
            testoInChiaro = self.__combinazione(testoInChiaro)
        return testoInChiaro

    def decodifica(self, testoCodificato: str) -> str:
        return self.__decodifica_combinazione(testoCodificato)




# Test per Cifratore a Scorrimento
messaggio1 = "Ciao, sono Cristiano Coccia !"
chiave = 3

cifr_s = CifratoreAScorrimento(chiave)
criptato1 = cifr_s.codifica(messaggio1)
print("MESSAGGIO SCORRIMENTO CRIPTATO:", criptato1)
decriptato1 = cifr_s.decodifica(criptato1)
print("MESSAGGIO SCORRIMENTO DECRIPTATO:", decriptato1)

# Test per Cifratore a Combinazione
messaggio2 = "abcdefghi"
combinazioni = 3

cifr_c = CifratoreACombinazione(combinazioni)
criptato2 = cifr_c.codifica(messaggio2)
print("\nMESSAGGIO COMBINAZIONE CRIPTATO:", criptato2)
decriptato2 = cifr_c.decodifica(criptato2)
print("MESSAGGIO COMBINAZIONE DECRIPTATO:", decriptato2)
