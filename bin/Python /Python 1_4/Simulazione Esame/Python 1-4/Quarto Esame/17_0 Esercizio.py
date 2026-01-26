'''
Scrivere in Python dei cicli che stampino le seguenti sequenze di valori:
a) 1, 2, 3, 4, 5, 6, 7
b) 3, 8, 13, 18, 23
c) 20, 14, 8, 2, -4, -10
d) 19, 27, 35, 43, 51

For example:
Test 	Result

print_seq()

	

Sequenza a):
1
2
3
4
5
6
7

Sequenza b):
3
8
13
18
23

Sequenza c):
20
14
8
2
-4
-10

Sequenza d):
19
27
35
43
51



'''


def print_seq(): 
    
    print("Sequenza a):")
    for elm in range (1,8):

     print(elm)

    print("Sequenza b):")
    for elm in range (3,24,5):
        print(elm)

    print("Sequenza c):")
    for elm in range (20,-11,-6):
        print(elm)

    print("Sequenza d):")
    for elm in range (19,52,8):
        print(elm)
    
    return


print(print_seq())