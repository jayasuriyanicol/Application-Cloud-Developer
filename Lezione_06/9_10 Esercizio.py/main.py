'''
There is the PROGRAM 9_6 Esercizio.py of the LASTEST RESTAURANT PROGRAM:

Questa parte reppresenta la parte dove facciamo la parte MAIN, ovvero recupoeriamo i dati dal file 'restaurant.py' dove sono presenti le nostre funzioni
tramite il FROM e recuperiamo le due funzioni che ci interessano che sono le funzioni di 'Restaurant' e 'IcCreamStand' come richiamandole e riportando 
le chiamate a funzioni precedenti possiamo vedere come esse funzionino.
'''


from restaurant import Restaurant, IceCreamStand

# Creiamo un'istanza di Restaurant e testiamo i metodi
ristorante = Restaurant("Kebab Damasco", "Kebab - Cucina Araba")
ristorante.describe_restaurant()
ristorante.open_restaurant()

# Testiamo anche IceCreamStand
gelateria = IceCreamStand("Gelateria da Pino", "Gelateria", ["Fragola", "Banana", "Cocco"])
gelateria.describe_restaurant()
gelateria.pick_flavours()
