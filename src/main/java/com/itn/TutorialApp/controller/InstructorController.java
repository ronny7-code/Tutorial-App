package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.Instructor;
import com.itn.TutorialApp.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Optional: show form separately (if needed)
    @GetMapping("/admin/instructor/add")
    public String showAddInstructorForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "admin/addInstructor"; // JSP page for adding instructor
    }

    // Handle form submission from admin dashboard
    @PostMapping("/admin/instructor/add")
    public String addInstructor(@ModelAttribute("instructor") Instructor instructor) {
        // Save instructor to DB
        instructorService.addInstructor(instructor);

        // Redirect back to admin dashboard or instructor list
        return "redirect:/admin/home?instructorAdded";
    }
}