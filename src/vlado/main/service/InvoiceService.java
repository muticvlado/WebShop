package vlado.main.service;

import java.util.List;

import vlado.main.entity.Invoice;
import vlado.main.entity.Product;

public interface InvoiceService {

	void save(Invoice invoice);
	
	void delete(int id);
	
	List<Invoice> list();	
	
	List<Invoice> listByUsername(String username);
	
	Invoice getById(int id);
	
	//--------------------
	
	void addToCart(Product p, String username);
	
	Invoice getCart(String username);
	
	double getTotal(Invoice cart);
	
	void completeOrder(int invoice_id);
}
