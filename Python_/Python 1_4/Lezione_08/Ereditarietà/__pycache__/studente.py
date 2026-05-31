

'''La classe Persona avra due TIPOLOGIE di attributi:
       
    1. self.name
    2. self.lastname
    3. self.age

    Attributi che aggiungiamo alla classe Studente:

    1. self.matricola
        
    '''
    

'''Attraverso questa funzione possiamo verificare che tutto coincida e che abbiamo ereditato corretamente:
    
    def inheritaceTest(self):

       #Verichiamo che la classe Studnete erediti tutti gli attributi della classe Persona
       self.name
       self.lastname 
       self.age

       #Verifichiamo che la classe studnete erdetiti tutti i metodi della classe Persona
       self.getName
       self.getLastame
       self.getAge 
    '''

#Dal modulo persona.py importa la classe Persona
from persona import Persona

#Dirò che la classe Studente eredita gli attributi della classe Persona
class Studente(Persona):

    '''
    La classe Studente eredita dalla classe Persona e aggiunge:
     1. self.matricola: str (Attributo di tipo stringa)
    '''

    #Inizializziamo un oggetto della classe Studente
    def __init__(self, name: str, lastname: str, age: int, matricola: str):
        # Attraverso super(), richiamiamo il costruttore della superclasse (Persona)
        super().__init__(name, lastname, age)
        #Inizializziamo l'attributo specifico della classe Studente
        self.setMatricola(matricola)

    #METODO SETTER: consente di impostare il valore dell'attributo matricola
    def setMatricola(self, matricola: str) -> None:
        # Verifichiamo che la matricola non sia vuota
        if matricola:
            self.matricola = matricola
        else:
            print("Errore! La matricola non può essere una stringa vuota")

    #METODO GETTER: consente di ottenere il valore dell'attributo matricola
    def getMatricola(self) -> str:
        return self.matricola
    
    #Metodo che consente di visualizzare le informazioni relative ad un oggetto della classe Studente
    def __str__(self)->str:
       return f"\n\nNome:{self.getName()}\n\nCognome:{self.lastname}\n\nMatricola:{self.getMatricola()}"
   

    #Metodo che mi consente di calcolare la medai degli esami sostenuti da uno studente:
    def getMediaEsami(self,voti_esami:list[int])-> float:
        
       #Verifichiamo se la somma della lista non è vuota
       if voti_esami:

           somma:int = 0

           for voto in voti_esami:
               somma += voto
           
           return round(somma/len(voti_esami), 2) 
       #Se la lista è vuota, significa che non avremmo nessun voto, quindi ritorniamo 0 a due cifre decimali
       else:

           return 0.00  
     
    #Metodo che consente di controntare due oggetti della classe Studente e stabilire se questi due oggetti siano uguali o meno
    #Due studenti sono uguali se hanno la stessa MATRICOLA 
    def __eq__(self, other) -> bool:
        #Se other(altro studente di tipo oggetto) è None, oppure se other non è istanza della classe Studente -> ritorno False
        if other is None or not isinstance(other, type(self)):
            return False
        
        #Altrimenti valuta questa uguaglianza
        else:
            return self.getMatricola() == other.getMatricola()  