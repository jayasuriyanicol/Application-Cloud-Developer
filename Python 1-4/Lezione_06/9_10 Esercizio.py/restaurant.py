'''
There is the PROGRAM 9_6 Esercizio.py of the LASTEST RESTAURANT PROGRAM:

Questa parte reppresenta la parte dove abbiamo definito le nostre funzioni dell'ultimo esercizio di RESTAURANT
'''


class Restaurant:
    def __init__(self, restaurant_name: str, cuisine_type: str, number_served: int = 0):
        self.restaurant_name = restaurant_name
        self.cuisine_type = cuisine_type
        self.number_served = number_served

    def describe_restaurant(self):
        print("\n--------- DESCRIZIONE RISTORANTE -----------")
        print(f"Nome: {self.restaurant_name}")
        print(f"Tipologia: {self.cuisine_type}")

    def open_restaurant(self):
        print("\nIl ristorante è APERTO!")

    def set_number_served(self, numero):
        if numero >= 0:
            self.number_served = numero
            print(f"\nNumero clienti serviti: {self.number_served}")
        else:
            print("\nNon puoi inserire un numero inferiore a 0!")

    def increment_number_served(self, numero):
        if numero > 0:
            self.number_served += numero
            print(f"\nNumero totale di clienti serviti: {self.number_served}")
        else:
            print("\nNon puoi diminuire il numero!")


class IceCreamStand(Restaurant):
    def __init__(self, restaurant_name: str, cuisine_type: str, flavours: list):
        super().__init__(restaurant_name, cuisine_type)
        self.flavours = flavours

    def pick_flavours(self):
        print("\n--------- GELATERIA ------------")
        print("Gusti disponibili:")
        for flavour in self.flavours:
            print(f"- {flavour}")



