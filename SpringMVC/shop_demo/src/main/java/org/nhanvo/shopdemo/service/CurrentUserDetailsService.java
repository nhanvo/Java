package org.nhanvo.shopdemo.service;

import org.nhanvo.shopdemo.model.CurrentUser;
import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author nhanvo
 * Current User detail service class
 *
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

	// User service
    private final UserService userService;

    /**
     * Constructor
     * @param userService
     */
    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Override from parent
     */
    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}
