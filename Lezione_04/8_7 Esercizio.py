'''
8-7. Album: Write a function called make_album() that builds a dictionary describing a music album. 
The function should take in an artist name and an album title, and it should return a dictionary containing these two pieces of information. 
Use the function to make three dictionaries representing different albums. Print each return value to show that the  dictionaries are storing the album 
information correctly. Use None to add an optional parameter to make_album() that allows you to store the number of songs on an album. 
If the calling line includes a value for the number of songs, add that value to the album’s dictionary. 
Make at least one new function call that includes the number of songs on an album.
'''

#Definiamo una funzione che crea un album con relativo artista, titolo, ecc. e verifico se la chiave song è inserita altrimenti NONE
def make_album(artist:str, title:str, songs:int=None):

    album = {'Artista': artist.upper(), 'Titolo': title}
    if songs:
        album['Canzoni'] = songs
    return album

#Inserisco i valori di 3 album differenti, con l'album 3 anche l'opzione song e poi stampo i valori
album1 = make_album('ultimo', 'pianeti')
album2 = make_album('imagine dragons', 'evolve')
album3 = make_album('the weeknd', 'starboy', 18)  


print("\n", album1 )
print("\n", album2 )
print("\n", album3 )




'''
                                                        
                                                    |METODO ALTERNATIVO |


Metodo che permette l'inserimento di uin tot di album a piacere e l'inserimento direttamente da tastiera da parte dell'utente

#Definiamo una funzione nella quale creiamo l'album e aggiungiamo le varie variabili (chiavi e valori) + l'inserimento facoltativo della canzone nel dict
def make_album(artist: str, title: str, songs: int = None):
    album = {'Artista': artist.upper(), 'Titolo': title}
    if songs:
        album['Canzoni'] = songs
    return album

#Chiediamo l'inserimento dl num di album e creiamo una lista albums che conterrà tutti i nostri album
num_albums = int(input("Quanti album vuoi inserire? "))

albums = []

#Inserimento dei dati per il num_albums inseriti
for i in range(num_albums):
    i += 1
    print(f"\nInserisci i dati per il {i}° l'album:")
    artist = input("Nome dell'artista: ")
    title = input("Titolo dell'album: ")
    songs = input("Numero di canzoni (premi invio se non vuoi specificarlo): ")

    #Verifica se il numero delle canzoni è un numero intero
    songs = int(songs) if songs.isdigit() else None

    #Aggiunge il formato di make_album dentro albums
    albums.append(make_album(artist, title, songs))

#Stampa tutti i risultati degli album 
print("\nAlbum inseriti:")
for album in albums:
    print(album)
    
    
'''