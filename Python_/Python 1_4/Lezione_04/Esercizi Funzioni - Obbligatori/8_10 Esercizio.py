'''
8-10. Sending Messages: Start with a copy of your program from Exercise 8-9. 
Write a function called send_messages() that prints each text message and moves each message to a new list 
called sent_messages as it’s printed. After calling the function, print both of your lists to make sure the messages were moved correctly.

'''
#INIZIO ESERCIZIO 8_9

#Defin#amo la lista con i messaggi corti
messages:list =["Che la forza sia con te !", "Ricordati sempre chi sei !", "Il traguardo è più vicino di quello che sembra !"] 


print("\n--------------")
#Funzione che stampa tutti i messaggi uno per volta all'interno della lista
def show_message(message:list):

   for i in message:
       print("\nVECCHIO ESERCIZIO - MESSAGGIO: ",i)

show_message(messages)
print("\n--------------")

#FINE ESERCIZIO 8_9



#INIZIO ESERCIZIO 8_10


#Creiamo una lista vuota dove inseriamo uno per uno i messaggi dalla lista precedente
sent_messages:list= [ ]  
print("\n--- NUOVO ESERCIZIO (8_10) --- ")

#Definiamo la funzione con CICLO WHILE che elimina dalla vecchia lista il messaggio e lo posiziona nella nuova lista, stampando ad ogni iterazione il messaggio corrente
def send_messages(messaggio):
    while messaggio:

     messaggio_corrente:str = messages.pop(0)
     
     print("\n",messaggio_corrente)
     
     sent_messages.append(messaggio_corrente)


#Definiamo la funzione con l'ausilio del CILO FOR, che fa la medesima azione, come CICLO alternativo

'''                                    |CICLO FOR|                                          '''


'''def send_messages(messagges):

 for messaggio in messages[:] :
    print(messaggio)
     
    messages.remove(messaggio)

    
    sent_messages.append(messaggio) '''


#Infine richiamiamo la funzione con il parametro associato precendentemente, mostrando le due liste differenti
send_messages(messages)
print("\nQuesta è la lista VECCHIA: ",messages)
print("\nQuesta è la lista NUOVA: ",sent_messages) 
print("\n--------------")
