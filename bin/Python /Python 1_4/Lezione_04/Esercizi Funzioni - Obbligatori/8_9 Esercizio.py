'''
8-9. Messages: Make a list containing a series of short text messages. 
Pass the list to a function called show_messages(), which prints each text message.

'''
#Definiamo la lista con i messaggi corti
message:list =["Che la forza sia con te !", "Ricordati sempre chi sei !", "Il traguardo è più vicino di quello che sembra !"] 

#Funzione che stampa tutti i messaggi uno per volta all'interno della lista
def show_message(message:list):

   for i in message:
       print("\n",i)


#Richiamiamo la funzione con il parametro
show_message (message)

