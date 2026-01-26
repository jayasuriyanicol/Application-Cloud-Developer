from flask import Flask, url_for

pagina = Flask(__name__)

@pagina.route('/')
def homePagina() -> str:
   
    linkAbout = url_for('aboutPagina')
    linkBenvenuto = url_for('salutoBenvenuto')
    linkProfili = url_for('profiliUtenti')
    linkPost = url_for('postGenerale')

    return f'''
    <h2>Benvenuti nella pagina PRINCIPALE del BLOG</h2>
    <p>Di seguito potete trovare i link per navigare nel BLOG:</p>
    <ul>
        <li><a href='{linkAbout}'>About</a></li>
        <li><a href='{linkBenvenuto}'>Benvenuto</a></li>
        <li><a href='{linkProfili}'>Utenti</a></li>
        <li><a href='{linkPost}'>Post</a></li>
    </ul>
    '''


@pagina.route('/about')
def aboutPagina() -> str:

    return '''<h2>Benvenuto nella nostra pagina!</h2>
              <p>Attraverso il nostro sito potrai navigare tra i vari utenti e scoprire i loro <b>DETTAGLI</b> ed <b>INFORMAZIONI</b>.</p>
              <p>Il nostro sito ti offre una navigazione gratuita e soddisfacente.</p>
              <p><b>Ti AUGURIAMO una buona navigazione!</b></p>
           '''


@pagina.route('/benvenuto')
def salutoBenvenuto() -> str:

    return 'Benvenuto Nicol! Siamo lieti di accoglierti sul nostro <b>BLOG</b>.'




utenti: list[str] = ['Cristiano', 'Giacomo', 'Michael', 'Stefano']

@pagina.route('/user')
def profiliUtenti() -> str:

    costruttoUtente: str = ''

    for utente in utenti:
        link = url_for('profiloUtente', nome=utente)
        costruttoUtente += f'<li><a href="{link}">{utente}</a></li>'

    return f'''
    <h3>LINK UTENTI:</h3>
    <ul>
        {costruttoUtente}
    </ul>
    '''

informazioni: dict[str, str] = {
    'Cristiano': "Cristiano Coccia, studente di 22 anni del corso Application Cloud Developer.",
    'Giacomo': "Giacomo Crisentini, lavoratore di 21 anni presso Amazon Roma, amante dei cani.",
    'Michael': "Michael Fastuer, calciatore di 18 anni nella SS Lazio, appassionato di cucina.",
    'Stefano': "Stefano Reale, imprenditore 39 enne con azienda vinicola a Terni."
}


@pagina.route('/user/<nome>')
def profiloUtente(nome: str) -> str:

    if nome in informazioni:
        informazione = informazioni.get(nome)

        return f'''<h3>Profilo di {nome.upper()}</h3>
                   <p><b>Descrizione:</b> {informazione}</p>'''
    
    else:
        return f"<h3>Utente {nome} non trovato.</h3>"


post: dict[int, str] = {
    1: 'Articolo ITS ICT ACADEMY',
    2: 'Appropiazione del palazzo Cesare Pavese',
    3: 'Sciopero Mezzi Venerdì 10 Ottobre 2024'
}



@pagina.route('/post')
def postGenerale() -> str:

    articoloPost: str = ''

    for key, value in post.items():

        linkPost = url_for('mostraArticolo', key=key)
        articoloPost += f"<li><a href='{linkPost}'>{value}</a></li>"

    return f'''
    <h3>LINK POST</h3>
    <ul>
        {articoloPost}
    </ul>
    '''

informazioniPosts: dict[int, str] = {
    1: 'Approfondimento sui corsi e le competenze digitali offerte dall’ITS ICT Academy.',
    2: 'Notizia relativa alla nuova sede presso il palazzo Cesare Pavese.',
    3: 'Avviso sui disagi previsti per lo sciopero mezzi del 10 ottobre 2024.'
}

@pagina.route('/post/<int:key>')
def mostraArticolo(key: int) -> str:
    
    if key in informazioniPosts:
        informazionePost = informazioniPosts.get(key)
        titolo = post.get(key)
        return f'''<h3>{titolo}</h3>
                   <p>{informazionePost}</p>'''
    else:
        return f"<h3>Articolo con id {key} non trovato.</h3>"



pagina.run(debug=True)
