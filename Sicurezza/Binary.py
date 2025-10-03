n = 3512

with open("numero1.dat" ,"wb") as f:
    f.write(n.to_bytes(4, byteorder="little"))

with open("numero2.dat","wb") as f:
    f.write(n.to_bytes(4, byteorder="big"))

#Per eseguire utilizzare la forma 'xxd nomefile.estensione' -> esempio 'xxd numero2.dat'

s = 'Ciao'
with open("numero3.dat","wb") as f:
    f.write(s)




def stringToNumber(string:str) -> int:

    tot = 0
    esp = 0

    for c in string:

        tot = tot + 256**esp*ord(c)
        esp = esp + 1
    return tot



print(stringToNumber("Stringa"))


def numberToString(numb):
    pass

def stringToShift(string:str)-> str:

#Attraverso lo shift verso destra '>>' andrò ogni volta a dividere per due
#Mentre nel caso in cui effettuiamo uno shift verso sinistra '<<' andrò a moltlipicare per due



    tot = 0

    for char in s:
        tot = (tot<<8) | ord (char)
    return tot





n = 8138098139849139319491387
p = 18408013480

a = 123224324384
b = 1394194917919189



print(pow(pow(p,a,n),b,n))
print(pow(pow(p,b,n),a,n))