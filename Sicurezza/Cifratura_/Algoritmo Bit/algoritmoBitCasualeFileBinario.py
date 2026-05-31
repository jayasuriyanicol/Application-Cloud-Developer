'''
ALGORITMO DI MODIFICA DI UN BIT CASUALE IN UN FILE BINARIO

Implementare in maniera semplice un programma che, dato un FILE BINARIO, proceda a:

        1. SCEGLIERE CASUALMENTE UN BYTE ALL'INTERNO DEL FILE
        2. SCEGLIERE CASUALMENTE UN BIT ALL'INTERNO DI QUEL BYTE
        3. INVERTIRE (XOR) IL BIT SCELTO
        4. RISCRIVERE IL FILE CON IL BIT MODIFICATO
        5. MOSTRARE IN OUTPUT LA POSIZIONE DEL BYTE E IL BIT MODIFICATO

Di seguito un esempio di inserimento e di output atteso:

File = "esempio.dat"

Byte scelto in posizione 12 => 0b01010101

Bit scelto = 3

Byte dopo modifica => 0b01011101

Output console:

"Modified byte at position 12, bit 3 in file esempio.dat."

'''

import sys
from random import randint

if len(sys.argv) < 2:
    
    print("Usage: python randombit.py <file name>")
    sys.exit(1)

nomeFile = sys.argv[1]

#Procedo e leggo il file in modalità binaria, utilizzando bytearray per poter modificare singoli byte
with open(nomeFile, 'rb') as f:
    data = bytearray(f.read()) 

#Come primo passo scelgo un BYTE casuale
pos = randint(0, len(data) - 1)
byte = data[pos]

#Secondo passo scelgo un BUT tra (0-7), quindi 8bit - 1
bit = randint(0, 7)

#Terzo passo, modifico il BIT scelto come XOR
byte ^= (1 << bit)

#Quarto aggiorno il BYTE nel bytearray
data[pos] = byte

#Infine, per concludere riscrivo nuovamente il FILE.
with open(nomeFile, 'wb') as f:
    f.write(data)

print(f"Modified byte at position {pos}, bit {bit} in file {nomeFile}.")

