package Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.Account;
import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.game;
@Controller
@RequestMapping("/Game")
public class controller {
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("Account",new Account());
		return "login";
	}
	
	
	
	
	
	
	
		
	
}
