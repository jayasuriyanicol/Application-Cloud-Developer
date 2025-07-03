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

from abc import ABC, abstractmethod 
from string import ascii_lowercase, ascii_uppercase

class CodificatoreMessaggio(ABC):
  
 @abstractmethod
 def codifica(self,testoInChiaro:str) -> str:
   pass
 

class DecodificatoreMessaggio(ABC):

  @abstractmethod
  def decodifica(self,testoCodificato:str) -> str:
    pass
  

class CifratoreAScorrimento(CodificatoreMessaggio, DecodificatoreMessaggio):
 
  def __init__(self, chiave:int)-> None:
   
   self.chiave = chiave


  def codifica(self,testoInChiaro:str) -> str:

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
  


  def decodifica(self,testoCodificato:str) -> str:

    risultatoDecriptato: list[str]  = []

    for lettera in testoCodificato:

        if lettera in ascii_lowercase:

            decriptaMinuscole = (ascii_lowercase.index(lettera) - self.chiave ) % 26
            risultatoDecriptato.append(ascii_lowercase[decriptaMinuscole] )

        elif lettera in ascii_uppercase:
            decriptaMaiuscole = (ascii_uppercase.index(lettera) - self.chiave) % 26
            risultatoDecriptato.append(ascii_uppercase[decriptaMaiuscole] )

        else:
            risultatoDecriptato.append(lettera)


    return ''.join(risultatoDecriptato)



  def leggiFile(self, nomeFile:str) -> str:

    with open(nomeFile, 'r', encoding="utf-8") as f:
      return f.read()

  def scriviFile(self, nomeFile:str, testoScrivere:str) -> None:
    with open(nomeFile, 'w', encoding="utf-8") as f:
      f.write(testoScrivere)



class CifratoreACombinazione(CodificatoreMessaggio, DecodificatoreMessaggio):
   
  def __init__(self,n:int) -> None:
    self.n = n

  def __combinazione(self,testoInChiaro:str) -> str:
    lunghezza = len(testoInChiaro)
    lunghezzaMeta = lunghezza // 2 if lunghezza % 2 == 0 else lunghezza // 2 + 1

    testoPrimaMeta = testoInChiaro[:lunghezzaMeta]
    testoSecondaMeta = testoInChiaro[lunghezzaMeta:]

    risultato = ""

    for conteggio in range(len(testoInChiaro)):

        if conteggio % 2 == 0 and testoPrimaMeta:
            risultato += testoPrimaMeta[0]
            testoPrimaMeta = testoPrimaMeta[1:]

        elif conteggio % 2 != 0 and testoSecondaMeta:
            risultato += testoSecondaMeta[0]
            testoSecondaMeta = testoSecondaMeta[1:]

    return risultato

  def __decodifica_combinazione(self, testo:str) -> str:

      primaMeta = [''] * lunghezzaMeta
      secondaMeta = [''] * (lunghezza - lunghezzaMeta)
      indicePrima = 0
      indiceSeconda = 0



      for _ in range(self.n):
      
        lunghezza = len(testo)
        
      if lunghezza % 2 == 0:
         
        lunghezzaMeta = lunghezza // 2 
     
      else:
        lunghezzaMeta = lunghezza // 2 + 1

   
      
      for i in range(len(testo)):
          if i % 2 == 0:
              primaMeta[indicePrima] = testo[i]
              indicePrima += 1
          else:
              secondaMeta[indiceSeconda] = testo[i]
              indiceSeconda += 1

      testo = ''.join(primaMeta + secondaMeta)
      return testo



  def codifica(self, testoInChiaro: str) -> str:

    for _ in range(self.n):
      
      testoInChiaro = self.__combinazione(testoInChiaro)

    return testoInChiaro

  def decodifica(self, testoCodificato: str) -> str:

    return self.__decodifica_combinazione(testoCodificato)

  def leggiFile(self, nomeFile:str) -> str:

    with open(nomeFile , 'r', encoding="utf-8") as f:
      
      return f.read()
      
  def scriviFile(self, nomeFile:str, testoScrivere:str) -> None:

    with open(nomeFile, 'w', encoding="utf-8") as f:
      
      f.write(testoScrivere)



if __name__ == "__main__":
   
    print("\n--- TEST CIFRATORE A SCORRIMENTO ---")
    cifrario = CifratoreAScorrimento(3)
    testo = "Ciao, sono Cristiano Coccia!"
    cifrato = cifrario.codifica(testo)
    print("Testo Cifrato:", cifrato)
    decifrato = cifrario.decodifica(cifrato)
    print("Testo Decifrato:", decifrato)

    
    print("\n--- TEST CIFRATORE A COMBINAZIONE ---")
    combinatore = CifratoreACombinazione(3)
    testoComb = "abcdefghi"
    cifratoComb = combinatore.codifica(testoComb)
    print("Testo Cifrato:", cifratoComb)
    decifratoComb = combinatore.decodifica(cifratoComb)
    print("Testo Decifrato:", decifratoComb)
