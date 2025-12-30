'''
Funzioni, For, While, If, Elif ed Else
3) Scrivere in Python dei cicli che stampino le seguenti sequenze di valori:
a) 2, 4, 6, 8, 10, 12, 14
b) 1, 4, 7, 10, 13
c) 30, 25, 20, 15, 10, 5, 0
d) 5, 15, 25, 35, 45
'''



numero = 2
print("\na)")
for i in range(7):
    print(numero, end=",")
    numero += 2


numero= 1
print("\nb)")
for i in range(5):
    print(numero, end=",")
    numero += 3

numero=30
print("\nc)")
for i in range(7):
    print(numero, end=",")
    numero -= 5

numero=5

print("\nd)")
for i in range(5):
    print(numero, end=",")
    numero += 10
    