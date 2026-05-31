'''
Scrivi un programma che gestisca i voti di una classe:

Chiedi all’utente di inserire più voti (da 0 a 10) finché non scrive "fine".

Salva tutti i voti in una lista.

Alla fine stampa:

Il voto più alto.

Il voto più basso.

La media dei voti.

Il numero di insufficienze (< 6).

Tutti i voti in ordine crescente.

Esempio di OUTPUT atteso:


Inserisci un voto (0-10) o 'fine': 8
Inserisci un voto (0-10) o 'fine': 5.5
Inserisci un voto (0-10) o 'fine': 9
Inserisci un voto (0-10) o 'fine': 4
Inserisci un voto (0-10) o 'fine': fine

RISULTATI:
Voto massimo: 9.0
Voto minimo: 4.0
Media voti: 6.63
Numero insufficienze: 2
Voti ordinati: [4.0, 5.5, 8.0, 9.0]

'''

listaVoti:list[int] = [] 
numeroInsufficienze:int = 0

while True:

     
     inserimentoUtente:str = input("Inserisci un voto (0-10) o 'fine' : ")

     if inserimentoUtente.lower() == 'fine':
       
       break

     try:

        votoInserito = float(inserimentoUtente)

     except ValueError:
    
        print("ATTENZIONE ! È possibile solo inserire numeri INTERI o DECIMALI !")

        continue
    
     if 0 < votoInserito > 10:
         
         print("ATTENZIONE ! È possibile solo inserire numeri da 0 a 10 MASSIMO !")
         continue
    

     listaVoti.append(votoInserito)
    
    
      
numeroMassimo:int = max(listaVoti)
numeroMinimo:int = min(listaVoti)
mediaVoti:float = sum(listaVoti) / len(listaVoti)

for elemento in listaVoti:
      
    if elemento < 6:

        numeroInsufficienze += 1 

listaVotiOrdinata = sorted(listaVoti)
print(f"\nRISULTATI:\nVoto Massimo: {numeroMassimo}\nVoto Minimo : {numeroMinimo}\nMedia Voti: {mediaVoti:.2f}\nNumero Insufficienze: {numeroInsufficienze}\nVoti Ordinati: {listaVotiOrdinata}")

        