'''
The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:

max_sequence([-2, 1, -3, 4, -1, 2, 1, -5, 4])
# should be 6: [4, -1, 2, 1]

Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. I
If the list is made up of only negative numbers, return 0 instead.

Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.

'''

def max_sequence(arr):

    somma:int = 0
    sommaMassima:int = 0
    numeriNegativi:bool = True
    

    if len(arr) == 0 :

        return 0
    
    for elemento in arr:

        if elemento >=0:
            numeriNegativi = False
            break

    if numeriNegativi:
            return 0
    

    '''In forma più ridotta con un'array comprehension possiamo adottare la formulla con 'all' ovvero:
    
                             if all(elemento < 0 for elemento in arr):
                                return 0
    
    '''
    
   
     
    for elemento in arr:


        somma += elemento 

        if somma < 0:

            somma = 0
        if somma > sommaMassima:
            sommaMassima = somma

    return sommaMassima
        









    
        
