'''
Calcola Media Ponderata - PUNTI 1
Scrivi una funzione con il seguente header:
weighted_average(values: list[float], weights: list[float]) -> float
che calcoli la media ponderata. Se le liste sono vuote o di lunghezze diverse, solleva
ValueError("liste non valide").
Non usare librerie esterne.

'''

def weighted_average(values: list[float], weights: list[float]) -> float:

    sommaVotiPesi:int = 0
    sommaPesi:int = 0
    mediaPonderata:float = 0.0


    if len(values)== 0 or len(weights) == 0:

       raise ValueError("liste non valide")
   
    else:

         for elem in range(len(values)):

                sommaVotiPesi += values[elem]  * weights[elem]  
                sommaPesi +=  weights[elem]  
         mediaPonderata = sommaVotiPesi / sommaPesi
         return round(mediaPonderata,2)




                
print(weighted_average(values=[26.0, 28.0, 27.0, 30.0],weights=[6.0, 9.0, 6.0, 12.0]))

