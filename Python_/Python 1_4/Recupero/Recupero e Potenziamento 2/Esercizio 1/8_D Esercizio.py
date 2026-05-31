'''
8.D Scrivere in Python una funzione chiamata fractionCompare() che prende in input la lista di frazioni l originale e la lista con le frazioni di l semplificata.
 
Usando il metodo value(), dimostrare che il valore di ogni funzione di entrambe le liste non cambia, stampandolo in output.
Esempio:

    Valore frazione originale: 0.538 --- Valore frazione ridotta: 0.538

'''

class Frazione:

    ___numeratore: int | float
    ___denominatore: int | float

    def __init__(self, numeratore: int | float, denominatore: int | float) -> None:
        self.___numeratore = numeratore
        self.___denominatore = denominatore

    def __repr__(self):
        return f"{self.___numeratore} / {self.___denominatore}"

    def value(self) -> float:
        return self.___numeratore / self.___denominatore

    def MassimoComuneDivisore(self, x: int | float, y: int | float) -> int:
        x = abs(x)
        y = abs(y)
        valoreMinimo = min(x, y)

        for elementoFrazione in range(valoreMinimo, 0, -1):
            if x % elementoFrazione == 0 and y % elementoFrazione == 0:
                return elementoFrazione
        return 1

    def semplifica(self):
        valoreMcD = self.MassimoComuneDivisore(self.___numeratore, self.___denominatore)
        return Frazione(self.___numeratore // valoreMcD, self.___denominatore // valoreMcD)


# Funzione esterna alla classe
def semplifica(listaFrazioni: list[Frazione]) -> list[Frazione]:
    listaFrazioneIrriducibili = []
    for frazione in listaFrazioni:
        frazioneNonSemplificata = frazione.semplifica()
        listaFrazioneIrriducibili.append(frazioneNonSemplificata)
    return listaFrazioneIrriducibili


# Funzione esterna alla classe
def fractionCompare(listaFrazioniOriginale: list[Frazione], listaFrazioniSemplificata: list[Frazione]) -> None:
    for frazione_originale, frazione_semplicata in zip(listaFrazioniOriginale, listaFrazioniSemplificata):
        valore_originale = frazione_originale.value()
        valore_semplice = frazione_semplicata.value()
        print(f"Valore frazione originale: {valore_originale:.3f} --- Valore frazione ridotta: {valore_semplice:.3f}")


if __name__ == "__main__":
    l = [Frazione(3, 5), Frazione(8, 4), Frazione(3, 7), Frazione(18, 6)]
    l_semplificata = semplifica(l)
    fractionCompare(l, l_semplificata)
