'''
2️⃣ Analizzatore di Testo

Scrivi una funzione:

analyze_text(text: str) -> dict[str, float]

che ritorni un dizionario con:

"num_parole" → numero di parole

"lunghezza_media" → media della lunghezza delle parole

"parola_piu_lunga" → la parola più lunga

📘 Esempio:

analyze_text("ciao a tutti gli studenti di python")
➜ {"num_parole": 6, "lunghezza_media": 4.5, "parola_piu_lunga": "studenti"}

'''



def analyze_text(text :str) -> dict[str,float]:

    from string import punctuation

    lunghezzaParole:int = 0
    lunghezzaMedia:float = 0
    splitText:list
    somma:float= 0.0

    parolaPiùLunga:str = ""
   

    dizionarioParole: dict[str,int|float]  = {}


    for char in punctuation:

        text= text.replace(char,"")

    
    lunghezzaParole = len(text.split())
    

    
    splitText = text.split()

    for el in splitText:

        if len(el) > len(parolaPiùLunga):

            parolaPiùLunga = el

        somma += len(el)
    
    lunghezzaMedia = somma/lunghezzaParole



    dizionarioParole = {"num_parole": lunghezzaParole,"lunghezza_media": round(lunghezzaMedia,2),"parola_piu_lunga": parolaPiùLunga} 



    
    return dizionarioParole 
    


print(analyze_text("ciao a tutti gli studenti di python"))
    

            






        
    



