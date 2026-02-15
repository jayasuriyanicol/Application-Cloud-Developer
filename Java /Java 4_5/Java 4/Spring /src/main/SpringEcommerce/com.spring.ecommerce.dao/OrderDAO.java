package com.spring.ecommerce.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ecommerce.entity.Status;
import com.spring.ecommerce.entity.Order;
import com.spring.ecommerce.exception.IdDuplicatedException;
import com.spring.ecommerce.exception.OrderNotFoundException;


//Implement the methods CRUD keeping it on the OrderInterfaceDAO

@Repository
public class OrderDAO implements OrderInterfaceDAO {
	
	
	private HashMap<Integer,Order> mappaOrdini = new HashMap<>();
	private int indicatoreMappa = 0;
	
	@Override
	public synchronized void aggiungiOrdine(Order ordine) {
		
		
		if(ordine.getId() == (Integer) null)
			
			ordine.setId(indicatoreMappa);
		
		if (ordine.getId() != (Integer) null)
			
			indicatoreMappa = ordine.getId();
		indicatoreMappa ++;
			
		if(mappaOrdini.containsKey(ordine.getId()))
			
			throw new IdDuplicatedException("ATTENZIONE ! Esite già un altro ordine con lo stesso ID !");
		
	}
	

	@Override
	public Order selezionaId(int id) {
		if(!mappaOrdini.containsKey(id))
			throw new OrderNotFoundException("ATTENZIONE ! Nessun ordine con ID -> " + id);

		return mappaOrdini.get(id);
	}

	@Override
	public List<Order> mostraTuttiOrdini(){
		
		return new ArrayList<Order>(mappaOrdini.values());
	}

	@Override
	public Order rimuoviOrdine(int id) {
		
		if(!mappaOrdini.containsKey(id))
			throw new OrderNotFoundException("ATTENZIONE ! Non è possibile proseguire con la richiesta, ID INESISTENTE ->" + id);

		return mappaOrdini.remove(id);
	}
	

	@Override
	public void cambiaIdOrdine(int id, Status nuovoStatus) {
		
		selezionaId(id).setStatus(nuovoStatus);
	}
}
	
	
	
	
	
	
