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
#Andiamo a richiamare e importare per la risoluzione dell'esercizio
from abc import ABC, abstractmethod 
from string import ascii_lowercase, ascii_uppercase


'''In questo caso le prime due classi ASTRATTE saranno "passate", dato che verranno richiamati i loro metodi'''

class CodificatoreMessaggio(ABC):
  
  @abstractmethod
  def codifica(self,testoInChiaro:str) -> str:
    pass
 

class DecodificatoreMessaggio(ABC):

  @abstractmethod
  def decodifica(self,testoCodificato:str) -> str:
    pass
  

#Partiamo con il metodo di cifratura che è quello del CIFRARIO DI CESARE ed andiamo a richiamare le due classi ASTRATTE
class CifratoreAScorrimento(CodificatoreMessaggio, DecodificatoreMessaggio):
  
  '''
     Data la chiave in INPUT procediamo con la stesura del codice passando e definendo la chiave che servirà per la cifratura e decifratura
     nel metodo COSTRUTTORE.
  '''
 
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


  #Come richiesto anche dall'esercizio andiamo a svolgere la lettura e scrittura in un file di testo (txt) per entrambi i cifratori.
  def leggiFile(self, nomeFile:str) -> str:

    with open(nomeFile, 'r', encoding="utf-8") as f:
      return f.read()

  def scriviFile(self, nomeFile:str, testoScrivere:str) -> None:
    with open(nomeFile, 'w', encoding="utf-8") as f:
      f.write(testoScrivere)


#Definiamo il CIFRATORE A COMBINAZIONE che è ben diverso dal CIFRARIO DI CESARE infatti, quest'ultimo va combinare uno ad uno gli elementi presenti nel testoInChiaro per n volte, quanto lungo il testo da codificare e decodificare.
class CifratoreACombinazione(CodificatoreMessaggio, DecodificatoreMessaggio):
   

  '''Andiamo a definire un attributo n che ci servirà per iterare tutto lungo il testoInChiaro. Dividiamo in COMBINAZIONE E DECODIFICA COMBINAZIONE'''
  def __init__(self,n:int) -> None:
    self.n = n

  '''Infine andiamo a richiamare le classi ASTRATTE ad inizio del codice '''
  def codifica(self, testoInChiaro: str) -> str:

    for _ in range(self.n):
      testoInChiaro = self.__combinazione(testoInChiaro)

    return testoInChiaro

  def decodifica(self, testoCodificato: str) -> str:

    for _ in range(self.n):

      lunghezza:int = len(testoCodificato)

      if lunghezza % 2 == 0:
        lunghezzaMeta:int = lunghezza // 2
      else:
        lunghezzaMeta:int = lunghezza // 2 + 1

      #Inizializziamo le due metà da ricostruire
      primaMeta:list[str] = [''] * lunghezzaMeta
      secondaMeta:list[str] = [''] * (lunghezza - lunghezzaMeta)

      indicePrima:int = 0
      indiceSeconda:int = 0

      #Ricostruiamo primaMeta e secondaMeta in base all'alternanza
      for i in range(len(testoCodificato)):
        if i % 2 == 0:
          primaMeta[indicePrima] = testoCodificato[i]
          indicePrima += 1
        else:
          secondaMeta[indiceSeconda] = testoCodificato[i]
          indiceSeconda += 1

      #Ricostruiamo il messaggio originale unendo le due metà
      testoCodificato = ''.join(primaMeta + secondaMeta)

    return testoCodificato
  
  
  #Nella combinazione andiamo a verificare se la len del testoInChiaro sia PARI o DISPARI al fine di cifrare bene il messaggio in situazioni di disparità che non siano pari 
  def __combinazione(self,testoInChiaro:str) -> str:
    lunghezza = len(testoInChiaro)

    if lunghezza % 2 == 0 :
      lunghezzaMeta = lunghezza // 2 
    
    #Infatti per i numeri DISPARI andiamo ad aggiungere un +1 per ottenere nella PRIMA PARTE del testoInChiaro una lettera|numero|ecc. in più rispetto alla SECONDA PARTE 
    else:
      lunghezzaMeta = lunghezza // 2 + 1
       
    '''Quindi dividiamo il testo in due parti come anticipato precedentemente'''
    testoPrimaMeta = testoInChiaro[:lunghezzaMeta]
    testoSecondaMeta = testoInChiaro[lunghezzaMeta:]

    risultatoMessaggioCombinato = ""

    for conteggio in range(len(testoInChiaro)):

      if conteggio % 2 == 0 and testoPrimaMeta:
        risultatoMessaggioCombinato += testoPrimaMeta[0]
        testoPrimaMeta = testoPrimaMeta[1:]

      elif conteggio % 2 != 0 and testoSecondaMeta:
        risultatoMessaggioCombinato += testoSecondaMeta[0]
        testoSecondaMeta = testoSecondaMeta[1:]

    return risultatoMessaggioCombinato


  #Come richiesto anche dall'esercizio andiamo a svolgere la lettura e scrittura in un file di testo (txt) per entrambi i cifratori.
  def leggiFile(self, nomeFile:str) -> str:

    with open(nomeFile , 'r', encoding="utf-8") as f:
      return f.read()
      
  def scriviFile(self, nomeFile:str, testoScrivere:str) -> None:

    with open(nomeFile, 'w', encoding="utf-8") as f:
      f.write(testoScrivere)





'''DRIVER PROGRAM - Per testare le funzionalità dell'esercizio'''


if __name__ == "__main__":
   
  print("\n--- TEST CIFRATORE A SCORRIMENTO ---\n")
  cifrario = CifratoreAScorrimento(3)
  testo = "Ciao, sono Cristiano Coccia!"
  cifrato = cifrario.codifica(testo)
  print("Testo Cifrato:", cifrato)
  decifrato = cifrario.decodifica(cifrato)
  print("Testo Decifrato:", decifrato)

    
  print("\n--- TEST CIFRATORE A COMBINAZIONE ---\n")
  combinatore =  CifratoreACombinazione(3)
  testo2 = "abcdefghi"
  cifrato2 = combinatore.codifica(testo2)
  print("Testo Cifrato:", cifrato2)
  decifrato2 = combinatore.decodifica(cifrato2)
  print("Testo Decifrato:", decifrato2)
