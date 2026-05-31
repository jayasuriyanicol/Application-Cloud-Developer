'''
Complete the solution so that the function will break up camel casing, using a space between words.
Example

"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""

'''


def solution(s) -> str:

    risultatoStringa:str = ""

    for lettera in s:

        if lettera.isupper():

            risultatoStringa += " " + lettera
        else:

            risultatoStringa += lettera
    return risultatoStringa

  

        


print(solution("helloWorld"))
print(solution("camelCasing"))  
print(solution("identifier"))   
print(solution(""))             