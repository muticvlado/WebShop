package vlado.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);		
	}

	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		session.delete(product);		
	}

	@Override
	public List<Product> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("from Product", Product.class).getResultList();
		return list;
	}

	@Override
	public Product getById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		return product;
	}

}
