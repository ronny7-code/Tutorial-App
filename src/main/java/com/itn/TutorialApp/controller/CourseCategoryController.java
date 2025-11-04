package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.CourseCategory;
import com.itn.TutorialApp.service.CourseCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("/admin/submitCourseCategory")
    public String getCourseCategory(@ModelAttribute CourseCategory courseCategory,Model model) {
        boolean success = courseCategoryService.saveCourseCategory(courseCategory);
        if (success) {
            model.addAttribute("successMsg", "Course Category Added Successfully!");
        } else {
            model.addAttribute("errorMsg", "Course Category cannot be Added!");
        }
        return "admin/CourseCategory";
    }
}
