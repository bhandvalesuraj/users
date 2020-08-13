package com.example.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.User.Entity.User;
import com.example.User.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		System.out.println("********************** 111");
		List<User> userList = userService.listAll();
		model.addAttribute("userList", userList);
		System.out.println("********************** 222");
		return "index";
	}
	
	@RequestMapping("/new")
	public String showAddUser(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		
		userService.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editUser(@PathVariable(name="id") Long id) {
		
		ModelAndView mv = new ModelAndView("edit_user");
		
		User user = userService.get(id);
		mv.addObject("user", user);
		
		return mv;
	}
	
	@RequestMapping("delete/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) {
		
		userService.delete(id);
		
		return "redirect:/";
	}
}
