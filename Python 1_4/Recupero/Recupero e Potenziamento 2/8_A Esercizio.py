'''

8.A Si Scriva in Python in un file frazioni.py una classe Frazione, i cui attributi privati siano rispettivamente numeratore e denominatore.
Si definiscano i metodi __init__, setter, getter, __str__, value.
In particolare:

    il metodo value(), deve restituire il valore della frazione, ovvero numeratore / denominatore arrotondato a 3 cifre decimali;

    il metodo __str__ deve mostare in output la frazione nel seguente modo: "numeratore / denominatore ";
    i metodi setter devono controllare che il valore inserito sia un intero, in caso contrario il numeratore ed il denominatore devono essere impostati per default rispettivamente a 13 e 5.
     Inoltre, il metodo setter relativo al denominatore deve assicurarsi che questo non sia mai uguale a 0. Nel caso in cui il denominatore passato sia 0, impostarlo per default a 5.

Suggerimento: per verificare che il numeratore ed il denominatore siano numeri interi, usare la funzione is_integer().

'''

from typing import Any

class Frazione:

    ___numeratore:Any
    ___denominatore:Any
    

    def __init__(self, numeratore:Any=13, denominatore:Any=5):

        self.setNumeratore(numeratore)
        self.setDenominatore(denominatore)

    def setNumeratore(self, numeratore:Any):

        if isinstance(numeratore, int):

            self.__numeratore = numeratore


        elif isinstance(numeratore, float) and numeratore.is_integer():

            self.__numeratore = int(numeratore)


        else:
            self.__numeratore = 13

    def setDenominatore(self, denominatore):

        if isinstance(denominatore, int) and denominatore != 0:
            
            self.__denominatore = denominatore

        elif isinstance(denominatore, float) and denominatore.is_integer() and denominatore != 0:

            self.__denominatore = int(denominatore)


        else:
            self.__denominatore = 5

    def getNumeratore(self):

        return self.__numeratore

    def getDenominatore(self):

        return self.__denominatore

    def __str__(self):

        return f"{self.__numeratore} / {self.__denominatore}"
    


    def value(self):

        return round(self.__numeratore / self.__denominatore, 3)



'''DRIVER PROGRAMM - Per verificare le funzionalità'''

PrimaFrazione = Frazione(10, 4)
SecondaFrazione = Frazione (20.9, "Cristiano")

print(PrimaFrazione)              
print(PrimaFrazione.value())      
print(PrimaFrazione.getNumeratore())   
print(PrimaFrazione.getDenominatore()) 

print("\n")


print(SecondaFrazione)              
print(SecondaFrazione.value())      
print(SecondaFrazione.getNumeratore())   
print(SecondaFrazione.getDenominatore()) 
