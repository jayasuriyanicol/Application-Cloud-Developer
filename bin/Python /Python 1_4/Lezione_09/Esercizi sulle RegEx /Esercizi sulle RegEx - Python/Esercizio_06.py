'''
6. Verifica un codice prodotto

Scrivi una funzione check_product_code(code) che verifica se il codice è nel formato PROD-1234-AB.

Esempio:

check_product_code("PROD-9876-ZX")  # True
check_product_code("PROD-99-ZX")    # False
'''
#Importiamo la funzione re.findall per la ricerca del codice prodotto che rispetta o standard ovvero (PROD-NNNN-AZ) attraverso una funzione BOOL
import re

def check_product_code(code:str) -> str:

    return bool (re.findall(r'(PROD)-(\d{4})-([A-Z]{2})',code))

#Andiamo a testare i vari codici, verificando che essi siano compatibili allo standard
print(check_product_code ("PROD-9876-ZX"))
print(check_product_code("PROD-99-ZX") )