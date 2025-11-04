package com.itn.TutorialApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itn.TutorialApp.entity.CourseCategory;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long>{

}
