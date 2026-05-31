'''
8-16. Imports: Using a program you wrote that has one function in it, store that function in a separate file. 
Import the function into your main program file, and call the function using each of these approaches:
import module_name
from module_name import function_name
from module_name import function_name as fn
import module_name as mn
from module_name import *

'''


'''                                                | FILE SALUTI |                                                                '''

#Creiamo un file chiamato 'SALUTI' dove andiamo a inserire la nostra funzione saluto che poi verrà uitilizzata nel file 'MAIN'

#Definiamo una funzione chiamaata saluto, passando un parametro 'nome' come str, e scrivendo un messaggio di benvenuto
def saluto(nome:str):
    
 print(f"\nCiao {nome} ! Ti diamo il BENVENUTO !")

