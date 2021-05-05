package vlado.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Category category) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}

	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		session.delete(category);
	}

	@Override
	public List<Category> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Category> list = session.createQuery("from Category", Category.class).getResultList();
		return list;
	}

	@Override
	public Category getById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		return category;
	}
}
