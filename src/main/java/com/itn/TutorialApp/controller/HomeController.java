package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.User;
import com.itn.TutorialApp.entity.UserRole;
import com.itn.TutorialApp.service.CourseService;
import com.itn.TutorialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@GetMapping({"/", "/home"})
	public String getHomePage(Model model) {
		model.addAttribute("courseList", courseService.findAllCourse());
		return "index";
	}

	@GetMapping("/user/login")
	public String getLoginPage(){
		return "login";
	}

	@GetMapping("/user/signup")
	public String getRegisterPage(Model model){
		model.addAttribute("courseList", courseService.findAllCourse());
		return "register";
	}

	@PostMapping("/user/signup")
	public String signup(@ModelAttribute User user){
		user.setActive("1"); // 1 means enable 0 means disable
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUser(user);

		user.setUserRole(userRole);

		userService.addUser(user);

		// Calling user service method to save user
		return "redirect:/user/login";
	}
}