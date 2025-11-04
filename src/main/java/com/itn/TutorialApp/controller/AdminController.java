package com.itn.TutorialApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/home")
	public String adminDashboard() {
		return "admin/dashboard";
	}
}