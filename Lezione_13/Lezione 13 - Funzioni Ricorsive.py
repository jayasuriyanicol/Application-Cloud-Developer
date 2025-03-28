
''' | FUNZIONI RICORSIVE |

Una funzione ricorsiva è una funzione che richiama se stessa, a differenza del metodo ITERATIVO dove andiamo STEP-BY-STEP, ma possiamo farlo in maniera differente ovvero con la ricorsione.

Definiamo la nostra funzione e la richiamiamo passando la nostra funzione con un valore in meno, esempio:

    countdown(5) -> 5 
     countdown(4) -> 4
      countdown(3) -> 3
       countdown(2) -> 2
        countdown(1) -> 1
         countdown(0) -> 0
 
         
 Con la ricorsione, dobbiamo ricordarci di interrompere la ricorsione, sennò essa potrebbe diventare infinita. Procediamo con due step:

 1. STEP IN CUI LA RICORSIONE SI BLOCCA
 2. STEP IN CUI VI È LA RICORSIONE VERA E PROPRIA

 1. ESEMPIO:

  def recursiveCountdown(n:int) -> None:

      #numero n è negativo
      if n < 0:
        print("ERROR! Inserted number is negative!")  

      elif n == 0:
           print(0)  
    
 
  recursiveCountdown(-5) -> >> ERROR! Inserted number is negative!
  recursiveCountdown(0) -> >> 0

  2. ESEMPIO:

  def recursiveCountdown(n:int) -> None:

      #numero n è negativo
      if n < 0:
        print("ERROR! Inserted number is negative!")  
     
       #n = 0 ferma il processo ricorsivo 
      elif n == 0:
           print(0)  
      
     #Richiamo la mia funzione stessa decrementata di -1  
      else:
          print(n)
          recursiveCountdown(n-1)

  recursiveCountdown(5) -> >> 5
                              4
                              3
                              2
                              1
                              0

                            
                            
                            
                            |CASI DA NON OMETTERE |

                        
  Nel caso in cui omettiamo la condizione intermedia, in output avremmo l'errore del numero negativo.
  Quindi ci dobbiamo ricordare di mettere nei casi in cui occorre il caso intermedio, così da evitare errori.

  Lo stesso vale se omettiamo anche il caso del numero negativo, lasciando l'iterazione infinita della ricorsione.
  

  SECONDO ESEMPIO: 

  Vediamo un'altro esempio in questione, per capire bene.

   def sum(n:int) -> int:
   
      if n < 0:
      print("ERROR! Inserted number is negative!") 
      return 0

      else:
          sum:int = 0

          while n:
            sum += n
            n -= 1

          return int(sum)

    print(sum(-5)) -> >> ERROR! Inserted number is negative!
                         0
    print(sum(5)) -> >> 15


    def recursiveSum(n:int) -> int:
    
      if n < 0:
      print("ERROR! Inserted number is negative!") 
      return 0

      elif n == 0:
          return 0



          recursiveSum(5)
            recursiveSum(4)
              recursiveSum(3)
                recursiveSum(2)
                  recursiveSum(1)
                    recursiveSum(0)

                    

    recursiveSum(5) -> (5>0, 5!=0) -> 5 + recursiveSum(4)
     recursiveSum(4) -> (4>0, 4!=0) -> 4 + recursiveSum(3)
      recursiveSum(3) -> (3>0, 3!=0) -> 3 + recursiveSum(2)
       recursiveSum(2) -> (2>0, 2!=0) -> 2 + recursiveSum(1)
        recursiveSum(1) -> (1>0, 1!=0) -> 1 + recursiveSum(0)
         recursiveSum(0) -> (0=0) -> 0
           
         


    Per ottenere il risultato dobbiamo fare il contrario dal basso verso l'alto:

    0 (0+1)
     1 + rs(0) = 1 (1+1)
      2 + rs(1) = 3 (2+1)
       3 + rs(2) = 6 (3+3)
        4 + rs(3) = 10 (6+4)
         5 + rs(4) = 15 (10+5)
          rs(5) = 15 COMPLETED : 15


  TERZO ESEMPIO:

   def sumInRange(a:int, b:int) -> int:
   
    if a > b:

       temp:int = a

       a = b
       b = temp 

    sum:int = 0

    while b>=a:
        sum += b
        b -= 1

    return int(sum) 
  
    

    def recorsiveSumInRange(a:int, b:int) -> int:
   
        if a > b:

        temp:int = a

         a = b
         b = temp 

        sum:int = 0

        while b==a:
            return int(a) 
              
             
              
     
    recursiveSumInRange(5,10)
     recursiveSumInRange(5,9)
      recursiveSumInRange(5,8)
       recursiveSumInRange(5,7)
        recursiveSumInRange(5,6)
         recursiveSumInRange(5,5)









 (ARRIVATI FINO SLIDE 54 )


 
 
 
 
 '''