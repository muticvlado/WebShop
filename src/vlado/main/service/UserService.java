package vlado.main.service;

import java.util.List;

import vlado.main.entity.User;

public interface UserService {
	
	void save(User user);
	
	void delete(int user_number);
	
	List<User> list();
	
	User getByUserNumber(int user_number);
	
	//-------------------------------------
	
	int nextUserNumber();
	
}
