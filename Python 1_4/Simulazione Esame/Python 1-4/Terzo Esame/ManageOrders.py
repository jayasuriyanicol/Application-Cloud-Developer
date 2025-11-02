




class Product:

    def __init__(self,product_id:str,name:str,price:float)-> None:

        self.product_id =product_id
        self.name = name
        self.price = price
        self.in_stock = True

    
    def mark_sold_out(self)-> None:

        self.in_stock = False
    
    def restock(self) -> None:

        self.in_stock = True
    



class Customer:


    def __init__(self,customer_id:str,name:str) -> None:

        self.customer_id = customer_id
        self.name = name
        self.orders:list[str] =  []


    def add_order(self,order_id:str) -> None:


        if order_id not in self.orders:

            self.orders.append(order_id)
        else:
            print(f"Errore: il codice {order_id} è già presente negli orders")

    def list_orders(self)-> list[str]:

        listaOrdini:list[str] = []   


        for elm in self.orders:

            listaOrdini.append(elm)
        return listaOrdini
    




class Store:

    def __init__(self)-> None:
        
        self.products:dict[str,Product] =  {}
        self.customers:dict[str,Customer] = {}
    
    def add_product(self,product_id:str,name:str,price:float)-> None:

        self.products[product_id]= Product(product_id, name, price)  
    
    def register_customer(self,customer_id:str,name:str) -> None:

        self.customers[customer_id]= Customer(customer_id,name)

    def create_order(self,customer_id:str, product_id:str) -> None:

        if customer_id not in self.customers or  product_id not in self.products:

                print("Errore: dati non validi")

        customer =self.customers[customer_id]
        product = self.products[product_id]

        if not product.in_stock:
            print("Prodotto non disponibile") 
            return
        customer.add_order(product_id)
        product.mark_sold_out()
    

    def list_available_products(self) -> list[str]:

        listAvailableProducts:list[str] = []   

        for id,p in self.products.items():


            if p.in_stock:
                listAvailableProducts.append(id)

        return listAvailableProducts
    

    def list_customer_orders(self,customer_id:str)-> list[str]|str:

        listCustomersOrders:list[str] = [] 

        if customer_id in self.customers:

           return self.customers[customer_id].list_orders() 
        
        else:

            return"Errore: non è presente nessun custom id"
       
    


        
