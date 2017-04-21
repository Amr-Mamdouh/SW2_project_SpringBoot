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
@RequestMapping("/Studnet")
public class StudentController {
	// function use to take the student data from the login page to check if he is a member in the system or not 
	@PostMapping("/StudentLogin")
	public ModelAndView StudentLogin
	(@ModelAttribute Account account,
	 Model model
	)
	{
		int c=account.Studentlogin();
		ModelAndView mv = new ModelAndView();
		if(c==-1)
		{
		mv.setViewName("Error");
		return mv;
		}
		else{
		mv.setViewName("profile");
		mv.addObject("", num1 + num2);
		return mv;}
	}
}
