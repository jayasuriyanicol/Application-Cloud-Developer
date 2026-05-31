package com.spring.ecommerce.entity;


/* * Product - Inventory Domain Entity
    ? Represents a distinct item available for purchase within the e-commerce system. It encapsulates the essential attributes—identity, descriptive metadata, monetary value, and stock availability—required for order processing.

    ! 1. Data Type Adaptation, the parameterized constructor accepts the price as a `String` and performs immediate parsing (`Double.parseDouble`). This indicates an intentional design choice to handle raw input (potentially from text-based sources like CSVs or legacy APIs) by sanitizing it at the moment of object creation.
    ! 2. Mutable State Container, exposes standard getters and setters, allowing the Service layer (specifically `OrderService`) to dynamically adjust the `stock` count during transaction processing (e.g., decrementing upon order confirmation).
    ! 3. Debugging Utility, overrides `toString()` to produce a formatted, multi-line console output. This simplifies logging and troubleshooting by providing a snapshot of the product's state without needing a debugger.
*/


public class Product {

    private int id;
    private String name;
    private double price;
    private int stock;    

    public Product() {}

   
    public Product(int id, String name, String priceString, int stock) {
        this.id = id;
        this.name = name;
        
        //To avoid the problem to convert always the price from Double in String we do it on the constructor
        this.price = Double.parseDouble(priceString); 
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
 

	@Override
	public String toString() {
		return "|PRODOTTO|\n  ID -> " + id + "\nNOME -> " + name + "\nSTOCK -> " + stock + "\nPREZZO ->" + price ;
	}
	
    
    
}
