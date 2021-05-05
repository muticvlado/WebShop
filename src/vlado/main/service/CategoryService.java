package vlado.main.service;

import java.util.List;

import vlado.main.entity.Category;

public interface CategoryService {
	
	void save(Category category);
	
	void delete(int id);
	
	List<Category> list();
	
	Category getById(int id);
}
