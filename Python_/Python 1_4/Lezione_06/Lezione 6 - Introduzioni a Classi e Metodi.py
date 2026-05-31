'''
CLASSI in Pyhton, Lezione Introduttiva 13/03/2025 
'''


'''
#Creiamo la classe PERSONA, creando al di sotto un costruttore
class Persona:

    #Il self serve per salvare la singola istanza del parametro
    def __init__ (self, nome:str, cognome:str, data_nascita:str):
         
      self.nome = nome 
      self.cognome = cognome
      self.data_nascita = data_nascita
      


#Invece di richiamare la classe, in questo caso richiamiamo il COSTRUTTORE, indicando tra i due punti iln ila  calsse in questione che è 'PERSONA'
persona_1: Persona = Persona("Nicol", "Jayasuriya", "05/06/2004")
persona_2: Persona = Persona(nome = "Nathan", cognome = "Mbuyamba", data_nascita = "08/01/2004")

#Istanze diverse, ma appertenenti allo stesso costruttore.
print(persona_1.nome)
print(persona_2.nome)

#Andiamo ad analizzare bil concetto di ERIDITARIETÀ



class Studente(Persona):
   
   def __init__(self, nome, cognome, data_nascita, corso_seguito):
      
 #Invece di riscrivere tutti i dati presenti in def, chiamo una superclasse con 'super()' 
      super().__init__(self, nome, cognome, data_nascita)

      self.corso_seguito = corso_seguito

studente_1: Studente =  Studente("Nicol","Jayasuriya", "05/06/2004", "Calcolatori Elettronici")
      

print(studente_1.nome)
'''


'''LEZIONE 14/03/2025

SPIEGAZIONI CLASSI - Object Oriented Programming

L'oggetto di una classe è l'istanza di una classe, tramite i modelli possiamo approssimare le cose e possiamo prevedere i casi.
Parliamo di approssimazione dato che non sono leggi o cocncetti definitivi o precisi.
Tramite le classi creiamo un modello, che ci permettere di svolgere ovvero simulare la realtà. 

Le classi sono come degli stampi, ovvero prendiamo questi stampi e possiamo modellarli a nostro piacimento,
e può avere delle istanze ovvero per esempio la Classe studente può contenere nomi degli studenti.

Le classi hanno attributi e sia metodi(funzioni), i metodi specificano le funzioni di una classe ovverro un oggetto dell'istanza :
inserimento voto.




EREDITARIETÀ:
Ci permette di non duplicare il codice e avere un programma ben strutturato:

PERSONA: età e peso
STUDENTE:  età e peso +  Matricola Univeristà e Univeristà
STUDNETE STRANIERO:  età,peso, Matricola Univeristà, Univeristà e Origine dell'Università


La sintassi in Python per la creazione di una classe è la seguente:

class Name_Class | NameClass: #La prima lettera per OBBLIGO deve essere maiuscola

 Inizializzazione dell'oggetto | COSTRUTTORE: def __init__(self,param_1,param_2) #Ci permette di creare una nuova istanza e degli attributi, diverso per ogni istanza che noi creiamo e deve essere implicito

 self.parm_1 = param_1 #In questa maniera con self, serve per indicare che la variabile si riferisce alla istanza  in particolare
 self.parm_2 = parm_2  



 name_variabile_1 : Name_Class = NameClass("input" , "input" , input)
 name_variabile_2 : Name_Class = NameClass("input" , "input" , input)

#Il dato inserito verrà salvato un due differenti istanze nonostante appartenenti alla stessa classe, dato che sono 
allocate in due indirizzi di memoria differenti.

 def function (self) -> type #Attraverso questo caso andiamo a scrivere una funzione per la clase
 return self.variabile 

 print(parm_1.function) 
 print(parm_1.function()) 


self. __name_variabile #Secondo questa sintassi rendiamo privata una variabile, tramite "__" doppio underscore, ma al moento non lòa utilizzeremo


- AGGIORNAMENTO LEZIONE 24/03/2025:

                           |DIFFERENCE BETWEEN GLOBAL AND LOCAL ATTRIBUTES|

class name_class:
 #GLOBAL PART  - OBJECT CLASS
  global_object
  
 #Attraverso self, accediamo ad un attributo presente dentro un costruttore oppure dentro una classe. 
  def _init__ (self, name_attribute):
     #LOCAL PART - OBJECT ATTRIBUTES 
      self.name_attribute =  name_attriute

 #Attraverso cls, possiamo accedere all'oggetto globale che si trova al di fuori del costruttore 
  def getGlobalObject(cls):
      name = len(global_object)
      return name

                                       |DECORATOR - DECORATORE|
            
#Utilizzo dei METODI STATICI con l'utilizzo del DECORATOR
 @staticmethod -> Decorator
 def name_function(lst:list[int] , val: int ) -> list:
     lst.append(val)
  
     

                                               
                                              | METODO __CALL__ |

  #Attraverso il metodo __call__ permette di nrendere un'istanza di una classe, quindi un oggetto prenderlo e interpretarlo come una funzione.
  
  Le principali funziuonalità sono:

   1. PRENDERE OGGETTI COME FUNZIONI
   2. MIGLIORE LEGGIBILITÀ E FLESSIBILITÀ 
   3. GENERAZIONE DINAMICA DEGLI OGGETTI

   Vediamo un esempio più pratico: 
    
   class coffeeMachine: 
    def __init__ (self,tipology= "Espresso"):
        self.tipology = tipology
      
    def __call__ (self):
        return f"We can prepare a coffee {self.tipology}
    
    machine = coffeeMachine()
    print(machine()) -> Questo ci ritornerà il valore indicato che è per l'appunto un caffè ESPRESSO.
    machine_cappuccino = coffeeMachine("Cappuccino")
    print(machine_cappuccino()) -> Abbiamo modificato il valore di caffè e lo cambiamo con CAPPUCCINO.

                                        
                                        
                                        | METODO __STR__ e __REPR__ |


                                  
 #Attraverso il metodo __str__ e __repr__ sono utilizzati per definire le rappresentazioni in formato stringa di un oggetto. 
 Il metodo `__str__` fornisce una rappresentazione leggibile e user-friendly dell'oggetto, mentre `__repr__` restituisce una rappresentazione 
 più dettagliata e tecnica, utile per gli sviluppatori e il debugging.


In sintesi, `__str__` è destinato a fornire una descrizione chiara e comprensibile dell'oggetto per l'utente finale, mentre `__repr__` mira a fornire 
una rappresentazione precisa e informativa dell'oggetto, utile per la diagnostica e il debugging.
  
 METODO __STR__ e  __REPR__ :

  __str__ = Metodo INFORMALE -> Dove viene 'printata' la nostra infromazione, in modo INFORMALE, dato GREZZO.
  _repr__ = Metodo FORMALE -> Dove viene anche richiamata anche una possibile funzione che noi creiamo.

  Sono molto identici, la loro funzione è praticamente identica solo che vengono utilizzati in casi differenti l'uno dall'altro.


  Facciamo un esempio PRATICO sull'utilizzo di queste due METODI:

  class MacchinaCaffe:
    def __init__(self, tipo="Espresso", marca="DeLonghi"):
        self.tipo = tipo
        self.marca = marca

    def __str__(self):
        return f"☕ Macchina del caffè {self.marca}, pronta a fare un {self.tipo}!"

    def __repr__(self):
        return f"MacchinaCaffe(tipo='{self.tipo}', marca='{self.marca}')"

  macchina = MacchinaCaffe("Cappuccino", "Nespresso")

  print(str(macchina))  # Output Metodo INFORMALE:  Macchina del caffè Nespresso, pronta a fare un Cappuccino!


  print(repr(macchina))  # Output Metodo FORMALE: MacchinaCaffe(tipo='Cappuccino', marca='Nespresso')






     

     
     
'''