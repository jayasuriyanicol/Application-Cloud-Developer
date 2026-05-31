'''
Funzioni, For, While, If, Elif ed Else
1) Scrivi una funzione che verifica se una combinazione di condizioni (X, Y, e Z) è
soddisfatta per procedere con un'azione. L'azione può procedere solo se la condizione X
è vera e almeno una tra Y e Z è vera. La funzione deve ritornare "Azione permessa"
oppure "Azione negata" a seconda delle condizioni che sono soddisfatte.
'''

def X():
    #Supponiamo che X sia vera
    return True

def Y():
    #Supponiamo che Y sia falsa
    return False

def Z():
    #Supponiamo che Z sia vera
    return True

def verifica_condizioni():
    if X() and (Y() or Z()):
        return "Azione permessa"
    else:
        return "Azione negata"

#Eseguiamo la funzione, per vedere se la funzione sia corretta o meno
print(verifica_condizioni())


