'''
Funzioni, For, While, If, Elif ed Else
2) Scrivi una funzione che prenda una lista di numeri e ritorni un dizionario che
classifichi i numeri in liste separate per numeri positivi e negativi.
'''

def funzionePositiviNegativi(listaNumeri:list) -> dict:
 
    dizionarioPositiviNegativi:dict= {"Positivi":[], "Negativi":[], "Zeri":[] }


    for numero in listaNumeri:

        if numero > 0:

            dizionarioPositiviNegativi["Positivi"].append(numero) 
        elif numero < 0:

            dizionarioPositiviNegativi["Negativi"].append(numero)

       #In questa funzione andiamo a considerare anche il parametro di zero che verrà aggiunta in una sezione a parte  
        else:
            dizionarioPositiviNegativi["Zeri"].append(numero) 


    return dizionarioPositiviNegativi


print(funzionePositiviNegativi([1,-2,3,-4,6,-9,0]))