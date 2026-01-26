'''
Esercizio 3
Scrivere un programma che acquisisca una stringa inserita dall'utente e generi una nuova stringa che corrisponda
alla versione invertita della stringa originale. 
Il programma deve poi visualizzare la stringa ottenuta in output. 
Per risolvere il problema non si deve utilizzare alcun tipo di funzione, ma esclusivamente i cicli.

'''
#Inizializziamo la stringa dove poi andremo a inserire la stringa capovolta
stringa_capovolta = ""

#Input della stringa da tastiera
stringa:str = input("\nBenvenuto questo programma trasforma una stringa in reverse con l'utilizzo di cicli\n\nPrego, inserire una stringa: ")

#Utilizziamo un contatore e un ciclo FOR per leggere i caratteri della stringa
contatore = 0
#Per ogni carattere nella stringa andiamo a incrementare il contatore
for carattere in stringa:  
    contatore += 1

#Con questa operazione attraverso l'indice "contatore" andiamo dall'ultimo carattere al primo.
i = contatore - 1

#Utilizziamo un cilo WHILE per costruire carattere per carattere la stringa_capovolta
while i >= 0:
    stringa_capovolta += stringa[i]

   #Decrementiamo con -1 finchè la condizione non sarà più vera !=0
    i -= 1  

#Output riportando il risultato
print(f'\nEcco qui il valore della nuova stringa in reverse: "{stringa_capovolta}" ')




''' IN ALTERNATIVA, LASCIANDO COME COMMENTO, DATO CHE POTREBBE NON Attraverso lo slicing andiamo a non specificare l'inizio e la fine leggendo tutta la stringa
# e utilizzando il -1 per leggerlo al contrario.

reverse_stringa:str = stringa [::- 1] '''


