

from math import sqrt

def geometric_mean(values:list[float]) -> float:

    
    moltlipicazione:float = 1.0
    mediaGeometrica:int = 0
    lunghezzaVal = len(values)

    if not values:

        for elm in values:
         if elm < 0:

            raise ValueError("valori non validi")

    else:

        for elm in values:
             moltlipicazione *= elm

        mediaGeometrica = moltlipicazione **(1/lunghezzaVal)

        mediaGeometrica = round(mediaGeometrica)
    
    return mediaGeometrica



print(geometric_mean([1.0, 4.0, 9.0]))


        