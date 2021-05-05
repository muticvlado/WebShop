package vlado.main.dao;

import java.util.List;

import vlado.main.entity.Category;

public interface CategoryDAO {

	void save(Category category);
	
	void delete(int id);
	
	List<Category> list();	
	
	Category getById(int id);
}
