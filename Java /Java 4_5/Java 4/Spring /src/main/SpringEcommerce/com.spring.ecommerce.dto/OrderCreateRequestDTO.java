package com.spring.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderCreateRequestDTO {
	
	private List<OrderItemDTO> listaProdottiOrdinati;
	private String productId;
	private int quantity;
	
	
	
	public OrderCreateRequestDTO(List<OrderItemDTO> listaProdottiOrdinati, String productId, int quantity) {
		
		this.listaProdottiOrdinati = listaProdottiOrdinati;
		this.productId = productId;
		this.quantity = quantity;
	}


	public OrderCreateRequestDTO() {
		
		
	}
	
	
	public List<OrderItemDTO> getListaProdottiOrdinati() {
		
		if(listaProdottiOrdinati == null )
			
			//If will null, i will return an ArrayList with zero data and arguements
			return listaProdottiOrdinati = new ArrayList<OrderItemDTO>();
		
		//On the other hand, i will return if not null the ArrayList with the products
		return new ArrayList<>(listaProdottiOrdinati);
		
		
		
		
	}



	public void setListaProdottiOrdinati(List<OrderItemDTO> listaProdottiOrdinati) {
		
		if(listaProdottiOrdinati == null)
			
			//Set an ArrayList empty
			this.listaProdottiOrdinati = new ArrayList<>();
		
		
		//Setting with the list of OrderItemDTO
		this.listaProdottiOrdinati = new ArrayList<>(listaProdottiOrdinati);
		
		
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	
	

}
