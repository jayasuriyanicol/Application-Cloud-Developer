'''
# Testi Digitali

Si definisca una classe Documento che contenga una variabile di tipo stringa chiamata testo e che memorizza qualsiasi contenuto testuale per il documento.
Si crei un metodo getText() che restituisca il testo. Si crei un metodo setText() per impostare il testo. Scrivere un metodo isInText() che restituisce True se un documento contiene la parola chiave specificata.

Si definisca poi una classe Email che sia derivata da Documento e che includa le variabili per il mittente, il destinatario e il titolo del messaggio.
Si implementino i metodi get() e set() appropriati per tali variabili. Il corpo del messaggio dell’e-mail dovrebbe essere memorizzato nella variabile ereditata testo.
Si ridefinisca il metodo getText() per concatenare e ritornare tutti i campi di testo (mittente, destinatario, titolo del messaggio, e messaggio) come di seguito:
 
Da: alice@example.com, A: bob@example.com
Titolo: Incontro
Messaggio: Ciao Bob, possiamo incontrarci domani?
 
Inoltre, si implementi un metodo writeToFile() per scrivere il risultato del metodo getText() in un file di testo e in un percorso specificato.
 
Analogamente, si definisca una classe File che sia derivata da Documento e includa una variabile per il nomePercorso.
Crea un file document.txt con all'interno la stringa "Questo e' il contenuto del file." e salvalo in una directory a tua scelta e che sarà indicata in nomePercorso.
I contenuti testuali del file dovrebbero essere letti da questo file di testo al percorso specificato in nomePercorso e memorizzati nella variabile ereditata testo tramite un metodo leggiTestoDaFile().
Si ridefinisca il metodo getText() che concateni e ritorni il nome del percorso e il testo, come di seguito:
 
Percorso: nomePercorso/document.txt
Contenuto: Questo e' il contenuto del file.

### Test tramite codice driver:
Creazione degli oggetti:

    Email: Viene creato un oggetto Email con mittente, destinatario, oggetto e corpo del messaggio.
    File: Viene creato un oggetto File specificando il percorso di un file esistente.

Prova dei metodi:

    Stampa del testo dell'email: Viene stampato il testo del messaggio dell'email utilizzando il metodo getText().
    Stampa del testo del file: Viene stampato il contenuto del file utilizzando il metodo getText().

Scrittura del contenuto dell'email su un file:

    Scrittura su file: Il contenuto dell'email viene scritto su un nuovo file chiamato email1.txt utilizzando il metodo writeToFile().

Verifica della presenza di parole chiave:

    Email: Utilizzo del metodo isInText() per verificare se la parola 'incontrarci' è presente nel testo dell'email. Il risultato atteso è True.
    File: Utilizzo del metodo isInText() per verificare se la parola 'percorso' è presente nel testo del file. Il risultato atteso è False.

'''

class Documento:

    def __init__(self, testo: str) -> None:
        self.testo = testo

    def getText(self) -> str:
        return self.testo

    def setText(self, testoInserire: str) -> None:

        self.testo = testoInserire

    def isInText(self, parolaChiave: str) -> bool:

        return parolaChiave in self.testo


class Email(Documento):

    def __init__(self, testo: str, mittente: str, destinatario: str, titoloMessaggio: str) -> None:

        super().__init__(testo)

        self.mittente = mittente

        self.destinatario = destinatario

        self.titoloMessaggio = titoloMessaggio

    def setMittente(self, inserimentoMittente: str) -> None:

        self.mittente = inserimentoMittente

    def setDestinatario(self, inserimentoDestinatario: str) -> None:

        self.destinatario = inserimentoDestinatario

    def setTitoloMessaggio(self, inserimentoTitoloMessaggio: str) -> None:

        self.titoloMessaggio = inserimentoTitoloMessaggio

    def getMittente(self) -> str:

        return self.mittente

    def getDestinatario(self) -> str:

        return self.destinatario

    def getTitoloMessaggio(self) -> str:

        return self.titoloMessaggio

    def getText(self) -> str:

        return f"Da: {self.mittente}, A: {self.destinatario}\nTitolo: {self.titoloMessaggio}\nMessaggio: {super().getText()}"

    def writeToFile(self, percorso: str) -> None:

        with open(percorso, 'w', encoding='utf-8') as f:

            f.write(self.getText())


class File(Documento):

    def __init__(self, nomePercorso: str) -> None:

        self.nomePercorso = nomePercorso

        '''Inizializziamo il testo inizialmente come vuoto'''

        super().__init__('') 

    def leggiTestoFile(self) -> None:

        with open(self.nomePercorso, 'r', encoding='utf-8') as f:
            self.testo = f.read()

    def getText(self) -> str:

        return f"Percorso: {self.nomePercorso}\nContenuto: {super().getText()}"



'''DRIVER PROGRAMM - per verificare le funzionalità corrette del programma'''

messaggioEmail = Email(

    testo="Ciao Bob, possiamo incontrarci domani?",

    mittente="alice@example.com",

    destinatario="bob@example.com",

    titoloMessaggio="Incontro"
)


percorsoFile = "document.txt"
with open(percorsoFile, "w", encoding="utf-8") as f:
    f.write("Questo e' il contenuto del file.")

documentoTesto = File(percorsoFile)
documentoTesto.leggiTestoFile()


print("--- Percorso Email ---\n")
print(messaggioEmail.getText())

print("\n--- Verifica File ---\n")
print(documentoTesto.getText())


messaggioEmail.writeToFile("email1.txt")

print("\nC'è la parola 'incontrarci' nell'email? RISPOSTA -> ", messaggioEmail.isInText("incontrarci"))  
print("C'è la parola 'percorso' nel file? RISPOSTA -> ", documentoTesto.isInText("percorso"))        

 