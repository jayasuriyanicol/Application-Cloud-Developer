'''
FILE: Andiamo a vedere il funzionamento dei FILE in Python.
'''
'''PATH : str = "'Lezione_15/example.txt"

file = open(PATH,"r", encoding="utf-8")
output : str = file.read()
print(output)
file.close()'''


'''
file = open("Lezione_15/example.txt","a")
try:
    pass
except Exception as e:
    pass

finally:
    file.close()
#home/its/Lezione_15/example.py
'''

#CONTEXT MANAGER -> open (...)
with open("Lezione_15/example.txt","w") as file:
    print(file.read())

