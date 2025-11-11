package com.itn.TutorialApp.service;

import com.itn.TutorialApp.dao.CourseRepository;
import com.itn.TutorialApp.entity.Course;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public void saveCourse(Course category) {
        courseRepository.save(category);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Course oldcourse = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        oldcourse.setName(updatedCourse.getName());
        oldcourse.setDescription(updatedCourse.getDescription());
        oldcourse.setCourseCategory(updatedCourse.getCourseCategory());

        return courseRepository.save(oldcourse);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}