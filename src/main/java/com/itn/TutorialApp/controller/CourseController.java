package com.itn.TutorialApp.controller;

import com.itn.TutorialApp.entity.*;
import com.itn.TutorialApp.service.CourseCategoryService;
import com.itn.TutorialApp.service.CourseService;
import com.itn.TutorialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.UUID;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseCategoryService courseCategoryService;

    @Autowired
    private UserService userService;

    @GetMapping({"/admin/course/add", "/admin/course/show"})
    public String getCourseForm(Model model){
        model.addAttribute("courseList", courseService.findAllCourse());
        model.addAttribute("categoryList", courseCategoryService.findAllCourseCategories());
        return "admin/course";
    }

    @PostMapping("/admin/course/add")
    public String addCourse(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("category") CourseCategory category,
            @RequestParam("price") double price) {

        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setCourseCategory(category);
        course.setPrice(price);

        courseService.saveCourse(course);

        return "redirect:/admin/course/add?save=success";
    }

    @GetMapping("/admin/course/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model){
        Course course = courseService.findCourseById(id).orElseThrow();
        model.addAttribute("course", course);
        model.addAttribute("category_list", courseService.findAllCourse());
        model.addAttribute("categoryList", courseCategoryService.findAllCourseCategories());
        return "admin/course";
    }

    @PostMapping("/admin/course/update/{id}")
    public String updatingCourse(@PathVariable Long id,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("category") CourseCategory category,
                                 @RequestParam("price") double price){

        Course course = courseService.findCourseById(id)
                .orElseThrow();
        course.setName(name);
        course.setDescription(description);
        course.setCourseCategory(category);
        courseService.saveCourse(course);
        course.setPrice(price);
        return "redirect:/admin/course/add?update=success";
    }

    @GetMapping("/admin/course/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model){
        model.addAttribute("courseList", courseService.findAllCourse());
        model.addAttribute("categoryList", courseCategoryService.findAllCourseCategories());
        courseService.deleteCourse(id);
        return "redirect:/admin/course/add?delete=success";
    }

    // User course access
    @GetMapping("/user/course/{id}")
    public String showCourse(@PathVariable("id") Long id, Model model){
        Course course = courseService.findCourseById(id).orElse(new Course());
        model.addAttribute("course", course);
        model.addAttribute("courseList", courseService.findAllCourse());
        return "courseDetail";
    }

    @GetMapping("user/enroll/{id}")
    public String enrollCourse(@PathVariable("id") Long id, Principal principal){
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(userService.findByUsername(principal.getName()));
        enrollment.setCourse(courseService.findCourseById(id).orElse(new Course()));
        enrollment.setEnrollDate(LocalDate.now());
        enrollment.setStatus("PENDING");
        enrollment.setPayAmount("1000");
        enrollment.setPaymentMode("Esewa");
        enrollment.setEnrollEnds(LocalDate.now().plusYears(1));

        // Payment Model
        EsewaPayment esewaPayment = new EsewaPayment();
        esewaPayment.setAmount(100000L);
        esewaPayment.setFailureUrl("http://localhost:7777/user/enroll_payment/esewa?failure=true");
        esewaPayment.setSuccessUrl("http://localhost:7777/user/enroll_payment/esewa?success=true");
        esewaPayment.setProductCode("EPAYTEST");
        esewaPayment.setSignedFieldNames("total_amount,transaction_uuid,product_code");
        esewaPayment.setTransactionUUID(UUID.randomUUID()+"_E_LEARNING");
        return null;
    }
}