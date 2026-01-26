'''
ESERCIZIO NUMERO 4


Calcola Deviazione Standard - PUNTI 1
Scrivi una funzione con il seguente header:

calculate_std_dev(nums: list[float]) -> float che, data una lista di numeri,
ritorni la deviazione standard (radice quadrata della varianza). Se la lista è vuota, solleva
un’eccezione ValueError con messaggio "lista vuota". Attenzione: non usare funzioni
built-in di python o librerie.calculate_std_dev(nums: list[float]) -> float che, data una lista di
numeri, ritorni la deviazione standard (radice quadrata della varianza). Se la lista è vuota,
solleva un’eccezione ValueError con messaggio "lista vuota". Attenzione: non usare funzioni
built-in di python o librerie.

Nota Bene: Il calcolo della varianza misura la dispersione dei dati rispetto alla media. Si
calcola come la media dei quadrati delle differenze tra ciascun valore all’interno della lista e
la media dei valori della lista di numeri

Esempio:
Se nums = [1.0, 2.0, 3.0, 4.0, 5.0]:

1. Calcolo della media:
(1.0 + 2.0 + 3.0 + 4.0 + 5.0) / 5 = 15.0 / 5 = 3.0

2. Calcolo della varianza:
((1.0 - 3.0)^2 + (2.0 - 3.0)^2 + (3.0 - 3.0)^2 + (4.0 - 3.0)^2 + (5.0 - 3.0)^2) / 5
= ((-2.0)^2 + (-1.0)^2 + (0.0)^2 + (1.0)^2 + (2.0)^2) / 5
= (4.0 + 1.0 + 0.0 + 1.0 + 4.0) / 5
= 10.0 / 5 = 2.0

3. Calcolo della deviazione standard:
radice quadrata di 2.0 ≈ 1.41421356


'''

def calculate_std_dev(nums: list[float]) -> float|str :
    
    somma = 0
    mediaNumeri:float= 0
    sommaNumeri:float = 0
    lunghezzaLista :int = 0
    mediaDevStand:float = 0

    if not nums:

        raise ValueError("La lista è vuota")

    for numero in nums :
        somma += numero
        lunghezzaLista += 1
    
    mediaNumeri = somma/lunghezzaLista

    for numero2 in nums:

        sommaNumeri += (numero2 - mediaNumeri)**2 

    mediaDevStand = (sommaNumeri / lunghezzaLista) ** 0.5

    return mediaDevStand




print(calculate_std_dev ([1.0,2.0,3.0,4.0,5.0] ))
