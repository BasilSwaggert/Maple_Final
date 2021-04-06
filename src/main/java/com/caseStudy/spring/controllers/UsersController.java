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

@Controller
@RequestMapping(value = "users")
public class UsersController {

	@Autowired
    private UsersService usersService;

    //Authentication used here may be incorrect
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Authentication authentication, ModelMap modelMap) {
        modelMap.put("users", usersService.findByUsername(authentication.getName()));
        return "users.profile";
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String profile(@ModelAttribute("users") Users account) {
        Users currentAccount = usersService.findByUsername(account.getUsername());
        if (!account.getPassword().isEmpty()) {
            currentAccount.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        }
        currentAccount.setEmail(account.getEmail());
        currentAccount.setFullName(account.getFullName());
        usersService.save(currentAccount);
        return "redirect:/users/profile";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	Users account = new Users();
        modelMap.put("users", account);
        return "users.add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("users") Users account, ModelMap modelMap) {
        try {
            account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
            usersService.save(account);
            return "redirect:/account";
        } catch (Exception e) {
            modelMap.put("error", "Creation Failed");
            return "users.add";

        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
        	usersService.delete(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Deletion Failed");
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        Users account = usersService.find(id);
        modelMap.put("users", account);
        return "users.edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("users") Users account, ModelMap modelMap) {
        try {
            if (account.getPassword().isEmpty()) {
                account.setPassword(usersService.find(account.getId()).getPassword());
            } else {
                account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
            }
            usersService.save(account);
            return "redirect:/users";
        } catch (Exception e) {
            modelMap.put("error", "Update Failed");
            modelMap.put("users", account);
            return "users.edit";
        }
    }
}