from formagenerica import FormaGenerica

class Rettangolo(FormaGenerica):

   #Inizializziamo un oggetto della classe Rettangolo
   def __init__(self):
      super().__init__() 

      self.setShape('rettangolo')

   def draw(self) -> None:

      print(f"\n{self.getShape()}\n") 

     #Outer for
      for i in range(5):
        
         #Inner for
         for j in range(5*2):
         
           #Il lato A e il lato D del rettangolo
           if i == 0  or  i==5-1:
             #La clausola 'end= " " ' ci permette di evitare l'andare a capo dell'asterisco, quindi uno spazio bianco
              print("*", end=" ")
           #Il lato B e il lato C del rettangolo  
           elif j==0 or j== 5*2-1:
              
              print("*", end= " ")
          #Spazi bianchi
           else:
            print(" ", end= " ")
         
         print("\n", end= "")