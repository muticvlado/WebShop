package vlado.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.entity.Category;
import vlado.main.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/category-form")
	public String getAddCategoryForm(Model model) {
		
		model.addAttribute("category", new Category());
		return "category-form";
	}
	
	@RequestMapping("/category-save")
	public String categorySave(@ModelAttribute Category category) {
		
			categoryService.save(category);
			return "redirect:/category-list";
	}
	
	@RequestMapping("/category-list")
	public String getCategoryList(Model model) {
		
		model.addAttribute("categories", categoryService.list());
		return "category-list";
	}
	
	@RequestMapping("/category-delete")
	public String categoryDelete(@RequestParam int id) {
		
		categoryService.delete(id);
		return "redirect:/category-list";
	}
	
	@RequestMapping("/category-update")
	public String getUpdateCategoryForm(@RequestParam int id, Model model) {
		
		Category category = categoryService.getById(id);
		model.addAttribute("category", category);
		return "category-form";
	}
}
