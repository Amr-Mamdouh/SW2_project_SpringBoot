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
	
	
	@PostMapping("/TeachertLogin")
	public ModelAndView TeacherLogin
	(@ModelAttribute Account account,
	 Model model
	)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		//mv.addObject("result", num1 + num2);
		return mv;
	}

	@GetMapping("/addstudent")
	public String StudentForm(Model model)
	{
		model.addAttribute("stuendt",new Student());
		return "regitration";
	}
	@PostMapping("/addstudent")
	public String Studentsubmit(@ModelAttribute Student student, Model model)
	{
		student.createstudent(student.getName(), student.getE_mail(), student.getPass(),student.getGender(), student.getPhone(), student.getAge());
		model.addAttribute("profile","");
		return "profile";
	}
	@GetMapping("/addteacher")
	public String TeacherForm(Model model)
	{
		model.addAttribute("stuendt",new Teacher());
		return "regitration";
	}
	@PostMapping("/addTeacher")
	public String Teachersubmit(@ModelAttribute Teacher teacher, Model model)
	{
		teacher.createTeacher(teacher.getName(), teacher.getE_mail(), teacher.getPass(),teacher.getGender(), teacher.getPhone(), teacher.getAge());
		model.addAttribute("profile","");
		return "profile";
	}
	
	
	@GetMapping("/addCourse")
	public String CourseForm(Model model)
	{
		model.addAttribute("Course",new Course());
		return "regitration";
	}
	@PostMapping("/addCourse")
	public String CreateCourse(@ModelAttribute Course course, Model model) 
	{
		course.addCourse(course.getT_id());
		model.addAttribute("profile","");
		return "profile";
	}
	
	
	@GetMapping("/addGame")
	public String GameForm(Model model)
	{
		model.addAttribute("Game",new game());
		return "regitration";
	}
	@PostMapping("/addGame")
	public String GameCreate(@ModelAttribute game ga, Model model)
	{
		ga.creategame(ga.getG_name(), ga.getG_description(),ga.getC_id(),ga.getT_id(),ga.getG_category());
		model.addAttribute("profile","");
		return "profile";
	}
}
