package com.spring.ecommerce.entity;

/* * OrderItem - Order Line Entity
    ? Represents a single line item within a larger Order. It captures the specific details of a product transaction, effectively linking the catalog to the purchase history.

    ! 1. Price Historization, the `unitPrice` field is critical as it records the cost of the item *at the moment of purchase*. This ensures that subsequent price changes in the global Product catalog do not retroactively alter the total value of past orders.
    ! 2. Lightweight Association, references the product via `productId` (an integer) rather than embedding the full `Product` object. This creates a loosely coupled relationship, simplifying data serialization and avoiding complex object graph loading issues.
*/

public class OrderItem {
	
	private int productId;
	private int quantity;
	private double unitPrice;
	
	
	
	public OrderItem(int productId, int quantity, double unitPrice) {
	
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	@Override
    public String toString() {
    return "|ITEM ORDINE|\n  ID PRODOTTO -> " + productId + "\n  QUANTITÀ -> " + quantity +  "\n  PREZZO UNITARIO -> " + unitPrice;
}
	

}
