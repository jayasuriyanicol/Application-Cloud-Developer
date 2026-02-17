package com.spring.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

/* * OrderCreateRequestDTO - Inbound Order Payload
    ? A specialized Data Transfer Object designed to capture the initial customer intent. It acts as the entry point for new orders, carrying only the essential data required for the system to begin validation and processing.

    ! 1. Focused Input, unlike the comprehensive 'OrderResponseDTO', this class only contains a list of products and quantities. It excludes system-generated fields like IDs, timestamps, and totals, ensuring the client cannot artificially inject unauthorized data during creation.
    ! 2. Collection Initialization, the default constructor ensures that `listaProdottiOrdinati` is initialized as an empty `ArrayList`. This prevents potential `NullPointerExceptions` when the Service layer attempts to stream or iterate through the request items.
    ! 3. DTO Nesting, utilizes a list of `OrderItemDTO` to create a hierarchical request structure. This allows the API to process multi-item orders in a single transactional request, mapping cleanly to the relational structure of the backend entities.
*/

public class OrderCreateRequestDTO {

    
   
    private List<OrderItemDTO> listaProdottiOrdinati;

    
    public OrderCreateRequestDTO() {
        this.listaProdottiOrdinati = new ArrayList<>();
    }

   
    public OrderCreateRequestDTO(List<OrderItemDTO> listaProdottiOrdinati) {
        this.listaProdottiOrdinati = listaProdottiOrdinati;
    }

    
    public List<OrderItemDTO> getListaProdottiOrdinati() {
        return listaProdottiOrdinati;
    }

    
    public void setListaProdottiOrdinati(List<OrderItemDTO> listaProdottiOrdinati) {
        this.listaProdottiOrdinati = listaProdottiOrdinati;
    }
}