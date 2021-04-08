package com.caseStudy.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Class controls access to the dashboard
@Controller
@RequestMapping(value = "dashboard")
public class DashboardController {

	//Controls the view and mapping of the dashboard
    @RequestMapping(value = { "",  "index" }, method = RequestMethod.GET)
    public String index() {
        return "dashboard.index";
    }
}
