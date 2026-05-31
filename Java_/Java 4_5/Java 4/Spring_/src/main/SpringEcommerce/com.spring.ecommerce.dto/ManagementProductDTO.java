package com.spring.ecommerce.dto;

import java.util.Objects;

/* * ManagementProductDTO - Admin-Level Product Operation DTO
    ? A specialized Data Transfer Object designed for administrative product management. It combines the product details (name, price, stock) with security credentials to ensure that only authorized personnel can perform catalog modifications.

    ! 1. Embedded Authentication, uniquely includes `username` and `password` fields within the payload. This allows the system to perform "inline" validation, ensuring that every request to add or modify a product is accompanied by a valid security handshake before the transaction proceeds.
    ! 2. Integrity through Identity, overrides `equals` and `hashCode` based solely on the product `id`. This ensures that in-memory collections or set-based comparisons correctly identify duplicate products, preventing the accidental creation of multiple entries for the same identifier.
    ! 3. Administrative Formatting, the `toString()` method provides a clean, capitalized summary of the product. This is specifically useful for back-office logging, allowing administrators to verify exactly what data was submitted to the catalog at a glance.
*/

public class ManagementProductDTO {

		private int id;
		private String name;
		private double UnitPrice;
		private int stock;
		private String username;
		private String password;

		public ManagementProductDTO () {}

		public ManagementProductDTO(int id, String name, double UnitPrice, int stock, String username, String password) {
			
			this.id = id;
			this.name = name;
			this.UnitPrice = UnitPrice;
			this.stock = stock;
			this.username = username;
			this.password = password;
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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (getClass() != obj.getClass())
				return false;
			
			ManagementProductDTO other = (ManagementProductDTO) obj;
			return id == other.id;
		}

		@Override
		public String toString() {
			return id + "|PRODOTTO " + name.toUpperCase() + "|\nPREZZO UNITARIO ->" + UnitPrice + "€\nNOME STOCK -> " + stock;
		}
	}

