package com.itn.TutorialApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CombinedUserDetailService implements UserDetailsService {
    private final MyUserDetailService userService;
    private final AdminDetailService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return adminService.loadUserByUsername(username);
        }
    }
}