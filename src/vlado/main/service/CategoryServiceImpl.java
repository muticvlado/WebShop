package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.CategoryDAO;
import vlado.main.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Transactional
	@Override
	public void save(Category category) {
		
		categoryDAO.save(category);
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		categoryDAO.delete(id);		
	}

	@Transactional
	@Override
	public List<Category> list() {
		
		return categoryDAO.list();
	}

	@Transactional
	@Override
	public Category getById(int id) {
		
		return categoryDAO.getById(id);
	}
}
