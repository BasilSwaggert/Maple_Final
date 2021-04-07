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

import com.caseStudy.spring.entities.Tickets;
import com.caseStudy.spring.entities.Users;
import com.caseStudy.spring.services.CategoryService;
import com.caseStudy.spring.services.TicketsService;
import com.caseStudy.spring.services.UsersService;


@Controller
@RequestMapping(value = "tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "send", method = RequestMethod.GET)
    public String send(ModelMap modelMap) {
        Tickets tickets = new Tickets();
        modelMap.put("tickets", tickets);
        modelMap.put("category", categoryService.findAll());
        return "tickets.send";
    }

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

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String history(Authentication authentication, ModelMap modelMap) {
        modelMap.put("tickets", ticketsService.findTicketsByUsername(authentication.getName()));
        return "tickets.history";
    }
    
    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.put("tickets", ticketsService.find(id));
        return "tickets.details";
    } 
}