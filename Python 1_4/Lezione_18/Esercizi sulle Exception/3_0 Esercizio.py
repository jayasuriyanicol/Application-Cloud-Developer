'''
3. Context Managers for File Handling: Use the with statement and context managers to open and close a file. 
Handle potential IOError within the with block for clean resource management.
'''

#Creiamo due funzioni separate per la LETTURA e la SCRITTURA del file



#Nella funzione di LETTURA del file andiamo ad aprilo e abilitare la lettura con 'r' (read), acquisiamo il contenuto salvandolo in una variabile e stampiamo il messaggio di avvenuto successo
def readFile(filename):
    try: 
        with open(filename,'r') as file:
            contenuto = file.read()
            print("Accesso al file avvenuto con successo !\n", contenuto)
    
    #In caso negativo, mandiamo un messaggio di EXCEPT con relativo messaggio di errore nella lettura del FILE 
    except IOError as error:
        print(f"Attenzione ! Errore nella lettura del FILE {error} !")



#Proseguiamo con la funzione che permette la SCRITTURA del file attraverso il medesimo procedimento però in 'w' ovvero scrittura, con relativi messaggi di successo o negativo in caso di insdef writeFile(filename, text):
def writeFile(filename):
    try:
        with open(filename, 'w') as file:
            contenuto = file.write()
            print("Accesso e abilitazione con scrittura avvenuto con successo !\n", contenuto)
    except IOError as error :
        print(f"Errore nella scrittura del file {error} !")










