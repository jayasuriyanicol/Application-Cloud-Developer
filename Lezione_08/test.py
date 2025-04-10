from persona import Persona
from studente import Studente

#Creiamo un oggetto p di classe persona
p: Persona = Persona("Nicol", "Jayasuriya" , 20)

#Visualizziamo le infromazioni relative alla persona p
print(p)

#Creiamo l'oggetto 1 della classe studente 
studente1 : Studente = Studente("Nathan", "Mbuyamba" , 21, "13213")



'''Svogliamo delle domande ovvero QUERY da richiedere al sistema'''




#Vogliamo controllare che studente sia istanza della classe 
if isinstance(studente1, Studente):
    print("\nstudente1 è un oggetto della classe Studente")

#La funzione isistance(obj, Class)-> True se l'oggetto obj è un istanza della classe Studente

#Voglio sapere se studente1 sia anche istanza della classe Persona, dato che la classe studente beredita dalla classe Persona
if isinstance(studente1, Persona):
    print("\nl'oggetto studente1 è anche un'istanza della classe Persona")

else:
    print("\nl'oggetto studente1 è solo un'istanza della classe Studente e non della classe Persona")

#Voglio controllare che l'oggetto p sia un istanza della Classe Persona
if isinstance(p,Persona):
    print("\nl'oggetto p è un'istanza dellan classe Persona")

#Voglio anche controllare se l'oggetto p sia anche un'istabza della Classe Studente
if isinstance(p,Studente):
    print("\nl'oggetto p è istanza della classe Persona ed è anche istanza della classe Studente")

else:
    print("\nl'oggetto p è solo istanza della classe Persona ma non è istanza della classe Studente")

#Voglio controllare se Studente è sottoclasse della classe Persona, attraverso issubclass(Class1, Class2):
#Controlliamo se Class1 è sottoclasse della classe Class2, in caso affermatico ritorna True

if issubclass(Studente, Persona):
    print("\nla classe Studente è sottoclasse della classe Persona:\n")


print(studente1)
print(f"\n{p}")
print(f"\n\nLa media dei voti relativi agli esami sostenuti dallo studente1 è: {studente1.getMediaEsami([10,20,30])}")

#Creiamo uno studente2 oggetto della classe Studente
studente2:Studente = Studente(p.getName(), p.getLastname(), p.getAge(), "0356923")

print(studente2)

#Confrontare se studente == p (Persona Generica)
print("\n",studente1 == p)

#Confronto studente1 e studente2
print("\n",studente1 == studente2)

#Verifichiamo che lo studente1 sia uguale a se stesso
print("\n", studente1 ==  studente1)

#Modificare nome, cognome e età dello studente2 afficheè abbia tutti gli attributi( trenne Matricola e Età) dello studente1
studente2.setName(studente1.getName())
studente2.setLastname(studente1.getLastname())
studente2.setAge(studente1.getAge())


#Confronto studente1 con studente2 
print("\n", studente1 == studente2)

#Ho forzato la matricola dello studente 2 ad essere uguale alla matricola dello studente1
studente2.setMatricola(studente1.getMatricola())

#Confronto nuovamente se studente1 == studente2
print("\n",studente1 == studente2)



