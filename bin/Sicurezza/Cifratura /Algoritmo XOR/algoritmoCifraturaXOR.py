'''
ALGORITMO DI CIFRATURA XOR 

Implementare in maniera semplice un'algoritmo di CIFRATURA XOR, nella quale data una frase
ed una chiave XOR INTERA, mostro in output:

        1. LA FRASE IN CIFRATURA XOR
        2. LA FRESE DECIFRATA IN XOR

Di seguito un'esempio di inserimento e di output atteso:

Testo = "Nel mezzo del cammin di nostra vita", 57

                OPPURE
tuple => ('Nel mezzo del cammin di nostra vita', 57)

ord("N") => 78

ord ("N") ^ 57 => 119

ord (119 ^ 57 ) => 'N'

ord (" ") => 32

'''

fraseInput = input("Benvenuto, inserisci la frase: ")
cifraturaXOR = int(input("Inserisci la chiave XOR: "))


fraseCifrata = ""
for c in fraseInput:
    fraseCifrata += chr(ord(c) ^ cifraturaXOR)

print("\nFrase cifrata:", fraseCifrata)

fraseDecifrata = ""
for c in fraseCifrata:
    fraseDecifrata += chr(ord(c) ^ cifraturaXOR)

print("Frase decifrata:", fraseDecifrata)

