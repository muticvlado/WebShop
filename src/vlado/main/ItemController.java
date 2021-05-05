package vlado.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemSevice;
	
	@RequestMapping("/add-one")
	public String addOne(@RequestParam int item_id) {
		
		itemSevice.addOne(item_id);
		return "redirect:/cart";
	}
	
	@RequestMapping("/remove-one")
	public String removeOne(@RequestParam int item_id) {
		
		itemSevice.removeOne(item_id);
		return "redirect:/cart";
	}
	
	@RequestMapping("/delete-item")
	public String delete(@RequestParam int item_id) {
		
		itemSevice.delete(item_id);
		return "redirect:/cart";
	}
}
