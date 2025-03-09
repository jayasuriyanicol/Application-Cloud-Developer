'''
8-8. User Albums: Start with your program from Exercise 8-7. Write a while loop that allows users to enter an album’s artist and title. 
Once you have that information, call make_album() with the user’s input and print the dictionary that’s created. 
Be sure to include a quit value in the while loop.
'''

#INIZIO ESERCIZIO NUMERO 8_7

#Definiamo una funzione che crea un album con relativo artista, titolo, ecc. e verifico se la chiave song è inserita altrimenti NONE
def make_album(artist:str, title:str, songs:int=None):

    album = {'Artista': artist.upper(), 'Titolo': title}
    if songs:
        album['Canzoni'] = songs
    return album

#FINE ESERCIZIO 8_7

#INIZIO ESERCIZIO 8_8

#Condizione WHILE True, finchè non esce quit continuiamo a stampare da INPUT tutto quello che ci viene richiesto
while True:

     artist = str(input("\nInserisci il nome dell'ARTISTA: "))
     if artist.lower() == "quit":
      break
     
     title = str(input("\nInserisci il titolo della CANZONE: "))
     if title.lower() == "quit":
      break
     
     songs = int(input("\nInserisci il numero di CANZONI presenti sull'ALBUM: "))
     if songs.lower() == "quit":
      break
     
     songs = int(songs) if songs.isdigit() else None
     album = make_album(artist,title, songs)

     print ("\nEcco il tuo ALBUM" ,album)
print("\n\nProgramma TERMINATO") 

#FINE ESERCIZIO 8_8
