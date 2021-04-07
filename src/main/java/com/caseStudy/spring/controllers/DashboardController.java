package com.caseStudy.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "dashboard")
public class DashboardController {

    @RequestMapping(value = { "",  "index" }, method = RequestMethod.GET)
    public String index() {
        return "dashboard.index";
    }
}
