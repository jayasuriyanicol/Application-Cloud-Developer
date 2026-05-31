package com.spring.ecommerce.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ecommerce.entity.Product;
import com.spring.ecommerce.exception.ProductNotFoundException;

/* * ProductDAO - In-Memory Product Catalog
    ? An implementation of `ProductInterfaceDAO` that serves as the source of truth for the product inventory. It initializes a static catalog and provides methods to query and manipulate product availability.

    ! 1. Mock Data Initialization, the constructor acts as a data seeder, populating the `HashMap` with twenty distinct products. This ensures the application is immediately functional for testing and demonstration purposes without requiring a connected database.
    ! 2. Stock Mutation Logic, the `aggiornaIDStock` method provides a bridge for the `OrderService` to adjust inventory. By accepting the new stock as a `String` and leveraging the `Product` entity's internal parsing, it facilitates stock deductions when orders are confirmed.
    ! 3. Fail-Fast Validation, the `selezionaID` method implements immediate validation. By checking for `null` and throwing a specialized `ProductNotFoundException`, it ensures that invalid IDs do not propagate through the service layer, preventing downstream `NullPointerExceptions`.
*/


@Repository
public class ProductDAO implements ProductInterfaceDAO{


	private HashMap<Integer, Product> mappaProdotti = new HashMap<>();

	
	//Adding the classmate given product on the constructor, because we do not have MAIN
	
    public ProductDAO() {
    	
        mappaProdotti.put(1, new Product(1, "Laptop", "999.99", 10));
        mappaProdotti.put(2, new Product(2, "Smartphone", "699.99", 25));
        mappaProdotti.put(3, new Product(3, "Tablet", "399.99", 15));
        mappaProdotti.put(4, new Product(4, "Monitor 24\"", "179.99", 20));
        mappaProdotti.put(5, new Product(5, "Tastiera Meccanica", "89.99", 30));
        mappaProdotti.put(6, new Product(6, "Mouse Wireless", "39.99", 50));
        mappaProdotti.put(7, new Product(7, "Stampante", "149.99", 12));
        mappaProdotti.put(8, new Product(8, "Hard Disk 1TB", "59.99", 40));
        mappaProdotti.put(9, new Product(9, "SSD 500GB", "79.99", 35));
        mappaProdotti.put(10, new Product(10, "Webcam HD", "49.99", 18));
        mappaProdotti.put(11, new Product(11, "Cuffie Bluetooth", "99.99", 22));
        mappaProdotti.put(12, new Product(12, "Microfono USB", "69.99", 16));
        mappaProdotti.put(13, new Product(13, "Router WiFi", "89.99", 14));
        mappaProdotti.put(14, new Product(14, "Power Bank", "29.99", 60));
        mappaProdotti.put(15, new Product(15, "Smartwatch", "199.99", 27));
        mappaProdotti.put(16, new Product(16, "TV 55\"", "599.99", 8));
        mappaProdotti.put(17, new Product(17, "Console Gaming", "499.99", 6));
        mappaProdotti.put(18, new Product(18, "Controller Wireless", "59.99", 45));
        mappaProdotti.put(19, new Product(19, "Speaker Bluetooth", "79.99", 33));
        mappaProdotti.put(20, new Product(20, "Notebook 15\"", "849.99", 11));
    }
	
	
	
	@Override
	public Product selezionaID(int id) {
		Product prod = mappaProdotti.get(id);

		if (prod == null)
			throw new ProductNotFoundException("ATTENZIONE ! Nessun prodotto con ID -> " + id);

		return prod;
	}

	@Override
	
	public String selezionaIDStock(int idStock) {
		
		return selezionaID(idStock).getStock();
	}

	@Override
	public void aggiornaIDStock(int idStock, String nuovoStock) {
		selezionaID(idStock).setStock(nuovoStock);
	}
	
	
	@Override
	public List<Product> mostraTutto() {
		
		return new ArrayList<Product>(mappaProdotti.values());
	}
}
