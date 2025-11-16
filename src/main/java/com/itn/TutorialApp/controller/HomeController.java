package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.User;
import com.itn.TutorialApp.entity.UserRole;
import com.itn.TutorialApp.service.CourseService;
import com.itn.TutorialApp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({"/", "/home"})
	public String getHomePage(Model model) {
		model.addAttribute("courseList", courseService.findAllCourse());
		return "index";
	}

	@GetMapping("/login")
	public String getLoginPage(){
		return "login";
	}

	@GetMapping("/signup")
	public String getRegisterPage(Model model){
		model.addAttribute("courseList", courseService.findAllCourse());
		return "register";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute User user){
		user.setActive("1"); // 1 - means enable 0 means disable
		UserRole userRole = new UserRole();
		userRole.setRole("USER");
		userRole.setUser(user);

		user.setUserRole(userRole);

		if(user.getPassword().equals(user.getCPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.addUser(user);
		}
		else{
			throw new IllegalArgumentException("Password is not matching");
		}
		// Calling user service method to save user
		return "redirect:/login?success=true";
	}

	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/user/profile")
	public String getUserProfile(){
		return "profile";
	}

	@GetMapping("/welcome")
	public String getAdminHome(Authentication authentication){

		String authority = authentication.getAuthorities().toString();

		if(authority.contains("ADMIN")){
			return "redirect:/admin/home";
		}
		else if(authority.contains("TUTOR")){
			return "redirect:/tutor/home";
		}
		else{
			return "redirect:/user/profile";
		}
	}

}