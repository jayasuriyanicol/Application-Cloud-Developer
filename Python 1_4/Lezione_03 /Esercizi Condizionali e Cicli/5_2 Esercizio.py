'''
5-2. More Conditional Tests: You don’t have to limit the number of tests you cre-
ate to 10. If you want to try more comparisons, write more tests and add them

to conditional_tests.py. Have at least one True and one False result for each of
the following:
• Tests for equality and inequality with strings
• Tests using the lower() method
• Numerical tests involving equality and inequality, greater than and less
than, greater than or equal to, and less than or equal to
• Tests using the and keyword and the or keyword
• Test whether an item is in a list
• Test whether an item is not in a list

'''

#Inizializziamo le variabili, aggiungendo anche come una LISTA di Fruit e quella del tempo  WEATHER.
car = 'subaru'
favorite_color = 'blue'
age = 25
number = 10
is_sunny = True
fruits = ['apple', 'banana', 'cherry']
weather = 'sunny'

#Modifichiamo chiedendo l'uguaglianza e la disuguaglianza
print("Is car == 'subaru'? I predict True.")
print(car == 'subaru')  

print("\nIs car != 'audi'? I predict True.")
print(car != 'audi')  

#Modifichiamo chiedendo se il nome del colore in questione con la funzione LOWER CASE.
print("\nIs favorite_color.lower() == 'blue'? I predict True.")
print(favorite_color.lower() == 'blue')  

print("\nIs favorite_color.lower() == 'RED'? I predict False.")
print(favorite_color.lower() == 'RED')  

#Modifichiamo con operazioni matematiche di (Uguaglianza, Disuaglianza, Maggiore di, Minore di, Maggiore Uguale ad, Minore Uguale adc)
print("\nIs age == 25? I predict True.")
print(age == 25)  

print("\nIs age != 25? I predict False.")
print(age != 25)  

print("\nIs number > 5? I predict True.")
print(number > 5)  

print("\nIs number < 5? I predict False.")
print(number < 5)  

print("\nIs age >= 18? I predict True.")
print(age >= 18) 

print("\nIs age <= 18? I predict False.")
print(age <= 18) 

#Creiamo chiedendo una comparazione sia vera e comparazione di una vera.
print("\nIs age > 18 and is_sunny == True? I predict True.")
print(age > 18 and is_sunny == True)  

print("\nIs age < 18 and is_sunny == True? I predict False.")
print(age < 18 and is_sunny == True)  

print("\nIs age > 18 or weather == 'rainy'? I predict True.")
print(age > 18 or weather == 'rainy')  

print("\nIs age < 18 or weather == 'rainy'? I predict False.")
print(age < 18 or weather == 'rainy')  


#Creiamo se un determinato frutto è presente nella lista creata FRUIT
print("\nIs 'banana' in fruits? I predict True.")
print('banana' in fruits)  

print("\nIs 'grape' in fruits? I predict False.")
print('grape' in fruits)  

#Creiamo chieddendo se un determinato frutto non è presente nella lista FRUIT
print("\nIs 'apple' not in fruits? I predict False.")
print('apple' not in fruits)  

print("\nIs 'orange' not in fruits? I predict True.")
print('orange' not in fruits)  
