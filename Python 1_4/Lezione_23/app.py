from flask import Flask,url_for

app = Flask (__name__)

'''
Nel caso non inseriamo nulla, di default abbiamo host 127.0.0.1', port =5000, 
durante l'avvio/produzione, bisogna settare il debug a False. Utilizziamo il True 
per effettuare la fase di DEBUG 
'''

'''Per avviare utilizzare il comando nella cartella e percorso corretto 
   'flask run', ogni volta per visualizzare cambiamenti 

   1.CTRL C
   2. flask run -> Terminale

'''

@app.route('/')
def home() -> str:
    return "<h3>Benvenuto su Flask !</h3>"


#Al contempo possiamo specificare più variabili sia nella funzione che sull'URL 
@app.route ('/user/<string:username>/age/<int:age>')
def showUserProfile(username: str,age:int)-> str:

    return f"Profilo di {username} di {age} anni !"


#Se non andiamo a specificare il tipo è di default str, per modificare il dato dobbiamo farlo all'interno dell'URL
@app.route ('/post/<int:postId>')
def showPost(postId:int) -> str:

    return f"Post {postId}"


'''Attraverso il  app.test_request_context(), e successivamente se andiamo a effettuare il print:

   1. Importare oltre a Flask e url_for
   2. print(url_for('nomeFunzione) variabile1 = valore1, variabile2 = valore2, variabilen = valoren) 
   
'''

with app.test_request_context():
     print(url_for('home'))
     print(url_for('showUserProfile',username ='NicolJayasuriya', age=21))
     print(url_for('showPost', postId=42))




app.run(debug=True)
