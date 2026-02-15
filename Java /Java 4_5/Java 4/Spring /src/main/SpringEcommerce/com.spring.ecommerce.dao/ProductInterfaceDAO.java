package com.spring.ecommerce.dao;

import java.util.List;

import com.spring.ecommerce.entity.Product;

public interface ProductInterfaceDAO {
	
	
	public Product selezionaID(int id);
	
	public String selezionaIDStock(int idStock);
	
	public void aggiornaIDStock(int idStock, String nuovoStock);
	
	public List<Product> mostraTutto();
}
