'''
Esercizio 9 — Dizionario invertito per liste

Scrivi una funzione:

reverse_index(data: dict[str, list[str]]) -> dict[str, list[str]]

he trasformi un dizionario da:

{
  "Matematica": ["Anna", "Luca"],
  "Storia": ["Anna", "Marta"]
}

a:

{
  "Anna": ["Matematica", "Storia"],
  "Luca": ["Matematica"],
  "Marta": ["Storia"]
}


'''


def reverse_index(data: dict[str, list[str]]) -> dict[str, list[str]]:


    dizionarioCorretto:dict[str, list [str]] ={} 


    for key,value in data.items():

            for val in value:
               
                if val not in dizionarioCorretto:
                
                    dizionarioCorretto[val]= [key]  
                else:
                    dizionarioCorretto[val].append(key)

    return dizionarioCorretto





print(reverse_index({"Matematica": ["Anna", "Luca"], "Storia": ["Anna", "Marta"]}))
        
        