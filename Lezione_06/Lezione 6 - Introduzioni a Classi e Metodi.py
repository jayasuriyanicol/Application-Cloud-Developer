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

#Il dato inserito verrà salvato un due differenti istanza nonostante appartenenti alla stessa classe, dato che sono 
allocate in due indirizzi di memoria differenti.

 def function (self) -> type #Attraverso questo caso andiamo a scrivere una funzione per la clase
 return self.variabile 

 print(parm_1.function) 
 print(parm_1.function()) 


self. __name_varibile #Secondo questa sintassi rendiamo privata una variabile, tramite "__" doppio underscore, ma al moento non lòa utilizzeremo






'''