package vlado.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.entity.Product;
import vlado.main.service.CategoryService;
import vlado.main.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/product-form")
	public String getAddProductForm(Model model) {
		
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.list());
		return "product-form";
	}
	
	@RequestMapping("/product-save")
	public String productSave(@ModelAttribute Product product) {
		
		productService.save(product);
		return "redirect:/product-list";
	}
	
	@RequestMapping("/product-list")
	public String productList(Model model) {
		
		model.addAttribute("products", productService.list());
		return "product-list";
	}
	
	@RequestMapping("/product-delete")
	public String productSave(@RequestParam int id) {
		
		productService.delete(id);
		return "redirect:/product-list";
	}
	
	@RequestMapping("/product-update")
	public String productUpdate(@RequestParam int id, Model model) {
		
		model.addAttribute("product", productService.getById(id));
		model.addAttribute("categories", categoryService.list());
		return "product-form";
	}
}
