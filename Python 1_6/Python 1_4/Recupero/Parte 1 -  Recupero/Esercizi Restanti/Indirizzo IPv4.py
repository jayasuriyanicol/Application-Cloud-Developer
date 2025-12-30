'''
Validazione di un Indirizzo IPv4
Scrivi una funzione is_valid_ipv4(address: str) -> bool che determina se una
stringa è un indirizzo IPv4 valido. Un indirizzo IPv4 è composto da quattro numeri decimali
(ciascuno da 0 a 255) separati da punti (.). Gli zeri iniziali sono consentiti (ad esempio
192.168.001.001 è valido), ma ciascuna delle quattro parti deve essere compresa tra 0 e
255 e non deve contenere caratteri o spazi aggiuntivi.
Requisiti:
● Se non ci sono esattamente tre punti o non ci sono quattro parti numeriche,
restituisci False.
● Ciascuna parte deve contenere solo cifre (isdigit()) e, convertita in intero, deve
essere nel range [0,255][0,255][0,255].
Esempi:
is_valid_ipv4("192.168.0.1") # True
is_valid_ipv4("255.255.255.255") # True
is_valid_ipv4("256.100.10.1") # False (256 è fuori range)
is_valid_ipv4("192.168.1") # False (solo 3 parti)
is_valid_ipv4("192.168.1.a") # False (parte non numerica)

'''

"192.168.0.1"
#Definiamo una funzione che controlla se una stringa è un indirizzo IPv4 valido
def is_valid_ipv4(address: str) -> bool:

    #Verifichiamo che ci siano esattamente 3 punti nella stringa (IPv4 ha 4 blocchi)
    if address.count(".") != 3:
        return False

    #Dividiamo la stringa in parti usando il punto come separatore
    partiDistinte = address.split(".")

    #Controlliamo che il risultato della divisione abbia esattamente 4 elementi
    if len(partiDistinte) != 4:
        return False
    
    #Per ogni parte dell’indirizzo
    for elemento in partiDistinte:

        #Controlliamo che sia composta solo da cifre
        if not elemento.isdigit():
            return False

        #Convertiamo la parte in intero per il controllo del range
        elementoCoerente = int(elemento)

        #Verifichiamo che il valore sia compreso tra 0 e 255
        if not (0 <= elementoCoerente < 256):
            return False
    
    #Se tutte le condizioni sono rispettate, l’indirizzo è valido
    return True


''' DRIVER PROGRAM - Test delle funzionalità della funzione con vari casi '''


print(is_valid_ipv4("192.168.0.1"))
print(is_valid_ipv4("255.255.255.255"))
print(is_valid_ipv4("256.100.10.1"))
print(is_valid_ipv4("192.168.1"))
print(is_valid_ipv4("192.168.1.a"))


