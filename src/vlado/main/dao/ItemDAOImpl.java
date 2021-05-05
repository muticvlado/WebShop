package vlado.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Item item) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
	}

	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, id);
		session.delete(item);
	}

	@Override
	public List<Item> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Item> list = session.createQuery("from Item", Item.class).getResultList();
		return list;
	}

	@Override
	public Item getById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, id);
		return item;
	}

	@Override
	public void addOne(int item_id) {
		
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, item_id);
		if(item != null)
			item.setQuantity(item.getQuantity() + 1);
	}

	@Override
	public void removeOne(int item_id) {
		
		Session session = sessionFactory.getCurrentSession();
		Item item = session.get(Item.class, item_id);
		if(item != null) {
			double quantity = item.getQuantity();
			if(quantity > 0)
				item.setQuantity(item.getQuantity() - 1);
		}
	}
}
