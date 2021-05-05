package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.ProductDAO;
import vlado.main.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Override
	public void save(Product product) {
		
		productDAO.save(product);
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		productDAO.delete(id);
	}

	@Transactional
	@Override
	public List<Product> list() {
		
		return productDAO.list();
	}

	@Transactional
	@Override
	public Product getById(int id) {
		
		return productDAO.getById(id);
	}
}
