package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.dao.AdminRepository;
import com.itn.TutorialApp.entity.Admin;
import com.itn.TutorialApp.entity.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/admin/home")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	@GetMapping("/admin/add")
	public String addNewAdmin() {
		return "admin/addAdmin";
	}

	@PostMapping("/admin/add")
	public String saveAdmin(@ModelAttribute Admin admin) {

		// 1️⃣ Validate password & confirm password
		if (!java.util.Objects.equals(admin.getPassword(), admin.getCPassword())) {
			throw new IllegalArgumentException("Password is not matching");
		}

		// 2️⃣ Assign Role
		AdminRole adminRole = new AdminRole();
		adminRole.setAdmin(admin);
		adminRole.setRole("ADMIN");

		admin.setAdminRole(adminRole);

		// 3️⃣ Encode password
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));

		// 4️⃣ Save admin
		adminRepository.save(admin);

		// 5️⃣ Redirect with success message
		return "redirect:/admin/add?success";
	}

}