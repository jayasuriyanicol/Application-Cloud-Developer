'''
In questo problema ricreerete la classica gara tra la tartaruga e la lepre. 
Userete la generazione di numeri casuali per sviluppare una simulazione di questo memorabile evento. 
I contendenti iniziano la gara dal quadrato #1 di un percorso composto da 70 quadrati. Ogni quadrato rappresenta una posizione lungo il percorso della corsa. 
Il traguardo è al quadrato 70 e il contendente che raggiunge per primo o supera questa posizione vince la gara. Durante la corsa, i contendenti possono occasionalmente perdere terreno. 
C'è un orologio che conta i secondi. Ad ogni tick dell'orologio, il vostro programma deve aggiornare la posizione degli animali secondo le seguenti regole:

- Tartaruga:
    - Passo veloce (50% di probabilità): avanza di 3 quadrati.
    - Scivolata (20% di probabilità): arretra di 6 quadrati. Non può andare sotto il quadrato 1.
    - Passo lento (30% di probabilità): avanza di 1 quadrato.

- Lepre:
    - Riposo (20% di probabilità): non si muove.
    - Grande balzo (20% di probabilità): avanza di 9 quadrati.
    - Grande scivolata (10% di probabilità): arretra di 12 quadrati. Non può andare sotto il quadrato 1.
    -  Piccolo balzo (30% di probabilità): avanza di 1 quadrato.
    - Piccola scivolata (20% di probabilità): arretra di 2 quadrati. Non può andare sotto il quadrato 1.

Il percorso è rappresentato attraverso l'uso di una lista. 
Usate delle variabili per tenere traccia delle posizioni degli animali (i numeri delle posizioni sono da 1 a 70). Fate partire ogni animale dalla posizione 1 
(cioè ai "cancelli di partenza"). Se un animale scivola a sinistra prima del quadrato 1, riportatelo al quadrato 1.

Realizzate le percentuali delle mosse nell'elenco precedente generando un intero a caso, i, 
nell'intervallo 1 ≤ i ≤ 10. Per la tartaruga eseguite un "passo veloce" quando 1 ≤ i ≤ 5, una "scivolata" quando 6 ≤ i ≤ 7, 
o un "passo lento" quando 8 ≤ i ≤ 10. Usate una tecnica simile per muovere la lepre seguendo le sue regole.

Iniziate la gara stampando:
'BANG !!!!! AND THEY'RE OFF !!!!!'

Quindi, per ogni tick dell'orologio (ossia per ogni iterazione di un ciclo), stampate una lista di 70 posizioni che mostra la lettera 'T' nella posizione della tartaruga, 
la lettera 'H' nella posizione della lepre, il carattere '_' nelle posizioni libere. Occasionalmente, i contendenti si troveranno sullo stesso quadrato.
 In questo caso la tartaruga morde la lepre e il vostro programma deve stampare 'OUCH!!!' iniziando da quella posizione. Tutte le posizioni di stampa diverse dalla 'T',
dalla 'H' o dal 'OUCH!!!' (in caso della stessa posizione) devono essere il carattere '_'.

Dopo la stampa di ogni tick, verificate se gli animali hanno raggiunto o superato il quadrato 70. Se è così, stampate il nome del vincitore e terminate la simulazione. 
Se vince la tartaruga, stampate "TORTOISE WINS! || VAY!!!". Se vince la lepre, stampate "HARE WINS || YUCH!!!". Se allo stesso tick dell'orologio vincono tutti e due gli animali, 
potreste voler favorire la tartaruga (la "sfavorita"), oppure stampare "IT'S A TIE.". 
Se non vince nessun animale, eseguite una nuova iterazione per simulare il successivo tick dell'orologio.

Requisiti del Codice:

- Utilizzare il modulo random per la generazione dei numeri casuali.
- Definire e utilizzare:
    - una funzione per visualizzare le posizioni sulla corsia di gara,
    - una funzione per calcolare la mossa della tartaruga,
    - una funzione per calcolare la mossa della lepre.
- Implementare un loop per simulare i tick dell'orologio. 
Ad ogni tick, calcolare le mosse, mostrare la posizione sulla corsia di gara, e determinare l'eventuale fine della gara.


SFIDE AGGIUNTIVE:
1. Variabilità Ambientale:
Introdurre fattori ambientali che possono influenzare la corsa, come il meteo.
Ad esempio, la pioggia può ridurre la velocità di avanzamento o aumentare la probabilità di scivolate per entrambi i concorrenti. Implementare un sistema dove le condizioni 'soleggiato' e 'pioggia' cambiano dinamicamente ogni 10 tick dell'orologio.
 
Modificatori mossa:
- La Tartaruga in caso di pioggia subisce penalità -1 su ogni mossa. In caso di sole non subisce variazioni.
- La Lepre in caso di pioggia subisca una penalità -2 su ogni mossa. In caso di sole non subisce variazioni.


2. Energia o Stamina:
Aggiungere una metrica di "energia" o "stamina" che diminuisce con ogni movimento e si ricarica in specifiche condizioni. Fare in modo che le mosse che consumano più energia non possano essere eseguite se l'animale non ha abbastanza energia. L'energia inziale per entrambi gli animali è 100.

Nuove regole di movimento:
- Tartaruga:
    - Per la tartaruga, ogni volta che il numero generato indica una mossa ma non è possibile eseguirla per mancanza di energia, essa guadagna 10 di energia. Non può superare l'energia iniziale.
    - Passo veloce (50% di probabilità): avanza di 3 quadrati e richiede 5 di energia.
    - Scivolata (20% di probabilità): arretra di 6 quadrati e richiede 10 di energia. Non può andare sotto il quadrato 1.
    - Passo lento (30% di probabilità): avanza di 1 quadrato e richiede 3 di energia.

- Lepre:
    - Riposo (20% di probabilità): non si muove e recupera 10 di energia. Non può superare l'energia iniziale.
    - Grande balzo (20% di probabilità): avanza di 9 quadrati  e richiede 15 di energia.
    - Grande scivolata (10% di probabilità): arretra di 12 quadrati e richiede 20 di energia. Non può andare sotto il quadrato 1.
    - Piccolo balzo (30% di probabilità): avanza di 1 quadrato e richiede 5 di energia.
    - Piccola scivolata (20% di probabilità): arretra di 2 quadrati e richiede 8 di energia. Non può andare sotto il quadrato 1.

'''


import random

# Costanti
LUNGHEZZA_CORSIA = 70
CAMBIO_CONDIZIONI = 10  # Ogni quanti tick cambiano le condizioni
ENERGIA_INIZIALE = 100  # Energia iniziale per tartaruga e lepre
OSTACOLI = {15: -3, 30: -5, 45: -7}  # Posizioni degli ostacoli e l'effetto negativo
BONUS = {10: 5, 25: 3, 50: 10}  # Posizioni dei bonus e l'effetto positivo

# Stato iniziale
tartaruga = 1
lepre = 1
tick = 0
condizioni = "soleggiato"  # Condizioni meteorologiche iniziali
energia_tartaruga = ENERGIA_INIZIALE
energia_lepre = ENERGIA_INIZIALE


# Funzione per mostrare la posizione corrente nella pista
def mostra_posizioni(tartaruga, lepre):
    traccia = ['_'] * LUNGHEZZA_CORSIA
    pos_tartaruga = min(tartaruga, LUNGHEZZA_CORSIA)
    pos_lepre = min(lepre, LUNGHEZZA_CORSIA)
    if pos_tartaruga == pos_lepre:
        traccia[pos_tartaruga-1] = 'OUCH!!!'
    else:
        traccia[pos_tartaruga-1] = 'T'
        traccia[pos_lepre-1] = 'H'
    print(''+str(traccia))

# Funzione per la mossa della tartaruga
def muovi_tartaruga(tartaruga, condizioni, energia_tartaruga):
    mossa = random.randint(1, 10)

    if condizioni == "pioggia":
        mod_tartaruga = -1 
    else:
        mod_tartaruga = 0

    if 1 <= mossa <= 5 and energia_tartaruga >= 5:
        tartaruga += 3 + mod_tartaruga # Passo veloce
        energia_tartaruga -= 5
    else:
        energia_tartaruga += 10
        energia_tartaruga = min(energia_tartaruga, ENERGIA_INIZIALE)  # Ricarica se non ha energia per muoversi
    
    if 6 <= mossa <= 7 and energia_tartaruga >= 10:
        tartaruga -= 6 + mod_tartaruga # Scivolata
        tartaruga = max(1, tartaruga)  # Non andare sotto il quadrato 1
        energia_tartaruga -= 10
    else:
        energia_tartaruga += 10
        energia_tartaruga = min(energia_tartaruga, ENERGIA_INIZIALE)  # Ricarica se non ha energia per muoversi
    
    if 8 <= mossa <= 10 and energia_tartaruga >= 3:
        tartaruga += 1 + mod_tartaruga # Passo lento
        energia_tartaruga -= 3
    else:
        energia_tartaruga += 10
        energia_tartaruga = min(energia_tartaruga, ENERGIA_INIZIALE)  # Ricarica se non ha energia per muoversi


    # Controlla la presenza di ostacoli
    if tartaruga in OSTACOLI:
        tartaruga += OSTACOLI[tartaruga]
        tartaruga = max(1, tartaruga)  # Non andare sotto il quadrato 1

    # Controlla la presenza di bonus
    if tartaruga in BONUS:
        tartaruga += BONUS[tartaruga]


    return tartaruga

# Funzione per la mossa della lepre
def muovi_lepre(lepre, condizioni, energia_lepre):
    mossa = random.randint(1, 10)

    if condizioni == "pioggia":
        mod_lepre = -2
    else:
        mod_lepre = 0

    if 1 <= mossa <= 2:
        lepre += 0  # Riposo
        energia_lepre += 10 # Ricarica energia
        energia_lepre = min(energia_lepre, ENERGIA_INIZIALE) # Verifico che l'energia guadagnata non superi l'energia iniziale
    elif 3 <= mossa <= 4 and energia_lepre >= 15:
        lepre += 9 + mod_lepre  # Grande balzo
        energia_lepre -= 15
    elif mossa == 5 and energia_lepre >= 20:
        lepre -= 12 + mod_lepre # Grande scivolata
        lepre = max(1, lepre)  # Non andare sotto il quadrato 1
        energia_lepre -= 20
    elif 6 <= mossa <= 8 and energia_lepre >= 5:
        lepre += 1 + mod_lepre # Piccolo balzo
        energia_lepre -= 5
    elif 9 <= mossa <= 10 and energia_lepre >= 8:
        lepre -= 2 + mod_lepre # Piccola scivolata
        lepre = max(1, lepre)  # Non andare sotto il quadrato 1
        energia_lepre -= 8


    # Controlla la presenza di ostacoli
    if lepre in OSTACOLI:
        lepre += OSTACOLI[lepre]
        lepre = max(1, lepre)  # Non andare sotto il quadrato 1

    # Controlla la presenza di bonus
    if lepre in BONUS:
        lepre += BONUS[lepre]

    return lepre

def cambia_condizioni():
    return random.choice(["soleggiato", "pioggia", "ventoso"])

print("BANG !!!!!")
print("AND THEY'RE OFF !!!!!")

while tartaruga < LUNGHEZZA_CORSIA and lepre < LUNGHEZZA_CORSIA:
    if tick % CAMBIO_CONDIZIONI == 0:
        condizioni = cambia_condizioni()  # Cambia le condizioni ogni 10 tick
        print(f"Le condizioni meteorologiche sono ora: {condizioni}")
    
    tartaruga = muovi_tartaruga(tartaruga, condizioni, energia_tartaruga)  # Aggiorno posizione tartaruga
    lepre = muovi_lepre(lepre, condizioni, energia_lepre)  # Aggiorno posizione lepre
    
    mostra_posizioni(tartaruga, lepre)
    tick += 1

    if tartaruga >= LUNGHEZZA_CORSIA or lepre >= LUNGHEZZA_CORSIA:
        if tartaruga >= LUNGHEZZA_CORSIA and lepre >= LUNGHEZZA_CORSIA:
            print("It's a tie.")
        elif tartaruga >= LUNGHEZZA_CORSIA:
            print("TORTOISE WINS! || YAY!!!")
        elif lepre >= LUNGHEZZA_CORSIA:
            print("Hare wins. Yuch.")
        break