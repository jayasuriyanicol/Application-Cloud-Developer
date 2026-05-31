'''
Write a function that takes an integer as input, and returns the number of bits that are equal
to one in the binary representation of that number. You can guarantee that input is non-negative.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 
in this case.

'''

def count_bits(n):
    

    conteggioBit:int = 0

    if n < 0:

        print("ATTENZIONE ! il numero deve essere positivo !")
    elif n == 0:

        return 0
    else:

        numeroAnalisi = n 

        numeroParteBinaria = bin(numeroAnalisi)

        #In questa maniera procediamo alla conversione solo della parte binaria interessata 
        numeroBinario = numeroParteBinaria[2:] 

        for elemento in numeroBinario:

            if elemento == '1':

                conteggioBit += 1
    return conteggioBit
    
    
'''Procediamo con il verificare le funzionalità corrette del programma, testando gli OUTPUT'''

print(count_bits(0))
print(count_bits(1234))
print(count_bits(5678))
