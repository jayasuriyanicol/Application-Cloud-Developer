#Importiamo le classi dai file "persona" -> Persona e "alieno" -> Alieno
from persona import Persona
from alieno import Alieno


'''Polimorfismo: possibilità di usare oggetti di classi diverse tramite la stessa interfaccia/metodo.
   In maniera più sintetica è lo stesso metodo su oggetti di classi diverse.

                                        Differenza tra overriding e polimorfismo
    
    - Overriding (sovrascrittura): una sottoclasse riscrive un metodo ereditato dalla superclasse
    per modificarne o estenderne il comportamento.

    - Polimorfismo: possibilità di chiamare lo stesso metodo su oggetti di classi diverse,
    trattandoli in modo uniforme senza sapere la loro classe specifica.

    Somiglianza:
    - L'overriding abilita il polimorfismo: riscrivendo i metodi nelle sottoclassi,
    possiamo usare il polimorfismo per gestire oggetti diversi tramite la stessa interfaccia.

    Esempio:
    class Animale:
        def parla(self):
            print("L'animale fa un verso.")

    class Cane(Animale):
        def parla(self):  # <-- Overriding
            print("Il cane abbaia.")

    class Gatto(Animale):
        def parla(self):  # <-- Overriding
            print("Il gatto miagola.")

    Polimorfismo: trattiamo Cane e Gatto come Animale
    animali = [Cane(), Gatto()]

    for animale in animali:
        animale.parla()

    Output:
    Il cane abbaia.
    Il gatto miagola.

    In breve:
    - Overriding = riscrivere un metodo ereditato.
    - Polimorfismo = usare oggetti diversi con lo stesso metodo.


'''

#Creiamo un oggetto p della classe Persona
p: Persona = Persona("Nicol", "Jayasuriya", 20)

#Visualizziamo le infromazioni della Persona P:
print(p)

#Creiamo un oggetto "et" (alieno del film) della classe Alieno
et: Alieno = Alieno("Andromeda")

#Visualizziamo le informazioni dell'alieno ET
print(et)

#Invocare l'oggetto p che invoca il metodo speak()
p.speak()

#L'oggetto et invoca il metod speak()
et.speak()



