package com.example.loginspringboot.service;

import com.example.loginspringboot.component.CustomUserDetails;
import com.example.loginspringboot.entity.User;
import com.example.loginspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User Not Fount");
        }
        return new CustomUserDetails(user);
    }
}
