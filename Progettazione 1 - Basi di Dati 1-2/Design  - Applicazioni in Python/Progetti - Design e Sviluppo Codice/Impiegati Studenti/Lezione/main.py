'''
s1 = Studente("Cristiano")
m1 = Modulo("Analisi")



s1 = Studente("Mario")
m1 = Modulo("Fisica")

esame.add_link(s1,m1,28)


1 #...

l  = s1.esame(m1)

esame.del_link(l)

if l.voto > 18:

    pass

    #... -> ERRORE, ogggetto non esistente 

'''

