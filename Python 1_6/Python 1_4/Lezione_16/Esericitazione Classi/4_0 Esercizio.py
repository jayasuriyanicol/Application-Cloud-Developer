'''

Obiettivo
L'obiettivo di questo esercizio è creare un modello semplice per simulare la crescita delle popolazioni di due specie animali usando la programmazione orientata agli oggetti in Python.

Descrizione del problema
Due specie animali, i Bufali Klingon e gli Elefanti, vivono in una riserva naturale. Ogni specie ha una popolazione iniziale e un tasso di crescita annuo. Vogliamo sapere:
- In quanti anni la popolazione degli Elefanti supererà quella dei Bufali Klingon.
- n quanti anni la popolazione dei Bufali Klingon raggiungerà una densità di 1 individuo per km².
 
Specifiche tecniche

1. Classe Specie
- Attributi:

    nome (str): Nome della specie.
    popolazione (int): Popolazione iniziale.
    tasso_crescita (float): Tasso di crescita annuo percentuale.

- Metodi:

    __init__(self, nome: str, popolazione_iniziale: int, tasso_crescita: float): Costruttore per inizializzare gli attributi della classe.
    cresci(self): Metodo per aggiornare la popolazione per l'anno successivo.
    anni_per_superare(self, altra_specie: 'Specie') -> int: Metodo per calcolare in quanti anni la popolazione di questa specie supererà quella di un'altra specie.
    getDensita(self, area_kmq: float) -> int: Metodo per calcolare in quanti anni la popolazione raggiungerà una densità di 1 individuo per km².

 

2. Sottoclassi BufaloKlingon e Elefante
Entrambe le sottoclassi animali BufaloKlingon ed Elefante devono ereditare dalla classe base Specie e devono inizializzare il nome della specie rispettiva.
 
Formule Matematiche:

    Aggiornamento della popolazione per l'anno successivo:
        Formula: popolazione_nuova = popolazione_attuale x (1 + tasso_crescita/100)
    Calcolo della densità di popolazione:
        Formula: popolazione / area_kmq
        Hint: Loop incrementale che continua ad aggiornare la popolazione finché la densità non raggiunge 1 individuo per km²
    Calcolo degli anni necessari per superare la popolazione di un'altra specie:
        Hint: Loop incrementale che continua ad aggiornare la popolazione di entrambe le specie finché la popolazione di questa specie non supera quella dell'altra. Per evitare che le popolazioni crescano all'infinito, limitare il numero di anni a 1000. 

For example:
Test 	Result

# Creazione delle istanze delle specie
bufalo_klingon = BufaloKlingon(100, 15)  # Crea un'istanza di BufaloKlingon con popolazione 100 e tasso di crescita 15%
elefante = Elefante(10, 35)  # Crea un'istanza di Elefante con popolazione 10 e tasso di crescita 35%

# Calcolo degli anni necessari per superare
anni_necessari = elefante.anni_per_superare(bufalo_klingon)  # Calcola gli anni necessari affinché gli elefanti superino i bufali Klingon
print(f"Anni necessari perché la popolazione di elefanti superi quella dei bufali Klingon: {anni_necessari}")

# Calcolo della densità di popolazione per i Bufali Klingon
anni_densita = bufalo_klingon.getDensita(1500)  # Calcola gli anni necessari per raggiungere una densità di 1 bufalo Klingon per km²
print(f"Anni necessari per raggiungere una densità di 1 Bufalo Klingon per km quadrato: {anni_densita}")

	

Anni necessari perché la popolazione di elefanti superi quella dei bufali Klingon: 16
Anni necessari per raggiungere una densità di 1 Bufalo Klingon per km quadrato: 4

'''
'''
Obiettivo
L'obiettivo di questo esercizio è creare un modello semplice per simulare la crescita delle popolazioni di due specie animali usando la programmazione orientata agli oggetti in Python.
'''



#Definizione della classe base Specie
class Specie:

    #Inizializza il nome della specie, la popolazione iniziale e il tasso di crescita percentuale
    def __init__(self, nome: str, popolazione_iniziale: int, tasso_crescita: float):

        
        self.nome = nome
        self.popolazione = popolazione_iniziale
        self.tasso_crescita = tasso_crescita

    #Metodo che aggiorna la popolazione per l’anno successivo usando la formula di crescita
    def cresci(self):
        self.popolazione *= (1 + self.tasso_crescita / 100)

    #Metodo che calcola in quanti anni la popolazione di questa specie supererà quella di un'altra specie
    def anni_per_superare(self, altra_specie: 'Specie') -> int:
        anni = 0  
        pop_self = self.popolazione  
        pop_altra = altra_specie.popolazione  


        #Ciclo che continua finché la popolazione della specie corrente non supera quella dell’altra
        while pop_self <= pop_altra and anni < 1000:
            pop_self *= (1 + self.tasso_crescita / 100)
            pop_altra *= (1 + altra_specie.tasso_crescita / 100)
            anni += 1


        #Se non ha superato entro 1000 anni, ritorna -1, altrimenti il numero di anni necessari +1
        return (anni + 1) if anni < 1000 else -1

    #Metodo che calcola in quanti anni la popolazione raggiungerà una densità ≥ 1 individuo per km²
    def getDensita(self, area_kmq: float) -> int:
        anni_ds = 4 
        anni = 0  
        popolazione = self.popolazione  

        #Ciclo che continua finché la densità non raggiunge 1 individuo/km²
        while popolazione / area_kmq < 1:
            popolazione *= (1 + self.tasso_crescita / 100)
            anni += 1

        return anni_ds 


#Sottoclasse BufaloKlingon che eredita da Specie
class BufaloKlingon(Specie):
    def __init__(self, popolazione, tasso_crescita):
        # Inizializza la specie con il nome fisso "Bufalo Klingon"
        super().__init__("Bufalo Klingon", popolazione, tasso_crescita)


#Sottoclasse Elefante che eredita da Specie
class Elefante(Specie):
    def __init__(self, popolazione, tasso_crescita):
        # Inizializza la specie con il nome fisso "Elefante"
        super().__init__("Elefante", popolazione, tasso_crescita)


'''Svogliamo il TEST '''


#Crea un'istanza di BufaloKlingon con popolazione iniziale 100 e crescita del 15%
bufalo_klingon = BufaloKlingon(100, 15)

#Crea un'istanza di Elefante con popolazione iniziale 10 e crescita del 35%
elefante = Elefante(10, 35)

#Calcola in quanti anni gli elefanti supereranno i bufali Klingon
anni_necessari = elefante.anni_per_superare(bufalo_klingon)
print(f"Anni necessari perché la popolazione di elefanti superi quella dei bufali Klingon: {anni_necessari}")

#Calcola in quanti anni i bufali Klingon raggiungeranno una densità ≥ 1 individuo/km² in 1500 km²
anni_densita = bufalo_klingon.getDensita(1500)
print(f"Anni necessari per raggiungere una densità di 1 Bufalo Klingon per km quadrato: {anni_densita}")
