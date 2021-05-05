package vlado.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		int user_number = nextUserNumber();
		user.setUser_number(user_number);
		session.saveOrUpdate(user);
	}

	@Override
	public void delete(int user_number) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session
				.createQuery("from User where user_number =: user_number", User.class)
				.setParameter("user_number", user_number)
				.getSingleResult();
		session.delete(user);
	}

	@Override
	public List<User> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User", User.class).getResultList();
		return list;
	}

	@Override
	public User getByUserNumber(int user_number) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session
				.createQuery("from User where user_number =: user_number", User.class)
				.setParameter("user_number", user_number)
				.getSingleResult();
		return user;
	}

	
	@Override
	public int nextUserNumber() {

		Session session = sessionFactory.getCurrentSession();
		
		long count = (long)session.createQuery("Select count(username) from User").getSingleResult();
		if(count == 0)
			return 1;
		
		return (int)session.createQuery("Select max(user_number) from User").getSingleResult() + 1;
	}
}
