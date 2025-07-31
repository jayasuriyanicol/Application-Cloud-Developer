import sys
import math
from random import *


if len(sys.argv)<2:

    print("Usage: python randombit.py <file name>")
    sys.exit(1)


nomeFile = sys.argv[1]
data = None
with open(nomeFile ,'rb') as f:
    data = f.read() 

   #Devo modificare solo un BIT. 1 | quindi procedo con il scegliere il Byte da modificare

    pos = math.random.randint (0,len(data) -1)
    byte = data[pos]

  # 2 | Scelgo il Bit da modificare

    bit = math.random.randint(0,7)  

 # 3 | Supponiamo di aver scelto il Bit 3, come faccio a modificare il Bit 2 di Byte? Attraverso uno XOR !
    byte ^= (1 <<bit)

 # 4 | Ricostruisco il Byte modificato

    data =  data[pos] + bytes([byte]) + data[pos +1:]  

with open(nomeFile, 'wb') as f:
     f.write(data)

print(f"Modified byte at position {pos}, bit {bit} in file {nomeFile}.")

sys.exit(0)
