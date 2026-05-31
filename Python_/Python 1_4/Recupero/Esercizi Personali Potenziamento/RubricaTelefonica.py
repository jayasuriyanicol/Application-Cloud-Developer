
contattoLista:dict[str,str] = {}
while True:


        
        try:
            numero:int = int(input("\n1. Aggiungi contatto\n2. Cerca contatto \n3. Mostra Rubrica\n4. Esci\n"))
        except ValueError:
           
           print("ATTENZIONE ! Inserire un numero valido INTERO DA 1 A 4 !")
        match numero:

            case 1:
               try:
                contattoNome:str = str(input("Benvenuto, inserisci il nome e cognome del contatto: "))
                contattoNumero:str = str(input("Numero Telefono: "))
                contattoLista[contattoNome] = contattoNumero
                
               except ValueError:
                  
                  print("ATTENZIONE ! il nome,cognome e numero telefono devono essere UNA STRINGA !")
            
            case 2:
                
                try: 
                   if not contattoLista:
                      
                      print("ATTENZIONE ! Nessun contatto presente in RUBRICA !")

                      continue
                   
                   contattoRicerca:str = str(input("Inserisci il nome del contatto: "))
                   
                   valoreRicerca:str = contattoLista.get(contattoRicerca)

                  
                      
                   if valoreRicerca is not None:
                      
                      print(f"SUCCESSO ! Valore ottenuto per ' {contattoRicerca} ' è -> {valoreRicerca}")
                   else:
                      print("ATTENZIONE ! Valore errato o non esistente")
                   
                except ValueError:
                   
                   print("ATTENZIONE ! Valore di RICERCA ERRATO !")
                   

            case 3:
                
                print (contattoLista)
                
           
            
            case 4:
              
              print("SUCCESSO ! Sei fuori dalla rubrica ")
              break
            
            case _:
              
              print (" ERRORE ! Inserire un numero valido da 1 a 4 INTERO !")
           




               

                      

            
  

                