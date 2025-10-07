'''
ESERCIZIO 2_0 

🔹 Esercizi su routing statico e dinamico

    Route dinamica per profilo utente

        Creare un percorso /user/<nome> che restituisca “Benvenuto, <nome>!”.

        Testare con nomi diversi nell’URL.

    Route con parametri numerici

        Definire /square/<int:n> che ritorni il quadrato di n.

    Parametri multipli

        Creare /sum/<int:a>/<int:b> che restituisca la somma dei due numeri.
'''



from flask import Flask

routing = Flask (__name__)

@routing.route('/')

def routingHome()-> str:

    return "<h3> Benvenuto nella sezione HOME di ROUTING ! </h3>"

@routing.route('/user/<nome:str>')

def benvenutoNome(nome:str) -> str:

    return f"Benvenuto,{nome} !"

@routing.route('/square/<n:int>')

def squareOfN(n:int):

    return n**n

@routing.route('/sum/<a:int>/<b:int>')

def sumOfNumbers(a:int,b:int)-> int:

    return a+b


routing.run(debug=True)








