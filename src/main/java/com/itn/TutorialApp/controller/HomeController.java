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

@Controller
public class HomeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Home page
	@GetMapping({"/", "/home"})
	public String getHomePage(Model model) {
		model.addAttribute("courseList", courseService.findAllCourse());
		return "index";
	}

	// Login page
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		return "login";
	}

	// Registration page
	@GetMapping("/signup")
	public String getRegisterPage(Model model) {
		model.addAttribute("courseList", courseService.findAllCourse());
		return "register";
	}

	// User signup
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {

		// Safe password comparison to prevent NullPointerException
		if (!java.util.Objects.equals(user.getPassword(), user.getCPassword())) {
			throw new IllegalArgumentException("Password is not matching");
		}

		// Enable the user
		user.setActive("1"); // 1 = enabled, 0 = disabled

		// Assign default role
		UserRole userRole = new UserRole();
		userRole.setRole("USER");
		userRole.setUser(user);
		user.setUserRole(userRole);

		// Encode password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// Save user
		userService.addUser(user);

		// Redirect to login page with success
		return "redirect:/login?success";
	}

	// Logout user
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	// User profile page
	@GetMapping("/user/profile")
	public String getUserProfile(Authentication authentication, Model model) {

		if (authentication != null && authentication.isAuthenticated()) {
			// Get logged-in username (usually email or username)
			String username = authentication.getName();

			// Fetch full user info from DB
			User user = userService.findByUsername(username); // assuming you have this method
			if (user != null) {
				model.addAttribute("user", user);
			}
		}
		return "profile";
	}

	// Welcome page redirect based on role
	@GetMapping("/welcome")
	public String getAdminHome(Authentication authentication) {

		String authority = authentication.getAuthorities().toString();

		if (authority.contains("ADMIN")) {
			return "redirect:/admin/home";
		} else if (authority.contains("TUTOR")) {
			return "redirect:/tutor/home";
		} else {
			return "redirect:/user/profile";
		}
	}


}