'''
ALGORITMO DI SCAMBIO DI CHIAVE DIFFIE-HELLMAN

Implementare in maniera semplice un programma che simuli lo SCAMBIO DI CHIAVE Diffie-Hellman, nel quale:

        1. VENGONO SCELTI DUE PARAMETRI PUBBLICI: un NUMERO PRIMO p e un GENERATORE g
        2. ALICE E BOB SCELGONO SEGRETI CASUALI a e b
        3. CALCOLANO LE LORO CHIAVI PUBBLICHE A = g^a mod p e B = g^b mod p
        4. SCAMBIANO LE CHIAVI PUBBLICHE
        5. CALCOLANO LA CHIAVE SEGRETA CONDIVISA: K = B^a mod p = A^b mod p
        6. VERIFICANO CHE LE DUE CHIAVI CONDIVISE SIANO UGUALI

Se l'agoritmo funziona correttamente dovrà dare esito Positivo, mai negativo dato che -> gli esponenti e moltiplicazione modulo p sono commutativi.
In caso negativo, c'è qualcosa che non va con il calcolo degli esponenti e la moltlipicazionende del modulo p e NON saranno commutativi.

'''


import random


numeroPrimo:int = 23
baseGeneratrice = 5


print(f"\nParametri Pubblici:\n1.numeroPrimo: {numeroPrimo}\n2.baseGeneratrice: {baseGeneratrice}")



chiaveSegretaAlice:int = random.randint(1,numeroPrimo-2)
chiaveSegretaBob:int = random.randint(1,numeroPrimo-2)


print(f"\nParametri Segreti:\n1.Chiave SEGRETA Alice: {chiaveSegretaAlice}\n2. Chiave SEGRETA Bob: {chiaveSegretaBob}")



chiavePubblicaAlice = pow(baseGeneratrice,chiaveSegretaAlice,numeroPrimo)
chiavePubblicaBob = pow(baseGeneratrice, chiaveSegretaBob, numeroPrimo)




print(f"\nChiavi PUBBLICHE:\n1.Chiave PUBBLICA Alice: {chiavePubblicaAlice}\n2. Chiave PUBBLICA Bob :{chiavePubblicaBob}")



print(f"\nSCAMBIO CHIAVI PUBBLICHE: Alice invia la propria CHIAVE PUBBLICA -> ({chiavePubblicaAlice}) a Bob\nBob invia la propria CHIAVE PUBBLICA -> ({chiavePubblicaBob}) ad Alice")


calcoloChiaveSegretaAnna = pow(chiavePubblicaBob,chiaveSegretaAlice,numeroPrimo)
calcoloChiaveSegretaBob = pow(chiavePubblicaAlice,chiaveSegretaBob,numeroPrimo)


print(f"\nCalcolo delle CHIAVI PRIVATE:\n1.Chiave PRIVATA Calcolata di Alice: {calcoloChiaveSegretaAnna}\n2. Chiave PRIVATA calcolata di Bob: {calcoloChiaveSegretaBob}")


if calcoloChiaveSegretaAnna == calcoloChiaveSegretaBob:

    print("\nSUCCESSO ! La chiave è stata condivisa CORRETTAMENTE")
else:

    print("\nATTENZIONE ! Errore le chiavi condivise non COINCIDONO !")