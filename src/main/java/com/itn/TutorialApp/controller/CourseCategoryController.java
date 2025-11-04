package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.CourseCategory;
import com.itn.TutorialApp.service.CourseCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("courseCategory")
    public String getCourseCategoryForm(Model model){
        model.addAttribute("courseCategory", new CourseCategory());
        return "admin/CourseCategory";
    }

    @PostMapping("/submitCourseCategory")
    public String getCourseCategory(@ModelAttribute("courseCategory") CourseCategory courseCategory, Model model) {
        boolean success = courseCategoryService.saveCourseCategory(courseCategory);
        if (success) {
            model.addAttribute("successMsg", "Course Category Added Successfully!");
        } else {
            model.addAttribute("errorMsg", "Course Category cannot be Added!");
        }
        return "courseCategory";
    }
}