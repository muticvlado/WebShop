package vlado.main.service;

import java.util.List;

import vlado.main.entity.User;

public interface UserService {
	
	void save(User user);
	
	void saveProfil(User user);
	
	void delete(int user_number);
	
	List<User> list();
	
	User getByUserNumber(int user_number);

	User getByUserName(String username);
	
	int nextUserNumber();
	
	void registration(User user);
	
	void enableOrDisable(int user_number);
	
}
