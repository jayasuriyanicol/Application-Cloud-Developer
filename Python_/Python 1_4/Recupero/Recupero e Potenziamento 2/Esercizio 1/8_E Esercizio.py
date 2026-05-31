'''
8.E Scrivere un codice Python che inizializzi la seguente lista l di frazioni, dove ogni frazione è un oggetto della classe Frazione:
 
l = 2.5/0,   1/2,   2/4,   3/5,   6/9,   4/7,   24/36,   12/36,   40/60,   5/11,   10/45,   42/78,   9/15
       
Sfruttando la funzione semplifica, generare una nuova lista chiamata l_s, contente una versione semplificata delle frazioni della lista l.
Infine, richiamando la funzione fractionCompare, dimostrare che le funzioni delle lista l e l_s sono equivalenti, ovvero hanno lo stesso valore.

'''
class Frazione:

    ___numeratore: int | float
    ___denominatore: int | float

    def __init__(self, numeratore: int | float, denominatore: int | float) -> None:
        if denominatore == 0:
            raise ValueError("Il denominatore non può essere zero.")
        self.___numeratore = numeratore
        self.___denominatore = denominatore

    def __repr__(self):
        return f"{self.___numeratore} / {self.___denominatore}"

    def value(self) -> float:
        return self.___numeratore / self.___denominatore

    def MassimoComuneDivisore(self, x: int | float, y: int | float) -> int:
        x = abs(int(x))
        y = abs(int(y))
        while y:
            x, y = y, x % y
        return x

    def semplifica(self):
        valoreMcD = self.MassimoComuneDivisore(self.___numeratore, self.___denominatore)
        return Frazione(self.___numeratore // valoreMcD, self.___denominatore // valoreMcD)

#Data la lista delle frazioni dell'esercizio, prendiamo la lista e andiamo a vedere se sono formati da numeratore e denominatore e nel caso il valore del denominatore è pari a zero lancia un messaggio di errore nelle generazione del valore.
def frazioniSemplificate() -> tuple[list[Frazione], list[Frazione]]:
  
    #Nel seguente caso la prima tupla di frazione è ha come denominatore zero, questo vuol dire che lancerà un messaggio di errore tramite excpet. 
    listaFrazioni = [
        (2.5, 0), (1, 2), (2, 4), (3, 5), (6, 9), (4, 7), (24, 36),
        (12, 36), (40, 60), (5, 11), (10, 45), (42, 78), (9, 15)
    ]

    l: list[Frazione] = []
    l_s: list[Frazione] = []

    for numeratore, denominatore in listaFrazioni:
        try:
            frazione = Frazione(numeratore, denominatore)
            l.append(frazione)
        except ValueError as ErroreDivisione:
            print(f"Errore creando la frazione {numeratore} / {denominatore}: {ErroreDivisione}")

    for elementoFrazione in l:
        frazioneSemplificata = elementoFrazione.semplifica()
        l_s.append(frazioneSemplificata)

    return l, l_s

 #A differenza dell'esercizio precedente andiamo a verificare se il valore_orginale e quello semplice siano identici, nel caso non lo siano uscirà False.  
def fractionCompare(listaFrazioniOriginale: list[Frazione], listaFrazioniSemplificata: list[Frazione]) -> None:
    frazioniEquivalenti = True

    for i in range(len(listaFrazioniOriginale)):
        valore_originale = listaFrazioniOriginale[i].value()
        valore_semplice = listaFrazioniSemplificata[i].value()
        print(f"Valore frazione originale: {valore_originale:.3f} --- Valore frazione ridotta: {valore_semplice:.3f}")

        if valore_originale != valore_semplice:
            frazioniEquivalenti = False

    if frazioniEquivalenti:
        print("La lista fornita delle frazioni risultano TUTTE EQUIVALENTI alle originali !")
    else:
        print("La lista fornita delle frazioni, alcune NON risultano EQUIVALENTI alle originali !")


# Esecuzione
l, l_s = frazioniSemplificate()
fractionCompare(l, l_s)
