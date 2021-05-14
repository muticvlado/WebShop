package vlado.main.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Invoice;
import vlado.main.entity.Item;
import vlado.main.entity.Product;
import vlado.main.entity.User;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Invoice invoice) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(invoice);
	}

	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Invoice invoice = session.get(Invoice.class, id);
		session.delete(invoice);
	}

	@Override
	public List<Invoice> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Invoice> list = session.createQuery("from Invoice", Invoice.class).getResultList();
		return list;
	}

	@Override
	public Invoice getById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Invoice invoice = session.get(Invoice.class, id);
		Hibernate.initialize(invoice.getItems());
		
		return invoice;
	}
	
	@Override
	public Invoice getCart(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Invoice cart = null;
		
		try {
			cart = session
					.createQuery("Select i from Invoice i where i.user.username=:username and i.complete = 0", Invoice.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (NoResultException err) {
			
		}
		
		if(cart != null) {
			Hibernate.initialize(cart.getItems());
			if(cart.getItems() == null)
				cart.setItems(new ArrayList<Item>());			
		}		
		else if(cart == null) {
			cart = new Invoice();
			cart.setDate(new Date());
			User user = session
					.createQuery("from User where username=:username", User.class)
					.setParameter("username", username)
					.getSingleResult();
			cart.setUser(user);
			cart.setItems(new ArrayList<Item>());
			save(cart);
		}
		
		return cart;
	}

	@Override
	public boolean isItemExist(Product product, Invoice invoice) {
		
		List<Item> items = invoice.getItems();		
		for (Item item : items) {
			if(item.getProduct().getName().equalsIgnoreCase(product.getName()))
				return true;
		}
		return false;
	}

	@Override
	public void addOne(Product product, Invoice invoice) {
		
		List<Item> items = invoice.getItems();		
		for (Item item : items) {
			if(item.getProduct().getName().equalsIgnoreCase(product.getName())) {
				item.setQuantity(item.getQuantity() + 1);
				break;
			}
		}
	}

	@Override
	public double getTotal(Invoice cart) {
		
		double total = 0;
		List<Item> items = cart.getItems();
		for (Item item : items) {
			total += item.getPrice()*item.getQuantity();
		}		
		return total;
	}

	@Override
	public void completeOrder(int invoice_id) {
		
		Session session = sessionFactory.getCurrentSession();
		Invoice cart = session.get(Invoice.class, invoice_id);
		cart.setComplete(true);	
		cart.setAmount(getTotal(cart));
	}

	@Override
	public List<Invoice> listByUser(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		List<Invoice> invoices = session.createQuery("Select i from Invoice i where i.user.username=:username and i.complete = 1", Invoice.class)
				.setParameter("username", username)
				.getResultList();
		return invoices;
	}
}
