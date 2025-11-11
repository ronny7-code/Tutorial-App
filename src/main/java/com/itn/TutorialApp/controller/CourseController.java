package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.Course;
import com.itn.TutorialApp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping({"/admin/course/add", "/admin/course/show"})
    public String getCourseForm(Model model){
        model.addAttribute("courseList", courseService.findAllCourse());
        return "admin/course";
    }

    @PostMapping("/admin/course/add")
    public String addCourse(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("type") String type) {

        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setType(type);

        courseService.saveCourse(course);

        return "redirect:/admin/course/add?save=success";
    }

    @GetMapping("/admin/course/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model){
        Course course = courseService.findCourseById(id).orElseThrow();
        model.addAttribute("category", course);
        model.addAttribute("category_list", courseService.findAllCourse());
        return "admin/course";
    }

    @PostMapping("/admin/course/update/{id}")
    public String updatingCourse(@PathVariable Long id,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   @RequestParam("type") String type){

        Course course = courseService.findCourseById(id)
                .orElseThrow();
        course.setName(name);
        course.setDescription(description);
        course.setType(type);
        courseService.saveCourse(course);
        return "redirect:/admin/course/add?update=success";
    }

    @GetMapping("/admin/course/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model){
        courseService.deleteCourse(id);
        return "redirect:/admin/course/add?delete=success";
    }
}