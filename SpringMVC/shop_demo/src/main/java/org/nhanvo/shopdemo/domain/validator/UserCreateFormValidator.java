package org.nhanvo.shopdemo.domain.validator;

import org.nhanvo.shopdemo.model.UserCreateForm;
import org.nhanvo.shopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author nhanvo
 * User create form validator class
 */
@Component
public class UserCreateFormValidator implements Validator {

	// User service
    private final UserService userService;

    /**
     * Constructor
     * @param userService User service
     */
    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    /**
     * Override from parent
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }
    
    /**
     * Override from parent
     */
    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    /**
     * Validate password
     * @param errors Error
     * @param form User create form
     */
    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    /**
     * Validate email
     * @param errors Error
     * @param form User create form
     */
    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
