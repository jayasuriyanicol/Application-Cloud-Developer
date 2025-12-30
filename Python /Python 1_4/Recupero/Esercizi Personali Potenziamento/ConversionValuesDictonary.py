'''
6️⃣ Conversione di Valori in Dizionario

Scrivi una funzione:

convert_values(data: dict[str, str]) -> dict[str, int]

che trasformi tutti i valori (che rappresentano numeri in formato stringa) in interi.
Se un valore non è convertibile, lascialo invariato.

📘 Esempio:


convert_values({"a": "10", "b": "ciao", "c": "3"}) ➜ {"a": 10, "b": "ciao", "c": 3}

'''

def convert_values(data: dict[str, str]) -> dict[str, int]:

    dizionarioConversion:dict[str,int] = {}  


    for k,v in data.items():

        if isinstance(v,str):

            try:

               v= int(v)
            except ValueError:
                pass
    
        dizionarioConversion[k]=v 

    return dizionarioConversion


print(convert_values({"a": "10", "b": "ciao", "c": "3"}))
