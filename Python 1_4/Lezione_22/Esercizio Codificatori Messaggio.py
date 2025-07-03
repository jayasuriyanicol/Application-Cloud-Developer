'''

# Codificatori Messaggio
Si crei una classe astratta chiamata CodificatoreMessaggio che ha un solo metodo astratto codifica(testoInChiaro), dove testoInChiaro sarà il messaggio da codificare. Il metodo restituirà il messaggio codificato.

Si crei una classe astratta chiamata DecodificatoreMessaggio che abbia un solo metodo decodifica(testoCodificato), dove testoCodificato sarà il messaggio da decodificare. Il metodo ritornerà il messaggio decodificato.

Si crei una classe CifratoreAScorrimento che implementa le classi astratte CodificatoreMessaggio e DecodificatoreMessaggio. Il costruttore dovrebbe ricevere un numero intero chiamato chiave. Si definisca il metodo codifica(testoInChiaro) così che ogni lettera del testo sia spostata dal valore contenuto in chiave.
Per esempio, se chiave è uguale a 3, la lettera 'a' sarà sostituita da 'd', la lettera 'b' sarà sostituita da 'e', la lettera 'c' sarà sostituita da 'f' e così via.

     Suggerimento: si potrebbe definire un metodo privato sposta_carattere(c) che restituisca la codifica di un singolo carattere c da concatenare agli altri per costruire il messaggio codificato nel metodo codifica(testoInChiaro).


Si crei una classe CifratoreACombinazione che implementa le classi astratte CodificatoreMessaggio e DecodificatoreMessaggio. Il costruttore dovrebbe ricevere un numero intero chiamato n. Si definisca il metodo codifica(testoInChiaro) così che il messaggio sia combinato n volte. Per eseguire una singola combinazione, si divide il messaggio a metà e poi si prendono i caratteri da ognuna delle metà in modo alternato. Per esempio, se il messaggio è 'abcdefghi', le metà sono 'abcde' e 'fghi' (nel caso in cui la lunghezza del testo da decifrare sia un numero dispari, la prima metà deve essere più lunga della seconda metà). Il messaggio combinato è 'afbgchdie'.

    Suggerimento: si potrebbe definire un metodo privato combinazione(testo) che esegue la combinazione del testo e ritorni il testo cifrato da usare nel metodo codifica(testoInChiaro).


Si scriva il metodo decodifica(testoCodificato) per ognuna delle classi CifrarioAScorrimento e CifrarioACombinazione.

    Suggerimento: definire il metodo privato decodifica_carattere() per la classe CifrarioAScorrimento che compie un'azione inversa al metodo sposta_carattere().

    Suggerimento: definire il metodo privato decodifica_combinazione() per la classe CifrarioACombinazione che compie un'azione inversa al metodo combinazione().


Infine, si implementi anche un metodo per leggere il testo da cifrare da un file e un metodo per scrivere il testo cifrato su un file per entrambe le classi CifratoreAScorrimento e CifratoreACombinazione.

### Test tramite codice driver:
Test del Cifratore a Scorrimento:
- Inizializzazione: Viene creato un oggetto CifratoreAScorrimento con una chiave di scorrimento di 3.
- Lettura del testo: Il testo in chiaro viene letto da un file.
- Codifica: Il testo in chiaro viene codificato utilizzando il cifratore a scorrimento.
- Scrittura del testo codificato: Il testo codificato viene scritto su un file.
- Stampa del testo codificato: Il testo codificato viene stampato.
- Decodifica: Il testo codificato viene decodificato.
- Stampa del testo decodificato: Il testo decodificato viene stampato.

Test del Cifratore a Combinazione:
- Inizializzazione: Viene creato un oggetto CifratoreACombinazione con 3 combinazioni.
- Lettura del testo: Il testo in chiaro viene letto da un file.
- Codifica: Il esto in chiaro viene codificato utilizzando il cifratore a combinazione.
- Scrittura del testo codificato: Il testo codificato viene scritto su un file.
- Stampa del testo codificato: Il testo codificato viene stampato.
- Decodifica: Il testo codificato viene decodificato.
- Stampa del testo decodificato: Il testo decodificato viene stampato.

'''

from abc import ABC,abstractmethod 
from string import ascii_lowercase, ascii_uppercase


class CodificatoreMessaggio:
  
 @abstractmethod
 def codifica(testoInChiaro:str) -> str:
   pass
 

class DecodificatoreMessaggio:

  @abstractmethod
  def decodifica(testoCodificato:str) -> str:

    pass
  

class CifratoreAScorrimento(CodificatoreMessaggio, DecodificatoreMessaggio):
 
  def __init__(self, chiave:int)-> None:
   
   self.chiave = chiave


def codifica(self,testoInChiaro:str,chiave:str) -> str:

    risultatoCriptato: list[str] = []


    for lettera in testoInChiaro:


        if lettera in ascii_lowercase:

            indiceMinuscole = (ascii_lowercase.index(lettera) + self.chiave) % 26
            risultatoCriptato.append(ascii_lowercase[indiceMinuscole])
        

        elif lettera in ascii_uppercase:


            indiceMaiuscole = (ascii_uppercase.index(lettera) + self.chiave) % 26
            risultatoCriptato.append(ascii_uppercase[indiceMaiuscole])
        
        else:

            risultatoCriptato.append(lettera)
    
    return ''.join(risultatoCriptato)


def decodifica(self,testoCodificato:str,chiave:str) -> str:

    risultatoDecriptato: list[str]  = []


    for lettera in self.testoDecodificato:


        if lettera in ascii_lowercase:

            decriptaMinuscole = (ascii_lowercase.index(lettera) - self.chiave ) % 26
            risultatoDecriptato.append(ascii_lowercase[decriptaMinuscole] )
        
        elif lettera in ascii_uppercase:

            decriptaMaiuscole = (ascii_uppercase.index(lettera) - self.chiave) % 26
            risultatoDecriptato.append(ascii_uppercase[decriptaMaiuscole] )

        else:

            risultatoDecriptato.append(lettera)

    return ''.join(risultatoDecriptato)





'''DRIVER PROGRAMM - Per verificare le funzionalità del programma 

messaggioCriptareDecriptare = "Ciao, sono Cristiano Coccia !"
chiave = 2

messaggioCriptato = caesar_cypher_encrypt(messaggioCriptareDecriptare, chiave)
print("MESSAGGIO CRIPTATO: ", messaggioCriptato)  

messaggioDecriptato = caesar_cypher_decrypt(messaggioCriptato, chiave)
print("MESSAGGIO DECRIPTATO: ", messaggioDecriptato)  

   
'''
 

class CifratoreACombinazione(CodificatoreMessaggio,DecodificatoreMessaggio):
   
   def __init__(self,n:int) ->  None:
       
       self.n =  n

   def codifica(self,testoInChiaro:str) -> str:
       super().codifica()

       MessaggioFinaleCombinato:str 

       lunghezzaMessaggioMeta:int = len(testoInChiaro) // 2


       if lunghezzaMessaggioMeta % 2 == 0 :
        
          
          for elementoPrimaParte in range(0,lunghezzaMessaggioMeta) in testoInChiaro:
             
             messaggioPrimaMeta:str
             
             messaggioPrimaMeta += elementoPrimaParte

          for elementoSecondaParte in range(lunghezzaMessaggioMeta, testoInChiaro[:]  ):
          
             messaggioSecondaMeta:str

             messaggioSecondaMeta += elementoSecondaParte

          for primoElemento in messaggioPrimaMeta:
               
            for secondoElemento in messaggioSecondaMeta:
                  
                MessaggioFinaleCombinato += primoElemento,secondoElemento
        
       else:
          
          lunghezzaMessaggioMeta:int = len(testoInChiaro) // 2

          
        
          for elementoPrimaParte in range(0,lunghezzaMessaggioMeta+1) in testoInChiaro:
             
             messaggioPrimaMeta:str
             
             messaggioPrimaMeta += elementoPrimaParte

             for elementoSecondaParte in range(lunghezzaMessaggioMeta+1, testoInChiaro[:]  ):
          
                messaggioSecondaMeta:str

                messaggioSecondaMeta += elementoSecondaParte

                for primoElemento in messaggioPrimaMeta:
               
                    for secondoElemento in messaggioSecondaMeta:
                    
                         MessaggioFinaleCombinato += primoElemento,secondoElemento


           
       
                  
   def decodifica(self,testoCodificato:str) -> str:

        super().decodifica()

        testoDecodificato:str 
        self.MessaggioFinaleCombinato = testoCodificato

        if len(testoCodificato) % 2 == 0 :
           
           for elementoPrimaParte in range (0,len(testoCodificato),1):

               

             for elementoSecondaParte in range (1,len(testoCodificato),1):
                 
                primaParte += elementoPrimaParte
                secondaParte += elementoSecondaParte
          
         
             
           testoDecodificato = primaParte + secondaParte
                
           return testoCodificato
        
        else:
           
            for elementoPrimaParte in range (0,len(testoCodificato),1):

               

             for elementoSecondaParte in range (1,len(testoCodificato),1):
                 
                primaParte += elementoPrimaParte
                secondaParte += elementoSecondaParte
          
         
             
            testoDecodificato = primaParte + secondaParte
                
            return testoDecodificato
           



    

             
               


       

    

       
     