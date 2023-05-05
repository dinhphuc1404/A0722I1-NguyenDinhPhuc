package com.example.case_study.repository.service;

import com.example.case_study.repository.employee.IRoleRepository;
import com.example.case_study.repository.employee.IUserRepository;
import com.example.case_study.entity.Role;
import com.example.case_study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository userRepositories;

    @Autowired
    IRoleRepository roleRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositories.findByUsername(username);
        if(username==null){
            throw new UsernameNotFoundException("User " + username + " was not found");
        }

        List<Role> roles = userRepositories.findAllRoleByUsername(username);
        List<String> roleNames = new ArrayList<>();
        for(Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(roles!=null){
            for(String roleName : roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(authority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
