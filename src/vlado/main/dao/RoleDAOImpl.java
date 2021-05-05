package vlado.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vlado.main.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> list() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = session.createQuery("from Role", Role.class).getResultList();
		return roles;
	}
	

}
