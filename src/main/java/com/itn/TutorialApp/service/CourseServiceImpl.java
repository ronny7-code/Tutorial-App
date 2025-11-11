package com.itn.TutorialApp.service;

import com.itn.TutorialApp.dao.CourseRepository;
import com.itn.TutorialApp.entity.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
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
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Course oldcourse = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        oldcourse.setName(updatedCourse.getName());
        oldcourse.setType(updatedCourse.getType());
        oldcourse.setDescription(updatedCourse.getDescription());
        return courseRepository.save(oldcourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}