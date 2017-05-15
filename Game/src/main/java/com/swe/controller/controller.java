
package com.swe.controller;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Model.Account;
import Model.game;
@Controller
@RequestMapping("/Game")
public class controller {
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/result")
	public ModelAndView viewResult
	(@RequestParam("num1") int num1,
	 @RequestParam("num2") int num2,
	 Model model
	){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("result", num1 + num2);
		return mv;
	}

	@GetMapping("/login")
	public String index(Model model){
		model.addAttribute("Account",new Account());
		return "LoginPage";
	}
	@RequestMapping()
	public String getTeacherdata()
	{
		JSONArray arr=new JSONArray();
		//arr.p
		return null;
	}
	
	@RequestMapping("/Courses")
	public  ModelAndView getCourese() throws JSONException
			{
				game g=new game();
				 ArrayList<String> gam=g.getcourse();
				 String S="";
				 for (int i=0;i<gam.size();i+=2)
				 {
					 S=S+gam.get(i)+"-"+gam.get(i+1)+"*";
				 }
				 JSONObject j=new JSONObject(); 
				j.put("Courses", S);
				ModelAndView m=new ModelAndView();
				m.setViewName("Courses");
				m.addObject("Courses",j.toString());
				return m;
				
			}
	@RequestMapping("/Games/{number}")
	public  ModelAndView getGames(@PathVariable int number) throws JSONException
			{
				game g=new game();
				 ArrayList<String> gam=g.getgames(number);
				 String S="";
				 for (int i=0;i<gam.size();i+=2)
				 {
					 S=S+gam.get(i)+"-"+gam.get(i+1);
				 }
				 JSONObject j=new JSONObject();
				j.put("Courses", S);
				ModelAndView m=new ModelAndView();
				m.setViewName("Courses");
				m.addObject("Courses",j.toString());
				return m;
				
			}
	
	
	
	
	
	
		
	
}
