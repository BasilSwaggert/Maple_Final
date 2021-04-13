package com.caseStudy.spring.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caseStudy.spring.entities.Category;
import com.caseStudy.spring.entities.Status;
import com.caseStudy.spring.entities.Tickets;
import com.caseStudy.spring.entities.Users;
import com.caseStudy.spring.services.CategoryService;
import com.caseStudy.spring.services.TicketsService;
import com.caseStudy.spring.services.UsersService;

//Class controls the ticket submission proccess
@Controller
@RequestMapping(value = "tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private UsersService usersService;

    //Method controls the viewing and layout of the ticket submission page
    @RequestMapping(value = "send", method = RequestMethod.GET)
    public String send(ModelMap modelMap) {
        Tickets tickets = new Tickets();
        modelMap.put("tickets", tickets);
        modelMap.put("category", categoryService.findAll());
        return "tickets.send";
    }

    //Method add the ticket to the program and to the database
    @RequestMapping(value = "send", method = RequestMethod.POST)
    public String send(@ModelAttribute("tickets") Tickets tickets,
                       Authentication authentication, RedirectAttributes redirectAttributes) {
        try {
        	Users users = usersService.findByUsername(authentication.getName());
            tickets.setCreatedDate(new Date());
            tickets.setAccountByUserId(users);
            ticketsService.save(tickets);
            redirectAttributes.addFlashAttribute("success", "Sent Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("err", "Send Failed");
        }
        return "redirect:/tickets/send";
    }

    //Pulls up all submitted tickets indexed to the userId
    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String history(Authentication authentication, ModelMap modelMap) {
        modelMap.put("tickets", ticketsService.findTicketsByUsername(authentication.getName()));
        return "tickets.history";
    }
    
  //Controls how to edit a ticket
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
    	Tickets tickets = ticketsService.find(id);
        modelMap.put("tickets", tickets);
        tickets.setId(id);
        modelMap.put("category", categoryService.findAll());
        return "tickets.edit";
    }
    
    //Edits the category in the program and database
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("tickets") Tickets tickets, ModelMap modelMap) {
    	try {
    		ticketsService.save(tickets);
            return "redirect:/tickets/history";
    	} catch (Exception e) {
    		modelMap.put("err", "Ticket Update Failed");
    		modelMap.put("tickets", tickets);
    		return "tickets.edit";
    	}
    }
    
  //Controls the deletion of the user
    @RequestMapping(value = "complete/{id}", method = RequestMethod.GET)
    public String complete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
        	ticketsService.delete(id);
        	redirectAttributes.addFlashAttribute("success", "Completed Successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("err", "Deletion Failed");
        }
        return "redirect:/tickets/history";
    }
    
    //Pulls up the details and layout of the ticket
    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.put("tickets", ticketsService.find(id));
        return "tickets.details";
    } 
}