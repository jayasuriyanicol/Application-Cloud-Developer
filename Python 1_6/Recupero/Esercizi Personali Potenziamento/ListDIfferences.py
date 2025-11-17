'''
Implement a function that computes the difference between two lists. The function should remove all occurrences of elements from the first list (a) 
that are present in the second list (b). 
The order of elements in the first list should be preserved in the result.

Examples

If a = [1, 2] and b = [1], the result should be [2].

If a = [1, 2, 2, 2, 3] and b = [2], the result should be [1, 3].

'''

def array_diff(a, b):
     
     listaRisultante:list[int] = []

     for elemento in a:
          if elemento not in b:
               
               listaRisultante.append(elemento)

     return listaRisultante


     '''
     In alternativa è possibile utilizzare una list Comprehension per risolvere l'esercizio
        return[elemento for elemento in a if elemento not in b] 
     '''


'''Svolgimento degli output attesi, richiesti dall'esercizio:'''

print(array_diff(a = [1, 2], b= [1] ))
print(array_diff(a = [1, 2, 2, 2, 3] , b = [2]))