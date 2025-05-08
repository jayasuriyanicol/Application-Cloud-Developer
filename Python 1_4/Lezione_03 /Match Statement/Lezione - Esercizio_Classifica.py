#Esercizio Classifica - Posizionamento

# Tipologia UNIVOCA - USUALE

posizione=int(input("Benvenuto, inserisci la posizione in cui sei arrivato: "))

if posizione == 1:
    print("Sei arrivato 1st !")
elif posizione == 2:
    print("Sei arrivato 2nd !")
elif posizione == 3:
    print("Sei arrivato 3rd ! ")
else:
    print(f"Sei arrivato {posizione}th !")

#Altra tipologia con l'utilizzo del TEST CASE 

match posizione:
    case 1:
     print("Sei arrivato 1st !")
    case 2:
     print("Sei arrivato 2nd !")
    case 3:
     print("Sei arrivato 3rd !")

#Caso di default indicato come "case_n", per quanto riguarda l'operatore OR utilizziamo la "|" BARRETTA
    case _:
     print(f"Sei arrivato {posizione}th !")


#In questo caso mostriamo che è possibile anche inserire delle condizioni nel TEST CASE

match posizione:
   case posizione if posizione>0 and posizione%2==0:
      print(f"{posizione} è positiva !")
   case posizione if posizione<0 and posizione%2!=0:
      print(f"Attenzione il numero è dispari !")

#Caso dell' inserimento delle variabili string e int nel TEST CASE

''' 
  g: str = "f"
  age: int = 5
 # Match statement 
  match (g,age):
    case ("f",5):
    print ("piccola")
    case ("f",10):
    print ("Grande!")
    case_:
    print("Kinder Sorpresa !")
'''
#Caso dell'inserimento di una lista nel TEST CASE

'''
#Define a list
 ingredients =["pomodoro", "mozzarella, "basilico"]

 match ingredients:
  case ["pomodoro", "mozzarella", "basilico"]:
   print("Puoi fare una Caprese !")
  case ["pasta", "pomodoro", *_]:
     print("Puoi fare una pasta al pomodoro !")
  case ["pane", "prosciutto", "formaggio" ]:
      print ("Puoi fare un Panino !")
  case _:
    print("Non saprei cosa consigliarti, INGREDIENTI INSUFFICENTI!")

'''

#Caso dell'inserimento di un dizionario nel TEST CASE

'''
#Define a dictionary
 user =["nome": "Luca, "ruolo": "Admin" ]

 match user:
  case ["nome": name , "ruolo": "Admin" ]:
   print(f"Benvenuto, amministratore {name}")
  case ["nome": name , "ruolo": "utente"]:
     print("f"Benvenuto utente {name}")
  case _:
    print("ATTENZIONE ! Ruolo non riconosciuto")
'''


      
