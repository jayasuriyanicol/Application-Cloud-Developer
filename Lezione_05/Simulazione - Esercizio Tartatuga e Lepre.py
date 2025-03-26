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

#Definisco la funzione che stampa la gara, in base alle posizioni in modo randomico dei due animali.
def printMatch(position_turtle: int, position_hare: int) -> None:
    lane = ['_'] * 70
    if position_turtle == position_hare:
        lane[position_turtle - 1] = "OUCH!!!"
    else:
        lane[position_turtle - 1] = "T"
        lane[position_hare - 1] = "H"
    print("".join(lane))


#Successivamente, vado a definire i vari spostamenti che fa la tartaruga nella gara elencando i vari spostamenti richiesti dall'esercizio, aggiungendo anche la penalità in caso di pioggia.
def moveTurtle(position: int, weather: str) -> int:
    penalty = -1 if weather == "pioggia" else 0
    pointer = random.randint(1, 10)
    if pointer <= 5:
        position += 3 + penalty
    elif pointer <= 7:
        position -= 6
    else:
        position += 1 + penalty
    return max(1, min(position, 70))

#In maniera correlata andiamo a fare lo stesso ragionamento con la lepre con le sue caratteristiche richieste dall'esercizio, aggiungendo anche qui la penalità.
def moveHare(position: int, weather: str) -> int:
    penalty = -2 if weather == "pioggia" else 0
    pointer = random.randint(1, 10)
    if pointer <= 2:
        pass
    elif pointer <= 4:
        position += 9 + penalty
    elif pointer == 5:
        position -= 12
    elif pointer <= 8:
        position += 1 + penalty
    else:
        position -= 2
    return max(1, min(position, 70))

#Definisco in maniera analoga anche il fatto di variare il meyro ogni 10 tick
def changeWeather() -> str:
    return random.choice(["soleggiato", "pioggia"])

#Definiamo successivamente la funzione chiave dove andiamo a richiamare tutte le funzioni che calcolano la posizione della LEPRE e della TARTARUGA, e continua ogni volta che noi premiamo invio
def match():
    while True:
        print("BANG !!!!! AND THEY'RE OFF !!!!!")
        position_turtle = position_hare = 1
        weather = changeWeather()
        tick = 0
        
        while True:
            tick += 1
            if tick % 10 == 0:
                weather = changeWeather()
                print(f"\n\nIl meteo ora è: {weather}")
            
            position_turtle = moveTurtle(position_turtle, weather)
            position_hare = moveHare(position_hare, weather)
            printMatch(position_turtle, position_hare)
            
            if position_turtle >= 70 and position_hare >= 70:
                print("IT'S A TIE.")
                break
            elif position_turtle >= 70:
                print("TORTOISE WINS! || VAY!!!")
                break
            elif position_hare >= 70:
                print("HARE WINS || YUCH!!!")
                break
        
        while True:
            selezione = input("\nPress ENTER if you want to continue or write down EXIT, if you want to finish here: ").strip().lower()
            if selezione == "exit":
                print("\nThank you to play with us !")
                return
            elif selezione == "":
                break
            else:
                print("\nINVALID INPUT, Please, write down 'EXIT' or press ENTER to continue !")

match()

'''
import random

def visualizza_corsia(t_pos, h_pos):
    corsia = ['_'] * 70
    if t_pos == h_pos:
        corsia[t_pos - 1] = 'OUCH!!!'
    else:
        corsia[t_pos - 1] = 'T'
        corsia[h_pos - 1] = 'H'
    print(''.join(corsia))

def mossa_tartaruga(meteo, energia):
    i = random.randint(1, 10)
    penalita = -1 if meteo == 'pioggia' else 0
    if 1 <= i <= 5 and energia >= 5:
        return 3 + penalita, -5  # Passo veloce
    elif 6 <= i <= 7 and energia >= 10:
        return -6 + penalita, -10  # Scivolata
    elif 8 <= i <= 10 and energia >= 3:
        return 1 + penalita, -3  # Passo lento
    return 0, 10  # Recupero energia

def mossa_lepre(meteo, energia):
    i = random.randint(1, 10)
    penalita = -2 if meteo == 'pioggia' else 0
    if 1 <= i <= 2:
        return 0, 10  # Riposo e recupero energia
    elif 3 <= i <= 4 and energia >= 15:
        return 9 + penalita, -15  # Grande balzo
    elif i == 5 and energia >= 20:
        return -12 + penalita, -20  # Grande scivolata
    elif 6 <= i <= 8 and energia >= 5:
        return 1 + penalita, -5  # Piccolo balzo
    elif 9 <= i <= 10 and energia >= 8:
        return -2 + penalita, -8  # Piccola scivolata
    return 0, 0  # Nessun movimento, nessun recupero

def gara():
    t_pos = h_pos = 1
    t_energia = h_energia = 100
    tick = 0
    meteo = 'soleggiato'
    print("BANG !!!!! AND THEY'RE OFF !!!!!")
    
    while t_pos < 70 and h_pos < 70:
        tick += 1
        if tick % 10 == 0:
            meteo = 'pioggia' if meteo == 'soleggiato' else 'soleggiato'
            print(f"CAMBIO METEO: Ora è {meteo}!")
        
        t_mossa, t_spesa = mossa_tartaruga(meteo, t_energia)
        h_mossa, h_spesa = mossa_lepre(meteo, h_energia)
        
        t_pos = min(70, max(1, t_pos + t_mossa))
        h_pos = min(70, max(1, h_pos + h_mossa))
        
        t_energia = min(100, t_energia + t_spesa)
        h_energia = min(100, h_energia + h_spesa)
        
        visualizza_corsia(t_pos, h_pos)
        
        if t_pos >= 70 and h_pos >= 70:
            print("IT'S A TIE.")
            break
        elif t_pos >= 70:
            print("TORTOISE WINS! || VAY!!!")
            break
        elif h_pos >= 70:
            print("HARE WINS || YUCH!!!")
            break

gara()
'''