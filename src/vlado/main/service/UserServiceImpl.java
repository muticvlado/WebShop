package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Transactional
	@Override
	public void registration(User user) {
		
		String passwordEncode = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword("{bcrypt}" + passwordEncode);
		userDAO.save(user);		
	}
	
	@Transactional
	@Override
	public void enableOrDisable(int user_number) {
		
		User user = userDAO.getByUserNumber(user_number);
		user.setEnabled(!user.getEnabled());
		userDAO.save(user);		
	}

	@Transactional
	@Override
	public void saveProfil(User user) {
		
		User userEdit = userDAO.getByUserNumber(user.getUser_number());
		
		userEdit.setName(user.getName());
		userEdit.setSurname(user.getSurname());
		userEdit.setAdress(user.getAdress());
		userEdit.setEmail(user.getEmail());
		userEdit.setPhone(user.getPhone());		
	}
}
