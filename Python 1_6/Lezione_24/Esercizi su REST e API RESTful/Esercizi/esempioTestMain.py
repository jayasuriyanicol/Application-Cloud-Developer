#Esempio di test JSON con GET, POST, DUMPS

import requests
import json 

if __name__ == "__main":


    headers = {


        'Content-type' : 'application/json',
        'Accept' : 'application/json'

       }
    

   #ESEMPIO di GET 
    response = requests.get(
        url = "http://localhost:5000/libri",
        headers = headers

    )

    print("Risposta GET: ", response.json())



   #Esempio di POST
    payload = {


       "nome" : "Nicol",
       "cognome" : "Jayasuriya" 
       
    
 }

# NO JSON DUMPS
response_post = requests.post(

    url= "http://localhost/api/utenti",
    json= payload,
    headers=headers


)

# JSON DUMPS
response_post = requests.post(

    url= "http://localhost/api/utenti",
    data= json.dumps(payload),
    headers=headers

)


print("Risposta POST: ", response_post.json())