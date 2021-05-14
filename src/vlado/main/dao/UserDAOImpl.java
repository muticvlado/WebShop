package vlado.main.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Role;
import vlado.main.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		if(user.getUser_number() == 0) {
			int user_number = nextUserNumber();
			user.setUser_number(user_number);
			String passwordEncode = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword("{bcrypt}" + passwordEncode);
		}
		
		session.saveOrUpdate(user);
	}
	
	@Override
	public void addNew(User user) {
		
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
		Hibernate.initialize(user.getAuthorities());
		for (Role role : user.getAuthorities()) {
			System.out.println("ROLA USERA JE: " + role.getAuthority());
		}
		
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

	@Override
	public User getUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session
				.createQuery("From User where username=:username", User.class)
				.setParameter("username", username)
				.getSingleResult();		
		return user;
	}

	@Override
	public void changePassword(String username, String oldPassword, String newPassword) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = this.getUserByUsername(username);
		String dbPassword = user.getPassword();		
		
		if(encoder.matches(dbPassword, oldPassword)) {
			
			newPassword = encoder.encode(newPassword);
			user.setPassword(newPassword);			
		}
	}
}
