'''
8-11. Archived Messages: Start with your work from Exercise 8-10. 
Call the function send_messages() with a copy of the list of messages. 
After calling the function, print both of your lists to show that the original list has retained its messages.
'''

#Creiamo una lista con tutti i messaggi dell'esercizio precedente in più una lista vuota dove inseriremo la copia dei messaggi
messages = ["Che la forza sia con te!", "Ricordati sempre chi sei!", "Il traguardo è più vicino di quello che sembra!"]
sent_messages = []  

#Definiamo una funzione che legge i messaggi della vecchia lista e li sposta nella nuova.
def send_messages(messaggi):
    while messaggi:
        messaggio_corrente = messaggi.pop(0)
        print("\nMessaggio inviato:", messaggio_corrente)
        sent_messages.append(messaggio_corrente)


#Richiamiamo nuovamente la funzione con il parametro
send_messages(messages)

#Stampiamo entrambe le liste per verificare che la lista originale sia stata svuotata
print("\nLista ORIGINALE (dopo l'invio, ora vuota):", messages)
print("Lista dei messaggi INVIATI:", sent_messages)
