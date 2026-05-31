'''
                                                                   PROGRAMMA CIFRATURA RSA 

    CONSEGNA :
    Estrarre n (modulus), e (public exponent), d (private exponent) dal file PEM (chiave pubblica)
    Convertire n, e, d in numeri interi
        • Esempio: n: togliere i «:», togliere «\n», togliere « « e poi con la funzione int(s, 16) => numero intero
        • Prendete il messaggio e convertitelo in numero intero
        • Poi eseguite
        • Cifra: pow(M, e, n) => C (messaggio cifrato)
        • Decifra: pow(C, d, n) => M
        • Riconvertire M in stringa e verificare se avete decifrato correttamente

'''

#Inserisco i n: moduli e gli e :esponenti privati dal file PEM chiave pubblica

n: str =''' 00:d3:3a:90:4a:fe:0f:9a:8d:ec:76:2e:3b:89:bb:
            9c:ca:f9:20:8c:19:d8:5c:5b:21:de:63:03:19:55:
            c5:b8:11:6d:7a:70:2b:01:b6:ba:0f:de:b0:98:32:
            9d:dd:0f:99:96:20:64:b0:bd:6b:99:e0:d8:40:97:
            a2:95:fc:d2:0a:be:34:a4:18:f1:84:72:8a:e8:ec:
            41:8c:e7:65:99:62:5c:74:bf:2f:27:50:b2:fb:62:
            fe:a4:f9:f0:01:f8:7c:bf:5f:0b:1f:29:9e:21:e6:
            10:3a:db:16:34:bb:00:3b:0f:41:c4:e6:06:67:f9:
            0a:71:22:04:ec:ac:7b:aa:b3:db:b9:18:bb:f9:f4:
            4d:63:16:cd:ff:3c:96:d9:cc:14:ad:92:35:cb:81:
            aa:0b:b8:e5:ec:d2:d8:f8:a1:1a:5b:a4:ad:df:ca:
            4f:6c:65:f4:5c:fc:9f:2c:85:2c:c4:fa:8d:71:85:
            3b:4f:6c:df:62:96:87:32:c9:12:2a:d4:80:53:9b:
            4b:ba:65:34:d3:e8:1b:b0:b0:e9:72:c8:9d:af:b2:
            33:69:2f:69:af:08:75:e5:65:72:a1:2e:20:5b:4a:
            9b:72:a2:f8:2d:24:88:1c:ff:1f:c9:03:1b:29:2e:
            d9:80:ed:f3:43:89:ce:35:85:89:9c:e2:d1:d6:fe:
            92:d5'''





d: str =''' 22:f5:db:71:fe:10:d9:14:ca:61:59:0f:93:a1:50:
            b7:2b:7a:9e:95:9c:80:d4:b8:8b:55:39:eb:14:8e:
            30:03:fa:69:bc:6c:f1:d0:ab:84:fa:e7:a1:99:27:
            15:b2:82:4a:1d:bc:6c:a0:3d:51:ef:ab:fb:2c:dd:
            c5:13:5e:34:56:fc:e1:78:1b:69:3f:88:0c:3b:26:
            32:4b:0e:3e:cf:cf:db:a6:d5:08:1d:cc:31:dd:55:
            a6:3a:93:e5:cf:99:de:16:be:01:7f:62:e3:db:6f:
            2e:3e:9a:b3:49:8c:25:3a:46:39:6f:94:f9:da:77:
            46:f8:49:76:5e:a9:ed:3b:a0:95:5b:d4:d6:6c:b8:
            52:47:25:c3:42:02:55:5a:cc:44:19:7b:b9:08:97:
            a9:18:26:5b:66:b2:43:58:b8:15:7a:57:9f:bd:98:
            40:9c:fb:69:c6:2d:cc:b1:af:96:d3:6e:74:6f:f9:
            9a:d1:48:2c:48:fa:cc:90:ad:67:15:61:ac:4f:3d:
            12:a3:ee:cd:f9:bc:11:08:e4:64:6d:e6:c9:36:79:
            ec:79:c3:cb:74:a8:68:c6:f7:d2:dd:33:f0:90:00:
            6a:7c:bc:f7:35:eb:63:6c:67:47:87:97:ba:cd:52:
            98:1a:58:d5:1f:b0:db:95:13:f0:50:80:d3:e3:a2:
            d5'''



#Aggiungo la stringa di esempio che andremo a convertire, in più l'esponente
stringaEsempio = 'Benvenuto ! Questo è un mini programma RSA di cifratura e decifratura !'
e:int = 65537


#Vado a eliminare eventuali discrepanze che ci possano essere durante la CIFRATURA
n:int = int(n.replace(":", "").replace('\n', '').replace(' ',''),16)
d:int = int(d.replace(":", "").replace('\n', '').replace(' ',''),16)


#Inizio la cifratura ad 8 bit, cifrando il messaggio e dopo decifrandolo
messaggioBinario = ''
for carattere in stringaEsempio:

    codiceAscii = ord(carattere)
    stringaBinaria = format(codiceAscii, '08b')
    messaggioBinario += stringaBinaria

    MCifratura:int = int(messaggioBinario,2)

    C = pow(MCifratura,e,n)
    MDecifratura = pow(C,d,n)
    MDecifraturaBinaria = format(MDecifratura, 'b')


    #Verifico che il messaggio DECIFRATO sia multlipo di 8 bit, in caso non lo sia, aggiungo degli zeri all'inizior per 'riempirlo' completando il BYTE 
    lunghezzaCorretta = (8 - len(MDecifraturaBinaria) % 8) % 8  
    MDecifraturaBinaria = '0' * lunghezzaCorretta + MDecifraturaBinaria

    '''
    1A. len(M_decifrato_bin) % 8 → calcola quanti bit in più rispetto a un multiplo di 8 ci sono.

    1B. 8 - (...) → calcola quanti zeri servono per arrivare al multiplo di 8.

    1C. % 8 → serve per evitare di aggiungere 8 zeri se è già multiplo di 8.

    2A. '0' * lunghezza_padding + M_decifrato_bin → aggiunge gli zeri a sinistra per completare il byte.
    '''
    

   #Infine vado a ricostruire il messaggio in maniera tale che risulti idoneo come al MESSAGGIO ORIGINALE
    stringaDecifrata = ''
    indice = 0

    while indice < len(MDecifraturaBinaria):

        byte = MDecifraturaBinaria[indice:indice+8]
        valoreAscii = int(byte,2)
        carattere = chr(valoreAscii)
        stringaDecifrata += carattere
        indice += 8



print("\nMessaggio ORIGINALE:",stringaEsempio)
print("\n\nMessaggio CIFRATO:\n",C)
print("\nMessaggio DECIFRATO:",stringaDecifrata)

    