'''
Scrivi una funzione che unisce due dizionari. Se una chiave è presente in entrambi, somma i loro valori.

For example:

Test 	                                           Result

print(merge_dictionaries({'x': 5}, {'x': -5}))  {'x': 0}

'''


def merge_dictionaries(dict1:dict[str,int],dict2:dict[str,int]) -> dict[str,int]:


    dizionarioUnito:dict[str,int] = dict1.copy()


    for k,v in dict2.items() :
        
        if k in dizionarioUnito:

          dizionarioUnito[k] += v
        else:
           dizionarioUnito[k] = v
    return dizionarioUnito





print(merge_dictionaries({'x': 5}, {'x': -5})) 


print(merge_dictionaries({'a': 1, 'b': 2}, {'b': 3, 'c': 4}))


print(merge_dictionaries({}, {'a': 10, 'b': 20}))

	



	



