''' 
ESERCIZIO NUMERO 1: 

Scrivi una funzione che accetti tre parametri: username, password e status di attivazione dell'account (attivo/non attivo). 
L'accesso è consentito solo se il nome utente è "admin", la password corrisponde a "12345" e l'account è attivo. 
La funzione ritorna "Accesso consentito" oppure "Accesso negato".

For example:

print(check_access("admin", "12345", True)) >> Accesso consentito

print(check_access("admin", "54321", True)) >> Accesso negato
'''

#Definiamo una funzione che a seconda dei requisiti consenta l'accesso alle persone, quindi se soddisfano: "admin", "12345" e "True" --> Accesso consentito sennò --> Accesso negato
def check_access(username: str, password: str, is_active: bool) -> str:
    if username == "admin":
        if password == "12345":
           if is_active == True:
             return "Accesso consentito"
    
    return "Accesso negato"






'''
ESERCIZIO NUMERO 2:

Scrivi una funzione che, data una lista, ritorni un dictionary che mappa ogni elemento alla sua frequenza nella lista.

For example:

print(frequency_dict(['mela', 'banana', 'mela'])) >> {'mela': 2, 'banana': 1}
'''
#Definiamo una funzione che dati degli elementi di una lista. riporta in un nuovo dict il risultato dei vari valori se ripetuti più volte se no valore 1
def frequency_dict(elements: list) -> dict:
    frequenza = {}
    for i in elements:
          if i in frequenza:
              frequenza[i] +=1
          else: 
              frequenza[i] = 1
    return frequenza




'''
ESERCIZIO NUMERO 3:
Scrivi una funzione che calcola la media di una lista di numeri e ritorna il valore arrotondato all'intero più vicino.

For example:

print(rounded_average([1, 1, 2, 2])) >> 2
'''
#Definiamo una funzione che calcola la media dei numeri poresenti in una lista, riportando il valore più significativo
def rounded_average(numbers: list[int]) -> int:
    somma = 0
    conteggio= 0
    for i in numbers:
        conteggio +=1 
        somma += i

    media = somma / conteggio
    return round(media)



'''
ESERCIZIO NUMERO 4:

Scrivi una funzione che, dato un numero intero, determina se è un "numero magico". Un numero magico è definito come un numero che contiene il numero 7.

For example:

print(is_magic_number(70)) >> True

print(is_magic_number(123)) >> False
'''
#Definiamo una funzione, che verifica dato un numero se vi è la presenza del numero magico 'numero : 7', se è presente deve ritornare True se non è presente FALSE

def is_magic_number(num: int) -> bool:
    
    while num > 0: 
        
        elemento =  num % 10
        
        if elemento == 7:
            return True
        
        else:
            num = num // 10
    return False


'''
ESERCIZIO NUMERO 5:


Scrivi una funzione che verifica se una combinazione di condizioni (A, B, e C) è soddisfatta per procedere con un'operazione. 
L'operazione può procedere solo se la condizione A è vera o se entrambe le condizioni B e C sono vere.
La funzione deve ritornare "Operazione permessa" oppure "Operazione negata" a seconda delle condizioni che sono soddisfatte.

For example:

print(check_combination(True, False, True)) >> Operazione permessa

print(check_combination(False, True, False)) >> Operazione negata
'''


#Definiamo una funzione che date tre condizioni, permette l'operzione solo se la prima o la seconda e terza condizione sono vere. Altrimenti l'operzione è negata
def check_combination(conditionA: bool, conditionB: bool, conditionC: bool) -> str:
    if conditionA == True or(conditionB == True and conditionC == True):
        return "Operazione permessa"
    
    else:
        return "Operazione negata"
    




'''
ESERCIZIO NUMERO 6:

La funzione dovrebbe determinare se un elemento è presente in una lista.
Un errore nell'implementazione porta a risultati inaspettati.
 
TROVA L'ERRORE E CORREGGI IL CODICE
'''
#L'errore nella funzione era il return che non era indetato bene, tanto che certi test non si superavano 'return False'

def find_element(lst: list[int], element: int) -> bool:
    for item in lst :
        if item == element:
            return True
       
    return False




'''
ESERCIZIO NUMERO 7:
Scrivi una funzione che verifica se in una stringa le parentesi '(' e ')' sono bilanciate, cioè per ogni parentesi che apre 
c'è la corrispondente parentesi che chiude.

For example:

print(check_parentheses("()()")) >> True

print(check_parentheses("(()))(")) >> False
'''

#Definiamo una funzione che date delle parentesi, verifica che esse siano bilanciate ovvero chiusa e aperta.
def check_parentheses(expression: str) -> bool:
      parentesi_pari = 0


      for carattere in expression:
          
             if carattere == "(":
               parentesi_pari += 1
             elif carattere == ")":
                parentesi_pari -= 1

    
          
             if parentesi_pari <  0: 
                return False 
             


'''
ESERCIZIO NUMERO 8:

Scrivi una funzione che conta e ritorna quante volte un elemento appare isolato in una lista di numeri interi. 
Un elemento è considerato isolato se non è affiancato sia a destra che a sinistra da elementi uguali.

For example:
print(count_isolated([1, 2, 2, 3, 3, 3, 4])) >> 2

print(count_isolated([1, 2, 3, 4, 5])) >> 5
'''
#Definiamo una funzione nella quale calcoliamo quante volte un numero rimane isolato, ovvero che non ha numeri uguali a sinistra e a destra, riportando le volte in cui ciò accade
def count_isolated(caratteri:list[int] )  -> int:
  carattere = 0

  for numero in range (len(caratteri)):
      if (numero == 0 or caratteri[numero] != caratteri[numero-1]) and (numero == len(caratteri)-1 or caratteri[numero]!= caratteri[numero+1]):
        carattere += 1
  return carattere


'''
ESERCIZIO NUMERO 9:

Scrivi una funzione che, dato un insieme e una lista di numeri interi da rimuovere, ritorni un nuovo insieme senza i numeri specificati nella lista.

For example:

print(remove_elements({5, 6, 7}, [7, 8, 9])) >> {5, 6}
'''
#Definiamo una funzione che data un dict e una lista, riporta nuovamente il dizionario senza i vari numeri dichiarati precedentemente nella lista
def remove_elements(original_set: set[int], elements_to_remove: list[int]) -> set[int]:
      numeri = set()
      for numero in original_set:
           if numero not in elements_to_remove:
               numeri.add(numero)
      return numeri


'''
ESERCIZIO NUMERO 10:
Scrivi una funzione che unisce due dizionari. Se una chiave è presente in entrambi, somma i loro valori.

For example:
print(merge_dictionaries({'x': 5}, {'x': -5})) >> {'x': 0}
'''
#Definiamo una funziuone che dati due dizionari che hanno lo stesso valore ridia la chiave con la somnma dei valori che hanno la stessa chiave 
def merge_dictionaries(dict1: dict, dict2: dict) -> dict:

    for chiave, valore in dict2.items():
    
        if chiave in dict1:

          dict1[chiave] += valore

        else:

          dict1[chiave] = valore
    return dict1 






        

    








