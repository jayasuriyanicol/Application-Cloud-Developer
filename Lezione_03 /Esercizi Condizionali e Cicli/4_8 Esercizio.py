'''
4-8. Cubes: A number raised to the third power is called a cube. For example, the cube of 2 is written as 2**3 in Python. 
Make a list of the first 10 cubes (that is, the cube of each integer from 1 through 10), and use a for loop to print out the value of each cube.

'''
#Creiamo uan lista di CUBI che andranno in rnage dalla prima variabile 1 a 11 ovvero 11-1=10, il cubo lo memorizziamo all'interno di numero
cubi =[numero **3 for numero in range(1,11)]  
n=0


#Abbiamo dichiarato un contatore N che calcolerà ad ogni ciclo quante volte il cubo di quel numero verrà stampato.
for cubo in cubi:
 n+=1
 print(f"Questo è il {n} cubo: ",cubo)
 