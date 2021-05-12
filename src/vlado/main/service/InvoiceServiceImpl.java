package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.InvoiceDAO;
import vlado.main.entity.Invoice;
import vlado.main.entity.Item;
import vlado.main.entity.Product;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDAO invoiceDAO;
	
	@Transactional
	@Override
	public void save(Invoice invoice) {
		
		invoiceDAO.save(invoice);
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		invoiceDAO.delete(id);
	}

	@Transactional
	@Override
	public List<Invoice> list() {
		
		return invoiceDAO.list();
	}

	@Transactional
	@Override
	public Invoice getById(int id) {
		
		return invoiceDAO.getById(id);
	}

	@Transactional
	@Override
	public void addToCart(Product p, String username) {
		
		Invoice cart = invoiceDAO.getCart(username);
		
		if(!invoiceDAO.isItemExist(p, cart)) {
			Item item = new Item();
			item.setProduct(p);
			item.setInovice(cart);
			item.setPrice(p.getPrice());
			item.setQuantity(1);
			item.setTax(p.getTax());
			cart.getItems().add(item);
		}
		else {
			invoiceDAO.addOne(p, cart);
		}
	}

	@Transactional
	@Override
	public Invoice getCart(String username) {
		
		return invoiceDAO.getCart(username);
	}
	
	@Transactional
	@Override
	public double getCartTotal(Invoice cart) {
		
		return invoiceDAO.getCartTotal(cart);
	}

	@Transactional
	@Override
	public void completeOrder(int invoice_id) {
		
		invoiceDAO.completeOrder(invoice_id);		
	}

	@Transactional
	@Override
	public List<Invoice> listByUsername(String username) {
		
		return invoiceDAO.listByUser(username);
	}
}
