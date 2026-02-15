package com.spring.ecommerce.dto;

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


