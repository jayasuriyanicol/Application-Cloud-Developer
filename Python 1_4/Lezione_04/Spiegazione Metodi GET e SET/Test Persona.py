'''

'''

'''
from persona import Persona

#Creo una persona
fm:Persona = Persona("Nicol", "Jayasuriya", "20")

print(fm)
print(fm.name, fm.last_name, fm.age)

#Richiamo la funzione displayData della classe Persona per mostrare i dati reltivi alla Persona
fm.displayData()
'''
#Dal file perosna importa la classe Persona
from persona import Persona

fm: Persona = Persona ()
#richiamo la funzione displayDat della classe Persona per mostrare in output le infromazioni relative all'oggetto fm

fm.displayData() 


#Modifichiamo il nome, cognome e età della persona fm. SUccessivamente andiamo a stampare il 
print("--------------")
fm.setName("Nathan")
fm.setLastName ("Mbuyamba")
fm.setAge(20)
fm.displayData()

#Tramite la metodologia GET, otteniamo i dati di cui abbiamo bisogno: NAME, LAST_NAME, AGE
print("--------------\n")
print(fm.getName(), fm.getLastName(), fm.getAge())

