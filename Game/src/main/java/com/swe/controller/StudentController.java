package com.swe.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.Account;
import Model.Comment;
import Model.Course;
import Model.Notification;
import Model.Student;
import Model.Teacher;
import Model.game;
@Controller
@RequestMapping("/Studnet")
public class StudentController {
	
	// function use to take the student data from the login page to check if he is a member in the system or not 
	@PostMapping("/StudentLogin/")
	public ModelAndView StudentLogin
	(@ModelAttribute Account account,Model model)
	{
		System.out.println("addd Student");
		System.out.println(account.getUsername());
		System.out.println(account.getPassword());
		int c=account.Studentlogin();
		System.out.println("C"+c);
		ModelAndView mv = new ModelAndView();
//		if(c==-1)
//		{
//		//mv.setViewName("Error");
//		return "error";
//		}
		//else{
	mv.setViewName("MyProfile");
	model.addAttribute("profile","MY Name is Amr");
	mv.addObject("Profile","Welcome to your Page");
		return mv;
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
	@RequestMapping("/AddComment")
	public String AddComment(Model model)
	{
		return "WriteComment";
	}
	
	@RequestMapping("/AddComment/")
	public String viewResult
	(@RequestParam("S_ID") int S_ID,
	 @RequestParam("G_ID") int G_ID,
	 @RequestParam("T_ID") int T_ID,
	 @RequestParam("comment") String com,
	 Model model
	){
		Comment c=new Comment();
		c.AddStudentComment(com, S_ID,G_ID ,T_ID);
		return "MyProfile";
	}
	@RequestMapping("/GetNotification")
	public String GetNotification(@RequestParam("S_ID") int S_ID,Model model)
	{
		Notification n=new Notification();
	ArrayList<String>not=n.getTeacherNotification(S_ID);
	model.addAttribute("Notification",not);
		return "MyNotification";
	}
}
