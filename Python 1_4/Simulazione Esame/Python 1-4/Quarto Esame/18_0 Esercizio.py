'''
Scrivi una funzione che, data una lista, ritorni un dictionary che mappa ogni elemento alla sua frequenza nella lista.

For example:
Test 	Result

print(frequency_dict(['mela', 'banana', 'mela'])) {'mela': 2, 'banana': 1}

'''


def frequency_dict(elements: list) -> dict:

    dizionarioParole:dict[str,int] = {} 

    for elem in elements:

        if elem in dizionarioParole.keys():

            dizionarioParole[elem] += 1
        else:
            dizionarioParole[elem] = 1
    return dizionarioParole  




print(frequency_dict(['mela', 'banana', 'mela']))