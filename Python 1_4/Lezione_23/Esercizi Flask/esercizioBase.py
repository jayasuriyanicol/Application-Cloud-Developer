'''
ESERCIZIO 1_0

🔹 Esercizio di base

    Definire un route /about

        Definire una route /about che ritorni un breve testo HTML con descrizione dell’app o dell’autore.

'''

from flask import Flask,url_for

base = Flask(__name__)

@base.route("/about")
def aboutHome() -> str:

    return "<h3>Benvenuti, nella sezione HOME di ABOUT !</h3>"


@base.route('/descrizione/<string:descrizione>')
def descrizioneSito(descrizione:str) -> str:

    return f"Ecco la breve descrizione dell'APP:\n{descrizione}"


base.run(debug=True)