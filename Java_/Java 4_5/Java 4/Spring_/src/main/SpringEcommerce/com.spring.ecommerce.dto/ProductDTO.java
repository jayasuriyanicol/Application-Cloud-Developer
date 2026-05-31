package com.spring.ecommerce.dto;


/* * ProductDTO - Catalog Data Transfer Object
    ? A projection of the Product entity tailored for external communication. It carries the essential catalog information—identity, name, pricing, and availability—from the server to the client-side interface.

    ! 1. Decoupled Persistence, by using a DTO instead of the raw Entity, the API structure remains stable even if the underlying database schema changes. This prevents internal logic leaks and ensures the client only interacts with the public-facing representation of a product.
    ! 2. String-Based Stock, represents stock levels as a `String` (matching the DAO's internal logic). This choice allows for flexible messaging, such as displaying "Out of Stock" or specific numeric values, without forcing the client to handle complex integer parsing.
    ! 3. Consistent Formatting, includes a `toString()` override that matches the Entity’s visual layout. This provides uniformity across server logs and terminal outputs, making it easier for developers to track a product's journey as it is converted from a database record to a JSON response.
*/

public class ProductDTO {

		
		private int id;
		private String name,stock;
		private double price;
		
		
		public ProductDTO(int id, String name, String stock, double price) {
			
			this.id = id;
			this.name = name;
			this.stock = stock;
			this.price = price;
		}
		
		public ProductDTO() {
			
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


		public String getStock() {
			return stock;
		}


		public void setStock(String stock) {
			this.stock = stock;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		@Override
		public String toString() {
			return "|PRODOTTO|\n  ID -> " + id + "\nNOME -> " + name + "\nSTOCK -> " + stock + "\nPREZZO ->" + price ;
		}
		
		
		
		
		

	}


