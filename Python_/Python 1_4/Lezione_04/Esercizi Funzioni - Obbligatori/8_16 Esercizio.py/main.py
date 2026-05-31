'''
8-16. Imports: Using a program you wrote that has one function in it, store that function in a separate file. 
Import the function into your main program file, and call the function using each of these approaches:
import module_name
from module_name import function_name
from module_name import function_name as fn
import module_name as mn
from module_name import *

'''


'''                                                | FILE MAIN |                                                                      '''

#Creiamo adesso un file chiamato 'MAIN' dove andiamo a richiamare il nostro file 'SALUTI' cosi da richiamare anche la funzione presente in essa.


#In questro esercizio come richiesto dalla consegna andiamo a adoperare diverse modalità di IMPORT e FROM. In particolare:


#Partiamo con la modalità base che per l'appunto l'utilizzo di IMPORT nella forma BASE: nome_file.nome_funzione("Oggeto in questione")
import saluti 
saluti.saluto("Nicol")

#Con la seconda modalità andiamo a richiamare (FROM) il FILE e successivamente importare il nome della funzione presente nel FILE (IMPORT), con la dicitura: nome_funzione("Oggeto in questione")
from saluti import saluto
saluto("Nathan")

#Con la terza modalità, ci adoperiamo come nella seconda però poi andando a 'rinominare il file' utilizzando il 'AS' con un nuovo nome da adare al FILE, quindi la dicitura sarà la seguente: nome_rinominato("Oggetto in questione") 
from saluti import saluto as salutare
salutare("Michael")

#Con la quarta modalità, andiamo importare il file ma rinominarlo nuovamente con  'AS', la modlità di dicitura ssaà sempre la medesima
import saluti as salve
salve.saluto("Mattia")

#Con l'ultima modalità ovvero la quinta, andiamo a prendere il file in questione ed ad importare tutto quanto con l'asterisco '*', che significa prendi tutto 'ALL'
from saluti import *
saluto("Diego")
