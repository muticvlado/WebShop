package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.ItemDAO;
import vlado.main.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	@Transactional
	@Override
	public void save(Item item) {
		
		itemDAO.save(item);
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		itemDAO.delete(id);
	}

	@Transactional
	@Override
	public List<Item> list() {
		
		return itemDAO.list();
	}

	@Transactional
	@Override
	public Item getById(int id) {
		
		return itemDAO.getById(id);
	}

	@Transactional
	@Override
	public void addOne(int item_id) {
		
		itemDAO.addOne(item_id);		
	}

	@Transactional
	@Override
	public void removeOne(int item_id) {
		
		itemDAO.removeOne(item_id);		
	}
}
