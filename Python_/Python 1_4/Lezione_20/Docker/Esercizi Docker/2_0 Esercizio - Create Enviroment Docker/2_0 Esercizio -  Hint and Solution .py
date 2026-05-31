'''
Exercise 2
New, create your Python environment and your Python app!
Step 1. Create the following files:
● Create Dockerfile
● Create python_requirements.txt
● Create app.py

'''


#Come primo step andiamo a creare il file e l'ambiente dfi "sviluppo" che ci interessa
'''
FROM python: 3.11.11 -> #ovvvero la versione di Python con cui andiamo a operare

COPY python_requirements.txt / -> #Copiamo il file 'python_requirements' nella /opt del container  

RUN pip install -r python_requirements.txt -> #Andiamo a installare i pacchetti Python elencati nel file dei requisiti 



RUN mkdir /app -> #Creiamo una directory dove andiamo a "ospitare" l'applicazione 'app.py' 
COPY app.py /app -> #Copiamo il file 'app.py' dalla macchina host dentro la directory /app del container  
WORKDIR /app -> #Andiamo ad impostare  /app come directory di lavoro dove da ora in poi tutti i coamndi vengono eseguiti da qui


CMD ["python", "app.py"] ->#Comando di default che il container esegue all'avvio 


'''


#Come secondo step andiamo a riportare il contenuto nel file 'python_requirements'

'''
numpy == 2.2.4

'''


#Come terzo step andiamo a scrivere il contenuto all'interno del file 'app.py'

'''
import numpy as np


def main():
    matrix = np.array([

       [1, 2, 3],
       [4, 5, 6],
       [7, 8, 9] 
    
    ] )

    print("Matrice di partenza: ")
    print(matrix)


    print("\nMatrice Trasposta: ")

    transposedMatrix = matrix.T
    print(transposedMatrix)


if __name__ == '__main___':
   main()


'''


#Come ultimo step andiamo a creare l'immagine Docker e ad eseguirla


'''

* Build the docker image

Run the following command:

$ docker build . -t dockerized-pythonapp:latest


* Run the container

Run the following command:

$ docker run -it dockerized-pythonapp:latest python app.py

'''

#Otteneremo come risultato la matrice originale e quella trasposta


'''

its@its-Virtual-Machine:~/Scrivania/ITS/Application-Cloud-Developer/Python 1_4/Lezione_20/Docker/Esercizi Docker/2_0 Esercizio - Create Enviroment Docker$ docker run -it dockerized-pythonapp:latest



Matrice di partenza: 
[[1 2 3]
 [4 5 6]
 [7 8 9]]

Matrice Trasposta: 
[[1 4 7]
 [2 5 8]
 [3 6 9]]



'''
