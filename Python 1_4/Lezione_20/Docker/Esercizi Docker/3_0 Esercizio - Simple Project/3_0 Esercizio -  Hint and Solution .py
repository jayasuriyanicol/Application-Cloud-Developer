'''
Exercise 3
1. Create a simple project structure.
2. Create a python_requirments.txt to install python packages.
3. Create app.py to develop a Python app that uses the installed
package.
4. Create a Dockerfile based on the previous example to build your
docker image.
5. Run the container to execute your Python app.

'''


#Come primo step andiamo a creare il file e l'ambiente dfi "sviluppo" che ci interessa
'''
FROM python: 3.11.11 -> #ovvvero la versione di Python con cui andiamo a operare

COPY python_requirements.txt / -> #Copiamo il file 'python_requirements' nella /opt del container  

RUN pip install -r python_requirements.txt -> #Andiamo a installare i pacchetti Python elencati nel file dei requisiti 



RUN mkdir /app -> #Creiamo una directory dove andiamo a "ospitare" l'applicazione 'app.py' 
COPY app.py /app -> #Copiamo il file 'app.py' dalla macchina host dentro la directory /app del container  
WORKDIR /app -> # Andiamo ad impostare  /app come directory di lavoro dove da ora in poi tutti i coamndi vengono eseguiti da qui

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
    data = np.random.randint(0, 100, size=10)
    print("Array casuale:", data)
    print("Media:", np.mean(data))
    print("Deviazione standard:", np.std(data))
    print("Somma:", np.sum(data))

if __name__ == '__main__':
    main()


'''


#Come ultimo step andiamo a creare l'immagine Docker e ad eseguirla


'''

* Build the docker image

Run the following command:

$ docker build . -t esercizio-calcolo-media:latest


* Run the container

Run the following command:

$ docker run -it esercizio-calcolo-media:latest python app.py

'''

#Otteneremo come risultato la matrice casuale con relativa: medai,deviazione standard e somma.


'''

its@its-Virtual-Machine:~/Scrivania/ITS/Application-Cloud-Developer/Python 1_4/Lezione_20/Docker/Esercizi Docker/3_0 Esercizio - Simple Project$ docker run -it esercizio-calcolo-media:latest


Array casuale: [99 26 35 14  1 59 71 16 91 85]
Media: 49.7
Deviazione standard: 33.885247527500816
Somma: 497

'''
