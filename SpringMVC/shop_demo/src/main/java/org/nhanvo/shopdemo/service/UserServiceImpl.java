package org.nhanvo.shopdemo.service;

import java.util.List;
import java.util.Optional;

import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.model.UserCreateForm;
import org.nhanvo.shopdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.findAll();
    }

    /**
     * Override from parent
     */
    @Override
    public User create(UserCreateForm userform) {
        User user = new User();
        user.setEmail(userform.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(userform.getPassword()));
        user.setRole(userform.getRole());
        user.setUsername(userform.getUsername());  
        return userRepository.save(user);
    }
    
    @Override
    public User update(Long id, UserCreateForm userform) {
    	User user = userRepository.findOne(id);
        user.setEmail(userform.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(userform.getPassword()));
        user.setRole(userform.getRole());
        user.setUsername(userform.getUsername()); 
    	return userRepository.save(user);
    }
    
    @Override
    public void delete(Long id) {
    	User user = userRepository.findOne(id);
    	userRepository.delete(user);
    }
    
    /**
     * Check User is exist
     */
	public boolean isUserExist(String username) {
		List<User> users = userRepository.findAll();
		for(User u : users){
			if(u.getUsername().equalsIgnoreCase(username)){
				return true;
			}
		}
		return false;
	}
    
}
