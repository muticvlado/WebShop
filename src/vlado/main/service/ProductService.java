package vlado.main.service;

import java.util.List;

import vlado.main.entity.Product;

public interface ProductService {
	
	void save(Product product);
	
	void delete(int id);
	
	List<Product> list();	
	
	Product getById(int id);
}
