package vlado.main.dao;

import java.util.List;

import vlado.main.entity.Invoice;
import vlado.main.entity.Product;

public interface InvoiceDAO {

	void save(Invoice invoice);
	
	void delete(int id);
	
	List<Invoice> list();	
	
	Invoice getById(int id);
	
	Invoice getCart(String username);
	
	boolean isItemExist(Product product, Invoice invoice);
	
	void addOne(Product product, Invoice invoice);
	
	double getCartTotal(Invoice cart);
}
