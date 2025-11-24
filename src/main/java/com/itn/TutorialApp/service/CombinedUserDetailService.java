package com.itn.TutorialApp.service;

import com.itn.TutorialApp.dao.AdminRepository;
import com.itn.TutorialApp.dao.UserRepository;
import com.itn.TutorialApp.entity.Admin;
import com.itn.TutorialApp.entity.AdminDetail;
import com.itn.TutorialApp.entity.User;
import com.itn.TutorialApp.entity.UserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CombinedUserDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // try user first
        User user = userRepository.findUserByUsername(username);
        if (user != null) return new UserDetail(user);

        // then admin
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) return new AdminDetail(admin.getUsername(), admin.getPassword(),
                (admin.getAdminRole() != null) ? admin.getAdminRole().getRole() : "ADMIN");

        throw new UsernameNotFoundException("User/Admin not found: " + username);
    }


}