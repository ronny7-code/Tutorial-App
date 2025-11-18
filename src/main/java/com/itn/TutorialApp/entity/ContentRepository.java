package com.itn.TutorialApp.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}