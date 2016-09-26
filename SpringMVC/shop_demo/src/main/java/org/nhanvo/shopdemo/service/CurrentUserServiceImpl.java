package org.nhanvo.shopdemo.service;

import org.nhanvo.shopdemo.model.CurrentUser;
import org.nhanvo.shopdemo.model.Role;
import org.springframework.stereotype.Service;

/**
 * Current user service implement class
 * @author nhanvo
 *
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    /**
     * Override from parent
     */
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
