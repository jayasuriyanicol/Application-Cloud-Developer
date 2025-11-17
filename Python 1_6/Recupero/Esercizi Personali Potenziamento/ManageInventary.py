'''
3️⃣ Inventario Negozio

Scrivi una funzione:

update_inventory(inventory: dict[str, int], prodotto: str, quantita: int) -> dict[str, int]

che:

aggiunge un nuovo prodotto se non esiste,

aggiorna la quantità (positiva o negativa) se già presente,

rimuove il prodotto se la quantità finale ≤ 0.

📘 Esempio:

update_inventory({"mele": 10, "pere": 5}, "mele", -5) ➜ {"mele": 5, "pere": 5}
update_inventory({"mele": 5}, "mele", -5) ➜ {}



'''


def update_inventory(inventory: dict[str, int], prodotto: str, quantita: int) -> dict[str, int]:


    if prodotto not in inventory:
        if quantita<=0:
             print("ERRORE: Non è possibile inserire la quantità richiesta")
             return inventory
              
        inventory[prodotto] = quantita
        return inventory
        
       

    if prodotto in inventory:

        inventory[prodotto] += quantita
    
        

        if inventory[prodotto] <=0:

            del inventory[prodotto] 
    return inventory



print(update_inventory({"mele": 10, "pere": 5}, "mele", -5))
print(update_inventory({"mele": 5}, "mele", -5))