'''
5-7. Favorite Fruit: Make a list of your favorite fruits, and then write a series of independent if statements that 
check for certain fruits in your list.
• Make a list of your three favorite fruits and call it favorite_fruits.
• Write five if statements. Each should check whether a certain kind of fruit is in your list. 
If the fruit is in your list, the if block should print a statement, such as You really like Apples!

'''

# Creo la lista dei miei frutti preferiti
favorite_fruits = ["apple", "orange", "banana"]

# Verifico se un frutto specifico è presente nella lista
if "apple" in favorite_fruits:
    print("You really like Apples!")

if "orange" in favorite_fruits:
    print("You really like Oranges!")

if "banana" in favorite_fruits:
    print("You really like Bananas!")

if "grape" in favorite_fruits:
    print("You really like Grapes!")

if "kiwi" in favorite_fruits:
    print("You really like Kiwis!")
