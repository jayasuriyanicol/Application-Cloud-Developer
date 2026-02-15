package com.spring.ecommerce.dao;

import java.util.List;

import com.spring.ecommerce.entity.Order;
import com.spring.ecommerce.entity.Status;


//Creation of an INTERFACE to manipulate the CRUD DAO of ORDERS 


public interface OrderInterfaceDAO {
	
	public void aggiungiOrdine(Order ordine);
	

	public Order selezionaId(int id);

	
	public List<Order> mostraTuttiOrdini();
	
	public Order rimuoviOrdine(int idOrd);

	
	public void cambiaIdOrdine(int idOrd, Status newStatus);
	
	

	

}
