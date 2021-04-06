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

@Controller
@RequestMapping(value = "status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
    @RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("statuses", statusService.findAll());
        return "status.index";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	Status status = new Status();
    	status.setDisplay(true);
        modelMap.put("status", status);
        return "status.add";
    }
    
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
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
    	Status status = statusService.find(id);
        modelMap.put("status", status);
        return "status.add";
    }
    
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