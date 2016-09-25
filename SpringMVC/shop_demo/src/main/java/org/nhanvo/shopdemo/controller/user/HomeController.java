package org.nhanvo.shopdemo.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author nhanvo
 * Home controller class
 */
@Controller
public class HomeController {
	/**
     * Mapping to http://localhost:8080/
     * @return Home page
     */
    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }

}
