package vlado.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.main.entity.User;
import vlado.main.service.RoleService;
import vlado.main.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/user-form")
	public String getAddUserForm(Model model) {
		
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.list());		
		return "user-form";
	}
	
	@RequestMapping("/user-form-registration")
	public String getAddUserFormReg(Model model) {
		
		model.addAttribute("user", new User());	
		return "user-form-registration";
	}
	
	@RequestMapping("/user-save")
	public String userSave(@ModelAttribute User user) {
		
		userService.save(user);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/user-save-profile")
	public String userSaveProfile(@ModelAttribute User user) {
		
		userService.saveProfil(user);
		return "redirect:/";
	}
	
	@RequestMapping("/user-registration")
	public String userReghistration(@ModelAttribute User user) {
		
		userService.registration(user);
		return "user-reg-confirmation";
	}
	
	@RequestMapping("/user-list")
	public String userList(Model model) {
		
		model.addAttribute("users", userService.list());
		return "user-list";
	}
	
	@RequestMapping("/user-delete")
	public String userDelete(@RequestParam int user_number) {
		
		userService.delete(user_number);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/user-update")
	public String getUpdateUserForm(@RequestParam int user_number, Model model) {
		
		User user = userService.getByUserNumber(user_number);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.list());		
		return "user-form";
	}
	
	@RequestMapping("/user-enable-disable")
	public String userEnableOrDisable(@RequestParam int user_number) {
		
		userService.enableOrDisable(user_number);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/user-form-profile")
	public String userProfile(@RequestParam int user_number, Model model) {
		
		model.addAttribute("user", userService.getByUserNumber(user_number));
		return "user-form-profile";
	}	
}
