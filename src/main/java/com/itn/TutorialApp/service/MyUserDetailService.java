package com.itn.TutorialApp.service;

import com.itn.TutorialApp.dao.UserRepository;
import com.itn.TutorialApp.entity.User;
import com.itn.TutorialApp.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found with username: "+ username);
        }
        return new UserDetail(user);
    }
}