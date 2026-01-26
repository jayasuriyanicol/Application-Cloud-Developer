'''
In questo esercizio, creeremo una gerarchia di classi per rappresentare diversi tipi di veicoli.
 
1. Classe Base: Veicolo
Crea una classe base chiamata Veicolo con i seguenti attributi e metodi:
 
Attributi:
- marca (stringa)
- modello (stringa)
- anno (intero)

Metodi:
- __init__(self, marca, modello, anno): metodo costruttore che inizializza gli attributi marca, modello e anno.
- descrivi_veicolo(self): metodo che stampa una descrizione del veicolo nel formato "Marca: [marca], Modello: [modello], Anno: [anno]".

2. Classe Derivata: Auto
Crea una classe derivata chiamata Auto che eredita dalla classe Veicolo e aggiunge i seguenti attributi e metodi:
 
Attributi:
- numero_porte (intero)

Metodi:
- __init__(self, marca, modello, anno, numero_porte): metodo costruttore che inizializza gli attributi della classe base e numero_porte.
- descrivi_veicolo(self): metodo che sovrascrive quello della classe base per includere anche il - numero di porte nella descrizione, nel formato "Marca: [marca], Modello: [modello], Anno: [anno], Numero di porte: [numero_porte]".

3. Classe Derivata: Moto
Crea una classe derivata chiamata Moto che eredita dalla classe Veicolo e aggiunge i seguenti attributi e metodi:
 
Attributi:
- tipo (stringa, ad esempio "sportiva", "cruiser", ecc.)

Metodi:
- __init__(self, marca, modello, anno, tipo): metodo costruttore che inizializza gli attributi della classe base e tipo.
- descrivi_veicolo(self): metodo che sovrascrive quello della classe base per includere anche il tipo di moto nella descrizione, nel formato "Marca: [marca], Modello: [modello], Anno: [anno], Tipo: [tipo]".

For example:
Test 	Result

veicolo = Veicolo("Generic", "Model", 2020)  # Crea un'istanza della classe Veicolo
auto = Auto("Toyota", "Corolla", 2021, 4)  # Crea un'istanza della classe Auto
moto = Moto("Yamaha", "R1", 2022, "sportiva")  # Crea un'istanza della classe Moto

veicolo.descrivi_veicolo()  # Test del metodo descrivi_veicolo per Veicolo
auto.descrivi_veicolo()  # Test del metodo descrivi_veicolo per Auto
moto.descrivi_veicolo()  # Test del metodo descrivi_veicolo per Moto

	

Marca: Generic, Modello: Model, Anno: 2020
Marca: Toyota, Modello: Corolla, Anno: 2021, Numero di porte: 4
Marca: Yamaha, Modello: R1, Anno: 2022, Tipo: sportiva

'''

#Creiamo la classe base Veicolo per rappresentare le informazioni generiche di un veicolo
class Veicolo:

    #Inizializziamo gli attributi marca, modello e anno del veicolo
    def __init__(self, marca: str, modello: str, anno: int):
        
        self.marca = marca
        self.modello = modello
        self.anno = anno


    #Creiamo il metodo per stampare una descrizione del veicolo
    def descrivi_veicolo(self):
        print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}")




#Creiamo la classe Auto che estende la classe Veicolo aggiungendo il numero di porte
class Auto(Veicolo):
    def __init__(self, marca: str, modello: str, anno: int, numero_porte: int):
        #Inizializziamo gli attributi della classe base utilizzando super()
        super().__init__(marca, modello, anno)
        #Inizializziamo l'attributo specifico per le auto: numero di porte
        self.numero_porte = numero_porte



    #Sovrascriviamo il metodo per includere anche il numero di porte nella descrizione
    def descrivi_veicolo(self):
        print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}, Numero di porte: {self.numero_porte}")




#Creiamo la classe Moto che estende la classe Veicolo aggiungendo il tipo di moto
class Moto(Veicolo):
    def __init__(self, marca: str, modello: str, anno: int, tipo: str):
        #Inizializziamo gli attributi della classe base utilizzando super()
        super().__init__(marca, modello, anno)
        #Inizializziamo l'attributo specifico per le moto: tipo (es. sportiva, cruiser)
        self.tipo = tipo



    #Sovrascriviamo il metodo per includere anche il tipo nella descrizione
    def descrivi_veicolo(self):
        print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}, Tipo: {self.tipo}")




        


'''Eseguiamo dei test per verificare il funzionamento delle classi'''

#Creiamo un'istanza della classe Veicolo
veicolo = Veicolo("Generic", "Model", 2020)

#Creiamo un'istanza della classe Auto con 4 porte
auto = Auto("Toyota", "Corolla", 2021, 4)

#Creiamo un'istanza della classe Moto di tipo sportiva
moto = Moto("Yamaha", "R1", 2022, "sportiva")

#Stampiamo la descrizione del veicolo generico
veicolo.descrivi_veicolo()

#Stampiamo la descrizione dell'auto
auto.descrivi_veicolo()

#Stampiamo la descrizione della moto
moto.descrivi_veicolo()
