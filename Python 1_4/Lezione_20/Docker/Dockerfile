#Usa l'immagine ufficiale di Python 3.11.11 come base
FROM python:3.11.11

#Copia il file dei requisiti Python nella directory /opt del container
COPY python_requirements.txt /opt

#Installa i pacchetti Python elencati nel file dei requisiti
RUN pip install -r /opt/python_requirements.txt

#Crea una directory chiamata /app nel container per ospitare l'applicazione
RUN mkdir /app

#Copia il file app.py dalla macchina host alla directory /app del container
COPY app.py /app

#Imposta /app come directory di lavoro; da qui in poi tutti i comandi verranno eseguiti da questa directory
WORKDIR /app



