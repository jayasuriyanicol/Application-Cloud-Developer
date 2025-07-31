'''

Testo = "Nel mezzo del cammin di nostra vita", 57

tuple => ('Nel mezzo del cammin di nostra vita', 57)
ord("N") => 78

ord ("N") ^ 57 => 119

ord (119 ^ 57 ) => 'N'

ord (" ") => 32

'''


fraseInput:str = input("Benvenuto, inserisci la frase: ")

cifraturaXOR:int = input("Prego adessso, inserie la cifratura in XOR: ")



for elementoTesto in fraseInput:

        fraseFinale:str = " "

        cifratura= ord(elementoTesto) 

        cifraturaElemento:int = cifratura * 57

        testoCifrato:str = ord(cifraturaElemento)

        fraseFinale += cifraturaElemento
        
print(fraseFinale)

    




