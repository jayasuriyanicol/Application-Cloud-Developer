'''
3-4. Guest List: If you could invite anyone, living or deceased, to dinner, who would you invite? 
Make a list that includes at least three people you’d like to invite to dinner. 
Then use your list to print a message to each person, inviting them to dinner.

'''

invited=["Cristiano Ronaldo", "Will Smith", "Michael Jackson"] 

#Metodo basilare, più semplice e inutivo, ma allo stesso tempo meccanico

message=print(f"Welcome {invited[0] }, you are invited to my dinner !")
message=print(f"Welcome {invited[1] }, you are invited to my dinner !")
message=print(f"Welcome {invited[2] }, you are invited to my dinner !\n")


#Metodo più rapido con l'utilizzo del ciclo FOR
for name in invited:
     message=print(f"Welcome {name}, you are invited to my dinner !")