package com.spring.ecommerce.dto;


/* * OrderItemDTO - Transaction Line Item Detail
    ? A lightweight Data Transfer Object used to represent an individual product entry within an order. It serves as the bridge between the client's shopping cart and the backend's processing logic, capturing essential purchase specifics.

    ! 1. Data Encapsulation, uses wrapper classes (`Integer`, `Double`) to allow for nullability during deserialization checks. This ensures the system can distinguish between a value of zero and a missing field, which is critical for validating mandatory inputs like product IDs and quantities.
    ! 2. Pricing Snapshot, includes a `unitPrice` field to facilitate the "freezing" of costs at the time of the transaction. This prevents future price fluctuations in the master catalog from altering the historical total of an already submitted or processed order.
    ! 3. Human-Readable Debugging, features a customized `toString()` method that outputs a structured "Item Detail" block. This formatted string is optimized for console logging, making it easy for developers to verify order contents during the integration of multi-item requests.
*/


public class OrderItemDTO {
	
		private Integer productId, quantity;
		private Double unitPrice;
		
		
		public OrderItemDTO() {}
		
		
		public OrderItemDTO(Integer productId, Integer quantity, Double unitPrice) {
		
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



		public Integer getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}



		public Double getUnitPrice() {
			return unitPrice;
		}



		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
		
		
		


		@Override
		public String toString() {
		    return 
		           "    |DETTAGLIO ITEM|\n" +
		          
		           "      ID PRODOTTO -> " + productId + "\n" +
		           "      QUANTITÀ    -> " + quantity + "\n" +
		           "      PREZZO UNIT -> " + unitPrice + " €\n";
		}

		
		
		
		
		

	}

