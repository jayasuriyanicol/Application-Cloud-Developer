class Alieno:

    '''
    Nella classe alieno ci interessa sapere, la galassia di provenzienza:
     -self.galaxy: str

    
    
    '''

    #Inizializziamo un oggetto della classe Alieno
    def __init__(self, galaxy:str):
        self.setGalaxy(galaxy)


    #Si limita a settare il nostro dato (nome) attraverso setGalxy
    def setGalaxy(self, galaxy:str) -> None:

        #Se la galaxy n on è vuota andiamo associarlo a self 
        if galaxy:
            self.galaxy = galaxy

        #Altrimenti andiamo a stampare un messaggio di errore 
        else:
            print("Errore ! La galassia di provenienza non deve essere una stringa vuota !")

    def getGalaxy(self) -> str:

        return self.galaxy
    
    #Attraverso la funzione __str__ andamo a ritornare una stringa 
    def __str__(self) -> str:

        return f"\nAlieno proveninete dalla galassia {self.getGalaxy}\n"
    
      
    #Ci ritorna una frase in linguaggio alieno 
    def speak(self) -> None:

        print("fjqdkwhfjohs")

