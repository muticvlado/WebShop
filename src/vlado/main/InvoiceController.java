package vlado.main;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.entity.Invoice;
import vlado.main.entity.Product;
import vlado.main.service.InvoiceService;
import vlado.main.service.ProductService;
import vlado.main.service.UserService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/catalog")
	public String getCatalog(Principal principal, Model model) {
		
		model.addAttribute("user", userService.getByUserName(principal.getName()));
		model.addAttribute("products", productService.list());
		model.addAttribute("total", invoiceService.getTotal(invoiceService.getCart(principal.getName())));
		return "catalog";
	}
	
	@RequestMapping("/")
	public String getCatalogIndex(Model model) {
		
		model.addAttribute("products", productService.list());
		return "catalog-index";
	}
	
	@RequestMapping("/product-add-to-cart")
	public String addToCart(Principal principal, @RequestParam int product_id) {
		
		Product p = productService.getById(product_id);		
		invoiceService.addToCart(p, principal.getName());
		
		return "redirect:/catalog";
	}
	
	@RequestMapping("/cart")
	public String getCart(Principal principal, Model model) {
		
		model.addAttribute("user", userService.getByUserName(principal.getName()));
		Invoice cart = invoiceService.getCart(principal.getName());
		model.addAttribute("cart", cart);
		model.addAttribute("total", invoiceService.getTotal(cart));
		return "cart";
	}
	
	@RequestMapping("/order-save")
	public String orderSave(@RequestParam int cart_id) {
		
		invoiceService.completeOrder(cart_id);			
		return "buying-confirmation";
	}
	
	@RequestMapping("/invoice-list")
	public String invoiceList(Model model, Principal principal) {
		
		model.addAttribute("user", userService.getByUserName(principal.getName()));
		model.addAttribute("invoices", invoiceService.list());
		return "invoice-list";
	}
	
	@RequestMapping("/user-invoice-list")
	public String userInvoiceList(Model model, Principal principal) {
		
		model.addAttribute("user", userService.getByUserName(principal.getName()));
		model.addAttribute("invoices", invoiceService.listByUsername(principal.getName()));
		return "invoice-list";
	}	
	
	@RequestMapping("/invoice-details")
	public String getInvoice(@RequestParam int id, Model model) {
		
		Invoice invoice = invoiceService.getById(id);
		model.addAttribute("invoice", invoice);
		model.addAttribute("total", invoiceService.getTotal(invoice));
		return "invoice-details";
	}
	
}
