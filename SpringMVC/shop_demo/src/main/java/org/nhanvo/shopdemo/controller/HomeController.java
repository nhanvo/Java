package org.nhanvo.shopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author nhanvo Home controller class
 */
@Controller
public class HomeController {
	/**
	 * Mapping to http://localhost:8080/
	 * 
	 * @return Home page
	 */
	@RequestMapping("/")
	public String getHomePage() {
		return "home";
	}

	@RequestMapping(value = "/userinformation", method = RequestMethod.GET)
	public String getIndexPage() {
		return "UserInformation";
	}

}
