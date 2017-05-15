package com.swe.controller;
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
	@RequestMapping("/StudentLogin/")
	public String StudentLogin
	(@ModelAttribute Account account,
	 Model model
	)
	{
		System.err.println("addd Student");
		System.err.println(account.getUsername());
		System.err.println(account.getPassword());
		int c=account.Studentlogin();
		System.err.println("C"+c);
		//ModelAndView mv = new ModelAndView();
//		if(c==-1)
//		{
//		//mv.setViewName("Error");
//		return "error";
//		}
		//else{
		//mv.setViewName("profile");
	model.addAttribute("profile","MY Name is Amr");
		return "MyProfile";
		//}
	}
	@GetMapping("/addstudent")
	public String StudentForm(Model model)
	{
		model.addAttribute("stuendt",new Student());
		return "AddGame";
	}
	@PostMapping("/addstudent")
	public String Studentsubmit(@ModelAttribute Student student, Model model)
	{
		student.createstudent(student.getName(), student.getE_mail(), student.getPass(),student.getGender(), student.getPhone(), student.getAge());
		model.addAttribute("profile","");
		return "profile";
	}
}
