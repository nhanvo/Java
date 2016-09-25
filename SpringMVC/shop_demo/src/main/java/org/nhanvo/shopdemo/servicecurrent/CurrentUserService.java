package org.nhanvo.shopdemo.servicecurrent;

import org.nhanvo.shopdemo.model.CurrentUser;

/**
 * 
 * @author nhanvo
 * Current user service interface
 *
 */
public interface CurrentUserService {
	/**
	 * Can access user
	 * @param currentUser Current user
	 * @param userId Id of user
	 * @return
	 */
    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
