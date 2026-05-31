package com.spring.ecommerce.dto;


import java.util.Objects;


/* * ProductResponseDTO - Public Catalog Representation
    ? A Data Transfer Object specifically structured for outbound product data. It serves as the standard read-only view of a product, providing customers and the frontend application with essential details while omitting sensitive management fields.

    ! 1. Data Sanitization, unlike the 'ManagementProductDTO', this class excludes administrative fields like usernames and passwords. This ensures that sensitive security credentials never leave the server environment, maintaining a strict boundary between public information and private access data.
    ! 2. Optimized Identity Logic, implements `equals` and `hashCode` based on the unique product ID. This is vital for frontend state management and Java Collections, ensuring that duplicate product entries are correctly identified and handled during catalog rendering.
    ! 3. Uniform Presentation, maintains a `toString()` format identical to the management version. This consistency simplifies cross-referencing between administrative logs and customer-facing reports, making it easier for support teams to verify product availability and pricing.
*/

public class ProductResponseDTO {
	
	private int id;
	private String name;
	private double UnitPrice;
	private int stock;

	public ProductResponseDTO() {}

	public ProductResponseDTO(int id, String name, double price, int stock) {
		
		this.id = id;
		this.name = name;
		this.UnitPrice = price;
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

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double UnitPrice) {
		this.UnitPrice = UnitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			
			return true;
		
		if (obj == null)
			
			return false;
		
		if (getClass() != obj.getClass())
			
			return false;
		
		ProductResponseDTO other = (ProductResponseDTO) obj;
		
		return id == other.id;
	}
	

	@Override
	public String toString() {
		return id + "|PRODOTTO " + name.toUpperCase() + "|\nPREZZO UNITARIO ->" + UnitPrice + "€\nNOME STOCK -> " + stock;
	}
}