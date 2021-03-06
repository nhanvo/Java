package org.nhanvo.shopdemo.controller;

import org.nhanvo.shopdemo.model.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * 
 * @author nhanvo
 * Current user controller
 */
@ControllerAdvice
public class CurrentUserControllerAdvice {

	/**
     * Define current user model
     * @param authentication User authentication
     * @return Null or principal
     */
    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }
}
