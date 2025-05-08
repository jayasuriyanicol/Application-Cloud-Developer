
''' LEZIONE NUMERO 4 - FUNZIONI '''

'''
Primo esercizio nelle SLIDE (PDF Funzioni), creazione di un algortimo, senza l'utilizzo della funzione: 
Suppose that you need to find the sum of integers from 1 to 10, 20 to 37, and 35 to 49. Write a Python program that
compute these three different sums.
Expected Output:
Sum of integers from 1 to 10 is 55
Sum of integers from 20 to 37 is 513
Sum of integers from 35 to 49 is 630

'''
'''
#Inizializzo semnpre la varibile somma a 0, dato che poi mi stamperà in output il risultato SOLO per il CICLO IN QUESTIONE
sum:int=0
for i in range (0,11):
    sum += i
print("SOMMA DA 1 A 10 È: ",sum)

sum:int=0
for i in range (20,38):
    sum  += i
print("SOMMA DA 20 A 37 È: ",sum)

sum:int=0
for i in range (35,50):
    sum += i
print("SOMMA DA 35 A 50 È: ",sum)
'''

'''
Utilizziamo le funzioni per OTTIMIZZARE certe operazioni per valutare una determinata operazione.
Ci sono due STEP: 
La prima è quella di definmire la funzione prima di utilizzarla, in questa maniera:

        def functionName(lista di parametri):
              instruzioni per il corpo della funzione
              
tramite le parentesi presenti nella funzione, indicando una lista di parametri, che servirà per funzionare.

Sotto riporterò tutte le cose che dovrà svolgere la funzione per lavorare.

Vediamo un tentavivo per la creazione din una funzione:

(lista dei parametri): questi saranno i parametri della nostra funzione, non verranno dichiarati
dentro o fuori dalla funzione, ma ben si dentro le parentesi.

|IMPORTANTE È L'INDENTAZIONE, sempre distanziare dalla definizione della funzione !
SERVE A CAPIRE CHE SIAMO NEL CORPO DELLA FUNZIONE !|

vediamolo implementato:

def sumInRange(a:int, b:int):

    result:int = 0
    for i in rnage (a,b+1)
      result += i
    return result #RESTITUISCI IL RISULATO.

Da qui possiamo direttamente utilizzare questa forma: 
mysum = sumInRange(1,10)

#Chiamiamo in questo caso gli argomenti della funzione, ovvero (1,10), cosi per ogni fase richiesta dall'esercizio
print(f"La somma da 1 a 10 è {sumInRange(1,10}") 

'''
'''
def sommaInRange (a:int, b:int):
    result:int = 0
    for i in range(a,b+1):
        result += i
    return result

print(f"Somma da 1 a 10 è: {sommaInRange(1,10)}")
print(f"Somma da 20 a 37 è: {sommaInRange(20,37)}")
print(f"Somma da 35 a 49 è: {sommaInRange (35,49)}") 

'''


'''

In questo esercizio: 

Functions/3: Exercise
Let’s try to define a function named subtract ourselves:
● It should take 2 parameters.
● Inside the function, it should subtract the two.
● Then, return the result.


After you defined it, call the function with some arguments!

Speigazione funzionamento. logica del programma: 

Andiamo a definire una funzione che la chiamerermo in questa maniera: sottrazioneTraDueNumeri e andiamo a dichiarare due parametri interi a e b
e andiamo a scrivere dentro la funzione la nostra operazione in questione, ovvero la sottrazione.
Come prima cosa andando a inizializzare la variabile risultato come variabile intera e inizializzandola a 0. Infine andiamo a scolgere la nostra, 
operazione in questione che sarà uguale ad (A e B) e poi riportando il nostro risultato con return.



INFINE, come step finale andiamo a richiamare la funzione e salvarla in una variabile chiamata MyResult e poi stamparte il risultato.
per esempio se nei parametri sostituiamo i dati e mettiamo (a=4 e b=3) avremo come risultato= 1.

CODICE: 
'''

'''
def sottrazioneTraDueNumeri (a:int, b:int):
 
     risultato:int 
     risultato = a-b
     return risultato

My_result =  sottrazioneTraDueNumeri(4,3)
print(My_result)

'''

'''
Possiamo allo stesso modo chiedere all'utente di inserire dei valori da tastiera: 

MyResult = sottrazioneTraDueNumeri(a = input("Inserire il valore di A: "),
                                   b = input("Inserire il valore di B: "))
'''

'''
Attraverso l'utilizzo di RETURN possiamo estrarre il nostro numero. Possiamo inserire ccanto ai parametri della funzione 
per esplicare che l'output della funzione sarà -> int

Esempio sintassi da seguire: 

def myFunction (parametri della funzione) -> tipologia di output (int,float,char,ecc.)
lo stesso. La funzione può anche non riportare nulla in Output.

con  print(type(sottrazioenTraDueNumeri(4,1)) in questo caso come indicato precedentemente in output avremo la tipologia del risultato:

<class 'int'>

Quando non riportimo RETURN nella funzione questa ci riporterà 'None', scrivendo sempre print e il nome della funzione con le relative variabili.


PARAMETRI DI UNA FUNZIONE: 

Ci sono tre tipologie di parametri, che sono: 

- POSIZIONE: ovvero nell'ordine con cui sono stati dichiariati, primo, secondo e cosi via ...
  bisogna seguire l'ordine in cui li abbiamo dichiarati e sopratutto inserire qualcosa alla chiamata alla funzione.
  Come: greet ("Angela", 13).


- KEYWORD: ovvero per Nome, riportare in questo caso direttamente, il parametro = il dato. L'ordine in questo caso
  non è obbligatorio, possiamo in questa maniera avere chiaro quale dato stiamo passando come parametro.
  Se vogliamo combinarli. si deve seguire la regola della sintassi, ovvero prima quelli POSIZIONALI, e poi tutti le KEYWORD. 
  

- DEFAULT: ovvero vengono dati dei parametri inseriti in maniera obbligatoria e DEVONO essere dichiarati inizialmente. In caso 
           noi non inseriamo in nostri valori, di DEFAULT verrà assegnato un valore. 
    ESEMPIO:

    def func(par1, par2 , par3=value3, par4= value4)
    #par1, par2 OBBLIGATORIE 
    #par3 , par4 : se non vengono indicati, assumeranno il valore di default presente sulla dichiarazione.
     
- WITHOUT PARAMETRES: ovvero delle funzioni che possono essere passate senza utilizzo di parametri, in questo caso
                     ESEMPIO:

                    def hello():
                        print('Hello')
            hello()
            >> Hello

Bisogna fare attenzione a non far passare troppi elementi di quanti dichiarati, un modo per ovviare è quello di utilizzare
il metodo "*args" cosi in modo da far passare una "lista illimitata" di elementi.

**kwargs = molto simile a un DICT, dove indichiamo la chiave e un valore. Un esenpio potrebbe essere il seguente:
           dizionario = dict(cofee =2.99, juice = 3.20)

Per quanbto riguarda (*args e **kwargs) possiamo utilizzare anche altri nomi con la sintassi*name, **name:
Quindi, bisogna ricordarsi di mettere:
* =  per le tuple
** = dict


BULT IN, variabili:

abs() =  da il valore assoluto
round() = riporta il valore apporossimato in eccesso e in difetto.
sorted() = riporta la lista ordinata di elementi di una lista.



'''
 
 
 
 
 
 
 
 
 '''