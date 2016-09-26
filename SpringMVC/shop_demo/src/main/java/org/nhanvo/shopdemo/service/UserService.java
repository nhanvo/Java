package org.nhanvo.shopdemo.service;

import java.util.List;
import java.util.Optional;

import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.model.UserCreateForm;

/**
 * 
 * @author nhanvo
 * User service interface
 *
 */
public interface UserService {
	/**
	 * Get user by Id
	 * @param id Id of user
	 * @return User founded
	 */
    Optional<User> getUserById(long id);

    /**
     * Get user by email
     * @param email Email of user
     * @return User founded
     */
    Optional<User> getUserByEmail(String email);

    /**
     *  Get all users
     * @return List all users
     */
    List<User> getAllUsers();

    /**
     * Create new user
     * @param form User create form
     * @return User created
     */
    User create(UserCreateForm userform);
    
    /**
     * Update user
     * @param userform
     * @return
     */
    public User update(Long id, UserCreateForm userform);
    
    /**
     * Delete user
     * @param id
     * @return
     */
    public void delete(Long id);
    
    /**
     * Check user is exist
     */
	public boolean isUserExist(String username);

}
