'''
7. Roman Numeral Conversion:

    Create a function that converts a given integer to its Roman numeral representation.
    Handle numbers from 1 to 3999.
    Use a combination of string manipulation and conditional statements to build the Roman numeral.
'''

#Definiamo una funzione che converte un numero arabo (numerazione da noi utilizzata) -> in romano
def romanNumbers():
     
    #Prendiamo un numero intero in input, se questo non è valido, uscirà un messaggio di ERRORE 
    number_arabic: int = int(input("\n\nWelcome, please write down the ARABIC NUMBER: "))  

    if not (1 <= number_arabic <= 3999):  
        print("\nATTENTION! The number has to be from 1 to 3999, not less nor more!")
        return  

   #Inseriamo tutti i numeri ARABI con i numeri ROMANI corrispondenti fino a 1000, sotto aggiungiamo una stringa vuota con il risultato pronto
    numbersRoman = {1000: "M", 900: "CM", 500: "D", 400: "CD", 100: "C", 90: "XC", 50: "L", 40: "XL", 10: "X", 9: "IX", 5: "V", 4: "IV", 1: "I"}

    number_converted = ""
    num = number_arabic

   #Per ogni chiave e simbolo nel dict finchè il numero non sarà 0 continuiamo la conversione.
    for value, symbol in numbersRoman.items(): 
        while num >= value:
           #Se il valore è corrispondente andiamo a inserirlo nella stringa, sennò continuiamo a decrementare finche non raggiunge il valore della conversione 
            number_converted += symbol
            num -= value
    #STampiamo il valorre mostrando il risultato e il numero inserito nella conmversione 
    print(f"\nThe Roman numeral for {number_arabic} is: {number_converted}") 


romanNumbers()

        
        
    
        
            
            