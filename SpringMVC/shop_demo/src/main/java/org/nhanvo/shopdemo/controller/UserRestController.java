package org.nhanvo.shopdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.model.UserCreateForm;
import org.nhanvo.shopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserRestController {

	// User service
	private final UserService userService;

	/**
	 * Constructor
	 * 
	 * @param userService
	 */
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/userlist/", method = RequestMethod.GET)
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
	
	/**
	 * Create user
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/user/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserCreateForm user, UriComponentsBuilder ucBuilder) { 
        if (userService.isUserExist(user.getUsername())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.create(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	/**
	 * Update a User
	 * @param id
	 * @param user
	 * @return
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserCreateForm> updateUser(@PathVariable("id") long id, @RequestBody UserCreateForm user) {
         
        if (user==null) {
            return new ResponseEntity<UserCreateForm>(HttpStatus.NOT_FOUND);
        }
         
        userService.update(id, user);
        return new ResponseEntity<UserCreateForm>(user, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserCreateForm> deleteUser(@PathVariable("id") Long id) {
        
        userService.delete(id);
        return new ResponseEntity<UserCreateForm>(HttpStatus.NO_CONTENT);
    }
 
}
