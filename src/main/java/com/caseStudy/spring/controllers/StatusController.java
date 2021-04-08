package com.caseStudy.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caseStudy.spring.entities.Status;
import com.caseStudy.spring.services.StatusService;

//This class controls the functionality of adding, editing, viewing, and deleting statuses. All but viewing are accessible only to the admin role.
@Controller
@RequestMapping(value = "status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	//Controls the viewing and layout
    @RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("statuses", statusService.findAll());
        return "status.index";
    }
    
    //Method controls how to add a status
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	Status status = new Status();
    	status.setDisplay(true);
        modelMap.put("status", status);
        return "status.add";
    }
    
    //Method add the new status to the program and database
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("status") Status status, ModelMap modelMap) {
    	try {
    		statusService.save(status);
            return "redirect:/status";
    	} catch (Exception e) {
    		modelMap.put("err", "Status Add Failed");
    		return "status.add";
    	}
    }
    
    //Method controls how to edit a status
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
    	Status status = statusService.find(id);
        modelMap.put("status", status);
        return "status.edit";
    }
    
    //Method edits the status in the program and database
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("status") Status status, ModelMap modelMap) {
    	try {
    		statusService.save(status);
            return "redirect:/status";
    	} catch (Exception e) {
    		modelMap.put("err", "Status Update Failed");
    		modelMap.put("category", status);
    		return "status.edit";
    	}
    }
    
    //Method controls the deletion of a status in the program and database
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
    	try {
    		statusService.delete(id);
    	} catch (Exception e) {
    		redirectAttributes.addFlashAttribute("err", "Status Deletion Failed");
    	}
        return "redirect:/status";
    }
}