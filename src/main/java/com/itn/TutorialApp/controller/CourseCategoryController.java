package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.CourseCategory;
import com.itn.TutorialApp.service.CourseCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("courseCategory")
    public String getCourseCategoryForm(){
        return "admin/CourseCategory";
    }

    @PostMapping("/submitCourseCategory")
    public String getCourseCategory(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            Model model) {

        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setName(name);
        courseCategory.setDescription(description);

        boolean success = courseCategoryService.saveCourseCategory(courseCategory);

        if (success) {
            model.addAttribute("successMsg", "Course Category Added Successfully!");
        } else {
            model.addAttribute("errorMsg", "Course Category cannot be Added!");
        }

        return "admin/CourseCategory";
    }

}