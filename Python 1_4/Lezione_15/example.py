'''
FILE: Andiamo a vedere il funzionamento dei FILE in Python. 

Un file è una sequenza di Bit composta da 0 e 1, ogni file è composto da 3 parti distinte:

- HEADER -> Dove sono contenute le informazioni di un file 
- BODY -> Dove sono contenute tutte le informazioni del file
- EOF -> Acronimo di End Of File, dove capiamo che il file è concluso, TERMITATO

Operazioni possibili : open(...) and code (...) -> ritorna un Wrapper: una classe che include delle funzioni
                       permette di svolgere delle funzioni. Chiamato anche come I/O Wrapper per la gestione di I/O dei dati
                       



'''
'''PATH : str = "'Lezione_15/example.txt"

file = open(PATH,"r", encoding="utf-8")
output : str = file.read()
print(output)
file.close()'''


'''
file = open("Lezione_15/example.txt","a") -> a: append
try:
    pass
except Exception as e:
    pass

finally: -> eseguito sempre, a caso delle ricezioni lanciate o meno. 
            Usiamo else, se non viene lanciato
    file.close()
    oppure
    reader.close() 
#home/its/Lezione_15/example.py
'''

#CONTEXT MANAGER : una classe, ha due funzioni speciali __ENTER__ ed __EXIT__ -> open ( relative PATH of the file, "r or w") as reader -> viene inserito nella variabile reader
with open("Lezione_15/example.txt","w") as file:
    print(file.read()) #-> Per leggere il file e chiude in automatico il codice senza bisogno di close. 


import time
class MyResource:


    def __init__(self):
        
        self.start_time = 0.0
        self.end_time = 0.0
        

    def __enter__(self):

        self.start_time = time.time()
        print("Sono nella funzione ENTER,\nRISORSA ACQUISITA!")
        return self
    
    def __exit__(self):

        self.end_time = time.time()
        # ... 
        

print("Sono all'inizio del programma")

with MyResource() as resources:
    print("Sono dentro il blocco WITH")       

