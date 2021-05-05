package vlado.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.entity.Invoice;
import vlado.main.entity.Product;
import vlado.main.service.InvoiceService;
import vlado.main.service.ProductService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/catalog")
	public String getCatalog(Model model) {
		
		model.addAttribute("products", productService.list());
		model.addAttribute("total", invoiceService.getCartTotal(invoiceService.getCart("vlado")));
		return "catalog";
	}
	
	@RequestMapping("/product-add-to-cart")
	public String addToCart(@RequestParam int product_id) {
		
		Product p = productService.getById(product_id);		
		invoiceService.addToCart(p, "vlado");
		
		return "redirect:/catalog";
	}
	
	@RequestMapping("/cart")
	public String getCart(/*@RequestParam String username,*/ Model model) {
		
		Invoice cart = invoiceService.getCart("vlado");
		model.addAttribute("cart", cart);
		model.addAttribute("total", invoiceService.getCartTotal(cart));
		return "cart";
	}
}
