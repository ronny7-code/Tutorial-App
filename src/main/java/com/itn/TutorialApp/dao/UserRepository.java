package com.itn.TutorialApp.dao;

import com.itn.TutorialApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}