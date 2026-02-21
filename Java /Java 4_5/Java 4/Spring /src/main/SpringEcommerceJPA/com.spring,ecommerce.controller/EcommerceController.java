package com.spring.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.service.EcommerceService;

/* * EcommerceController - Multi-Tenant Marketplace API
    ? A sophisticated REST controller managing the relationship between Sellers (Venditori) and their Catalog (Prodotti). It acts as the primary gateway for a marketplace ecosystem, handling sensitive operations like credential management and product inventory updates.

    ! 1. Hierarchical Resource Routing, implements a "Nested Resource" pattern where products are associated directly with a seller ID in the URI. This structure clearly defines the ownership relationship in the API, ensuring that product additions are contextually tied to the correct vendor.
    ! 2. Diverse HTTP Verb Strategy, demonstrates advanced REST principles by utilizing the full HTTP suite: `@PutMapping` for state-replacement tasks like password changes, and `@PatchMapping` for partial updates, specifically for fine-tuning inventory quantities without resubmitting the entire product object.
    ! 3. Security-Integrated Persistence, routes sensitive data (like passwords) through path variables and request bodies. This design allows the service layer to implement specific validation or hashing logic before persisting vendor data, maintaining a high standard of security for the e-commerce platform.
*/

@RestController
@RequestMapping(path = "/ecommerce")
public class EcommerceController {

    @Autowired
    private EcommerceService service;

    
    @PostMapping(path = "/venditore/{password}", consumes = "application/json", produces = "application/json")
    public void inserisciVenditore(@RequestBody VenditoreDTO dto, @PathVariable String password) {
         service.inserisciVenditore(dto, password);
    }

    
    @GetMapping(path = "/venditore/{id}", produces = "application/json")
    public VenditoreDTO visualizzaVendID(@PathVariable Integer id) {
        return service.visualizzaVendID(id);
    }

    
    @GetMapping(path = "/venditore/base/{id}", produces = "application/json")
    public VenditoreDTO visualizzaDatiVend(@PathVariable Integer id) {
        return service.visualizzaDatiVend(id);
    }

    
    @PutMapping(path = "/venditore/password/{id}/{nuovaPassword}", produces = "application/json")
    public VenditoreDTO modificaPassVend(@PathVariable Integer id, @PathVariable String nuovaPassword) {
        return service.modificaPassVend(id, nuovaPassword);
    }

    
    @PostMapping(path = "/prodotto/{idVenditore}/prodotto", consumes = "application/json")
    public void aggiungiProdottoVend(@PathVariable Integer idVenditore, @RequestBody ProdottoDTO prodotto) {
        service.aggiungiProdottoVend(idVenditore, prodotto);
    }

 
    @PatchMapping(path = "/prodotto/{idProdotto}/{nuovaQuantita}", produces = "application/json")
    public ProdottoDTO modificaQuantitàProd(@PathVariable Integer idProdotto, @PathVariable Integer nuovaQuantita) {
        return service.modificaQuantitàProd(idProdotto,nuovaQuantita);
    }
}