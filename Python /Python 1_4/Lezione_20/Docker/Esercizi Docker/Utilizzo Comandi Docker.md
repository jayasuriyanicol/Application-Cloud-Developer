# 🐳 Lezione DOCKER - comandi per manipolazione dei FILE


## 1. Prepara i file del progetto

```bash
mkdir mio-progetto-docker
cd mio-progetto-docker
touch Dockerfile
touch python_requirements.txt
touch app.py
```

## 2. Scrivi il contenuto dei file

### `python_requirements.txt`

```txt
flask
```

### `app.py`

```python
print("Benvenuto in Docker!")
```

### `Dockerfile`

```Dockerfile
FROM python:3.11.11
COPY python_requirements.txt /opt
RUN pip install -r /opt/python_requirements.txt
RUN mkdir /app
COPY app.py /app
WORKDIR /app
CMD ["python", "app.py"]
```

##  3. Costruisci l’immagine Docker

```bash
docker build -t esercizio-docker .
```

##  4. Verifica che l’immagine sia stata creata

```bash
docker images
```

##  5. Avvia il container

```bash
docker run -it esercizio-docker
```

##  6. Comandi utili

- **Vedere tutti i container attivi:**
  ```bash
  docker ps
  ```

- **Vedere tutti i container (anche terminati):**
  ```bash
  docker ps -a
  ```

- **Fermare un container attivo:**
  ```bash
  docker stop <nome-container>
  ```

- **Rimuovere un container:**
  ```bash
  docker rm <nome-container>
  ```

- **Rimuovere un'immagine:**
  ```bash
  docker rmi esercizio-docker
  ```

- **Eseguire un comando dentro un container attivo:**
  ```bash
  docker exec -it <nome-container> bash
  ```