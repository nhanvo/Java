package com.nhanvo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhanvo.model.UserEntity;
import com.nhanvo.repository.UserRepository;

import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String getUsers() {
		
		List<UserEntity> userList = userRepository.findAll();
		if (userList.size() == 0) {
			System.err.println("Error");
		}
		return "admin/users";
	}
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public String addUser() {
		return "admin/addUser";
	}
	
	@RequestMapping(value = "/admin/userDetail", method = RequestMethod.GET)
	public String showUser() {
		return "admin/userDetail";
	}
	
	@RequestMapping(value = "/admin/updateUser", method = RequestMethod.GET)
	public String updateUser() {
		return "admin/updateUser";
	}
	
	
	public String deleteUser () {
		return "";
	}
}
