package vlado.main.service;

import java.util.List;

import vlado.main.entity.Item;

public interface ItemService {

	void save(Item item);
	
	void delete(int id);
	
	List<Item> list();	
	
	Item getById(int id);
	
	void addOne(int item_id);
	
	void removeOne(int item_id);
}
