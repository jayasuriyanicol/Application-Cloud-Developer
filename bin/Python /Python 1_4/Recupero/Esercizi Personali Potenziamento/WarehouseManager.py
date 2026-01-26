
class WarehouseManager:

    def __init__(self)-> None:

      self.warehouses:dict[str,dict[str,int]] = {}

    def add_warehouse(self,name:str) -> None:

        if name in self.warehouses:

            print("Errore: magazzino già esistente")
        else:

            self.warehouses[name] = {}

    def add_product(self,warehouse_name:str, product_name:str, qty:int) -> None:

        if warehouse_name not in self.warehouses:

            print("Errore: magazzino non trovato")

        if warehouse_name in self.warehouses:

            if product_name in self.warehouses[warehouse_name]:

               self.warehouses[warehouse_name][product_name] += qty 

            else:
                 
                self.warehouses[warehouse_name][product_name] = qty

    def remove_product(self,warehouse_name:str, product_name:str, qty: int) -> None:

        if warehouse_name not in self.warehouses:

            print("Errore: magazzino non presente")
        if warehouse_name in self.warehouses:

            
            warehouse = self.warehouses[warehouse_name] 
            quantitaDisponibile = self.warehouses[warehouse_name].get(product_name) 

            if product_name not in warehouse:
                print("Errore: prodotto non trovato") 
             
             
            if qty < quantitaDisponibile:
    

             warehouse[product_name] -= qty

             if warehouse[warehouse_name] == 0:

                 del warehouse[product_name]   

            else:

                  print("Errore: quantità non sufficiente") 

    def list_products(self,warehouse_name:str) -> None:

        if warehouse_name in self.warehouses:

           for prod , qty in self.warehouses[warehouse_name].items():
               
               print(f"{prod}: {qty}") 
        else:
              print("Errore: magazzino non presente")
        
    
    def transfer_product(self,from_wh: str, to_wh: str, product_name: str, qty: int)-> None:
        from_warehouse = self.warehouses.get(from_wh)
        to_warehouse = self.warehouses.get(to_wh)

        if not from_warehouse or not to_warehouse:
            print("Errore: magazzino provenienza o destinazione non presente")
            return

        if product_name not in from_warehouse:
            print("Errore: prodotto non presente nel magazzino di partenza")
            return

        if qty > from_warehouse[product_name]:
            print("Errore: quantità non sufficiente per il trasferimento")
            return

        
        from_warehouse[product_name] -= qty
        to_warehouse[product_name] = to_warehouse.get(product_name,0)  + qty
    

    
    def summary(self)-> dict[str,dict[str,int]]:
        
        print("--- Riepilogo Magazzini ---")
        for wh_name, products in self.warehouses.items():
            print(f"Magazzino: {wh_name}")
            for product, qty in products.items():
                print(f"  {product}: {qty}") 





manager = WarehouseManager()

manager.add_warehouse("Milano")
manager.add_warehouse("Roma")

manager.add_product("Milano", "Monitor", 10)
manager.add_product("Milano", "Mouse", 25)
manager.add_product("Roma", "Laptop", 8)
manager.add_product("Roma", "Mouse", 5)

manager.remove_product("Milano", "Mouse", 10)
manager.transfer_product("Milano", "Roma", "Monitor", 5)

manager.list_products("Milano")
manager.list_products("Roma")

manager.summary()



            


    


    


        
        