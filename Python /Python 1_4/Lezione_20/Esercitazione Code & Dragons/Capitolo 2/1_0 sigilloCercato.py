'''
CAPITOLO 2 - ESERCIZIO NUMERO 1
Sigillo Cercato

Negli annali delle formule cerchi un ingrediente: se manca sugli scaffali, prendi il sostituto previsto. 
Applica `get_or_default(d, k, default)` restituendo il valore o `default` senza alterare `d`.
 Mantieni la firma e supera i test.


'''


def get_or_default(d: dict, k, default=None):

    if not d:
       
      return default 
      
    else:
        for chiave,valore in d.items():
          if chiave == k:
             return valore
          else:
             pass
    

print(get_or_default ({},'x',7))