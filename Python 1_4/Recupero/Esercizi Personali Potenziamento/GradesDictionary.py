'''

5️⃣ Dizionario di Valutazioni

Scrivi una funzione:


average_grades(grades: dict[str, list[int]]) -> dict[str, float]


che calcoli la media di ogni studente e ritorni un nuovo dizionario con nome → media.

📘 Esempio:

average_grades({"Anna": [8,9,10], "Luca": [6,7,8]})➜ {"Anna": 9.0, "Luca": 7.0}

'''


def average_grades(grades: dict[str, list[int]]) -> dict[str, float]:


    dizionarioVoti:dict[str,float] = {}
    sommaVoti:int= 0
    mediaVoti:float =  0.0


    for k,v in grades.items():

    
        for n in v:
           sommaVoti += n
        
        mediaVoti = sommaVoti / len(v)
    
        dizionarioVoti[k]= mediaVoti
        sommaVoti = 0.0
 


    return dizionarioVoti


print(average_grades({"Anna": [8,9,10], "Luca": [6,7,8]}))



    

        


        



