'''

7️⃣ Raggruppa per Parità

Scrivi una funzione:

group_by_parity(nums: list[int]) -> dict[str, list[int]]


che ritorni un dizionario con due chiavi:

"pari" → lista dei numeri pari

"dispari" → lista dei numeri dispari

📘 Esempio:


group_by_parity([1,2,3,4,5,6])➜ {"pari": [2,4,6], "dispari": [1,3,5]}

'''


def group_by_parity(nums: list[int]) -> dict[str, list[int]]:

    dizionarioPariDispari: dict[str, list[int]] = {"pari" : [], "dispari" : []   }
    for el in nums:

        if el % 2 ==0:
            dizionarioPariDispari["pari"].append(el) 
        else:
            dizionarioPariDispari["dispari"].append(el)
        
    
    return dizionarioPariDispari


print(group_by_parity([1,2,3,4,5,6]))