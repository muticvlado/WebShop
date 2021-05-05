package vlado.main.dao;

import java.util.List;

import vlado.main.entity.Product;

public interface ProductDAO {

	void save(Product product);
	
	void delete(int id);
	
	List<Product> list();	
	
	Product getById(int id);
}
