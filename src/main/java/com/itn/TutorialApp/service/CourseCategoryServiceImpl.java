package com.itn.TutorialApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itn.TutorialApp.dao.CourseCategoryRepository;
import com.itn.TutorialApp.entity.CourseCategory;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService{
	
	@Autowired
	private CourseCategoryRepository categoryRepository;

	@Override
	public void saveCourseCategory(CourseCategory category) {
		categoryRepository.save(category);
	}
	@Override
	public List<CourseCategory> findAllCourseCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<CourseCategory> findCourseCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public CourseCategory updateCourseCategory(Long courseId, CourseCategory updatedCategory) {
	    CourseCategory oldCategory = categoryRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("CourseCategory not found with id: " + courseId));

	    oldCategory.setName(updatedCategory.getName());
	    oldCategory.setDescription(updatedCategory.getDescription());

	    return categoryRepository.save(oldCategory);
	}

	@Override
	public void deleteCourseCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}