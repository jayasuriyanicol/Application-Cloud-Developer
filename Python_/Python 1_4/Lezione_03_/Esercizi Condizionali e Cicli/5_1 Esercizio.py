'''
5-1. Conditional Tests: Write a series of conditional tests. Print a statement
describing each test and your prediction for the results of each test. Your code
should look something like this:
car = 'subaru'
print("Is car == 'subaru'? I predict True.")
print(car == 'subaru')
print("\nIs car == 'audi'? I predict False.")
print(car == 'audi')
• Look closely at your results, and make sure you understand why each line
evaluates to True or False.
• Create at least 10 tests. Have at least 5 tests evaluate to True and another
5 tests evaluate to False.

'''
#Inizializziamo la varuiabile come richiesto dall'esercizio, prendendo per esempio la MACCHINA, la sua ETÀ, 
#Il COLORE PREFERITO, il NUMERO PREFERITO e se c'è SOLE.
car = 'subaru'
age = 25
favorite_color = 'blue'
number = 10
is_sunny = True

# Test 1: Chiediamo se il modello della macchina sia Sabaru, a quanto pare è TRUE.
print("Is car == 'subaru'? I predict True.")
print(car == 'subaru')  # True

# Test 2: Chiediamo se il modello della macchina sia Audi, a quanto pare è FALSE.
print("\nIs car == 'audi'? I predict False.")
print(car == 'audi')  # False

# Test 3: Chiediamo se l'età della macchina sia maggiore di 18?, a quanto pare è TRUE.
print("\nIs age > 18? I predict True.")
print(age > 18)  # True

# Test 4: Chiediamo se l'età della macchina sia minore di 18?, a quanto pare è FALSE.
print("\nIs age < 18? I predict False.")
print(age < 18)  # False

# Test 5: Chiediamo il colore preferito sia il BLU?, a quanto pare è TRUE.
print("\nIs favorite_color == 'blue'? I predict True.")
print(favorite_color == 'blue')  # True

# Test 6:Chiediamo il colore preferito sia il VERDE?, a quanto pare è FALSE.
print("\nIs favorite_color == 'green'? I predict False.")
print(favorite_color == 'green')  # False

# Test 7: Chiediamo il numero preferito sia il 10?, a quanto pare è TRUE.
print("\nIs number == 10? I predict True.")
print(number == 10)  # True

# Test 8: Chiediamo il numero preferito sia il 15?, a quanto pare è FALSE.
print("\nIs number > 15? I predict False.")
print(number > 15)  # False

# Test 9: Chiediamo se ci sia SOLE oggi?, a quanto pare è TRUE.
print("\nIs is_sunny == True? I predict True.")
print(is_sunny == True)  # True

# Test 10: Chiediamo se ci sia SOLE oggi?, a quanto pare è TRUE.
print("\nIs is_sunny == False? I predict False.")
print(is_sunny == False)  # False


