package com.caseStudy.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caseStudy.spring.entities.Category;
import com.caseStudy.spring.services.CategoryService;

//This class controls the functionality of adding, editing, viewing, and deleting categories. All but viewing are accessible only to the admin role.
@Controller
@RequestMapping(value = "category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Controls the viewing and layout
    @RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("categories", categoryService.findAll());
        return "category.index";
    }
    
    //Controls how to add a category
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	Category category = new Category();
    	category.setStatus(true);
        modelMap.put("category", category);
        return "category.add";
    }
    
    //Adds the category to the program and database
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("category") Category category, ModelMap modelMap) {
    	try {
    		categoryService.save(category);
            return "redirect:/category";
    	} catch (Exception e) {
    		modelMap.put("err", "Category Add Failed");
    		return "category.add";
    	}
    }
    
    //Controls how to edit a category
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
    	Category category = categoryService.find(id);
        modelMap.put("category", category);
        return "category.edit";
    }
    
    //Edits the category in the program and database
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("category") Category category, ModelMap modelMap) {
    	try {
    		categoryService.save(category);
            return "redirect:/category";
    	} catch (Exception e) {
    		modelMap.put("err", "Category Update Failed");
    		modelMap.put("category", category);
    		return "category.edit";
    	}
    }
    
    //Controls the deletion of a category in the program and database
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
    	try {
    		categoryService.delete(id);
    	} catch (Exception e) {
    		redirectAttributes.addFlashAttribute("err", "Category Deletion Failed");
    	}
        return "redirect:/category";
    }
}