package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//Common data include in all Handler using this method. ModelAttribute is used to add common data in every handler
	@ModelAttribute
	public void commomData(Model model,Principal principal) {
		//Principal paramter is used to get the username from Spring security login page.
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		System.out.println(user);
				
		model.addAttribute("user",user);
	}
	
	//User Dashboard Handler
	@RequestMapping("/index")
	public String dashboard(Model model) {
		model.addAttribute("title","User Dashboard");
		return "normal/user_dashboard";
	}
	
	//open add form handler
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact",new Contact());
		
		return "normal/add_contact_form";
	}
	
	
}
