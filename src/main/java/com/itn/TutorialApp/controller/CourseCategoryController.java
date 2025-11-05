package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.CourseCategory;
import com.itn.TutorialApp.service.CourseCategoryService;
import org.springframework.stereotype.Controller;
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
            @RequestParam("description") String description) {

        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setName(name);
        courseCategory.setDescription(description);

       courseCategoryService.saveCourseCategory(courseCategory);

    

        return "admin/CourseCategory";
    }

}