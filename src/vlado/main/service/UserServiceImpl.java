package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.UserDAO;
import vlado.main.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void save(User user) {
		
		userDAO.save(user);
	}

	@Transactional
	@Override
	public void delete(int user_number) {
		
		userDAO.delete(user_number);
	}

	@Transactional
	@Override
	public List<User> list() {
	
		List<User> list = userDAO.list();
		return list;
	}

	@Transactional
	@Override
	public User getByUserNumber(int user_number) {
		
		return userDAO.getByUserNumber(user_number);
	}

	@Transactional
	@Override
	public int nextUserNumber() {
		
		return userDAO.nextUserNumber();
	}
}
