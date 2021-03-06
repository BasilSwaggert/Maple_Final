package com.caseStudy.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caseStudy.spring.entities.Users;
import com.caseStudy.spring.services.UsersService;

//This class controls the viewing of, adding, editing, and deletion of users. All but viewing your own profile is only available to the admin role.
@Controller
@RequestMapping(value = "users")
public class UsersController {

	@Autowired
    private UsersService usersService;
	
	//Controls the view of the users page
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("users", usersService.findAll());
        return "users.index";
    }

	//Controls the view of the profile page and fields
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Authentication authentication, ModelMap modelMap) {
        modelMap.put("users", usersService.findByUsername(authentication.getName()));
        return "users.profile";
    }

    //Pulls the data for the profile from the database
    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String profile(@ModelAttribute("users") Users users, RedirectAttributes redirectAttributes) {
        Users currentusers = usersService.findByUsername(users.getUsername());
        if (!users.getPassword().isEmpty()) {
            currentusers.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        }
        currentusers.setEmail(users.getEmail());
        currentusers.setFullName(users.getFullName());
        usersService.save(currentusers);
        redirectAttributes.addFlashAttribute("success", "Updated Successfully");
        return "redirect:/users/profile";
    }

    //Controls how details are added to the user
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	Users users = new Users();
        modelMap.put("users", users);
        return "users.add";
    }
    
    //Adds details input by the user to the program and database
    	//If else for validation
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("users") Users users, ModelMap modelMap) {
        try {
            users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
            usersService.save(users);
            return "redirect:/users";
        } catch (Exception e) {
            modelMap.put("error", "Creation Failed");
            return "users.add";

        }
    }
    
    //Controls how details are edited in the user
    	//May be passing in empty string
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        Users users = usersService.find(id);
        modelMap.put("users", users);
        return "users.edit";
    }
    
    //Edits the details of the user and makes the changes in the program and database
    	//If else for validation
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("users") Users users, ModelMap modelMap) {
        try {
            if (users.getPassword().isEmpty()) {
                users.setPassword(usersService.find(users.getId()).getPassword());
            } else {
                users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
            }
            usersService.save(users);
            return "redirect:/users";
        } catch (Exception e) {
            modelMap.put("err", "Update Failed");
            modelMap.put("users", users);
            return "users.edit";
        }
    }
    
    //Controls the deletion of the user
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
        	usersService.delete(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("err", "Deletion Failed");
        }
        return "redirect:/users";
    }
}