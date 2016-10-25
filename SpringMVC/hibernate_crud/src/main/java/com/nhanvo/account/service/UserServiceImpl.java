package com.nhanvo.account.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhanvo.account.model.Role;
import com.nhanvo.account.model.User;
import com.nhanvo.account.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleService.getRoleById((long)1));
        user.setRoles(roles);
        userRepository.save(user);
    }
    
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
