package org.nhanvo.shopdemo.service;

import java.util.List;
import java.util.Optional;

import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.model.UserCreateForm;
import org.nhanvo.shopdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 
 * @author nhanvo
 * User service implement class
 *
 */
@Service
public class UserServiceImpl implements UserService {

	// User Repository
    private final UserRepository userRepository;

    /**
     * Constructor
     * @param userRepository User repository
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Override from parent
     */
    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    /**
     * Override from parent
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    /**
     * Override from parent
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    /**
     * Override from parent
     */
    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        user.setUsername(form.getUsername());  
        return userRepository.save(user);
    }
    
}
