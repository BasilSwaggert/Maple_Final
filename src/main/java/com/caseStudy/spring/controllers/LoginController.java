package com.caseStudy.spring.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//This class controls the login/logout functionality of the program
@Controller
@RequestMapping(value = { "", "login-panel" })
public class LoginController {
	
	//Method controls the view of the login screen	
    @RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
    public String index() {
        return "redirect:/login-panel/login";
    }
    
    //Method controls issues such as incorrect credentials at login and redirection
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            ModelMap modelMap) {
        if (error != null) {
            modelMap.put("msg", "Invalid username or password");
        }
        if (logout != null) {
            modelMap.put("msg", "Logout successfully");
        }
        return "login.index";
    }

    //Method controls logout functionality of the of the program
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/login-panel/login?logout";
    }

    //Method controls access authentication and the error recieved upon being denied access
    @RequestMapping(value = "accessDenied", method = RequestMethod.GET)
    public String accessDenied(Authentication authentication, ModelMap modelMap) {
        if (authentication != null) {
            modelMap.put("msg", "Hi " + authentication.getName() + ", you do not have permission to access this page!");
        } else {
            modelMap.put("msg", "You do not have permission to access this page!");
        }
        return "login.accessDenied";
    }

    //Method controls successful login and redirects to the dashboard
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
    	return "redirect:/dashboard";
    }
}