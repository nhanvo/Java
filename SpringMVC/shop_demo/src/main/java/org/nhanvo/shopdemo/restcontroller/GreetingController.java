package org.nhanvo.shopdemo.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.model.UserCreateForm;
import org.nhanvo.shopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	// User service
	private final UserService userService;

	/**
	 * Constructor
	 * 
	 * @param userService
	 */
	@Autowired
	public GreetingController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public ResponseEntity<List<UserCreateForm>> getAllUser() {
		List<UserCreateForm> userforms = new ArrayList<UserCreateForm>();
		List<User> users = userService.getAllUsers();
		ListIterator<User> itr = users.listIterator();
		while (itr.hasNext()) {
			User user = itr.next();
			UserCreateForm userform = new UserCreateForm(user.getId(), user.getEmail(), user.getRole(), user.getUsername());
			userforms.add(userform);
		}
		return new ResponseEntity<List<UserCreateForm>>(userforms, HttpStatus.OK) ;
	}
	
	
}
