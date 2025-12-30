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




class Veicolo:

    def __init__(self,marca:str,modello:str,anno:int)-> None:

        self.marca = marca
        self.modello = modello
        self.anno = anno

    def descrivi_veicolo(self) -> None:

        print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}")
    

class Auto(Veicolo):

    def __init__(self, marca:str, modello:str, anno:int,numero_porte:int) -> None:

        super().__init__(marca, modello, anno)

        self.numero_porte = numero_porte
    
    def descrivi_veicolo(self)-> None:
        print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}, Numero di porte: {self.numero_porte}")
        

class Moto(Veicolo):

    def __init__(self, marca:str, modello:str, anno:int,tipo:str) -> None:
        super().__init__(marca, modello, anno)

        self.tipo = tipo

    def descrivi_veicolo(self) -> None:
          print(f"Marca: {self.marca}, Modello: {self.modello}, Anno: {self.anno}, Tipo: {self.tipo}")
   
   

      
