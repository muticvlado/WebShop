package vlado.main.dao;

import java.util.List;

import vlado.main.entity.User;

public interface UserDAO {
	
	void save(User user);
	
	void addNew(User user);
	
	void delete(int user_number);
	
	List<User> list();
	
	User getByUserNumber(int user_number);
	
	User getUserByUsername(String username);
	
	int nextUserNumber();
	
	public void changePassword(String username, String oldPassword, String newPassword);
}
