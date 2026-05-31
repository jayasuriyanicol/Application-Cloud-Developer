package com.spring.ecommerce.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ecommerce.entity.Order;
import com.spring.ecommerce.entity.Status;
import com.spring.ecommerce.exception.OrderNotFoundException;

/* * OrderDAO - In-Memory Persistence Layer
    ? An implementation of `OrderInterfaceDAO` that utilizes a `HashMap` to simulate a database. It manages the storage, retrieval, and lifecycle state of orders during the application's runtime.

    ! 1. Thread-Safe ID Generation, uses a `synchronized` method for `aggiungiOrdine` and a manual counter (`indicatoreMappa`). This ensures that even with concurrent requests, each order receives a unique, incremental identifier without collisions.
    ! 2. Default State Injection, provides automated "fail-safe" logic for new entries. If an order arrives without a status or timestamp, the DAO automatically assigns `Status.CREATED` and the current `LocalDateTime`, ensuring data completeness before storage.
    ! 3. Reference-Based Updates, leverages Java's object reference behavior in the `cambiaIdOrdine` method. Since the `Order` object retrieved from the Map is a reference, modifying its status updates the "stored" version directly, eliminating the need for an explicit "replace" or "update" call.
*/

@Repository
public class OrderDAO implements OrderInterfaceDAO {
    

    private HashMap<Integer, Order> mappaOrdini = new HashMap<>();
    
    
    private int indicatoreMappa = 0;
    
    @Override
    public synchronized void aggiungiOrdine(Order ordine) {
        
        
        indicatoreMappa++; 
        int nuovoId = indicatoreMappa;

        
        ordine.setId(nuovoId);

        //If we have a product as 'NULL' we can associate default to Status CREATED
        if (ordine.getStatus() == null) {
            ordine.setStatus(Status.CREATED);
        }
        
       //Similiar to the other one if we have the problem 'Null' int creation time we associate the specific now LocalTimeDate 
        if (ordine.getCreatedAt() == null) {
            ordine.setCreatedAt(LocalDateTime.now());
        }
        
        //After all this check, we can associate the correct data into the HashMap
        mappaOrdini.put(nuovoId, ordine);
        
        System.out.println("SUCCESSO ! Ordine salvato correttamente con ID: " + nuovoId);
    }
    

    @Override
    public Order selezionaId(int id) {
    	
        if(!mappaOrdini.containsKey(id))
        	
            throw new OrderNotFoundException("ATTENZIONE ! Nessun ordine con ID -> " + id);

        return mappaOrdini.get(id);
    }

    @Override
    public List<Order> mostraTuttiOrdini(){
       
        return new ArrayList<>(mappaOrdini.values());
    }

    @Override
    public Order rimuoviOrdine(int id) {
    	
        if(!mappaOrdini.containsKey(id))
        	
            throw new OrderNotFoundException("ATTENZIONE ! Non è possibile proseguire con la richiesta, ID INESISTENTE ->" + id);

        return mappaOrdini.remove(id);
    }
    
    
    
    //In a HashMap, the object is stored aby reference, so changing 'order', also updates it within the map. There's no need to put it again.
    @Override
    public void cambiaIdOrdine(int id, Status nuovoStatus) {
       
        Order ordine = selezionaId(id);
        ordine.setStatus(nuovoStatus);
        
        
    }
}