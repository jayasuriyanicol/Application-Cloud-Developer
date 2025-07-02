from typing import Self #, Any 


'''Dopo aver effettuato la ristrutturazione dal Diagramma delle classi (UML) di 'VoliAerei1',
procediamo con la definizione dei TIPI DI DATO SPECIALIZZATI con vincoli numerici.'''


#Definiamo un tipo intero che rappresenta una quantità strettamente maggiore di zero (> 0)
class IntValue(int):

    def __new__(cls, value: int | float | str | bool | Self | 'IntData') -> Self:

        #Controllo del vincolo: il valore deve essere > 0, sennò ValueError
        if int(value) <= 0:
            raise ValueError(f"ATTENZIONE!\nIl valore fornito deve essere strettamente maggiore di 0 (ricevuto: {value})")

        return int.__new__(cls, int(value))


#Definiamo un tipo intero che rappresenta una quantità maggiore o uguale a zero (>= 0)
class IntQuantity(int):

    def __new__(cls, value: int | float | str | bool | Self | 'IntData') -> Self:

        #Controllo del vincolo: il valore deve essere >= 0, sennò ValueError
        if int(value) < 0:
            raise ValueError(f"ATTENZIONE!\nIl valore fornito deve essere maggiore o uguale a 0 (ricevuto: {value})")

        return int.__new__(cls, int(value))


#Definiamo un tipo intero che rappresenta un anno successivo al 1900 (> 1900)
class IntData(int):

    def __new__(cls, value: int | float | str | bool | Self | 'IntQuantity') -> Self:

        # Controllo del vincolo: l'anno deve essere maggiore di 1900, sennò ValueError
        if int(value) <= 1900:
            raise ValueError(f"ATTENZIONE!\nL'anno fornito deve essere maggiore di 1900 (ricevuto: {value})")

        return int.__new__(cls, int(value))
