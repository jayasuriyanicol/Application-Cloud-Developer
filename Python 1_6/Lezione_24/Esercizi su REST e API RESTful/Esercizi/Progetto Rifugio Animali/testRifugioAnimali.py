#Procediamo, con il test del RIFUGIO ANIMALI, utilizzando i metodi GET, POST e convertendoli in formato JSON attraverso DUMPS.

import requests
import json 

if __name__ == "__main__":

    headers = {

        'Content-type' : 'application/json',
        'Accept' : 'application/json'
       }
    


   #Effettuiamo il metodo GET per gli animali, passando il path e restutendo la GET
    response = requests.get(

        url =  "http://127.0.0.1:5000/animals",
        headers = headers

    )


    print("Risposta GET: ",  "\n" ,response.json())


   #Eseguiamo la POST, nella quale indichiamo tutte le variabili dell'animale in questione 
    payload ={

        'id' : 'd99',
        'type': 'dog',
        'name': 'Rudy',
        'age_years': 3,
        'weight_kg': 45.2,
        'breed' : 'Meticcio',
        'is_trained' : False
       }
    


    #Eseguiamo uan richiesta di response, nella quale andiamo a passare i dati forniti (payload)  
    response_post = requests.post(


        url= "http://127.0.0.1:5000/animals/add",
        json= payload,
        headers= headers
    )

    print("\nCODICE STATO: ", response_post.status_code)
    print("\nTESTO RISPOSTA: ",response_post.text)



    try:

        print("\nRISPOSTA JSON : ",response_post.json())
    except:
        print("La risposta non conteneva un JSON valido")






